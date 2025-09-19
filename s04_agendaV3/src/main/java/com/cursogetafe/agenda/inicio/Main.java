package com.cursogetafe.agenda.inicio;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cursogetafe.agenda.config.Config;

public class Main {
	public static void main(String[] args) {
		
		new AnnotationConfigApplicationContext(Config.class);
	}
}
