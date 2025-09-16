package com.cursogetafe.dixml.negocio;

import com.cursogetafe.dixml.persistencia.ClienteDao;

public class NegocioImpl implements Negocio{
	
	private ClienteDao cDao;
	
	public NegocioImpl() {
		System.out.println("Constructor por defecto del NegocioImpl");
	}
	
	public NegocioImpl(ClienteDao cDao) {
		this.cDao = cDao;
		System.out.println("Constructor por defecto del NegocioImpl(ClienteDao)");
	}
	
	
	
	@Override
	public String proceso(int idCliente) {
		return "Soy el negocio y llamo al Dao: " + cDao.findById(idCliente);
	}

	public ClienteDao getcDao() {
		return cDao;
	}

	public void setcDao(ClienteDao cDao) {
		System.out.println("NegocioImpl, setDao(...)");
		this.cDao = cDao;
	}

}
