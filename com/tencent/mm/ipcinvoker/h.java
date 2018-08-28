package com.tencent.mm.ipcinvoker;

import java.util.HashMap;
import java.util.Map;

public class h {
    private static volatile h dmF;
    Map<String, BaseIPCService> dmG = new HashMap();

    private h() {
    }

    public static h Ct() {
        if (dmF == null) {
            synchronized (h.class) {
                if (dmF == null) {
                    dmF = new h();
                }
            }
        }
        return dmF;
    }

    public final BaseIPCService fG(String str) {
        return (BaseIPCService) this.dmG.get(str);
    }
}
