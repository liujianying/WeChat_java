package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.regex.Pattern;

protected class i$a {
    private static final Pattern eXs = Pattern.compile(".*#.*wechat_redirect");
    private String jIf = null;

    public i$a(String str) {
        this.jIf = str;
    }

    public final int Di(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.MMWebViewClient", "getReason fail, url is null");
            return 0;
        } else if (str.equals(this.jIf)) {
            return 0;
        } else {
            if (eXs.matcher(str).find()) {
                return 2;
            }
            return 1;
        }
    }
}
