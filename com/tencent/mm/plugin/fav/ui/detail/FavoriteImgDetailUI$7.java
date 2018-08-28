package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.a;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

class FavoriteImgDetailUI$7 implements d {
    final /* synthetic */ FavoriteImgDetailUI jcT;
    final /* synthetic */ a jcX;

    FavoriteImgDetailUI$7(FavoriteImgDetailUI favoriteImgDetailUI, a aVar) {
        this.jcT = favoriteImgDetailUI;
        this.jcX = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        String b = b.b(this.jcX.bOz);
        if (e.cn(b)) {
            switch (menuItem.getItemId()) {
                case 1:
                    b.d(b, this.jcT.mController.tml);
                    h.f(FavoriteImgDetailUI.b(this.jcT).field_localId, 0, 0);
                    return;
                case 2:
                    if (o.Wf(b)) {
                        Intent intent = new Intent();
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("select_is_ret", true);
                        com.tencent.mm.bg.d.b(this.jcT, ".ui.transmit.SelectConversationUI", intent, 1);
                    } else {
                        b.c(b, this.jcT.mController.tml);
                    }
                    h.f(FavoriteImgDetailUI.b(this.jcT).field_localId, 1, 0);
                    return;
                case 3:
                    FavoriteImgDetailUI.a(b, this.jcT.getString(i.favorite_save_fail), this.jcT.mController.tml);
                    return;
                case 4:
                    x.i("MicroMsg.FavoriteImgDetailUI", "request deal QBAR string");
                    cb cbVar = new cb();
                    cbVar.bJq.activity = this.jcT;
                    cbVar.bJq.bHL = this.jcX.jdb;
                    cbVar.bJq.bJr = this.jcX.bJr;
                    cbVar.bJq.bJt = 7;
                    if (this.jcX.bOz != null) {
                        cbVar.bJq.imagePath = this.jcX.bOz.rzo;
                        cbVar.bJq.bJw = this.jcX.bOz.rzq;
                    }
                    cbVar.bJq.bJs = this.jcX.bJs;
                    Bundle bundle = new Bundle(1);
                    bundle.putInt("stat_scene", 5);
                    cbVar.bJq.bJx = bundle;
                    com.tencent.mm.sdk.b.a.sFg.m(cbVar);
                    return;
                default:
                    return;
            }
        }
        x.w("MicroMsg.FavoriteImgDetailUI", "file not exists");
    }
}
