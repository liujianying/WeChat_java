package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.ui.SelectDateUI.1;

class SelectDateUI$1$1 implements Runnable {
    final /* synthetic */ 1 hOW;

    SelectDateUI$1$1(1 1) {
        this.hOW = 1;
    }

    public final void run() {
        SelectDateUI.c(this.hOW.hOV).setBeginDate(SelectDateUI.b(this.hOW.hOV) == -1 ? System.currentTimeMillis() * 1000 : SelectDateUI.b(this.hOW.hOV));
        SelectDateUI.c(this.hOW.hOV).a(this.hOW.hOV, SelectDateUI.d(this.hOW.hOV).values());
        if (SelectDateUI.d(this.hOW.hOV).size() == 0) {
            SelectDateUI.e(this.hOW.hOV).setVisibility(0);
            SelectDateUI.c(this.hOW.hOV).setVisibility(8);
            SelectDateUI.e(this.hOW.hOV).setText(this.hOW.hOV.getString(R.l.chatting_record_noting_hint));
            return;
        }
        SelectDateUI.e(this.hOW.hOV).setVisibility(8);
        SelectDateUI.c(this.hOW.hOV).setVisibility(0);
    }
}
