package c.t.m.g;

final class bo implements Runnable {
    private /* synthetic */ String a;
    private /* synthetic */ byte[] b;
    private /* synthetic */ bn c;

    bo(bn bnVar, String str, byte[] bArr) {
        this.c = bnVar;
        this.a = str;
        this.b = bArr;
    }

    public final void run() {
        String str = this.a;
        byte[] bArr = this.b;
        if (ci.a(str) || ci.a(bArr)) {
            p.e();
            str = p.b();
            bArr = this.c.a.a(str);
        }
        bp.c().a.a(str, bArr, null);
    }
}
