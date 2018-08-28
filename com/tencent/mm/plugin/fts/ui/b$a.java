package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.fts.ui.n.b;
import com.tencent.mm.sdk.platformtools.ad;

public class b$a {
    public static int jvq;

    static {
        jvq = 0;
        Context context = ad.getContext();
        jvq = ((a.fk(context) - (a.ad(context, b.SearchLargePadding) * 2)) - a.ad(context, b.NormalAvatarSize)) - a.ad(context, b.SearchLargePadding);
    }
}
