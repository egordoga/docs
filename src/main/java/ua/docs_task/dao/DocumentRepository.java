package ua.docs_task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.docs_task.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {
}
