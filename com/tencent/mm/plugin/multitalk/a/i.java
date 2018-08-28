package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.List;

public final class i {
    public static final float[][] lua;

    static {
        r0 = new float[6][];
        lua = r0;
        r0[0] = null;
        lua[1] = new float[]{0.5f, 0.5f};
        lua[2] = new float[]{0.0f, 0.5f, 1.0f, 0.5f};
        lua[3] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.5f, 1.0f};
        lua[4] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        lua[5] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 2.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 2.0f, 1.0f, 0.0f, 2.0f, 1.0f, 2.0f, 2.0f, 2.0f};
    }

    public static String h(MultiTalkGroup multiTalkGroup) {
        if (multiTalkGroup == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        List<MultiTalkGroupMember> list = multiTalkGroup.vgq;
        stringBuffer.append("->[usernamelist]");
        if (list != null) {
            for (MultiTalkGroupMember multiTalkGroupMember : list) {
                stringBuffer.append(multiTalkGroupMember.vgr + "|");
                stringBuffer.append(multiTalkGroupMember.status + ", ");
            }
        }
        stringBuffer.append(" ->createname:" + multiTalkGroup.vgp);
        stringBuffer.append(" ->talkgroupId:" + multiTalkGroup.vgm);
        stringBuffer.append(" ->wxGroupId:" + multiTalkGroup.vgo);
        return stringBuffer.toString();
    }

    public static boolean a(MultiTalkGroup multiTalkGroup, MultiTalkGroup multiTalkGroup2) {
        if (multiTalkGroup == null || multiTalkGroup2 == null) {
            return false;
        }
        if (!bi.oW(multiTalkGroup.vgm) && !bi.oW(multiTalkGroup2.vgm) && multiTalkGroup.vgm.equals(multiTalkGroup2.vgm)) {
            return true;
        }
        if (bi.oW(multiTalkGroup.vgn) || bi.oW(multiTalkGroup2.vgn) || !multiTalkGroup.vgn.equals(multiTalkGroup2.vgn)) {
            return false;
        }
        return true;
    }

    public static boolean i(MultiTalkGroup multiTalkGroup) {
        if (multiTalkGroup == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.vgq) {
            boolean z3;
            if (multiTalkGroupMember.vgr.equals(q.GF())) {
                if (multiTalkGroupMember.status == 10) {
                    if (z) {
                        return true;
                    }
                    z2 = true;
                }
                z3 = z;
            } else {
                if (multiTalkGroupMember.status == 10) {
                    if (z2) {
                        return true;
                    }
                    z3 = true;
                }
                z3 = z;
            }
            z = z3;
        }
        return false;
    }

    public static boolean j(MultiTalkGroup multiTalkGroup) {
        int i = 0;
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.vgq) {
            int i2;
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i > 1) {
            return true;
        }
        return false;
    }

    public static boolean c(e eVar) {
        if (eVar == e.lvL || eVar == e.lvM || eVar == e.lvJ) {
            return true;
        }
        return false;
    }

    public static boolean k(MultiTalkGroup multiTalkGroup) {
        return multiTalkGroup.vgp.equals(q.GF());
    }

    public static String l(MultiTalkGroup multiTalkGroup) {
        if (multiTalkGroup == null) {
            return "";
        }
        String str = multiTalkGroup.vgm;
        if (bi.oW(str)) {
            str = multiTalkGroup.vgn;
        }
        return bi.aG(str, "");
    }

    public static String bgC() {
        return l(o.bgN().ltt);
    }

    public static String m(MultiTalkGroup multiTalkGroup) {
        String str = null;
        int i = 0;
        while (i < multiTalkGroup.vgq.size()) {
            String str2;
            if (((MultiTalkGroupMember) multiTalkGroup.vgq.get(i)).vgr.equals(q.GF())) {
                str2 = ((MultiTalkGroupMember) multiTalkGroup.vgq.get(i)).vgs;
            } else {
                str2 = str;
            }
            i++;
            str = str2;
        }
        return str;
    }

    public static String bgD() {
        return m(o.bgN().ltt);
    }

    public static boolean bgE() {
        return false;
    }

    public static int v(Context context, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("state");
            if (stringExtra != null) {
                if (stringExtra.equals("IDLE")) {
                    return 0;
                }
                if (stringExtra.equals("RINGING")) {
                    return 1;
                }
                if (stringExtra.equals("OFFHOOK")) {
                    return 2;
                }
            }
        }
        return ((TelephonyManager) context.getSystemService("phone")).getCallState();
    }

    public static boolean tj(int i) {
        return i == 2 || i == 3;
    }

    public static boolean tk(int i) {
        return i == 1 || i == 3;
    }

    public static a bgF() {
        if (ao.isWifi(ad.getContext())) {
            return a.lub;
        }
        if (ao.is4G(ad.getContext())) {
            return a.luc;
        }
        if (ao.is3G(ad.getContext()) || ao.is2G(ad.getContext())) {
            return a.lud;
        }
        return a.lue;
    }

    public static boolean bgG() {
        au.HU();
        int intValue = ((Integer) c.DT().get(a.sZI, Integer.valueOf(-1))).intValue();
        au.HU();
        long longValue = ((Long) c.DT().get(a.sZJ, Long.valueOf(-1))).longValue();
        if (intValue <= 0 || longValue <= 0) {
            au.HU();
            c.DT().a(a.sZI, Integer.valueOf(-1));
            au.HU();
            c.DT().a(a.sZJ, Long.valueOf(-1));
            return true;
        }
        x.i("MicroMsg.MultiTalkUtil", "checkMultiTalkAvailable, disableTime: %s, disableTimestamp: %s", new Object[]{Integer.valueOf(intValue), Long.valueOf(longValue)});
        if (bi.bI(longValue) <= ((long) (intValue * 1000))) {
            return false;
        }
        au.HU();
        c.DT().a(a.sZI, Integer.valueOf(-1));
        au.HU();
        c.DT().a(a.sZJ, Long.valueOf(-1));
        return true;
    }
}
