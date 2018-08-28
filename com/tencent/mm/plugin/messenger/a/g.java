package com.tencent.mm.plugin.messenger.a;

import com.tencent.mm.pluginsdk.a.b;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    public static d lbL;

    public static d bcT() {
        if (lbL == null) {
            lbL = new b();
        }
        if (lbL instanceof b) {
            x.w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
        }
        return lbL;
    }
}
