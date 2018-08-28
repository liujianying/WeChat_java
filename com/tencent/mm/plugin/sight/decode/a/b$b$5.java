package com.tencent.mm.plugin.sight.decode.a;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.plugin.sight.decode.a.b.b;

class b$b$5 implements Runnable {
    final /* synthetic */ b ncZ;

    b$b$5(b bVar) {
        this.ncZ = bVar;
    }

    public final void run() {
        if (b.q(this.ncZ.ncT) != null) {
            View bvP = b.q(this.ncZ.ncT).bvP();
            if (bvP != null) {
                if (!(b.C(this.ncZ.ncT) != null || b.q(this.ncZ.ncT).bvQ() == -1 || b.k(this.ncZ.ncT).get() == null)) {
                    b.a(this.ncZ.ncT, AnimationUtils.loadAnimation(((View) b.k(this.ncZ.ncT).get()).getContext(), b.q(this.ncZ.ncT).bvQ()));
                }
                if (b.C(this.ncZ.ncT) != null) {
                    bvP.startAnimation(b.C(this.ncZ.ncT));
                }
                bvP.setVisibility(0);
            }
        }
    }
}
