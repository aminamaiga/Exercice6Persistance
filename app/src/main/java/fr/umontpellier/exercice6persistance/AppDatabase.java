package fr.umontpellier.exercice6persistance;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Utilisateur.class}, version = 5, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UtilisateurDao utilisateurDao();
}
