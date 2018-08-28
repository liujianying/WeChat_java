package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;

public final class a implements d {
    public static final g aiU = new 1();
    private static final int amG = t.aE("ID3");
    private final long amH;
    private final b amI;
    private final j amJ;
    private boolean amK;

    public a() {
        this(0);
    }

    public a(long j) {
        this.amH = j;
        this.amI = new b();
        this.amJ = new j(2786);
    }

    public final void a(f fVar) {
        this.amI.a(fVar, new u$d());
        fVar.jU();
        com.google.android.exoplayer2.c.j.a aVar = new com.google.android.exoplayer2.c.j.a(-9223372036854775807L);
    }

    public final int a(e eVar) {
        int read = eVar.read(this.amJ.data, 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.amJ.setPosition(0);
        this.amJ.cZ(read);
        if (!this.amK) {
            this.amI.aih = this.amH;
            this.amK = true;
        }
        this.amI.b(this.amJ);
        return 0;
    }
}
