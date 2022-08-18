package com.coderteca.phone.app;

import static spark.Spark.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

import jakarta.persistence.Persistence;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

/**
 * @author Narvaez Ruiz Alexis
 *         Serve
 */
public class Serve {
	/**
	 * Inicia el servidor
	 */
	public static void run() {

		System.out.println("Static files");
		staticFiles.location("/public");

		System.out.println("Init Serve");

		port(8080);
		initExceptionHandler((e) -> System.out.println("Uh-oh"));
		init();

		System.out.println("Init routes of Serve");
		Routes.initRoutes();

		System.out.println("Init JPA");
		Persistence.createEntityManagerFactory("phones").createEntityManager();

		exception(Exception.class, (e, request, response) -> {
			var result = Arrays.stream(e.getStackTrace()).map(x -> {
				return "<div>" + x.toString() + "</div>";
			}).reduce((v, a) -> v += a).get();
			result = "<div>" + e.getMessage() + "</div>" + result;
			response.body(result);
		});

	}
}
