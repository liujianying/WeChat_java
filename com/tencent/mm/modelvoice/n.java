package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

public final class n {
    public String enF;
    public boolean enG;
    public long time;

    public static String b(String str, long j, boolean z) {
        return str + ":" + j + ":" + (z ? 1 : 0) + "\n";
    }

    public n(String str) {
        try {
            int i;
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            String[] split = str.split(":");
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
        } catch (Exception e) {
            if (this.enF == null) {
                this.enF = "";
            }
            this.enG = false;
            this.time = 0;
            x.e("MicroMsg.VoiceContent", "VoiceContent parse failed.");
        }
    }
}
