package com.coderteca.phone.controllers;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Route;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

/**
 * @author Narvaez Ruiz Alexis
 *         Index
 */
public class Index {

	public static Route index = (request, response) -> {
		HashMap<String,Object> map = new HashMap<String,Object>();

		return new ThymeleafTemplateEngine()
				.render(
						new ModelAndView(map, "index"));
	};

}
