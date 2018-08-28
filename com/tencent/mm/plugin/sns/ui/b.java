package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    private int Tu = 0;
    private float aaI = 0.0f;
    private float aaJ = 0.0f;
    private final Context context;
    private ag mHandler = new ag();
    int mHeight = 0;
    int mWidth = 0;
    private int nJR = 0;
    int nJS = 0;
    int nJT = 0;
    int nJU = 0;
    int nJV = 0;
    float nJW = 0.0f;
    float nJX = 1.0f;
    int nJY = 0;
    int nJZ = 0;
    int nKa = 0;
    int nKb = 0;
    int nKc = 0;
    private int nKd = l.CTRL_BYTE;
    private int nKe = 0;
    int nKf = 1;
    int nKg = 2;
    int nKh = 3;
    int nKi = 4;
    int nKj = this.nKe;

    public b(Context context) {
        this.context = context;
    }

    public final void u(int i, int i2, int i3, int i4) {
        this.Tu = i;
        this.nJR = i2;
        this.mWidth = i3;
        this.mHeight = i4;
    }

    final void j(View view, boolean z) {
        int i;
        float f;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (this.Tu == 0 && this.nJR == 0) {
            this.Tu = view.getWidth() / 2;
            this.nJR = view.getHeight() / 2;
        }
        this.nJU = this.Tu - iArr[0];
        this.nJV = this.nJR - iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            width = this.nJS;
            height = this.nJT;
            i = width;
        } else {
            i = width;
        }
        if (!(i == 0 || height == 0)) {
            this.aaI = ((float) this.mWidth) / ((float) i);
            this.aaJ = ((float) this.mHeight) / ((float) height);
        }
        if (this.nJZ == 0 && this.nKa == 0 && this.nKb == 0 && this.nKc == 0) {
            f = 1.0f;
        } else {
            f = 1.1f;
        }
        if (z) {
            if (!(this.nJS == 0 || this.nJT == 0)) {
                this.aaI = ((float) this.mWidth) / ((float) this.nJS);
                this.aaJ = ((float) this.mHeight) / ((float) this.nJT);
            }
            f = 1.0f;
        }
        if (this.aaI > this.aaJ) {
            this.nJW = this.aaI * f;
            this.nJV = (int) (((float) this.nJV) - (((((float) height) * this.nJW) - (((float) this.mHeight) * f)) / 2.0f));
        } else {
            this.nJW = this.aaJ * f;
            this.nJU = (int) (((float) this.nJU) - (((((float) i) * this.nJW) - (((float) this.mWidth) * f)) / 2.0f));
            if (this.nJT != 0 && this.nJT < height) {
                this.nJV = (int) (((float) this.nJV) - (((((float) height) * this.nJW) - (((float) this.mHeight) * f)) / 2.0f));
            }
        }
        this.nJV = (int) ((((float) this.nJV) - ((((float) this.mHeight) * (f - 1.0f)) / 2.0f)) - ((((float) this.nJY) * this.nJW) / 2.0f));
        this.nJU = (int) (((float) this.nJU) - ((((float) this.mWidth) * (f - 1.0f)) / 2.0f));
        if (this.nJT != 0 && this.nJR < (height - this.nJT) / 2) {
            this.nJV = (int) ((((f - 1.0f) * ((float) this.mHeight)) / 2.0f) + ((float) this.nJV));
        } else if (this.nJT != 0 && this.nJR + this.mHeight > (this.nJT + height) / 2) {
            this.nJV = (int) (((float) this.nJV) - (((f - 1.0f) * ((float) this.mHeight)) / 2.0f));
        }
        if (this.mWidth == 0 && this.mHeight == 0) {
            this.nJW = 0.5f;
            this.nJX = 0.0f;
            this.nJU = (int) (((float) this.nJU) - ((((float) i) * this.nJW) / 2.0f));
            this.nJV = (int) ((((float) this.nJV) - ((((float) height) * this.nJW) / 2.0f)) - ((((float) this.nJY) * this.nJW) / 2.0f));
        }
    }

    @TargetApi(16)
    public final void a(View view, LinkedList<View> linkedList, View view2, b bVar) {
        if (VERSION.SDK_INT >= 12 && view != null && this.nKj != this.nKg && this.nKj != this.nKi && this.nKj != this.nKh) {
            j(view, false);
            e.eL(this.context);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setScaleX(this.nJW);
            view.setScaleY(this.nJW);
            view.setTranslationX((float) this.nJU);
            view.setTranslationY((float) this.nJV);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration((long) this.nKd);
            animatorSet.setInterpolator(new DecelerateInterpolator(1.2f));
            Builder play = animatorSet.play(ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{0.0f, 1.0f}));
            Animator ofFloat = ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{view.getScaleX(), 1.0f});
            Animator ofFloat2 = ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{view.getScaleY(), 1.0f});
            Animator ofFloat3 = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[]{view.getTranslationX(), 0.0f});
            play.with(ofFloat).with(ofFloat2).with(ofFloat3).with(ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{view.getTranslationY(), 0.0f}));
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                View view3 = (View) it.next();
                view3.setAlpha(0.0f);
                view3.setVisibility(0);
                view3.setTranslationY(100.0f);
                ofFloat3 = ObjectAnimator.ofFloat(view3, View.ALPHA, new float[]{0.0f, 1.0f});
                ofFloat = ObjectAnimator.ofFloat(view3, View.TRANSLATION_Y, new float[]{view3.getTranslationY(), 0.0f});
                ofFloat3.setDuration((long) (this.nKd >>> 1));
                ofFloat.setDuration((long) (this.nKd >>> 1));
                play.before(ofFloat3);
                play.before(ofFloat);
            }
            animatorSet.addListener(new 1(this, bVar));
            animatorSet.start();
        }
    }
}
