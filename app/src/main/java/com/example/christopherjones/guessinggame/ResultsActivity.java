package com.example.christopherjones.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.christopherjones.guessinggame.GameActivity.winningNumber;

public class ResultsActivity extends AppCompatActivity {

    private Button playAgainButton;
    private TextView correctNumberTextView;
    private TextView resultsTextView;
    private ImageView resultImageView;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        playAgainButton = findViewById(R.id.restart_button);
        correctNumberTextView = findViewById(R.id.number_textview);
        resultsTextView = findViewById(R.id.results_textview);
        resultImageView = findViewById(R.id.winning_imageView);

        setListener();

        // get winning number from intent IF user has lost
        intent = getIntent();
        if(intent.hasExtra(winningNumber)) {
            setLosingData();
        }

    }

    private void setLosingData() {
        int winningNumber = intent.getIntExtra(GameActivity.winningNumber, 0);
        resultsTextView.setText(R.string.you_lost);
        correctNumberTextView.setText(getString(R.string.winning_number, winningNumber));
        correctNumberTextView.setVisibility(View.VISIBLE);

        resultImageView.setImageResource(R.drawable.losingsadface);
    }


    //handles setting the listener for the Play Again button
    private void setListener() {
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
