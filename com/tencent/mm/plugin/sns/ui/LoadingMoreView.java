package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

public class LoadingMoreView extends LinearLayout {
    private ImageView bRk;
    private Context context;
    protected LinearLayout hzN;
    protected LinearLayout hzO;
    protected LinearLayout nOp;
    protected LinearLayout nOq;
    protected TextView nOr;

    public LoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public LoadingMoreView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(this.context).inflate(g.sns_next_loading, this, true);
        this.bRk = (ImageView) findViewById(f.album_next_progress);
        this.hzN = (LinearLayout) inflate.findViewById(f.loading_more_state);
        this.hzO = (LinearLayout) inflate.findViewById(f.loading_end);
        this.nOp = (LinearLayout) inflate.findViewById(f.strange_limit);
        this.nOq = (LinearLayout) inflate.findViewById(f.recent_limit);
        this.nOr = (TextView) inflate.findViewById(f.recent_limit_text);
        this.hzN.setVisibility(0);
        this.hzO.setVisibility(8);
        this.nOp.setVisibility(8);
        this.nOq.setVisibility(8);
        Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.bRk.startAnimation(rotateAnimation);
    }

    public final void im(boolean z) {
        this.hzN.setVisibility(8);
        if (z) {
            this.nOp.setVisibility(0);
            this.hzO.setVisibility(8);
        } else {
            this.hzO.setVisibility(0);
            this.nOp.setVisibility(8);
        }
        this.nOq.setVisibility(8);
    }

    public final void xk(int i) {
        this.hzN.setVisibility(8);
        this.nOp.setVisibility(8);
        this.hzO.setVisibility(8);
        this.nOq.setVisibility(0);
        if (i == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN) {
            this.nOr.setText(getContext().getResources().getString(j.sns_recent_half_year_tip));
        } else if (i == MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK) {
            this.nOr.setText(getContext().getResources().getString(j.sns_close));
        } else if (i == 2004) {
            this.nOr.setText(getContext().getResources().getString(j.sns_recent_three_day_tip));
        }
    }
}
