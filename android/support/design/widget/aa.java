package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.design.widget.u.d;
import android.view.View;

final class aa {
    static final d jn = new 1();
    private static final a jo;

    static {
        if (VERSION.SDK_INT >= 21) {
            jo = new c((byte) 0);
        } else {
            jo = new b((byte) 0);
        }
    }

    static void u(View view) {
        jo.u(view);
    }

    static u aP() {
        return jn.aP();
    }
}
