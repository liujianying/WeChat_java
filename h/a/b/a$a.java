package h.a.b;

import h.a.c.a;
import h.a.c.b;

class a$a {
    short[] vLu = new short[2];
    a[] vLv = new a[16];
    a[] vLw = new a[16];
    a vLx = new a(8);
    int vLy = 0;
    final /* synthetic */ a vLz;

    a$a(a aVar) {
        this.vLz = aVar;
    }

    public final void IH(int i) {
        while (this.vLy < i) {
            this.vLv[this.vLy] = new a(3);
            this.vLw[this.vLy] = new a(3);
            this.vLy++;
        }
    }

    public final void cKI() {
        b.c(this.vLu);
        for (int i = 0; i < this.vLy; i++) {
            b.c(this.vLv[i].vLG);
            b.c(this.vLw[i].vLG);
        }
        b.c(this.vLx.vLG);
    }

    public final int a(b bVar, int i) {
        if (bVar.e(this.vLu, 0) == 0) {
            return this.vLv[i].a(bVar);
        }
        if (bVar.e(this.vLu, 1) == 0) {
            return this.vLw[i].a(bVar) + 8;
        }
        return (this.vLx.a(bVar) + 8) + 8;
    }
}
