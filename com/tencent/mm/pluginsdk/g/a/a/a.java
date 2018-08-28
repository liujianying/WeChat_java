package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.f.b;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bi;

public final class a implements b {
    final int bIC;
    final int bID;
    final int bIE;
    final boolean bIF;
    final String filePath;
    final boolean qBA;
    final String qBB;
    final int qBC;
    final byte[] qBD;
    final String qBE;
    final boolean qBF;
    final long qBG;
    final String qBH;
    final int qBI;
    final int qBJ;
    final String qBy;
    final boolean qBz;
    final String url;

    private a(String str, int i, int i2, int i3, boolean z, String str2, boolean z2, boolean z3, String str3, int i4, byte[] bArr, String str4, boolean z4, long j, String str5, String str6, int i5, int i6) {
        this.qBy = str;
        this.bIC = i;
        this.bID = i2;
        this.bIE = i3;
        this.bIF = z;
        this.filePath = str2;
        this.qBz = z2;
        this.qBA = z3;
        this.qBB = str3;
        this.qBC = i4;
        this.qBD = bArr;
        this.qBE = str4;
        this.qBF = z4;
        this.qBG = j;
        this.qBH = str5;
        this.url = str6;
        this.qBI = i5;
        this.qBJ = i6;
    }

    public final String cco() {
        return this.qBy;
    }

    public static a a(s sVar) {
        return new a(sVar.field_urlKey, sVar.field_resType, sVar.field_subType, bi.getInt(sVar.field_fileVersion, 0), sVar.field_fileUpdated, sVar.field_filePath, sVar.field_fileEncrypt, sVar.field_fileCompress, sVar.field_encryptKey, sVar.field_keyVersion, sVar.field_eccSignature, sVar.field_originalMd5, bi.oV(sVar.field_groupId2).equals("NewXml"), sVar.field_reportId, sVar.field_sampleId, sVar.field_url, sVar.field_maxRetryTimes, sVar.field_retryTimes);
    }
}
