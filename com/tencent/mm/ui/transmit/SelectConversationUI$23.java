package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.x;

class SelectConversationUI$23 implements a {
    final /* synthetic */ SelectConversationUI uEC;
    final /* synthetic */ Intent val$intent;

    SelectConversationUI$23(SelectConversationUI selectConversationUI, Intent intent) {
        this.uEC = selectConversationUI;
        this.val$intent = intent;
    }

    public final void a(boolean z, String str, int i) {
        this.uEC.YC();
        boolean booleanExtra = this.val$intent.getBooleanExtra("need_delete_chatroom_when_cancel", false);
        if (booleanExtra) {
            int i2 = z ? 1 : 0;
            x.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomOperation %d %d", new Object[]{Integer.valueOf(13943), Integer.valueOf(i2)});
            h.mEJ.h(13943, new Object[]{Integer.valueOf(i2)});
        }
        if (z) {
            this.val$intent.putExtra("custom_send_text", str);
            SelectConversationUI.a(this.uEC, this.val$intent);
            this.uEC.finish();
        } else if (booleanExtra) {
            String stringExtra = this.val$intent.getStringExtra("Select_Contact");
            au.HU();
            c.FW().Yp(stringExtra);
        }
    }
}
