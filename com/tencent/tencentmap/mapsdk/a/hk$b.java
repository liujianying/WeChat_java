package com.tencent.tencentmap.mapsdk.a;

class hk$b extends Thread {
    final /* synthetic */ hk a;
    private boolean b;
    private boolean c;

    private hk$b(hk hkVar) {
        this.a = hkVar;
    }

    public synchronized void start() {
        this.b = true;
        super.start();
    }

    public synchronized void a() {
        this.c = true;
    }

    public synchronized void b() {
        this.c = false;
    }

    public synchronized void destroy() {
        this.b = false;
        interrupt();
    }

    public void run() {
        while (this.b) {
            if (!this.c) {
                if (hk.a(this.a) != null) {
                    hk.a(this.a).a(hi.h);
                }
                if (hk.b(this.a) && System.currentTimeMillis() - hk.c(this.a) > 500) {
                    hk.a(this.a, false);
                    if (hk.d(this.a) != null) {
                        hk.d(this.a).a();
                    }
                }
            }
            try {
                synchronized (this) {
                    wait(this.a.h());
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
