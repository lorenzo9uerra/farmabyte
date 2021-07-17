package it.farmabyte.app.model;
/*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "role")
@SQLDelete(sql = "UPDATE role SET deleted_date = NOW() WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause="deleted_date IS NULL")
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    @NotNull(message = "Il nome è obbligatorio")
    private String name;

    @ManyToMany
    @JoinTable(name = "security_activity_role",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "security_activity_id", referencedColumnName = "id"))
    @JsonIgnoreProperties("roles")
    private Set < SecurityActivity > securityActivities;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(uniqueConstraints= @UniqueConstraint(columnNames={"role_id","rules"}))
    private Set < String > rules;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

}*/