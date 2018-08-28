package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.4.2;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.base.h;

class FavoriteSightDetailUI$4$2$1 implements OnClickListener {
    final /* synthetic */ 2 jds;

    FavoriteSightDetailUI$4$2$1(2 2) {
        this.jds = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.a(FavoriteSightDetailUI.a(this.jds.jdr.jdp).field_localId, new 1(this, h.a(this.jds.jdr.jdp.mController.tml, this.jds.jdr.jdp.getString(i.app_delete_tips), false, null)));
    }
}
