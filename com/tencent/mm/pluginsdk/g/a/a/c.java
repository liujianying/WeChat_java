package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bi;

final class c extends l {
    private final boolean bIJ;
    final String bKg;
    final long fileSize;
    volatile boolean pON;
    final long qBG;
    volatile byte[] qCe;

    private c(String str, int i, String str2, boolean z, long j, String str3, int i2, long j2, int i3, int i4) {
        super(str, i.Ti(str), String.valueOf(i), "CheckResUpdate", str3, "GET", i2, i3, i4);
        this.bKg = str2;
        this.qBG = j;
        this.bIJ = z;
        this.fileSize = j2;
    }

    public final boolean ccs() {
        return true;
    }

    public final String getFilePath() {
        return i.Ti(this.qBy);
    }

    public final String aca() {
        return "CheckResUpdate";
    }

    static c c(s sVar) {
        return new c(sVar.field_urlKey, bi.getInt(sVar.field_fileVersion, 0), sVar.field_md5, bi.oV(sVar.field_groupId2).equals("NewXml"), sVar.field_reportId, sVar.field_url, sVar.field_maxRetryTimes, sVar.field_fileSize, sVar.field_networkType, sVar.field_priority);
    }
}
