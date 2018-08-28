package com.tencent.mm.plugin.game.gamewebview.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.regex.Pattern;

public final class f {
    public b jIa;
    c jIb;

    public static class b {
        private static final Pattern eXs = Pattern.compile(".*#.*wechat_redirect");
        private String jIf = null;

        public b(String str) {
            this.jIf = str;
        }

        public final int Di(String str) {
            if (bi.oW(str)) {
                x.e("MicroMsg.GameWebViewGetA8KeyHelp", "getReason fail, url is null");
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

    public f(String str, c cVar) {
        this.jIb = cVar;
        this.jIa = new b(str);
    }
}
