package datos;

/**
 *  Clase que permite recuperar desde un archivo externo un objeto de
 *  la clase TSBSimpleList que haya sido grabado por Serializacion.
 *  @author Ing. Valerio Frittelli.
 *  @version Septiembre de 2017.
 */
import java.io.*;
public class TSB_OAHashtableReader
{
      private String arch = "lista.dat";
    
      /**
       * Crea un objeto SimpleListReader. Asume que el nombre del archivo desde el
       * cual se recupera es "lista.dat".
       */
      public TSB_OAHashtableReader()
      {
      }
      
      /**
       * Crea un objeto SimpleListReader. Fija el nombre del archivo desde el cual 
       * se recupera con el nombre tomado como parametro.
       * @param nom el nombre del archivo a abrir para iniciar la recuperacion.
       */
      public TSB_OAHashtableReader(String nom)
      {
          arch = nom;
      }
      
      
      /**
       * Recupera una SimpleList desde un archivo serializado.
       * @throws TSB_OAHashtableIOException si se encuentra un error de IO.
       * @return una referencia al objeto recuperado.
       */
      public TSB_OAHashtable read() throws TSB_OAHashtableIOException
      {
          TSB_OAHashtable sl = null;
           
           try
           {
                 FileInputStream istream = new FileInputStream(arch);
                 ObjectInputStream p = new ObjectInputStream(istream);
          
                 sl = (TSB_OAHashtable ) p.readObject();
                 
                 p.close();
                 istream.close();
           }
           catch (Exception e)
           {
             throw new TSB_OAHashtableIOException("No se pudo recuperar la lista");
           }
           
           return sl;
       }
}