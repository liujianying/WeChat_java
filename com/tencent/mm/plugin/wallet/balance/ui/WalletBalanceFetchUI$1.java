package com.tencent.mm.plugin.wallet.balance.ui;

import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.10;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;

class WalletBalanceFetchUI$1 implements OnClickListener {
    final /* synthetic */ WalletBalanceFetchUI pad;

    WalletBalanceFetchUI$1(WalletBalanceFetchUI walletBalanceFetchUI) {
        this.pad = walletBalanceFetchUI;
    }

    public final void onClick(View view) {
        CharSequence charSequence;
        int i;
        this.pad.Wq();
        p.bNp();
        List bPF = p.bNq().bPF();
        p.bNp();
        b bVar = p.bNq().prE;
        CharSequence charSequence2 = "";
        String str = "";
        if (bVar != null) {
            str = bVar.plD;
            charSequence2 = bVar.plC;
            charSequence = str;
        } else {
            Object charSequence3 = str;
        }
        WalletBalanceFetchUI walletBalanceFetchUI = this.pad;
        ActionBarActivity actionBarActivity = this.pad.mController.tml;
        Bankcard a = WalletBalanceFetchUI.a(this.pad);
        1 1 = new 1(this, bPF);
        d dVar = new d(actionBarActivity, 2, true);
        dVar.ofp = new 10(walletBalanceFetchUI, bPF, actionBarActivity);
        dVar.ofq = 1;
        dVar.uKi = true;
        View inflate = LayoutInflater.from(actionBarActivity).inflate(g.wallet_balance_fetch_bankcard_bottomsheet_header, null);
        if (!bi.oW(charSequence2)) {
            ((TextView) inflate.findViewById(f.bfbh_header_title_tv)).setText(charSequence2);
        }
        if (!bi.oW(charSequence3)) {
            ((TextView) inflate.findViewById(f.bfbh_header_desc_tv)).setText(charSequence3);
        }
        dVar.dS(inflate);
        int size = bPF.size();
        if (a != null) {
            int i2 = 0;
            while (true) {
                i = size;
                if (i2 >= bPF.size()) {
                    break;
                }
                size = ((Bankcard) bPF.get(i2)).field_bindSerial.equals(a.field_bindSerial) ? i2 : i;
                i2++;
            }
        } else {
            i = size;
        }
        dVar.uKk = i;
        dVar.bXO();
    }
}
