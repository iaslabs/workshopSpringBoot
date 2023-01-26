package co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo;

public class ZoneDBO {

	private Long id;
	private String zoneName;

	public ZoneDBO(Long id, String zoneName) {
		this.id = id;
		this.zoneName = zoneName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
}
