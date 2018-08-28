package com.tencent.mm.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.f.e;
import java.util.LinkedList;

class f$e$c extends ag {
    long lastUpdateTime;
    final /* synthetic */ e thW;
    long tia;
    final int tib = (hashCode() | 1910);
    final int tic = (hashCode() | 1914);

    public f$e$c(e eVar, Looper looper) {
        this.thW = eVar;
        super(looper);
        eVar.thT = new LinkedList();
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == this.tic) {
            removeMessages(this.tib);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.tia > ((long) this.thW.thN.thF) || currentTimeMillis - this.tia < 0 || ((this.lastUpdateTime != 0 && currentTimeMillis - this.lastUpdateTime > ((long) this.thW.thN.thG)) || currentTimeMillis - this.lastUpdateTime < 0)) {
                e.a(this.thW);
            } else {
                sendEmptyMessageDelayed(this.tib, (long) this.thW.thN.thF);
            }
            this.tia = currentTimeMillis;
        } else if (message.what == this.tib) {
            e.a(this.thW);
        }
    }
}
