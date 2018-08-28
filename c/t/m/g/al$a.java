package c.t.m.g;

public abstract class al$a implements Runnable {
    private /* synthetic */ al a;

    private al$a(al alVar) {
        this.a = alVar;
    }

    /* synthetic */ al$a(al alVar, byte b) {
        this(alVar);
    }

    public final void a(boolean z) {
        if (!z) {
            al.a(this.a).post(this);
        } else if (!al.a(this.a).postAtFrontOfQueue(this)) {
            al.a(this.a).post(this);
        }
    }
}
