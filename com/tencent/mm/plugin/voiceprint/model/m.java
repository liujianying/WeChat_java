package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.File;

public final class m {
    public static String aY(String str, boolean z) {
        String str2 = aa.duN;
        x.i("MicroMsg.VoicePrintLogic", "dbCachePath " + str2);
        str2 = str2.endsWith(File.separator) ? str2 + str : str2 + File.separator + str;
        x.i("MicroMsg.VoicePrintLogic", "genpath " + str2);
        if (bi.oW(str2)) {
            return null;
        }
        return (z || new File(str2).exists()) ? str2 : str2;
    }
}
