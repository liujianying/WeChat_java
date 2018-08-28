package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.a;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.b;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoOldUI$a$1 implements OnItemClickListener {
    final /* synthetic */ a pwE;

    WalletOrderInfoOldUI$a$1(a aVar) {
        this.pwE = aVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Promotions zt = this.pwE.pwD.pwx.zt(i);
        if (bi.oW(zt.lNW)) {
            String fx = this.pwE.pwD.fx(zt.pji);
            if ("-1".equals(fx) || "3".equals(fx)) {
                h.mEJ.h(13472, new Object[]{WalletOrderInfoOldUI.b(this.pwE.pwD), Integer.valueOf(zt.ppT), Integer.valueOf(1), Long.valueOf(zt.pji), Long.valueOf(zt.poF)});
                h.mEJ.h(13033, new Object[]{Integer.valueOf(2), "", zt.url, zt.name, ""});
                if (!bi.oW(zt.ppW) && !bi.oW(zt.ppX)) {
                    x.i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", new Object[]{zt.ppW, zt.ppX});
                    qu quVar = new qu();
                    quVar.cbq.userName = zt.ppW;
                    quVar.cbq.cbs = bi.aG(zt.ppX, "");
                    quVar.cbq.scene = 1060;
                    quVar.cbq.bGG = this.pwE.pwD.lJJ;
                    quVar.cbq.cbt = 0;
                    com.tencent.mm.sdk.b.a.sFg.m(quVar);
                    h.mEJ.h(14118, new Object[]{this.pwE.pwD.lJJ, this.pwE.pwD.bNs(), Integer.valueOf(2)});
                    WalletOrderInfoOldUI.a(this.pwE.pwD, new d(this.pwE.pwD, zt.pji, zt.ppU, zt.poD, zt.poE, this.pwE.pwD.bNs(), WalletOrderInfoOldUI.b(this.pwE.pwD), zt.poF));
                    WalletOrderInfoOldUI.a(this.pwE.pwD, true);
                    return;
                } else if (zt.ppT == 1) {
                    this.pwE.pwD.a(zt);
                    return;
                } else if (zt.ppT != 2 || bi.oW(zt.url)) {
                    x.e("MicroMsg.WalletOrderInfoOldUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                    return;
                } else if (WalletOrderInfoOldUI.c(this.pwE.pwD).containsKey(zt.pji)) {
                    x.i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", new Object[]{((b) WalletOrderInfoOldUI.c(this.pwE.pwD).get(zt.pji)).url});
                    this.pwE.pwD.Ps(r0.url);
                    return;
                } else {
                    this.pwE.pwD.ptj = zt.url;
                    this.pwE.pwD.a(zt.url, new d(this.pwE.pwD, zt.pji, zt.ppU, zt.poD, zt.poE, this.pwE.pwD.bNs(), WalletOrderInfoOldUI.b(this.pwE.pwD), zt.poF));
                    return;
                }
            }
            return;
        }
        if (this.pwE.pwD.pvK.contains(zt.lNW)) {
            this.pwE.pwD.pvK.remove(zt.lNW);
        } else {
            this.pwE.pwD.pvK.add(zt.lNW);
        }
        this.pwE.pwD.pwu.notifyDataSetChanged();
    }
}
