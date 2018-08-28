package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class SingleChatInfoUI$5 implements OnClickListener {
    final /* synthetic */ SingleChatInfoUI tqo;

    SingleChatInfoUI$5(SingleChatInfoUI singleChatInfoUI) {
        this.tqo = singleChatInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(14553, new Object[]{Integer.valueOf(6), Integer.valueOf(4), SingleChatInfoUI.d(this.tqo)});
        SingleChatInfoUI.dv(true);
        if (SingleChatInfoUI.e(this.tqo)) {
            this.tqo.finish();
            return;
        }
        LauncherUI cpQ = LauncherUI.cpQ();
        if (cpQ != null) {
            cpQ.startChatting(SingleChatInfoUI.f(this.tqo).field_username, null, true);
        }
    }
}
