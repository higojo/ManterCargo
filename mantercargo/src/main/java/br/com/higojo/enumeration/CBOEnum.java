package br.com.higojo.enumeration;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author higojo
 * Enum de CBOs
 *
 */
public enum CBOEnum {
	A, B, C, D;
	
	/**
	 * Adiciona valores do Enum numa lista e retorna
	 * @return List<String>
	 */
	public static List<String> valores() {
		List<String> valores = new ArrayList<>();
		for(CBOEnum item : CBOEnum.values()) {
			valores.add(item.toString());
		}
		return valores;
	}
}
