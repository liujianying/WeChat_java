package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;

public final class f extends a {
    public static final int CTRL_INDEX = 216;
    public static final String NAME = "saveVideoToPhotosAlbum";

    final boolean tG(String str) {
        return bi.oV(str).toLowerCase().contains("video");
    }

    final String tH(String str) {
        return r.oN("mp4");
    }

    final void tI(String str) {
        ah.A(new 1(this, str));
    }
}
