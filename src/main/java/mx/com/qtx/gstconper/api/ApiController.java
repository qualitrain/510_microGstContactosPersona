package mx.com.qtx.gstconper.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import mx.com.qtx.gstconper.core.IGestorTematicas;
import mx.com.qtx.gstconper.entidades.TematicaPersona;

@RestController
public class ApiController {
	@Autowired
	private IGestorTematicas gestorTematicas;
	
	@GetMapping(path = "/tematicas/{numPersona}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TematicaPersona> getTematicas(@PathVariable int numPersona){
		return this.gestorTematicas.getTematicasXpersona(numPersona);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorFormato> manejarErrores(
			MethodArgumentTypeMismatchException matmex){
		ErrorFormato err = ErrorFormato.crearErrorFormatoURI("Invocación con argumentos erróneos", 
				                                              matmex.getMessage());
		return new ResponseEntity<ErrorFormato>(err,HttpStatus.NOT_ACCEPTABLE);
		
	}

}
