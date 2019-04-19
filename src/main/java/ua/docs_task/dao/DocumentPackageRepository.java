package ua.docs_task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.docs_task.entity.DocumentPackage;

import java.util.List;

@Repository
public interface DocumentPackageRepository extends JpaRepository<DocumentPackage, String> {
    List<DocumentPackage> findByInn(String inn);
}
