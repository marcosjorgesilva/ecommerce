package com.marcosjorge.projetojweb.resources;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.marcosjorge.projetojweb.services.CategoriaService;

public class CategoriaResourceTest {

	@Test
	public void testeCategoriaResource() {
		CategoriaService cs = new CategoriaService();
		Assert.assertThat(cs.find(1),CoreMatchers.is("Feminino"));
	}

}
 