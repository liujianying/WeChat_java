package com.tencent.mm.plugin.report.b;

import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.b.a.a.i;
import com.tencent.b.a.a.i.1;
import com.tencent.b.a.a.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static i mDM = i.aF(ad.getContext());
    private static int mDN = 2;

    static /* synthetic */ int wz() {
        int i = mDN;
        mDN = i - 1;
        return i;
    }

    public static String brJ() {
        try {
            i.a(new 1());
            x.i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", mDM.tO(), mDM.tP());
            return mDM.tO();
        } catch (Throwable e) {
            x.e("MicroMsg.MidHelper", "QueryMid Error e:%s", bi.i(e));
            return "";
        }
    }

    public static void KE(String str) {
        try {
            i iVar = mDM;
            if (i.mContext != null) {
                i.bvB = System.currentTimeMillis();
                n.bvM = -1;
                try {
                    Editor edit = PreferenceManager.getDefaultSharedPreferences(i.mContext).edit();
                    edit.putLong("__MID_LAST_CHECK_TIME__", i.bvB);
                    edit.commit();
                } catch (Exception e) {
                }
                if (i.mHandler != null) {
                    i.mHandler.post(new 1(iVar, str));
                }
            }
            x.i("MicroMsg.MidHelper", "QueryMid local:%s", mDM.tP());
        } catch (Throwable e2) {
            x.e("MicroMsg.MidHelper", "procReturnData Error e:%s", bi.i(e2));
        }
    }

    public static int n(int i, int i2, String str) {
        if (g.Eg().Dx()) {
            long VE = bi.VE();
            if (i == 3 && bi.a((Long) g.Ei().DT().get(331778, null), 0) >= VE) {
                return 0;
            }
            int i3;
            if (ao.is2G(ad.getContext())) {
                i3 = 1;
            } else if (ao.isWifi(ad.getContext())) {
                i3 = 3;
            } else if (ao.is3G(ad.getContext())) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            String brJ = brJ();
            x.i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", Integer.valueOf(i), brJ);
            f.mDy.h(11402, brJ, Integer.valueOf(i), Integer.valueOf(i3), q.zz(), Integer.valueOf(i2), str, ao.getISPName(ad.getContext()), Integer.valueOf(0), q.getDeviceID(ad.getContext()));
            g.Ei().DT().set(331778, Long.valueOf(259200 + VE));
            return 0;
        }
        x.i("MicroMsg.MidHelper", "checkReportMid acc not ready");
        return -1;
    }
}
