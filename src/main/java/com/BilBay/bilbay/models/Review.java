package com.BilBay.bilbay.models;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "reviews")
@Validated
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Review.class)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Ändrade här enligt överenskomlse - Johan
    @ManyToOne
    @JoinColumn(name = "users_id_by", referencedColumnName = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private User userBy; // Kan inte döpa den till user
    @Column(name = "comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "users_id_for", referencedColumnName = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private User userFor; // Kan inte döpa den till user
    @Range(min = 1, max = 5)
    @Column(name = "rate")
    private int rate;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;
    @Column(name = "updated_at")
    @CreationTimestamp
    private LocalDate updatedAt;


    public Review() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUserBy() {
        return userBy;
    }
    public void setUserBy(User userBy) {
        this.userBy = userBy;
    }
    public User getUserFor() {
        return userFor;
    }
    public void setUserFor(User userFor) {
        this.userFor = userFor;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getRate() {
        return rate;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
