package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.c.c.u.c;
import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j$a;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class t implements d {
    public static final g aiU = new 1();
    private static final long aoP = ((long) com.google.android.exoplayer2.i.t.aE("AC-3"));
    private static final long aoQ = ((long) com.google.android.exoplayer2.i.t.aE("EAC3"));
    private static final long aoR = ((long) com.google.android.exoplayer2.i.t.aE("HEVC"));
    private final List<q> aoS;
    private final j aoT;
    private final SparseIntArray aoU;
    private final c aoV;
    private final SparseArray<u> aoW;
    private final SparseBooleanArray aoX;
    private f aoY;
    private int aoZ;
    private boolean apa;
    private u apb;
    private final int mode;

    public t() {
        this((byte) 0);
    }

    private t(byte b) {
        this(0);
    }

    private t(char c) {
        this(1, new q(0), new e((byte) 0));
    }

    public t(int i, q qVar, c cVar) {
        this.aoV = (c) a.Z(cVar);
        this.mode = i;
        if (i == 1 || i == 2) {
            this.aoS = Collections.singletonList(qVar);
        } else {
            this.aoS = new ArrayList();
            this.aoS.add(qVar);
        }
        this.aoT = new j(9400);
        this.aoX = new SparseBooleanArray();
        this.aoW = new SparseArray();
        this.aoU = new SparseIntArray();
        kb();
    }

    public final void a(f fVar) {
        this.aoY = fVar;
        j$a j_a = new j$a(-9223372036854775807L);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.c.e r12) {
        /*
        r11 = this;
        r7 = 188; // 0xbc float:2.63E-43 double:9.3E-322;
        r0 = -1;
        r1 = 1;
        r2 = 0;
        r3 = r11.aoT;
        r3 = r3.data;
        r4 = r11.aoT;
        r4 = r4.position;
        r4 = 9400 - r4;
        if (r4 >= r7) goto L_0x0025;
    L_0x0011:
        r4 = r11.aoT;
        r4 = r4.me();
        if (r4 <= 0) goto L_0x0020;
    L_0x0019:
        r5 = r11.aoT;
        r5 = r5.position;
        java.lang.System.arraycopy(r3, r5, r3, r2, r4);
    L_0x0020:
        r5 = r11.aoT;
        r5.m(r3, r4);
    L_0x0025:
        r4 = r11.aoT;
        r4 = r4.me();
        if (r4 >= r7) goto L_0x0042;
    L_0x002d:
        r4 = r11.aoT;
        r4 = r4.limit;
        r5 = 9400 - r4;
        r5 = r12.read(r3, r4, r5);
        if (r5 != r0) goto L_0x003b;
    L_0x0039:
        r2 = r0;
    L_0x003a:
        return r2;
    L_0x003b:
        r6 = r11.aoT;
        r4 = r4 + r5;
        r6.cZ(r4);
        goto L_0x0025;
    L_0x0042:
        r0 = r11.aoT;
        r5 = r0.limit;
        r0 = r11.aoT;
        r0 = r0.position;
    L_0x004a:
        if (r0 >= r5) goto L_0x0055;
    L_0x004c:
        r4 = r3[r0];
        r6 = 71;
        if (r4 == r6) goto L_0x0055;
    L_0x0052:
        r0 = r0 + 1;
        goto L_0x004a;
    L_0x0055:
        r3 = r11.aoT;
        r3.setPosition(r0);
        r6 = r0 + 188;
        if (r6 > r5) goto L_0x003a;
    L_0x005e:
        r0 = r11.aoT;
        r7 = r0.readInt();
        r0 = 8388608; // 0x800000 float:1.17549435E-38 double:4.144523E-317;
        r0 = r0 & r7;
        if (r0 == 0) goto L_0x006f;
    L_0x0069:
        r0 = r11.aoT;
        r0.setPosition(r6);
        goto L_0x003a;
    L_0x006f:
        r0 = 4194304; // 0x400000 float:5.877472E-39 double:2.0722615E-317;
        r0 = r0 & r7;
        if (r0 == 0) goto L_0x00a3;
    L_0x0074:
        r4 = r1;
    L_0x0075:
        r0 = 2096896; // 0x1fff00 float:2.938377E-39 double:1.0360043E-317;
        r0 = r0 & r7;
        r8 = r0 >> 8;
        r0 = r7 & 32;
        if (r0 == 0) goto L_0x00a5;
    L_0x007f:
        r3 = r1;
    L_0x0080:
        r0 = r7 & 16;
        if (r0 == 0) goto L_0x00a7;
    L_0x0084:
        r0 = r1;
    L_0x0085:
        r9 = r11.mode;
        r10 = 2;
        if (r9 == r10) goto L_0x00e3;
    L_0x008a:
        r7 = r7 & 15;
        r9 = r11.aoU;
        r10 = r7 + -1;
        r9 = r9.get(r8, r10);
        r10 = r11.aoU;
        r10.put(r8, r7);
        if (r9 != r7) goto L_0x00a9;
    L_0x009b:
        if (r0 == 0) goto L_0x00e3;
    L_0x009d:
        r0 = r11.aoT;
        r0.setPosition(r6);
        goto L_0x003a;
    L_0x00a3:
        r4 = r2;
        goto L_0x0075;
    L_0x00a5:
        r3 = r2;
        goto L_0x0080;
    L_0x00a7:
        r0 = r2;
        goto L_0x0085;
    L_0x00a9:
        r9 = r9 + 1;
        r9 = r9 & 15;
        if (r7 == r9) goto L_0x00e3;
    L_0x00af:
        if (r3 == 0) goto L_0x00bc;
    L_0x00b1:
        r3 = r11.aoT;
        r3 = r3.readUnsignedByte();
        r7 = r11.aoT;
        r7.da(r3);
    L_0x00bc:
        if (r0 == 0) goto L_0x00dc;
    L_0x00be:
        r0 = r11.aoW;
        r0 = r0.get(r8);
        r0 = (com.google.android.exoplayer2.c.c.u) r0;
        if (r0 == 0) goto L_0x00dc;
    L_0x00c8:
        if (r1 == 0) goto L_0x00cd;
    L_0x00ca:
        r0.jX();
    L_0x00cd:
        r1 = r11.aoT;
        r1.cZ(r6);
        r1 = r11.aoT;
        r0.a(r1, r4);
        r0 = r11.aoT;
        r0.cZ(r5);
    L_0x00dc:
        r0 = r11.aoT;
        r0.setPosition(r6);
        goto L_0x003a;
    L_0x00e3:
        r1 = r2;
        goto L_0x00af;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.c.t.a(com.google.android.exoplayer2.c.e):int");
    }

    private void kb() {
        this.aoX.clear();
        this.aoW.clear();
        SparseArray ka = this.aoV.ka();
        int size = ka.size();
        for (int i = 0; i < size; i++) {
            this.aoW.put(ka.keyAt(i), ka.valueAt(i));
        }
        this.aoW.put(0, new q(new a(this)));
        this.apb = null;
    }
}
