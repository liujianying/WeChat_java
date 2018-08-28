package c.t.m.g;

final class ca implements Runnable {
    private /* synthetic */ int a;
    private /* synthetic */ bz b;

    ca(bz bzVar, int i) {
        this.b = bzVar;
        this.a = i;
    }

    public final void run() {
        bz.a(this.b).a(this.a);
    }
}
