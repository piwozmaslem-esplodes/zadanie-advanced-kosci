package com.example.kosci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();

    private TextView textLosowanie, textWynikGry, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10;
    private Button buttonRoll;
    private Button buttonReset;

    private ImageView foto1, foto2, foto3, foto4, foto5;

    int[] obrazy = {R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6};

    int wynikGry = 0, poprzedniaLiczba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textLosowanie = findViewById(R.id.textLosowanie);
        textWynikGry = findViewById(R.id.textWynikGry);
        buttonRoll = findViewById(R.id.buttonRoll);
        buttonReset = findViewById(R.id.buttonReset);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        foto1 = findViewById(R.id.foto1);
        foto2 = findViewById(R.id.foto2);
        foto3 = findViewById(R.id.foto3);
        foto4 = findViewById(R.id.foto4);
        foto5 = findViewById(R.id.foto5);
        buttonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView[] pola = {foto1, foto2, foto3, foto4, foto5};
                int[] kosci = new int[5];
                int wynik = 0, dwiePary = 0,  para = 0, mStreet = 0, dStreet = 0, full = 0, poker = 0, kareta = 0, trojka = 0, rzutKostka;

                for (int i = 0; i < kosci.length; i++) {
                    rzutKostka = random.nextInt(6) + 1;

                        for (int j = 0; j < kosci.length; j++){

                            if(para > 0  && rzutKostka == kosci[j]){
                                dwiePary = para + rzutKostka + kosci[j];
                            }

                            //para
                            if(rzutKostka == kosci[j]){
                                if (rzutKostka + kosci[j] > para){
                                    para = rzutKostka + kosci[j];
                                }
                            }





                        }
                    kosci[i] = rzutKostka;
                    pola[i].setImageResource(obrazy[kosci[i] - 1]);
                    wynik += kosci[i];
                    poprzedniaLiczba = kosci[i];
                }

                textLosowanie.setText("Wynik tego losowania: " + wynik);
                wynikGry += wynik;
                textWynikGry.setText("Wynik gry: " + wynikGry);
                textView3.setText("Para: " + para);
                textView4.setText("2 Pary: " + dwiePary);
                textView5.setText("Trójka: " + trojka);
                textView6.setText("Kareta: " + kareta);
                textView7.setText("Poker: " + poker);
                textView8.setText("Full: " + full);
                textView9.setText("m Street: " + mStreet);
                textView10.setText("d Street: " + dStreet);


            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foto1.setImageResource(R.drawable.question);
                foto2.setImageResource(R.drawable.question);
                foto3.setImageResource(R.drawable.question);
                foto4.setImageResource(R.drawable.question);
                foto5.setImageResource(R.drawable.question);

                wynikGry = 0;
                textLosowanie.setText("Wynik tego losowania: 0");
                textWynikGry.setText("Wynik gry: 0");
            }
        });
    }
}
