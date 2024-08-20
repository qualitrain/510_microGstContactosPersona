package mx.com.qtx.gstconper.api;

public class ErrorFormato {
	private String cveError;
	private String mensaje;
	private String mensajeOriginal;

	public static ErrorFormato crearErrorFormatoURI(String mensaje, String mensajeOriginal) {
		ErrorFormato error = new ErrorFormato();
		error.cveError = "INV001";
		error.mensaje = mensaje;
		error.mensajeOriginal = mensajeOriginal;
		return error;
	}

	public ErrorFormato() {
		super();
	}

	public String getCveError() {
		return cveError;
	}

	public void setCveError(String cveError) {
		this.cveError = cveError;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensajeOriginal() {
		return mensajeOriginal;
	}

	public void setMensajeOriginal(String mensajeOriginal) {
		this.mensajeOriginal = mensajeOriginal;
	}

	@Override
	public String toString() {
		return "ErrorFormato [cveError=" + cveError + ", mensaje=" + mensaje + ", mensajeOriginal=" + mensajeOriginal
				+ "]";
	}
}
