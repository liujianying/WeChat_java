package com.tencent.mm.plugin.fav;

import android.os.Looper;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class a implements m {
    public final b a(String str, Map<String, String> map, com.tencent.mm.ab.d.a aVar) {
        x.i("MicroMsg.Fav.FavNewXmlConsumer", "consumeNewXml subtype: %s values: %s", new Object[]{str, map.toString()});
        int i = -1;
        switch (str.hashCode()) {
            case -1938535405:
                if (str.equals("resendfavitem")) {
                    i = 1;
                    break;
                }
                break;
            case -1648140403:
                if (str.equals("uploadfavitem")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                fz fzVar = new fz();
                fzVar.bOL.type = 38;
                fzVar.bOL.bOU = (String) map.get(".sysmsg.favids");
                com.tencent.mm.sdk.b.a.sFg.a(fzVar, Looper.getMainLooper());
                h.pH(1);
                break;
            case 1:
                fz fzVar2 = new fz();
                fzVar2.bOL.type = 39;
                fzVar2.bOL.bOU = (String) map.get(".sysmsg.favitem.favid");
                fzVar2.bOL.bOV = (String) map.get(".sysmsg.favitem.dataidlist");
                com.tencent.mm.sdk.b.a.sFg.a(fzVar2, Looper.getMainLooper());
                h.pH(0);
                break;
        }
        return null;
    }
}
