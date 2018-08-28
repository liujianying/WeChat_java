package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ab {
    private static final Set<String> pRH;

    static {
        Set hashSet = new HashSet();
        pRH = hashSet;
        hashSet.add("file:///android_asset/");
        String str = e.duO;
        if (!bi.oW(str)) {
            str = e.duO.replace("/data/user/0", "/data/data");
        }
        pRH.add("file://" + new File(p.zT(0)).getAbsolutePath());
        pRH.add("file://" + new File(e.bnE, p.zR(0)).getAbsolutePath());
        pRH.add("file://" + new File(str, "wenote/res").getAbsolutePath());
        pRH.add("file://" + new File(e.bnE, "wenote/res").getAbsolutePath());
        x.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[]{r1.getAbsolutePath(), r2.getAbsolutePath()});
        pRH.add("file://" + new File(str, "emoji/res").getAbsolutePath());
        pRH.add("file://" + new File(e.bnE, "emoji/res").getAbsolutePath());
        x.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[]{r1.getAbsolutePath(), r0.getAbsolutePath()});
        Iterator it = pRH.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", new Object[]{(String) it.next()});
        }
    }

    public static boolean Ql(String str) {
        if (af.exj) {
            x.w("MicroMsg.URLFilter", "skipLoadUrlCheck");
            return true;
        } else if (bi.oW(str)) {
            return true;
        } else {
            String toLowerCase = str.toLowerCase();
            if (toLowerCase.startsWith("about:blank")) {
                return false;
            }
            if (toLowerCase.startsWith("file://")) {
                for (String startsWith : pRH) {
                    if (toLowerCase.startsWith(startsWith)) {
                        return true;
                    }
                }
                return false;
            }
            Uri parse = Uri.parse(toLowerCase);
            if (bi.oW(parse.getHost())) {
                return true;
            }
            return !parse.getHost().contains(s.cfB());
        }
    }
}
