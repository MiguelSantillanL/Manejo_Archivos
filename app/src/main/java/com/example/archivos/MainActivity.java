package com.example.archivos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {
    private EditText et_Text;
    private  String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_Text = findViewById(R.id.et_Text);
    }

    public void BotonGuardar(View view){

        try{ //Para crear un archivo de texto usamos el metodo openFileOutput, el cual nos regresa un objeto de clase FileOutputStream
            FileOutputStream archivoSalida = openFileOutput("Datos.txt", MODE_PRIVATE);
            //Para facilitar la escritura en el archivo de salida, utilizamos otra clase llamada OutputStreamWriter
            OutputStreamWriter outputText = new OutputStreamWriter(archivoSalida);
            text = et_Text.getText().toString(); //recuperar texto escrito en el editText
            outputText.write(text); //Escribir el texto en el archivo
            //Una vez que ya no requerimos escribir, cerramos el archivo
            outputText.close();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Ocurrio una EXEPCION");
        }
    }

    public void btn_Read(View view){
        try {//Para Leer un archivo desde el el sistema en el almacenamiento interno
            //usamos openFileInput, el cual nos regresa un objeto de la clase FileInputSream
            FileInputStream archivoDeLectura = openFileInput("Datos.txt");
            //Para facilitar la lectura del archivo de entrada usamos la clase llamada InputStreamReader
            InputStreamReader textoEntrada = new InputStreamReader(archivoDeLectura);
            BufferedReader bufferEntrada = new BufferedReader(textoEntrada);
            //Leer linea por linea el texto del archivo
            text = bufferEntrada.readLine(); //Si no hay mas lineas de texto en el archivo regresa NULL
            et_Text.setText(text);
            //Al finalizar la lectura cerramos
            textoEntrada.close();

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Ocurrio una EXEPCION");
        }
    }
}//FIN DE LA CLASE MAIN