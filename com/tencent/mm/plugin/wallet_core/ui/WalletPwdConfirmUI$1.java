package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.smtt.utils.TbsLog;

class WalletPwdConfirmUI$1 implements OnClickListener {
    final /* synthetic */ WalletPwdConfirmUI pxf;

    WalletPwdConfirmUI$1(WalletPwdConfirmUI walletPwdConfirmUI) {
        this.pxf = walletPwdConfirmUI;
    }

    public final void onClick(View view) {
        if (this.pxf.bND()) {
            this.pxf.YC();
            this.pxf.showDialog(TbsLog.TBSLOG_CODE_SDK_BASE);
            return;
        }
        this.pxf.finish();
    }
}
