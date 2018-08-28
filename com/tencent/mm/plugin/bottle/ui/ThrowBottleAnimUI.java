package com.tencent.mm.plugin.bottle.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

@SuppressLint({"HandlerLeak"})
public class ThrowBottleAnimUI extends FrameLayout {
    int Om;
    int On;
    BottleBeachUI hlO;
    private SprayLayout hmP;
    private BottleImageView hmQ;
    private TextView hmR;
    private AnimationSet hmS;
    private int hmT;
    private int hmU;
    private int hmV;
    private int hmW;
    int hmX;
    private a hmY;
    boolean hmZ;
    private ag hna = new 4(this);

    static /* synthetic */ void f(ThrowBottleAnimUI throwBottleAnimUI) {
        float f;
        int i;
        throwBottleAnimUI.hmR.setVisibility(0);
        if (throwBottleAnimUI.hmZ) {
            throwBottleAnimUI.hmR.setBackgroundDrawable(a.f(throwBottleAnimUI.hlO, R.g.rcd_anim1));
            throwBottleAnimUI.hmR.setWidth(throwBottleAnimUI.hmX);
            f = 1.0f;
            i = TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR;
        } else {
            throwBottleAnimUI.hmR.setBackgroundDrawable(a.f(throwBottleAnimUI.hlO, R.g.bottle_stationery));
            f = 0.5f;
            i = 25;
        }
        throwBottleAnimUI.hmS = new AnimationSet(true);
        throwBottleAnimUI.hmS.setInterpolator(throwBottleAnimUI.hlO, 17432582);
        Animation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.0f, 1, 0.0f);
        scaleAnimation.setDuration(700);
        Animation rotateAnimation = new RotateAnimation(0.0f, (float) i, 1, f, 1, 1.0f);
        rotateAnimation.setDuration(700);
        int intrinsicWidth = throwBottleAnimUI.hmQ.getBackground().getIntrinsicWidth() / 2;
        int intrinsicHeight = throwBottleAnimUI.hmQ.getBackground().getIntrinsicHeight() / 2;
        int b = b.b(throwBottleAnimUI.hlO, 40.0f);
        x.v("MicroMsg.ThrowBottleAnimView", "tran from (" + throwBottleAnimUI.Om + "," + throwBottleAnimUI.On + ") to (" + ((throwBottleAnimUI.getUIWidth() - b) - intrinsicWidth) + " , " + ((throwBottleAnimUI.getUIHeight() - b) - intrinsicHeight));
        Animation translateAnimation = new TranslateAnimation((float) throwBottleAnimUI.Om, (float) ((throwBottleAnimUI.getUIWidth() - b) - intrinsicWidth), (float) throwBottleAnimUI.On, (float) ((throwBottleAnimUI.getUIHeight() - b) - intrinsicHeight));
        translateAnimation.setDuration(700);
        throwBottleAnimUI.hmS.addAnimation(rotateAnimation);
        throwBottleAnimUI.hmS.addAnimation(scaleAnimation);
        throwBottleAnimUI.hmS.addAnimation(translateAnimation);
        throwBottleAnimUI.hmS.setAnimationListener(new 2(throwBottleAnimUI));
    }

    public ThrowBottleAnimUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hlO = (BottleBeachUI) context;
        initView();
    }

    public ThrowBottleAnimUI(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hlO = (BottleBeachUI) context;
        initView();
    }

    public final void release() {
        this.hlO = null;
        this.hmS = null;
        this.hmP = null;
        if (this.hmQ != null) {
            BottleImageView bottleImageView = this.hmQ;
            bottleImageView.context = null;
            bottleImageView.hlj = null;
        }
        this.hmQ = null;
        this.hmY = null;
    }

    public boolean isInEditMode() {
        return false;
    }

    private void initView() {
        inflate(this.hlO, R.i.bottle_throw_anim, this);
        this.hmQ = (BottleImageView) findViewById(R.h.bottle_throw_bottle_iv);
        this.hmR = (TextView) findViewById(R.h.bottle_throw_content_scale);
        DisplayMetrics displayMetrics = this.hlO.getResources().getDisplayMetrics();
        this.hmV = displayMetrics.widthPixels;
        this.hmW = displayMetrics.heightPixels;
    }

    public void setOnThrowEndListener(a aVar) {
        this.hmY = aVar;
    }

    private int getUIWidth() {
        int abs = Math.abs(getWidth());
        if (abs <= 0) {
            return this.hmV;
        }
        return abs;
    }

    private int getUIHeight() {
        int abs = Math.abs(getHeight());
        if (abs <= 0) {
            return this.hmW;
        }
        return abs;
    }

    /* renamed from: auB */
    final void e() {
        this.hmQ.setImageDrawable(null);
        int intrinsicWidth = this.hmQ.getBackground().getIntrinsicWidth();
        int intrinsicHeight = this.hmQ.getBackground().getIntrinsicHeight();
        this.hmQ.setVisibility(0);
        int b = b.b(this.hlO, 40.0f);
        this.hmQ.setLayoutParams(new LayoutParams(-2, -2, getUIWidth() - (intrinsicWidth + b), getUIHeight() - (intrinsicHeight + b)));
    }

    /* renamed from: auC */
    final void h() {
        int intrinsicWidth = this.hmQ.getBackground().getIntrinsicWidth();
        int intrinsicHeight = this.hmQ.getBackground().getIntrinsicHeight();
        this.hmQ.setVisibility(0);
        int b = b.b(this.hlO, 40.0f);
        setBackgroundDrawable(a.f(this.hlO, bi.ciW() ? R.g.bottle_pick_bg_spotlight_day : R.g.bottle_pick_bg_spotlight_night));
        if (this.hmZ) {
            this.hmQ.setImageDrawable(a.f(this.hlO, R.g.bottle_type_voice));
        } else {
            this.hmQ.setImageDrawable(a.f(this.hlO, R.g.bottle_type_text));
        }
        this.hmQ.setLayoutParams(new LayoutParams(-2, -2, 0, 0));
        BottleImageView bottleImageView = this.hmQ;
        int uIWidth = getUIWidth() - (intrinsicWidth + b);
        intrinsicWidth = this.hmT - (intrinsicWidth / 2);
        b = getUIHeight() - (b + intrinsicHeight);
        intrinsicHeight = this.hmU - (intrinsicHeight / 2);
        3 3 = new 3(this);
        bottleImageView.Om = uIWidth;
        bottleImageView.Oo = intrinsicWidth;
        bottleImageView.On = b;
        bottleImageView.Op = intrinsicHeight;
        bottleImageView.hlj.setAnimationListener(3);
        bottleImageView.hlj.setDuration(2000);
        bottleImageView.hlj.setRepeatCount(0);
        bottleImageView.hlj.setStartOffset(500);
        bottleImageView.hlj.setInterpolator(bottleImageView.context, 17432582);
        bottleImageView.startAnimation(bottleImageView.hlj);
    }

    /* renamed from: auD */
    final void d() {
        this.hmT = getUIWidth() / 2;
        this.hmU = (getUIHeight() * 460) / 800;
        x.v("MicroMsg.ThrowBottleAnimView", "to (" + this.hmT + "," + this.hmU + ")  bottle (" + this.hmQ.getDrawable().getIntrinsicWidth() + "," + this.hmQ.getDrawable().getIntrinsicHeight() + ")");
    }
}
