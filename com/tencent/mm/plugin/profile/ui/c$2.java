package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.profile.a;
import com.tencent.mm.plugin.profile.ui.c.8;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n$d;

class c$2 implements n$d {
    final /* synthetic */ c lVT;

    c$2(c cVar) {
        this.lVT = cVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        c cVar;
        switch (menuItem.getItemId()) {
            case 1:
                cVar = this.lVT;
                Intent intent = new Intent();
                intent.putExtra("Select_Talker_Name", cVar.guS.field_username);
                intent.putExtra("Select_block_List", cVar.guS.field_username);
                intent.putExtra("Select_Send_Card", true);
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("mutil_select_is_ret", true);
                a.ezn.a(intent, cVar.bGc);
                return;
            case 2:
                this.lVT.bGc.getString(R.l.fmt_delcontactmsg_confirm, new Object[]{this.lVT.guS.BL()});
                h.a(this.lVT.bGc, this.lVT.bGc.getString(R.l.contact_info_biz_clear_msg_tips), "", this.lVT.bGc.getString(R.l.contact_info_biz_clear_msg), this.lVT.bGc.getString(R.l.app_cancel), new 1(this), null);
                return;
            case 3:
                this.lVT.bnt();
                return;
            case 4:
                c cVar2 = this.lVT;
                ((g) com.tencent.mm.kernel.g.l(g.class)).a(cVar2.lUs, cVar2.bGc, cVar2.guS, true, new c$3(cVar2));
                return;
            case 5:
                cVar = this.lVT;
                x.d("MicroMsg.ContactWidgetBizInfo", "dealAddShortcut, username = " + cVar.guS.field_username);
                b.V(cVar.bGc, cVar.guS.field_username);
                ah.i(new 8(cVar), 1000);
                return;
            default:
                return;
        }
    }
}
