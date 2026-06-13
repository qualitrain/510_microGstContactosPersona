package mx.com.qtx.gstconper.api;

public class ErrorNegocio {
    public static final int SE_REQUIERE_PERSONA_EXISTENTE = 10001;

    private String error;
    private String regla;

    public ErrorNegocio(String error, String regla) {
        this.error = error;
        this.regla = regla;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getRegla() {
        return regla;
    }

    public void setRegla(String regla) {
        this.regla = regla;
    }

    @Override
    public String toString() {
        return "ErrorNegocio{" +
                " error='" + error + '\'' +
                ", regla='" + regla + '\'' +
                '}';
    }

    public static ErrorNegocio crearErrorNegocio(String msj, String regla){
        return new ErrorNegocio(msj,regla);
    }
}
