package com.tencent.mm.modelvideo;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class p {
    public String enF;
    private boolean enG;
    private long time;

    public static String b(String str, long j, boolean z) {
        return str + ":" + j + ":" + (z ? 1 : 0) + "\n";
    }

    public p(String str) {
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        String[] split = str.split(":");
        try {
            if (split.length > 0) {
                this.enF = split[0];
            }
            if (split.length > 1) {
                this.time = bi.getLong(split[1], 0);
            }
            if (split.length > 2) {
                this.enG = split[2].equals("1");
            }
        } catch (Exception e) {
            if (this.enF == null) {
                this.enF = "";
            }
            this.enG = false;
            this.time = 0;
            x.e("MicroMsg.VideoContent", "VoiceContent parse failed.");
        }
    }
}
