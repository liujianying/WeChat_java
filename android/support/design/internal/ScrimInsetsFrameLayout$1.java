package android.support.design.internal;

import android.graphics.Rect;
import android.support.v4.view.ap;
import android.support.v4.view.t;
import android.support.v4.view.z;
import android.view.View;

class ScrimInsetsFrameLayout$1 implements t {
    final /* synthetic */ ScrimInsetsFrameLayout bK;

    ScrimInsetsFrameLayout$1(ScrimInsetsFrameLayout scrimInsetsFrameLayout) {
        this.bK = scrimInsetsFrameLayout;
    }

    public final ap a(View view, ap apVar) {
        if (ScrimInsetsFrameLayout.a(this.bK) == null) {
            ScrimInsetsFrameLayout.a(this.bK, new Rect());
        }
        ScrimInsetsFrameLayout.a(this.bK).set(apVar.getSystemWindowInsetLeft(), apVar.getSystemWindowInsetTop(), apVar.getSystemWindowInsetRight(), apVar.getSystemWindowInsetBottom());
        this.bK.c(ScrimInsetsFrameLayout.a(this.bK));
        ScrimInsetsFrameLayout scrimInsetsFrameLayout = this.bK;
        boolean z = ScrimInsetsFrameLayout.a(this.bK).isEmpty() || ScrimInsetsFrameLayout.b(this.bK) == null;
        scrimInsetsFrameLayout.setWillNotDraw(z);
        z.E(this.bK);
        return apVar.co();
    }
}
