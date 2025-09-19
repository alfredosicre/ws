  package com.cursogetafe.dixml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cursogetafe.dixml.negocio.Negocio;

public class Tes03 {
	
	public static void main(String[] args) {
		
		BeanFactory ctx = new ClassPathXmlApplicationContext("a02_ctx.xml");
		
		Negocio neg = ctx.getBean("negocio", Negocio.class);
		System.out.println(neg.proceso(78));
	}

}
