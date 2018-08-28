package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.2;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

class FavoriteVoiceDetailUI$2$2 implements d {
    final /* synthetic */ 2 jdT;

    FavoriteVoiceDetailUI$2$2(2 2) {
        this.jdT = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                Intent intent = new Intent();
                intent.putExtra("key_fav_scene", 2);
                intent.putExtra("key_fav_item_id", this.jdT.jdS.iWQ.field_localId);
                b.a(this.jdT.jdS.mController.tml, ".ui.FavTagEditUI", intent);
                a aVar = this.jdT.jdS.jcb;
                aVar.iVQ++;
                return;
            case 1:
                h.a(this.jdT.jdS.mController.tml, this.jdT.jdS.getString(i.app_delete_tips), "", new 1(this), null);
                return;
            default:
                return;
        }
    }
}
