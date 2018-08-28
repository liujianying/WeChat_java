package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class a extends com.tencent.mm.plugin.fts.ui.a {
    private boolean jzm;

    public a(Context context, b bVar, int i) {
        boolean z;
        super(context, bVar, i);
        String str = (String) g.Ei().DT().get(6, null);
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        this.jzm = z;
        x.d("MicroMsg.FTS.FTSAddFriendUIUnit", "[FTSAddFriendUIUnit doSearchMobile : %s]", new Object[]{Boolean.valueOf(this.jzm)});
    }

    protected final com.tencent.mm.plugin.fts.a.a.a a(ag agVar, HashSet<String> hashSet) {
        String str = this.bWm;
        ArrayList arrayList = new ArrayList();
        if (this.jzm) {
            arrayList.add(Integer.valueOf(131073));
            arrayList.add(Integer.valueOf(131074));
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                i = i2 + 1;
            } else {
                return ((n) g.n(n.class)).search(9, i.a(str, iArr, aQQ(), -1, hashSet, com.tencent.mm.plugin.fts.a.c.b.jsU, this, agVar));
            }
        }
    }

    private int[] aQQ() {
        ArrayList arrayList = new ArrayList();
        if (this.jzm) {
            arrayList.add(Integer.valueOf(16));
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return iArr;
            }
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            i = i2 + 1;
        }
    }

    protected final void a(j jVar, HashSet<String> hashSet) {
        List list = jVar.jsx;
        this.jvp.clear();
        com.tencent.mm.plugin.fts.a.d.e.a aVar = new com.tencent.mm.plugin.fts.a.d.e.a();
        aVar.iPZ = -4;
        aVar.jtb = false;
        aVar.jth = 1;
        aVar.jrx = jVar.jrx;
        aVar.jte = new LinkedList();
        this.jvp.add(aVar);
        if (bk(list)) {
            list = d.a(list, c.jqq);
            if (bk(list)) {
                aVar = new com.tencent.mm.plugin.fts.a.d.e.a();
                aVar.iPZ = -11;
                aVar.jte = list;
                aVar.jrx = jVar.jrx;
                this.jvp.add(aVar);
            }
        }
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a a(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        int i2 = (i - aVar.jta) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.jte.size() && i2 >= 0) {
            com.tencent.mm.plugin.fts.a.d.a.a a;
            l lVar = (l) aVar.jte.get(i2);
            if (lVar.type == 131073 || lVar.type == 131074) {
                a = ((com.tencent.mm.plugin.fts.ui.a) ((n) g.n(n.class)).createFTSUIUnit(33, this.context, this.jsY, this.jsZ)).a(lVar.type, i, lVar, aVar);
            } else {
                a = null;
            }
            aVar2 = a;
        } else if (!aVar.jtb && i == 0) {
            aVar2 = new com.tencent.mm.plugin.fts.ui.a.a(i);
            aVar2.jrx = aVar.jrx;
        }
        if (aVar2 != null) {
            aVar2.jtm = i2 + 1;
        }
        return aVar2;
    }

    public final int getType() {
        return 8192;
    }
}
