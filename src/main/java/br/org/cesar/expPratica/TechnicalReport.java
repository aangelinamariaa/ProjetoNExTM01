package br.org.cesar.expPratica;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "technicalReport")
public class TechnicalReport {
	@Id
	@Column(name = "id")
	private long id;

	@NotBlank
	@Column(name = "name")
    private String name;

	@NotBlank
	@Column(name = "equipment")
    private String equipment;

	@NotBlank
	@Column(name = "defect")
    private String defect;

	@NotBlank
	@Column(name = "description")
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

	@Override
	public String toString() {
		return "Id - " + id + "\n"
				+ "Nome - " + name + "\n"
				+ "Equipamento - " + equipment + "\n"
				+ "Defeito - " + defect + "\n"
				+ "Parecer - " + description;
	}

}
