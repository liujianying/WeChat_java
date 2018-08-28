package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public boolean bTv;
    public boolean hEj;
    public com.tencent.mm.e.b.c kql;
    public final Object kqm;
    int kqn;
    boolean kqo;
    int kqp;
    boolean kqq;
    com.tencent.mm.e.b.c.a kqr;

    private class a implements Runnable {
        private com.tencent.mm.e.b.c kqt = null;

        public a(com.tencent.mm.e.b.c cVar) {
            this.kqt = cVar;
        }

        public final void run() {
            x.d("MicroMsg.IPCallRecorder", "do stopRecord");
            if (this.kqt != null) {
                this.kqt.we();
                this.kqt = null;
                c cVar = c.this;
                cVar.kqn = 92;
                cVar.kqo = true;
                cVar.kqp = 0;
            }
        }
    }

    public c() {
        this.kql = null;
        this.kqm = new Object();
        this.bTv = false;
        this.hEj = false;
        this.kqn = 92;
        this.kqo = true;
        this.kqp = 0;
        this.kqq = true;
        this.kqr = new 1(this);
        this.bTv = false;
    }

    public final void setMute(boolean z) {
        x.i("MicroMsg.IPCallRecorder", "setMute: %b", new Object[]{Boolean.valueOf(z)});
        if (this.bTv && this.kql != null) {
            this.kql.aO(z);
        }
        this.hEj = z;
    }
}
