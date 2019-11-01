package ProgramacionConcurrenteVideo1;

public class Avion {
	
	private int id;
	private int intencion;
	
	public Avion (int id, int intencion) {
		this.id = id;
		this.intencion= intencion;
	}
	
	public int getIntencion() {
		return intencion;
	}
	
	public int getId() {
		return id;
	}
	
	public int nextintencion() {
		intencion = ++intencion % 5;
		return intencion;
	}
	
}
