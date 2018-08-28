package android.support.v4.widget;

import android.support.v4.widget.l.a;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class l$2 implements AnimationListener {
    final /* synthetic */ a Ai;
    final /* synthetic */ l Aj;

    l$2(l lVar, a aVar) {
        this.Aj = lVar;
        this.Ai = aVar;
    }

    public final void onAnimationStart(Animation animation) {
        l.a(this.Aj, 0.0f);
    }

    public final void onAnimationEnd(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
        this.Ai.cL();
        a aVar = this.Ai;
        aVar.av(aVar.cK());
        this.Ai.D(this.Ai.An);
        if (this.Aj.Ah) {
            this.Aj.Ah = false;
            animation.setDuration(1332);
            this.Ai.B(false);
            return;
        }
        l.a(this.Aj, (l.a(this.Aj) + 1.0f) % 5.0f);
    }
}
