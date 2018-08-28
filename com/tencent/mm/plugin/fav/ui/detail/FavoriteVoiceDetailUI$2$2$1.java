package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.2.2;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.base.h;

class FavoriteVoiceDetailUI$2$2$1 implements OnClickListener {
    final /* synthetic */ 2 jdU;

    FavoriteVoiceDetailUI$2$2$1(2 2) {
        this.jdU = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.a(FavoriteVoiceDetailUI.a(this.jdU.jdT.jdS).field_localId, new 1(this, h.a(this.jdU.jdT.jdS.mController.tml, this.jdU.jdT.jdS.getString(i.app_delete_tips), false, null), FavoriteVoiceDetailUI.a(this.jdU.jdT.jdS).field_localId, (long) FavoriteVoiceDetailUI.a(this.jdU.jdT.jdS).field_id));
    }
}
