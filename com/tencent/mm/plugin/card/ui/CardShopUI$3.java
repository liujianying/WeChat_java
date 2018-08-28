package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.am;

class CardShopUI$3 implements OnCancelListener {
    final /* synthetic */ CardShopUI hGu;

    CardShopUI$3(CardShopUI cardShopUI) {
        this.hGu = cardShopUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        m axl = am.axl();
        axl.a(CardShopUI.d(this.hGu), this.hGu);
        if (axl.huR != null) {
            g.Eh().dpP.c(axl.huR);
        }
    }
}
