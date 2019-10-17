package ProgramacionConcurrenteVideo1;

public class carrera implements Runnable {
	
	private int id;
	private static int participantes;

	public carrera(int i, int participantes) {
		this.id = i;
		this.participantes = participantes;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
