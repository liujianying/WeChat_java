package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import java.util.Iterator;

class i$2 implements OnCancelListener {
    final /* synthetic */ i uXP;

    i$2(i iVar) {
        this.uXP = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.uXP.eXG != null && this.uXP.eXE.isEmpty()) {
            this.uXP.eXG.dismiss();
            Iterator it = this.uXP.eXF.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                g.Ek();
                g.Eh().dpP.c(lVar);
            }
            this.uXP.eXF.clear();
        }
    }
}
