package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.4;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.base.n.d;

class FavoriteSightDetailUI$4$2 implements d {
    final /* synthetic */ 4 jdr;

    FavoriteSightDetailUI$4$2(4 4) {
        this.jdr = 4;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        a aVar;
        switch (menuItem.getItemId()) {
            case 0:
                h.f(FavoriteSightDetailUI.a(this.jdr.jdp).field_localId, 1, 0);
                intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("scene_from", 1);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("select_fav_local_id", FavoriteSightDetailUI.a(this.jdr.jdp).field_localId);
                com.tencent.mm.bg.d.b(this.jdr.jdp.mController.tml, ".ui.transmit.SelectConversationUI", intent, 1);
                aVar = this.jdr.jdp.jcb;
                aVar.iVN++;
                return;
            case 2:
                com.tencent.mm.ui.base.h.a(this.jdr.jdp.mController.tml, this.jdr.jdp.getString(i.app_delete_tips), "", new 1(this), null);
                return;
            case 3:
                aVar = this.jdr.jdp.jcb;
                aVar.iVQ++;
                intent = new Intent();
                intent.putExtra("key_fav_scene", 2);
                intent.putExtra("key_fav_item_id", FavoriteSightDetailUI.a(this.jdr.jdp).field_localId);
                b.a(this.jdr.jdp.mController.tml, ".ui.FavTagEditUI", intent);
                return;
            default:
                return;
        }
    }
}
