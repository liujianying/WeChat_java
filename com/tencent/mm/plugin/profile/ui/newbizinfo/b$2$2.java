package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.profile.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.2;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.3;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

class b$2$2 implements d {
    final /* synthetic */ 2 lYv;

    b$2$2(2 2) {
        this.lYv = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        b bVar;
        Intent intent;
        switch (menuItem.getItemId()) {
            case 1:
                bVar = this.lYv.lYu;
                intent = new Intent();
                intent.setClass(bVar.lYs, NewBizInfoMoreInofUI.class);
                intent.putExtra("Contact_User", bVar.guS.field_username);
                if (bVar.lYs.getIntent() != null) {
                    intent.putExtras(bVar.lYs.getIntent());
                }
                bVar.lYs.startActivity(intent);
                c.bT(bVar.guS.field_username, 700);
                return;
            case 2:
                bVar = this.lYv.lYu;
                intent = new Intent();
                intent.putExtra("Select_Talker_Name", bVar.guS.field_username);
                intent.putExtra("Select_block_List", bVar.guS.field_username);
                intent.putExtra("Select_Send_Card", true);
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("mutil_select_is_ret", true);
                a.ezn.a(intent, bVar.lYs);
                c.bT(bVar.guS.field_username, 800);
                return;
            case 3:
                bVar = this.lYv.lYu;
                intent = new Intent();
                intent.setClass(bVar.lYs, NewBizInfoSettingUI.class);
                intent.putExtra("Contact_User", bVar.guS.field_username);
                if (bVar.lYs.getIntent() != null) {
                    intent.putExtras(bVar.lYs.getIntent());
                }
                bVar.lYs.startActivity(intent);
                return;
            case 4:
                b bVar2 = this.lYv.lYu;
                ((g) com.tencent.mm.kernel.g.l(g.class)).a(bVar2.lUs, bVar2.lYs, bVar2.guS, true, new 3(bVar2));
                c.bT(bVar2.guS.field_username, 1000);
                return;
            default:
                x.w("MicroMsg.ContactWidgetNewBizInfo", "default onMMMenuItemSelected err");
                return;
        }
    }
}
