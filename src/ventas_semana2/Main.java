package ventas_semana2;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

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
	
	public String[][] createSalesManInfoFile(String ruta) {
		String[][] sellersList = new String[7][1]; // Variable que devuelve array con datos del archivo
		
		// Generar archivo vendedores
    	try {
	    	String columnas = "TipoDocumento;NumeroDocumento;NombresVendedor;ApellidosVendedor\n";
	    	String vendedor1 = "CC;18397655;Alejandro;Velez\n";
	    	String vendedor2 = "CC;52345243;Myra;Moreno\n";
	    	String vendedor3 = "CC;24354267;Pedro;Castillo\n";
	    	String vendedor4 = "CC;126776666;Mario;Millan\n";
	    	String vendedor5 = "CC;53155393;Diana;Romero\n";
	    	String vendedores = columnas + vendedor1 + vendedor2 + vendedor3 + vendedor4 + vendedor5;
	    	
	    	// Crear lista de vendedores para retornar
	    	sellersList[0] = columnas.replace("\n", "").split(";");
	    	sellersList[1] = vendedor1.replace("\n", "").split(";");
	    	sellersList[2] = vendedor2.replace("\n", "").split(";");
	    	sellersList[3] = vendedor3.replace("\n", "").split(";");
	    	sellersList[4] = vendedor4.replace("\n", "").split(";");
	    	sellersList[5] = vendedor5.replace("\n", "").split(";");
	    	
	    	File file = new File(ruta);
	    	if (!file.exists()) {
		    	file.createNewFile();
		    	FileWriter fw = new FileWriter(file);
		    	BufferedWriter bw = new BufferedWriter(fw);
		    	bw.write(vendedores);
		    	bw.close();
		    	sellersList[6][0] = "Archivo de vendedores generado!";
	    	} else {
	    		sellersList[6][0] = "Archivo de vendedores ya existe!";
	    	}
    	} catch (Exception e) {
    		StringWriter sw = new StringWriter();
    		PrintWriter pw = new PrintWriter(sw);
    		e.printStackTrace(pw);
    		sellersList[6][0] = sw.toString();
    	}
    	return sellersList;
	}
	
	public String[][] createListSales(String[][] resultProducts, String[][] resultSellers) {
		// Armar lista de ventas por vendedor
		String[][] dataSellers = new String[5][1]; // Variable que devuelve array con datos de ventas aleatorias
		String seller = ""; // Variable para almacenar ventas por producto
		Random rand = new Random(); // Variable instanciada para generar cantidades aleatorias
		
		// For para armar variable string y variable tipo array
		for (int i = 1; i < resultSellers.length - 1; i++) {
			// Almacenar número de documento del vendedor
            for (int j = 0; j < resultSellers[i].length -2; j++) {
            	if (seller == "") {
            		seller = resultSellers[i][j];
            	} else {
            		seller += ";" + resultSellers[i][j];
            	}
            }
            // Almacenar cantidad vendida del producto
            for (int k = 1; k < resultProducts.length - 1; k++) {
            	for (int l = 0; l < 1; l++) {
            		seller += ";" +resultProducts[k][l];
            		int randomNum = rand.nextInt(60 - 30); // Valor aleatorio de cantidad del producto
            		seller += ";" + randomNum;
            	}
            }
            dataSellers[i-1] = seller.split(";"); // Almacenamiento de los datos en la variable tipo array
            seller = "";
		}
		return dataSellers;
	}
	
	public String createSalesMenFile(String rutaVentasGeneradas, String[][] resultListSales) {
		// Generar archivos de ventas
		try {
			int counterFinal = 0; // Variable para verificar que se ralicen los 5 archivos
			int counterUser = 1; // Variable para identificar cuando se acaba listado de ventas
			String sellsUser = ""; // Variable que almacena en string las ventas de cada vendedor
			int index = 1; // Variable que siempre va a traer valor de No documento del array por vendedor
			 
			// Armar variable con los datos y generar archivo por cada vendedor
			for (String[] lista : resultListSales) {
				for (int i = 0; i < lista.length; i++) {
					if (sellsUser == "") {
						sellsUser = lista[i];
					} else if (counterUser % 2 != 0) {
						sellsUser += lista[i];
					} else {
						sellsUser += ";" + lista[i] + "\n";
					}
					counterUser += 1;
					if (counterUser == 13) {
						String archivo = rutaVentasGeneradas + lista[index] + ".txt";
						File file = new File(archivo);
						file.createNewFile();
						FileWriter fw = new FileWriter(file);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(sellsUser);
						bw.close();
						counterUser = 1;
						sellsUser = "";
						counterFinal += 1;
					}
				}
			}
			
			
			// Verificar que los 5 archivos han sido generados
			if (counterFinal==5) {
				response = "Archivos de ventas por vendedores generados!";
			} else {
				response = "Error al crear uno o varios archivos de ventas por vendedores generados!";
			}
    	} catch (Exception e) {
    		StringWriter sw = new StringWriter();
    		PrintWriter pw = new PrintWriter(sw);
    		e.printStackTrace(pw);
    		response = sw.toString();
    	}
    	return response;
	}
	
	public String createTotalSalesSellers(String rutaTotalVentasVendedores, String[][] resultListSales,
		      String[][] resultProducts, String[][] resultSellers) {
	  	String seller = "";  // Variable para almacenar string para crear archivo
	    String sellerForList = ""; // Variable para almacenar nombre por vendedor
	    int value = 0; // Variable para almacenar valor de venta por vendedor
	    int counterProducts = 0; // Variable para traer el registro del valor de cada producto
	    int counterList = 0; // Variable para almacenar en cada fila el resultado de ventas
	    String[][] totalListSales = new String[5][1]; // Variable tipo array para organizar
	    String[] tmp = new String[1];
	    
	    // Crear variable para archivo y variable array
	    for (String[] listSales : resultListSales) {
	      for (int i = 1; i < listSales.length; i += 2) {
	        if (i == 1) {          
	          if (sellerForList == "") {
	            sellerForList = resultSellers[counterList+1][2] + " " + resultSellers[counterList+1][3] + ";";
	            seller += sellerForList;
	          } else {
	            sellerForList += listSales[i] + ";";
	            seller += listSales[i] + ";";
	          }
	          counterProducts += 1;
	          continue;
	        }
	        value += Integer.parseInt(listSales[i]) * Integer.parseInt(resultProducts[counterProducts][2]);
	        counterProducts += 1;
	      }
	      seller += value + "\n";
	      sellerForList += value;
	      totalListSales[counterList] = sellerForList.split(";");
	      sellerForList = "";
	      counterProducts = 0;
	      counterList += 1;
	      value = 0;
	    }
	    
<<<<<<< HEAD
	    // ordenar listado de ventas de mayor a menor
=======
	    //ordenar listado de ventas de mayor a menor
>>>>>>> 5bb4070ffacb078c0f860edfd2cb8c3f444d58d4
	    for (int i = 0; i < totalListSales.length; i++) {
	    	for (int j = 1; j < totalListSales.length - i; j++) {
	    		if (Integer.parseInt(totalListSales[j - 1][1]) < Integer.parseInt(totalListSales[j][1])) {
	    			tmp = totalListSales[j - 1];
	    			totalListSales[j - 1] = totalListSales[j];
	    			totalListSales[j] = tmp;
	    		}
	    	}
	    }
<<<<<<< HEAD
	    		
=======
	    
	    // con listado ordenado,armar informacion para generar archivo
	    seller = "";
	    for (int i = 0; i < totalListSales.length; i++) {
	    	if (seller == "") {
	    		seller = totalListSales[i][0] + ";" + totalListSales[i][1];
	    	} else {
	    		seller += "\n" + totalListSales[i][0] + ";" + totalListSales[i][1];
	    	}
	    }
	    
>>>>>>> 5bb4070ffacb078c0f860edfd2cb8c3f444d58d4
	    System.out.println(Arrays.deepToString(totalListSales));
	    // Generar archivo de ventas totales
	    try {
	      String archivo = rutaTotalVentasVendedores;
	      File file = new File(archivo);
	      file.createNewFile();
	        FileWriter fw = new FileWriter(file);
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(seller);
	        bw.close();
	        response = "Archivo ventas totales vendedores generado!";
	    } catch (Exception e) {
	        StringWriter sw = new StringWriter();
	        PrintWriter pw = new PrintWriter(sw);
	        e.printStackTrace(pw);
	        response = sw.toString();
	    }    
	    return response;
	}
	
	public String createTotalQuantityProducts(String rutaTotalCantidadProductos, String[][] resultListSales, String[][] resultProducts) {
		Map<String, Integer> quantiyProducts = new HashMap<String, Integer>();
		String product1 = ""; String product2 = ""; String product3 = ""; String product4 = ""; String product5 = ""; // Declarar varias variables en la misma línea
		int quantity1 = 0; int quantity2 = 0; int quantity3 = 0; int quantity4 = 0; int quantity5 = 0;
		
		//Armar variable con datos para crear archivo y variable array
		for (String[] listSeller : resultListSales) { 
			for (int i = 2; i < listSeller.length; i += 2) {
				if (Integer.parseInt(listSeller[i]) == 1) {
					
				}
			}
		}
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
    	String[][] resultSellers = ventas.createSalesManInfoFile(rutaVendedoresGenerados);
    	System.out.println(resultSellers[6][0].toString());
    	
    	// Generar lista de ventas para generar archivo de ventas
    	String[][] resultListSales = ventas.createListSales(resultProducts, resultSellers);
    	// System.out.println(Arrays.deepToString(resultListSales));
		
		// Generar archivo ventas_generadas.txt
    	String rutaVentasGeneradas = "ventas_generadas_";
    	String resultSalesFile = ventas.createSalesMenFile(rutaVentasGeneradas, resultListSales);
    	System.out.println(resultSalesFile);
    	
    	// Generar archivo de vendedores y valor de ventas por cada uno
    	String rutaTotalVentasVendedores = "total_ventas_vendedores.txt";
    	String resultTotalVentasVendedores = ventas.createTotalSalesSellers(rutaTotalVentasVendedores, resultListSales, resultProducts, resultSellers);
    	System.out.println(resultTotalVentasVendedores);
    	
    	//generar archivo total cantidad por productos 
    	String rutaTotalCantidadProductos = "total_cantidad_productos.txt";
    	String resultadoTotalCantidadProdcutos = ventas.createTotalQuantityProducts(rutaTotalCantidadProductos, resultListSales, resultProducts);
    	System.out.println(resultadoTotalCantidadProductos);
	}

}

