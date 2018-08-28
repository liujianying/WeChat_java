package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.a.d;

public final class bf {
    private final d sJh;
    private aa<String, String> sJi = new aa(256);

    public bf(String str) {
        this.sJh = new d(str);
    }

    public final String decryptTag(String str) {
        Throwable e;
        try {
            if (str.startsWith("!")) {
                if (this.sJi.bb(str)) {
                    return (String) this.sJi.get(str);
                }
                String substring = str.substring(1);
                try {
                    String[] split = substring.split("@");
                    if (split.length > 1) {
                        String str2 = split[0];
                        int intValue = Integer.valueOf(split[0]).intValue();
                        String substring2 = substring.substring(str2.length() + 1, (str2.length() + 1) + intValue);
                        String str3 = this.sJh.cl(substring2) + substring.substring(intValue + (str2.length() + 1));
                        this.sJi.put(str, str3);
                        return str3;
                    }
                    str = substring;
                } catch (Exception e2) {
                    e = e2;
                    str = substring;
                    x.printErrStackTrace("MicroMsg.TagDecrypter", e, "", new Object[0]);
                    str = "[td]" + str;
                    return str;
                }
            }
        } catch (Throwable e3) {
            e = e3;
            x.printErrStackTrace("MicroMsg.TagDecrypter", e, "", new Object[0]);
            str = "[td]" + str;
            return str;
        }
        return str;
    }
}
