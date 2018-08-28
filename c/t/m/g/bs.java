package c.t.m.g;

final class bs implements Runnable {
    private /* synthetic */ bp a;

    bs(bp bpVar) {
        this.a = bpVar;
    }

    public final void run() {
        try {
            p.e();
            bp.a(this.a, p.b());
            bp.b(this.a).removeCallbacks(bp.a(this.a));
            bp.b(this.a).post(bp.a(this.a));
        } catch (Throwable th) {
        }
    }
}
