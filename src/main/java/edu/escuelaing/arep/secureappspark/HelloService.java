package edu.escuelaing.arep.secureappspark;

import static spark.Spark.*;

public class HelloService{
    String paswdunico = "456789";
    public static void main(String... args){
          port(getPort());
          secure("keystores/ecikeystore.p12", "arepeci", null, null);
          get("/hello", (req,res) -> "Hello World!");
          //get("/login", (req,res) -> sc.validate(usr,createHash(passwd)));
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
}
