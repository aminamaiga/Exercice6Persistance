package fr.umontpellier.exercice6persistance;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao

public interface UtilisateurDao {

    @Insert
    void ajouter(Utilisateur utilisateur);

    @Query("SELECT * FROM utilisateur")
    List<Utilisateur> getAllUsers();
}
