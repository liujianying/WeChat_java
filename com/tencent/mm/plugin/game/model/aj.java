package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bk.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bl;
import com.tencent.mm.plugin.game.d.cq;
import com.tencent.mm.plugin.game.d.da;
import com.tencent.mm.plugin.game.d.m;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class aj extends ac {
    private int jNB;
    public bl jNW;
    public LinkedList<d> jNX;
    public LinkedList<d> jNY;

    public aj(a aVar, boolean z, int i) {
        this.jNB = 0;
        if (aVar == null) {
            this.jNW = new bl();
            return;
        }
        this.jNW = (bl) aVar;
        this.jNB = i;
        this.jNX = aUt();
        this.jNY = aUu();
        if (z) {
            ((c) g.l(c.class)).aSk().a("pb_library", aVar);
        }
        d.S(this.jNX);
        d.S(this.jNY);
    }

    public aj(byte[] bArr) {
        this.jNB = 0;
        this.jNW = new bl();
        if (bArr != null && bArr.length != 0) {
            try {
                this.jNW.aG(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataLibrary", "Parsing Failed: %s", e.getMessage());
            }
            this.jNX = aUt();
            this.jNY = aUu();
            d.S(this.jNX);
            d.S(this.jNY);
        }
    }

    private LinkedList<d> aUt() {
        LinkedList<d> linkedList = new LinkedList();
        if (this.jNW.jSe == null || this.jNW.jSe.jSJ == null || this.jNW.jSe.jSJ.jSY == null) {
            return linkedList;
        }
        Iterator it = this.jNW.jSe.jSJ.jSY.iterator();
        int i = 1;
        while (it.hasNext()) {
            cq cqVar = (cq) it.next();
            d a = a(cqVar.jOV);
            if (a != null) {
                a.jLm = cqVar.jOV.jPl;
                a.scene = 11;
                a.bYq = 1110;
                int i2 = i + 1;
                a.position = i;
                linkedList.add(a);
                i = i2;
            }
        }
        return linkedList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.LinkedList<com.tencent.mm.plugin.game.model.d> aUu() {
        /*
        r7 = this;
        r3 = new java.util.LinkedList;
        r3.<init>();
        r0 = r7.jNW;
        r0 = r0.jSf;
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        r0 = r3;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r7.jNB;
        r2 = r0 + 1;
        r0 = r7.jNB;
        r0 = r0 / 15;
        r0 = r0 + 901;
        r1 = r7.jNW;
        r1 = r1.jSf;
        r6 = r1.iterator();
        r1 = r0;
    L_0x0020:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0073;
    L_0x0026:
        r0 = r6.next();
        r0 = (com.tencent.mm.plugin.game.d.c) r0;
        r4 = 0;
        r5 = r0.hcE;
        switch(r5) {
            case 1: goto L_0x0042;
            case 2: goto L_0x0051;
            default: goto L_0x0032;
        };
    L_0x0032:
        r0 = r1;
    L_0x0033:
        if (r4 == 0) goto L_0x0075;
    L_0x0035:
        r1 = 11;
        r4.scene = r1;
        r1 = 1111; // 0x457 float:1.557E-42 double:5.49E-321;
        r4.bYq = r1;
        r3.add(r4);
        r1 = r0;
        goto L_0x0020;
    L_0x0042:
        r0 = r0.jOV;
        r4 = a(r0);
        if (r4 == 0) goto L_0x0032;
    L_0x004a:
        r5 = r2 + 1;
        r4.position = r2;
        r0 = r1;
        r2 = r5;
        goto L_0x0033;
    L_0x0051:
        r5 = r0.jOY;
        if (r5 == 0) goto L_0x0032;
    L_0x0055:
        r4 = r0.jOY;
        r4 = r4.jOV;
        r4 = a(r4);
        if (r4 == 0) goto L_0x0032;
    L_0x005f:
        r5 = 1;
        r4.type = r5;
        r5 = r0.jOY;
        r5 = r5.jOX;
        r4.jLe = r5;
        r0 = r0.jOY;
        r0 = r0.jOW;
        r4.jLf = r0;
        r0 = r1 + 1;
        r4.position = r1;
        goto L_0x0033;
    L_0x0073:
        r0 = r3;
        goto L_0x000c;
    L_0x0075:
        r1 = r0;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.model.aj.aUu():java.util.LinkedList<com.tencent.mm.plugin.game.model.d>");
    }

    public final HashMap<Integer, String> aUv() {
        HashMap<Integer, String> linkedHashMap = new LinkedHashMap();
        if (this.jNW.jSe == null || this.jNW.jSe.jSM == null) {
            return linkedHashMap;
        }
        Iterator it = this.jNW.jSe.jSM.iterator();
        while (it.hasNext()) {
            da daVar = (da) it.next();
            int i = daVar.jSc;
            linkedHashMap.put(Integer.valueOf(i), daVar.jPe);
        }
        return linkedHashMap;
    }

    public final LinkedList<GameLibraryCategoriesView.a> aUw() {
        if (this.jNW.jSe == null || this.jNW.jSe.jSK == null) {
            return null;
        }
        int i = 0;
        LinkedList<GameLibraryCategoriesView.a> linkedList = new LinkedList();
        Iterator it = this.jNW.jSe.jSK.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return linkedList;
            }
            m mVar = (m) it.next();
            GameLibraryCategoriesView.a aVar = new GameLibraryCategoriesView.a();
            aVar.jZu = mVar.jPL;
            aVar.jZv = mVar.jPe;
            aVar.jZw = mVar.jOX;
            aVar.fmD = mVar.jPd;
            i = i2 + 1;
            aVar.position = i;
            linkedList.add(aVar);
        }
    }
}
