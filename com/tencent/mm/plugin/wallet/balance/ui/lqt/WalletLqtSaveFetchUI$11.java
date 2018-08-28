package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.awx;
import com.tencent.mm.protocal.c.sj;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;

class WalletLqtSaveFetchUI$11 implements OnClickListener {
    final /* synthetic */ WalletLqtSaveFetchUI pcc;
    final /* synthetic */ awx pci;

    WalletLqtSaveFetchUI$11(WalletLqtSaveFetchUI walletLqtSaveFetchUI, awx awx) {
        this.pcc = walletLqtSaveFetchUI;
        this.pci = awx;
    }

    public final void onClick(View view) {
        View linearLayout = new LinearLayout(this.pcc);
        linearLayout.setOrientation(1);
        Iterator it = this.pci.rZY.iterator();
        while (it.hasNext()) {
            sj sjVar = (sj) it.next();
            if (!(sjVar == null || sjVar.title == null)) {
                LinearLayout linearLayout2 = (LinearLayout) View.inflate(this.pcc, g.wallet_lqt_fetch_info, null);
                ((TextView) linearLayout2.findViewById(f.title)).setText(sjVar.title);
                ((TextView) linearLayout2.findViewById(f.desc)).setText(sjVar.desc);
                linearLayout.addView(linearLayout2);
            }
        }
        h.a(this.pcc.mController.tml, "", this.pcc.getString(i.wallet_i_know_it), linearLayout, new 1(this));
    }
}
