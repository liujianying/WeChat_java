package com.tencent.mm.plugin.webview.modeltools;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.c;
import java.util.LinkedList;
import java.util.List;

public final class b {
    public static final String pTG = Integer.toString(100028);

    public static void d(d dVar) {
        Bundle g;
        try {
            g = dVar.g(24, new Bundle(0));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebView.CookiesCleanup", e, "", new Object[0]);
            g = null;
        }
        if (g == null) {
            x.i("MicroMsg.WebView.CookiesCleanup", "bundle is null, skip cookies cleanup");
            return;
        }
        List stringArrayList = g.getStringArrayList("cookies_cleanup_url_list");
        if (bi.cX(stringArrayList)) {
            x.i("MicroMsg.WebView.CookiesCleanup", "url list is empty, skip cookies cleanup");
            return;
        }
        cN(stringArrayList);
        c.ij(ad.getContext());
        c.sync();
        x.i("MicroMsg.WebView.CookiesCleanup", "cleanup cookies end");
    }

    private static void cN(List<String> list) {
        com.tencent.xweb.b cIi = com.tencent.xweb.b.cIi();
        for (String str : list) {
            List list2;
            x.i("MicroMsg.WebView.CookiesCleanup", "cookies cleanup: url(%s)", new Object[]{str});
            String cookie = cIi.getCookie(str);
            if (bi.oW(cookie)) {
                list2 = null;
            } else {
                String[] split = cookie.split(";");
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    split[i] = split[i].trim();
                }
                list2 = new LinkedList();
                for (String str2 : split) {
                    if (!bi.oW(str2) && str2.contains("=")) {
                        list2.add(str2.split("=")[0]);
                    }
                }
                if (list2.isEmpty()) {
                    list2 = null;
                }
            }
            a(str, list2, cIi);
        }
    }

    private static void a(String str, List<String> list, com.tencent.xweb.b bVar) {
        if (!bi.cX(list)) {
            String str2;
            String[] split = Uri.parse(str).getHost().split("\\.");
            if (split.length <= 1) {
                str2 = "";
            } else {
                str2 = split[split.length - 2] + "." + split[split.length - 1];
            }
            x.d("MicroMsg.WebView.CookiesCleanup", "host(%s)", new Object[]{r2});
            x.d("MicroMsg.WebView.CookiesCleanup", "domain(%s)", new Object[]{str2});
            for (String str3 : list) {
                if (!bi.oW(str3)) {
                    bVar.setCookie(str, str3 + "=");
                    bVar.setCookie(str, str3 + "=;path=/");
                    if (!bi.oW(str2)) {
                        bVar.setCookie(str2, str3 + "=;domain=." + str2 + ";path=/");
                    }
                }
            }
        }
    }
}
