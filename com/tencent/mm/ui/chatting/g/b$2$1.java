package com.tencent.mm.ui.chatting.g;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.g.b.2;
import java.util.ArrayList;
import java.util.Iterator;

class b$2$1 implements a {
    final /* synthetic */ 2 tYg;

    b$2$1(2 2) {
        this.tYg = 2;
    }

    public final boolean vD() {
        String str = "MicroMsg.BaseHistoryListPresenter";
        String str2 = "[onTimerExpired]  mDataListCache is null?:%s mSearchText is null?:%s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.tYg.tYf.tYc == null);
        objArr[1] = Boolean.valueOf(bi.oW(this.tYg.tNU));
        x.i(str, str2, objArr);
        if (bi.oW(this.tYg.tNU)) {
            this.tYg.tYf.tYa.tNU = this.tYg.tNU;
            if (this.tYg.tYf.tYc == null) {
                this.tYg.tYf.cwG();
            } else {
                this.tYg.tYf.gBc = this.tYg.tYf.tYc;
                ah.A(new 1(this));
            }
        } else {
            this.tYg.tYf.gBc = this.tYg.tYf.tYc;
            ArrayList arrayList = new ArrayList();
            Iterator it = this.tYg.tYf.gBc.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.aak(this.tYg.tNU)) {
                    arrayList.add(bVar);
                }
            }
            this.tYg.tYf.gBc = arrayList;
            this.tYg.tYf.tYa.tNU = this.tYg.tNU;
            ah.A(new Runnable() {
                public final void run() {
                    b$2$1.this.tYg.tYf.tYa.RR.notifyChanged();
                    b$2$1.this.tYg.tYf.tXZ.bz(b$2$1.this.tYg.tNU, b$2$1.this.tYg.tYf.gBc.isEmpty());
                }
            });
        }
        return false;
    }
}
