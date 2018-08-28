package com.tencent.mm.plugin.base.model;

import android.os.Process;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static String wO(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String an = bi.an(ad.getContext(), Process.myPid());
        x.i("MicroMsg.ShortcutUtil", "process name: %s", new Object[]{an});
        if (!str.startsWith("shortcut_") || str.length() <= 9) {
            return str;
        }
        an = str.substring(9);
        if (an == null || an.length() <= 0) {
            return str;
        }
        return b.bT(new String(b.wN(an)), q.zy());
    }

    public static String bU(String str, String str2) {
        return g.u((g.u(str.getBytes()) + b.bT(str2, str)).getBytes());
    }

    public static String wP(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String an = bi.an(ad.getContext(), Process.myPid());
        x.i("MicroMsg.ShortcutUtil", "process name: %s", new Object[]{an});
        an = b.bT(str, q.zy());
        if (bi.oW(an)) {
            return null;
        }
        return "shortcut_" + b.aa(an.getBytes());
    }
}
