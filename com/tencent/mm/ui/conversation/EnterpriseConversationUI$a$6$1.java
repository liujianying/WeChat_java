package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.profile.a.c;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a.6;

class EnterpriseConversationUI$a$6$1 implements OnCancelListener {
    final /* synthetic */ c hpy;
    final /* synthetic */ 6 uqB;

    EnterpriseConversationUI$a$6$1(6 6, c cVar) {
        this.uqB = 6;
        this.hpy = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.hpy);
        au.DF().b(1394, this.uqB.uqA);
    }
}
