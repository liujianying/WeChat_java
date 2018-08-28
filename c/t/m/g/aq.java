package c.t.m.g;

final class aq implements Runnable {
    private /* synthetic */ al a;

    aq(al alVar) {
        this.a = alVar;
    }

    public final void run() {
        if (al.e(this.a).size() == 0) {
            al.f(this.a).incrementAndGet();
            al.b(this.a, true);
            return;
        }
        al.a(this.a, true, true);
    }
}
