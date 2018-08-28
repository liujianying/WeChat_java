package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;

public abstract class h extends a {
    private WeakReference<l> joI;
    public i jsj;
    public j jsk;

    public h(i iVar) {
        this.jsj = iVar;
        this.joI = new WeakReference(iVar.jsv);
    }

    public void a(j jVar) {
        jVar.jrx = g.ax(this.jsj.bWm, false);
        jVar.bjW = -5;
    }

    public final boolean execute() {
        i iVar = this.jsj;
        if (!bi.oW(iVar.bWm)) {
            try {
                iVar.bWm = new String(iVar.bWm.getBytes("UTF8"), "UTF8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        this.jsk = new j(this.jsj);
        l lVar;
        try {
            this.jsk.jsw = this;
            a(this.jsk);
            this.jsk.bjW = 0;
            if (this.jsj.handler == null) {
                lVar = (l) this.joI.get();
                if (lVar != null) {
                    lVar.b(this.jsk);
                }
            } else {
                this.jsj.handler.post(new 1(this));
            }
            return true;
        } catch (Exception e2) {
            if (e2 instanceof InterruptedException) {
                this.jsk.bjW = 1;
            } else {
                this.jsk.bjW = -1;
            }
            throw e2;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (this.jsj.handler == null) {
                lVar = (l) this.joI.get();
                if (lVar != null) {
                    lVar.b(this.jsk);
                }
            } else {
                this.jsj.handler.post(new 1(this));
            }
        }
    }
}
