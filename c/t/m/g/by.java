package c.t.m.g;

public final class by implements bd, bw {
    private static by a = new by();
    private bw b;
    private bd c;
    private boolean d = false;

    private by() {
    }

    public static by c() {
        return a;
    }

    public final void a() {
        this.b.a();
    }

    public final void a(int i) {
        this.b.a(i);
    }

    public final void a(bd bdVar) {
        this.c = bdVar;
    }

    public final void a(String str, String str2) {
        this.c.a(str, str2);
    }

    public final void a(String str, byte[] bArr, String str2) {
        this.c.a(str, bArr, str2);
    }

    public final void a_() {
        this.c.a_();
    }

    public final void b() {
        this.b.b();
    }

    public final synchronized void d() {
        if (!this.d) {
            this.b = bp.c();
            if (this.b != null) {
                this.b.a(this);
                this.b.d();
            }
            this.d = true;
        }
    }
}
