package Implementacion;

import java.util.ArrayList;
import java.util.List;

import Dominio.Panes;
import Interface.Metodos;

public class LogicaMetodos implements Metodos {

	// GENERAMOS LA LISTA CON LA QUE TRABAJAREMOS

	private List<Panes> lista = new ArrayList<Panes>();

	public void guardar(Panes pan) {
		// TODO Auto-generated method stub

		boolean bandera = true;

		for (Panes p : lista) {
			if (p.getNombre().equals(pan.getNombre())) {
				System.out.println("ese nombre de pan ya existe no se puede guardar");
				bandera = false;
			}
		}

		if (bandera == true) {
			lista.add(pan);
			System.out.println("se guardo con exito");
		}

	}

	public List<Panes> Mostrar() {
		// TODO Auto-generated method stub
		return lista;
	}

	public Panes buscaPorIndice(int indice) {
		// TODO Auto-generated method stub
		return lista.get(indice);
	}

	public void editar(int indice, Panes pan) {
		// TODO Auto-generated method stub

		lista.set(indice, pan);

	}

	public void Eliminar(int indice) {
		// TODO Auto-generated method stub
		lista.remove(indice);
	}

	// Buscar por nombre
	@Override
	public Panes buscarPorNombre(String nombre) {
		for (Panes p : lista) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				return p;
			}
		}
		return null; // No se encontró el pan
	}

	// Buscar por sabor
	@Override
	public List<Panes> buscarPorSabor(String sabor) {
		List<Panes> resultado = new ArrayList<>();
		for (Panes p : lista) {
			if (p.getSabor().equalsIgnoreCase(sabor)) {
				resultado.add(p);
			}
		}
		return resultado;
	}

	// Calcular total de dinero invertido
	@Override
	public float calcularTotalInvertido() {
		float total = 0;
		for (Panes p : lista) {
			total += p.getPrecio() * p.getExistencia();
		}
		return total;
	}

	// Editar buscando por nombre
	@Override
	public void editarPorNombre(String nombre, Panes pan) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
				lista.set(i, pan);
				System.out.println("El pan fue editado correctamente.");
				return;
			}
		}
		System.out.println("No se encontró un pan con ese nombre.");
	}

	// Eliminar buscando por nombre
	@Override
	public boolean eliminarPorNombre(String nombre) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
				lista.remove(i);
				return true;
			}
		}
		return false;
	}

}
