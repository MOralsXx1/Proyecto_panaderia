package Main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Dominio.Panes;
import Implementacion.LogicaMetodos;

public class Principal {

    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);

        String nombre, sabor;
        int existencia, menuPrinc, indice;
        float precio;
        LocalDate Fechalabo;
        Panes pan = null;
        LogicaMetodos imp = new LogicaMetodos();

        do {
            System.out.println("\nMENU PRINCIPAL DE PANADERIA ");
            System.out.println("1------ ALTA ");
            System.out.println("2------ MOSTRAR ");
            System.out.println("3------ BUSCAR ");
            System.out.println("4------ EDITAR ");
            System.out.println("5------ ELIMINAR ");
            System.out.println("6------ BUSCAR POR NOMBRE ");
            System.out.println("7------ BUSCAR POR SABOR ");
            System.out.println("8------ CALCULAR TOTAL DE DINERO INVERTIDO  ");
            System.out.println("9------ EDITAR BUSCANDO POR NOMBRE ");
            System.out.println("10------ ELIMINAR BUSCANDO POR NOMBRE ");
         
            System.out.println("11------ SALIR ");
            System.out.print("Introduce opcion deseada: ");
            menuPrinc = lectura.nextInt();
            lectura.nextLine(); //  salto de línea 

            switch (menuPrinc) {

                case 1:
                    try {
                        System.out.print("Ingrese el nombre: ");
                        nombre = lectura.nextLine();
                        System.out.print("Ingrese el precio: ");
                        precio = lectura.nextFloat();
                        System.out.print("Ingrese la existencia: ");
                        existencia = lectura.nextInt();
                        lectura.nextLine();
                        System.out.print("Ingrese el sabor: ");
                        sabor = lectura.nextLine();
                        System.out.print("Ingrese la fecha de elaboracion (YYYY-MM-DD): ");
                        String fecha = lectura.nextLine();
                        Fechalabo = LocalDate.parse(fecha);

                        pan = new Panes(nombre, precio, existencia, sabor, Fechalabo);
                        imp.guardar(pan);
                    } catch (Exception e) {
                        System.out.println("Error al guardar: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println(imp.Mostrar());
                    break;

                case 3:
                    try {
                        System.out.print("Ingrese el indice del registro a buscar: ");
                        indice = lectura.nextInt();
                        pan = imp.buscaPorIndice(indice);
                        System.out.println("Se encontro: " + pan);
                    } catch (Exception e) {
                        System.out.println("Error al buscar: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Ingrese el indice del registro a editar: ");
                        indice = lectura.nextInt();
                        lectura.nextLine();
                        pan = imp.buscaPorIndice(indice);
                        System.out.println("Se encontro: " + pan.getNombre());

                        System.out.print("Ingrese el nuevo nombre del pan: ");
                        nombre = lectura.nextLine();
                        pan.setNombre(nombre);
                        imp.editar(indice, pan);

                        System.out.println("Se edito correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al editar: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.print("Ingrese el indice a eliminar: ");
                        indice = lectura.nextInt();
                        imp.Eliminar(indice);
                    } catch (Exception e) {
                        System.out.println("Error al eliminar: " + e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        System.out.print("Ingrese el nombre del pan a buscar: ");
                        nombre = lectura.nextLine();
                        Panes resultado = imp.buscarPorNombre(nombre);
                        if (resultado != null) {
                            System.out.println("Pan encontrado: " + resultado);
                        } else {
                            System.out.println("No se encontro el pan con ese nombre.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al buscar por nombre: " + e.getMessage());
                    }
                    break;

                case 7:
                    try {
                        System.out.print("Ingrese el sabor del pan a buscar: ");
                        sabor = lectura.nextLine();
                        List<Panes> panesEncontrados = imp.buscarPorSabor(sabor); // Definimos el tipo explícitamente

                        if (panesEncontrados.size() > 0) {
                            System.out.println("Panes encontrados con sabor " + sabor + ":");
                            for (int i = 0; i < panesEncontrados.size(); i++) { // Uso de for clásico
                                Panes pan1 = panesEncontrados.get(i);
                                System.out.println(pan1.getNombre() + "  Precio: " + pan1.getPrecio()
                                        + " Existencia: " + pan1.getExistencia());
                            }
                        } else {
                            System.out.println("No se encontraron panes con ese sabor.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al buscar por sabor: " + e.getMessage());
                    }
                    break;

                case 8:
                	try {
                        float totalInvertido = 0;
                        List<Panes> listaPanes = imp.Mostrar(); // Obtener la lista de panes

                        for (Panes p : listaPanes) {
                            totalInvertido += p.getPrecio() * p.getExistencia(); // Multiplicamos precio * cantidad
                        }

                        System.out.println("Total de dinero invertido en panes: " + totalInvertido);
                    } catch (Exception e) {
                        System.out.println("Error al calcular el total invertido: " + e.getMessage());
                    }
                    break;

                case 9:
                    try {
                        System.out.print("Ingrese el nombre del pan a editar: ");
                        nombre = lectura.nextLine();
                        pan = imp.buscarPorNombre(nombre);

                        if (pan != null) {
                            System.out.print("Ingrese el nuevo nombre: ");
                            String nuevoNombre = lectura.nextLine();
                            pan.setNombre(nuevoNombre);
                            imp.editarPorNombre(nombre, pan);
                            System.out.println("Se editó correctamente.");
                        } else {
                            System.out.println("No se encontró el pan con ese nombre.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al editar por nombre: " + e.getMessage());
                    }
                    break;

                case 10:
                    try {
                        System.out.print("Ingrese el nombre del pan a eliminar: ");
                        nombre = lectura.nextLine();
                        boolean eliminado = imp.eliminarPorNombre(nombre);
                        if (eliminado) {
                            System.out.println("Se eliminó el pan exitosamente.");
                        } else {
                            System.out.println("No se encontró el pan con ese nombre.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al eliminar por nombre: " + e.getMessage());
                    }
                    break;

                case 11:
                    System.out.println("Saliendo del programa...");
                    break;

    
            }
        } while (menuPrinc < 11);

       
    }
}

