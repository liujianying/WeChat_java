package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;
import java.util.List;

public final class f {
    public static void a(Context context, List<Bankcard> list, Bankcard bankcard, String str, String str2, d dVar) {
        com.tencent.mm.ui.widget.a.d dVar2 = new com.tencent.mm.ui.widget.a.d(context, 2, true);
        dVar2.ofp = new 1(list, context, new HashMap(), dVar2);
        dVar2.ofq = dVar;
        dVar2.uKi = true;
        View inflate = LayoutInflater.from(context).inflate(g.wallet_balance_fetch_bankcard_bottomsheet_header, null);
        if (!bi.oW(str)) {
            ((TextView) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.bfbh_header_title_tv)).setText(str);
        }
        if (!bi.oW(str2)) {
            ((TextView) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.bfbh_header_desc_tv)).setText(str2);
        }
        dVar2.dS(inflate);
        if (bankcard != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                if (((Bankcard) list.get(i2)).field_bindSerial.equals(bankcard.field_bindSerial)) {
                    dVar2.uKk = i2;
                }
                i = i2 + 1;
            }
        }
        dVar2.bXO();
    }
}
