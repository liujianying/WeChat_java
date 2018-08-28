package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.mm.k.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends d implements b {
    private ag jvE = new ag(Looper.getMainLooper());
    int jvU = 1;
    private boolean jwE;
    boolean jwG;
    private List<e> jwJ;
    com.tencent.mm.plugin.fts.ui.c.b jwK = new com.tencent.mm.plugin.fts.ui.c.b();
    private b jwL = null;
    private long jwM;
    private long jwN;
    private long jwO;
    private long jwP;
    private ag jwQ = new 1(this, Looper.getMainLooper());
    private int jwR = -1;
    boolean jwS;
    private boolean jwT;
    private boolean jww;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j(com.tencent.mm.plugin.fts.ui.e r7, int r8, com.tencent.mm.plugin.fts.ui.j.b r9) {
        /*
        r6 = this;
        r0 = 1;
        r6.<init>(r7);
        r1 = 0;
        r6.jwL = r1;
        r6.jvU = r0;
        r1 = new com.tencent.mm.plugin.fts.ui.j$1;
        r2 = android.os.Looper.getMainLooper();
        r1.<init>(r6, r2);
        r6.jwQ = r1;
        r1 = new com.tencent.mm.sdk.platformtools.ag;
        r2 = android.os.Looper.getMainLooper();
        r1.<init>(r2);
        r6.jvE = r1;
        r1 = -1;
        r6.jwR = r1;
        r1 = new com.tencent.mm.plugin.fts.ui.c.b;
        r1.<init>();
        r6.jwK = r1;
        r1 = new java.util.HashSet;
        r1.<init>();
        r2 = 16;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 32;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 48;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 64;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 96;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = com.tencent.mm.kernel.g.Eg();
        r2 = r2.Dx();
        if (r2 == 0) goto L_0x00db;
    L_0x0077:
        r2 = new com.tencent.mm.g.a.pk;
        r2.<init>();
        r3 = com.tencent.mm.sdk.b.a.sFg;
        r3.m(r2);
        r3 = com.tencent.mm.model.c.c.Jx();
        r4 = "100193";
        r3 = r3.fJ(r4);
        r4 = r3.isValid();
        if (r4 == 0) goto L_0x00db;
    L_0x0092:
        r4 = "1";
        r3 = r3.ckq();
        r5 = "isOpenLocalSearch";
        r3 = r3.get(r5);
        r3 = r4.equals(r3);
        if (r3 == 0) goto L_0x00db;
    L_0x00a6:
        r2 = r2.cai;
        r2 = r2.cak;
        if (r2 == 0) goto L_0x00db;
    L_0x00ac:
        if (r0 == 0) goto L_0x00b7;
    L_0x00ae:
        r0 = 144; // 0x90 float:2.02E-43 double:7.1E-322;
        r0 = java.lang.Integer.valueOf(r0);
        r1.add(r0);
    L_0x00b7:
        r0 = com.tencent.mm.modelappbrand.a.JJ();
        if (r0 == 0) goto L_0x00c6;
    L_0x00bd:
        r0 = 208; // 0xd0 float:2.91E-43 double:1.03E-321;
        r0 = java.lang.Integer.valueOf(r0);
        r1.add(r0);
    L_0x00c6:
        r0 = com.tencent.mm.plugin.fts.a.n.class;
        r0 = com.tencent.mm.kernel.g.n(r0);
        r0 = (com.tencent.mm.plugin.fts.a.n) r0;
        r2 = r6.getContext();
        r0 = r0.createFTSUIUnitList(r1, r2, r6, r8);
        r6.jwJ = r0;
        r6.jwL = r9;
        return;
    L_0x00db:
        r0 = 0;
        goto L_0x00ac;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.j.<init>(com.tencent.mm.plugin.fts.ui.e, int, com.tencent.mm.plugin.fts.ui.j$b):void");
    }

    protected final a qh(int i) {
        a aVar = null;
        for (e qh : this.jwJ) {
            aVar = qh.qh(i);
            if (aVar != null) {
                break;
            }
        }
        a aVar2 = aVar;
        if (aVar2 != null) {
            int i2;
            LinkedList linkedList = new LinkedList();
            for (e qh2 : this.jwJ) {
                linkedList.addAll(qh2.aQf());
            }
            for (int size = linkedList.size() - 1; size >= 0; size--) {
                if (i > ((Integer) linkedList.get(size)).intValue()) {
                    i2 = i - size;
                    break;
                }
            }
            i2 = i;
            aVar2.jtl = i2;
            aVar2.pageType = 1;
        }
        if (aVar2 == null) {
            x.e("MicroMsg.FTS.FTSMainAdapter", "Create Data Item Error: getCount-%d position-%d", Integer.valueOf(getCount()), Integer.valueOf(i));
        }
        return aVar2;
    }

    protected final void aQx() {
        this.jww = false;
        this.jwG = false;
        this.jwR = -1;
        this.jwS = false;
        this.jwK.reset();
        this.jvU = 1;
        this.jwM = 0;
        this.jwN = 0;
        this.jwO = 0;
        this.jwP = 0;
        HashSet hashSet = new HashSet();
        hashSet.add("filehelper");
        boolean Hm = q.Hm();
        if (!Hm) {
            Hm = bi.getInt(g.AT().getValue("BindQQSwitch"), 1) == 1;
        }
        if (!Hm) {
            x.i("MicroMsg.FTS.FTSMainAdapter", "summerqq BindQQSwitch off");
            hashSet.add("22");
            hashSet.add("23");
        }
        if (!com.tencent.mm.modelappbrand.a.JJ()) {
            hashSet.add("61");
        }
        hashSet.add("62");
        x.d("MicroMsg.FTS.FTSMainAdapter", "summerqq doSearch blockSet[%d]", Integer.valueOf(hashSet.size()));
        c(hashSet);
    }

    public final void finish() {
        if (!this.jww) {
            this.jww = true;
            if (!this.jwG) {
                k.a(this.bWm, false, aQg(), 0, this.jwK);
            }
        }
        if (!(this.jwG || this.jwT)) {
            ad.h(this.bWm, this.jvU, 3, 3);
        }
        this.jwK.reset();
        super.finish();
    }

    protected final void clearCache() {
        super.clearCache();
        for (e eVar : this.jwJ) {
            eVar.aQe();
            eVar.acV();
        }
    }

    public final void stopSearch() {
        this.jwQ.removeMessages(1);
        super.stopSearch();
    }

    protected final boolean a(View view, a aVar, boolean z) {
        for (e a : this.jwJ) {
            z = a.a(view, aVar, z);
            if (z) {
                break;
            }
        }
        if (aVar.jts) {
            this.jwT = true;
            x.d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", Integer.valueOf(aVar.jtk), Integer.valueOf(aVar.jsZ), Integer.valueOf(aVar.jtl), Integer.valueOf(aVar.jtm), aVar.jtn, Long.valueOf(aVar.jto));
            if (!this.jww) {
                k.a(this.bWm, true, aQg(), 0, this.jwK);
                this.jww = true;
            }
            if (!bi.oW(this.bWm)) {
                ad.h(this.bWm, this.jvU, 1, 3);
            }
            this.jwK.jzl = qk(aVar.position);
            k.a(aVar, this.jwK);
            return true;
        }
        if (aVar instanceof h) {
            this.jwG = true;
            if (!bi.oW(this.bWm)) {
                ad.h(this.bWm, this.jvU, 1, 3);
            }
            this.jwK.jzl = qk(aVar.position);
            k.a(aVar, this.jwK);
        } else if (aVar instanceof i) {
            this.jwK.jzl = qk(aVar.position);
            k.a(aVar, this.jwK);
        }
        return false;
    }

    private int qk(int i) {
        int i2 = 0;
        List arrayList = new ArrayList();
        for (e aQf : this.jwJ) {
            arrayList.addAll(aQf.aQf());
        }
        int size = arrayList.size() - 1;
        while (size >= 0) {
            int i3;
            if (i >= ((Integer) arrayList.get(size)).intValue()) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            size--;
            i2 = i3;
        }
        return i2;
    }

    public final int getBlockCount() {
        List arrayList = new ArrayList();
        for (e aQf : this.jwJ) {
            arrayList.addAll(aQf.aQf());
        }
        return arrayList.size();
    }

    public final void a(e eVar, String str) {
        a aVar = (a) eVar;
        if (str.equals(this.bWm)) {
            c(aVar.jst);
        }
        if (aVar.aQw() > 0 && this.jwM == 0) {
            this.jwM = System.currentTimeMillis() - this.jwf;
            k.w(9, this.jwM);
            x.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", Long.valueOf(this.jwM));
        }
        switch (aVar.getType()) {
            case 16:
                if (this.jwN == 0) {
                    this.jwN = System.currentTimeMillis() - this.jwf;
                    x.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", Long.valueOf(this.jwN));
                    k.w(0, this.jwN);
                    break;
                }
                break;
            case 32:
                if (this.jwO == 0) {
                    this.jwO = System.currentTimeMillis() - this.jwf;
                    x.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", Long.valueOf(this.jwO));
                    k.w(3, this.jwO);
                    break;
                }
                break;
            case 48:
                if (this.jwP == 0) {
                    this.jwP = System.currentTimeMillis() - this.jwf;
                    x.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", Long.valueOf(this.jwP));
                    k.w(6, this.jwP);
                    break;
                }
                break;
        }
        com.tencent.mm.plugin.fts.ui.c.b bVar = this.jwK;
        for (e.a aVar2 : aVar.jvp) {
            switch (aVar2.iPZ) {
                case -15:
                    bVar.jzi = aVar2.jte.size();
                    break;
                case -11:
                    bVar.jzj = aVar2.jte.size();
                    break;
                case -8:
                    bVar.jza = aVar2.jte.size();
                    break;
                case -7:
                    bVar.jzd = aVar2.jte.size();
                    break;
                case -6:
                    bVar.jzf = aVar2.jte.size();
                    break;
                case -5:
                    bVar.jzh = aVar2.jte.size();
                    break;
                case -4:
                    bVar.jzb = aVar2.jte.size();
                    break;
                case -3:
                    bVar.jzc = aVar2.jte.size();
                    break;
                case -2:
                    bVar.jze = aVar2.jte.size();
                    break;
                case -1:
                    bVar.jzg = aVar2.jte.size();
                    break;
                default:
                    break;
            }
        }
        new a(this, eVar, str).run();
    }

    private void c(HashSet<String> hashSet) {
        this.jwR++;
        if (this.jwR < this.jwJ.size()) {
            ((e) this.jwJ.get(this.jwR)).a(this.bWm, this.jvE, hashSet);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (absListView.getLastVisiblePosition() == getCount() && this.jwS) {
            this.jvU = 2;
            if (this.jwL != null) {
                this.jwL.aQN();
            }
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.jwE = true;
            ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSImageLoader().aPM();
            com.tencent.mm.plugin.sns.b.n.nkx.pause();
            return;
        }
        this.jwE = false;
        if (!((n) com.tencent.mm.kernel.g.n(n.class)).getFTSImageLoader().aPN()) {
            this.jwQ.removeMessages(1);
            this.jwQ.sendEmptyMessageDelayed(1, 200);
        }
    }

    protected final int aQg() {
        int i = 0;
        Iterator it = this.jwJ.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((e) it.next()).aQg() + i2;
        }
    }
}
