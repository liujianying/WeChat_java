package com.tencent.mm.ipcinvoker;

import com.tencent.mm.ipcinvoker.h.b;

public final class g {
    public static void fD(final String str) {
        if (!fF(str)) {
            l.post(new Runnable() {
                public final void run() {
                    b Cq = b.Cq();
                    String str = str;
                    if (e.fC(str)) {
                        b.i("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", str);
                        return;
                    }
                    Cq.fA(str);
                }
            });
        }
    }

    public static void fE(String str) {
        if (!fF(str)) {
            l.post(new 4(str));
        }
    }

    public static boolean fF(String str) {
        return (e.fC(str) || b.Cq().dmm.get(str) == null) ? false : true;
    }
}
