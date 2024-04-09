package ventas_semana2;

import java.io.BufferedWriter; 
import java.io.File; 
import java.io.FileWriter;

import java.io.StringWriter;
import java.io.PrintWriter;


class GenerateInfoFiles {
	String response;
	
	public String createProductsFile(String ruta) {
		// Generar archivo productos
        try {
            String columnas = "IDProducto;NombreProducto;PrecioPorUnidadProducto\n";
            String producto1 = "1;arroz diana 425gr;900\n";
            String producto2 = "2;café sello rojo 30gr;450\n";
            String producto3 = "3;azucar manuelita 1000gr;1200\n";
            String producto4 = "4;sal refisal 500gr;500\n";
            String producto5 = "5;atun van camps 250gr;3500\n";
            String producto6 = "6;salsa de tomate fruko 500gr;3000\n";
            String producto7 = "7;leche klim 800gr;6000\n";
            String producto8 = "8;aceite girasol 1000ml;9800\n";
            String producto9 = "9;crema dental colgate 200gr;10000\n";
            String producto10 = "10;jabon en polbo fab 1000gr;5000\n";
            
            File file = new File(ruta);
            if (!file.exists()) { 
                file.createNewFile();
                FileWriter fw = new FileWriter(file); 
                BufferedWriter bw = new BufferedWriter(fw); 
                bw.write(columnas);
                bw.write(producto1);
                bw.write(producto2);
                bw.write(producto3);
                bw.write(producto4);
                bw.write(producto5);
                bw.write(producto6);
                bw.write(producto7);
                bw.write(producto8);
                bw.write(producto9);
                bw.write(producto10);
                bw.close();
                response = "Archivo de productos generado!";
            } else {
	    		response = "Archivo de productos ya existe!";
	    	}
        } catch (Exception e) {
        	StringWriter sw = new StringWriter();
    		PrintWriter pw = new PrintWriter(sw);
    		e.printStackTrace(pw);
    		response = sw.toString();
        }
        
        return response;
	}
	
	public String createSalesManInfoFile(String ruta) {
		// Generar archivo vendedores
    	try {
	    	String columnas = "TipoDocumento;NumeroDocumento;NombresVendedor;ApellidosVendedor\n";
	    	String vendedor1 = "CC;18397655;Alejandro;Velez\n";
	    	String vendedor2 = "CC;52345243;Myra;Moreno\n";
	    	String vendedor3 = "CC;24354267;Pedro;Castillo\n";
	    	String vendedor4 = "CC;126776666;Mario;Millan\n";
	    	String vendedor5 = "CC;53155393;Diana;Romero\n";
	    	File file = new File(ruta);
	    	if (!file.exists()) {
		    	file.createNewFile();
		    	FileWriter fw = new FileWriter(file);
		    	BufferedWriter bw = new BufferedWriter(fw);
		    	bw.write(columnas);
		    	bw.write(vendedor1);
		    	bw.write(vendedor2);
		    	bw.write(vendedor3);
		    	bw.write(vendedor4);
		    	bw.write(vendedor5);
		    	bw.close();
		    	response = "Archivo de vendedores generado!";
	    	} else {
	    		response = "Archivo de vendedores ya existe!";
	    	}
    	} catch (Exception e) {
    		StringWriter sw = new StringWriter();
    		PrintWriter pw = new PrintWriter(sw);
    		e.printStackTrace(pw);
    		response = sw.toString();
    	}
    	return response;
	}
	
	public String createSalesMenFile(String ruta) {		
		// Generar archivos de ventas
		try {
	    	String columnas = "TipoDocumentoVendedor;NúmeroDocumentoVendedor;IDProducto;CantidadProductoVendido\n";
	    	String vendedor1 = "CC;18397655;6;4\n";
	    	String vendedor2 = "CC;52345243;2;5\n";
	    	String vendedor3 = "CC;24354267;3;1\n";
	    	String vendedor4 = "CC;126776666;1;6\n";
	    	String vendedor5 = "CC;53155393;5;3\n";
	    	File file = new File(ruta);
	    	if (!file.exists()) {
		    	file.createNewFile();
		    	FileWriter fw = new FileWriter(file);
		    	BufferedWriter bw = new BufferedWriter(fw);
		    	bw.write(columnas);
		    	bw.write(vendedor1);
		    	bw.write(vendedor2);
		    	bw.write(vendedor3);
		    	bw.write(vendedor4);
		    	bw.write(vendedor5);
		    	bw.close();
		    	response = "Archivo de ventas generado!";
	    	} else {
	    		response = "Archivo de ventas ya existe!";
	    	}
    	} catch (Exception e) {
    		StringWriter sw = new StringWriter();
    		PrintWriter pw = new PrintWriter(sw);
    		e.printStackTrace(pw);
    		response = sw.toString();
    	}
    	return response;
	}
}



public class Main {

	public static void main(String[] args) {
		// Generar archivo productos_generados.txt
        String rutaProductosGenerados = "productos_generados.txt";
		GenerateInfoFiles genProductsFile = new GenerateInfoFiles();
		System.out.println(genProductsFile.createProductsFile(rutaProductosGenerados));

		// Generar archivo vendedores_generados.txt
    	String rutaVendedoresGenerados = "vendedores_generados.txt";
		GenerateInfoFiles genSellMenFile = new GenerateInfoFiles();
		System.out.println(genSellMenFile.createSalesManInfoFile(rutaVendedoresGenerados));
		
		// Generar archivo ventas_generadas.txt
		String rutaVentasGeneradas = "ventas_generadas.txt";
		GenerateInfoFiles genSellsFile = new GenerateInfoFiles();
		System.out.println(genSellsFile.createSalesMenFile(rutaVentasGeneradas));
//		System.out.println(genSellsFile.createSalesMenFile(rutaProductosGenerados, rutaVendedoresGenerados));
	}

}
