package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.a;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;
import java.util.Collections;
import java.util.List;

public final class g implements h {
    private int alP;
    private final List<a> anh;
    private final k[] ani;
    private boolean anj;
    private int ank;
    private long anl;

    public g(List<a> list) {
        this.anh = list;
        this.ani = new k[list.size()];
    }

    public final void jX() {
        this.anj = false;
    }

    public final void a(f fVar, d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ani.length) {
                a aVar = (a) this.anh.get(i2);
                dVar.kf();
                k cp = fVar.cp(dVar.kg());
                cp.f(Format.a(dVar.kh(), "application/dvbsubs", Collections.singletonList(aVar.aph), aVar.aem));
                this.ani[i2] = cp;
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public final void d(long j, boolean z) {
        if (z) {
            this.anj = true;
            this.anl = j;
            this.alP = 0;
            this.ank = 2;
        }
    }

    public final void jY() {
        if (this.anj) {
            for (k a : this.ani) {
                a.a(this.anl, 1, this.alP, 0, null);
            }
            this.anj = false;
        }
    }

    public final void b(j jVar) {
        int i = 0;
        if (!this.anj) {
            return;
        }
        if (this.ank == 2 && !c(jVar, 32)) {
            return;
        }
        if (this.ank != 1 || c(jVar, 0)) {
            int i2 = jVar.position;
            int me = jVar.me();
            k[] kVarArr = this.ani;
            int length = kVarArr.length;
            while (i < length) {
                k kVar = kVarArr[i];
                jVar.setPosition(i2);
                kVar.a(jVar, me);
                i++;
            }
            this.alP += me;
        }
    }

    private boolean c(j jVar, int i) {
        if (jVar.me() == 0) {
            return false;
        }
        if (jVar.readUnsignedByte() != i) {
            this.anj = false;
        }
        this.ank--;
        return this.anj;
    }
}
