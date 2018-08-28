package com.tencent.mm.plugin.appbrand.r;

import android.os.Looper;
import com.tencent.mm.sdk.d.d;
import java.util.LinkedList;
import java.util.Queue;

public abstract class f<Task> extends d {
    final b gBC = new b(this, (byte) 0);
    private final a gBD = new a(this, (byte) 0);
    final String gBE;
    public final Queue<Task> gBF = new LinkedList();

    public abstract boolean aic();

    public abstract void bk(Task task);

    static /* synthetic */ void a(f fVar) {
        Object poll;
        synchronized (fVar.gBF) {
            poll = fVar.gBF.poll();
        }
        if (poll != null) {
            fVar.b(fVar.gBD);
            fVar.bk(poll);
        }
    }

    public f(String str, Looper looper) {
        super(str, looper);
        this.gBE = str;
        a(this.gBC);
        a(this.gBD);
        b(this.gBC);
        start();
    }

    protected final void abD() {
        super.abD();
        synchronized (this.gBF) {
            this.gBF.clear();
        }
    }
}
