package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static boolean TW(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
            return false;
        }
        com.tencent.mm.storage.x DT = g.Ei().DT();
        if (DT == null) {
            x.e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
            return false;
        }
        a aVar = new a((byte) 0);
        aVar.KH((String) DT.get(69121, null));
        if (!aVar.mSx.contains(str)) {
            aVar.mSx.add(str);
        }
        DT.set(69121, aVar.cfl());
        return true;
    }

    public static boolean TX(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
            return false;
        }
        com.tencent.mm.storage.x DT = g.Ei().DT();
        if (DT == null) {
            x.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
            return false;
        }
        a aVar = new a((byte) 0);
        aVar.KH((String) DT.get(69121, null));
        if (aVar.mSx.contains(str)) {
            aVar.mSx.remove(str);
        }
        DT.set(69121, aVar.cfl());
        return true;
    }
}
