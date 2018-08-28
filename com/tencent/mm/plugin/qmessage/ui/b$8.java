package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.TimerTask;

class b$8 extends TimerTask {
    final /* synthetic */ ProgressDialog hZo;
    final /* synthetic */ ag hlG;

    b$8(ProgressDialog progressDialog, ag agVar) {
        this.hZo = progressDialog;
        this.hlG = agVar;
    }

    public final void run() {
        if (this.hZo != null) {
            this.hZo.dismiss();
            this.hlG.sendEmptyMessage(0);
        }
    }
}
