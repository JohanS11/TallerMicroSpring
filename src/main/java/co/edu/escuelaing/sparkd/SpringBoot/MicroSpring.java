package co.edu.escuelaing.sparkd.SpringBoot;


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MicroSpring {
    private Map<String, Method> beans = new HashMap<>();
    public void start(String[] args) throws Exception {
        int mapped = 0;
        for (Method m : Class.forName(args[0]).getMethods()) {
            if (m.isAnnotationPresent(RequestMapping.class)) {
                try {
                    beans.put(m.getAnnotation(RequestMapping.class).value(),m);
                    mapped++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                }}}
    }

    public String invoke(String path){
        try{
            return beans.get(path).invoke(null).toString();
        } catch (Exception ex) {
            Logger.getLogger(MicroSpringBoot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error";
    }
}

