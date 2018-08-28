package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.a.d;

class FavoriteImgDetailUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteImgDetailUI jcT;

    FavoriteImgDetailUI$2(FavoriteImgDetailUI favoriteImgDetailUI) {
        this.jcT = favoriteImgDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.jcT.mController.tml, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                Intent intent;
                a aVar;
                switch (menuItem.getItemId()) {
                    case 0:
                        intent = new Intent();
                        intent.putExtra("key_fav_scene", 2);
                        intent.putExtra("key_fav_item_id", FavoriteImgDetailUI.b(FavoriteImgDetailUI$2.this.jcT).field_localId);
                        b.a(FavoriteImgDetailUI$2.this.jcT.mController.tml, ".ui.FavTagEditUI", intent);
                        aVar = FavoriteImgDetailUI$2.this.jcT.jcb;
                        aVar.iVQ++;
                        return;
                    case 1:
                        h.a(FavoriteImgDetailUI$2.this.jcT.mController.tml, FavoriteImgDetailUI$2.this.jcT.getString(i.app_delete_tips), "", new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                b.a(FavoriteImgDetailUI.b(FavoriteImgDetailUI$2.this.jcT).field_localId, new 1(this, h.a(FavoriteImgDetailUI$2.this.jcT.mController.tml, FavoriteImgDetailUI$2.this.jcT.getString(i.app_delete_tips), false, null)));
                            }
                        }, null);
                        return;
                    case 2:
                        intent = new Intent();
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("scene_from", 1);
                        intent.putExtra("mutil_select_is_ret", true);
                        intent.putExtra("select_fav_local_id", FavoriteImgDetailUI.b(FavoriteImgDetailUI$2.this.jcT).field_localId);
                        com.tencent.mm.bg.d.b(FavoriteImgDetailUI$2.this.jcT, ".ui.transmit.SelectConversationUI", intent, 1);
                        com.tencent.mm.plugin.fav.a.h.f(FavoriteImgDetailUI.b(FavoriteImgDetailUI$2.this.jcT).field_localId, 1, 0);
                        aVar = FavoriteImgDetailUI$2.this.jcT.jcb;
                        aVar.iVN++;
                        return;
                    default:
                        return;
                }
            }
        };
        dVar.bXO();
        return true;
    }
}
