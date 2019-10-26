import java.util.*;
import java.io.*;


class procesamientoMensaje{
    public void instrucciones(){
        
        System.out.println("Instrucciones:");
        System.out.println("java Taller -h   ==> para ver las instrucciones ");
        System.out.println("java Taller -a mensaje.txt -k clave.txt -s salida.txt -c ==> para la ejecucion del programa");
        System.out.println("");
        
    }
    
    public void cargaArregloMap(Map arreglo){
        
    arreglo.put("00000000",'0');
    arreglo.put("00000001",'1');
    arreglo.put("00000010",'2');
    arreglo.put("00000011",'3');
    arreglo.put("00000100",'4');
    arreglo.put("00000101",'5');
    arreglo.put("00000110",'6');
    arreglo.put("00000111",'7');
    arreglo.put("00001000",'8');
    arreglo.put("00001001",'9');
    
    arreglo.put("01000001",'A');
    arreglo.put("01000010",'B');
    arreglo.put("01000011",'C');
    arreglo.put("01000100",'D');
    arreglo.put("01000101",'E');
    arreglo.put("01000110",'F');
    arreglo.put("01000111",'G');
    arreglo.put("01001000",'H');
    arreglo.put("01001001",'I');
    arreglo.put("01001010",'J');
    arreglo.put("01001011",'K');
    arreglo.put("01001100",'L');
    arreglo.put("01001101",'M');
    arreglo.put("01001110",'N');
    arreglo.put("01001111",'O');
    arreglo.put("01010000",'P');
    arreglo.put("01010001",'Q');
    arreglo.put("01010010",'R');
    arreglo.put("01010011",'S');
    arreglo.put("01010100",'T');
    arreglo.put("01010101",'U');
    arreglo.put("01010110",'V');
    arreglo.put("01010111",'W');
    arreglo.put("01011000",'X');
    arreglo.put("01011001",'Y');
    arreglo.put("01011010",'Z');
    
    arreglo.put("01100001",'a');
    arreglo.put("01100010",'b');
    arreglo.put("01100011",'c');
    arreglo.put("01100100",'d');
    arreglo.put("01100101",'e');
    arreglo.put("01100110",'f');
    arreglo.put("01100111",'g');
    arreglo.put("01101000",'h');
    arreglo.put("01101001",'i');
    arreglo.put("01101010",'j');
    arreglo.put("01101011",'k');
    arreglo.put("01101100",'l');
    arreglo.put("01101101",'m');
    arreglo.put("01101110",'n');
    arreglo.put("01101111",'o');
    arreglo.put("01110000",'p');
    arreglo.put("01110001",'q');
    arreglo.put("01110010",'r');
    arreglo.put("01110011",'s');
    arreglo.put("01110100",'t');
    arreglo.put("01110101",'u');
    arreglo.put("01110110",'v');
    arreglo.put("01110111",'w');
    arreglo.put("01111000",'x');
    arreglo.put("01111001",'y');
    arreglo.put("01111010",'z');

        arreglo.put('0',48);
        arreglo.put('1',49);
        arreglo.put('2',50);
        arreglo.put('3',51);
        arreglo.put('4',52);
        arreglo.put('5',53);
        arreglo.put('6',54);
        arreglo.put('7',55);
        arreglo.put('8',56);
        arreglo.put('9',57);
        arreglo.put('A',65);
        arreglo.put('B',66);
        arreglo.put('C',67);
        arreglo.put('D',68);
        arreglo.put('E',69);
        arreglo.put('F',70);
        arreglo.put('G',71);
        arreglo.put('H',72);
        arreglo.put('I',73);
        arreglo.put('J',74);
        arreglo.put('K',75);
        arreglo.put('L',76);
        arreglo.put('M',77);
        arreglo.put('N',78);
        arreglo.put('O',79);
        arreglo.put('P',80);
        arreglo.put('Q',81);
        arreglo.put('R',82);
        arreglo.put('S',83);
        arreglo.put('T',84);
        arreglo.put('U',85);
        arreglo.put('V',86);
        arreglo.put('W',87);
        arreglo.put('X',88);
        arreglo.put('Y',89);
        arreglo.put('Z',90);
        arreglo.put('a',97);
        arreglo.put('b',98);
        arreglo.put('c',99);
        arreglo.put('d',100);
        arreglo.put('e',101);
        arreglo.put('f',102);
        arreglo.put('g',103);
        arreglo.put('h',104);
        arreglo.put('i',105);
        arreglo.put('j',106);
        arreglo.put('k',107);
        arreglo.put('l',108);
        arreglo.put('m',109);
        arreglo.put('n',110);
        arreglo.put('o',111);
        arreglo.put('p',112);
        arreglo.put('q',113);
        arreglo.put('r',114);
        arreglo.put('s',115);
        arreglo.put('t',116);
        arreglo.put('u',117);
        arreglo.put('v',118);
        arreglo.put('w',119);
        arreglo.put('x',120);
        arreglo.put('y',121);
        arreglo.put('z',122);
    }
    
