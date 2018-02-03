package com.ricoaw.entity;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by rico on 2/1/2018.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel implements Comparable<BaseModel>, Serializable {

    private static final long serialVersionUID = -5766564887046282213L;

    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "idgen")
    @Column(name = "id")
    private String id;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated;

    @PrePersist
    public void prePersist(){
        created = updated = new Date();
    }

    @PreUpdate
    public void preUpdate(){
        updated = new Date();
    }

    @Override
    public int compareTo(@NotNull BaseModel o) {
        return this.getId().compareTo(o.getId());
    }

    @Override
    public boolean equals(Object other) {
        return !(other == null || other.getClass() != this.getClass()) && this.getId().equals(((BaseModel) other).getId());

    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).toHashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return created;
    }

    public void setCreatedAt(Date createdAt) {
        this.created = createdAt;
    }

    public Date getUpdatedAt() {
        return updated;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updated = updatedAt;
    }

}
