package com.tencent.mm.plugin.address.b.b;

import android.app.Dialog;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;

public final class a implements e {
    private HashSet<l> eXE;
    private HashSet<l> eXF;
    private Dialog eXG;

    public final void a(int i, int i2, String str, l lVar) {
        if (this.eXF.contains(lVar)) {
            this.eXF.remove(lVar);
            x.d("MicroMsg.InvoiceNetSceneMgr", "has find scene ");
        } else if (this.eXE.contains(lVar)) {
            this.eXE.remove(lVar);
            x.d("MicroMsg.InvoiceNetSceneMgr", "has find forcescenes ");
        }
        if (this.eXF.isEmpty() && this.eXE.isEmpty() && this.eXG != null) {
            this.eXG.dismiss();
            this.eXG = null;
        }
    }
}
