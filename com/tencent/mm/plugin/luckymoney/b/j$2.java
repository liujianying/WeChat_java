package com.tencent.mm.plugin.luckymoney.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import java.util.Iterator;

class j$2 implements OnCancelListener {
    final /* synthetic */ j kQw;

    j$2(j jVar) {
        this.kQw = jVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.kQw.tipDialog != null && this.kQw.eXE.isEmpty()) {
            this.kQw.tipDialog.dismiss();
            Iterator it = this.kQw.eXF.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                g.Ek();
                g.Eh().dpP.c(lVar);
            }
            this.kQw.eXF.clear();
        }
    }
}
