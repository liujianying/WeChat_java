package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.LinkedBlockingQueue;

public class ay {
    private LinkedBlockingQueue<am> a;
    private LinkedBlockingQueue<az> b;

    public void a(am amVar) {
        if (!this.a.offer(amVar)) {
            ax.a("AsyncCall|send queue is full");
        }
    }

    public void a(az azVar) {
        if (!this.b.offer(azVar)) {
            ax.a("AsyncCall|recv queue is full");
        }
    }
}
