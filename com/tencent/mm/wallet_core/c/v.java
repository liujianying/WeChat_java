package com.tencent.mm.wallet_core.c;

import android.content.Context;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.g;

public final class v {
    public static int cDl() {
        if (q.GS()) {
            return a$i.wallet_power_by_payu;
        }
        return a$i.wallet_power_by_tenpay;
    }

    public static String cDm() {
        if (q.GS()) {
            return "R";
        }
        if (q.GT()) {
            return "HK$";
        }
        return "¥";
    }

    public static int cDn() {
        if (q.GS()) {
            return g.wallet_payu_date_illustration_dialog;
        }
        return g.wallet_date_illustration_dialog;
    }

    public static int cDo() {
        if (q.GS()) {
            return a$i.wallet_card_date_illustraction_payu;
        }
        return a$i.wallet_card_date_illustraction;
    }

    public static int cDp() {
        if (q.GS()) {
            return g.cvv_payu_dialog;
        }
        return g.cvv_dialog;
    }

    public static String hg(Context context) {
        if (q.GS()) {
            return context.getString(a$i.wallet_pwd_dialog_titile_payu);
        }
        return context.getString(a$i.wallet_pwd_dialog_titile);
    }
}
