package android.support.design.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class r {
    WeakReference<View> cB;
    final ArrayList<a> gR = new ArrayList();
    a gS = null;
    Animation gT = null;
    private AnimationListener gU = new 1(this);

    r() {
    }

    public final void a(int[] iArr, Animation animation) {
        a aVar = new a(iArr, animation, (byte) 0);
        animation.setAnimationListener(this.gU);
        this.gR.add(aVar);
    }

    final View aF() {
        return this.cB == null ? null : (View) this.cB.get();
    }
}
