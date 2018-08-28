package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.w.a.b;
import com.tencent.mm.plugin.w.a.c;
import com.tencent.mm.plugin.w.a.d;
import com.tencent.mm.plugin.w.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.y;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class MMSightRecordButton extends FrameLayout {
    private static final float lol = (((float) ad.getContext().getResources().getDimensionPixelSize(b.mmsight_recorder_button_outer_size_max)) / ((float) ad.getContext().getResources().getDimensionPixelSize(b.mmsight_recorder_button_outer_size_init)));
    private static final int um = ViewConfiguration.getTapTimeout();
    private boolean bKe = true;
    private ag dvh = new ag(Looper.getMainLooper());
    private float hlo = -1.0f;
    private boolean isAnimating = false;
    private c loA;
    private a loB;
    private Drawable loC;
    private Drawable loD;
    private boolean loE = false;
    private boolean loF = false;
    private Runnable loG = new Runnable() {
        public final void run() {
            x.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[]{Boolean.valueOf(MMSightRecordButton.this.lor), Boolean.valueOf(MMSightRecordButton.this.los)});
            if (!MMSightRecordButton.this.lor) {
                MMSightRecordButton.this.los = true;
                if (MMSightRecordButton.this.loz != null) {
                    MMSightRecordButton.this.loz.bfh();
                }
            }
        }
    };
    private Runnable loH = new Runnable() {
        public final void run() {
            x.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[]{Boolean.valueOf(MMSightRecordButton.this.lox)});
            if (MMSightRecordButton.this.lox) {
                MMSightRecordButton.f(MMSightRecordButton.this);
            }
        }
    };
    private long lom = -1;
    private View lon;
    private View loo;
    View lop;
    MMSightCircularProgressBar loq;
    private boolean lor = false;
    private boolean los = false;
    private ViewPropertyAnimator lot;
    private ViewPropertyAnimator lou;
    private ViewPropertyAnimator lov;
    private ViewPropertyAnimator low;
    private boolean lox = false;
    private d loy;
    private b loz;

    static /* synthetic */ void f(MMSightRecordButton mMSightRecordButton) {
        mMSightRecordButton.isAnimating = true;
        if (mMSightRecordButton.lot != null) {
            mMSightRecordButton.lot.cancel();
            mMSightRecordButton.lot = null;
        }
        mMSightRecordButton.lot = mMSightRecordButton.lon.animate().scaleX(0.67f).scaleY(0.67f);
        mMSightRecordButton.lot.setListener(new 2(mMSightRecordButton)).setDuration(150).start();
        if (mMSightRecordButton.lou != null) {
            mMSightRecordButton.lou.cancel();
            mMSightRecordButton.lou = null;
        }
        mMSightRecordButton.lou = mMSightRecordButton.loo.animate().scaleX(lol).scaleY(lol);
        mMSightRecordButton.lou.setListener(new AnimatorListenerAdapter() {
            final /* synthetic */ AnimatorListenerAdapter loL = null;

            public final void onAnimationStart(Animator animator) {
                MMSightRecordButton.this.isAnimating = true;
                if (this.loL != null) {
                    this.loL.onAnimationStart(animator);
                }
            }

            public final void onAnimationEnd(Animator animator) {
                MMSightRecordButton.this.isAnimating = false;
                if (this.loL != null) {
                    this.loL.onAnimationEnd(animator);
                }
            }
        }).setDuration(150).start();
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        x.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[]{Integer.valueOf(TbsListener$ErrorCode.INFO_CODE_MINIQB), Integer.valueOf(um)});
        this.loC = getContext().getResources().getDrawable(c.mmsight_recorder_button_inner);
        this.loD = getContext().getResources().getDrawable(c.mmsight_recorder_button_outer);
        y.gq(getContext()).inflate(e.mmsight_recorder_button, this, true);
        this.lon = findViewById(d.inner);
        this.loo = findViewById(d.outer);
        this.lop = findViewById(d.progress_bar);
        this.loq = (MMSightCircularProgressBar) findViewById(d.circular_progress);
        this.lon.setBackgroundDrawable(this.loC);
        this.loo.setBackgroundDrawable(this.loD);
        this.bKe = true;
    }

    public void setSimpleTapCallback(d dVar) {
        this.loy = dVar;
    }

    public void setLongPressCallback(b bVar) {
        this.loz = bVar;
    }

    public void setLongPressScrollCallback(c cVar) {
        this.loA = cVar;
    }

    public void setErrorPressCallback(a aVar) {
        this.loB = aVar;
    }

    public void setTouchEnable(boolean z) {
        x.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[]{Boolean.valueOf(z)});
        this.bKe = z;
    }

    public final void bfe() {
        MMSightCircularProgressBar mMSightCircularProgressBar = this.loq;
        mMSightCircularProgressBar.loh = null;
        mMSightCircularProgressBar.lod = 0;
        mMSightCircularProgressBar.loe = 0;
        mMSightCircularProgressBar.duration = 0;
        mMSightCircularProgressBar.bTv = false;
        if (mMSightCircularProgressBar.log != null) {
            b bVar = mMSightCircularProgressBar.log;
            bVar.bTv = false;
            bVar.lps = 0;
            mMSightCircularProgressBar.log = null;
        }
        this.loq.setVisibility(8);
    }

    private void a(final AnimatorListenerAdapter animatorListenerAdapter) {
        this.isAnimating = true;
        if (this.lov != null) {
            this.lov.cancel();
            this.lov = null;
        }
        this.lov = this.lon.animate().scaleX(1.0f).scaleY(1.0f);
        this.lov.setListener(new 4(this, animatorListenerAdapter)).setDuration(150).start();
        if (this.low != null) {
            this.low.cancel();
            this.low = null;
        }
        this.low = this.loo.animate().scaleX(1.0f).scaleY(1.0f);
        this.low.setListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                MMSightRecordButton.this.isAnimating = true;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationStart(animator);
                }
            }

            public final void onAnimationEnd(Animator animator) {
                MMSightRecordButton.this.isAnimating = false;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
            }
        }).setDuration(150).start();
    }

    public void setVisibility(final int i) {
        x.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[]{Boolean.valueOf(this.isAnimating)});
        if (this.isAnimating) {
            postDelayed(new Runnable() {
                public final void run() {
                    super.setVisibility(i);
                }
            }, 150);
        } else {
            super.setVisibility(i);
        }
    }

    public final void reset() {
        setClipChildren(false);
        this.bKe = true;
        this.lon.setScaleX(1.0f);
        this.lon.setScaleY(1.0f);
        this.loo.setScaleX(1.0f);
        this.loo.setScaleY(1.0f);
        this.lop.setVisibility(8);
        bfe();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bKe) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.lox = true;
                    this.lom = System.currentTimeMillis();
                    this.lor = false;
                    this.los = false;
                    this.hlo = motionEvent.getRawY();
                    if (this.loz != null) {
                        this.loz.bfg();
                    }
                    this.dvh.postDelayed(this.loG, 550);
                    this.dvh.postDelayed(this.loH, 250);
                    this.loF = true;
                    this.loE = true;
                    break;
                case 1:
                case 3:
                    this.lox = false;
                    this.dvh.removeCallbacks(this.loH, Integer.valueOf(um));
                    this.dvh.removeCallbacks(this.loG);
                    if (!(this.lot == null || this.lou == null)) {
                        this.lot.cancel();
                        this.lou.cancel();
                    }
                    x.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[]{Boolean.valueOf(this.los), Boolean.valueOf(this.lor), Long.valueOf(this.lom), Long.valueOf(System.currentTimeMillis() - this.lom)});
                    bfe();
                    a(new 9(this, r2));
                    break;
                case 2:
                    x.d("MicroMsg.MMSightRecordButton", "move, x: %s, y: %s, top: %s", new Object[]{Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()), Integer.valueOf(getTop())});
                    float rawY = motionEvent.getRawY();
                    if (rawY < ((float) getTop()) && this.los) {
                        if (this.hlo > 0.0f) {
                            float abs = Math.abs(rawY - this.hlo);
                            int min;
                            c cVar;
                            if (rawY >= this.hlo || abs < 10.0f) {
                                if (rawY > this.hlo && abs >= 10.0f) {
                                    x.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[]{Integer.valueOf((int) (abs / 10.0f)), Boolean.valueOf(this.loF)});
                                    min = Math.min(min, 3);
                                    if (this.loA != null) {
                                        cVar = this.loA;
                                        if (this.loF) {
                                            min = 1;
                                        }
                                        cVar.tb(min);
                                    }
                                    this.loF = false;
                                    this.hlo = rawY;
                                    break;
                                }
                            }
                            x.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[]{Integer.valueOf((int) (abs / 10.0f)), Boolean.valueOf(this.loE)});
                            min = Math.min(min, 3);
                            if (this.loA != null) {
                                cVar = this.loA;
                                if (this.loE) {
                                    min = 1;
                                }
                                cVar.ta(min);
                            }
                            this.hlo = rawY;
                            this.loE = false;
                            break;
                        }
                        this.hlo = motionEvent.getRawY();
                        break;
                    }
                    break;
            }
        }
        x.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
        return true;
    }
}
