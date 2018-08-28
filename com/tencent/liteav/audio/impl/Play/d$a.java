package com.tencent.liteav.audio.impl.Play;

class d$a extends Thread {
    volatile boolean b = false;
    final /* synthetic */ d c;

    public d$a(d dVar, String str) {
        this.c = dVar;
        super(str);
    }

    public void a() {
        this.b = true;
    }

    public void b() {
        this.b = false;
    }
}