    public void cifrar(String nomMensaje, String nomClave,String nomSalidaCriptograma){

    Map arreglo = new HashMap();
    cargaArregloMap(arreglo);

    String Mensaje="";
        try {
             FileReader fr = new FileReader(nomMensaje);
             BufferedReader bf = new BufferedReader(fr);

            String entrada="";    
            while ((Mensaje = bf.readLine())!=null) {
                entrada += Mensaje;
            }

            Mensaje=entrada;
        } catch (Exception e) {
            System.out.println("error al leer el contenido del .txt: "+e);
        }

   String Key = "";
        try {
             FileReader fr = new FileReader(nomClave);
             BufferedReader bf = new BufferedReader(fr);

            String entrada="";    
            while ((Key = bf.readLine())!=null) {
                entrada += Key;
            }
            Key=entrada;
        } catch (Exception e) {
            System.out.println("error al crear la clave dentro del .txt:  "+e);
        }

        String t="";
        for (int i = 0; i < Mensaje.length(); i++) {
            
            if(Mensaje.charAt(i)!=' '){
                t +=Mensaje.charAt(i);
            }
            
        }Mensaje =t;
        t="";
         for (int i = 0; i < Key.length(); i++) {
            
            if(Key.charAt(i)!=' '){
                t +=Key.charAt(i);
            }
            
        }Key =t;
         System.out.println("Mensaje: "+Mensaje);
         System.out.println("Clave: "+Key);
        

    String Mensaje_Binario = "";

    String Bin_Char = "";

    String Nueva_Clave = "";  
    

    Mensaje_Binario = Integer.toBinaryString(Integer.parseInt(arreglo.get(Key.charAt(0))+""));
    Mensaje_Binario = String.format("%8s", Mensaje_Binario).replace(' ', '0');
    
        for (int i = 0; i < Mensaje.length(); i++){
            Bin_Char = Integer.toBinaryString(Integer.parseInt(arreglo.get(Mensaje.charAt(i))+""));
            Bin_Char = String.format("%8s", Bin_Char).replace(' ', '0');
            System.out.println(Mensaje.charAt(i)+" -> "+Bin_Char);
            String xor = "";
            for (int j = 0; j < Bin_Char.length(); j++){
               if (Bin_Char.charAt(j)==Mensaje_Binario.charAt(j)){
                   xor +="0";
               }else{
                   xor +="1";
               }               
            }
            Nueva_Clave +=xor;
        }
        System.out.println("Criptograma = "+Nueva_Clave);
         BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(new File(nomSalidaCriptograma)));
                bufferedWriter.write(Nueva_Clave);

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                    try {
                        if (bufferedWriter != null) {
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
            } 
        
    }
    
    
    public  void descifrar(String rutaCriptograma, String nomClave){
    Map arreglo = new HashMap();
    cargaArregloMap(arreglo); 

    String Criptograma="";
        try {
           
             BufferedReader bf = new BufferedReader(new FileReader(rutaCriptograma));
            String entrada="";    
            while ((Criptograma = bf.readLine())!=null) {
                entrada += Criptograma;
            }
            Criptograma=entrada;
            System.out.println("Criptograma leido: "+Criptograma);
        } catch (Exception e) {
            System.out.println("error al ingresar el mensaje cifrado dentro del .txt: "+e);
        }
    

   String Key = "";
        try {
             FileReader fr = new FileReader(nomClave);
             BufferedReader bf = new BufferedReader(fr);

            String entrada="";    
            while ((Key = bf.readLine())!=null) {
                entrada += Key;
            }

            Key=entrada;
        } catch (Exception e) {
            System.out.println("error al leer la clave dentro del .txt: "+e);
        }


    String Bin_Key = "";
    String Bin_Char = "";
    String NuevoMsgClaro = "";  
    

    Bin_Key = Integer.toBinaryString(Integer.parseInt((arreglo.get(Key.charAt(0)))+""));
    Bin_Key = String.format("%8s", Bin_Key).replace(' ', '0');

    int iteraciones=Criptograma.length()/8;
        int posArr=0;
        String claveCompleta="";
        for (int i = 0; i < iteraciones; i++){
            claveCompleta +=Bin_Key;
            String temp="";
            int cont=0;
            while(cont<8){
                
                temp+= Criptograma.charAt(posArr);
                posArr++;
                cont++;
            }
            System.out.println("temp= "+temp);
            String xor = "";
            for (int o = 0; o < temp.length(); o++){
               if (temp.charAt(o)==Bin_Key.charAt(o)){
                   xor +="0";
               }else{
                   xor +="1";
               }             
            }
            System.out.println("xor: "+xor);
            NuevoMsgClaro += arreglo.get(xor);
        }
        System.out.println("clave completa= "+claveCompleta);
        System.out.println("Nuevo Mensaje = "+NuevoMsgClaro);
    }       
}



