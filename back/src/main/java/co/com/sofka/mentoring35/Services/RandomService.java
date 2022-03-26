package co.com.sofka.mentoring35.Services;

import java.text.SimpleDateFormat;
import java.util.*;

public class RandomService {

    /*public static String getStringRandomTime(Long CantidadHoras){

        //Rellenamos con numeros aleatorios
        List<String> listaRandom = new ArrayList<String>();
        for (int i=0; i<CantidadHoras; i++){
            listaRandom.add(getRandomTime());
        }

        //De Lista hacia String
        final String SEPARADOR = ",";
        StringBuilder cadena = new StringBuilder("");
        for (String s : listaRandom) {
            cadena.append(s);
            cadena.append(SEPARADOR);
        }
        //cadena = cadena.substring(0,cadena.length() - SEPARADOR.length());

        //Convertimos en una cadena sola
        String randomString = cadena.substring(0,cadena.length() - SEPARADOR.length());

        return randomString.toString();
    }*/

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
