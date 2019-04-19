package ua.docs_task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.docs_task.dao.DocumentPackageRepository;
import ua.docs_task.dao.DocumentRepository;
import ua.docs_task.dao.RelationRepository;
import ua.docs_task.entity.Document;
import ua.docs_task.entity.DocumentPackage;
import ua.docs_task.entity.Relation;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceDB implements IServiceDB {

    private final DocumentPackageRepository documentPackageRepository;
    private final DocumentRepository documentRepository;
    private final RelationRepository relationRepository;

    @Autowired
    public ServiceDB(DocumentPackageRepository documentPackageRepository, DocumentRepository documentRepository, RelationRepository relationRepository) {
        this.documentPackageRepository = documentPackageRepository;
        this.documentRepository = documentRepository;
        this.relationRepository = relationRepository;
    }

    @Override
    public void printPackages(String inn) {
        List<DocumentPackage> documentPackages = documentPackageRepository.findByInn(inn);
        if (documentPackages.size() > 0) {
            for (DocumentPackage documentPackage : documentPackages) {
                System.out.println(documentPackage);
                List<Relation> relations = relationRepository.findAllByPackages_Id(documentPackage.getId());
                for (Relation relation : relations) {
                    System.out.println(relation.getDocument());
                }
                System.out.println("------------");
            }
        } else {
            System.out.println("Клиент с таким ИНН отсутствует");
        }
    }

    @Override
    public void upVersion(String docPackageId) {
        String clientNameNew = "Orest";  //Это новые данные. Они могут приходить откуда угодно.
        String passportNew = "5555";    // Можно задать в параметрах метода. Это не важно, поэтому так.

        DocumentPackage fromDB = documentPackageRepository.findById(docPackageId).orElse(null);
        DocumentPackage docPackageCopy;
        if (fromDB != null) {
            docPackageCopy = new DocumentPackage(UUID.randomUUID().toString(), fromDB.getDocumentTitle(),
                    fromDB.getClientName(), fromDB.getInn(), fromDB.getPassport(), fromDB.getVersion());
            fromDB.setClientName(clientNameNew);
            fromDB.setPassport(passportNew);
            fromDB.setVersion(fromDB.getVersion().add(BigDecimal.ONE));
            documentPackageRepository.save(fromDB);
            documentPackageRepository.save(docPackageCopy);

            List<Relation> relations = relationRepository.findAllByPackages_Id(fromDB.getId());
            for (Relation relation : relations) {
                Document document = relation.getDocument();
                document.setVersion(document.getVersion().add(BigDecimal.ONE));
                Relation newRelation = new Relation(UUID.randomUUID().toString(), document, docPackageCopy);
                relationRepository.save(newRelation);
                documentRepository.save(document);
            }
            checkChange();
        }
    }

    // Для бстрой проверки изменений
    private void checkChange() {
        DocumentPackage doc = documentPackageRepository.findById("a1").orElse(null);
        if (doc != null) {
            System.out.println("NAME: " + doc.getClientName());
            System.out.println("PASSPORT: " + doc.getPassport());
            System.out.println("VERSION: " + doc.getVersion());

            List<Relation> relations = relationRepository.findAllByPackages_Id("a1");
            for (Relation relation : relations) {
                Document document = relation.getDocument();
                System.out.println("VERSION OF DOCUMENT: " + document.getVersion());
            }

            System.out.println("SIZE OF RELATION TABLE  " + relationRepository.findAll().size()); // должно быть 12. 9 записей в таблице + 3 изменились
        }
    }
}
