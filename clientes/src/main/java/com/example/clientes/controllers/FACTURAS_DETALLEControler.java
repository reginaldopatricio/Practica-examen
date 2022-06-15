package com.example.clientes.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.clientes.model.FacturasDetalle;
import com.example.clientes.repository.FacturasDetalleRepository;

@CrossOrigin(origins = "http://localhost:8081")
@Controller
@RequestMapping(path = "practica")
public class FACTURAS_DETALLEControler {

	@Autowired
	FacturasDetalleRepository facturasDetalleRepository;

	@GetMapping(path = "deletedetalle")
	public String delete (Model model,@RequestParam long idDetalleFacturas){

		Optional<FacturasDetalle> facturasDetalleOptional = facturasDetalleRepository.findById(idDetalleFacturas);
		if (facturasDetalleOptional.isPresent()) {
			facturasDetalleRepository.deleteById(idDetalleFacturas);;
			return "redirect:/practica/updateFacturas?idFacturas=" + facturasDetalleOptional.get().getFacturas().getId();
		}

		return "error";
	}

	@GetMapping(path = "updateFacturasDetalle")
	public String updateFacturas (Model model, @RequestParam long idFacturasDetalle){
		model.addAttribute("update", true);
		model.addAttribute("intupdate", 0);
		Optional<FacturasDetalle> facturasDetalle = facturasDetalleRepository.findById(idFacturasDetalle);
		if (facturasDetalle.isPresent()) {
				model.addAttribute("tutorialDetalle",facturasDetalle.get() );
		}
		return "updateDetalleFacturas";
	}


}
