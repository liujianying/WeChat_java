package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    private static String TAG = "MicroMsg.SoterUtil";

    public static void bFi() {
        x.i(TAG, "alvinluo dynamic config support soter: %b", new Object[]{Boolean.valueOf(bi.getInt(((a) g.Ee().l(a.class)).AT().getValue("SoterEntry"), 0) == 1)});
        if (bi.getInt(((a) g.Ee().l(a.class)).AT().getValue("SoterEntry"), 0) == 1) {
            x.d(TAG, "alvinluo set all soter support flag to true");
            q.deS.cbY = true;
            q.deQ.deZ = 1;
            q.deQ.dfa = 1;
            x.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", new Object[]{Boolean.valueOf(q.deS.cbY), Integer.valueOf(q.deQ.deZ), Integer.valueOf(q.deQ.dfa)});
        }
    }

    public static String bFj() {
        try {
            String u = com.tencent.mm.a.g.u(com.tencent.mm.model.q.GI().getBytes());
            if (u != null) {
                return u.substring(0, 8);
            }
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "alvinluo get md5 exception", new Object[0]);
        }
        return "";
    }

    public static String bFk() {
        return "WechatAuthKeyPay&" + com.tencent.mm.model.q.GI();
    }

    public static boolean bFl() {
        if (q.deS.cbY) {
            return com.tencent.d.b.a.cFN();
        }
        x.i(TAG, "hy: dynamic config is not support soter");
        return false;
    }
}
