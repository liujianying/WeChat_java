package com.tencent.mm.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class f {
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
    private int nJU = 0;
    private int nJV = 0;
    float nJW = 0.0f;
    float nJX = 1.0f;
    public int nJY = 0;
    public int nJZ = 0;
    public int nKa = 0;
    public int nKb = 0;
    public int nKc = 0;
    private int nKd = 300;
    int nKe = 0;
    int nKf = 1;
    int nKg = 2;
    int nKh = 3;
    int nKi = 4;
    int nKj = this.nKe;
    float uzP = 0.0f;
    private float uzQ = 1.0f;
    public float uzR = 1.0f;
    private int uzS = 0;
    int uzT = 0;
    private int uzU = 10;

    public f(Context context) {
        this.context = context;
    }

    public final void u(int i, int i2, int i3, int i4) {
        this.Tu = i;
        this.nJR = i2;
        this.mWidth = i3;
        this.mHeight = i4;
    }

    public final void fh(int i, int i2) {
        this.nJS = i;
        this.nJT = i2;
    }

    public final void fi(int i, int i2) {
        this.uzS = i;
        this.uzT = i2;
    }

    private void j(View view, boolean z) {
        int i;
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
        float f = this.uzQ;
        if (!(this.nJZ == 0 && this.nKa == 0 && this.nKb == 0 && this.nKc == 0)) {
            f = 1.1f;
        }
        if (z) {
            if (!(this.nJS == 0 || this.nJT == 0)) {
                this.aaI = ((float) this.mWidth) / ((float) this.nJS);
                this.aaJ = ((float) this.mHeight) / ((float) this.nJT);
            }
            f = 1.0f;
        }
        if (((double) this.uzR) != 1.0d) {
            this.nJU += iArr[0];
            this.nJV += iArr[1];
            this.nJW = this.aaI * this.uzR;
            this.uzP = this.nJW;
            this.nJV = (int) (((float) this.nJV) - (((float) this.uzT) * this.nJW));
            this.nJU = (int) (((float) this.nJU) - (((float) this.uzS) * this.nJW));
            return;
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
    public final void a(final View view, View view2, b bVar) {
        if (VERSION.SDK_INT >= 12 && view != null && this.nKj != this.nKg && this.nKj != this.nKi && this.nKj != this.nKh) {
            j(view, false);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setScaleX(this.nJW);
            view.setScaleY(this.nJW);
            view.setTranslationX((float) this.nJU);
            view.setTranslationY((float) this.nJV);
            if (view2 != null) {
                view2.setAlpha(0.0f);
                view2.animate().setDuration((long) this.nKd).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(1.0f);
            }
            view.animate().setDuration((long) this.nKd).setInterpolator(new DecelerateInterpolator(1.2f)).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setListener(new 1(this, bVar));
            this.mHandler.postDelayed(new Runnable() {
                public final void run() {
                    if (f.this.nKj == f.this.nKe) {
                        x.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
                        view.requestLayout();
                    }
                }
            }, (long) this.uzU);
        }
    }

    @TargetApi(16)
    public final void a(View view, View view2, b bVar, a aVar) {
        if (VERSION.SDK_INT < 12 || view == null || this.nKj == this.nKg || this.nKj == this.nKi || this.nKj == this.nKf) {
            x.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation not run! animationState: %s , gallery:%s", new Object[]{Integer.valueOf(this.nKj), view});
            return;
        }
        j(view, true);
        if (view2 != null) {
            view2.animate().setDuration(200).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(0.0f);
        }
        Animation animationSet = new AnimationSet(true);
        final View view3 = view;
        final a aVar2 = aVar;
        Animation anonymousClass3 = new ScaleAnimation(this.nJW, this.nJW) {
            protected final void applyTransformation(float f, Transformation transformation) {
                if (!(f.this.nJS == 0 || f.this.nJT == 0 || f.this.uzR != 1.0f)) {
                    Rect rect = new Rect();
                    view3.getGlobalVisibleRect(rect);
                    int i = (rect.right - rect.left) / 2;
                    int i2 = ((rect.bottom - rect.top) + f.this.nJY) / 2;
                    int i3 = (int) (((((float) (f.this.nJS - f.this.mWidth)) * (1.0f - f)) + ((float) f.this.mWidth)) / (1.0f - ((1.0f - f.this.nJW) * f)));
                    int i4 = (int) (((((float) (f.this.nJT - f.this.mHeight)) * (1.0f - f)) + ((float) f.this.mHeight)) / (1.0f - ((1.0f - f.this.nJW) * f)));
                    if (f.this.uzR != 1.0f) {
                        f.this.nJW = f.this.uzP / f.this.uzR;
                        i4 = rect.right;
                        i4 = rect.left;
                        i = (rect.right + rect.left) / 2;
                        i2 = (f.this.uzT - rect.top) + ((int) (((float) f.this.nJT) / 2.0f));
                        i3 = (int) (((((float) (f.this.nJS - f.this.mWidth)) * (1.0f - f)) + ((float) f.this.mWidth)) / (1.0f - ((1.0f - f.this.nJW) * f)));
                        i4 = (int) (((((float) (f.this.nJT - f.this.mHeight)) * (1.0f - f)) + ((float) f.this.mHeight)) / (1.0f - ((1.0f - f.this.nJW) * f)));
                    }
                    int i5 = (int) (((float) (i - (i3 / 2))) + ((((float) f.this.nJZ) * f) / (1.0f - ((1.0f - f.this.nJW) * f))));
                    int i6 = (int) ((((float) (i2 - (i4 / 2))) - ((((float) f.this.nJY) * (1.0f - f)) / 2.0f)) + ((((float) f.this.nKb) * f) / (1.0f - ((1.0f - f.this.nJW) * f))));
                    i3 = (int) (((float) ((i3 / 2) + i)) - ((((float) f.this.nKa) * f) / (1.0f - ((1.0f - f.this.nJW) * f))));
                    i4 = (int) (((float) ((i4 / 2) + i2)) - ((((float) f.this.nKc) * f) / (1.0f - ((1.0f - f.this.nJW) * f))));
                    if (VERSION.SDK_INT >= 21) {
                        view3.setClipBounds(new Rect(i5, i6, i3, i4));
                    } else if (VERSION.SDK_INT >= 18) {
                        if (aVar2 != null) {
                            aVar2.v(i5, i6, i3, i4);
                        } else {
                            view3.setClipBounds(new Rect(i5 + view3.getScrollX(), i6, i3 + view3.getScrollX(), i4));
                        }
                    }
                }
                super.applyTransformation(f, transformation);
            }
        };
        anonymousClass3.setDuration(200);
        anonymousClass3.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(anonymousClass3);
        anonymousClass3 = new TranslateAnimation(0.0f, (float) this.nJU, 0.0f, (float) this.nJV);
        anonymousClass3.setDuration(200);
        anonymousClass3.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(anonymousClass3);
        anonymousClass3 = new AlphaAnimation(1.0f, this.nJX);
        anonymousClass3.setDuration(200);
        anonymousClass3.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(anonymousClass3);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new 4(this, bVar));
        view.startAnimation(animationSet);
    }
}
