package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiFrontPageUI$6 implements OnCancelListener {
    final /* synthetic */ FreeWifiFrontPageUI jnd;

    FreeWifiFrontPageUI$6(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        this.jnd = freeWifiFrontPageUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        d.a(this.jnd.ssid, 4, this.jnd.getIntent());
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[]{m.E(this.jnd.getIntent()), Integer.valueOf(m.F(this.jnd.getIntent())), Integer.valueOf(4)});
    }
}
