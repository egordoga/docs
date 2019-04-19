package ua.docs_task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.docs_task.entity.Relation;

import java.util.List;

@Repository
public interface RelationRepository extends JpaRepository<Relation, String> {
    List<Relation> findAllByPackages_Id(String id);
}
