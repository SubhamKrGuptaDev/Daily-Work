package parking_lot.parking.com.model;

import java.util.UUID;

/**
 * Base model for add common attributes
 */
public abstract class BaseModel {

	private UUID id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
}
