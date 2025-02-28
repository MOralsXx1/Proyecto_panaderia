package Interface;

import java.util.List;

import Dominio.Panes;

public interface Metodos {

	public void guardar(Panes pan);

	public List<Panes> Mostrar();

	public Panes buscaPorIndice(int indice);

	public void editar(int indice, Panes pan);

	public void Eliminar(int indice);

	List<Panes> buscarPorSabor(String sabor);

	float calcularTotalInvertido();

	Panes buscarPorNombre(String nombre);

	void editarPorNombre(String nombre, Panes pan);

	boolean eliminarPorNombre(String nombre);

}
