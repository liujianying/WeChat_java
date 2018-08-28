package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.protocal.c.ff;
import com.tencent.mm.sdk.platformtools.x;

class WalletECardBindCardListUI$1 implements OnItemClickListener {
    final /* synthetic */ WalletECardBindCardListUI pCn;

    WalletECardBindCardListUI$1(WalletECardBindCardListUI walletECardBindCardListUI) {
        this.pCn = walletECardBindCardListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.WalletECardBindCardListUI", "position: %d", new Object[]{Integer.valueOf(i)});
        int itemViewType = adapterView.getAdapter().getItemViewType(i);
        WalletECardBindCardListUI.a(this.pCn).getClass();
        if (itemViewType == 1) {
            x.d("MicroMsg.WalletECardBindCardListUI", "click add item: %s", new Object[]{Integer.valueOf(WalletECardBindCardListUI.b(this.pCn))});
            WalletECardBindCardListUI.c(this.pCn);
            return;
        }
        if (((ff) adapterView.getAdapter().getItem(i)) == null) {
            x.w("MicroMsg.WalletECardBindCardListUI", "empty item");
            return;
        }
        this.pCn.cDL().m(new Object[]{r0});
    }
}
