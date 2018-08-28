package com.tencent.mm.ak.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.ak.a.c.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements f {
    public final String mc(String str) {
        if (bi.oW(str)) {
            return null;
        }
        x.d("MicroMsg.imageloader.DefaultImageFileNameCreator", "[cpan] create image file name :%s", new Object[]{g.u(str.getBytes())});
        return g.u(str.getBytes());
    }
}
