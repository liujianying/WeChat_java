package com.tencent.mm.ui.transmit;

import com.tencent.mm.g.a.lj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.widget.a.c.a.b;
import com.tencent.mm.y.g$a;

class SelectConversationUI$7 implements b {
    final /* synthetic */ g$a fZg;
    final /* synthetic */ SelectConversationUI uEC;

    SelectConversationUI$7(SelectConversationUI selectConversationUI, g$a g_a) {
        this.uEC = selectConversationUI;
        this.fZg = g_a;
    }

    public final void aMV() {
        lj ljVar = new lj();
        ljVar.bVI.context = this.uEC.mController.tml;
        ljVar.bVI.bJC = SelectConversationUI.i(this.uEC);
        ljVar.bVI.bVJ = this.fZg.dwW;
        ljVar.bVI.bUY = false;
        ljVar.bVI.scene = 7;
        a.sFg.m(ljVar);
    }
}
