package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.Point;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;

public final class h {
    public static void a(MMActivity mMActivity, Point point, e eVar) {
        a(mMActivity, point, -1.0f, eVar);
    }

    static void a(MMActivity mMActivity, Point point, float f, e eVar) {
        as.I(ad.getContext(), R.l.webview_minimize_sound_path);
        b.a(mMActivity, new 1(eVar, mMActivity, point, f));
    }
}
