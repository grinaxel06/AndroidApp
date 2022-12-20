package com.example.listapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.listapplication.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Posts[] post = new Posts[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      binding = ActivityMainBinding.inflate(getLayoutInflater());
      setContentView(binding.getRoot());
        post[0] = new Posts("OnePiece", 31,12,R.drawable.chopper);
        post[1] = new Posts("JoJo", 21,24,R.drawable.speedwagon);
        post[2] = new Posts("Rick Astley", 10,5,R.drawable.rickastley);
        post[3] = new Posts("Michael Jackson", 88,13,R.drawable.michaeljackson);
        post[4] = new Posts("Minions", 23,43,R.drawable.minions);
        post[5] = new Posts("Chainsaw Man", 25,11,R.drawable.chainsawman);
        binding.listView.setAdapter(new PostAdapter(this,post));


    }



}