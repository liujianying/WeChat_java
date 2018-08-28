package com.tencent.mm.ui.widget.a;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mm.ui.widget.a.c.a.c;

class c$1 implements OnClickListener {
    final /* synthetic */ c uJH;
    final /* synthetic */ ImageView uJI;
    final /* synthetic */ c uJJ;

    c$1(c cVar, c cVar2, ImageView imageView) {
        this.uJJ = cVar;
        this.uJH = cVar2;
        this.uJI = imageView;
    }

    public final void onClick(View view) {
        if (this.uJH != null) {
            this.uJH.cdN();
        }
        if (this.uJI.isSelected()) {
            c.c(this.uJJ).startAnimation(c.b(this.uJJ));
            c.b(this.uJJ).setAnimationListener(new 1(this));
            ObjectAnimator.ofFloat(this.uJI, "rotation", new float[]{180.0f, 0.0f}).setDuration(200).start();
            this.uJI.setSelected(false);
            return;
        }
        c.c(this.uJJ).startAnimation(c.e(this.uJJ));
        c.e(this.uJJ).setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                c.a(c$1.this.uJJ, c.f(c$1.this.uJJ));
            }

            public final void onAnimationEnd(Animation animation) {
                c.c(c$1.this.uJJ).setVisibility(0);
                c.a(c$1.this.uJJ, 8);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        ObjectAnimator.ofFloat(this.uJI, "rotation", new float[]{0.0f, 180.0f}).setDuration(200).start();
        this.uJI.setSelected(true);
    }
}
