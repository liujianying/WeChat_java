package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import com.tencent.mm.plugin.luckymoney.ui.i.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;

final class i$a implements b {
    final /* synthetic */ i kXv;

    i$a(i iVar) {
        this.kXv = iVar;
    }

    public final void a(i$c i_c, Context context) {
        int color = context.getResources().getColor(c.lucky_money_goldstyle_busi_detail_primary_text_color);
        int color2 = context.getResources().getColor(c.lucky_money_goldstyle_busi_detail_sub_text_color);
        int color3 = context.getResources().getColor(c.lucky_money_goldstyle_text_red_color);
        i_c.ido.setBackgroundResource(c.transparent);
        i_c.ido.setPadding(0, context.getResources().getDimensionPixelOffset(d.MiddlePadding), 0, context.getResources().getDimensionPixelOffset(d.MiddlePadding));
        i_c.jYA.setTextColor(color);
        i_c.kLE.setTextColor(color2);
        i_c.kLF.setTextColor(color);
        i_c.kLG.setTextColor(color);
        i_c.kLH.setTextColor(color3);
    }
}
