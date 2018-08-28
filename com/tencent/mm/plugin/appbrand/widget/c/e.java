package com.tencent.mm.plugin.appbrand.widget.c;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.s.a;
import java.util.LinkedList;

public final class e extends FrameLayout implements i {
    public final g gFU = new g(this);
    public final LinkedList<h> gFV = new LinkedList();
    private final Runnable gFW = new 2(this);
    private h gFX;
    public h gFY;
    public final OnClickListener mOnClickListener = new 1(this);

    static /* synthetic */ void a(e eVar) {
        h hVar = (h) eVar.gFV.peekLast();
        if (hVar == null) {
            eVar.setVisibility(8);
        } else if (hVar.ape()) {
            hVar.onCancel();
            eVar.b(hVar);
        }
    }

    public e(Context context) {
        super(context);
        setVisibility(4);
        setBackgroundColor(0);
        setOnClickListener(this.mOnClickListener);
    }

    public final void b(h hVar) {
        if (hVar.getContentView().getParent() == this && this.gFX != hVar) {
            this.gFX = hVar;
            View contentView = hVar.getContentView();
            contentView.animate().cancel();
            contentView.clearAnimation();
            TimeInterpolator loadInterpolator = AnimationUtils.loadInterpolator(contentView.getContext(), a.decelerate_quint_interpolator);
            TimeInterpolator loadInterpolator2 = AnimationUtils.loadInterpolator(contentView.getContext(), a.decelerate_cubic_interpolator);
            Animator animatorSet = new AnimatorSet();
            r4 = new Animator[3];
            Animator duration = ObjectAnimator.ofFloat(contentView, "scaleX", new float[]{1.0f, 0.9f}).setDuration(220);
            duration.setInterpolator(loadInterpolator);
            r4[0] = duration;
            duration = ObjectAnimator.ofFloat(contentView, "scaleY", new float[]{1.0f, 0.9f}).setDuration(220);
            duration.setInterpolator(loadInterpolator);
            r4[1] = duration;
            Animator duration2 = ObjectAnimator.ofFloat(contentView, "alpha", new float[]{1.0f, 0.0f}).setDuration(150);
            duration2.setInterpolator(loadInterpolator2);
            r4[2] = duration2;
            animatorSet.playTogether(r4);
            animatorSet.addListener(new 3(this, contentView, hVar));
            animatorSet.start();
            if (this.gFV.size() <= 1) {
                this.gFU.c(0, this.gFW);
            }
        }
    }

    public static void bT(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getChildCount() == 0) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
