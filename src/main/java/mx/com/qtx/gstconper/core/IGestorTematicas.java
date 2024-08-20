package mx.com.qtx.gstconper.core;

import java.util.List;

import mx.com.qtx.gstconper.entidades.TematicaPersona;

public interface IGestorTematicas {
	List<TematicaPersona> getTematicasXpersona(int numPersona);
}
