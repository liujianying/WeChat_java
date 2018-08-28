package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class d implements a {
    private c hzK;

    public final /* synthetic */ b nE(int i) {
        return this.hzK != null ? (ShareCardInfo) this.hzK.getItem(i) : null;
    }

    public d(c cVar) {
        this.hzK = cVar;
    }

    public final void onCreate() {
        if (this.hzK != null) {
            am.axi().c(this.hzK);
        }
    }

    public final void onDestroy() {
        if (this.hzK != null) {
            am.axi().d(this.hzK);
            c cVar = this.hzK;
            cVar.hzI.release();
            cVar.hzI = null;
            cVar.aYc();
            int i = (int) (cVar.endTime - cVar.beginTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(24);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(25);
            iDKey2.SetValue((long) i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.mEJ.b(arrayList, true);
            this.hzK = null;
        }
    }

    public final void Ij() {
        if (this.hzK != null) {
            this.hzK.a(null, null);
        }
    }
}
