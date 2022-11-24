package br.org.cesar.expPratica;

public class TechnicalReport {

    private Long id;
    private String name;
    private String equipment;
    private String defect;
    private String description;

    public TechnicalReport() {
    }

    public TechnicalReport(Long id, String name, String equipment, String defect, String description) {
		this.id = id;
		this.name = name;
		this.equipment = equipment;
		this.defect = defect;
		this.description = description;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getDefect() {
		return defect;
	}

	public void setDefect(String defect) {
		this.defect = defect;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
