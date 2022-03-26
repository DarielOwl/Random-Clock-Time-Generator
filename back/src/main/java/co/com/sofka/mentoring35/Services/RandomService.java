package co.com.sofka.mentoring35.Services;

import java.text.SimpleDateFormat;
import java.util.*;

public class RandomService {

    public String getRandomTime() {
        Random rand = new Random();

        //Instanciamos la fecha
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Calendar cal = Calendar.getInstance();

        //Setiamos el rango de fecha
        cal.set(2000, 0, 1);
        long start = cal.getTimeInMillis();

        cal.set(2022, 10, 1);
        long end = cal.getTimeInMillis();

        //Hacemos la formula de numeros aleatorios pero con fecha
        Date d = new Date(start + (long) (rand.nextDouble() * (end - start)));
        //System.out.println(format.format(d));

        //Convertimos a String
        String RandomDate = format.format(d);

        return RandomDate;
    }

}
