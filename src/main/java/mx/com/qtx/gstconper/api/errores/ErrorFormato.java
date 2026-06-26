package mx.com.qtx.gstconper.api.errores;

public class ErrorFormato extends Error {

	private String mensaje;
	private String mensajeOriginal;

	public static ErrorFormato crearErrorFormatoURI(String mensaje, String mensajeOriginal) {
		ErrorFormato error = new ErrorFormato(Error.ERROR_FORMATO);
		error.mensaje = mensaje;
		error.mensajeOriginal = mensajeOriginal;
		return error;
	}

	public ErrorFormato(String cveError) {
		super(cveError);
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
		return "ErrorFormato [cveError=" + super.getCveError() + ", mensaje=" + mensaje + ", mensajeOriginal=" + mensajeOriginal
				+ "]";
	}
}
