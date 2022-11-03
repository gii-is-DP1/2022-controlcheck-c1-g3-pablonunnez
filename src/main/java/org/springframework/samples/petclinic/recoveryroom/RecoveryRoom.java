package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.NamedEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "recovery_rooms")
public class RecoveryRoom extends NamedEntity {
    @NotEmpty
    @Size(min = 3, max = 50)
    String name;
    @PositiveOrZero
    double size;
    @NotNull
    boolean secure;
    @Transient
    RecoveryRoomType roomType;
}
