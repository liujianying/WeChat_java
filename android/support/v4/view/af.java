package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class af {
    static final c vU;

    interface c {
        void d(ViewGroup viewGroup);
    }

    static class f implements c {
        f() {
        }

        public void d(ViewGroup viewGroup) {
        }
    }

    static class a extends f {
        a() {
        }

        public final void d(ViewGroup viewGroup) {
            viewGroup.setMotionEventSplittingEnabled(false);
        }
    }

    static class b extends a {
        b() {
        }
    }

    static class d extends b {
        d() {
        }
    }

    static class e extends d {
        e() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            vU = new e();
        } else if (i >= 18) {
            vU = new d();
        } else if (i >= 14) {
            vU = new b();
        } else if (i >= 11) {
            vU = new a();
        } else {
            vU = new f();
        }
    }

    public static void d(ViewGroup viewGroup) {
        vU.d(viewGroup);
    }
}
