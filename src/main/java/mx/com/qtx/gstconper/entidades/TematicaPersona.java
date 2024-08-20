package mx.com.qtx.gstconper.entidades;

public class TematicaPersona {
	private String nomCorto;
	private String nombre;
	private int numPersona;
	private int idTematica;
	
	public TematicaPersona(String nomCorto, String nombre, int numPersona, int idTematica) {
		super();
		this.nomCorto = nomCorto;
		this.nombre = nombre;
		this.numPersona = numPersona;
		this.idTematica = idTematica;
	}

	public TematicaPersona() {
		super();
	}

	public String getNomCorto() {
		return nomCorto;
	}

	public void setNomCorto(String nomCorto) {
		this.nomCorto = nomCorto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumPersona() {
		return numPersona;
	}

	public void setNumPersona(int numPersona) {
		this.numPersona = numPersona;
	}

	public int getIdTematica() {
		return idTematica;
	}

	public void setIdTematica(int idTematica) {
		this.idTematica = idTematica;
	}

	@Override
	public String toString() {
		return "TematicaPersona [nomCorto=" + nomCorto + ", nombre=" + nombre + ", numPersona=" + numPersona
				+ ", idTematica=" + idTematica + "]";
	}

}
