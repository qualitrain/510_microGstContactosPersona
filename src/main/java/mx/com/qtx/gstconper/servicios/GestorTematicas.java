package mx.com.qtx.gstconper.servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import mx.com.qtx.gstconper.api.ErrorNegocio;
import mx.com.qtx.gstconper.core.NegocioException;
import org.springframework.stereotype.Service;

import mx.com.qtx.gstconper.core.IGestorTematicas;
import mx.com.qtx.gstconper.entidades.TematicaPersona;

@Service
public class GestorTematicas implements IGestorTematicas {
	private static Map<Integer,TematicaPersona> mapTematicas = crearTematicas();
	
	public List<TematicaPersona> getTematicasXpersona(int numPersona){
		if(this.personaExiste(numPersona) == false){
			throw NegocioException.crearExceptionPersonaRequerida(numPersona);
		}
		return mapTematicas.values()
				           .stream()
				           .filter(v -> v.getNumPersona() == numPersona)
				           .collect(Collectors.toList());
	}

	@Override
	public boolean personaExiste(int numPersona) {
		long nTematicasPersona = mapTematicas.values()
											.stream()
											.filter(v->v.getNumPersona() == numPersona)
											.count();
		if(nTematicasPersona == 0)
			return false;
		else
			return true;
	}

	private static Map<Integer, TematicaPersona> crearTematicas() {
		Map<Integer,TematicaPersona> mTematicas = new HashMap<>();
		mTematicas.put(1,new TematicaPersona("Auditoria","Auditoría y Gobierno Corporativo",1,1));
		mTematicas.put(2,new TematicaPersona("Acuario","Proyecto Acuario",1,2));
		mTematicas.put(3,new TematicaPersona("Compras","Portal de Compras",1,3));
		mTematicas.put(4,new TematicaPersona("Servicio","Servicio al cliente",1,4));
		mTematicas.put(5,new TematicaPersona("Buen Fin","Iniciativa Buen Fin 2026",2,5));
		mTematicas.put(6,new TematicaPersona("C.Sureste","Campaña Sureste",2,6));
		mTematicas.put(7,new TematicaPersona("M. Izt","Proyecto Mercado Iztapalapa",2,7));
		mTematicas.put(8,new TematicaPersona("Ventas","Avances comerciales",2,8));
		mTematicas.put(9,new TematicaPersona("Servicio","Servicio al cliente",3,4));
		mTematicas.put(10,new TematicaPersona("Buen Fin","Iniciativa Buen Fin 2026",3,5));
		mTematicas.put(11,new TematicaPersona("C.Sureste","Campaña Sureste",3,6));
		return mTematicas;
	}
}
