package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoOldUI$11 implements OnLongClickListener {
    final /* synthetic */ WalletOrderInfoOldUI pwD;

    WalletOrderInfoOldUI$11(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.pwD = walletOrderInfoOldUI;
    }

    public final boolean onLongClick(View view) {
        if (view.getId() == f.wallet_order_info_desc || view.getId() == f.wallet_order_info_trans_id) {
            try {
                String str = (String) view.getTag();
                Toast.makeText(this.pwD, i.wallet_order_info_copy_success, 0).show();
                a.a(this.pwD.mController.tml, str, str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletOrderInfoOldUI", e, "", new Object[0]);
            }
        }
        return true;
    }
}
