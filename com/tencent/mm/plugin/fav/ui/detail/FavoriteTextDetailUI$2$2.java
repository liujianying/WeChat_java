package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.2;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.base.n.d;

class FavoriteTextDetailUI$2$2 implements d {
    final /* synthetic */ 2 jdA;

    FavoriteTextDetailUI$2$2(2 2) {
        this.jdA = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        a aVar;
        switch (menuItem.getItemId()) {
            case 0:
                if (this.jdA.jdz.jcO != null && this.jdA.jdz.jcO.field_favProto != null) {
                    intent = new Intent();
                    intent.putExtra("key_value", this.jdA.jdz.jcO.field_favProto.desc);
                    intent.putExtra("key_max_count", FavoriteTextDetailUI.jdu);
                    intent.putExtra("key_show_confirm", true);
                    intent.putExtra("key_fav_item_id", this.jdA.jdz.jcO.field_id);
                    b.a(this.jdA.jdz, ".ui.FavTextEditUI", intent, 1);
                    aVar = this.jdA.jdz.jcb;
                    aVar.iVP++;
                    return;
                }
                return;
            case 2:
                if (this.jdA.jdz.jcO != null && this.jdA.jdz.jcO.field_favProto != null) {
                    aVar = this.jdA.jdz.jcb;
                    aVar.iVN++;
                    b.e(this.jdA.jdz.jcO.field_favProto.desc, this.jdA.jdz);
                    h.f(this.jdA.jdz.jcO.field_localId, 1, 0);
                    return;
                }
                return;
            case 3:
                intent = new Intent();
                intent.putExtra("key_fav_scene", 2);
                intent.putExtra("key_fav_item_id", this.jdA.jdz.jcO.field_localId);
                b.a(this.jdA.jdz.mController.tml, ".ui.FavTagEditUI", intent);
                aVar = this.jdA.jdz.jcb;
                aVar.iVQ++;
                return;
            case 4:
                com.tencent.mm.ui.base.h.a(this.jdA.jdz.mController.tml, this.jdA.jdz.getString(i.app_delete_tips), "", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b.a(FavoriteTextDetailUI$2$2.this.jdA.jdz.jdk, new 1(this, com.tencent.mm.ui.base.h.a(FavoriteTextDetailUI$2$2.this.jdA.jdz.mController.tml, FavoriteTextDetailUI$2$2.this.jdA.jdz.getString(i.app_delete_tips), false, null)));
                    }
                }, null);
                return;
            default:
                return;
        }
    }
}
