package org.grupouno.Parqueo_Is4Tech.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "detailRoleProfile")
@IdClass(DetailDTO.class)
public class DetailRoleProfile {
    @Id
    @Column(name = "id_profile")
    private long idProfile;
    @Id
    @Column(name = "id_role")
    private long idRole;
}
