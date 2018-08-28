package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.profile.a.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;

class EnterpriseConversationUI$a$6 implements OnClickListener {
    final /* synthetic */ String dhh;
    final /* synthetic */ a uqA;
    final /* synthetic */ Context val$context;

    EnterpriseConversationUI$a$6(a aVar, String str, Context context) {
        this.uqA = aVar;
        this.dhh = str;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c cVar = new c(this.dhh, true);
        au.DF().a(1394, this.uqA);
        au.DF().a(cVar, 0);
        a aVar = this.uqA;
        Context context = this.val$context;
        this.val$context.getString(R.l.app_tip);
        a.a(aVar, h.a(context, this.val$context.getString(R.l.app_waiting), true, new 1(this, cVar)));
    }
}