public class Taller {
    
    public static void main(String[] args) {
        procesamientoMensaje tm= new procesamientoMensaje();
        if(args.length == 0){            
            System.out.println("ingrese el comando -h para ver las instrucciones de la siguinte forma:"
                    + "\n       java Taller -h");
        }else if(args[0].equals("-h")){
            tm.instrucciones();
        }else if(args.length >= 6 && args.length <= 7){ 
            System.out.println("Validando parametros...");
                boolean cifrar=false;
                boolean comando_a=false;
                boolean comando_k=false;
                boolean comando_s=false;
                String nomMensaje="";
                String nomClave="";
                String nomSalida="";
                
                try {
                    for (int i = 0; i < args.length; i++) {
                    if (args[i].equals("-c") && cifrar==false ) {
                        cifrar=true;
                    }
                    if (args[i].equals("-k") && comando_k==false) {
                        comando_k=true;
                        nomClave=args[i+1];
                    }
                    if (args[i].equals("-a") && comando_a==false) {
                        comando_a=true;
                        nomMensaje=args[i+1];
                    }
                    if (args[i].equals("-s") && comando_s==false) {
                        comando_s=true;
                        nomSalida=args[i+1];
                    }
                }

                    
                } catch (Exception e) {
                    System.out.println("error en el ingreso de los parametros:"
                            + "\n utilice el comando -h para ver las instrucciones.");
                }
                if(cifrar){
                   if(comando_a && comando_k && comando_s && nomMensaje.length()>0 && nomClave.length()>0 && nomSalida.length()>0){
                    System.out.println("este seria el comando de ejecucion");
                    System.out.println("java Taller -a("+comando_a+") "+nomMensaje+" -k("+comando_k+")  "+nomClave+" -s("+comando_s+")  "+nomSalida+" -c");
                    tm.cifrar(nomMensaje, nomClave, nomSalida);
                    }else{
                        System.out.println("Error en el ingreso de los parametros, consulte la ayuda asi:"
                                + "\njava Taller -h");
                    }
                }else{
                    tm.descifrar(nomSalida, nomClave);                    
                }

        }else{
            System.out.println("opcion invalida");
        }         
    } 
}