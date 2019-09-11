package com.marcosjorge.projetojweb.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class CategoriaTest {

	@Test
	public void test() {
		
		Categoria cat1 = new Categoria(1,"Feminino");
		Categoria cat2 = new Categoria(2,"Masculino");
		
		List <Categoria> lista = new ArrayList<Categoria>();
		lista.add(cat1);
		lista.add(cat2);
		
		Assert.assertEquals(cat1.getNome(), cat2.getNome());
		
		}
}
