package com.example.samirvega.practica1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText arribaidIn,abajoidIn;//Para el ingreso de datos
    TextView areaidR,perimetroidR,volumenidR;//para la salida de datos
    TextView areaidT,perimetroidT,volumenidT;//Para los textos de la salida
    RadioButton cuadroid,trianguloid,circuloid,cuboid;//seleccion de los radiobutton
    Button calcularid;
    String auxTexto1="",auxTexto2="",auxTexto3="";//para guardar los textos mientras se hacen calculos
    double data1=0,data2=0,data3=0;//guarda los valores double de los datos ingresados
    int dirRadiobutton=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Entradas
        arribaidIn= findViewById(R.id.arribaidIn);
        abajoidIn=findViewById(R.id.abajoidIn);
        //Resultados
        areaidT=findViewById(R.id.areaidT);
        perimetroidT=findViewById(R.id.perimetroidT);
        volumenidT=findViewById(R.id.volumenidT);
        areaidR=findViewById(R.id.areaidR);
        perimetroidR=findViewById(R.id.perimetroidR);
        volumenidR=findViewById(R.id.volumenidR);
        //Radiobutons
        cuadroid=findViewById(R.id.cuadroid);
        trianguloid=findViewById(R.id.trianguloid);
        circuloid=findViewById(R.id.circuloid);
        cuboid=findViewById(R.id.cuboid);
        //boton calcular
        calcularid=findViewById(R.id.calcularid);
    }

    //Este bloque controla la visibilidad de los texview y los edirtext
    public void onRadioButtonClicked(View view) {
        dirRadiobutton=view.getId();
        switch (dirRadiobutton) {

            case R.id.cuadroid:
                arribaidIn.setText("");
                arribaidIn.setHint("Ingrese un lado del cuadrado");
                //control de visualizacion de las entradas
                arribaidIn.setVisibility(View.VISIBLE);
                abajoidIn.setVisibility(View.INVISIBLE);
                //control de la visualizacion de las salidas
                areaidR.setVisibility(View.VISIBLE);
                perimetroidR.setVisibility(View.VISIBLE);
                volumenidR.setVisibility(View.INVISIBLE);
                areaidT.setVisibility(View.VISIBLE);
                perimetroidT.setVisibility(View.VISIBLE);
                volumenidT.setVisibility(View.INVISIBLE);
                break;

            case R.id.circuloid:
                arribaidIn.setText("");
                arribaidIn.setHint("Ingrese el radio del circulo");
                //control de visualizacion de las entradas
                arribaidIn.setVisibility(View.VISIBLE);
                abajoidIn.setVisibility(View.INVISIBLE);
                //control de visualizacion de las salidas
                areaidR.setVisibility(View.VISIBLE);
                perimetroidR.setVisibility(View.VISIBLE);
                volumenidR.setVisibility(View.INVISIBLE);
                areaidT.setVisibility(View.VISIBLE);
                perimetroidT.setVisibility(View.VISIBLE);
                volumenidT.setVisibility(View.INVISIBLE);
                break;

            case R.id.trianguloid:
                arribaidIn.setText("");
                abajoidIn.setText("");
                arribaidIn.setHint("Ingrese la base del triangulo");
                abajoidIn.setHint("Ingrese la altura del triangulo");
                //control de visualizacion de las entradas
                arribaidIn.setVisibility(View.VISIBLE);
                abajoidIn.setVisibility(View.VISIBLE);
                //control de visualizacion de las salidas
                areaidR.setVisibility(View.VISIBLE);
                perimetroidR.setVisibility(View.VISIBLE);
                volumenidR.setVisibility(View.INVISIBLE);
                areaidT.setVisibility(View.VISIBLE);
                perimetroidT.setVisibility(View.VISIBLE);
                volumenidT.setVisibility(View.INVISIBLE);
                break;

            case R.id.cuboid:
                arribaidIn.setText("");
                arribaidIn.setHint("Ingrese un lado del cubo");
                //control de visualizacion de las entradas
                arribaidIn.setVisibility(View.VISIBLE);
                abajoidIn.setVisibility(View.INVISIBLE);
                //control de la visualizacion de las salidas
                areaidR.setVisibility(View.VISIBLE);
                perimetroidR.setVisibility(View.VISIBLE);
                volumenidR.setVisibility(View.VISIBLE);
                areaidT.setVisibility(View.VISIBLE);
                perimetroidT.setVisibility(View.VISIBLE);
                volumenidT.setVisibility(View.VISIBLE);
                break;
        }
    }


    public void BotonCalcular(View view) {
        switch (dirRadiobutton) {

            case R.id.cuadroid:
                if (!TextUtils.isEmpty(arribaidIn.getText().toString())) {

                    try {
                        auxTexto1 = arribaidIn.getText().toString();
                        data1 = Double.parseDouble(auxTexto1);
                        data2=data1*4;//Calculo del perimetro
                        data1 = data1 * data1;//calculo del area
                        auxTexto2 = String.valueOf(data2);
                        auxTexto1 = String.valueOf(data1);
                        areaidR.setText(auxTexto1);
                        perimetroidR.setText(auxTexto2);

                    } catch (NumberFormatException excepcion) {
                        Toast.makeText(this, "Ha ocurrido un problema", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.circuloid:
                if (!TextUtils.isEmpty(arribaidIn.getText().toString())) {
                    try {
                        auxTexto1 = arribaidIn.getText().toString();
                        data1 = Double.parseDouble(auxTexto1);
                        data2=2*Math.PI*data1;//perimtro del circulo
                        data1 = Math.PI* Math.pow(data1,2);//calculo del area
                        auxTexto2 = String.valueOf(data2);
                        auxTexto1 = String.valueOf(data1);
                        areaidR.setText(auxTexto1);
                        perimetroidR.setText(auxTexto2);

                    } catch (NumberFormatException excepcion) {
                        Toast.makeText(this, "Ha ocurrido un problema", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.trianguloid:
                if (!(TextUtils.isEmpty(arribaidIn.getText().toString()) || TextUtils.isEmpty(abajoidIn.getText().toString()))) {
                    try {
                        auxTexto1 = arribaidIn.getText().toString();
                        auxTexto2 = abajoidIn.getText().toString();
                        data1 = Double.parseDouble(auxTexto1);
                        data2 = Double.parseDouble(auxTexto2);
                        if((data1>0)&&(data2>0)){
                            data3 = Math.sqrt(Math.pow(data1, 2) + Math.pow(data2, 2));//calculo hipotenusa
                            data3 = data1 + data2 + data3;//perimetro
                            data1 = (data1 * data2) / 2;//area
                            auxTexto1 = String.valueOf(data1);
                            auxTexto2 = String.valueOf(data3);
                            areaidR.setText(auxTexto1);
                            perimetroidR.setText(auxTexto2);
                        } else {
                            Toast.makeText(this, "Ingresar mayor que cero", Toast.LENGTH_SHORT).show();
                        }

                    } catch (NumberFormatException excepcion) {
                        Toast.makeText(this, "Ha ocurrido un problema", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "ingrese un valor", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.cuboid:
                if (!TextUtils.isEmpty(arribaidIn.getText().toString())) {
                    try {
                        auxTexto1 = arribaidIn.getText().toString();
                        data1 = Double.parseDouble(auxTexto1);
                        data2=data1*data1*6;//area
                        data3=data1*data1*data1;//volumen
                        data1=data1*12;//perimetro
                        auxTexto1 = String.valueOf(data1);
                        auxTexto2 = String.valueOf(data2);
                        auxTexto3 = String.valueOf(data3);
                        areaidR.setText(auxTexto2);
                        perimetroidR.setText(auxTexto1);
                        volumenidR.setText(auxTexto3);

                    } catch (NumberFormatException excepcion) {
                        Toast.makeText(this, "Ha ocurrido un problema", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
//BASURERO
//data=Integer.parseInt(texto1);
//data=Float.parseFloat(texto1);
//Log.d("onRadioButtonClicked: ", "presiono cuadro");
// arribaidIn.setError("ingrese un valor"); INGRESAR ERRON EN UN RECUADRO
//int id=view.getId();

/*
//VERIFICAR EL TIPO DE DATO INGRESADO
public static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
 */