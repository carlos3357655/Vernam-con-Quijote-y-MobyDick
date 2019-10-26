# -*- coding: iso-8859-1 -*-
import sys, getopt
import time
import alfabeto

from vigenere import cifrar_vigenere, descifrar_vigenere
from feistel import cifrar_feistel, descifrar_feistel


#
#TEST PARA SABER SI FUNCIONA
#python cifrador.py -v -c -k "key.txt" -i quijote.txt -o out.txt 
#

def main(argv):

	try:
		opts, args = getopt.getopt(argv,"hvfcdk:i:o:",["keyfile=","inputfile=", "outputfile="])
	except getopt.GetoptError:
		print ""
		print "Para obtener ayuda usa el comando -h"
		print ""
		print "	python cifrador.py -h"
		print ""
		sys.exit(2)
	for opt, arg in opts:
		if opt == '-h':
			print ''
			print ''
			print ' ________________________________________ '
			print ' MENU AYUDA CIFRADOR FEISTEL'		
			print ' ________________________________________ '
			print ' Inicialmente fue trabajado por Camilo Quintero y Emilio guzman. '
			print ' Correos: camilo_ale.quintero@uao.edu.co y Emilio.guzman@uao.edu.co. '		
			print'Sintaxis:'
			print 'python cifrador.py <algoritmo> <operacion> <llave> <input> <oputput>'
			print '-f  --feistel      Ejecuta el algoritmo Feistel'
			print '-c  --cifrar       Ejecuta el modulo de cifrado'
			print '-d  --descifrar    Ejecuta el modulo de descifrado'
			print '-k  --key          Ruta del archivo con la llave'
			print '-i  --input        Ruta del archivo de entrada'
			print '-o  --output       Ruta del archivo de salida'
			print 'Ejemplo:'
			print 'Cifrado Feistel'
			print 'python cifrador.py -f -c -i "cifrado.txt" -o "mensaje.cif"'
			print 'python cifrador.py -f -d -i "mensaje.cif" -o "mensaje.dec"'
                        print 'Andres Mauricio Rubianes- Carlos Alberto Tombe'
		       	print 'Amrubianes@gmail.com- Carlos516.36@gmail.com'
			print 'Presentado a SILER AMADOR DONADO.'
		        print 'Universidad Autonoma de Occidente'
			print ''
			sys.exit()
		elif opt in ("-v", "--vigenere"):
			cifrado = 'vigenere'
		elif opt in ("-f", "--feistel"):
			cifrado = 'feistel'
		elif opt in ("-c", "--cifrar"):
			operacion = 'cifrar'
		elif opt in ("-d", "--descifrar"):
			operacion = 'descifrar'
		elif opt in ("-k", "--key"):
			keyfile = arg
		elif opt in ("-i", "--input"):
			inputfile = arg
		elif opt in ("-o", "--output"):
			if operacion == 'cifrar':
				outputfile = arg + ".cif"
			elif operacion == 'descifrar':
				outputfile = arg + ".dec"
	
	try:
		if cifrado == 'vigenere':
			if operacion == 'cifrar':
				start_time = time.time()
				cifrar_vigenere(inputfile, keyfile, alfabeto.es_letras, outputfile)
				end_time = time.time()
				print "==================================================="
				print "==================================================="
				print "Su archivo " + inputfile + " fue cifrado con exito."
				print "==================================================="
				print "Algoritmo o cifra: " + cifrado
				print "Archivo cifrado:   " + outputfile
				print "Tiempo de cifrado: " + str(end_time - start_time) + "seg"
				print "==================================================="
				print "==================================================="
				print ""
			elif operacion == 'descifrar':
				start_time = time.time()
				descifrar_vigenere(inputfile, keyfile, alfabeto.es_letras, outputfile)
				end_time = time.time()
				print "==================================================="
				print "==================================================="
				print "Su archivo " + inputfile + " fue descifrado con exito."
				print "==================================================="
				print "Algoritmo o cifra: " + cifrado
				print "Archivo cifrado:   " + outputfile
				print "Tiempo de cifrado: " + str(end_time - start_time) + "seg"
				print "==================================================="
				print "==================================================="
				print ""
		elif cifrado == 'feistel':
			if operacion == 'cifrar':
				start_time = time.time()
				cifrar_feistel(inputfile, 20, alfabeto.es_letras, outputfile, 2)
				end_time = time.time()
				print "==================================================="
				print "==================================================="
				print "Su archivo " + inputfile + " fue cifrado con exito."
				print "==================================================="
				print "Algoritmo o cifra: " + cifrado
				print "Archivo cifrado:   " + outputfile
				print "Tiempo de cifrado: " + str(end_time - start_time) + "seg"
				print "==================================================="
				print "==================================================="
				print ""
			elif operacion == 'descifrar':
				start_time = time.time()
				descifrar_feistel(inputfile, 20, alfabeto.es_letras, outputfile, 2)
				end_time = time.time()
				print "==================================================="
				print "==================================================="
				print "Su archivo " + inputfile + " fue descifrado con exito."
				print "==================================================="
				print "Algoritmo o cifra: " + cifrado
				print "Archivo cifrado:   " + outputfile
				print "Tiempo de cifrado: " + str(end_time - start_time) + "seg"
				print "==================================================="
				print "==================================================="
				print ""
				
	except:
		print "---------------------------------------------------"
		print "Algo salio mal :'-( ... Para obtener ayuda ejecute: "
		print "---------------------------------------------------"
		print "	python cifrador.py -h"
		print "---------------------------------------------------"



if __name__== "__main__":
	main(sys.argv[1:])
