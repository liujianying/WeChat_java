package com.tencent.mm.plugin.appbrand.game.c;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.game.c.b.4;

class b$1 implements OnClickListener {
    final /* synthetic */ b fBh;

    b$1(b bVar) {
        this.fBh = bVar;
    }

    public final void onClick(View view) {
        b bVar = this.fBh;
        ValueAnimator ofFloat;
        if (bVar.fBd) {
            ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new b$3(bVar));
            ofFloat.start();
            bVar.fBd = false;
            return;
        }
        ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(new 4(bVar));
        ofFloat.start();
        bVar.fBd = true;
    }
}
