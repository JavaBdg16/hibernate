package entity;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 20)
    private String name;

    // @Transient
    private String description;

    @Column(nullable = false)
    // TODO:  do zbadania
    @ColumnDefault("1.00")
    private BigDecimal price  = new BigDecimal(1.0);

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date date;

    @Temporal(TemporalType.TIME)
    @CreationTimestamp
    private Date time;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date timestamp;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    public void setName(String name) {
        this.name = name;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
