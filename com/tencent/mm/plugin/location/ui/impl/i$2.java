package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.map.a;
import com.tencent.mm.ui.base.n$d;

class i$2 implements n$d {
    final /* synthetic */ i kKy;

    i$2(i iVar) {
        this.kKy = iVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case 0:
                this.kKy.baq();
                return;
            case 1:
                if (this.kKy.type == 2) {
                    h.f(this.kKy.activity.getIntent().getLongExtra("kFavInfoLocalId", -1), 1, 0);
                }
                intent = new Intent();
                intent.putExtra("Retr_Msg_content", e.a(this.kKy.kHP));
                intent.putExtra("Retr_Msg_Type", 9);
                d.e(this.kKy.activity, ".ui.transmit.MsgRetransmitUI", intent);
                return;
            case 2:
                this.kKy.bNP = 0;
                this.kKy.bas();
                return;
            case 3:
                this.kKy.bar();
                return;
            case 4:
                com.tencent.mm.ui.base.h.a(this.kKy.activity, this.kKy.activity.getString(a.h.app_delete_tips), "", new 1(this), null);
                return;
            case 5:
                long longExtra = this.kKy.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
                Intent intent2 = new Intent();
                intent2.putExtra("key_fav_item_id", longExtra);
                intent2.putExtra("key_fav_scene", 2);
                b.a(this.kKy.activity, ".ui.FavTagEditUI", intent2);
                return;
            case 6:
                intent = new Intent();
                intent.putExtra("Retr_Msg_content", e.a(this.kKy.kHP));
                intent.putExtra("Retr_Msg_Id", this.kKy.bJC);
                d.e(this.kKy.activity, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                return;
            default:
                return;
        }
    }
}
