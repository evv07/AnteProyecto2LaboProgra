package com.example.simon;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class PlayScreen extends AppCompatActivity {

    public Vector<Integer> SimonVector = new Vector<>();
    public Vector<Integer> PlayerVector = new Vector<>();

    int cont;

    public void YouLostActivity(View view){
        Intent GoToYouLost = new Intent(this, YouLostActivity.class);
        startActivity(GoToYouLost);
    }

    private static int getRandomNumberInRange() {

        Random r = new Random();
        return r.nextInt((5 - 0) + 1) + 0;
    }


    boolean lost = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

        //Animacion cuando se presionan los botones
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);

        //Declaracion botones
        final ImageButton DogButton = (ImageButton) this.findViewById(R.id.DogButton);
        final ImageButton CatButton = (ImageButton) this.findViewById(R.id.CatButton);
        final ImageButton CowButton = (ImageButton) this.findViewById(R.id.CowButton);
        final ImageButton HorseButton = (ImageButton) this.findViewById(R.id.HorseButton);
        final ImageButton FrogButton = (ImageButton) this.findViewById(R.id.FrogButton);
        final ImageButton RoosterButton = (ImageButton) this.findViewById(R.id.RoosterButton);
        final Button StartGameButton = (Button) this.findViewById(R.id.StartGameButton);

        //***************Sonidos
        final MediaPlayer dogSound = MediaPlayer.create(this, R.raw.dogsound);
        final MediaPlayer catSound = MediaPlayer.create(this, R.raw.catsound);
        final MediaPlayer cowSound = MediaPlayer.create(this, R.raw.cowsound);
        final MediaPlayer horseSound = MediaPlayer.create(this, R.raw.horsesound);
        final MediaPlayer frogSound = MediaPlayer.create(this, R.raw.frogsound);
        final MediaPlayer roosterSound = MediaPlayer.create(this, R.raw.roostersound);


        StartGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DogButton.setEnabled(false);
                CatButton.setEnabled(false);
                CowButton.setEnabled(false);
                HorseButton.setEnabled(false);
                FrogButton.setEnabled(false);
                RoosterButton.setEnabled(false);
                cont=0;

                SimonVector.clear();
                PlayerVector.clear();
                for(int i=0; i<2 ; i++){
                    Log.d("aaa" + Integer.toString(i),"aaa");
                    SimonVector.add(getRandomNumberInRange());
                }

                final Handler handler = new Handler();

                        for(int i = 0;i<2 ; i++){
                            Log.d("Valores vector" + Integer.toString(SimonVector.elementAt(i)), " ");
                            switch (SimonVector.elementAt(i)) {
                                case 0:
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            dogSound.start();
                                            DogButton.startAnimation(anim);
                                        }
                                    }, i*3000);
                                    break;
                                case 1:
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            catSound.start();
                                            CatButton.startAnimation(anim);
                                        }
                                    }, i*3000);
                                    break;
                                case 2:
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            cowSound.start();
                                            CowButton.startAnimation(anim);
                                        }
                                    }, i*3000);
                                    break;
                                case 3:
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            horseSound.start();
                                            HorseButton.startAnimation(anim);
                                        }
                                    }, i*3000);
                                    break;
                                case 4:
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            frogSound.start();
                                            FrogButton.startAnimation(anim);
                                        }
                                    }, i*3000);
                                    break;
                                case 5:
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            roosterSound.start();
                                            RoosterButton.startAnimation(anim);
                                        }
                                    }, i*3000);
                                    break;
                            }
                        }

                DogButton.setEnabled(true);
                CatButton.setEnabled(true);
                CowButton.setEnabled(true);
                HorseButton.setEnabled(true);
                FrogButton.setEnabled(true);
                RoosterButton.setEnabled(true);

            }



        });

        DogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dogSound.start();
                view.startAnimation(anim);
                PlayerVector.add(0);
                if(SimonVector.elementAt(cont) != PlayerVector.elementAt(cont)){
                    lost = true;
                    startActivity( new Intent(PlayScreen.this, YouLostActivity.class));
                    }

                    else if(SimonVector.size() == PlayerVector.size()){
                    final Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            StartGameButton.performClick();
                        }
                    }, 3000);


                    }

                cont++;
            }
        });

        CatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catSound.start();
                view.startAnimation(anim);
                PlayerVector.add(1);
                if(SimonVector.elementAt(cont) != PlayerVector.elementAt(cont)){
                    lost = true;
                    startActivity( new Intent(PlayScreen.this, YouLostActivity.class));
                }
                else if(SimonVector.size() == PlayerVector.size()){
                    final Handler handler2 = new Handler();
                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            StartGameButton.performClick();
                        }
                    }, 3000);


                }
                cont++;
            }
        });

        CowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cowSound.start();
                view.startAnimation(anim);
                PlayerVector.add(2);
                if(SimonVector.elementAt(cont) != PlayerVector.elementAt(cont)){
                    lost = true;
                    startActivity( new Intent(PlayScreen.this, YouLostActivity.class));
                }
                else if(SimonVector.size() == PlayerVector.size()){
                    final Handler handler3 = new Handler();
                    handler3.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            StartGameButton.performClick();
                        }
                    }, 3000);


                }
                cont++;
            }
        });

        HorseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                horseSound.start();
                view.startAnimation(anim);
                PlayerVector.add(3);
                if(SimonVector.elementAt(cont) != PlayerVector.elementAt(cont)){
                    lost = true;
                    startActivity( new Intent(PlayScreen.this, YouLostActivity.class));
                }
                else if(SimonVector.size() == PlayerVector.size()){
                    final Handler handler4 = new Handler();
                    handler4.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            StartGameButton.performClick();
                        }
                    }, 3000);


                }
                cont++;
            }
        });

        FrogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frogSound.start();
                view.startAnimation(anim);
                PlayerVector.add(4);
                if(SimonVector.elementAt(cont) != PlayerVector.elementAt(cont)){
                    lost = true;
                    startActivity( new Intent(PlayScreen.this, YouLostActivity.class));
                }
                else if(SimonVector.size() == PlayerVector.size()){
                    final Handler handler5 = new Handler();
                    handler5.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            StartGameButton.performClick();
                        }
                    }, 3000);


                }
                cont++;
            }
        });


        RoosterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roosterSound.start();
                view.startAnimation(anim);
                PlayerVector.add(5);
                if(SimonVector.elementAt(cont) != PlayerVector.elementAt(cont)){
                    lost = true;
                    startActivity( new Intent(PlayScreen.this, YouLostActivity.class));
                }
                else if(SimonVector.size() == PlayerVector.size()){
                    final Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            StartGameButton.performClick();
                        }
                    }, 3000);


                }
                cont++;
            }
        });

    }


}
