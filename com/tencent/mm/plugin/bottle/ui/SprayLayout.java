package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.Random;

public class SprayLayout extends FrameLayout {
    private ag handler;
    Animation hmA;
    Animation hmB;
    Animation hmC;
    Animation hmD;
    AnimationSet hmE;
    AnimationSet hmF;
    AnimationSet hmG;
    private int hmH;
    private int hmI;
    private int hmJ;
    private int hmK;
    private int hmL;
    private int hmM;
    private Runnable hmN;
    private ImageView hmw;
    private ImageView hmx;
    private ImageView hmy;
    Animation hmz;
    private int repeatCount;

    static /* synthetic */ void d(SprayLayout sprayLayout) {
        int i = -1;
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sprayLayout.getLayoutParams();
        FrameLayout frameLayout = (FrameLayout) sprayLayout.getParent();
        if (marginLayoutParams != null && frameLayout != null) {
            if (sprayLayout.hmJ == -1 && sprayLayout.hmK == -1) {
                Random random = new Random();
                int nextInt = (random.nextBoolean() ? 1 : -1) * random.nextInt(sprayLayout.hmL);
                int sqrt = (int) Math.sqrt((double) (((((sprayLayout.hmL * sprayLayout.hmL) - (nextInt * nextInt)) * sprayLayout.hmM) * sprayLayout.hmM) / (sprayLayout.hmL * sprayLayout.hmL)));
                if (random.nextBoolean()) {
                    i = 1;
                }
                marginLayoutParams.setMargins(nextInt, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, ((frameLayout.getHeight() * 300) / 800) + (random.nextInt(Math.max(sqrt, 1)) * i));
            } else {
                marginLayoutParams.setMargins(sprayLayout.hmJ - (frameLayout.getWidth() / 2), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, frameLayout.getHeight() - sprayLayout.hmK);
            }
            sprayLayout.setLayoutParams(marginLayoutParams);
        }
    }

    static /* synthetic */ int k(SprayLayout sprayLayout) {
        int i = sprayLayout.hmH + 1;
        sprayLayout.hmH = i;
        return i;
    }

    public SprayLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SprayLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hmz = new ScaleAnimation(0.6f, 0.8f, 0.6f, 0.8f, 1, 0.5f, 1, 1.0f);
        this.hmA = new AlphaAnimation(0.2f, 1.0f);
        this.hmB = new ScaleAnimation(0.8f, 1.27f, 0.8f, 1.27f, 1, 0.5f, 1, 1.0f);
        this.hmC = new AlphaAnimation(1.0f, 0.5f);
        this.hmD = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 1.0f);
        this.hmE = new AnimationSet(true);
        this.hmF = new AnimationSet(true);
        this.hmG = new AnimationSet(true);
        this.hmz.setDuration(280);
        this.hmA.setDuration(280);
        this.hmB.setDuration(280);
        this.hmC.setDuration(280);
        this.hmE.addAnimation(this.hmz);
        this.hmE.addAnimation(this.hmA);
        this.hmE.setRepeatCount(1);
        this.hmE.setDuration(280);
        this.hmF.addAnimation(this.hmB);
        this.hmF.setRepeatCount(1);
        this.hmF.setDuration(280);
        this.hmG.addAnimation(this.hmD);
        this.hmG.setRepeatCount(1);
        this.hmG.setDuration(280);
        this.hmH = 0;
        this.repeatCount = 1;
        this.hmJ = -1;
        this.hmK = -1;
        this.handler = new ag();
        this.hmN = new 1(this);
    }

    public final void E(int i, int i2, int i3) {
        this.hmH = 0;
        this.repeatCount = i;
        this.hmI = 0;
        this.hmJ = i2;
        this.hmK = i3;
        if (this.hmw == null) {
            this.hmw = (ImageView) findViewById(R.h.bottle_spray_one_iv);
            this.hmx = (ImageView) findViewById(R.h.bottle_spray_two_iv);
            this.hmy = (ImageView) findViewById(R.h.bottle_spray_three_iv);
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            this.hmL = (displayMetrics.widthPixels * 35) / 96;
            this.hmM = displayMetrics.heightPixels / 16;
        }
        this.hmw.setVisibility(8);
        this.hmx.setVisibility(8);
        this.hmy.setVisibility(8);
        setVisibility(0);
        this.handler.removeCallbacks(this.hmN);
        this.handler.postDelayed(this.hmN, 0);
    }

    public final void stop() {
        this.handler.removeCallbacks(this.hmN);
        setVisibility(8);
    }
}
