package ventas_semana2;

import java.io.BufferedWriter; 
import java.io.File; 
import java.io.FileWriter;

import java.io.StringWriter;
import java.io.PrintWriter;


class GenerateInfoFiles {
	String response;
	
	public String[][] createProductsFile(String ruta) {
		String[][] productsList = new String[7][1]; // Variable que devuelve array con datos del archivo
	      
	    // Generar archivo productos
	        try {
	          // Armar lista de productos para crear archivo
	            String columnas = "IDProducto;NombreProducto;PrecioPorUnidadProducto\n";
	            String producto1 = "1;Arroz Diana 425gr;900\n";
	            String producto2 = "2;Café Sello Rojo 30gr;450\n";
	            String producto3 = "3;Azúcar manuelita 1000gr;1200\n";
	            String producto4 = "4;Sal Refisal 500gr;500\n";
	            String producto5 = "5;Atún VanCamps 250gr;3500";
	            String productos = columnas + producto1 + producto2 + producto3 + producto4 + producto5;
	            
	            // Crear lista de productos para retornar
	          productsList[0] = columnas.replace("\n", "").split(";");
	          productsList[1] = producto1.replace("\n", "").split(";");
	          productsList[2] = producto2.replace("\n", "").split(";");
	          productsList[3] = producto3.replace("\n", "").split(";");
	          productsList[4] = producto4.replace("\n", "").split(";");
	          productsList[5] = producto5.replace("\n", "").split(";");
	            
	            File file = new File(ruta);
	            if (!file.exists()) { 
	                file.createNewFile();
	                FileWriter fw = new FileWriter(file); 
	                BufferedWriter bw = new BufferedWriter(fw); 
	                bw.write(productos);
	                bw.close();
	                productsList[6][0] = "Archivo de productos generado!";
	            } else {
	              productsList[6][0] = "Archivo de productos ya existe!";
	        }
	        } catch (Exception e) {
	          StringWriter sw = new StringWriter();
	        PrintWriter pw = new PrintWriter(sw);
	        e.printStackTrace(pw);
	        productsList[6][0] = sw.toString();
	        }
	        
	        return productsList;
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
		// Instanciar el objeto ventas con la clase GenerateIfoFiles
		GenerateInfoFiles ventas = new GenerateInfoFiles();
	
		// Generar archivo productos_generados.txt
		String rutaProductosGenerados = "productos_generados.txt";
		String[][] resultProducts = ventas.createProductsFile(rutaProductosGenerados);
		System.out.println(resultProducts[6][0].toString());

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
