package com.tencent.mm.plugin.backup.backuppcmodel;

class b$2 implements Runnable {
    final /* synthetic */ b gWv;

    b$2(b bVar) {
        this.gWv = bVar;
    }

    public final void run() {
        try {
            if (b.a(this.gWv) != null && b.a(this.gWv).isHeld()) {
                b.a(this.gWv).release();
            }
        } catch (Throwable th) {
        }
    }
}
