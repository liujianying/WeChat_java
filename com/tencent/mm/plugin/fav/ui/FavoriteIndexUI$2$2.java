package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.2;
import com.tencent.mm.plugin.report.service.h;

class FavoriteIndexUI$2$2 implements OnClickListener {
    final /* synthetic */ 2 jbi;

    FavoriteIndexUI$2$2(2 2) {
        this.jbi = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FavoriteIndexUI.a(this.jbi.jbh, FavoriteIndexUI.a(this.jbi.jbh).eU(true));
        h.mEJ.h(11125, new Object[]{Integer.valueOf(r0.size()), Integer.valueOf(3)});
        if (FavoriteIndexUI.a(this.jbi.jbh).jbI) {
            FavoriteIndexUI.b(this.jbi.jbh);
        }
    }
}
