package com.tencent.mm.plugin.appbrand.widget.f;

import android.view.ViewPropertyAnimator;
import com.tencent.mm.plugin.appbrand.widget.f.a.3;

class a$1 implements Runnable {
    final /* synthetic */ a gOP;

    a$1(a aVar) {
        this.gOP = aVar;
    }

    public final void run() {
        a aVar = this.gOP;
        if (aVar.getAlpha() != 0.0f && aVar.gOO == null) {
            aVar.animate().cancel();
            ViewPropertyAnimator animate = aVar.animate();
            aVar.gOO = animate;
            animate.alpha(0.0f).setListener(new 3(aVar)).start();
        }
    }
}
