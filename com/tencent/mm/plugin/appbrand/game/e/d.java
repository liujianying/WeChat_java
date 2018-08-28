package com.tencent.mm.plugin.appbrand.game.e;

import android.content.Context;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static boolean fBd = false;

    public static void cw(Context context) {
        String str = q.deU.dbx;
        if (fBd) {
            x.i("MicroMsg.WAGameShowFailDialogUtil", "hy: already shown");
            return;
        }
        String string = ad.getResources().getString(j.appbrand_game_game_start_error);
        String string2 = ad.getResources().getString(j.app_tip);
        if (bi.oW(str)) {
            str = string;
        }
        a.a(context, str, string2, ad.getResources().getString(j.app_ok), "", new 1(), new 2(), new 3());
        fBd = true;
    }
}
