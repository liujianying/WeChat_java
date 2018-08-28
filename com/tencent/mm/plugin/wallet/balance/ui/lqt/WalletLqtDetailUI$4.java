package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.sj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.e;

class WalletLqtDetailUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ WalletLqtDetailUI pbs;

    WalletLqtDetailUI$4(WalletLqtDetailUI walletLqtDetailUI) {
        this.pbs = walletLqtDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.pbs, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new n$d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                if (menuItem.getItemId() == -1 && !WalletLqtDetailUI.c(WalletLqtDetailUI$4.this.pbs).sfN) {
                    String string;
                    if (WalletLqtDetailUI.c(WalletLqtDetailUI$4.this.pbs).rtK == 0) {
                        string = WalletLqtDetailUI$4.this.pbs.getString(i.wallet_lqt_close_alert_wording);
                    } else {
                        string = WalletLqtDetailUI$4.this.pbs.getString(i.wallet_lqb_close_alert_wording);
                    }
                    h.a(WalletLqtDetailUI$4.this.pbs, string, "", WalletLqtDetailUI$4.this.pbs.getString(i.close_btn), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            WalletLqtDetailUI.g(WalletLqtDetailUI$4.this.pbs);
                            WalletLqtDetailUI$4.this.pbs.startActivityForResult(new Intent(WalletLqtDetailUI$4.this.pbs, WalletLqtSimpleCheckPwdUI.class), 123);
                        }
                    });
                } else if (WalletLqtDetailUI.c(WalletLqtDetailUI$4.this.pbs).sfG != null && WalletLqtDetailUI.c(WalletLqtDetailUI$4.this.pbs).sfG.size() > 0 && menuItem.getItemId() < WalletLqtDetailUI.c(WalletLqtDetailUI$4.this.pbs).sfG.size()) {
                    e.l(WalletLqtDetailUI$4.this.pbs, ((sj) WalletLqtDetailUI.c(WalletLqtDetailUI$4.this.pbs).sfG.get(menuItem.getItemId())).rvK, false);
                }
            }
        };
        dVar.bXO();
        return false;
    }
}
