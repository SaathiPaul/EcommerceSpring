package com.example.EcommerceSpring.entity;

import jakarta.persistence.*;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.intellij.lang.annotations.Identifier;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.Instant;

@MappedSuperclass   // Base class for entities, no table created
@EntityListeners(AuditingEntityListener.class)  // Enable automatic timestamps
@Getter
@Setter
public class BaseEntity {

    @Id      // Marks 'id' as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // Database will auto-generate the ID (auto-increment)
    private long id;

    @CreatedDate    // Marks this field to store the creation timestamp automatically
    @Column(nullable=false , updatable = false)   // Cannot be null, cannot be changed after creation
    private Instant createdAt;

    @LastModifiedDate         // Marks this field to store the last update timestamp automatically
    @Column(nullable = false)    // Cannot be null
    private Instant updatedAt;


    @PrePersist        // This method runs automatically just **before inserting a new row** in DB
    public void onCreate()
    {
        Instant now = Instant.now();    // get current time
        this.createdAt = now;           //set createdAt
        this.updatedAt = now;         // set updatedAt initially same as createdAt
    }

    @PreUpdate                 // This method runs automatically just **before updating a row** in DB
    public void onUpdate()
    {
        this.updatedAt = Instant.now();   // update updatedAt to current time
    }

}
