package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class a$1 implements OnCancelListener {
    final /* synthetic */ a qIg;

    a$1(a aVar) {
        this.qIg = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a.a(this.qIg, false, this.qIg.qIa, this.qIg.eNh);
    }
}
