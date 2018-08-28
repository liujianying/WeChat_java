package com.tencent.mm.plugin.honey_pay.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.protocal.c.aze;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.WalletTextView;

class HoneyPayCardManagerUI$a extends BaseAdapter {
    final /* synthetic */ HoneyPayCardManagerUI kkT;

    private HoneyPayCardManagerUI$a(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        this.kkT = honeyPayCardManagerUI;
    }

    /* synthetic */ HoneyPayCardManagerUI$a(HoneyPayCardManagerUI honeyPayCardManagerUI, byte b) {
        this(honeyPayCardManagerUI);
    }

    public final int getCount() {
        return HoneyPayCardManagerUI.i(this.kkT).size();
    }

    private aze ri(int i) {
        return (aze) HoneyPayCardManagerUI.i(this.kkT).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final boolean isEnabled(int i) {
        return !bi.oW(ri(i).url);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.kkT.mController.tml).inflate(g.honey_pay_card_setting_item_layout, viewGroup, false);
            b bVar = new b(this.kkT, (byte) 0);
            bVar.hWO = (TextView) view.findViewById(f.hpci_date_tv);
            bVar.kkX = (WalletTextView) view.findViewById(f.hpci_amt_tv);
            bVar.kkX.setPrefix(v.cDm());
            view.setTag(bVar);
        }
        aze ri = ri(i);
        b bVar2 = (b) view.getTag();
        bVar2.hWO.setText(ri.mPv);
        bVar2.kkX.setText(c.dK(ri.sbV));
        return view;
    }
}
