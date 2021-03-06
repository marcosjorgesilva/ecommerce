package com.marcosjorge.projetojweb.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.marcosjorge.projetojweb.domain.Cliente;
import com.marcosjorge.projetojweb.domain.enums.TipoCliente;
import com.marcosjorge.projetojweb.dto.ClienteNewDTO;
import com.marcosjorge.projetojweb.repositories.RepoCliente;
import com.marcosjorge.projetojweb.resources.exception.FieldMessage;
import com.marcosjorge.projetojweb.services.validation.utils.CpfCnpjUtils;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private RepoCliente repo;
	
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !CpfCnpjUtils.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj","CPF invalido!"));
		}
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !CpfCnpjUtils.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj","CNPJ invalido!"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
				
		if(aux != null) {
			list.add(new FieldMessage("Email","Email já existente!"));
		}
		
		// inclua os testes aqui, inserindo erros na lista
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
