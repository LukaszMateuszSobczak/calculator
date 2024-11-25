package com.lukaszsobczak.calculator;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView textViewOutput = findViewById(R.id.text_view_result);
        EditText editTextInput = findViewById(R.id.edit_text_input);
//        ImageView imageViewBackspace = findViewById(R.id.image_view_backspace);

//        MaterialButton buttonClear = findViewById(R.id.button_clear);
//        MaterialButton buttonBrackets = findViewById(R.id.button_brackets);
//        MaterialButton buttonPercentage = findViewById(R.id.button_percent);
//        MaterialButton buttonDivide = findViewById(R.id.button_divide);
//        MaterialButton buttonSeven = findViewById(R.id.button_seven);
//        MaterialButton buttonEight = findViewById(R.id.button_eight);
//        MaterialButton buttonNine = findViewById(R.id.button_nine);
//        MaterialButton buttonMultiply = findViewById(R.id.button_multiply);
//        MaterialButton buttonFour = findViewById(R.id.button_four);
//        MaterialButton buttonFive = findViewById(R.id.button_five);
//        MaterialButton buttonSix = findViewById(R.id.button_six);
//        MaterialButton buttonMinus = findViewById(R.id.button_minus);
//        MaterialButton buttonOne = findViewById(R.id.button_one);
//        MaterialButton buttonTwo = findViewById(R.id.button_two);
//        MaterialButton buttonThree = findViewById(R.id.button_three);
//        MaterialButton buttonPlus = findViewById(R.id.button_plus);
//        MaterialButton buttonPlusMinus = findViewById(R.id.button_plus_minus);
//        MaterialButton buttonZero = findViewById(R.id.button_zero);
//        MaterialButton buttonDot = findViewById(R.id.button_dot);
//        MaterialButton buttonEqual = findViewById(R.id.button_equal);

        ViewGroup viewGroupConstraint = findViewById(R.id.main);

        for (int i = 0; i < viewGroupConstraint.getChildCount(); i++) {
            View view = viewGroupConstraint.getChildAt(i);
            if (view instanceof ImageView) {
                if (view.getId() == R.id.image_view_backspace) {
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String currentText = textViewOutput.getText().toString();
                            if (currentText.length() > 0) {
                                textViewOutput.setText(currentText.substring(0, currentText.length() - 1));
                            }
                        }
                    });
                }
            }
            if (view instanceof MaterialButton) {
                if (view.getId() == R.id.button_clear) {
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            textViewOutput.setText("");
                        }
                    });
                } else {
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String text = (String) ((MaterialButton) view).getText();
                            textViewOutput.append(text);
                        }
                    });
                }
            }
        }


    }
}