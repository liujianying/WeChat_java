package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2;
import com.tencent.mm.ui.base.n$d;

class FavRecordDetailUI$2$2 implements n$d {
    final /* synthetic */ 2 msI;

    FavRecordDetailUI$2$2(2 2) {
        this.msI = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case 0:
                intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("scene_from", 1);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("select_fav_local_id", FavRecordDetailUI.b(this.msI.msF).field_localId);
                d.b(this.msI.msF, ".ui.transmit.SelectConversationUI", intent, 4097);
                h.f(FavRecordDetailUI.b(this.msI.msF).field_localId, 1, 0);
                return;
            case 2:
                com.tencent.mm.ui.base.h.a(this.msI.msF.mController.tml, this.msI.msF.getString(R.l.app_delete_tips), "", new 1(this), null);
                return;
            case 3:
                intent = new Intent();
                intent.putExtra("key_fav_scene", 2);
                intent.putExtra("key_fav_item_id", FavRecordDetailUI.a(this.msI.msF));
                b.a(this.msI.msF.mController.tml, ".ui.FavTagEditUI", intent);
                return;
            case 4:
                intent = new Intent();
                intent.putExtra("key_fav_scene", 1);
                intent.putExtra("key_fav_item_id", FavRecordDetailUI.b(this.msI.msF).field_localId);
                b.a(this.msI.msF.mController.tml, ".ui.FavTagEditUI", intent);
                return;
            default:
                return;
        }
    }
}
