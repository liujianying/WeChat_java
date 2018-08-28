package com.tencent.xweb.xwalk;

class b$2 implements Runnable {
    final /* synthetic */ b vEH;

    b$2(b bVar) {
        this.vEH = bVar;
    }

    public final void run() {
        while (this.vEH.vEG) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
