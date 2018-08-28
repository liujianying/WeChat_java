package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.sortview.c$a;
import com.tencent.mm.ui.base.sortview.d;

class BankCardSelectSortView$1 implements c$a {
    final /* synthetic */ BankCardSelectSortView pzl;

    BankCardSelectSortView$1(BankCardSelectSortView bankCardSelectSortView) {
        this.pzl = bankCardSelectSortView;
    }

    public final View a(d dVar, View view, int i, boolean z, boolean z2) {
        Context context = this.pzl.getContext();
        if (view == null) {
            view = LayoutInflater.from(context).inflate(g.bank_remit_sort_item, null);
            b bVar = new b((byte) 0);
            bVar.mwM = (TextView) view.findViewById(f.catalogTV);
            bVar.muz = (TextView) view.findViewById(f.brsb_item_title);
            bVar.mux = (CdnImageView) view.findViewById(f.brsb_item_icon);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        if (this.pzl.tDL && z) {
            bVar2.mwM.setText(dVar.tDT);
            bVar2.mwM.setVisibility(0);
        } else {
            bVar2.mwM.setVisibility(8);
        }
        a aVar = (a) dVar.data;
        bVar2.muz.setText(aVar.lNT);
        if (bi.oW(aVar.bWP)) {
            bVar2.mux.setImageBitmap(null);
        } else {
            bVar2.mux.setUseSdcardCache(true);
            bVar2.mux.fC(aVar.bWP, aVar.pzm);
        }
        return view;
    }
}
