package com.tencent.liteav.videoencoder;

class a$2 implements Runnable {
    final /* synthetic */ a a;

    a$2(a aVar) {
        this.a = aVar;
    }

    public void run() {
        if (this.a.mInit) {
            a.a(this.a);
            a.b(this.a).a().removeCallbacksAndMessages(null);
        }
    }
}
