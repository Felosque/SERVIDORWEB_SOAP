package constantes;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilitiesFunctions {
    
    public static final int EDAD_MINIMA_REGISTRO = 5;

    private UtilitiesFunctions(){
        
    }
    
    //Verifica si la cadena es un numero
    public static boolean esNumerico(String value){
        boolean ret = false;
        if (!value.isEmpty()) {
            ret = value.matches("^[0-9]+$");
        }
        return ret;
    }
    
    //Genera un arreglo de int dando el Día, Mes, Año de un Date dado por parametro
    public static int[] darDiaMesAno(Date pDate)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(pDate);
        int[] diaMesAno = new int[3];
        diaMesAno[0] = cal.get(Calendar.DAY_OF_MONTH);
        diaMesAno[1] = cal.get(Calendar.MONTH);
        diaMesAno[2] = cal.get(Calendar.YEAR);
        return diaMesAno;
    }
    
    public static String darDiaMesAnoToString(Date pDate){
        
        int[] diaMesAnoInt = darDiaMesAno(pDate);
        String[] diaMesAno = new String[3];
        diaMesAno[0] = Integer.toString(diaMesAnoInt[0]);
        diaMesAno[1] = Integer.toString(diaMesAnoInt[1]);
        diaMesAno[2] = Integer.toString(diaMesAnoInt[2]);
        if(diaMesAno[0].length() < 2){
            diaMesAno[0] = "0" + diaMesAno[1];
        }
        if(diaMesAno[1].length() < 2){
            diaMesAno[1] = "0" + diaMesAno[1];
        }
        String fecha = diaMesAno[0] + " / " + diaMesAno[1] + " / " + diaMesAno[2];
        return fecha;
    }
    
    public static Date sumarRestarAnosDate(Date fecha, int anos){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.YEAR, anos);
        return calendar.getTime();
    }
    
    public static boolean esEmailValido(String eMail){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(eMail);
        if(mather.find()) {
            return true;
        }else{
            return false;
        }
    }
    
    public static String fechaSQL(Date pFecha){
        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dformat.format(pFecha);
        return currentTime;
    }
    
}
