package com.tencent.mm.e.b;

import java.util.TimerTask;

class e$a extends TimerTask {
    private int bEA = this.bEC.bEm;
    byte[] bEB = new byte[this.bEz];
    final /* synthetic */ e bEC;
    private int bEz = (this.bEC.bEm * 2);

    e$a(e eVar) {
        this.bEC = eVar;
    }

    public final void run() {
        if (!this.bEC.mIsPause) {
            int wq = (int) (0.8d * ((double) this.bEC.wq()));
            if (wq < this.bEC.bEm * 8) {
                wq = this.bEC.bEm * 8;
            }
            if (this.bEC.wr() > wq) {
                wq = 8;
            } else {
                wq = 1;
            }
            for (int i = 0; i < wq; i++) {
                int v = this.bEC.v(this.bEB, this.bEA);
                if (this.bEC.bEs != null && v == 0) {
                    this.bEC.bEs.s(this.bEB, this.bEA);
                }
            }
        }
    }
}
