package com.tencent.mm.plugin.voip_cs.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class VoipCSMainUI$17 implements OnClickListener {
    final /* synthetic */ VoipCSMainUI oYm;

    VoipCSMainUI$17(VoipCSMainUI voipCSMainUI) {
        this.oYm = voipCSMainUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.voipcs.VoipCSMainUI", "cannot start voip by user choose cancel call  in not wifi network!");
        dialogInterface.dismiss();
        this.oYm.yZ(8);
    }
}
