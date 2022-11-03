package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "recovery_room_types")
public class RecoveryRoomType {
    @NotEmpty
    @Size(min = 5, max = 50)
    String name;
}
