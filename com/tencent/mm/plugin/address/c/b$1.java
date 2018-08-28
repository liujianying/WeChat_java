package com.tencent.mm.plugin.address.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import java.util.Iterator;

class b$1 implements OnCancelListener {
    final /* synthetic */ b eXV;

    b$1(b bVar) {
        this.eXV = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.eXV.eXG != null && this.eXV.eXE.isEmpty()) {
            this.eXV.eXG.dismiss();
            Iterator it = this.eXV.eXF.iterator();
            while (it.hasNext()) {
                au.DF().c((l) it.next());
            }
            this.eXV.eXF.clear();
        }
    }
}
