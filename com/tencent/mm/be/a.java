package com.tencent.mm.be;

import android.content.Context;
import com.tencent.mm.az.d;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.platformtools.bi;

public final class a {
    public static boolean cbf() {
        Object value = g.AT().getValue("EnableStrangerChat");
        String str = "1";
        if (bi.oW(value)) {
            value = "0";
        }
        return str.equals(value);
    }

    public static void eF(Context context) {
        if (cbf() || d.SG().axd() <= 0) {
            com.tencent.mm.bg.d.A(context, "nearby", ".ui.NearbyFriendsUI");
        } else {
            com.tencent.mm.bg.d.A(context, "nearby", ".ui.NearbyFriendShowSayHiUI");
        }
    }
}
