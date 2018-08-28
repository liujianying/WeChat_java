package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

class RecordMsgImageUI$11 implements Runnable {
    final /* synthetic */ Runnable bzs;
    final /* synthetic */ String jal;
    final /* synthetic */ List mth;
    final /* synthetic */ RecordMsgImageUI mtp;

    RecordMsgImageUI$11(RecordMsgImageUI recordMsgImageUI, List list, String str, Runnable runnable) {
        this.mtp = recordMsgImageUI;
        this.mth = list;
        this.jal = str;
        this.bzs = runnable;
    }

    public final void run() {
        for (String str : this.mth) {
            g.bcT().a(this.mtp.mController.tml, str, RecordMsgImageUI.j(this.mtp), 0, "", "");
            g.bcT().dF(this.jal, str);
        }
        ah.A(this.bzs);
    }

    public final String toString() {
        return super.toString() + "|onActivityResult";
    }
}
