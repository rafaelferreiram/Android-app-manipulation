package br.com.fiap.viewcomponentes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private EditText campo1;
    private EditText       campo2;
    private CheckBox       caixa;
    private Switch         ligaDesliga;
    private ToggleButton   interruptor;
    private RatingBar      estrelas;
    private SeekBar        volume;
    private RadioGroup     grupo;
    private Spinner        menu;
    private Button         botao;
    private TextView       texto;
    private String textoQualquer;
    String[] itens = {"num1", "num2", "num3", "num4"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campo1 = findViewById(R.id.editText);
        campo2 = findViewById(R.id.editText2);
        caixa = findViewById(R.id.checkBox);
        ligaDesliga = findViewById(R.id.switch1);
        interruptor = findViewById(R.id.toggleButton);
        estrelas = findViewById(R.id.ratingBar);
        volume = findViewById(R.id.seekBar);
        grupo = findViewById(R.id.radioGroup);
        menu = findViewById(R.id.spinner);
        botao = findViewById(R.id.button);
        texto = findViewById(R.id.textView);

        caixa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                String texto = getString(isChecked);
                Toast.makeText(MainActivity.this, texto, Toast.LENGTH_SHORT).show();
            }
        });
        ligaDesliga.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String texto = getString(isChecked);
                Toast.makeText(MainActivity.this, texto, Toast.LENGTH_SHORT).show();
            }
        });
        interruptor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String texto = getString(isChecked);
                Toast.makeText(MainActivity.this, texto, Toast.LENGTH_SHORT).show();
            }
        });

        estrelas.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, rating + " Estrelas", Toast.LENGTH_SHORT).show();
            }
        });

        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                texto.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Começou", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Parou", Toast.LENGTH_SHORT).show();
            }
        });

        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group,
                                         int checkedId) {
                RadioButton radio = findViewById(checkedId);
                Toast.makeText(MainActivity.this,
                        radio.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });


        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item,
                        itens);
        menu.setAdapter(adapter);

        menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view,
                                       int position,
                                       long id) {
                String opcaoClicada = itens[position];
                Toast.makeText(MainActivity.this,
                        opcaoClicada, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorCampo1 = campo1.getText().toString();
                String valorCampo2 = campo2.getText().toString();
                int valorSeek = volume.getProgress();
                String valorBox = getString(caixa.isChecked());
                String valorSwitch = getString(ligaDesliga.isChecked());
                String valorToggle = getString(interruptor.isChecked());
                RadioButton radio = findViewById(grupo.getCheckedRadioButtonId());
                String valorRadio = radio.getText().toString();
                float valorRatingBar = estrelas.getRating();

                StringBuilder mensagem = new StringBuilder();
                mensagem.append("valorCampo1 = " + valorCampo1)
                        .append("\n")
                        .append("valorCampo2 = " + valorCampo2)
                        .append("\n")
                        .append("valorSeek = " + valorSeek)
                        .append("\n")
                        .append("valorBox = " + valorBox)
                        .append("\n")
                        .append("valorSwitch = " + valorSwitch)
                        .append("\n")
                        .append("valorToggle = " + valorToggle)
                        .append("\n")
                        .append("valorRadio = " + valorRadio)
                        .append("\n")
                        .append("valorRatingBar = " + valorRatingBar);
                Toast.makeText(MainActivity.this,
                        mensagem,
                        Toast.LENGTH_SHORT).show();
            }
        });

        campo1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Toast.makeText(MainActivity.this,
                        campo1.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        campo2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
             Toast.makeText(MainActivity.this,campo2.getText().toString(),
            Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getString(boolean isChecked) {
        String texto = "";
        if(isChecked) {
            texto = "Ligado";
        } else {
            texto = "Desligado";
        }
        return texto;
    }
}
