package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;

public final class l implements h {
    private k alX;
    private boolean anj;
    private long anl;
    private final j aor = new j(10);
    private int aos;
    private int sampleSize;

    public final void jX() {
        this.anj = false;
    }

    public final void a(f fVar, d dVar) {
        dVar.kf();
        this.alX = fVar.cp(dVar.kg());
        this.alX.f(Format.h(dVar.kh(), "application/id3"));
    }

    public final void d(long j, boolean z) {
        if (z) {
            this.anj = true;
            this.anl = j;
            this.sampleSize = 0;
            this.aos = 0;
        }
    }

    public final void b(j jVar) {
        if (this.anj) {
            int me = jVar.me();
            if (this.aos < 10) {
                int min = Math.min(me, 10 - this.aos);
                System.arraycopy(jVar.data, jVar.position, this.aor.data, this.aos, min);
                if (min + this.aos == 10) {
                    this.aor.setPosition(0);
                    if (73 == this.aor.readUnsignedByte() && 68 == this.aor.readUnsignedByte() && 51 == this.aor.readUnsignedByte()) {
                        this.aor.da(3);
                        this.sampleSize = this.aor.mg() + 10;
                    } else {
                        this.anj = false;
                        return;
                    }
                }
            }
            me = Math.min(me, this.sampleSize - this.aos);
            this.alX.a(jVar, me);
            this.aos = me + this.aos;
        }
    }

    public final void jY() {
        if (this.anj && this.sampleSize != 0 && this.aos == this.sampleSize) {
            this.alX.a(this.anl, 1, this.sampleSize, 0, null);
            this.anj = false;
        }
    }
}
