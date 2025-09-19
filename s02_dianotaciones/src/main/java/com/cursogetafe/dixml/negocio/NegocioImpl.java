package com.cursogetafe.dixml.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursogetafe.dixml.persistencia.ClienteDao;

@Service("negocio")
public class NegocioImpl implements Negocio {

	@Autowired
	private ClienteDao cDao;
	
	public NegocioImpl() {
		System.out.println("Constructor por defecto del NegocioImpl");
	}
	
//	@Autowired
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

//	@Autowired
	public void setcDao(ClienteDao cDao) {
		System.out.println("NegocioImpl, setcDao(...)");
		this.cDao = cDao;
	}

	
}
