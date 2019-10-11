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
                Intent navegacion = new Intent(MainActivity.this, menu.class);
                usuario user = validarLogin();
                if(user != null){
                    if(user.getFK_estado() == 0){
                        Toast.makeText(MainActivity.this, "Usuario inactivo", Toast.LENGTH_LONG).show();
                    } else if(user.getFK_rol() == 1 && user.getFK_estado() == 1){
                        startActivity(navegacion);
                    } else if(user.getFK_rol() == 2 && user.getFK_estado() == 1){
                        startActivity(navegacion);
                    }
                } else{
                    Toast.makeText(MainActivity.this, "Usuario y/o contraseña incorrectos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    //Funcion que establece la conexion con la base de datos y retorna un objeto de tipo usuario
    public usuario validarLogin(){
        //Variable que almacenará el resultado de la consulta
        usuario usuario = null;
        //Asignamos el driver de conexion
        String driver = "com.mysql.jdbc.Driver";
        try{
            //Cargamos el driver con el conector jdbc
            Class.forName(driver).newInstance();
            usuario user = new usuario(txtUsuario.getText().toString(), txtPassword.getText().toString(), "", "","", 0, 0);
            usuario = new Login().execute(user).get();
        } catch(Exception ex){
            Toast.makeText(MainActivity.this, "Error al conectarse a la BD" + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        return usuario;
    }
}
