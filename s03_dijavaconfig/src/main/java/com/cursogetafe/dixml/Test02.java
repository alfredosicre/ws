package com.cursogetafe.dixml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cursogetafe.dixml.config.A02Config;

public class Test02 {
	public static void main(String[] args) {
		BeanFactory ctx = new AnnotationConfigApplicationContext(A02Config.class);
		
	}
}
