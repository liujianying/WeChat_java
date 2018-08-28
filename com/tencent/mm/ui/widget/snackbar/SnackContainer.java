package com.tencent.mm.ui.widget.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.bw.a.f;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.util.LinkedList;
import java.util.Queue;

public class SnackContainer extends FrameLayout {
    private final Runnable iFN = new Runnable() {
        public final void run() {
            if (SnackContainer.this.getVisibility() == 0) {
                SnackContainer.this.startAnimation(SnackContainer.this.uML);
            }
        }
    };
    private AnimationSet tPN;
    Queue<a> uMK = new LinkedList();
    private AnimationSet uML;

    private static class a {
        final View uMO;
        final TextView uMP;
        final TextView uMQ;
        final Snack uMR;
        final c uMS;

        /* synthetic */ a(Snack snack, View view, c cVar, byte b) {
            this(snack, view, cVar);
        }

        private a(Snack snack, View view, c cVar) {
            this.uMO = view;
            this.uMQ = (TextView) view.findViewById(f.snackButton);
            this.uMP = (TextView) view.findViewById(f.snackMessage);
            this.uMR = snack;
            this.uMS = cVar;
        }
    }

    public SnackContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    SnackContainer(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        viewGroup.addView(this, new LayoutParams(-1, -1));
        setVisibility(8);
        setId(f.snackContainer);
        init();
    }

    private void init() {
        this.tPN = new AnimationSet(false);
        Animation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.tPN.setInterpolator(new DecelerateInterpolator(1.5f));
        this.tPN.addAnimation(translateAnimation);
        this.tPN.addAnimation(alphaAnimation);
        this.uML = new AnimationSet(false);
        translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, 1.0f);
        alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.uML.addAnimation(translateAnimation);
        this.uML.addAnimation(alphaAnimation);
        this.uML.setDuration(300);
        this.uML.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                if (!SnackContainer.this.isEmpty() && SnackContainer.this.uMK.peek() != null && ((a) SnackContainer.this.uMK.peek()).uMS != null) {
                    b.mH(false);
                    ((a) SnackContainer.this.uMK.peek()).uMS.aSx();
                }
            }

            public final void onAnimationEnd(Animation animation) {
                SnackContainer.this.removeAllViews();
                if (!SnackContainer.this.uMK.isEmpty()) {
                    SnackContainer.b((a) SnackContainer.this.uMK.poll());
                }
                if (SnackContainer.this.isEmpty()) {
                    SnackContainer.this.setVisibility(8);
                } else {
                    SnackContainer.this.a((a) SnackContainer.this.uMK.peek());
                }
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.tPN.cancel();
        this.uML.cancel();
        removeCallbacks(this.iFN);
        this.uMK.clear();
    }

    public final boolean isEmpty() {
        return this.uMK.isEmpty();
    }

    public final boolean isShowing() {
        return !this.uMK.isEmpty();
    }

    public final void hide() {
        removeCallbacks(this.iFN);
        this.iFN.run();
    }

    final void a(final a aVar) {
        setVisibility(0);
        if (aVar.uMS != null) {
            b.mH(true);
            aVar.uMS.onShow();
        }
        addView(aVar.uMO);
        aVar.uMP.setText(aVar.uMR.kjg);
        if (aVar.uMR.uMv != null) {
            aVar.uMQ.setVisibility(0);
            aVar.uMQ.setText(aVar.uMR.uMv);
        } else {
            aVar.uMQ.setVisibility(8);
        }
        this.tPN.setDuration(500);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bw.a.a.fast_faded_in);
        loadAnimation.setDuration(500);
        startAnimation(this.tPN);
        loadAnimation.setStartOffset(200);
        aVar.uMQ.startAnimation(loadAnimation);
        aVar.uMP.startAnimation(loadAnimation);
        if (aVar.uMR.uMy > (short) 0) {
            postDelayed(this.iFN, (long) aVar.uMR.uMy);
        }
        aVar.uMO.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 4:
                        SnackContainer.this.removeCallbacks(SnackContainer.this.iFN);
                        SnackContainer.b(aVar);
                        SnackContainer.this.startAnimation(SnackContainer.this.uML);
                        if (!SnackContainer.this.uMK.isEmpty()) {
                            SnackContainer.this.uMK.clear();
                            break;
                        }
                        break;
                }
                return true;
            }
        });
    }

    private static void b(a aVar) {
        if (aVar.uMS != null) {
            b.mH(false);
            aVar.uMS.onHide();
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if ((i == 0 && b.aKp()) || 8 == i) {
            removeAllViews();
            if (!this.uMK.isEmpty()) {
                b((a) this.uMK.poll());
            }
            if (isEmpty()) {
                setVisibility(8);
            } else {
                a((a) this.uMK.peek());
            }
            b.mH(false);
        }
    }
}
