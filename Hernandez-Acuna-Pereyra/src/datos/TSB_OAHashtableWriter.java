package datos;

/**
 * Una clase usada para grabar objetos de la clase t
 * mediante Serializacion.
 * 
 * @author Ing. Valerio Frittelli.
 * @version Septiembre de 2017.
 */
import entidades.Contador;

import java.io.*;
public class TSB_OAHashtableWriter
{
      // nombre del archivo serializado...
      private String arch = "lista.dat";
    
      /**
       * Crea un objeto SimpleListWriter. Supone que el nombre del archivo a grabar 
       * sera "lista.dat".
       */
      public TSB_OAHashtableWriter()
      {
      }
      
      /**
       * Crea un objeto SimpleListWriter. Fija el nombre del archivo que se graba con 
       * el nombre tomado como parametro.
       * @param nom el nombre del archivo a grabar.
       */
      public TSB_OAHashtableWriter(String nom)
      {
            arch = nom;
      }
      
      /**
       * Graba la lista tomada como parametro.
       * @param sl la lista a serializar.
       * @throws TSB_OAHashtableIOException si se encuentra un error de IO.
       */
      public void write (TSB_OAHashtable<String, Contador> sl) throws TSB_OAHashtableIOException
      {
           try
           {
             FileOutputStream ostream = new FileOutputStream(arch);
             ObjectOutputStream p = new ObjectOutputStream(ostream);
      
             p.writeObject(sl);
      
             p.flush(); 
             ostream.close();
           }
           catch ( Exception e )
           {
             throw new TSB_OAHashtableIOException("No se pudo grabar la lista...");
           }
      }
}
