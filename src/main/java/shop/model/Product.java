package shop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@ToString(of = {"id", "label", "description"})
@EqualsAndHashCode(of = {"id"})
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String label;
    private String description;
    private String organization;
    private float price;
    private int quantity;
    private String discountInformation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Review> productReviews;

    @Column(updatable = false)
    private LocalDateTime creationTime;

}
