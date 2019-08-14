package com.codingdojo.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "language")
public class Languages {
	public String getLanguage_name() {
        return language_name;
    }

    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Size(min = 2, max = 20)
    private String language_name;

    @Column
    @Size(min = 4, max = 20)
    private String creator;
    @Column
    @Size(max = 20)
    private String version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date created_at;

    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updated_at;


    public String getName() {
        return language_name;
    }

    public void setName(String language_name) {
        this.language_name = language_name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getVersion() {
        return version;
    }

    @PrePersist
    protected void onCreate(){
        this.created_at = new Date();

    }
    @PreUpdate
    protected void onUpdate(){
        this.updated_at = new Date();
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public Languages(){}
    public Languages(String language_name, String creator, String version){
        this.creator = creator;
        this.language_name = language_name;
        this.version = version;
    }

}
