package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.13;
import com.tencent.mm.plugin.fav.ui.h.2;
import com.tencent.mm.plugin.fav.ui.m$i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;

class FavoriteFileDetailUI$13$2 implements d {
    final /* synthetic */ 13 jcE;

    FavoriteFileDetailUI$13$2(13 13) {
        this.jcE = 13;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        a aVar;
        switch (menuItem.getItemId()) {
            case 0:
                if (FavoriteFileDetailUI.c(this.jcE.jcx) == 8) {
                    String b = b.b(FavoriteFileDetailUI.a(this.jcE.jcx));
                    if (!com.tencent.mm.vfs.d.cn(b)) {
                        x.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
                        Toast.makeText(this.jcE.jcx, this.jcE.jcx.getString(m$i.favorite_share_file_not_exists), 1).show();
                        return;
                    } else if (new com.tencent.mm.vfs.b(b).length() > 10485760) {
                        x.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
                        Toast.makeText(this.jcE.jcx, this.jcE.jcx.getString(m$i.favorite_share_too_large), 1).show();
                        return;
                    }
                }
                aVar = this.jcE.jcx.jcb;
                aVar.iVN++;
                FavoriteFileDetailUI.a(this.jcE.jcx, FavoriteFileDetailUI.b(this.jcE.jcx));
                return;
            case 1:
                aVar = this.jcE.jcx.jcb;
                aVar.iVO++;
                p a = h.a(this.jcE.jcx.mController.tml, this.jcE.jcx.getString(m$i.favorite_forward_tips), false, null);
                Context context = this.jcE.jcx.mController.tml;
                g b2 = FavoriteFileDetailUI.b(this.jcE.jcx);
                1 1 = new 1(this, a);
                List linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(b2.field_id));
                com.tencent.mm.kernel.g.DF().a(new am("", linkedList, new 2(b2, context, 1)), 0);
                return;
            case 2:
                h.a(this.jcE.jcx.mController.tml, this.jcE.jcx.getString(m$i.app_delete_tips), "", new 2(this), null);
                return;
            case 3:
                aVar = this.jcE.jcx.jcb;
                aVar.iVQ++;
                Intent intent = new Intent();
                intent.putExtra("key_fav_scene", 2);
                intent.putExtra("key_fav_item_id", FavoriteFileDetailUI.b(this.jcE.jcx).field_localId);
                b.a(this.jcE.jcx.mController.tml, ".ui.FavTagEditUI", intent);
                return;
            case 4:
                FavoriteFileDetailUI.k(this.jcE.jcx);
                return;
            default:
                return;
        }
    }
}
