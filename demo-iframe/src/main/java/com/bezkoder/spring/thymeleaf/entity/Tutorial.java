package com.bezkoder.spring.thymeleaf.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "tutorials")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Tutorial {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(length = 128, nullable = false)
  private String title;

  @Column(length = 256)
  private String description;

  @Column(nullable = false)
  private int level;

  @Column
  private boolean published;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private User user;

  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", title=" + title + ", description=" + description + ", level=" + level
        + ", published=" + published + "]";
  }
}
