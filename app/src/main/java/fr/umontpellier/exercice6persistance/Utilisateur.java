package fr.umontpellier.exercice6persistance;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Utilisateur {

    public Utilisateur(){}
    public Utilisateur(String prenom, String nom, int age, String phone){
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.phone = phone;
    }
    @PrimaryKey
    public  Integer id;
    @ColumnInfo(name = "prenom")
    String prenom;
    @ColumnInfo(name = "nom")
    String nom;
    @ColumnInfo(name = "age")
    Integer age;
    @ColumnInfo(name = "phone")
    String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

