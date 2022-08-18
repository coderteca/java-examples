package com.coderteca.phone.controllers;

import java.util.*;

import com.coderteca.phone.models.PhoneModel;
import com.coderteca.phone.models.config.Model;

import spark.ModelAndView;
import spark.Route;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

/**
 * PhonesController
 */
public class PhonesController {

	/**
	 * Muestra la pantalla principal
	 */
	public static Route index = (request, response) -> {
		HashMap<String, Object> values = new HashMap<String, Object>();
		values.put("host", "http://localhost:8080");

		List<PhoneModel> phones = Model.findAll(PhoneModel.class.getSimpleName());
		values.put("phones", phones);

		// Retornamos una vista
		return new ThymeleafTemplateEngine().render(
				new ModelAndView(values, "phones/home"));
	};

	/**
	 * Muestra el formulario principal para Agregar un nuevo registro
	 */
	public static Route add = (request, response) -> {
		HashMap<String, Object> values = new HashMap<String, Object>();
		values.put("host", "http://localhost:8080");
		return new ThymeleafTemplateEngine().render(
				new ModelAndView(values, "phones/add"));
	};

	/**
	 * Guarda un registro en la base datos
	 */
	public static Route store = (request, response) -> {
		// Obtenemos los valores enviados por el formulario
		String id = request.queryParams("id");
		String marca = request.queryParams("marca");
		String modelo = request.queryParams("modelo");
		String memoria = request.queryParams("memoria_interna");

		PhoneModel phone = new PhoneModel(id, marca, modelo, Float.parseFloat(memoria));
		Model.save(phone);
		/* try { */
		/* Model.save(phone); */
		/* } catch (Exception e) { */
		/* return "Error"; */
		/* } */
		response.redirect("/phones");
		return null;
		// return "id: "+Integer.parseInt(id)+" marca: "+ marca;
	};

	/**
	 * Muestra la pantalla de edicion del registro seleccionado
	 */
	public static Route edit = (request, response) -> {
		return null;
	};

	/**
	 * Actualiza un registro en la base de datos
	 */
	public static Route update = (request, response) -> {
		return null;

	};
	/**
	 * Muestra un registro de la base de datos
	 */
	public static Route show = (request, response) -> {
		return request.params("id");

	};
	/**
	 * Borra un registro de la base de datos
	 */
	public static Route delete = (request, response) -> {
		PhoneModel phone = (PhoneModel) Model.findByAttribute(PhoneModel.class.getSimpleName(), "id",
				request.params("id")).get(0);
		Model.delete(phone);
		return "[{ \"status\":\"deleted\", \"phone\": \""+phone+"\"}]";
	};

}
