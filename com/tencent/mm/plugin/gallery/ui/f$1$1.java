package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.t;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.gallery.ui.f.1;
import com.tencent.mm.sdk.platformtools.x;

class f$1$1 implements AnimationListener {
    final /* synthetic */ int jEu;
    final /* synthetic */ t jEv;
    final /* synthetic */ 1 jEw;

    f$1$1(1 1, int i, t tVar) {
        this.jEw = 1;
        this.jEu = i;
        this.jEv = tVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.jEu == 2) {
            f.b(this.jEw.jEt, f.a(this.jEw.jEt, this.jEv.gm()));
            this.jEw.ccQ = f.c(this.jEw.jEt);
            x.i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", new Object[]{Integer.valueOf(this.jEw.ccQ)});
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
