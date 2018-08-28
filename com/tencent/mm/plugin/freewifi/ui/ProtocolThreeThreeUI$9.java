package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeThreeUI$9 implements OnCancelListener {
    final /* synthetic */ ProtocolThreeThreeUI joy;

    ProtocolThreeThreeUI$9(ProtocolThreeThreeUI protocolThreeThreeUI) {
        this.joy = protocolThreeThreeUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        d.a(this.joy.ssid, 4, this.joy.getIntent());
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[]{m.E(this.joy.getIntent()), Integer.valueOf(m.F(this.joy.getIntent())), Integer.valueOf(4)});
    }
}
