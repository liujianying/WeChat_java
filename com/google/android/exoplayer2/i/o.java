package com.google.android.exoplayer2.i;

import android.os.SystemClock;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.p;

public final class o implements f {
    private long aCD;
    public long aCE;
    private p acY = p.aew;
    public boolean started;

    public final void stop() {
        if (this.started) {
            O(jn());
            this.started = false;
        }
    }

    public final void O(long j) {
        this.aCD = j;
        if (this.started) {
            this.aCE = SystemClock.elapsedRealtime();
        }
    }

    public final void a(f fVar) {
        O(fVar.jn());
        this.acY = fVar.ju();
    }

    public final long jn() {
        long j = this.aCD;
        if (!this.started) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.aCE;
        if (this.acY.aex == 1.0f) {
            return j + b.o(elapsedRealtime);
        }
        return j + (elapsedRealtime * ((long) this.acY.aey));
    }

    public final p b(p pVar) {
        if (this.started) {
            O(jn());
        }
        this.acY = pVar;
        return pVar;
    }

    public final p ju() {
        return this.acY;
    }
}
