package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.wallet_core.ui.e;

public final class c extends d {
    private Context mContext;

    public c(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.Bc.inflate(g.lucky_money_my_receive_record_item, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.jYA = (TextView) view.findViewById(f.lucky_money_my_record_nickname);
            aVar2.kLE = (TextView) view.findViewById(f.lucky_money_my_record_time);
            aVar2.kLF = (TextView) view.findViewById(f.lucky_money_my_record_amount);
            aVar2.kLQ = (ImageView) view.findViewById(f.lucky_money_my_record_group_icon);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        i sm = sm(i);
        o.a(this.mContext, aVar.jYA, sm.kQo);
        aVar.kLE.setText(sm.kQq);
        aVar.kLF.setText(this.mContext.getString(a$i.lucky_money_receive_amount, new Object[]{e.A(((double) sm.kQp) / 100.0d)}));
        if (sm.kPI == 1) {
            aVar.kLQ.setImageResource(a.e.lucky_money_group_icon);
            aVar.kLQ.setVisibility(0);
        } else if (sm.kPI == 2) {
            aVar.kLQ.setImageResource(a.e.lucky_money_f2f_record_icon);
            aVar.kLQ.setVisibility(0);
        } else {
            aVar.kLQ.setVisibility(8);
        }
        return view;
    }
}
