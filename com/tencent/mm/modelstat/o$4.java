package com.tencent.mm.modelstat;

import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class o$4 implements a {
    o$4() {
    }

    public final boolean vD() {
        try {
            o.Sf();
            if (o.Sg() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN || o.Sg() <= 1000) {
                o.iy(o.Sg());
            } else {
                o.ix(o.Sg());
            }
        } catch (Throwable e) {
            x.e("MicroMsg.NetTypeReporter", "run :%s", bi.i(e));
        }
        return false;
    }
}
