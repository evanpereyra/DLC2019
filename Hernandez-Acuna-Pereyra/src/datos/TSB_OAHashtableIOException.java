package datos;

/**
 * Representa situaciones de error en IO en la serializacion de objetos de la clase 
 * TSBSimpleList. Estos errores seran casi siempre debidos a intentos de Serializacion 
 * fallidos, pero puede usarse en cualquier otra situacion que implique IO por algun 
 * dispositivo externo.
 * 
 * @author Ing. Valerio Frittelli.
 * @version Septiembre de 2017.
 */
public class TSB_OAHashtableIOException extends Exception
{
       private String message = "Problema al serializar la lista";
    
      /**
       * Inicializa el objeto de excepcion con valores por default.
       */
       public TSB_OAHashtableIOException()
       {
       }  
    
      /**
       * Inicializa el mensaje a retornar con getMessage() con la cadena tomada como
       * parametro.
       * @param msg el mensaje que sera retornado con getMessage().
       * @see getMessage().
       */
       public TSB_OAHashtableIOException(String msg)
       {
            message = msg;
       }
    
      /**
       * Retorna una descripcion del error que provoco la excepcion.
       * @return una cadena con la descripcion del error.
       */
       @Override
       public String getMessage()
       {
         return message;
       }   
}
