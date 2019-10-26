//package vernam;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 *
 * @author luis Ordoñez
 */

public class vernam {
public static final String alfabeto="ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz0123456789+/";
    
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length==4)
        {            
            File in=new File(args[0]);
            FileReader inR = new FileReader(in);
            BufferedReader inB = new BufferedReader(inR);
		
            String linea ="";
            String temp ="";
            String clave="";
            String resto="";
            int cont=0;
	    int op=0;        
                        
            if (args[3].length()>1)
            {
                File cl=new File(args[3]);
                FileReader clR = new FileReader(cl);
                BufferedReader clB = new BufferedReader(clR);
                clave = clB.readLine();
            }
            else clave=args[3];
            
	    if ("-c".equals(args[1]))op=0;
	    if ("-d".equals(args[1]))op=1;
	    if ("-h".equals(args[1]))op=2;
                        
            while((linea = inB.readLine())!=null)
            {          
               temp=linea;
               
               char[] cl=new char[temp.length()];
                if (clave.length() != 1 && temp.length()>clave.length())
                {
                    for (int i=0;i<temp.length();i++)
                     {
                         if (cont == clave.length()-1)
                         {
                             cl[i]=clave.charAt(cont);
                             cont=0;
                         }
                         else 
                         {    
                             cl[i]=clave.charAt(cont);
                             cont ++;
                         }
                     }
                     String str  = new String (cl);
                     clave=str;
                }
                else
                {   
                    char[] aux=new char[temp.length()];
                    for (int i=0;i<temp.length();i++)
                    {
                        aux[i]=args[3].charAt(0);
                    }
                    String auxiliar= new String(aux);
                    clave=auxiliar;
                }          
               switch (op)
               {
                   case 0:
                       temp=cifrar(temp,clave);
                       temp=cod_64(temp);
                       write_file(temp,args[2]);
                   break;
                   case 1:
                       temp =decod_64(linea);
                       temp=decifrar(temp,clave);
                       write_file(temp,args[2]);
                   break;
                   default:  
                       System.out.println("Opcion invalida dirijase al -h para la ayuda");
                   break;
               }
            }
        }
        else
            if (args.length==1 && "-h".equals(args[0])) ayuda();
            else System.out.println("Argumentos incompleto dirijase al -h para la ayuda");
    }
    
     public static String cifrar(String linea, String clave) throws InterruptedException
    {
        char[] vec_linea = linea.toCharArray(); 
        char[] vec_clave = clave.toCharArray(); 
        char[] vec_result =new char[linea.length()]; 
        
        for(int i=0;i<linea.length();i++)
        {
            vec_result[i]=(char) (vec_linea[i]^vec_clave[i]);
        }
        String resultado =new String(vec_result);
        return resultado;
    }
    
    public static String decifrar(String linea, String clave)
    {
        char[] vec_linea = linea.toCharArray(); 
        char[] vec_clave = clave.toCharArray(); 
        char[] vec_result =new char[linea.length()]; 
      
        for(int i=0;i<linea.length();i++)
        {
            vec_result[i]=(char) (vec_linea[i]^vec_clave[i]);
        }
        String resultado =new String(vec_result);
        return resultado;
    }

    public static void write_file(String temp, String file) throws IOException 
    {    
////        ew OutputStreamWriter(new FileOutputStream("FicheroSalidaUTF8.txt"), "utf-8");
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "ascii"));
        out.write(temp);
        out.close();
//        FileWriter ficheroU  = new FileWriter(file,true);
//        PrintWriter pwU = new PrintWriter(ficheroU);
//        pwU.println(temp);
//        ficheroU.close();
    }

    private static void ayuda()
    {
        for (int i=0;i<8;i++){System.out.println("");}  
        System.out.println("Ayuda");
        System.out.println("Los parametros del programa deben ingresarce bajo");
        System.out.println("el siguiente esquema:");
        System.out.println("java codificacion.class [dir archivo de entrada] [operacion] [dir archivo de salida] [dir archivo clave]");
        System.out.println("Ejemplo:");
        System.out.println("java codificacion archivo_in.txt -c archivo_out.txt clave.txt");
        System.out.println("Operaciones Validas");
        System.out.println("-c cifrar por Sustitucion vernam");
        System.out.println("-d descifrar por Sustitucion vernam");
        for (int i=0;i<8;i++){System.out.println("");}
    }
    
    private static String cod_64(String cadena)
    {
        byte [] stringToEncodeBytes = cadena.getBytes();
        String encode = Base64.encode(stringToEncodeBytes);
        return encode;
    }
    
    private static String decod_64(String cadena)
    {
        byte [] stringToDecodeBytes = Base64.decode(cadena);
        String decode= new String(stringToDecodeBytes);
        return decode;
    }
}

