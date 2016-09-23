package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Usuario;
import com.ipartek.formacion.service.interfaces.UsuarioService;

@Controller
@RequestMapping(value="/usuarios")
public class UsuariosController {
	@Autowired
	private UsuarioService us = null;
	private ModelAndView mav = null;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll(){
		mav = new ModelAndView("/usuarios/listado"); //indicamos la vista
		List<Usuario> usuarios = us.getAll();
		
		mav.addObject("listado-usuarios",usuarios); //metemos el objeto en la respuesta
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView getById(@PathVariable ("id") int id){
		mav = new ModelAndView("usuarios/usuario");
		Usuario usuario = us.getById(id);
		
		mav.addObject("usuario",usuario);
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public String delete(@PathVariable ("id") int id){ //el método devuelve un String xq en el return vamos a devolver la ruta para volver al listado de usuarios
		String destino = "redirect:/usuarios";
		
		mav = new ModelAndView("usuarios/listado");
		us.delete(id);
		
		
		return destino;
		
	}
	
	
	
	
}
