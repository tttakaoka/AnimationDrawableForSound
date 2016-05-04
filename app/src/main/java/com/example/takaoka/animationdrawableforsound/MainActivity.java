package com.example.takaoka.animationdrawableforsound;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.imageView);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (img.getBackground() instanceof AnimationDrawable) {
                    img.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.sound_off));
                } else {
                    img.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.animation_sound));
                    // AnimationDrawableを取得
                    AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
                    // アニメーションの開始
                    frameAnimation.start();
                }
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (img == null) {
            return;
        }
        if (img.getBackground() instanceof AnimationDrawable) {
            // AnimationDrawableを取得
            AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

            // アニメーションの開始
            frameAnimation.start();
        }
    }
}
