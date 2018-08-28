package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.fg;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

class BankRemitSortView$1 implements a {
    final /* synthetic */ BankRemitSortView mwL;

    BankRemitSortView$1(BankRemitSortView bankRemitSortView) {
        this.mwL = bankRemitSortView;
    }

    public final View a(d dVar, View view, int i, boolean z, boolean z2) {
        Context context = this.mwL.getContext();
        if (view == null) {
            view = LayoutInflater.from(context).inflate(g.bank_remit_sort_item, null);
            BankRemitSortView.a aVar = new BankRemitSortView.a(this.mwL, (byte) 0);
            aVar.mwM = (TextView) view.findViewById(f.catalogTV);
            aVar.muz = (TextView) view.findViewById(f.brsb_item_title);
            aVar.mux = (CdnImageView) view.findViewById(f.brsb_item_icon);
            view.setTag(aVar);
        }
        BankRemitSortView.a aVar2 = (BankRemitSortView.a) view.getTag();
        fg fgVar = (fg) dVar.data;
        if (fgVar != null) {
            if (this.mwL.tDL && z) {
                if (dVar.tDT.equals("☆")) {
                    aVar2.mwM.setText(i.bank_remit_select_bank_freq_bank_title);
                } else {
                    aVar2.mwM.setText(dVar.tDT);
                }
                aVar2.mwM.setVisibility(0);
            } else {
                aVar2.mwM.setVisibility(8);
            }
            aVar2.mux.setUseSdcardCache(true);
            aVar2.mux.fC(fgVar.mug, b.JC(fgVar.mug));
            aVar2.muz.setText(fgVar.knE);
        } else {
            x.w("MicroMsg.BankcardSortView", "elem is null: %s", new Object[]{Integer.valueOf(i)});
        }
        return view;
    }
}
