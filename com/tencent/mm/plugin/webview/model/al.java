package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class al {
    private static Map<String, String> pSJ = new HashMap();

    public static void fn(String str, String str2) {
        x.i("MicroMsg.WebviewSharedUrlCache", "rawurl:[%s], shareUrl:[%s]", new Object[]{str, str2});
        if (bi.oW(str) || bi.oW(str2)) {
            x.e("MicroMsg.WebviewSharedUrlCache", "rawurl is null or share url is null");
        } else if (pSJ.containsKey(str)) {
            x.i("MicroMsg.WebviewSharedUrlCache", "has add this rawurl");
        } else {
            pSJ.put(str, str2);
        }
    }

    public static String Dp(String str) {
        x.i("MicroMsg.WebviewSharedUrlCache", "rawUrl:[%s]", new Object[]{str});
        if (bi.oW(str)) {
            x.e("MicroMsg.WebviewSharedUrlCache", "rawUrl is null");
            return null;
        }
        String str2 = (String) pSJ.get(str);
        if (bi.oW(str2)) {
            int indexOf = str.indexOf("#");
            str2 = (String) pSJ.get(indexOf < 0 ? str : str.substring(0, indexOf));
        }
        return !bi.oW(str2) ? str2 : str;
    }

    public static void clear() {
        pSJ.clear();
    }
}
