package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.ax.d;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.LinkedList;
import java.util.List;

public final class i {
    List<d> cWy = new LinkedList();
    ag handler = new ag(Looper.getMainLooper());

    public final void St() {
        1 1 = new 1(this);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            1.run();
        } else {
            this.handler.post(1);
        }
    }

    public final void i(String str, int i, int i2) {
        5 5 = new 5(this, str, i, i2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            5.run();
        } else {
            this.handler.post(5);
        }
    }

    public final void iA(int i) {
        7 7 = new 7(this, i);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            7.run();
        } else {
            this.handler.post(7);
        }
    }

    public final void nr(String str) {
        8 8 = new 8(this, str);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            8.run();
        } else {
            this.handler.post(8);
        }
    }

    public final void b(int i, int i2, String str) {
        9 9 = new 9(this, i, i2, str);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            9.run();
        } else {
            this.handler.post(9);
        }
    }
}
