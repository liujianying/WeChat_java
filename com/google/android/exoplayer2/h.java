package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.f.c;
import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class h implements f {
    private final r[] acG;
    final g acH;
    private final f acI;
    private final Handler acJ;
    private final i acK;
    final CopyOnWriteArraySet<q$a> acL;
    private final b acM;
    private final a acN;
    boolean acO;
    boolean acP;
    int acQ;
    int acR;
    int acS;
    boolean acT;
    w acU;
    Object acV;
    m acW;
    f acX;
    p acY;
    i.b acZ;
    int ada;
    int adb;
    long adc;
    private int repeatMode;

    @SuppressLint({"HandlerLeak"})
    public h(r[] rVarArr, g gVar, m mVar) {
        new StringBuilder("Init ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(t.aCH).append("]");
        com.google.android.exoplayer2.i.a.ap(rVarArr.length > 0);
        this.acG = (r[]) com.google.android.exoplayer2.i.a.Z(rVarArr);
        this.acH = (g) com.google.android.exoplayer2.i.a.Z(gVar);
        this.acP = false;
        this.repeatMode = 0;
        this.acQ = 1;
        this.acL = new CopyOnWriteArraySet();
        this.acI = new f(new e[rVarArr.length]);
        this.acU = w.aeW;
        this.acM = new b();
        this.acN = new a();
        this.acW = m.asH;
        this.acX = this.acI;
        this.acY = p.aew;
        this.acJ = new 1(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.acZ = new i.b(0);
        this.acK = new i(rVarArr, gVar, mVar, this.acP, this.repeatMode, this.acJ, this.acZ, this);
    }

    public final void a(q$a q_a) {
        this.acL.add(q_a);
    }

    public final void b(q$a q_a) {
        this.acL.remove(q_a);
    }

    public final int iB() {
        return this.acQ;
    }

    public final void a(com.google.android.exoplayer2.source.f fVar) {
        Iterator it;
        if (!(this.acU.isEmpty() && this.acV == null)) {
            this.acU = w.aeW;
            this.acV = null;
            it = this.acL.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (this.acO) {
            this.acO = false;
            this.acW = m.asH;
            this.acX = this.acI;
            this.acH.X(null);
            it = this.acL.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        this.acS++;
        this.acK.handler.obtainMessage(0, 1, 0, fVar).sendToTarget();
    }

    public final void af(boolean z) {
        if (this.acP != z) {
            int i;
            this.acP = z;
            Handler handler = this.acK.handler;
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            handler.obtainMessage(1, i, 0).sendToTarget();
            Iterator it = this.acL.iterator();
            while (it.hasNext()) {
                ((q$a) it.next()).b(z, this.acQ);
            }
        }
    }

    public final boolean iC() {
        return this.acP;
    }

    public final boolean iD() {
        return this.acT;
    }

    public final void seekTo(long j) {
        int iE = iE();
        if (iE < 0 || (!this.acU.isEmpty() && iE >= this.acU.iU())) {
            throw new l(this.acU, iE, j);
        }
        this.acR++;
        this.ada = iE;
        if (this.acU.isEmpty()) {
            this.adb = 0;
        } else {
            this.acU.a(iE, this.acM, 0);
            long o = j == -9223372036854775807L ? this.acM.afl : b.o(j);
            int i = this.acM.afj;
            long j2 = this.acM.afm + o;
            o = this.acU.a(i, this.acN, false).aet;
            while (o != -9223372036854775807L && j2 >= o && i < this.acM.afk) {
                j2 -= o;
                i++;
                o = this.acU.a(i, this.acN, false).aet;
            }
            this.adb = i;
        }
        if (j == -9223372036854775807L) {
            this.adc = 0;
            this.acK.a(this.acU, iE, -9223372036854775807L);
            return;
        }
        this.adc = j;
        this.acK.a(this.acU, iE, b.o(j));
        Iterator it = this.acL.iterator();
        while (it.hasNext()) {
            ((q$a) it.next()).iS();
        }
    }

    public final void stop() {
        this.acK.handler.sendEmptyMessage(5);
    }

    public final void release() {
        new StringBuilder("Release ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(t.aCH).append("] [").append(j.iO()).append("]");
        this.acK.release();
        this.acJ.removeCallbacksAndMessages(null);
    }

    public final void a(c... cVarArr) {
        i iVar = this.acK;
        if (!iVar.released) {
            iVar.adp++;
            iVar.handler.obtainMessage(11, cVarArr).sendToTarget();
        }
    }

    public final void b(c... cVarArr) {
        this.acK.b(cVarArr);
    }

    private int iE() {
        if (this.acU.isEmpty() || this.acR > 0) {
            return this.ada;
        }
        return this.acU.a(this.acZ.adJ.arU, this.acN, false).adO;
    }

    public final long getDuration() {
        if (this.acU.isEmpty()) {
            return -9223372036854775807L;
        }
        boolean z;
        if (!this.acU.isEmpty() && this.acR == 0 && this.acZ.adJ.kF()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return b.n(this.acU.a(iE(), this.acM, 0).aet);
        }
        com.google.android.exoplayer2.source.f.b bVar = this.acZ.adJ;
        this.acU.a(bVar.arU, this.acN, false);
        return b.n(this.acN.ar(bVar.arV, bVar.arW));
    }

    public final long getCurrentPosition() {
        if (this.acU.isEmpty() || this.acR > 0) {
            return this.adc;
        }
        return q(this.acZ.adM);
    }

    public final long getBufferedPosition() {
        if (this.acU.isEmpty() || this.acR > 0) {
            return this.adc;
        }
        return q(this.acZ.adN);
    }

    public final int getBufferedPercentage() {
        if (this.acU.isEmpty()) {
            return 0;
        }
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return t.u((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    private long q(long j) {
        long n = b.n(j);
        if (this.acZ.adJ.kF()) {
            return n;
        }
        this.acU.a(this.acZ.adJ.arU, this.acN, false);
        return n + b.n(this.acN.aeY);
    }
}
