package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.g.a.mu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class RecordMsgImageUI$3 extends c<mu> {
    final /* synthetic */ RecordMsgImageUI mtp;

    RecordMsgImageUI$3(RecordMsgImageUI recordMsgImageUI) {
        this.mtp = recordMsgImageUI;
        this.sFo = mu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mu muVar = (mu) bVar;
        RecordMsgImageUI.i(this.mtp).put(muVar.bXK.filePath, muVar);
        if (RecordMsgImageUI.k(this.mtp) != null && RecordMsgImageUI.k(this.mtp).ofo.isShowing()) {
            RecordMsgImageUI.d(this.mtp);
        }
        return true;
    }
}
