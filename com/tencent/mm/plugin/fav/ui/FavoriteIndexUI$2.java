package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.ui.base.h;

class FavoriteIndexUI$2 implements a {
    final /* synthetic */ FavoriteIndexUI jbh;

    FavoriteIndexUI$2(FavoriteIndexUI favoriteIndexUI) {
        this.jbh = favoriteIndexUI;
    }

    public final void aMy() {
        if (FavoriteIndexUI.a(FavoriteIndexUI.a(this.jbh).eU(false), this.jbh, new 1(this))) {
            FavoriteIndexUI.a(this.jbh, 4105);
        }
    }

    public final void aMh() {
        h.a(this.jbh.mController.tml, this.jbh.getString(i.favorite_delete_items_confirm), "", new 2(this), null);
    }

    public final void aMz() {
        if (FavoriteIndexUI.a(this.jbh).aMG() > 0) {
            if (FavoriteIndexUI.a(this.jbh).aMG() > 1) {
                Intent intent = new Intent();
                intent.putExtra("key_fav_scene", 3);
                b.a(this.jbh.mController.tml, ".ui.FavTagEditUI", intent, 4104);
                com.tencent.mm.plugin.fav.a.i.Bk("FavTagEditUI");
                return;
            }
            g gVar = (g) FavoriteIndexUI.a(this.jbh).eU(false).get(0);
            Intent intent2 = new Intent();
            intent2.putExtra("key_fav_scene", 3);
            intent2.putExtra("key_fav_item_id", gVar.field_localId);
            b.a(this.jbh.mController.tml, ".ui.FavTagEditUI", intent2);
            com.tencent.mm.plugin.fav.a.i.Bk("FavTagEditUI");
            if (FavoriteIndexUI.a(this.jbh).jbI) {
                FavoriteIndexUI.b(this.jbh);
            }
        }
    }
}
