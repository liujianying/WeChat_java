package com.tencent.mm.plugin.luckymoney.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

class LuckyMoneyAutoScrollItem$a extends BaseAdapter {
    final /* synthetic */ LuckyMoneyAutoScrollItem kTN;

    private LuckyMoneyAutoScrollItem$a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem) {
        this.kTN = luckyMoneyAutoScrollItem;
    }

    /* synthetic */ LuckyMoneyAutoScrollItem$a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem, byte b) {
        this(luckyMoneyAutoScrollItem);
    }

    public final int getCount() {
        return 2147483646;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i % 10);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(LuckyMoneyAutoScrollItem.c(this.kTN)).inflate(g.lucky_money_auto_scroll_item, null);
            a aVar2 = new a(this);
            aVar2.kTP = (ImageView) view.findViewById(f.text_number);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kTP.setImageResource(((Integer) LuckyMoneyAutoScrollItem.kTL.get(i % 10)).intValue());
        return view;
    }
}
