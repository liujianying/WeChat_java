package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    String bSS = null;
    private String[] mcN = null;
    private String[] mcO = null;
    private String[] mcP = null;
    String mcQ = null;
    a[] mcR = null;
    a[] mcS = null;
    String mck = null;

    public k(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2) {
        if (!bi.oW(str)) {
            this.bSS = str;
        }
        if (strArr == null || strArr.length <= 0) {
            this.mcN = null;
        } else {
            this.mcN = strArr;
        }
        if (strArr2 == null || strArr2.length <= 0) {
            this.mcO = null;
        } else {
            this.mcO = strArr2;
        }
        if (strArr3 == null || strArr3.length <= 0) {
            this.mcP = null;
        } else {
            this.mcP = strArr3;
        }
        if (bi.oW(str2)) {
            this.mck = null;
        } else {
            this.mck = str2;
        }
    }

    final String bon() {
        if (this.mcN == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("To: ");
        for (String str : this.mcN) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    final String boo() {
        if (this.mcO == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Cc: ");
        for (String str : this.mcO) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    final String bop() {
        if (this.mcP == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Bcc: ");
        for (String str : this.mcO) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    public static String JU(String str) {
        String u;
        String str2 = null;
        String str3 = "abEdf4&^^*sxcSD$%&1sdfz@!~AZcT4s322dA%^&&*$##C$%__SDy4d_(*%";
        int length = str3.length();
        try {
            u = g.u((str + "d$3^&xRw%&*_(").getBytes());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MailContentFormatter", e, "", new Object[0]);
            x.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + e.getLocalizedMessage());
            u = str2;
        }
        char[] cArr = new char[(u.length() * 2)];
        int i = 0;
        for (int i2 = 0; i2 < u.length(); i2++) {
            int i3 = i + 1;
            cArr[i] = u.charAt(i2);
            char charAt = u.charAt(i2);
            i = i3 + 1;
            cArr[i3] = (char) (str3.charAt(charAt % length) + u.charAt(i2));
        }
        try {
            return g.u(new String(cArr).getBytes("ISO-8859-1"));
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.MailContentFormatter", e2, "", new Object[0]);
            x.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + e2.getLocalizedMessage());
            return str2;
        }
    }
}
