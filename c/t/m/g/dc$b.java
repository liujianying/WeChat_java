package c.t.m.g;

class dc$b implements Runnable {
    dp a;
    private ct b;

    public dc$b(ct ctVar) {
        this.b = ctVar;
    }

    public final void run() {
        ct ctVar = this.b;
        Object obj = this.a;
        if (obj != null) {
            obj.a(ec.c(ctVar));
            ctVar.c(obj);
        }
    }
}
