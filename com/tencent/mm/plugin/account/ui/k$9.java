package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;

class k$9 implements OnClickListener {
    final /* synthetic */ k eSG;

    k$9(k kVar) {
        this.eSG = kVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",R200_200,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(a.gd("R200_200")).append(",2").toString());
    }
}
