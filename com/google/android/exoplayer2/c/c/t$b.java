package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.c.c.u.a;
import com.google.android.exoplayer2.c.c.u.b;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class t$b implements p {
    final /* synthetic */ t apd;
    private final i ape = new i(new byte[5]);
    private final SparseArray<u> apf = new SparseArray();
    private final SparseIntArray apg = new SparseIntArray();
    private final int pid;

    public t$b(t tVar, int i) {
        this.apd = tVar;
        this.pid = i;
    }

    public final void a(q qVar, f fVar, u$d u_d) {
    }

    public final void b(j jVar) {
        if (jVar.readUnsignedByte() == 2) {
            q qVar;
            int cY;
            int i;
            int i2;
            if (t.c(this.apd) == 1 || t.c(this.apd) == 2 || t.d(this.apd) == 1) {
                qVar = (q) t.e(this.apd).get(0);
            } else {
                qVar = new q(((q) t.e(this.apd).get(0)).amH);
                t.e(this.apd).add(qVar);
            }
            jVar.da(2);
            int readUnsignedShort = jVar.readUnsignedShort();
            jVar.da(5);
            jVar.c(this.ape, 2);
            this.ape.cX(4);
            jVar.da(this.ape.cY(12));
            if (t.c(this.apd) == 2 && t.f(this.apd) == null) {
                t.a(this.apd, t.g(this.apd).a(21, new b(21, null, null, new byte[0])));
                t.f(this.apd).a(qVar, t.h(this.apd), new u$d(readUnsignedShort, 21, 8192));
            }
            this.apf.clear();
            this.apg.clear();
            int me = jVar.me();
            while (me > 0) {
                int i3;
                jVar.c(this.ape, 5);
                cY = this.ape.cY(8);
                this.ape.cX(3);
                int cY2 = this.ape.cY(13);
                this.ape.cX(4);
                int cY3 = this.ape.cY(12);
                int i4 = jVar.position;
                int i5 = i4 + cY3;
                i = -1;
                String str = null;
                List list = null;
                while (jVar.position < i5) {
                    int readUnsignedByte = jVar.readUnsignedByte();
                    int readUnsignedByte2 = jVar.readUnsignedByte() + jVar.position;
                    if (readUnsignedByte == 5) {
                        long ba = jVar.ba();
                        if (ba == t.kc()) {
                            i = 129;
                        } else if (ba == t.kd()) {
                            i = 135;
                        } else if (ba == t.ke()) {
                            i = 36;
                        }
                    } else if (readUnsignedByte == 106) {
                        i = 129;
                    } else if (readUnsignedByte == 122) {
                        i = 135;
                    } else if (readUnsignedByte == 123) {
                        i = 138;
                    } else if (readUnsignedByte == 10) {
                        str = jVar.readString(3).trim();
                    } else if (readUnsignedByte == 89) {
                        i = 89;
                        list = new ArrayList();
                        while (jVar.position < readUnsignedByte2) {
                            String trim = jVar.readString(3).trim();
                            int readUnsignedByte3 = jVar.readUnsignedByte();
                            byte[] bArr = new byte[4];
                            jVar.readBytes(bArr, 0, 4);
                            list.add(new a(trim, readUnsignedByte3, bArr));
                        }
                    }
                    jVar.da(readUnsignedByte2 - jVar.position);
                }
                jVar.setPosition(i5);
                b bVar = new b(i, str, list, Arrays.copyOfRange(jVar.data, i4, i5));
                if (cY == 6) {
                    i3 = bVar.streamType;
                } else {
                    i3 = cY;
                }
                i = me - (cY3 + 5);
                i2 = t.c(this.apd) == 2 ? i3 : cY2;
                if (t.i(this.apd).get(i2)) {
                    me = i;
                } else {
                    Object f;
                    if (t.c(this.apd) == 2 && i3 == 21) {
                        f = t.f(this.apd);
                    } else {
                        f = t.g(this.apd).a(i3, bVar);
                    }
                    if (t.c(this.apd) != 2 || cY2 < this.apg.get(i2, 8192)) {
                        this.apg.put(i2, cY2);
                        this.apf.put(i2, f);
                    }
                    me = i;
                }
            }
            i = this.apg.size();
            for (i2 = 0; i2 < i; i2++) {
                cY = this.apg.keyAt(i2);
                t.i(this.apd).put(cY, true);
                u uVar = (u) this.apf.valueAt(i2);
                if (uVar != null) {
                    if (uVar != t.f(this.apd)) {
                        uVar.a(qVar, t.h(this.apd), new u$d(readUnsignedShort, cY, 8192));
                    }
                    t.a(this.apd).put(this.apg.valueAt(i2), uVar);
                }
            }
            if (t.c(this.apd) != 2) {
                t.a(this.apd).remove(this.pid);
                t.a(this.apd, t.c(this.apd) == 1 ? 0 : t.d(this.apd) - 1);
                if (t.d(this.apd) == 0) {
                    t.h(this.apd).jU();
                    t.k(this.apd);
                }
            } else if (!t.j(this.apd)) {
                t.h(this.apd).jU();
                t.a(this.apd, 0);
                t.k(this.apd);
            }
        }
    }
}
