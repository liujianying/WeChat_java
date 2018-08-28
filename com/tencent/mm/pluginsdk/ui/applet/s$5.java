package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class s$5 implements OnCancelListener {
    final /* synthetic */ s qJM;

    s$5(s sVar) {
        this.qJM = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.qJM.onStop();
        if (this.qJM.qJI != null) {
            this.qJM.qJI.ea(false);
        }
    }
}
