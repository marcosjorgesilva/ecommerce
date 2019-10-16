package dbUnit;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import org.dbunit.database.*;
import org.dbunit.dataset.*;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.Base64.InputStream;

public class DbUnitProvider {

	public void execute(DatabaseOperation operation, String xml){
		// Definindo JDBC driver e a URL do banco
		String JDBC_DRIVER = "org.h2.Driver";   
		String DB_URL = "jdbc:h2:mem:testdb";  
		   
		//  Definindo as credenciais do banco
		String USER = "sa"; 
		String PASS = ""; 
		
		try {
		// Criando a nova instancia e Definindo a conexão com a base
		Class.forName(JDBC_DRIVER).newInstance();
		Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		// Imputando as informações de conexão para a classe de conexão do DbUnit
		IDatabaseConnection iConn = new DatabaseConnection(conn);
		// Lendo os dados do xml
					
		InputStream stream = (InputStream) getClass().getResourceAsStream(xml);
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		JOptionPane.showInputDialog(stream, "ok");
		IDataSet dataSet = builder.build(stream);
		
		operation.execute(iConn, dataSet);
		
		iConn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}