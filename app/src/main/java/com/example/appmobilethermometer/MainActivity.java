package com.example.appmobilethermometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText_farenheit);
        TextView textViewResult = findViewById(R.id.txt_result);
        Button button = findViewById(R.id.btn_convert);

        Pattern validateCharacter = Pattern.compile("^\\d+$");

        button.setOnClickListener(v->{
            String inputFarenheit = editText.getText().toString();
            Matcher matcher = validateCharacter.matcher(inputFarenheit);
            if(!inputFarenheit.isEmpty() && matcher.matches()) {
                double result = 0;
                result = ((Double.parseDouble(inputFarenheit) - 32) * 5) / 9;
                String resultConvert = getString(R.string.result_convert, result+"");
                textViewResult.setText(resultConvert);
            }else{
                Toast.makeText(this, R.string.enter_a_valid_data,Toast.LENGTH_SHORT).show();
            }
        });
    }
}