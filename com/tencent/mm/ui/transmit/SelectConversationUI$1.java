package com.tencent.mm.ui.transmit;

import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.sdk.platformtools.x;

class SelectConversationUI$1 implements a {
    final /* synthetic */ SelectConversationUI uEC;

    SelectConversationUI$1(SelectConversationUI selectConversationUI) {
        this.uEC = selectConversationUI;
    }

    public final void dG(boolean z) {
        boolean isFinishing = this.uEC.isFinishing();
        x.i("MicroMsg.SelectConversationUI", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
        if (!z && !isFinishing) {
            this.uEC.finish();
        }
    }
}
