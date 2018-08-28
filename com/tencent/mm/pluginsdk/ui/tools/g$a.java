package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.LinkedList;

abstract class g$a<T> {
    private ag handler;
    final /* synthetic */ g qSF;
    final int qSK = Math.max(1, 16);
    LinkedList<T> qSL = new LinkedList();

    protected abstract T cfp();

    public g$a(g gVar, Looper looper) {
        this.qSF = gVar;
        this.handler = new 1(this, looper, gVar);
    }

    public final T cfq() {
        if (this.qSL.isEmpty()) {
            return cfp();
        }
        return this.qSL.removeFirst();
    }

    public final void C(T t) {
        this.handler.sendMessage(this.handler.obtainMessage(1, t));
    }
}
