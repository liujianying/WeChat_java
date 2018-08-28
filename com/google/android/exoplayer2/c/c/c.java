package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j.a;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;

public final class c implements d {
    public static final g aiU = new 1();
    private static final int amG = t.aE("ID3");
    private final long amH;
    private boolean amK;
    private final d amR;
    private final j amS;

    public c() {
        this(0);
    }

    public c(long j) {
        this.amH = j;
        this.amR = new d();
        this.amS = new j(200);
    }

    public final void a(f fVar) {
        this.amR.a(fVar, new u.d());
        fVar.jU();
        a aVar = new a(-9223372036854775807L);
    }

    public final int a(e eVar) {
        int read = eVar.read(this.amS.data, 0, 200);
        if (read == -1) {
            return -1;
        }
        this.amS.setPosition(0);
        this.amS.cZ(read);
        if (!this.amK) {
            this.amR.aih = this.amH;
            this.amK = true;
        }
        this.amR.b(this.amS);
        return 0;
    }
}
