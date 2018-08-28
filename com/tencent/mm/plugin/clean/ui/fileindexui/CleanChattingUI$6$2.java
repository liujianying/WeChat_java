package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.6;

class CleanChattingUI$6$2 implements Runnable {
    final /* synthetic */ 6 hSt;

    CleanChattingUI$6$2(6 6) {
        this.hSt = 6;
    }

    public final void run() {
        CleanChattingUI.a(this.hSt.hSr).notifyDataSetChanged();
        CleanChattingUI.e(this.hSt.hSr).setText(R.l.clean_chatting_empty);
    }
}
