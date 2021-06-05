package edu.integrador2.serviciosgenerales.entity;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationToken {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long idUser;
  private Long role;
  private String token;
  private LocalDate addDate;

  ConfirmationToken(Especialista especialista) {
    this.addDate = LocalDate.now();
    this.token = UUID.randomUUID().toString();
  }
}
