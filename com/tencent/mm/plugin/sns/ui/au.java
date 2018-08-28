package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class au extends e<n> {
    private boolean bNu = false;
    private String iKw = "";
    List<n> list = new ArrayList();
    private int nKI = 0;
    private int nKJ = 0;
    private Comparator<n> nmy = new 1(this);
    private boolean oaw = false;
    private b oax;
    private a oay;
    private String userName = "";

    public interface b {
        void a(List<n> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i, int i2);

        void bDJ();
    }

    public au(b bVar, String str, boolean z) {
        this.oax = bVar;
        this.userName = str;
        this.bNu = z;
    }

    public final void cq(List<n> list) {
        if (this.oax != null) {
            if (list != null) {
                b(true, list);
            }
            this.oax.bDJ();
        }
    }

    public final List<n> bBI() {
        x.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", new Object[]{Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(aj.a(this.userName, this.bNu, this.iKw, this.oaw).size())});
        return aj.a(this.userName, this.bNu, this.iKw, this.oaw);
    }

    public final void bDK() {
        Collections.sort(this.list, this.nmy);
    }

    final void bDL() {
        b(false, this.list);
    }

    public final void g(String str, boolean z, boolean z2) {
        x.d("MicroMsg.SnsSelfHelper", "limitSeq " + str);
        this.iKw = str;
        this.oaw = z;
        fu(z2);
    }

    private void b(boolean z, List<n> list) {
        n nVar;
        this.oay = new a(this);
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        Map hashMap3 = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        int i2 = 0;
        if (z && this.bNu) {
            nVar = new n((byte) 0);
            nVar.field_snsId = 0;
            nVar.nJc = -1;
            nVar.hK((int) (System.currentTimeMillis() / 1000));
            list.add(0, nVar);
        }
        int size = list.size();
        x.d("MicroMsg.SnsSelfHelper", "initFixType " + size);
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            int i5;
            int i6;
            a aVar = this.oay;
            aVar.oaB = -1;
            aVar.oaL = -1;
            aVar.oaA = -1;
            aVar.oaF = "";
            aVar.oaG = "";
            aVar.oaH = "";
            aVar.oaK = false;
            aVar.oaC = false;
            aVar.oaM = false;
            aVar.oaN = -1;
            aVar.oaD = -1;
            aVar.oaI = -1;
            aVar.oaJ = 0;
            aVar.oaE = 0;
            aVar.oaO = 0;
            if (this.bNu && i3 == 0) {
                i5 = 1;
            } else {
                bsu bAJ;
                if (i3 + 1 < size) {
                    nVar = (n) list.get(i3 + 1);
                    this.oay.oaB = nVar.field_head;
                    bAJ = nVar.bAJ();
                    this.oay.oaF = bAJ.spZ;
                    this.oay.oaC = aj.O(nVar.field_localPrivate, this.bNu);
                    this.oay.oaD = nVar.field_type;
                    if (bAJ.sqc != null) {
                        this.oay.oaE = bAJ.sqc.ruA.size();
                    } else {
                        this.oay.oaE = 0;
                    }
                }
                if (i3 + 2 < size) {
                    nVar = (n) list.get(i3 + 2);
                    this.oay.oaL = nVar.field_head;
                    bAJ = nVar.bAJ();
                    this.oay.oaG = bAJ.spZ;
                    this.oay.oaM = aj.O(nVar.field_localPrivate, this.bNu);
                    this.oay.oaN = nVar.field_type;
                    if (bAJ.sqc != null) {
                        this.oay.oaO = bAJ.sqc.ruA.size();
                    } else {
                        this.oay.oaO = 0;
                    }
                }
                nVar = (n) list.get(i3);
                this.oay.oaA = nVar.field_head;
                bAJ = nVar.bAJ();
                this.oay.oaH = bAJ.spZ;
                this.oay.oaI = nVar.field_type;
                this.oay.oaK = aj.O(nVar.field_localPrivate, this.bNu);
                if (bAJ.sqc != null) {
                    this.oay.oaJ = bAJ.sqc.ruA.size();
                } else {
                    this.oay.oaJ = 0;
                }
                aVar = this.oay;
                Object obj = aVar.oaI == 2 ? 1 : aVar.oaB == -1 ? 1 : aVar.oaI != aVar.oaD ? 1 : a.xx(aVar.oaI) ? 1 : a.xx(aVar.oaD) ? 1 : (aVar.oaJ > 1 || aVar.oaE > 1) ? 1 : (aVar.oaH == null || aVar.oaH.equals("")) ? (aVar.oaF == null || aVar.oaF.equals("")) ? aVar.oaA != aVar.oaB ? 1 : null : 1 : 1;
                if (obj != null) {
                    i5 = 1;
                } else {
                    aVar = this.oay;
                    obj = aVar.oaL == -1 ? 1 : aVar.oaD != aVar.oaN ? 1 : a.xx(aVar.oaN) ? 1 : aVar.oaO > 1 ? 1 : (aVar.oaG == null || aVar.oaG.equals("")) ? aVar.oaB != aVar.oaL ? 1 : null : 1;
                    i5 = obj != null ? 2 : 3;
                }
            }
            hashMap.put(Integer.valueOf(i4), Integer.valueOf(i));
            hashMap2.put(Integer.valueOf(i4), Integer.valueOf(i5));
            i += i5;
            hashMap3.put(Integer.valueOf(i4), Integer.valueOf(i2));
            if (this.bNu && i3 == 0) {
                i6 = 0;
            } else {
                i6 = 0;
                if (i5 > 0 && this.oay.oaI == 1) {
                    i6 = 1;
                }
                if (i5 >= 2 && this.oay.oaD == 1) {
                    i6++;
                }
                if (i5 >= 3 && this.oay.oaN == 1) {
                    i6++;
                }
            }
            i2 += i6;
            i3 += i5;
            i4++;
        }
        this.nKI = i4;
        this.nKJ = list.size();
        x.d("MicroMsg.SnsSelfHelper", "icount " + this.nKI);
        this.list = list;
        i.af("SnsphotoAdapter initFixType ", currentTimeMillis);
        this.oax.a(this.list, hashMap, hashMap2, hashMap3, this.nKJ, this.nKI);
    }
}
