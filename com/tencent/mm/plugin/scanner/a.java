package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.k.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public final class a {
    public static boolean aB(int i, String str) {
        if (i != 22 || bi.oW(str)) {
            return false;
        }
        String string;
        Set brW;
        if (ad.cic() || (Looper.myLooper() == Looper.getMainLooper() && !g.fF("com.tencent.mm"))) {
            brW = brW();
        } else {
            Set hashSet = new HashSet();
            Bundle bundle = (Bundle) f.a("com.tencent.mm", null, a.class);
            String str2 = "";
            if (bundle != null) {
                string = bundle.getString("wxCodePrefix", "");
            } else {
                string = str2;
            }
            String[] split = string.split("|");
            for (int i2 = 0; i2 < split.length; i2++) {
                if (!bi.oW(split[i2])) {
                    hashSet.add(split[i2]);
                }
            }
            brW = hashSet;
        }
        for (String string2 : brW) {
            if (str.startsWith(string2)) {
                return true;
            }
        }
        return false;
    }

    private static Set<String> brW() {
        Set<String> hashSet = new HashSet();
        hashSet.add("k");
        hashSet.add("l");
        if (ad.cic()) {
            String G;
            String str = "";
            c AU = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.zero.b.a.class)).AU();
            if (AU != null) {
                G = AU.G("ScanCode", "weAppCodePrefix");
            } else {
                G = str;
            }
            x.v("MicroMsg.QRCodeLogic", "getWxCodePrefix(%s)", new Object[]{G});
            if (!bi.oW(G)) {
                String[] split = G.split("|");
                for (int i = 0; i < split.length; i++) {
                    if (!bi.oW(split[i])) {
                        hashSet.add(split[i]);
                    }
                }
            }
        }
        return hashSet;
    }
}
