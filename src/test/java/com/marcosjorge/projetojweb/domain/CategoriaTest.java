package com.marcosjorge.projetojweb.domain;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;


public class CategoriaTest {

	@Test
	public void testCategoria() {
		
		Categoria cat1 = new Categoria(1,"Feminino");
		Categoria cat2 = new Categoria(2,"Masculino");
		
		List <Categoria> lista = new ArrayList<Categoria>();
		lista.add(cat1);
		lista.add(cat2);
		
		Assert.assertThat(cat1.getNome(), CoreMatchers.is("Femiino"));
		
		Assert.assertEquals(cat1.getNome(), cat1.getNome());
		
		}
}
