package ua.docs_task.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class DocumentPackage {

    @Id
    @Column(length = 50, nullable = false)
    private String id;

    @Column(length = 50, nullable = false)
    private String documentTitle;
    @Column(length = 50, nullable = false)
    private String clientName;
    @Column(length = 50, nullable = false)
    private String inn;
    @Column(length = 50, nullable = false)
    private String passport;
    @Column(columnDefinition = "DECIMAL(8, 2)", nullable = false)
    private BigDecimal version;

    public DocumentPackage(@NotNull String id, @NotNull String documentTitle, @NotNull String clientName,
                           @NotNull String inn, @NotNull String passport, @NotNull BigDecimal version) {
        this.id = id;
        this.documentTitle = documentTitle;
        this.clientName = clientName;
        this.inn = inn;
        this.passport = passport;
        this.version = version;
    }

    @Override
    public String toString() {
        return
                "Наименование документа=" + documentTitle + "\n" +
                        "ФИО=" + clientName + "\n" +
                        "ИНН=" + inn + "\n" +
                        "Паспортные данные=" + passport;
    }
}

