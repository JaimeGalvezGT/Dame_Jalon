package com.example.dame_jalon;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnIngresar;
    private EditText txtUsuario;
    private EditText txtPassword;
    private TextView txtRecuperar;
    private TextView txtRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtUsuario = findViewById(R.id.txtCorreo);
        txtPassword = findViewById(R.id.txtPassword);
        btnIngresar = findViewById(R.id.btnIngresar);
        txtRecuperar = findViewById(R.id.txtRecuperar);
        txtRegistrar = findViewById(R.id.registrar);


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String usuario = txtUsuario.getText().toString();
                String password = txtPassword.getText().toString();


                if(usuario.equals("galvezjaime419@gmail.com") && password.equals("admin")){

                    Intent navegacion = new Intent(MainActivity.this, menu.class);
                    startActivity(navegacion);

                }

                else {
                    Toast msjError = Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrectos", Toast.LENGTH_SHORT);
                    msjError.setGravity(Gravity.CENTER, 0, 0);
                    msjError.show();
                }


            }
        });

        txtRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navegacion2 = new Intent(MainActivity.this, recuperar.class);
                startActivity(navegacion2);

            }
        });

        txtRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navegacion3 = new Intent(MainActivity.this, registrar.class);
                startActivity(navegacion3);

            }
        });





    }
}
