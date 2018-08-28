package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

public final class e extends d {
    private Context mContext = null;

    public e(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.Bc.inflate(g.lucky_money_my_send_record_item, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.gsY = (TextView) view.findViewById(f.lucky_money_my_send_record_title);
            aVar2.hVS = (TextView) view.findViewById(f.lucky_money_my_send_record_desc);
            aVar2.kLE = (TextView) view.findViewById(f.lucky_money_my_send_record_time);
            aVar2.kLF = (TextView) view.findViewById(f.lucky_money_my_send_record_amount);
            aVar2.tH = i;
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        i sm = sm(i);
        aVar.gsY.setText(sm.kQr);
        aVar.kLE.setText(sm.kQs);
        aVar.kLF.setText(this.mContext.getString(a.i.lucky_money_amount_with_unit, new Object[]{com.tencent.mm.wallet_core.ui.e.A(((double) sm.kPR) / 100.0d)}));
        CharSequence string = this.mContext.getString(a.i.lucky_money_send_record_desc, new Object[]{Long.valueOf(sm.kPP), Long.valueOf(sm.kQt)});
        if (sm.status == 5) {
            string = this.mContext.getString(a.i.lucky_money_send_record_status_expired) + " " + string;
        }
        aVar.hVS.setText(string);
        return view;
    }
}
