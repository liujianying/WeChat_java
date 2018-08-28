package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class ks$a extends Handler {
    private final WeakReference<ks> a;

    public ks$a(ks ksVar) {
        this.a = new WeakReference(ksVar);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.a != null && this.a.get() != null) {
            ks ksVar = (ks) this.a.get();
            or i = ks.i(ksVar);
            if (i != null) {
                if (ksVar.p == null) {
                    if (message.what == 0) {
                        if (ksVar.n != null) {
                            ks.a(ksVar, false);
                            ks.b(ksVar, true);
                            ksVar.n.a(i);
                        }
                    } else if (message.what == 1) {
                        if (ksVar.n != null) {
                            ks.a(ksVar, true);
                            if (ks.j(ksVar) && ks.k(ksVar) == 0) {
                                ks.b(ksVar, false);
                                ksVar.n.b(i);
                            }
                        }
                        if (ks.l(ksVar) != null && ks.m(ksVar)) {
                            ks.l(ksVar).a();
                        }
                        ksVar.getMap().E();
                    }
                }
                ks.n(ksVar);
            }
        }
    }
}
