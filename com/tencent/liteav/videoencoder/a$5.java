package com.tencent.liteav.videoencoder;

class a$5 implements Runnable {
    final /* synthetic */ a a;

    a$5(a aVar) {
        this.a = aVar;
    }

    public void run() {
        if (a.c(this.a) != null) {
            try {
                a.c(this.a).signalEndOfInputStream();
            } catch (Exception e) {
            }
            do {
            } while (a.d(this.a) >= 0);
            a.a(this.a);
        }
    }
}
