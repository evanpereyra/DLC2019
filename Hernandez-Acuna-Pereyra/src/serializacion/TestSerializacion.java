package serializacion;

import datos.*;

import entidades.Contador;
import entidades.Palabra;
import negocio.ManejadorArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class TestSerializacion
{   public static  ManejadorArchivos ma= new ManejadorArchivos();
    private static TSB_OAHashtable<String, Contador>  sl ;

    static public void grabar(File f) throws IOException {

        try {
            ma.cargarArchivo(f);

        } catch (FileNotFoundException ex) {
            System.out.println("Error al leer el archivo: " + ex.getMessage());
        }

        sl = ma.getListPalabras();


        try
        {
            TSB_OAHashtableWriter slw = new TSB_OAHashtableWriter("lista.dat");
            slw.write(sl);
        }
        catch(TSB_OAHashtableIOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static public void leer()
    {
        try
        {
            TSB_OAHashtableReader slr = new TSB_OAHashtableReader("lista.dat");
            sl = (TSB_OAHashtable<String, Contador> ) slr.read();

            System.out.println(sl);
        }
        catch( TSB_OAHashtableIOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String [] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int op;
        do
        {
            System.out.println("1. Grabar");
            System.out.println("2. Recuperar");
            System.out.println("3. Probar");
            System.out.println("4. Salir");
            System.out.print("Ingrese opcion: ");
            op = sc.nextInt();
            switch(op)
            {
                case 1:  grabar(new File("FileTest.txt"));

                    break;

                case 2:   leer();
                    break;

                case 3:   System.out.println(sl);
            }
        }
        while(op != 4);
    }
}