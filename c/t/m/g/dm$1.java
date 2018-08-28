package c.t.m.g;

class dm$1 implements Runnable {
    private /* synthetic */ dm a;

    dm$1(dm dmVar) {
        this.a = dmVar;
    }

    public final void run() {
        dm.a(this.a);
        if (dm.b(this.a) > 0) {
            this.a.a(dm.b(this.a));
        }
        new StringBuilder("Wifi_Scan_Interval:").append(dm.b(this.a));
    }
}
