package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bi;

public final class d {
    public static String bZM;
    public static int cfR;
    public static String qgn;

    public d(Intent intent) {
        if (intent != null) {
            bZM = bi.oV(intent.getStringExtra("KPublisherId"));
            qgn = bi.oV(intent.getStringExtra("geta8key_username"));
            cfR = bi.f(Integer.valueOf(intent.getIntExtra("geta8key_scene", 0)));
        }
    }
}
