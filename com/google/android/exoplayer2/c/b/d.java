package com.google.android.exoplayer2.c.b;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.b.a.b;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j$a;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.k$a;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.o;
import com.tencent.map.lib.gl.model.GLIcon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class d implements com.google.android.exoplayer2.c.d {
    public static final g aiU = new 1();
    private static final int als = t.aE("seig");
    private static final byte[] alt = new byte[]{(byte) -94, (byte) 57, (byte) 79, (byte) 82, (byte) 90, (byte) -101, (byte) 79, (byte) 20, (byte) -94, (byte) 68, (byte) 108, (byte) 66, (byte) 124, (byte) 100, (byte) -115, (byte) -12};
    private long aet;
    private f ajc;
    private final j alA;
    private final q alB;
    private final j alC;
    private final byte[] alD;
    private final Stack<com.google.android.exoplayer2.c.b.a.a> alE;
    private final LinkedList<a> alF;
    private int alG;
    private int alH;
    private long alI;
    private int alJ;
    private j alK;
    private long alL;
    private int alM;
    private long alN;
    private b alO;
    private int alP;
    private int alQ;
    private boolean alR;
    private k alS;
    private k[] alT;
    private boolean alU;
    private final e alu;
    private final SparseArray<b> alv;
    private final j alw;
    private final j alx;
    private final j aly;
    private final j alz;
    private final int flags;
    private int sampleSize;

    private static final class a {
        public final long alV;
        public final int size;

        public a(long j, int i) {
            this.alV = j;
            this.size = i;
        }
    }

    public d() {
        this((byte) 0);
    }

    private d(byte b) {
        this(null);
    }

    public d(q qVar) {
        this(qVar, (byte) 0);
    }

    private d(q qVar, byte b) {
        this.flags = 0;
        this.alB = qVar;
        this.alu = null;
        this.alC = new j(16);
        this.alw = new j(h.aBV);
        this.alx = new j(5);
        this.aly = new j();
        this.alz = new j(1);
        this.alA = new j();
        this.alD = new byte[16];
        this.alE = new Stack();
        this.alF = new LinkedList();
        this.alv = new SparseArray();
        this.aet = -9223372036854775807L;
        this.alN = -9223372036854775807L;
        jV();
    }

    public final void a(f fVar) {
        this.ajc = fVar;
        if (this.alu != null) {
            b bVar = new b(fVar.cp(0));
            bVar.a(this.alu, new c(0, 0, 0, 0));
            this.alv.put(0, bVar);
            jW();
            this.ajc.jU();
        }
    }

    public final int a(e eVar) {
        while (true) {
            Object obj;
            long length;
            long position;
            int size;
            g gVar;
            int i;
            long ba;
            int me;
            b bVar;
            b bVar2;
            switch (this.alG) {
                case 0:
                    if (this.alJ == 0) {
                        if (!eVar.a(this.alC.data, 0, 8, true)) {
                            obj = null;
                            if (obj == null) {
                                break;
                            }
                            return -1;
                        }
                        this.alJ = 8;
                        this.alC.setPosition(0);
                        this.alI = this.alC.ba();
                        this.alH = this.alC.readInt();
                    }
                    if (this.alI == 1) {
                        eVar.readFully(this.alC.data, 8, 8);
                        this.alJ += 8;
                        this.alI = this.alC.mi();
                    } else if (this.alI == 0) {
                        length = eVar.getLength();
                        if (length == -1 && !this.alE.isEmpty()) {
                            length = ((com.google.android.exoplayer2.c.b.a.a) this.alE.peek()).ald;
                        }
                        if (length != -1) {
                            this.alI = (length - eVar.getPosition()) + ((long) this.alJ);
                        }
                    }
                    if (this.alI < ((long) this.alJ)) {
                        throw new o("Atom size less than header length (unsupported).");
                    }
                    position = eVar.getPosition() - ((long) this.alJ);
                    if (this.alH == a.ajY) {
                        size = this.alv.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            gVar = ((b) this.alv.valueAt(i2)).alW;
                            gVar.amp = position;
                            gVar.amr = position;
                            gVar.amq = position;
                        }
                    }
                    if (this.alH == a.ajv) {
                        this.alO = null;
                        this.alL = this.alI + position;
                        if (!this.alU) {
                            j$a j_a = new j$a(this.aet);
                            this.alU = true;
                        }
                        this.alG = 2;
                    } else {
                        i = this.alH;
                        obj = (i == a.ajP || i == a.ajR || i == a.ajS || i == a.ajT || i == a.ajU || i == a.ajY || i == a.ajZ || i == a.aka || i == a.akd) ? 1 : null;
                        if (obj != null) {
                            length = (eVar.getPosition() + this.alI) - 8;
                            this.alE.add(new com.google.android.exoplayer2.c.b.a.a(this.alH, length));
                            if (this.alI == ((long) this.alJ)) {
                                D(length);
                            } else {
                                jV();
                            }
                        } else {
                            i = this.alH;
                            obj = (i == a.akg || i == a.akf || i == a.ajQ || i == a.ajO || i == a.akh || i == a.ajK || i == a.ajL || i == a.akc || i == a.ajM || i == a.ajN || i == a.aki || i == a.akq || i == a.akr || i == a.akv || i == a.aku || i == a.aks || i == a.akt || i == a.ake || i == a.akb || i == a.akU) ? 1 : null;
                            if (obj != null) {
                                if (this.alJ != 8) {
                                    throw new o("Leaf atom defines extended atom size (unsupported).");
                                } else if (this.alI > 2147483647L) {
                                    throw new o("Leaf atom with length > 2147483647 (unsupported).");
                                } else {
                                    this.alK = new j((int) this.alI);
                                    System.arraycopy(this.alC.data, 0, this.alK.data, 0, 8);
                                    this.alG = 1;
                                }
                            } else if (this.alI > 2147483647L) {
                                throw new o("Skipping atom with length > 2147483647 (unsupported).");
                            } else {
                                this.alK = null;
                                this.alG = 1;
                            }
                        }
                    }
                    obj = 1;
                    if (obj == null) {
                        break;
                    }
                    return -1;
                case 1:
                    i = ((int) this.alI) - this.alJ;
                    if (this.alK != null) {
                        eVar.readFully(this.alK.data, 8, i);
                        b bVar3 = new b(this.alH, this.alK);
                        position = eVar.getPosition();
                        if (!this.alE.isEmpty()) {
                            ((com.google.android.exoplayer2.c.b.a.a) this.alE.peek()).ale.add(bVar3);
                        } else if (bVar3.type == a.ajO) {
                            long ba2;
                            j jVar = bVar3.alg;
                            jVar.setPosition(8);
                            i = a.cs(jVar.readInt());
                            jVar.da(4);
                            ba = jVar.ba();
                            if (i == 0) {
                                length = jVar.ba();
                                ba2 = position + jVar.ba();
                            } else {
                                length = jVar.mi();
                                ba2 = position + jVar.mi();
                            }
                            long a = t.a(length, 1000000, ba);
                            jVar.da(2);
                            int readUnsignedShort = jVar.readUnsignedShort();
                            int[] iArr = new int[readUnsignedShort];
                            long[] jArr = new long[readUnsignedShort];
                            long[] jArr2 = new long[readUnsignedShort];
                            long[] jArr3 = new long[readUnsignedShort];
                            position = a;
                            for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                                int readInt = jVar.readInt();
                                if ((Integer.MIN_VALUE & readInt) != 0) {
                                    throw new o("Unhandled indirect reference");
                                }
                                long ba3 = jVar.ba();
                                iArr[i3] = readInt & Integer.MAX_VALUE;
                                jArr[i3] = ba2;
                                jArr3[i3] = position;
                                length += ba3;
                                position = t.a(length, 1000000, ba);
                                jArr2[i3] = position - jArr3[i3];
                                jVar.da(4);
                                ba2 += (long) iArr[i3];
                            }
                            Pair create = Pair.create(Long.valueOf(a), new com.google.android.exoplayer2.c.a(iArr, jArr, jArr2, jArr3));
                            this.alN = ((Long) create.first).longValue();
                            obj = create.second;
                            this.alU = true;
                        } else if (bVar3.type == a.akU) {
                            j jVar2 = bVar3.alg;
                            if (this.alS != null) {
                                jVar2.setPosition(12);
                                jVar2.mj();
                                jVar2.mj();
                                position = t.a(jVar2.ba(), 1000000, jVar2.ba());
                                jVar2.setPosition(12);
                                me = jVar2.me();
                                this.alS.a(jVar2, me);
                                if (this.alN != -9223372036854775807L) {
                                    this.alS.a(position + this.alN, 1, me, 0, null);
                                } else {
                                    this.alF.addLast(new a(position, me));
                                    this.alM += me;
                                }
                            }
                        }
                    } else {
                        eVar.ck(i);
                    }
                    D(eVar.getPosition());
                    break;
                case 2:
                    bVar = null;
                    position = Long.MAX_VALUE;
                    me = this.alv.size();
                    size = 0;
                    while (size < me) {
                        gVar = ((b) this.alv.valueAt(size)).alW;
                        if (!gVar.amE || gVar.amr >= position) {
                            bVar2 = bVar;
                        } else {
                            position = gVar.amr;
                            bVar2 = (b) this.alv.valueAt(size);
                        }
                        size++;
                        bVar = bVar2;
                    }
                    if (bVar != null) {
                        i = (int) (position - eVar.getPosition());
                        if (i >= 0) {
                            eVar.ck(i);
                            gVar = bVar.alW;
                            eVar.readFully(gVar.amD.data, 0, gVar.amC);
                            gVar.amD.setPosition(0);
                            gVar.amE = false;
                            break;
                        }
                        throw new o("Offset to encryption data was negative.");
                    }
                    this.alG = 3;
                    break;
                default:
                    int size2;
                    int i4;
                    if (this.alG == 3) {
                        if (this.alO == null) {
                            SparseArray sparseArray = this.alv;
                            bVar = null;
                            ba = Long.MAX_VALUE;
                            size2 = sparseArray.size();
                            i4 = 0;
                            while (i4 < size2) {
                                bVar2 = (b) sparseArray.valueAt(i4);
                                if (bVar2.amc != bVar2.alW.ams) {
                                    position = bVar2.alW.amt[bVar2.amc];
                                    if (position < ba) {
                                        i4++;
                                        ba = position;
                                        bVar = bVar2;
                                    }
                                }
                                position = ba;
                                bVar2 = bVar;
                                i4++;
                                ba = position;
                                bVar = bVar2;
                            }
                            if (bVar == null) {
                                i = (int) (this.alL - eVar.getPosition());
                                if (i >= 0) {
                                    eVar.ck(i);
                                    jV();
                                    obj = null;
                                    if (obj != null) {
                                        break;
                                    }
                                    return 0;
                                }
                                throw new o("Offset to end of mdat was negative.");
                            }
                            i = (int) (bVar.alW.amt[bVar.amc] - eVar.getPosition());
                            if (i < 0) {
                                i = 0;
                            }
                            eVar.ck(i);
                            this.alO = bVar;
                        }
                        this.sampleSize = this.alO.alW.amv[this.alO.ama];
                        if (this.alO.alW.amz) {
                            j jVar3;
                            b bVar4 = this.alO;
                            g gVar2 = bVar4.alW;
                            f cx = gVar2.amB != null ? gVar2.amB : bVar4.alY.cx(gVar2.amo.alr);
                            if (cx.amm != 0) {
                                jVar3 = gVar2.amD;
                                i = cx.amm;
                            } else {
                                byte[] bArr = cx.amn;
                                this.alA.m(bArr, bArr.length);
                                jVar3 = this.alA;
                                i = bArr.length;
                            }
                            boolean z = gVar2.amA[bVar4.ama];
                            this.alz.data[0] = (byte) ((z ? 128 : 0) | i);
                            this.alz.setPosition(0);
                            k kVar = bVar4.alX;
                            kVar.a(this.alz, 1);
                            kVar.a(jVar3, i);
                            if (z) {
                                jVar3 = gVar2.amD;
                                int readUnsignedShort2 = jVar3.readUnsignedShort();
                                jVar3.da(-2);
                                readUnsignedShort2 = (readUnsignedShort2 * 6) + 2;
                                kVar.a(jVar3, readUnsignedShort2);
                                i = (i + 1) + readUnsignedShort2;
                            } else {
                                i++;
                            }
                            this.alP = i;
                            this.sampleSize += this.alP;
                        } else {
                            this.alP = 0;
                        }
                        if (this.alO.alY.amf == 1) {
                            this.sampleSize -= 8;
                            eVar.ck(8);
                        }
                        this.alG = 4;
                        this.alQ = 0;
                    }
                    g gVar3 = this.alO.alW;
                    e eVar2 = this.alO.alY;
                    k kVar2 = this.alO.alX;
                    size = this.alO.ama;
                    if (eVar2.alp != 0) {
                        byte[] bArr2 = this.alx.data;
                        bArr2[0] = (byte) 0;
                        bArr2[1] = (byte) 0;
                        bArr2[2] = (byte) 0;
                        i4 = eVar2.alp + 1;
                        int i5 = 4 - eVar2.alp;
                        while (this.alP < this.sampleSize) {
                            if (this.alQ == 0) {
                                eVar.readFully(bArr2, i5, i4);
                                this.alx.setPosition(0);
                                this.alQ = this.alx.mh() - 1;
                                this.alw.setPosition(0);
                                kVar2.a(this.alw, 4);
                                kVar2.a(this.alx, 1);
                                boolean z2 = this.alT != null && h.b(eVar2.aep.adW, bArr2[4]);
                                this.alR = z2;
                                this.alP += 5;
                                this.sampleSize += i5;
                            } else {
                                if (this.alR) {
                                    this.aly.reset(this.alQ);
                                    eVar.readFully(this.aly.data, 0, this.alQ);
                                    kVar2.a(this.aly, this.alQ);
                                    int i6 = this.alQ;
                                    size2 = h.i(this.aly.data, this.aly.limit);
                                    this.aly.setPosition("video/hevc".equals(eVar2.aep.adW) ? 1 : 0);
                                    this.aly.cZ(size2);
                                    com.google.android.exoplayer2.f.a.g.a(gVar3.cz(size) * 1000, this.aly, this.alT);
                                    i = i6;
                                } else {
                                    i = kVar2.a(eVar, this.alQ, false);
                                }
                                this.alP += i;
                                this.alQ -= i;
                            }
                        }
                    } else {
                        while (this.alP < this.sampleSize) {
                            this.alP = kVar2.a(eVar, this.sampleSize - this.alP, false) + this.alP;
                        }
                    }
                    position = gVar3.cz(size) * 1000;
                    if (this.alB != null) {
                        position = this.alB.U(position);
                    }
                    i = gVar3.amy[size] ? 1 : 0;
                    k$a k_a = null;
                    if (gVar3.amz) {
                        size = 1073741824 | i;
                        k_a = (gVar3.amB != null ? gVar3.amB : eVar2.cx(gVar3.amo.alr)).aml;
                    } else {
                        size = i;
                    }
                    kVar2.a(position, size, this.sampleSize, 0, k_a);
                    while (!this.alF.isEmpty()) {
                        a aVar = (a) this.alF.removeFirst();
                        this.alM -= aVar.size;
                        this.alS.a(aVar.alV + position, 1, aVar.size, this.alM, null);
                    }
                    bVar2 = this.alO;
                    bVar2.ama++;
                    bVar2 = this.alO;
                    bVar2.amb++;
                    if (this.alO.amb == gVar3.amu[this.alO.amc]) {
                        bVar2 = this.alO;
                        bVar2.amc++;
                        this.alO.amb = 0;
                        this.alO = null;
                    }
                    this.alG = 3;
                    obj = 1;
                    if (obj != null) {
                        break;
                    }
                    return 0;
            }
        }
    }

    private void jV() {
        this.alG = 0;
        this.alJ = 0;
    }

    private void D(long j) {
        while (!this.alE.isEmpty() && ((com.google.android.exoplayer2.c.b.a.a) this.alE.peek()).ald == j) {
            com.google.android.exoplayer2.c.b.a.a aVar = (com.google.android.exoplayer2.c.b.a.a) this.alE.pop();
            if (aVar.type == a.ajP) {
                e a;
                com.google.android.exoplayer2.i.a.c(this.alu == null, "Unexpected moov box.");
                DrmInitData l = l(aVar.ale);
                com.google.android.exoplayer2.c.b.a.a cw = aVar.cw(a.aka);
                SparseArray sparseArray = new SparseArray();
                long j2 = -9223372036854775807L;
                int size = cw.ale.size();
                for (int i = 0; i < size; i++) {
                    b bVar = (b) cw.ale.get(i);
                    j jVar;
                    if (bVar.type == a.ajM) {
                        jVar = bVar.alg;
                        jVar.setPosition(12);
                        Pair create = Pair.create(Integer.valueOf(jVar.readInt()), new c(jVar.mh() - 1, jVar.mh(), jVar.mh(), jVar.readInt()));
                        sparseArray.put(((Integer) create.first).intValue(), create.second);
                    } else if (bVar.type == a.akb) {
                        jVar = bVar.alg;
                        jVar.setPosition(8);
                        j2 = a.cs(jVar.readInt()) == 0 ? jVar.ba() : jVar.mi();
                    }
                }
                SparseArray sparseArray2 = new SparseArray();
                int size2 = aVar.alf.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    com.google.android.exoplayer2.c.b.a.a aVar2 = (com.google.android.exoplayer2.c.b.a.a) aVar.alf.get(i2);
                    if (aVar2.type == a.ajR) {
                        a = b.a(aVar2, aVar.cv(a.ajQ), j2, l, (this.flags & 32) != 0);
                        if (a != null) {
                            sparseArray2.put(a.id, a);
                        }
                    }
                }
                int size3 = sparseArray2.size();
                if (this.alv.size() == 0) {
                    for (int i3 = 0; i3 < size3; i3++) {
                        e eVar = (e) sparseArray2.valueAt(i3);
                        b bVar2 = new b(this.ajc.cp(i3));
                        bVar2.a(eVar, (c) sparseArray.get(eVar.id));
                        this.alv.put(eVar.id, bVar2);
                        this.aet = Math.max(this.aet, eVar.aet);
                    }
                    jW();
                    this.ajc.jU();
                } else {
                    com.google.android.exoplayer2.i.a.ap(this.alv.size() == size3);
                    for (int i4 = 0; i4 < size3; i4++) {
                        a = (e) sparseArray2.valueAt(i4);
                        ((b) this.alv.get(a.id)).a(a, (c) sparseArray.get(a.id));
                    }
                }
            } else if (aVar.type == a.ajY) {
                b(aVar);
            } else if (!this.alE.isEmpty()) {
                ((com.google.android.exoplayer2.c.b.a.a) this.alE.peek()).alf.add(aVar);
            }
        }
        jV();
    }

    private void b(com.google.android.exoplayer2.c.b.a.a aVar) {
        SparseArray sparseArray = this.alv;
        int i = this.flags;
        byte[] bArr = this.alD;
        int size = aVar.alf.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            b bVar;
            if (i3 < size) {
                com.google.android.exoplayer2.c.b.a.a aVar2 = (com.google.android.exoplayer2.c.b.a.a) aVar.alf.get(i3);
                if (aVar2.type == a.ajZ) {
                    b bVar2;
                    j jVar = aVar2.cv(a.ajL).alg;
                    jVar.setPosition(8);
                    int ct = a.ct(jVar.readInt());
                    i2 = jVar.readInt();
                    if ((i & 16) != 0) {
                        i2 = 0;
                    }
                    bVar = (b) sparseArray.get(i2);
                    if (bVar == null) {
                        bVar2 = null;
                    } else {
                        if ((ct & 1) != 0) {
                            long mi = jVar.mi();
                            bVar.alW.amq = mi;
                            bVar.alW.amr = mi;
                        }
                        c cVar = bVar.alZ;
                        bVar.alW.amo = new c((ct & 2) != 0 ? jVar.mh() - 1 : cVar.alr, (ct & 8) != 0 ? jVar.mh() : cVar.duration, (ct & 16) != 0 ? jVar.mh() : cVar.size, (ct & 32) != 0 ? jVar.mh() : cVar.flags);
                        bVar2 = bVar;
                    }
                    if (bVar2 != null) {
                        long j;
                        j jVar2;
                        int i4;
                        b bVar3;
                        int i5;
                        g gVar = bVar2.alW;
                        long j2 = gVar.amF;
                        bVar2.reset();
                        if (aVar2.cv(a.ajK) == null || (i & 2) != 0) {
                            j = j2;
                        } else {
                            jVar2 = aVar2.cv(a.ajK).alg;
                            jVar2.setPosition(8);
                            j = a.cs(jVar2.readInt()) == 1 ? jVar2.mi() : jVar2.ba();
                        }
                        int i6 = 0;
                        int i7 = 0;
                        List list = aVar2.ale;
                        int size2 = list.size();
                        i2 = 0;
                        while (true) {
                            i4 = i2;
                            if (i4 >= size2) {
                                break;
                            }
                            i2 = (b) list.get(i4);
                            if (i2.type == a.ajN) {
                                jVar2 = i2.alg;
                                jVar2.setPosition(12);
                                i2 = jVar2.mh();
                                if (i2 > 0) {
                                    i2 += i7;
                                    i7 = i6 + 1;
                                }
                            }
                            i6 = i7;
                            i4++;
                        }
                        bVar2.amc = 0;
                        bVar2.amb = 0;
                        bVar2.ama = 0;
                        g gVar2 = bVar2.alW;
                        gVar2.ams = i6;
                        gVar2.sampleCount = i7;
                        if (gVar2.amu == null || gVar2.amu.length < i6) {
                            gVar2.amt = new long[i6];
                            gVar2.amu = new int[i6];
                        }
                        if (gVar2.amv == null || gVar2.amv.length < i7) {
                            i7 = (i7 * 125) / 100;
                            gVar2.amv = new int[i7];
                            gVar2.amw = new int[i7];
                            gVar2.amx = new long[i7];
                            gVar2.amy = new boolean[i7];
                            gVar2.amA = new boolean[i7];
                        }
                        int i8 = 0;
                        int i9 = 0;
                        for (int i10 = 0; i10 < size2; i10++) {
                            bVar3 = (b) list.get(i10);
                            if (bVar3.type == a.ajN) {
                                long a;
                                int i11 = i8 + 1;
                                j jVar3 = bVar3.alg;
                                jVar3.setPosition(8);
                                i7 = a.ct(jVar3.readInt());
                                e eVar = bVar2.alY;
                                g gVar3 = bVar2.alW;
                                c cVar2 = gVar3.amo;
                                gVar3.amu[i8] = jVar3.mh();
                                gVar3.amt[i8] = gVar3.amq;
                                if ((i7 & 1) != 0) {
                                    long[] jArr = gVar3.amt;
                                    jArr[i8] = jArr[i8] + ((long) jVar3.readInt());
                                }
                                Object obj = (i7 & 4) != 0 ? 1 : null;
                                int i12 = cVar2.flags;
                                if (obj != null) {
                                    i12 = jVar3.mh();
                                }
                                Object obj2 = (i7 & GLIcon.TOP) != 0 ? 1 : null;
                                Object obj3 = (i7 & 512) != 0 ? 1 : null;
                                Object obj4 = (i7 & 1024) != 0 ? 1 : null;
                                Object obj5 = (i7 & 2048) != 0 ? 1 : null;
                                if (eVar.amg != null && eVar.amg.length == 1 && eVar.amg[0] == 0) {
                                    a = t.a(eVar.amh[0], 1000, eVar.amd);
                                } else {
                                    a = 0;
                                }
                                int[] iArr = gVar3.amv;
                                int[] iArr2 = gVar3.amw;
                                long[] jArr2 = gVar3.amx;
                                boolean[] zArr = gVar3.amy;
                                Object obj6 = (eVar.type != 2 || (i & 1) == 0) ? null : 1;
                                int i13 = i9 + gVar3.amu[i8];
                                long j3 = eVar.amd;
                                j2 = i8 > 0 ? gVar3.amF : j;
                                while (true) {
                                    int i14 = i9;
                                    if (i14 >= i13) {
                                        break;
                                    }
                                    int mh = obj2 != null ? jVar3.mh() : cVar2.duration;
                                    i8 = obj3 != null ? jVar3.mh() : cVar2.size;
                                    i9 = (i14 != 0 || obj == null) ? obj4 != null ? jVar3.readInt() : cVar2.flags : i12;
                                    if (obj5 != null) {
                                        iArr2[i14] = (int) ((((long) jVar3.readInt()) * 1000) / j3);
                                    } else {
                                        iArr2[i14] = 0;
                                    }
                                    jArr2[i14] = t.a(j2, 1000, j3) - a;
                                    iArr[i14] = i8;
                                    boolean z = ((i9 >> 16) & 1) == 0 && (obj6 == null || i14 == 0);
                                    zArr[i14] = z;
                                    j2 += (long) mh;
                                    i9 = i14 + 1;
                                }
                                gVar3.amF = j2;
                                i2 = i13;
                                i7 = i11;
                            } else {
                                i2 = i9;
                                i7 = i8;
                            }
                            i9 = i2;
                            i8 = i7;
                        }
                        f cx = bVar2.alY.cx(gVar.amo.alr);
                        bVar3 = aVar2.cv(a.akq);
                        if (bVar3 != null) {
                            j jVar4 = bVar3.alg;
                            i5 = cx.amm;
                            jVar4.setPosition(8);
                            if ((a.ct(jVar4.readInt()) & 1) == 1) {
                                jVar4.da(8);
                            }
                            i7 = jVar4.readUnsignedByte();
                            ct = jVar4.mh();
                            if (ct != gVar.sampleCount) {
                                throw new o("Length mismatch: " + ct + ", " + gVar.sampleCount);
                            }
                            i2 = 0;
                            if (i7 == 0) {
                                boolean[] zArr2 = gVar.amA;
                                i6 = 0;
                                while (i6 < ct) {
                                    int readUnsignedByte = jVar4.readUnsignedByte();
                                    i7 = i2 + readUnsignedByte;
                                    zArr2[i6] = readUnsignedByte > i5;
                                    i6++;
                                    i2 = i7;
                                }
                            } else {
                                boolean z2 = i7 > i5;
                                i7 = (i7 * ct) + 0;
                                Arrays.fill(gVar.amA, 0, ct, z2);
                                i2 = i7;
                            }
                            gVar.cy(i2);
                        }
                        bVar3 = aVar2.cv(a.akr);
                        if (bVar3 != null) {
                            jVar2 = bVar3.alg;
                            jVar2.setPosition(8);
                            i7 = jVar2.readInt();
                            if ((a.ct(i7) & 1) == 1) {
                                jVar2.da(8);
                            }
                            i6 = jVar2.mh();
                            if (i6 != 1) {
                                throw new o("Unexpected saio entry count: " + i6);
                            }
                            gVar.amr = (a.cs(i7) == 0 ? jVar2.ba() : jVar2.mi()) + gVar.amr;
                        }
                        bVar3 = aVar2.cv(a.akv);
                        if (bVar3 != null) {
                            a(bVar3.alg, 0, gVar);
                        }
                        bVar3 = aVar2.cv(a.aks);
                        b cv = aVar2.cv(a.akt);
                        if (!(bVar3 == null || cv == null)) {
                            jVar2 = bVar3.alg;
                            j jVar5 = cv.alg;
                            String str = cx != null ? cx.amk : null;
                            jVar2.setPosition(8);
                            i4 = jVar2.readInt();
                            if (jVar2.readInt() == als) {
                                if (a.cs(i4) == 1) {
                                    jVar2.da(4);
                                }
                                if (jVar2.readInt() != 1) {
                                    throw new o("Entry count in sbgp != 1 (unsupported).");
                                }
                                jVar5.setPosition(8);
                                i2 = jVar5.readInt();
                                if (jVar5.readInt() == als) {
                                    i2 = a.cs(i2);
                                    if (i2 == 1) {
                                        if (jVar5.ba() == 0) {
                                            throw new o("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (i2 >= 2) {
                                        jVar5.da(4);
                                    }
                                    if (jVar5.ba() != 1) {
                                        throw new o("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    jVar5.da(1);
                                    i2 = jVar5.readUnsignedByte();
                                    i5 = (i2 & com.tencent.mm.plugin.appbrand.jsapi.share.d.CTRL_INDEX) >> 4;
                                    ct = i2 & 15;
                                    if ((jVar5.readUnsignedByte() == 1 ? 1 : null) != null) {
                                        i4 = jVar5.readUnsignedByte();
                                        byte[] bArr2 = new byte[16];
                                        jVar5.readBytes(bArr2, 0, 16);
                                        byte[] bArr3 = null;
                                        if (i4 == 0) {
                                            i2 = jVar5.readUnsignedByte();
                                            bArr3 = new byte[i2];
                                            jVar5.readBytes(bArr3, 0, i2);
                                        }
                                        gVar.amz = true;
                                        gVar.amB = new f(true, str, i4, bArr2, i5, ct, bArr3);
                                    }
                                }
                            }
                        }
                        i6 = aVar2.ale.size();
                        for (i7 = 0; i7 < i6; i7++) {
                            bVar3 = (b) aVar2.ale.get(i7);
                            if (bVar3.type == a.aku) {
                                jVar2 = bVar3.alg;
                                jVar2.setPosition(8);
                                jVar2.readBytes(bArr, 0, 16);
                                if (Arrays.equals(bArr, alt)) {
                                    a(jVar2, 16, gVar);
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                }
                i2 = i3 + 1;
            } else {
                DrmInitData l = l(aVar.ale);
                if (l != null) {
                    int size3 = this.alv.size();
                    i2 = 0;
                    while (true) {
                        int i15 = i2;
                        if (i15 < size3) {
                            bVar = (b) this.alv.valueAt(i15);
                            f cx2 = bVar.alY.cx(bVar.alW.amo.alr);
                            String str2 = cx2 != null ? cx2.amk : null;
                            k kVar = bVar.alX;
                            Format format = bVar.alY.aep;
                            kVar.f(new Format(format.id, format.adV, format.adW, format.adT, format.bitrate, format.adX, format.width, format.height, format.aea, format.aeb, format.aec, format.aee, format.aed, format.aef, format.aeg, format.sampleRate, format.aeh, format.aei, format.aej, format.ael, format.aem, format.aen, format.aek, format.adY, l.ai(str2), format.adU));
                            i2 = i15 + 1;
                        } else {
                            return;
                        }
                    }
                }
                return;
            }
        }
    }

    private void jW() {
        if ((this.flags & 4) != 0 && this.alS == null) {
            this.alS = this.ajc.cp(this.alv.size());
            this.alS.f(Format.b("application/x-emsg", Long.MAX_VALUE));
        }
        if ((this.flags & 8) != 0 && this.alT == null) {
            this.ajc.cp(this.alv.size() + 1).f(Format.af("application/cea-608"));
            this.alT = new k[]{r0};
        }
    }

    private static void a(j jVar, int i, g gVar) {
        jVar.setPosition(i + 8);
        int ct = a.ct(jVar.readInt());
        if ((ct & 1) != 0) {
            throw new o("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z;
        if ((ct & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        int mh = jVar.mh();
        if (mh != gVar.sampleCount) {
            throw new o("Length mismatch: " + mh + ", " + gVar.sampleCount);
        }
        Arrays.fill(gVar.amA, 0, mh, z);
        gVar.cy(jVar.me());
        jVar.readBytes(gVar.amD.data, 0, gVar.amC);
        gVar.amD.setPosition(0);
        gVar.amE = false;
    }

    private static DrmInitData l(List<b> list) {
        int size = list.size();
        List list2 = null;
        for (int i = 0; i < size; i++) {
            b bVar = (b) list.get(i);
            if (bVar.type == a.aki) {
                Pair pair;
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                byte[] bArr = bVar.alg.data;
                j jVar = new j(bArr);
                if (jVar.limit < 32) {
                    pair = null;
                } else {
                    jVar.setPosition(0);
                    if (jVar.readInt() != jVar.me() + 4) {
                        pair = null;
                    } else if (jVar.readInt() != a.aki) {
                        pair = null;
                    } else {
                        int cs = a.cs(jVar.readInt());
                        if (cs > 1) {
                            pair = null;
                        } else {
                            UUID uuid = new UUID(jVar.readLong(), jVar.readLong());
                            if (cs == 1) {
                                jVar.da(jVar.mh() * 16);
                            }
                            cs = jVar.mh();
                            if (cs != jVar.me()) {
                                pair = null;
                            } else {
                                Object obj = new byte[cs];
                                jVar.readBytes(obj, 0, cs);
                                pair = Pair.create(uuid, obj);
                            }
                        }
                    }
                }
                UUID uuid2 = pair == null ? null : (UUID) pair.first;
                if (uuid2 != null) {
                    list2.add(new SchemeData(uuid2, "video/mp4", bArr));
                }
            }
        }
        return list2 == null ? null : new DrmInitData(list2);
    }
}
