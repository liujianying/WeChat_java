package com.tencent.mm.plugin.wallet.bind.ui;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

public final class b {
    public static boolean a(Bankcard bankcard) {
        if (bankcard == null) {
            return false;
        }
        g.Ek();
        String str = (String) g.Ei().DT().get(196659, null);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            return true;
        }
        for (String str2 : split) {
            if (str2 != null && str2.equals(bankcard.field_bankcardType)) {
                return false;
            }
        }
        return true;
    }
}
