package com.tencent.mm.ui;

class p$1 implements Runnable {
    final /* synthetic */ p tli;

    p$1(p pVar) {
        this.tli = pVar;
    }

    public final void run() {
        if (this.tli.tlh != null) {
            this.tli.tlh.run();
        }
    }

    public final String toString() {
        return super.toString() + "|onInitDelay";
    }
}
