package com.example.University.Portal.Database_Connection;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "admin_info")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class AdminInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String adminId;

    @NonNull
    private String name;

    @NonNull
    private String phoneNo;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    LoginInfo loginInfo;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "joining_year")
    private int joiningYear;
}
