package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;

class h$3 implements OnClickListener {
    final /* synthetic */ h eSy;

    h$3(h hVar) {
        this.eSy = hVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",F200_200,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(a.gd("F200_200")).append(",2").toString());
    }
}
