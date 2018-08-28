package com.tencent.mm.plugin.fts;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class b extends a implements Runnable {
    private int errorCode;
    private i joH;
    private WeakReference<l> joI;

    public b(int i, i iVar) {
        this.errorCode = i;
        this.joH = iVar;
        this.joI = new WeakReference(iVar.jsv);
        this.joH.jsv = null;
    }

    public final boolean execute() {
        if (this.errorCode == -2 || this.errorCode == -3) {
            j jVar = new j(this.joH);
            jVar.jsw = this;
            jVar.bjW = this.errorCode;
            jVar.jsx = new LinkedList();
            jVar.jrx = g.ax(this.joH.bWm, false);
            if (this.joH.handler == null) {
                l lVar = (l) this.joI.get();
                if (lVar != null) {
                    lVar.b(jVar);
                }
            } else {
                this.joH.handler.post(new 1(this, jVar));
            }
        }
        return true;
    }

    public final void run() {
        try {
            execute();
        } catch (Exception e) {
        }
    }

    public final int getPriority() {
        return 0;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final int getId() {
        return -1;
    }
}
