package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class s$a {
    private static final Pattern qUw = Pattern.compile("([a-zA-Z*-.0-9]+/[a-zA-Z*-.0-9]+)");
    public final String charset;
    public final String mimeType;

    private s$a(String str, String str2) {
        this.mimeType = str;
        this.charset = str2;
    }

    public final String toString() {
        return "ContentType{mimeType='" + this.mimeType + '\'' + ", charset='" + this.charset + '\'' + '}';
    }

    public static s$a Uj(String str) {
        String str2 = null;
        if (bi.oW(str)) {
            return null;
        }
        Matcher matcher = qUw.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        String group = matcher.group(0);
        if (str.contains("charset=")) {
            str2 = str.substring(str.indexOf("charset=") + 8).trim();
        }
        if (bi.oW(str2)) {
            str2 = "UTF-8";
        }
        return new s$a(group, str2);
    }
}
