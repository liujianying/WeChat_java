package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class b$1 implements OnCancelListener {
    final /* synthetic */ b qIl;

    b$1(b bVar) {
        this.qIl = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.qIl.eEX != null) {
            this.qIl.eEX.dismiss();
            this.qIl.eEX = null;
        }
    }
}
