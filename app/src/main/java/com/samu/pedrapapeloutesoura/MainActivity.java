package com.samu.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getOpcaoTesoura (View view){
        this.setJogar("tesoura");
    }
    public void getOpcaoPedra (View view){
        this.setJogar("pedra");
    }
    public void getOpcaoPapel (View view){
        this.setJogar("papel");
    }

    public void setJogar(String opcUser){
        // FAZ A MÁQUINA GERAR UMA ESCOLHA
        String[] escolhaDoApp = {"pedra", "papel", "tesoura"};
        int numEscolha = new Random().nextInt(escolhaDoApp.length);

        // MANIPULA A IMG DA ESCOLHA DO APP ATRAVES DO ID
        ImageView imgEscolhaApp = findViewById(R.id.imgApp);

        // ALTERA A IMAGEM DE APLICAÇÃO DE ACORDO COM A ESCOLHA DO APP
        switch (escolhaDoApp[numEscolha]){
            case "pedra":
                imgEscolhaApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgEscolhaApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgEscolhaApp.setImageResource(R.drawable.tesoura);
                break;
        }

        // SE A OPÇÃO ESCOLHIDA DO USUARIO FOR A MESMA DA MAQUINA, GERA EMPATE
        TextView resultado = findViewById(R.id.resultado);
        if(opcUser.equals(escolhaDoApp[numEscolha])){
            resultado.setText("Boa jogada, porém deu empate! tente novamente.");
        }

        // CASO O USUARIO JOGUE PEDRA E A MAQUINA JOGUE PAPEL
        else if (opcUser.equals("pedra") && escolhaDoApp[numEscolha].equals("papel") ){
            resultado.setText("Ops, nocauteado kkk você perdeu");
        }
        // CASO O USUARIO JOGUE PEDRA E A MAQUINA JOGUE TESOURA
        else if (opcUser.equals("pedra") && escolhaDoApp[numEscolha].equals("tesoura") ){
            resultado.setText("Boaaa, você venceu!!");
        }

        else if (opcUser.equals("papel") && escolhaDoApp[numEscolha].equals("tesoura") ){
            resultado.setText("Ops, nocauteado kkk você perdeu");
        }
        else if (opcUser.equals("papel") && escolhaDoApp[numEscolha].equals("pedra") ){
            resultado.setText("Boaaa, você venceu!!");
        }

        else if (opcUser.equals("tesoura") && escolhaDoApp[numEscolha].equals("pedra") ){
            resultado.setText("Ops, nocauteado kkk você perdeu");
        }
        else if (opcUser.equals("tesoura") && escolhaDoApp[numEscolha].equals("papel") ){
            resultado.setText("Boaaa, você venceu!!");
        }


    }

}