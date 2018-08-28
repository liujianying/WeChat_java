package com.tencent.mm.storage;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class an {
    public String bKg = "-1";
    public String enF;
    public boolean enG;
    public boolean taS;
    public String taT = "";
    public long time;

    public static String a(String str, long j, boolean z, String str2, boolean z2, String str3) {
        int i = 1;
        StringBuilder append = new StringBuilder().append(str).append(":").append(j).append(":").append(z ? 1 : 0).append(":").append(str2).append(":").append(str3.replace(":", "*#*")).append(":");
        if (!z2) {
            i = 0;
        }
        return append.append(i).append("\n").toString();
    }

    public final String clN() {
        int i = 1;
        StringBuilder append = new StringBuilder().append(this.enF).append(":").append(this.time).append(":").append(this.enG ? 1 : 0).append(":").append(this.bKg).append(":").append(this.taT).append(":");
        if (!this.taS) {
            i = 0;
        }
        return append.append(i).append("\n").toString();
    }

    public an(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. content is null.");
            return;
        }
        try {
            String substring;
            int i;
            if (str.endsWith("\n")) {
                substring = str.substring(0, str.length() - 1);
            } else {
                this.taT = str.replace(":", "*#*");
                substring = str;
            }
            String[] split = substring.split(":", 6);
            if (split.length == 4 && ab.gY(split[0])) {
                i = 1;
            } else {
                i = 0;
            }
            if (split.length > i) {
                this.enF = split[i];
            }
            if (split.length > i + 1) {
                this.time = bi.getLong(split[i + 1], 0);
            }
            if (split.length > i + 2) {
                this.enG = split[i + 2].equals("1");
            }
            if (split.length > i + 3) {
                this.bKg = split[i + 3];
            }
            if (split.length > i + 4) {
                this.taT = split[i + 4].replace("*#*", ":");
            }
            if (split.length > i + 5) {
                this.taS = split[i + 5].equals("1");
            }
        } catch (Throwable e) {
            this.time = 0;
            x.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. Content:%s Excpetion:%s", new Object[]{str, bi.i(e)});
        }
    }

    public static an YJ(String str) {
        return new an(str);
    }
}
