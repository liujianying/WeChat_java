package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.a.a$a;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;

class f$1 extends a$a {
    int ccQ = -1;
    final /* synthetic */ f jEt;

    f$1(f fVar) {
        this.jEt = fVar;
    }

    public final boolean a(RecyclerView$t recyclerView$t, RecyclerView$t recyclerView$t2) {
        int gm = recyclerView$t.gm();
        int gm2 = recyclerView$t2.gm();
        this.jEt.Y(gm, gm2);
        if (f.a(this.jEt) != null) {
            f.a(this.jEt).cG(gm, gm2);
        }
        f.a(this.jEt, gm2);
        return false;
    }

    public final void e(RecyclerView$t recyclerView$t, int i) {
        super.e(recyclerView$t, i);
        if (recyclerView$t != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(f.b(this.jEt), R.a.move_scale_out);
            loadAnimation.setAnimationListener(new 1(this, i, recyclerView$t));
            ((f$a) recyclerView$t).jEz.startAnimation(loadAnimation);
        }
    }

    public final void c(RecyclerView recyclerView, RecyclerView$t recyclerView$t) {
        if (recyclerView$t != null) {
            super.c(recyclerView, recyclerView$t);
            Animation loadAnimation = AnimationUtils.loadAnimation(f.b(this.jEt), R.a.move_scale_in);
            loadAnimation.setAnimationListener(new 2(this));
            ((f$a) recyclerView$t).jEz.startAnimation(loadAnimation);
        }
    }

    public final void ht() {
    }

    public final float hs() {
        return 0.295858f;
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView$t recyclerView$t, float f, float f2, int i, boolean z) {
        super.a(canvas, recyclerView, recyclerView$t, f / 1.3f, f2 / 1.3f, i, z);
    }

    public final int hm() {
        return 3342387;
    }

    public final boolean ho() {
        return true;
    }

    public final boolean hp() {
        return false;
    }
}
