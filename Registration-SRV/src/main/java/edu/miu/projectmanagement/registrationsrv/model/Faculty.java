package edu.miu.projectmanagement.registrationsrv.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@DiscriminatorValue("User_Faculty")
@NoArgsConstructor
public class Faculty extends User{

}
