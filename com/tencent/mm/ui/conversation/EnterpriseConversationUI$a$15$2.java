package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.bg.d;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a.15;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.transmit.SelectConversationUI;

class EnterpriseConversationUI$a$15$2 implements n$d {
    final /* synthetic */ 15 uqC;

    EnterpriseConversationUI$a$15$2(15 15) {
        this.uqC = 15;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int i2 = 0;
        Intent intent;
        switch (menuItem.getItemId()) {
            case 2:
                g.o(this.uqC.uqA.getContext(), a.c(this.uqC.uqA), 5);
                break;
            case 3:
                intent = new Intent(this.uqC.uqA.thisActivity(), SelectConversationUI.class);
                intent.putExtra("Select_Talker_Name", a.c(this.uqC.uqA));
                intent.putExtra("Select_block_List", a.c(this.uqC.uqA));
                intent.putExtra("Select_Send_Card", true);
                intent.putExtra("Select_Conv_Type", 3);
                this.uqC.uqA.startActivityForResult(intent, 1);
                i2 = 3;
                break;
            case 4:
                i2 = 4;
                Intent intent2 = new Intent();
                intent2.putExtra("enterprise_biz_name", a.c(this.uqC.uqA));
                intent2.putExtra("enterprise_scene", 2);
                d.b(this.uqC.uqA.thisActivity(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent2);
                break;
            case 5:
                intent = new Intent();
                intent.putExtra("Contact_User", a.c(this.uqC.uqA));
                d.b(this.uqC.uqA.thisActivity(), "profile", ".ui.ContactInfoUI", intent);
                i2 = 5;
                break;
        }
        g.di(a.c(this.uqC.uqA), i2);
    }
}
