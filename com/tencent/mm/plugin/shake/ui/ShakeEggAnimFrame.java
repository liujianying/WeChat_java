package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.br.c;
import com.tencent.mm.br.g;
import com.tencent.mm.plugin.appbrand.s$l;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class ShakeEggAnimFrame extends FrameLayout {
    List<View> mZj = new ArrayList();
    int mZk = 0;
    int size = 0;

    class b extends a {
        private int ftm;
        private int ftn;
        private float mZn;
        private float mZo;
        private float mZp;
        private float mZq;
        private float mZr = 0.01f;
        private float mZs = 0.02f;
        private float mZt;
        private float mZu;
        private float mZv;
        private float mZw;

        public b(int i, int i2) {
            super(ShakeEggAnimFrame.this);
            this.ftm = i;
            this.ftn = i2;
            this.mZn = ShakeEggAnimFrame.E(0.1f, 0.9f);
            this.mZo = this.mZn;
            this.mZq = ShakeEggAnimFrame.E(-0.3f, -0.1f);
            restart();
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.mZt;
            float f3 = this.mZv;
            if (this.mZt != this.mZu) {
                f2 = this.mZt + ((this.mZu - this.mZt) * f);
            }
            if (this.mZv != this.mZw) {
                f3 = this.mZv + ((this.mZw - this.mZv) * f);
            }
            transformation.getMatrix().setTranslate(f2, f3);
            if (f == 1.0f) {
                restart();
            }
        }

        private void restart() {
            if (this.mZq > 0.0f) {
                this.mZs += this.mZr;
            }
            this.mZp = this.mZq;
            this.mZq += this.mZs;
            if (this.mZp > 1.1f) {
                Assert.assertTrue(this.targetView != null);
                this.targetView.post(new 1(this));
            }
            this.mZt = this.mZn * ((float) this.ftm);
            this.mZu = this.mZo * ((float) this.ftm);
            this.mZv = this.mZp * ((float) this.ftn);
            this.mZw = this.mZq * ((float) this.ftn);
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            setRepeatCount(-1);
            setDuration((long) this.duration);
        }
    }

    public ShakeEggAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void G(Activity activity) {
        for (View view : this.mZj) {
            view.clearAnimation();
            removeView(view);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        setVisibility(0);
        for (int i = 0; i < 30; i++) {
            b bVar = new b(displayMetrics.widthPixels, displayMetrics.heightPixels);
            g.cjL();
            com.tencent.mm.br.b cjC = com.tencent.mm.br.b.cjC();
            Drawable a = cjC.a((c) cjC.sLA.get(s$l.AppCompatTheme_ratingBarStyleIndicator), true);
            a.setBounds(0, 0, getSize(), getSize());
            ImageSpan imageSpan = new ImageSpan(a, 1);
            CharSequence spannableString = new SpannableString("  ");
            spannableString.setSpan(imageSpan, 0, 1, 33);
            View textView = new TextView(getContext());
            textView.setSingleLine();
            textView.setText(spannableString);
            textView.setAnimation(bVar);
            textView.setTag(bVar);
            addView(textView);
            ((a) bVar).targetView = textView;
            this.mZj.add(textView);
        }
    }

    static float E(float f, float f2) {
        return (((float) Math.random()) * (f2 - f)) + f;
    }

    int getSize() {
        if (this.size == 0) {
            return (int) (((double) new TextView(getContext()).getTextSize()) * 1.2d);
        }
        return this.size;
    }
}
