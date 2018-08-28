package com.d.a.a;

import android.os.Handler;
import com.d.a.a.d.a;

abstract class c extends d {
    private boolean bgF;

    abstract void ss();

    abstract void st();

    c() {
    }

    synchronized void a(Handler handler, a aVar) {
        this.bgF = false;
        super.a(handler, aVar);
    }

    final synchronized void az(boolean z) {
        if ((this.bgF ^ z) != 0) {
            this.bgF = z;
            if (this.bgF) {
                ss();
            } else {
                st();
            }
        }
    }
}
