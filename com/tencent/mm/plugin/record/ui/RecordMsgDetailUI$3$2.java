package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.3;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.n.d;

class RecordMsgDetailUI$3$2 implements d {
    final /* synthetic */ 3 mtc;

    RecordMsgDetailUI$3$2(3 3) {
        this.mtc = 3;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                Intent intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("select_is_ret", true);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("Retr_Msg_Type", 10);
                intent.putExtra("Retr_Msg_Id", RecordMsgDetailUI.c(this.mtc.mtb));
                com.tencent.mm.bg.d.b(this.mtc.mtb, ".ui.transmit.SelectConversationUI", intent, 1001);
                return;
            case 2:
                ch chVar = new ch();
                e.a(chVar, RecordMsgDetailUI.c(this.mtc.mtb));
                chVar.bJF.bJM = 9;
                chVar.bJF.activity = this.mtc.mtb;
                a.sFg.m(chVar);
                return;
            default:
                return;
        }
    }
}
