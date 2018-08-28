package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;

class SelectMemberChattingRecordUI$2 implements a {
    final /* synthetic */ SelectMemberChattingRecordUI hPm;

    SelectMemberChattingRecordUI$2(SelectMemberChattingRecordUI selectMemberChattingRecordUI) {
        this.hPm = selectMemberChattingRecordUI;
    }

    public final void aAU() {
        if (SelectMemberChattingRecordUI.a(this.hPm) != null) {
            SelectMemberChattingRecordUI$a a = SelectMemberChattingRecordUI.a(this.hPm);
            a.hPo -= 16;
            if (!bi.oW(SelectMemberChattingRecordUI.c(a.hPm)) && q.gQ(SelectMemberChattingRecordUI.c(a.hPm))) {
                au.HU();
                a.setCursor(c.FT().bG(a.gBf, a.edl - a.hPo));
            } else if (!q.gQ(SelectMemberChattingRecordUI.c(a.hPm))) {
                au.HU();
                a.setCursor(c.FT().E(a.gBf, a.hPn, a.edl - a.hPo));
            }
            SelectMemberChattingRecordUI.a(this.hPm).notifyDataSetChanged();
        }
    }
}
