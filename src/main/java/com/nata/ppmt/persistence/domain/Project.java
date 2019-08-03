package com.nata.ppmt.persistence.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Project name is required")
    private String projectName;
    @NotBlank(message = "Project Identifier is required")
    @Size(min = 4, max = 5, message = "please use 4 to 5 characters")
    @Column(unique = true, updatable = false)
    private String projectIdentifier;
    @NotBlank(message = "Project description is required")
    private String description;
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Date endDate;

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
