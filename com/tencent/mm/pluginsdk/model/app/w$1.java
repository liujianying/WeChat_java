package com.tencent.mm.pluginsdk.model.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ac.a;
import com.tencent.mm.sdk.platformtools.x;

class w$1 implements OnCancelListener {
    final /* synthetic */ w qAb;

    public w$1(w wVar) {
        this.qAb = wVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.w("MicroMsg.LoadAppInfoAfterLogin", "do init canceled");
        g.DF().c(this.qAb.bKq);
        a.bmi().b(7, this.qAb);
        if (this.qAb.qAa != null) {
            this.qAb.qAa.Zq();
        }
    }
}
