package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.model.bv.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Map;

public final class aa {
    static ArrayList<j> iOD = null;
    private static aa prc = null;
    a hTD = new 1(this);

    static /* synthetic */ boolean a(aa aaVar, int i, Map map) {
        if (map == null) {
            x.w("MicroMsg.WalletPushNotifyManager", "hy: log is null. handle failed");
            return true;
        } else if (i < 0) {
            x.w("MicroMsg.WalletPushNotifyManager", "hy: paymsgtype error. maybe not found in xml");
            return true;
        } else if (i != 12) {
            return false;
        } else {
            int i2 = bi.getInt((String) map.get(".sysmsg.paymsg.avail_balance"), -1);
            long j = bi.getLong((String) map.get(".sysmsg.paymsg.balance_version"), -1);
            String[] strArr = new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"};
            e.a(strArr, new 3(aaVar, bi.getLong((String) map.get(".sysmsg.paymsg.time_out"), 7200), j, i2, i, map));
            return true;
        }
    }

    private aa() {
    }

    public static aa bPg() {
        if (prc == null) {
            prc = new aa();
        }
        return prc;
    }

    public static boolean a(j jVar) {
        if (jVar == null) {
            x.e("MicroMsg.WalletPushNotifyManager", "hy: the callback for registering is null. register failed");
            return false;
        }
        if (iOD == null) {
            iOD = new ArrayList();
        }
        iOD.add(jVar);
        return true;
    }

    public static boolean b(j jVar) {
        if (iOD == null) {
            x.e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
            return false;
        }
        iOD.remove(jVar);
        return true;
    }
}
