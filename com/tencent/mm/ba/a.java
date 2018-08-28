package com.tencent.mm.ba;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public enum a {
    ;

    private a(String str) {
    }

    public static boolean Us() {
        return !bi.oW(Ut());
    }

    public static String Ut() {
        g.Ek();
        x.i("MicroMsg.WebviewKeepManager", "getLastPageUrl : %s", new Object[]{(String) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sVL, String.valueOf(""))});
        return (String) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sVL, String.valueOf(""));
    }

    public static String Uu() {
        g.Ek();
        x.i("MicroMsg.WebviewKeepManager", "getLastPageTitle : %s", new Object[]{(String) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sVN, String.valueOf(""))});
        return (String) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sVN, String.valueOf(""));
    }

    public static void s(String str, String str2, String str3) {
        g.Ek();
        g.Ei().DT().a(com.tencent.mm.storage.aa.a.sVL, str);
        g.Ek();
        g.Ei().DT().a(com.tencent.mm.storage.aa.a.sVN, str2);
        g.Ek();
        g.Ei().DT().a(com.tencent.mm.storage.aa.a.sVM, str3);
    }
}
