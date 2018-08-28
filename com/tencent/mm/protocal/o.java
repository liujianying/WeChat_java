package com.tencent.mm.protocal;

import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    static /* synthetic */ byte[] UA(String str) {
        Object obj = new byte[16];
        System.arraycopy(str.getBytes(), 0, obj, 0, 15);
        obj[15] = null;
        x.d("MicroMsg.MMDirectSend", "new direct send: key=%s", new Object[]{bi.bB(g.v(obj))});
        return g.v(obj);
    }
}
