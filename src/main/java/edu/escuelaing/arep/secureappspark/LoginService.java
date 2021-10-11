package edu.escuelaing.arep.secureappspark;

import static spark.Spark.*;
/**
 * Inicia el proceso de login con un usuario y contraseña
 * @author Daniel Santiago Ducuara Ardila
 *
 */
public class LoginService{
    public static void main(String... args){
          port(getPort());
          secure("keystores/ecikeystore.p12", "arepeci", null, null);
          get("/hello", (req,res) -> "Hello World!");
          get("/hello", (req,res) -> "Welcome login");
          URLReader.startSecureLogin();
          get("/loginUser", (request,response) -> URLReader.readURL(request.queryParams("user"),request.queryParams("passwd")));
    }
    /**
     * elige el puerto
     * @return port
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
}
