package com.example.platypie_darkboard.backend_communication;

import android.os.Bundle;
import android.widget.TextView;

import com.example.platypie_darkboard.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BackendViewModel extends AppCompatActivity {
    private TextView textViewJsonTest;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.fragment_main);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://main.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        JsonDarkBoardAPI jsonDarkBoardAPI = retrofit.create(JsonDarkBoardAPI.class);

        Call<List<User>> call = jsonDarkBoardAPI.getTestString();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (!response.isSuccessful()) {
                    textViewJsonTest.setText("Code: " + response.code());
                    return;
                }

                List<User> users = response.body();

                for (User user : users) {
                    String content = "";
                    content += "Name: " + user.getName() + "\n";
                    content += "Hashed Pass: " + user.getHashedPassword() + "\n";
                    content += "User Type: " + user.getAccountType() + "\n";
                    content += "Text: " + user.getText() + "\n\n";

                    textViewJsonTest.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                textViewJsonTest.setText((t.getMessage()));

            }
        });
    }
}
