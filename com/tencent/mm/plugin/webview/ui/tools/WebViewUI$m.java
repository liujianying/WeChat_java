package com.tencent.mm.plugin.webview.ui.tools;

import android.webkit.URLUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class WebViewUI$m {
    private static final Pattern eXs = Pattern.compile(".*#.*wechat_redirect");
    public String jIf = null;
    String[] pZv = null;
    private LinkedList<String> qaL = new LinkedList();

    public WebViewUI$m(String str) {
        this.jIf = str;
    }

    public final int Di(String str) {
        int i = 0;
        if (bi.oW(str)) {
            x.e("MicroMsg.WebViewUI", "getReason fail, url is null");
            return 0;
        } else if (str.equals(this.jIf)) {
            return 0;
        } else {
            if (eXs.matcher(str).find()) {
                return 2;
            }
            if (!bi.oW(str) && this.pZv != null && this.pZv.length != 0 && !this.qaL.contains(str)) {
                String substring;
                if (URLUtil.isHttpUrl(str)) {
                    substring = str.substring(7);
                } else {
                    substring = str;
                }
                if (URLUtil.isHttpsUrl(substring)) {
                    substring = str.substring(8);
                }
                x.i("MicroMsg.WebViewUI", "rawUrl = %s, subUrl = %s", new Object[]{str, substring});
                for (String str2 : this.pZv) {
                    x.i("MicroMsg.WebViewUI", "force geta8key path = %s", new Object[]{str2});
                    if (substring.startsWith(r5[r2])) {
                        this.qaL.add(str);
                        i = 1;
                        break;
                    }
                }
            }
            return i != 0 ? 8 : 1;
        }
    }
}
