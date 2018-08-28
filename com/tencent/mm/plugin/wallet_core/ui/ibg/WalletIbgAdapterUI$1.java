package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.model.u$a;

class WalletIbgAdapterUI$1 implements OnClickListener {
    final /* synthetic */ WalletIbgAdapterUI pzd;

    WalletIbgAdapterUI$1(WalletIbgAdapterUI walletIbgAdapterUI) {
        this.pzd = walletIbgAdapterUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        u$a.eQ(this.pzd);
        Toast.makeText(this.pzd, this.pzd.getString(i.webview_tbs_download_start), 1).show();
        this.pzd.finish();
    }
}
