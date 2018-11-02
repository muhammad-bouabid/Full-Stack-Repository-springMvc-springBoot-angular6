/**
 * 
 */
package com.backend.dto.message;

import java.io.Serializable;

/**
 * @author m.bouabid
 *
 */
public class MessageDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5795214255452382434L;
	private String message;

	public MessageDto(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
