package android.support.v4.a;

import android.os.Build.VERSION;
import android.view.View;

public final class a {
    private static final c mc;

    static {
        if (VERSION.SDK_INT >= 12) {
            mc = new f();
        } else {
            mc = new e();
        }
    }

    public static g bb() {
        return mc.bb();
    }

    public static void v(View view) {
        mc.v(view);
    }
}
