package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URI;

public final class o {
    public static void a(s sVar, int i, int i2) {
        if (sVar == null) {
            ((b) g.l(b.class)).aSi();
            sVar = v.aTZ();
            if (sVar == null) {
                return;
            }
        }
        sVar.aTW();
        x.i("MicroMsg.GameFloatUtil", "float layer report");
        if (!bi.oW(sVar.jMI.url)) {
            int i3 = sVar.field_msgType;
            if (sVar.field_msgType == 100) {
                i3 = sVar.jNa;
            }
            an.a(ad.getContext(), 10, 1006, 1, 1, 0, sVar.field_appId, i, i3, sVar.field_gameMsgId, sVar.jNb, null);
            if (i2 == 1) {
                h.mEJ.a(858, 16, 1, false);
            } else if (i2 == 2) {
                h.mEJ.a(858, 17, 1, false);
            }
            sVar.field_isRead = true;
            ((c) g.l(c.class)).aSj().c(sVar, new String[0]);
        }
        ((b) g.l(b.class)).aSi();
        v.aUa();
    }

    public static String a(String str, s sVar) {
        boolean z;
        if (sVar != null) {
            sVar.aTW();
            if (!bi.oW(sVar.jMI.url)) {
                z = true;
                x.i("MicroMsg.GameFloatUtil", "hasFloatLayer = " + z);
                if (z) {
                    String str2;
                    Uri parse = Uri.parse(str);
                    String query = parse.getQuery();
                    if (query != null) {
                        str2 = query + "&h5FloatLayer=1";
                    } else {
                        str2 = "h5FloatLayer=1";
                    }
                    try {
                        str = new URI(parse.getScheme(), parse.getAuthority(), parse.getPath(), str2, parse.getFragment()).toString();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.GameFloatUtil", e, "", new Object[0]);
                    }
                }
                x.i("MicroMsg.GameFloatUtil", "abtest, url = %s", new Object[]{str});
                return str;
            }
        }
        z = false;
        x.i("MicroMsg.GameFloatUtil", "hasFloatLayer = " + z);
        if (z) {
            String str22;
            Uri parse2 = Uri.parse(str);
            String query2 = parse2.getQuery();
            if (query2 != null) {
                str22 = query2 + "&h5FloatLayer=1";
            } else {
                str22 = "h5FloatLayer=1";
            }
            try {
                str = new URI(parse2.getScheme(), parse2.getAuthority(), parse2.getPath(), str22, parse2.getFragment()).toString();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.GameFloatUtil", e2, "", new Object[0]);
            }
        }
        x.i("MicroMsg.GameFloatUtil", "abtest, url = %s", new Object[]{str});
        return str;
    }

    public static void a(Context context, String str, String str2, boolean z, s sVar, int i) {
        if (!bi.oW(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("geta8key_scene", 32);
            intent.putExtra("KPublisherId", str2);
            intent.putExtra("game_check_float", z);
            if (z && sVar != null) {
                sVar.aTW();
                if (sVar.jMI.jNf) {
                    intent.putExtra("game_transparent_float_url", sVar.jMI.url);
                }
                intent.putExtra("game_sourceScene", i);
            }
            com.tencent.mm.plugin.game.e.c.x(intent, context);
        }
    }
}
