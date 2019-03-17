package br.com.higojo.util;

/**
 * 
 * Classe util
 * Para reutilização massiva
 * @author higojo
 *
 */
public class StringUtil {

	/**
	 * Método de validação de String aceitável
	 * @param value
	 * @return boolean
	 */
	public static boolean ok(String value) {
        return (value != null) && !(value.trim().isEmpty());
    }
}
