package ua.docs_task.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Document {

    @Id
    @Column(length = 50, nullable = false)
    private String id;

    @Column(length = 50, nullable = false)
    private String accountNumber;
    @Column(length = 50, nullable = false)
    private String currency;
    @Column(length = 50, nullable = false)
    private String productType;
    @Column(columnDefinition = "DECIMAL(8, 2)", nullable = false)
    private BigDecimal version;

    @Override
    public String toString() {
        return
                " Номер счета='" + accountNumber + '\'' +
                        ", Валюта='" + currency + '\'' +
                        ", Тип продукта='" + productType;
    }
}
