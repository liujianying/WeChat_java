package com.tencent.mm.plugin.qmessage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class QConversationUI$3 implements OnCancelListener {
    final /* synthetic */ QConversationUI mbV;

    QConversationUI$3(QConversationUI qConversationUI) {
        this.mbV = qConversationUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        QConversationUI.h(this.mbV);
    }
}
