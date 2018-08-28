package com.tencent.mm.model;

import android.support.design.a$i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class f$3 implements Runnable {
    final /* synthetic */ bd dAB;
    final /* synthetic */ f dAz;

    f$3(f fVar, bd bdVar) {
        this.dAz = fVar;
        this.dAB = bdVar;
    }

    public final void run() {
        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "[deleteLocalFile] id:%s type:%s", new Object[]{Long.valueOf(this.dAB.field_msgId), Integer.valueOf(this.dAB.getType())});
        switch (this.dAB.getType()) {
            case 3:
            case a$i.AppCompatTheme_actionModePasteDrawable /*34*/:
            case a$i.AppCompatTheme_dialogPreferredPadding /*43*/:
            case a$i.AppCompatTheme_listDividerAlertDialog /*44*/:
            case a$i.AppCompatTheme_actionButtonStyle /*49*/:
            case 62:
            case 268435505:
                bd.j(this.dAB);
                return;
            default:
                return;
        }
    }
}
