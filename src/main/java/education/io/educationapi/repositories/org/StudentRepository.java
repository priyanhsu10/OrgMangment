package education.io.educationapi.repositories.org;

import education.io.educationapi.entities.org.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
  @Query("Select s from Student s where s.organization.id=:orgId")
    List<Student> getByOrganizationId(int orgId);
  @Query("Select s from Student s where s.standardsClass.id=:classId")
  List<Student> getByClassId(int classId);
  @Query("Select s from Student s where s.standard.id=:standardId")
  List<Student> getByStandardId(int standardId);
  @Query("Select count(s.id) from Student s where s.organization.id=:orgId")
  Integer getCountByOrganizationId(int orgId);
  @Query("Select count(s.id) from Student s where s.standardsClass.id=:classId")
  Integer getCountByClassId(int classId);
  @Query("Select count(s.id) from Student s where s.standard.id=:standardId")
  Integer getCountByStandardId(int standardId);
}
