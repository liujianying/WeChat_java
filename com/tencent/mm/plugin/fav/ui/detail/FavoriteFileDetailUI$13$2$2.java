package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.13.2;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.base.h;

class FavoriteFileDetailUI$13$2$2 implements OnClickListener {
    final /* synthetic */ 2 jcF;

    FavoriteFileDetailUI$13$2$2(2 2) {
        this.jcF = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.a(FavoriteFileDetailUI.b(this.jcF.jcE.jcx).field_localId, new 1(this, h.a(this.jcF.jcE.jcx.mController.tml, this.jcF.jcE.jcx.getString(i.app_delete_tips), false, null)));
    }
}
