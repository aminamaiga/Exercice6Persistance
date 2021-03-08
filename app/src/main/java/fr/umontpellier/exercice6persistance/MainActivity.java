package fr.umontpellier.exercice6persistance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editTexNom, editTextPrenom, editTextAge, editTextPhone;
     Button ajouter;
     private TextView tvListUser;
    StringBuilder   stringBuilder = new StringBuilder();

   //database
   AppDatabase appDatabase;
   UtilisateurDao utilisateurDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "rendez-vous").fallbackToDestructiveMigration()
                 .build();
         utilisateurDao = appDatabase.utilisateurDao();


        editTexNom = (EditText) findViewById(R.id.editext_nom);
        editTextPrenom = (EditText) findViewById(R.id.editext_prenom);
        editTextAge = (EditText) findViewById(R.id.editext_age);
        editTextPhone = (EditText) findViewById(R.id.editext_phone);
        ajouter = (Button)findViewById(R.id.ajouter);
        tvListUser = (TextView)findViewById(R.id.list_user);

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilisateur utilisateur = new Utilisateur(editTextPrenom.getText().toString(), editTexNom.getText().toString(),
                        Integer.parseInt(editTextAge.getText().toString()), editTextPhone.getText().toString());
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        utilisateurDao.ajouter(utilisateur);
                        List<Utilisateur> lUtilisateur = utilisateurDao.getAllUsers();

                        for (Utilisateur u: lUtilisateur) {
                            stringBuilder.append(u.getPrenom() + " " + u.getNom() + " "+ u.getAge() + " " + u.getPhone() + " ");
                        }
                    }
                });

                tvListUser.setText(stringBuilder.toString());
            }
        });

    }
}