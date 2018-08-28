package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.mm.protocal.c.avq;

public final class b {
    public static String avq() {
        avq Qa = com.tencent.mm.an.b.Qa();
        if (Qa == null || Qa.rsp == null || Qa.rYj != 0 || !com.tencent.mm.an.b.PY()) {
            return null;
        }
        return Qa.rsp;
    }
}
