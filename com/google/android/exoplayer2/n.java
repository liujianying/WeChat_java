package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;

final class n {
    final b acM = new b();
    final a acN = new a();
    w acU;
    int repeatMode;

    public final f.b d(int i, long j) {
        this.acU.a(i, this.acN, false);
        int v = this.acN.v(j);
        if (v == -1) {
            return new f.b(i);
        }
        return new f.b(i, v, this.acN.afc[v]);
    }

    public final a a(a aVar, int i) {
        return a(aVar, aVar.aer.cF(i));
    }

    final a a(a aVar, f.b bVar) {
        long j = aVar.adK;
        long j2 = aVar.aes;
        boolean b = b(bVar, j2);
        boolean a = a(bVar, b);
        this.acU.a(bVar.arU, this.acN, false);
        long ar = bVar.kF() ? this.acN.ar(bVar.arV, bVar.arW) : j2 == Long.MIN_VALUE ? this.acN.aet : j2;
        return new a(bVar, j, j2, aVar.adL, ar, b, a, (byte) 0);
    }

    final a a(f.b bVar, long j, long j2) {
        this.acU.a(bVar.arU, this.acN, false);
        if (!bVar.kF()) {
            long j3;
            int w = this.acN.w(j2);
            if (w == -1) {
                j3 = Long.MIN_VALUE;
            } else {
                j3 = this.acN.aeZ[w];
            }
            return b(bVar.arU, j2, j3);
        } else if (this.acN.aq(bVar.arV, bVar.arW)) {
            return b(bVar.arU, bVar.arV, bVar.arW, j);
        } else {
            return null;
        }
    }

    final a b(int i, int i2, int i3, long j) {
        f.b bVar = new f.b(i, i2, i3);
        boolean b = b(bVar, Long.MIN_VALUE);
        boolean a = a(bVar, b);
        return new a(bVar, i3 == this.acN.afc[i2] ? this.acN.afe : 0, Long.MIN_VALUE, j, this.acU.a(bVar.arU, this.acN, false).ar(bVar.arV, bVar.arW), b, a, (byte) 0);
    }

    final a b(int i, long j, long j2) {
        long j3;
        f.b bVar = new f.b(i);
        boolean b = b(bVar, j2);
        boolean a = a(bVar, b);
        this.acU.a(bVar.arU, this.acN, false);
        if (j2 == Long.MIN_VALUE) {
            j3 = this.acN.aet;
        } else {
            j3 = j2;
        }
        return new a(bVar, j, j2, -9223372036854775807L, j3, b, a, (byte) 0);
    }

    private boolean b(f.b bVar, long j) {
        int iW = this.acU.a(bVar.arU, this.acN, false).iW();
        if (iW == 0) {
            return true;
        }
        int i = iW - 1;
        boolean kF = bVar.kF();
        if (this.acN.aeZ[i] == Long.MIN_VALUE) {
            int i2 = this.acN.afa[i];
            if (i2 == -1) {
                return false;
            }
            boolean z;
            if (kF && bVar.arV == i && bVar.arW == i2 - 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
            if (kF || this.acN.afc[i] != i2) {
                return false;
            }
            return true;
        } else if (kF || j != Long.MIN_VALUE) {
            return false;
        } else {
            return true;
        }
    }

    private boolean a(f.b bVar, boolean z) {
        if (!this.acU.a(this.acU.a(bVar.arU, this.acN, false).adO, this.acM, 0).afi) {
            if ((this.acU.a(bVar.arU, this.acN, this.acM, this.repeatMode) == -1) && z) {
                return true;
            }
        }
        return false;
    }
}
