package com.demo.recycleviewdeatils;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.circularreveal.CircularRevealWidget;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class ShareViewActivity extends AppCompatActivity {
String title, subtitle;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_view);

        Toolbar toolbar = findViewById(R.id.toolbar_share_view);
        toolbar.setSubtitle(getTitle());
        toolbar.setTitle(getTitle());
        toolbar.setNavigationIcon(R.drawable.ic_close_black_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        int image = intent.getIntExtra("dimage",1);
        String creatorName = intent.getStringExtra("title");
        String likeCount = intent.getStringExtra("Sub");

        ImageView imageView = findViewById(R.id.rvi);
        TextView textViewCreator = findViewById(R.id.dtitle);
        TextView textViewLikes = findViewById(R.id.dstitle);

        imageView.setImageResource(image);
        Glide.with(this).load(image).into(imageView);
        textViewCreator.setText(creatorName);
        textViewLikes.setText("Information: " +likeCount);

    }



    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    ObjectAnimator upAnim = ObjectAnimator.ofFloat(view, "translationZ", 0);
                    upAnim.setDuration(200);
                    upAnim.setInterpolator(new DecelerateInterpolator());
                    upAnim.start();
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    ObjectAnimator downAnim = ObjectAnimator.ofFloat(view, "translationZ", 20);
                    downAnim.setDuration(200);
                    downAnim.setInterpolator(new AccelerateInterpolator());
                    downAnim.start();
                    break;
            }
            return false;
        }
    };

}
