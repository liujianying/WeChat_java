package com.tencent.mm.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.storage.bl;

public final class y {
    public static x if(String str) {
        return new x("@black.android", null, str, null, true, true);
    }

    public static x ig(String str) {
        bl Hg = ((i) g.l(i.class)).FZ().Hg("@t.qq.com");
        if (Hg == null) {
            return null;
        }
        return new x("@t.qq.com", null, str, null, Hg.isEnable(), Hg.cmV());
    }

    public static x P(String str, String str2) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        bl Hg = ((i) g.l(i.class)).FZ().Hg(str);
        if (Hg != null) {
            if (Hg.tcs == 1) {
                String str3 = "@domain.android";
                String str4 = Hg.name;
                String Zk = Hg.tcr.Zk("");
                String str5 = "";
                if (Zk != null) {
                    str5 = str5 + Zk.replace("@", "");
                }
                if (str2 != null) {
                    str5 = str5 + str2;
                }
                return new x(str3, str4, str5, Hg.tcr.Zk(""), Hg.isEnable(), true);
            }
        }
        return null;
    }
}
