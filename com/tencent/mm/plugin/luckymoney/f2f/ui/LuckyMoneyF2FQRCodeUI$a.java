package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;

class LuckyMoneyF2FQRCodeUI$a extends BaseAdapter {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI kOv;

    private LuckyMoneyF2FQRCodeUI$a(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.kOv = luckyMoneyF2FQRCodeUI;
    }

    /* synthetic */ LuckyMoneyF2FQRCodeUI$a(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI, byte b) {
        this(luckyMoneyF2FQRCodeUI);
    }

    public final int getCount() {
        return LuckyMoneyF2FQRCodeUI.a(this.kOv).size();
    }

    private String jl(int i) {
        return (String) LuckyMoneyF2FQRCodeUI.a(this.kOv).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.kOv).inflate(g.lucky_money_f2f_recv_list_item, null);
            ImageView imageView = (ImageView) view.findViewById(f.lucky_money_f2f_recv_grid_avatar);
            ImageView imageView2 = (ImageView) view.findViewById(f.lucky_money_f2f_most_lucky_icon);
            a aVar2 = new a(this);
            aVar2.eDn = imageView;
            aVar2.kOE = imageView2;
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        String str = (String) LuckyMoneyF2FQRCodeUI.b(this.kOv).get(jl(i));
        o.a(aVar.eDn, null, str);
        if (bi.oW(LuckyMoneyF2FQRCodeUI.C(this.kOv)) || !LuckyMoneyF2FQRCodeUI.C(this.kOv).equals(str)) {
            aVar.kOE.setVisibility(4);
        } else {
            aVar.kOE.setVisibility(0);
        }
        return view;
    }
}
