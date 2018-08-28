package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.b.a.e.b;
import com.google.android.exoplayer2.source.b.j.a;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public final class g implements b, a, e {
    private m acW;
    private e.a arL;
    private final k asZ = new k();
    private final com.google.android.exoplayer2.h.b asl;
    private final d atN;
    private final int atO;
    private final com.google.android.exoplayer2.source.a.a atP;
    private final IdentityHashMap<i, Integer> atQ = new IdentityHashMap();
    final Handler atR = new Handler();
    private int atS;
    j[] atT = new j[0];
    private j[] atU = new j[0];
    private d atV;
    final com.google.android.exoplayer2.source.b.a.e atb;

    public g(com.google.android.exoplayer2.source.b.a.e eVar, d dVar, int i, com.google.android.exoplayer2.source.a.a aVar, com.google.android.exoplayer2.h.b bVar) {
        this.atb = eVar;
        this.atN = dVar;
        this.atO = i;
        this.atP = aVar;
        this.asl = bVar;
    }

    public final void a(e.a aVar, long j) {
        int i;
        com.google.android.exoplayer2.source.b.a.a.a aVar2;
        List list;
        int i2;
        int i3;
        this.arL = aVar;
        this.atb.avD.add(this);
        com.google.android.exoplayer2.source.b.a.a aVar3 = this.atb.ats;
        List arrayList = new ArrayList(aVar3.auC);
        ArrayList arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        int i4 = 0;
        while (true) {
            i = i4;
            if (i >= arrayList.size()) {
                break;
            }
            aVar2 = (com.google.android.exoplayer2.source.b.a.a.a) arrayList.get(i);
            if (aVar2.aep.height > 0 || a(aVar2, "avc")) {
                arrayList2.add(aVar2);
            } else if (a(aVar2, "mp4a")) {
                arrayList3.add(aVar2);
            }
            i4 = i + 1;
        }
        if (arrayList2.isEmpty()) {
            if (arrayList3.size() < arrayList.size()) {
                arrayList.removeAll(arrayList3);
            }
            list = arrayList;
        } else {
            list = arrayList2;
        }
        List list2 = aVar3.auD;
        List list3 = aVar3.auE;
        this.atT = new j[((list2.size() + 1) + list3.size())];
        this.atS = this.atT.length;
        com.google.android.exoplayer2.i.a.ao(!list.isEmpty());
        com.google.android.exoplayer2.source.b.a.a.a[] aVarArr = new com.google.android.exoplayer2.source.b.a.a.a[list.size()];
        list.toArray(aVarArr);
        j a = a(0, aVarArr, aVar3.auc, aVar3.atd, j);
        i4 = 1;
        this.atT[0] = a;
        a.ak(true);
        a.la();
        i = 0;
        while (true) {
            i2 = i4;
            i3 = i;
            if (i3 >= list2.size()) {
                break;
            }
            a = a(1, new com.google.android.exoplayer2.source.b.a.a.a[]{(com.google.android.exoplayer2.source.b.a.a.a) list2.get(i3)}, null, Collections.emptyList(), j);
            i4 = i2 + 1;
            this.atT[i2] = a;
            a.la();
            i = i3 + 1;
        }
        for (i3 = 0; i3 < list3.size(); i3++) {
            a = a(3, new com.google.android.exoplayer2.source.b.a.a.a[]{(com.google.android.exoplayer2.source.b.a.a.a) list3.get(i3)}, null, Collections.emptyList(), j);
            a.cL(0).f(aVar2.aep);
            a.auj = true;
            a.ld();
            i4 = i2 + 1;
            this.atT[i2] = a;
            i2 = i4;
        }
        this.atU = this.atT;
    }

    public final void kx() {
        for (j kC : this.atT) {
            kC.kC();
        }
    }

    public final m ky() {
        return this.acW;
    }

    public final long a(com.google.android.exoplayer2.g.e[] eVarArr, boolean[] zArr, i[] iVarArr, boolean[] zArr2, long j) {
        int i;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= eVarArr.length) {
                break;
            }
            if (iVarArr[i] == null) {
                i2 = -1;
            } else {
                i2 = ((Integer) this.atQ.get(iVarArr[i])).intValue();
            }
            iArr[i] = i2;
            iArr2[i] = -1;
            if (eVarArr[i] != null) {
                l lG = eVarArr[i].lG();
                for (i2 = 0; i2 < this.atT.length; i2++) {
                    if (this.atT[i2].acW.a(lG) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                }
            }
            i2 = i + 1;
        }
        boolean z = false;
        this.atQ.clear();
        Object obj = new i[eVarArr.length];
        i[] iVarArr2 = new i[eVarArr.length];
        com.google.android.exoplayer2.g.e[] eVarArr2 = new com.google.android.exoplayer2.g.e[eVarArr.length];
        int i3 = 0;
        j[] jVarArr = new j[this.atT.length];
        i2 = 0;
        while (true) {
            i = i2;
            if (i < this.atT.length) {
                i2 = 0;
                while (i2 < eVarArr.length) {
                    iVarArr2[i2] = iArr[i2] == i ? iVarArr[i2] : null;
                    eVarArr2[i2] = iArr2[i2] == i ? eVarArr[i2] : null;
                    i2++;
                }
                j jVar = this.atT[i];
                com.google.android.exoplayer2.i.a.ap(jVar.adE);
                int i4 = jVar.auk;
                i2 = 0;
                while (true) {
                    int i5 = i2;
                    if (i5 >= eVarArr2.length) {
                        break;
                    }
                    if (iVarArr2[i5] != null && (eVarArr2[i5] == null || !zArr[i5])) {
                        jVar.q(((i) iVarArr2[i5]).group, false);
                        iVarArr2[i5] = null;
                    }
                    i2 = i5 + 1;
                }
                Object obj2 = (z || (jVar.auu ? i4 == 0 : j != jVar.aur)) ? 1 : null;
                com.google.android.exoplayer2.g.e eVar = jVar.aub.atl;
                i4 = 0;
                Object obj3 = obj2;
                com.google.android.exoplayer2.g.e eVar2 = eVar;
                while (i4 < eVarArr2.length) {
                    if (iVarArr2[i4] == null && eVarArr2[i4] != null) {
                        com.google.android.exoplayer2.g.e eVar3 = eVarArr2[i4];
                        int a = jVar.acW.a(eVar3.lG());
                        jVar.q(a, true);
                        if (a == jVar.aun) {
                            jVar.aub.atl = eVar3;
                            eVar2 = eVar3;
                        }
                        iVarArr2[i4] = new i(jVar, a);
                        zArr2[i4] = true;
                        if (obj3 == null) {
                            h hVar = jVar.auh[a];
                            hVar.rewind();
                            if (!hVar.e(j, true)) {
                                com.google.android.exoplayer2.source.g gVar = hVar.asn;
                                if (gVar.ase + gVar.asc != 0) {
                                    obj2 = 1;
                                    i4++;
                                    obj3 = obj2;
                                }
                            }
                            obj2 = null;
                            i4++;
                            obj3 = obj2;
                        }
                    }
                    obj2 = obj3;
                    i4++;
                    obj3 = obj2;
                }
                if (jVar.auk == 0) {
                    jVar.aub.atg = null;
                    jVar.aul = null;
                    jVar.auf.clear();
                    if (jVar.aud.iD()) {
                        for (h kM : jVar.auh) {
                            kM.kM();
                        }
                        jVar.aud.lY();
                    } else {
                        jVar.lc();
                    }
                } else {
                    boolean z2;
                    if (!(jVar.auf.isEmpty() || t.i(eVar2, eVar))) {
                        if (jVar.auu) {
                            obj2 = 1;
                        } else {
                            eVar2.kU();
                            obj2 = eVar2.lI() != jVar.aub.atc.j(((f) jVar.auf.getLast()).asK) ? 1 : null;
                        }
                        if (obj2 != null) {
                            z2 = true;
                            obj3 = 1;
                            jVar.aut = true;
                            if (obj3 != null) {
                                jVar.g(j, z2);
                                for (i2 = 0; i2 < iVarArr2.length; i2++) {
                                    if (iVarArr2[i2] != null) {
                                        zArr2[i2] = true;
                                    }
                                }
                            }
                        }
                    }
                    z2 = z;
                    if (obj3 != null) {
                        jVar.g(j, z2);
                        for (i2 = 0; i2 < iVarArr2.length; i2++) {
                            if (iVarArr2[i2] != null) {
                                zArr2[i2] = true;
                            }
                        }
                    }
                }
                jVar.auu = true;
                Object obj4 = null;
                for (i2 = 0; i2 < eVarArr.length; i2++) {
                    if (iArr2[i2] == i) {
                        com.google.android.exoplayer2.i.a.ap(iVarArr2[i2] != null);
                        obj[i2] = iVarArr2[i2];
                        obj4 = 1;
                        this.atQ.put(iVarArr2[i2], Integer.valueOf(i));
                    } else if (iArr[i2] == i) {
                        com.google.android.exoplayer2.i.a.ap(iVarArr2[i2] == null);
                    }
                }
                if (obj4 != null) {
                    jVarArr[i3] = jVar;
                    i2 = i3 + 1;
                    if (i3 == 0) {
                        jVar.ak(true);
                        if (!(obj3 == null && this.atU.length != 0 && jVar == this.atU[0])) {
                            this.asZ.aux.clear();
                            z = true;
                            i3 = i2;
                        }
                    } else {
                        jVar.ak(false);
                    }
                    i3 = i2;
                }
                i2 = i + 1;
            } else {
                System.arraycopy(obj, 0, iVarArr, 0, obj.length);
                this.atU = (j[]) Arrays.copyOf(jVarArr, i3);
                this.atV = new d(this.atU);
                return j;
            }
        }
    }

    public final void E(long j) {
        for (j jVar : this.atU) {
            int length = jVar.auh.length;
            for (int i = 0; i < length; i++) {
                h hVar = jVar.auh[i];
                hVar.L(hVar.asn.f(j, jVar.aup[i]));
            }
        }
    }

    public final boolean G(long j) {
        return this.atV.G(j);
    }

    public final long kB() {
        return this.atV.kB();
    }

    public final long kz() {
        return -9223372036854775807L;
    }

    public final long kA() {
        return this.atV.kA();
    }

    public final long F(long j) {
        if (this.atU.length > 0) {
            boolean g = this.atU[0].g(j, false);
            for (int i = 1; i < this.atU.length; i++) {
                this.atU[i].g(j, g);
            }
            if (g) {
                this.asZ.aux.clear();
            }
        }
        return j;
    }

    public final void iy() {
        int i = this.atS - 1;
        this.atS = i;
        if (i <= 0) {
            int i2 = 0;
            for (j jVar : this.atT) {
                i2 += jVar.acW.length;
            }
            l[] lVarArr = new l[i2];
            i2 = 0;
            for (j jVar2 : this.atT) {
                int i3 = jVar2.acW.length;
                i = 0;
                while (i < i3) {
                    int i4 = i2 + 1;
                    lVarArr[i2] = jVar2.acW.asI[i];
                    i++;
                    i2 = i4;
                }
            }
            this.acW = new m(lVarArr);
            this.arL.a(this);
        }
    }

    public final void a(com.google.android.exoplayer2.source.b.a.a.a aVar) {
        ((com.google.android.exoplayer2.source.b.a.e.a) this.atb.avA.get(aVar)).lg();
    }

    public final void kY() {
        kZ();
    }

    public final void b(com.google.android.exoplayer2.source.b.a.a.a aVar) {
        for (j jVar : this.atT) {
            c cVar = jVar.aub;
            int j = cVar.atc.j(aVar.aep);
            if (j != -1) {
                j = cVar.atl.indexOf(j);
                if (j != -1) {
                    cVar.atl.cU(j);
                }
            }
        }
        kZ();
    }

    private j a(int i, com.google.android.exoplayer2.source.b.a.a.a[] aVarArr, Format format, List<Format> list, long j) {
        return new j(i, this, new c(this.atb, aVarArr, this.atN, this.asZ, list), this.asl, j, format, this.atO, this.atP);
    }

    private void kZ() {
        if (this.acW != null) {
            this.arL.a(this);
            return;
        }
        for (j la : this.atT) {
            la.la();
        }
    }

    private static boolean a(com.google.android.exoplayer2.source.b.a.a.a aVar, String str) {
        Object obj = aVar.aep.adT;
        if (TextUtils.isEmpty(obj)) {
            return false;
        }
        for (String startsWith : obj.split("(\\s*,\\s*)|(\\s*$)")) {
            if (startsWith.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
