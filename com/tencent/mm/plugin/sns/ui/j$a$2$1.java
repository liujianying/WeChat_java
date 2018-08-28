package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.ui.j.a.2;

class j$a$2$1 implements OnCancelListener {
    final /* synthetic */ r nMk;
    final /* synthetic */ 2 nMl;

    j$a$2$1(2 2, r rVar) {
        this.nMl = 2;
        this.nMk = rVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Ek();
        g.Eh().dpP.c(this.nMk);
    }
}
