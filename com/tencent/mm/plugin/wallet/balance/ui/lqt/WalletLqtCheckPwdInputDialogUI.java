package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(3)
public class WalletLqtCheckPwdInputDialogUI extends WalletBaseUI {
    private String cZH = "";
    private String oZC = "";
    private o oZD;

    public void onCreate(Bundle bundle) {
        int i = 1;
        super.onCreate(bundle);
        ux(4);
        this.cZH = getIntent().getStringExtra("lqt_fetch_pwd_title");
        this.oZC = getIntent().getStringExtra("lqt_fetch_pwd_money");
        x.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: money : %s, title : %s", new Object[]{bi.oV(this.oZC), bi.oV(this.cZH)});
        if (bi.oW(this.cZH) || bi.oW(this.oZC)) {
            i = 0;
        }
        if (i == 0) {
            h.a(this.mController.tml, i.wallet_order_info_err, 0, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletLqtCheckPwdInputDialogUI.this.finish();
                }
            });
            return;
        }
        getWindow().setBackgroundDrawableResource(c.transparent);
        showDialog();
    }

    private void showDialog() {
        if (this.oZD != null && this.oZD.isShowing()) {
            this.oZD.dismiss();
        }
        if (this.oZD == null) {
            this.oZC = e.B(bi.getDouble(this.oZC, 0.0d));
            this.oZD = o.a(this, this.cZH, this.oZC, "", new 2(this), new 3(this), new o.a() {
                public final void blf() {
                    x.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: pwd cancel.finish");
                    WalletLqtCheckPwdInputDialogUI.this.oZD.dismiss();
                    WalletLqtCheckPwdInputDialogUI.this.finish();
                }
            });
            return;
        }
        this.oZD.bqn();
        this.oZD.show();
    }

    public final void rj(int i) {
        if (i == 0) {
            finish();
        } else if (i == 1) {
            showDialog();
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
