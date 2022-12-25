package de.tekup.studentsabsence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.tekup.studentsabsence.entities.Group;
import de.tekup.studentsabsence.entities.GroupSubject;
import de.tekup.studentsabsence.entities.GroupSubjectKey;

public interface GroupSubjectRepository extends CrudRepository<GroupSubject, GroupSubjectKey> {
	List<GroupSubject> findAllByGroup(Group id);
	/// TODO create a methode to find a groupSubject by Group Id and Subject Id

	GroupSubject findByGroupIdAndSubjectId(Long groupId, Long subjectId);

}
