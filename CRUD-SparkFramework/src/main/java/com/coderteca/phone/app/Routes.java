package com.coderteca.phone.app;

import static spark.Spark.*;

import com.coderteca.phone.controllers.Index;
import com.coderteca.phone.controllers.PhonesController;

/**
 * @author Narvaez Ruzi Alexis
 *         Routes
 */
public final class Routes {

	/**
	 * Inicia las ritas del servidor
	 */
	public static void initRoutes() {
		get("/", Index.index);

		path("/phones", () -> {
			//Get
			get("", PhonesController.index);
			get("/new", PhonesController.add);
			get("/:id", PhonesController.show);
			//Post
			post("/create",PhonesController.store);	
			put("/:id/store", PhonesController.update);
			delete("/:id", PhonesController.delete);
		});
	}
}
