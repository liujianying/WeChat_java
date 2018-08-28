package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.AdapterView.AdapterContextMenuInfo;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;
import java.util.List;

class FavoriteIndexUI$17 implements d {
    final /* synthetic */ FavoriteIndexUI jbh;

    FavoriteIndexUI$17(FavoriteIndexUI favoriteIndexUI) {
        this.jbh = favoriteIndexUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (FavoriteIndexUI.e(this.jbh)) {
            case 0:
                if (menuItem != null) {
                    AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) menuItem.getMenuInfo();
                    switch (menuItem.getItemId()) {
                        case 0:
                            if (adapterContextMenuInfo.position >= this.jbh.iYa.getHeaderViewsCount()) {
                                x.i("MicroMsg.FavoriteIndexUI", "do delete, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                                b.i(FavoriteIndexUI.a(this.jbh).pQ((adapterContextMenuInfo.position - this.jbh.iYa.getHeaderViewsCount()) - 1));
                                return;
                            }
                            return;
                        case 1:
                            FavoriteIndexUI.a(this.jbh, bi.VE());
                            x.i("MicroMsg.FavoriteIndexUI", "do edit, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                            FavoriteIndexUI.a(this.jbh, FavoriteIndexUI.a(this.jbh).pQ((adapterContextMenuInfo.position - this.jbh.iYa.getHeaderViewsCount()) - 1));
                            FavoriteIndexUI.b(this.jbh, FavoriteIndexUI.f(this.jbh));
                            return;
                        case 2:
                            x.i("MicroMsg.FavoriteIndexUI", "do tag, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                            g pQ = FavoriteIndexUI.a(this.jbh).pQ((adapterContextMenuInfo.position - this.jbh.iYa.getHeaderViewsCount()) - 1);
                            Intent intent = new Intent();
                            intent.putExtra("key_fav_scene", 4);
                            intent.putExtra("key_fav_item_id", pQ.field_localId);
                            b.a(this.jbh.mController.tml, ".ui.FavTagEditUI", intent);
                            i.Bk("FavTagEditUI");
                            return;
                        case 3:
                            FavoriteIndexUI.a(this.jbh, bi.VE());
                            x.i("MicroMsg.FavoriteIndexUI", "do transmit, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                            FavoriteIndexUI.c(this.jbh, FavoriteIndexUI.a(this.jbh).pQ((adapterContextMenuInfo.position - this.jbh.iYa.getHeaderViewsCount()) - 1));
                            FavoriteIndexUI.c(this.jbh, FavoriteIndexUI.g(this.jbh).clone());
                            if (FavoriteIndexUI.g(this.jbh) != null) {
                                List linkedList = new LinkedList();
                                linkedList.add(FavoriteIndexUI.g(this.jbh));
                                if (FavoriteIndexUI.a(linkedList, this.jbh, new 1(this))) {
                                    FavoriteIndexUI.a(this.jbh, 4106);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
