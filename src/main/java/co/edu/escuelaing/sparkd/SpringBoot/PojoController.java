package co.edu.escuelaing.sparkd.SpringBoot;

public class PojoController {

    @RequestMapping("/hola")
    static public String hola() {
        return "Greetings from Micro Spring Boot!";
    }

}
