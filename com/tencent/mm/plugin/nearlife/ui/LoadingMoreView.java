package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;

public class LoadingMoreView extends LinearLayout {
    private ImageView bRk = ((ImageView) findViewById(R.h.life_next_progress));
    private Context context;
    protected LinearLayout hzN;

    public LoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View inflate = LayoutInflater.from(this.context).inflate(R.i.life_loading_more, this, true);
        this.hzN = (LinearLayout) inflate.findViewById(R.h.loading_more_state);
        this.hzN.setVisibility(0);
        Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.bRk.startAnimation(rotateAnimation);
    }
}
