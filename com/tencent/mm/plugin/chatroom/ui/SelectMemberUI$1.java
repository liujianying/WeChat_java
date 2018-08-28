package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.b;
import com.tencent.mm.ui.base.VerticalScrollBar.a;

class SelectMemberUI$1 implements a {
    final /* synthetic */ SelectMemberUI hPv;

    SelectMemberUI$1(SelectMemberUI selectMemberUI) {
        this.hPv = selectMemberUI;
    }

    public final void ys(String str) {
        if ("↑".equals(str)) {
            SelectMemberUI.a(this.hPv).setSelection(0);
            return;
        }
        int intValue;
        b b = SelectMemberUI.b(this.hPv);
        if (b.hPz.containsKey(str)) {
            intValue = ((Integer) b.hPz.get(str)).intValue();
        } else {
            intValue = -1;
        }
        if (intValue != -1) {
            SelectMemberUI.a(this.hPv).setSelection(intValue);
        }
    }
}
