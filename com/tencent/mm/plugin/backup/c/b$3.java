package com.tencent.mm.plugin.backup.c;

class b$3 implements Runnable {
    final /* synthetic */ b gTI;

    b$3(b bVar) {
        this.gTI = bVar;
    }

    public final void run() {
        try {
            if (b.a(this.gTI) != null && b.a(this.gTI).isHeld()) {
                b.a(this.gTI).release();
            }
        } catch (Throwable th) {
        }
    }
}
