package com.tencent.mm.plugin.appbrand.debugger;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class q$4 implements OnClickListener {
    final /* synthetic */ q ftZ;

    q$4(q qVar) {
        this.ftZ = qVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (q.d(this.ftZ) != null) {
            q.d(this.ftZ).aeA();
        }
    }
}
