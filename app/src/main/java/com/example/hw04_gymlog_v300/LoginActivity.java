package com.example.hw04_gymlog_v300;

import android.content.Context;
import android.content.Intent;
<<<<<<< HEAD
=======
import android.content.SharedPreferences;
>>>>>>> ea1f6e9bbdb3754b4482c53886d5911eb7c2b88c
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

<<<<<<< HEAD
import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LiveData;

import com.example.hw04_gymlog_v300.Database.GymLogRepository;
import com.example.hw04_gymlog_v300.Database.entities.User;
import com.example.hw04_gymlog_v300.databinding.ActivityLoginBinding;

=======

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.example.hw04_gymlog_v300.database.GymLogRepository;
import com.example.hw04_gymlog_v300.database.entities.User;
import com.example.hw04_gymlog_v300.databinding.ActivityLoginBinding;


>>>>>>> ea1f6e9bbdb3754b4482c53886d5911eb7c2b88c
public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private GymLogRepository repository;

<<<<<<< HEAD



=======
>>>>>>> ea1f6e9bbdb3754b4482c53886d5911eb7c2b88c
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = GymLogRepository.getRepository(getApplication());

<<<<<<< HEAD


        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               verifyUser();
            }
        });

=======
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyUser();
            }
        });
>>>>>>> ea1f6e9bbdb3754b4482c53886d5911eb7c2b88c
    }

    private void verifyUser(){
        String username = binding.userNameLoginEditText.getText().toString();
        if(username.isEmpty()){
<<<<<<< HEAD
            toastMaker("Username should not be blank");
=======
            toastMaker("Username may not be blank.");
>>>>>>> ea1f6e9bbdb3754b4482c53886d5911eb7c2b88c
            return;
        }
        LiveData<User> userObserver = repository.getUserByUserName(username);
        userObserver.observe(this, user -> {
<<<<<<< HEAD
            if(user != null) {
                String password = binding.passwordLoginEditText.getText().toString();
                if (password.equals(user.getPassword())) {
                    startActivity(MainActivity.mainActivityIntentFactory(getApplicationContext(), user.getId()));
                } else {
                    toastMaker("Invalid password");
                    binding.passwordLoginEditText.setSelection(0);
                }
            } else {
                toastMaker(String.format("%s is not a valid username. ", username));
                binding.userNameLoginEditText.setSelection(0);
            }
        });


    }

    private void toastMaker(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }



    static Intent loginIntentFactory(Context context) {
        return new Intent(context, LoginActivity.class);

    }
}
=======
            if(user != null){
                String password = binding.passwordLoginEditText.getText().toString();
                if(password.equals(user.getPassword())){
                    startActivity(MainActivity.mainActivityIntentFactory(getApplicationContext(), user.getId()));
                }else{
                    toastMaker("Invalid password.");
                    binding.passwordLoginEditText.setSelection(0);
                }
            } else {
                toastMaker(String.format("%s is not a valid username", username));
                binding.userNameLoginEditText.setSelection(0);
            }
        });
    }

    private void toastMaker(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    static Intent loginIntentFactory(Context context){
        return new Intent(context, LoginActivity.class);
    }
}

>>>>>>> ea1f6e9bbdb3754b4482c53886d5911eb7c2b88c
