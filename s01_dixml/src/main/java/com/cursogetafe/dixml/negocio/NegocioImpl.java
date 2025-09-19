package com.cursogetafe.dixml.negocio;

import com.cursogetafe.dixml.persistencia.ClienteDao;

public class NegocioImpl implements Negocio {

	private ClienteDao cDao;
	
	public NegocioImpl() {
		cDao = null;
		System.out.println("Constructor por defecto del NegocioImpl");
	}
	
	
	public NegocioImpl(ClienteDao cDao) {
		this.cDao = cDao;
		System.out.println("Constructor de NegocioImpl(ClienteDao)");
	}

	@Override
	public String proceso(int idCliente) {
		return "Soy el negocio y llamo al dao: " + cDao.findById(idCliente);
	}

	public ClienteDao getcDao() {
		return cDao;
	}

	public void setcDao(ClienteDao cDao) {
		System.out.println("NegocioImpl, setcDao(...)");
		this.cDao = cDao;
	}

	
}
