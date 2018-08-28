package com.tencent.mm.plugin.sns.a.b;

class i$3 implements Runnable {
    final /* synthetic */ i njJ;

    i$3(i iVar) {
        this.njJ = iVar;
    }

    public final void run() {
        if (System.currentTimeMillis() - i.b(this.njJ) >= 60000 || i.a(this.njJ).rbN.size() > 1000) {
            if (i.a(this.njJ) != null && i.a(this.njJ).rbN.size() > 0) {
                i.d(this.njJ);
            }
            i.a(this.njJ, 0);
        }
    }
}
