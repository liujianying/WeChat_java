package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI.2;
import com.tencent.mm.ui.base.n.d;

class EnterpriseBizContactListUI$2$2 implements d {
    final /* synthetic */ 2 hpm;

    EnterpriseBizContactListUI$2$2(2 2) {
        this.hpm = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case 2:
                intent = new Intent();
                intent.putExtra("Select_Talker_Name", this.hpm.hpl.hph);
                intent.putExtra("Select_block_List", this.hpm.hpl.hph);
                intent.putExtra("Select_Send_Card", true);
                intent.putExtra("Select_Conv_Type", 3);
                com.tencent.mm.bg.d.b(this.hpm.hpl, ".ui.transmit.SelectConversationUI", intent, 1);
                return;
            case 3:
                intent = new Intent(this.hpm.hpl, EnterpriseBizContactPlainListUI.class);
                intent.putExtra("enterprise_biz_name", this.hpm.hpl.hph);
                intent.putExtra("enterprise_scene", 2);
                this.hpm.hpl.startActivity(intent);
                return;
            case 4:
                intent = new Intent();
                intent.putExtra("Contact_User", this.hpm.hpl.hph);
                a.ezn.d(intent, this.hpm.hpl);
                return;
            default:
                return;
        }
    }
}
