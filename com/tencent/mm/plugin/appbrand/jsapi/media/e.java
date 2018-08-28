package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;

public final class e extends a {
    public static final int CTRL_INDEX = 217;
    public static final String NAME = "saveImageToPhotosAlbum";

    final boolean tG(String str) {
        return bi.oV(str).toLowerCase().contains("image");
    }

    final String tH(String str) {
        return r.oN(str);
    }

    final void tI(String str) {
        ah.A(new 1(this));
    }
}
