package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

final class x {
    private static final a jc;

    static {
        if (VERSION.SDK_INT >= 11) {
            jc = new c((byte) 0);
        } else {
            jc = new b((byte) 0);
        }
    }

    static void a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        jc.b(viewGroup, view, rect);
    }
}
