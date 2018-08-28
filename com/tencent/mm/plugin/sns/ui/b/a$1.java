package com.tencent.mm.plugin.sns.ui.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.r;

class a$1 implements OnCancelListener {
    final /* synthetic */ r nMk;
    final /* synthetic */ a oku;

    a$1(a aVar, r rVar) {
        this.oku = aVar;
        this.nMk = rVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Ek();
        g.Eh().dpP.c(this.nMk);
    }
}
