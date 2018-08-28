package com.tencent.mm.plugin.order.ui;

import com.tencent.mm.ui.base.MMLoadMoreListView.a;

class MallOrderRecordListUI$3 implements a {
    final /* synthetic */ MallOrderRecordListUI lPQ;

    MallOrderRecordListUI$3(MallOrderRecordListUI mallOrderRecordListUI) {
        this.lPQ = mallOrderRecordListUI;
    }

    public final void aAU() {
        if (!this.lPQ.acT) {
            this.lPQ.acT = true;
            MallOrderRecordListUI mallOrderRecordListUI = this.lPQ;
            mallOrderRecordListUI.tH += 10;
            this.lPQ.bmC();
        }
    }
}
