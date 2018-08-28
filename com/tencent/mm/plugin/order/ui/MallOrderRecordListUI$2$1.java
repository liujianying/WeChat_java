package com.tencent.mm.plugin.order.ui;

import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.2;
import com.tencent.mm.ui.base.h.c;

class MallOrderRecordListUI$2$1 implements c {
    final /* synthetic */ int hW;
    final /* synthetic */ 2 lPR;

    MallOrderRecordListUI$2$1(2 2, int i) {
        this.lPR = 2;
        this.hW = i;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                i iVar = (i) this.lPR.lPQ.lPM.get(this.hW);
                if (iVar != null) {
                    this.lPR.lPQ.ed(iVar.lOE, iVar.lOX);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
