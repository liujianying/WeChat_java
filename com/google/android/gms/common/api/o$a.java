package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.o.b;

final class o$a extends Handler {
    final /* synthetic */ o aLG;

    o$a(o oVar, Looper looper) {
        this.aLG = oVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                o oVar = this.aLG;
                oVar.aKI.lock();
                try {
                    if (oVar.oS()) {
                        oVar.connect();
                    }
                    oVar.aKI.unlock();
                    return;
                } catch (Throwable th) {
                    oVar.aKI.unlock();
                }
            case 2:
                o.a(this.aLG);
                return;
            case 3:
                ((b) message.obj).b(this.aLG);
                return;
            case 4:
                throw ((RuntimeException) message.obj);
            default:
                new StringBuilder("Unknown message id: ").append(message.what);
                return;
        }
    }
}
