package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.DetailsService;
import services.ServiceBuilder2;

public class MainActivity extends AppCompatActivity {
    private EditText editTextFirstName, editTextLastName,
    editTextEmail, editTextGitHublink;
    Context context = this;
    private Button btnSubmit;
    private View mView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mView = findViewById(R.id.view);
        editTextFirstName = findViewById(R.id.edit_text_firstname);
        editTextLastName = findViewById(R.id.edit_text_lastname);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextGitHublink = findViewById(R.id.edit_text_project_link);
        btnSubmit = findViewById(R.id.button);
        ImageView btnGoback = findViewById(R.id.bck_button);


        btnSubmit.setOnClickListener(view -> {
            if(!detailIsEmpty()) {
                hideView();
                showDialog();


            } else {
                Toast.makeText(getApplicationContext(),"Fill all fields", Toast.LENGTH_SHORT).show();
            }

        });

        btnGoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });






    }

    private Boolean detailIsEmpty () {
        if(!editTextFirstName.getText().toString().equals("") &&
                !editTextLastName.getText().toString().equals("") &&
                !editTextEmail.getText().toString().equals("") &&
                !editTextGitHublink.getText().toString().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private void putDetail () {
        DetailsService detailsService = ServiceBuilder2.buildService(DetailsService.class);
        Call<Void> createRequest = detailsService.createDetail(
                editTextEmail.getText().toString(),
                editTextFirstName.getText().toString(),
                editTextLastName.getText().toString(),
                editTextGitHublink.getText().toString()
        );

        createRequest.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                // Dialog Success
                showDialogSuccessful();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Dialog Failure
                   showDialogUnsuccessful();

            }
        });
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(context);

        dialog.setContentView(R.layout.dialog_fragment_show);
        Button button =  dialog.findViewById(R.id.btn_confirm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               putDetail();
               dialog.dismiss();
            }
        });
        ImageView imgDismiss = dialog.findViewById(R.id.img_dialog_dismiss);
        imgDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                showView();
            }
        });
        dialog.show();
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                showView();
            }
        });

    }
    private void showDialogSuccessful() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_show_successful);
        dialog.show();
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                showView();
            }
        });
    }
    private void showDialogUnsuccessful() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_show_unsuccessful);
        dialog.show();
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                showView();
            }
        });
    }
    private void hideView() {
        mView.setVisibility(View.VISIBLE);
        btnSubmit.setVisibility(View.INVISIBLE);
        editTextGitHublink.setVisibility(View.INVISIBLE);
        editTextEmail.setVisibility(View.INVISIBLE);
        editTextLastName.setVisibility(View.INVISIBLE);
        editTextFirstName.setVisibility(View.INVISIBLE);

    }
    private void showView() {
        mView.setVisibility(View.INVISIBLE);
        btnSubmit.setVisibility(View.VISIBLE);
        editTextGitHublink.setVisibility(View.VISIBLE);
        editTextEmail.setVisibility(View.VISIBLE);
        editTextLastName.setVisibility(View.VISIBLE);
        editTextFirstName.setVisibility(View.VISIBLE);
    }


}