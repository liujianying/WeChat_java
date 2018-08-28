package com.tencent.mm.plugin.shake.ui;

import android.app.ProgressDialog;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.TimerTask;

class a$3 extends TimerTask {
    final /* synthetic */ ProgressDialog hZo;
    final /* synthetic */ ag hlG;

    a$3(ProgressDialog progressDialog, ag agVar) {
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
