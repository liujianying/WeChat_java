package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.plugin.qqmail.b.p.b;

class p$b$1 implements Runnable {
    final /* synthetic */ b mdj;

    p$b$1(b bVar) {
        this.mdj = bVar;
    }

    public final void run() {
        if (b.a(this.mdj) != null) {
            b.a(this.mdj).cancel();
        }
    }

    public final String toString() {
        return super.toString() + "|onCancelled";
    }
}
