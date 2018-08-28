package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.FavCleanUI.5;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.fav.ui.widget.a;
import com.tencent.mm.plugin.report.service.h;
import java.util.List;

class FavCleanUI$5$1 implements OnClickListener {
    final /* synthetic */ 5 iYB;

    FavCleanUI$5$1(5 5) {
        this.iYB = 5;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        long aMH = FavCleanUI.e(this.iYB.iYA).aMH();
        List eU = FavCleanUI.e(this.iYB.iYA).eU(true);
        a f = FavCleanUI.f(this.iYB.iYA);
        f.jfd += aMH;
        b.dh(b.aKT() - aMH);
        if (!eU.isEmpty()) {
            h.mEJ.h(14110, new Object[]{Integer.valueOf(FavCleanUI.g(this.iYB.iYA)), Integer.valueOf(eU.size()), Integer.valueOf((int) ((((double) aMH) * 1.0d) / 1024.0d))});
            g.Em().H(new 1(this, eU, com.tencent.mm.ui.base.h.a(this.iYB.iYA.mController.tml, this.iYB.iYA.getString(i.favorite_delete_tips), false, null)));
            h.mEJ.h(11125, new Object[]{Integer.valueOf(eU.size()), Integer.valueOf(3)});
        }
    }
}
