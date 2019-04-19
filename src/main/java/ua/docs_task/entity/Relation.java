package ua.docs_task.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public class Relation {

    @Id
    @Column(length = 50, nullable = false)
    private String id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "child_component")
    private Document document;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_component")
    private DocumentPackage packages;

    public Relation(@NotNull String id, Document document, DocumentPackage packages) {
        this.id = id;
        this.document = document;
        this.packages = packages;
    }
}
