package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tencentmap.mapsdk.a.kh.a;

class ni$1 extends Handler {
    final /* synthetic */ ni a;

    ni$1(ni niVar, Looper looper) {
        this.a = niVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message != null && message.obj != null) {
            lh lhVar = (lh) message.obj;
            if (lhVar.a == 0) {
                if (ni.a(this.a) != null) {
                    ni.a(this.a).a(lhVar.b, lhVar.c);
                }
                if (ni.b(this.a) != null) {
                    ni.b(this.a).c();
                }
            } else if (lhVar.a == 1) {
                if (ni.b(this.a) != null) {
                    ni.b(this.a).a(lhVar.d, lhVar.e);
                }
            } else if (lhVar.a == 3 && kh.f == a.b && ni.c(this.a) != null) {
                if (ni.d(this.a) == null) {
                    ni.a(this.a, new lc(ni.c(this.a).getContext()));
                }
                ni.d(this.a).a(ni.c(this.a));
            }
        }
    }
}
