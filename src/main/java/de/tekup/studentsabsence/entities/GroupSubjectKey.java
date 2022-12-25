package de.tekup.studentsabsence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupSubjectKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "group_id")
	private Long groupId;
	@Column(name = "subject_id")
	private Long subjectId;
}
