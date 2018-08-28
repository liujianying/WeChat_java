package com.d.a.a;

import android.content.Context;
import android.os.Handler;

abstract class a extends d implements m {
    private final Handler[] bgA = new Handler[this.bgz.length];
    private final com.d.a.a.d.a[] bgB = new com.d.a.a.d.a[this.bgA.length];
    private final d[] bgz;

    abstract void a(Handler handler, Handler[] handlerArr);

    abstract void a(com.d.a.a.d.a aVar, com.d.a.a.d.a[] aVarArr);

    a(d... dVarArr) {
        this.bgz = dVarArr;
    }

    final void aw(Context context) {
        for (d a : this.bgz) {
            try {
                a.a(context, new m[]{this});
            } catch (Exception e) {
            }
        }
    }

    void a(Context context, Handler handler, com.d.a.a.d.a aVar) {
        a(handler, this.bgA);
        a(aVar, this.bgB);
        for (int i = 0; i < this.bgz.length; i++) {
            try {
                this.bgz[i].a(this.bgA[i], this.bgB[i]);
            } catch (Exception e) {
            }
        }
    }

    final void ax(Context context) {
        for (d stop : this.bgz) {
            stop.stop();
        }
    }

    final void sr() {
        for (d su : this.bgz) {
            su.su();
        }
    }
}
