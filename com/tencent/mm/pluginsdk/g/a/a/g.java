package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bi;

final class g extends a {
    final int bIC;
    final int bID;
    private final boolean bIF;
    final boolean bIJ;
    final long fileSize;
    private final String qBB;
    final int qBC;
    private final byte[] qBD;
    final String qBE;
    final long qBG;
    private final String qBH;
    final byte[] qCe;
    final boolean qCf;
    final boolean qCg;
    private final int qCh;

    public g(String str, String str2, int i, int i2, int i3, long j, String str3, int i4, int i5, long j2, String str4, byte[] bArr, String str5, boolean z, boolean z2, String str6, int i6, int i7, byte[] bArr2, long j3, boolean z3, boolean z4, int i8) {
        super(str, str2, String.valueOf(i), i2, i3, i.Ti(str2), j, str3, "CheckResUpdate", z3 ? "NewXml" : "CGI", i8);
        this.bIC = i4;
        this.bID = i5;
        this.qBG = j2;
        this.qBH = str4;
        this.qBD = bArr;
        this.qBE = str5;
        this.qCf = z;
        this.qCg = z2;
        this.qBB = str6;
        this.qBC = i6;
        this.qCh = i7;
        this.qCe = bArr2;
        this.fileSize = j3;
        this.bIJ = z3;
        this.bIF = z4;
    }

    public final String toString() {
        return "CheckResUpdateRequest | fileUpdated=" + this.bIF + ", resType=" + this.bIC + ", subType=" + this.bID + ", reportId=" + this.qBG + ", sampleId='" + this.qBH + '\'' + ", originalMd5='" + this.qBE + '\'' + ", fileCompress=" + this.qCf + ", fileEncrypt=" + this.qCg + ", encryptKey='" + this.qBB + '\'' + ", keyVersion=" + this.qBC + ", EID=" + this.qCh + ", fileSize=" + this.fileSize + ", fromNewXml=" + this.bIJ + " | " + super.toString();
    }

    public final s cct() {
        s cct = super.cct();
        cct.field_fileUpdated = this.bIF;
        cct.field_resType = this.bIC;
        cct.field_subType = this.bID;
        cct.field_reportId = this.qBG;
        cct.field_sampleId = this.qBH;
        cct.field_eccSignature = this.qBD;
        cct.field_originalMd5 = this.qBE;
        cct.field_fileCompress = this.qCf;
        cct.field_fileEncrypt = this.qCg;
        cct.field_encryptKey = this.qBB;
        cct.field_keyVersion = this.qBC;
        cct.field_fileSize = this.fileSize;
        cct.field_EID = this.qCh;
        return cct;
    }

    protected final int Th(String str) {
        return bi.getInt(this.qCR, 0) - bi.getInt(str, 0);
    }
}
