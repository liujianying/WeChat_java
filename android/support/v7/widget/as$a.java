package android.support.v7.widget;

import android.support.v4.e.i$a;
import android.support.v4.e.i$b;
import android.support.v7.widget.RecyclerView.e.c;

class as$a {
    static i$a<as$a> Xy = new i$b(20);
    c Xw;
    c Xx;
    int flags;

    private as$a() {
    }

    static as$a hj() {
        as$a as_a = (as$a) Xy.bW();
        return as_a == null ? new as$a() : as_a;
    }

    static void a(as$a as_a) {
        as_a.flags = 0;
        as_a.Xw = null;
        as_a.Xx = null;
        Xy.j(as_a);
    }

    static void hk() {
        do {
        } while (Xy.bW() != null);
    }
}
