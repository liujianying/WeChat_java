package com.tencent.mm.ui.transmit;

import android.view.View;
import android.view.View.OnClickListener;

class SelectConversationUI$12 implements OnClickListener {
    final /* synthetic */ SelectConversationUI uEC;

    SelectConversationUI$12(SelectConversationUI selectConversationUI) {
        this.uEC = selectConversationUI;
    }

    public final void onClick(View view) {
        if (SelectConversationUI.a(this.uEC)) {
            SelectConversationUI.b(this.uEC);
        } else if (SelectConversationUI.c(this.uEC)) {
            SelectConversationUI.d(this.uEC);
        } else {
            SelectConversationUI.e(this.uEC);
        }
    }
}
