package com.pablomonteserin.login.google;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.pablomonteserin.ejercicios.R;

public class SecondActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
    private ImageView photoimageView1;
    private TextView nombreTextView;
    private TextView emailTextView;
    private TextView id;
    private GoogleApiClient googleApiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_google_second_activity);

        photoimageView1 = findViewById(R.id.photoImageView1);
        nombreTextView = findViewById(R.id.nombre);
        emailTextView = findViewById(R.id.email);
        id = findViewById(R.id.texto);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    public void desloguearse(View v){

    }

    @Override
    protected void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if(opr.isDone()){
            GoogleSignInResult result = opr.get();
            manejarResult(result);
        }else {
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {

                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    manejarResult(googleSignInResult);
                }
            });
        }
    }
    private void manejarResult(GoogleSignInResult result){
        if(result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            nombreTextView.setText(account.getDisplayName());
            emailTextView.setText(account.getEmail());
            id.setText(account.getId());
        }else{
            startActivity(new Intent(this, SecondActivity.class));
        }
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
