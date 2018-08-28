package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class ad {
    private static ThreadLocal<Rect> vR;

    /* renamed from: android.support.v4.view.ad$1 */
    static class AnonymousClass1 implements OnApplyWindowInsetsListener {
        final /* synthetic */ t vS;

        AnonymousClass1(t tVar) {
            this.vS = tVar;
        }

        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return ((aq) this.vS.a(view, new aq(windowInsets))).xp;
        }
    }

    static Rect cd() {
        if (vR == null) {
            vR = new ThreadLocal();
        }
        Rect rect = (Rect) vR.get();
        if (rect == null) {
            rect = new Rect();
            vR.set(rect);
        }
        rect.setEmpty();
        return rect;
    }
}
