package com.incentives.piggyback.user.model;

import com.incentives.piggyback.user.util.Roles;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.tools.ISupportsMessageContext;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.security.RolesAllowed;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

import java.lang.annotation.Target;

import static com.incentives.piggyback.user.util.Roles.PARTNER_API_USER;
import static com.incentives.piggyback.user.util.Roles.PIGGY_USER;
import static org.springframework.integration.graph.LinkNode.Type.error;

@Entity
@Table(name= "users" ,schema = "database1")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Size(min=2,max=30)
    @NotBlank(message = "First Name is mandatory")
    private String first_name;

    @Size(max=30)
    @Column(name="last_name")
    private String last_name;

    @NotBlank(message = "Password is mandatory")
    @Column(name="user_password")
    private String user_password;

    @Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\\\s\\\\./0-9]*$")
    @NotBlank(message = "Mobile Number is mandatory")
    @Column(name="mobile_number")
    private String mobile_number;

    @Column(name="mobile_verified")
    private Boolean mobile_verified;

    @Email
    @NotBlank(message = "User email is mandatory")
    @Column(name="user_email")
    private String user_email;

    @Column(name="user_interests")
    private String user_interests;

    @Column(name="user_role")
    private Roles user_role;

    @Column(name="user_type")
    private String user_type;

    @NotBlank(message = "device Id is mandatory")
    @Column(name="device_id")
    private String device_id;

}