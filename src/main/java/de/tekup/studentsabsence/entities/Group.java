package de.tekup.studentsabsence.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import de.tekup.studentsabsence.enums.LevelEnum;
import de.tekup.studentsabsence.enums.SpecialityEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "students")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_group")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Name is required")
	private String name;
	@NotBlank(message = "Label is required")
	private String label;
	@Enumerated(EnumType.STRING)
	private LevelEnum level;
	@NotNull(message = "Speciality is required")
	@Enumerated(EnumType.STRING)
	private SpecialityEnum speciality;
	// TODO Complete Relations with other entities

	@OneToMany(mappedBy = "group")
	private List<Student> students;
	
	@OneToMany(mappedBy = "subject")
	private List<GroupSubject> groupSubjects;

}
