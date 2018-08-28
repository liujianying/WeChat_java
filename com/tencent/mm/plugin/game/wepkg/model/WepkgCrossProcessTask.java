package com.tencent.mm.plugin.game.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class WepkgCrossProcessTask extends BaseWepkgProcessTask {
    public static final Creator<WepkgCrossProcessTask> CREATOR = new 1();
    public Runnable fFC;
    public WepkgVersion kff;
    public List<WepkgVersion> kfg;
    public WepkgPreloadFile kfh;
    public List<WepkgPreloadFile> kfi;
    public String kfj;
    public int nc;

    /* synthetic */ WepkgCrossProcessTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public WepkgCrossProcessTask() {
        this.nc = -1;
        this.kff = new WepkgVersion();
        this.kfg = new ArrayList();
        this.kfh = new WepkgPreloadFile();
        this.kfi = new ArrayList();
    }

    private WepkgCrossProcessTask(Parcel parcel) {
        g(parcel);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aai() {
        /*
        r12 = this;
        r0 = 0;
        r11 = 3;
        r10 = 2;
        r2 = 0;
        r3 = 1;
        r1 = r12.nc;
        switch(r1) {
            case 1001: goto L_0x000e;
            case 1002: goto L_0x0012;
            case 2001: goto L_0x0099;
            case 2002: goto L_0x0121;
            case 2003: goto L_0x038b;
            case 2004: goto L_0x05fe;
            case 2005: goto L_0x062f;
            case 2006: goto L_0x064f;
            case 3001: goto L_0x001c;
            case 3002: goto L_0x0611;
            case 3003: goto L_0x0038;
            case 3004: goto L_0x004a;
            case 3005: goto L_0x0068;
            case 3006: goto L_0x0082;
            case 3007: goto L_0x063c;
            case 3008: goto L_0x06a4;
            case 3009: goto L_0x06f9;
            case 4001: goto L_0x02c3;
            case 4002: goto L_0x036c;
            case 4003: goto L_0x05c7;
            case 4004: goto L_0x05dc;
            case 4005: goto L_0x0748;
            case 4006: goto L_0x07b0;
            default: goto L_0x000a;
        };
    L_0x000a:
        r12.En();
        return;
    L_0x000e:
        r0 = r12;
    L_0x000f:
        r0.bGZ = r3;
        goto L_0x000a;
    L_0x0012:
        r0 = com.tencent.mm.k.g.AU();
        r3 = r0.AG();
        r0 = r12;
        goto L_0x000f;
    L_0x001c:
        r1 = r12.kff;
        if (r1 == 0) goto L_0x000a;
    L_0x0020:
        r1 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r2 = r12.kff;
        r2 = r2.kfA;
        r1 = r1.DV(r2);
        if (r1 == 0) goto L_0x0035;
    L_0x002e:
        r0 = r12.kff;
        r0.a(r1);
        r0 = r12;
        goto L_0x000f;
    L_0x0035:
        r12.kff = r0;
        goto L_0x000a;
    L_0x0038:
        r0 = r12.kff;
        if (r0 == 0) goto L_0x000a;
    L_0x003c:
        r0 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r1 = r12.kff;
        r1 = r1.kfA;
        r3 = r0.DX(r1);
        r0 = r12;
        goto L_0x000f;
    L_0x004a:
        r0 = r12.kff;
        if (r0 == 0) goto L_0x000a;
    L_0x004e:
        r1 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r0 = r12.kff;
        r2 = r0.kfA;
        r0 = r12.kff;
        r3 = r0.kfR;
        r0 = r12.kff;
        r4 = r0.kfS;
        r0 = r12.kff;
        r6 = r0.kfT;
        r3 = r1.a(r2, r3, r4, r6);
        r0 = r12;
        goto L_0x000f;
    L_0x0068:
        r0 = r12.kff;
        if (r0 == 0) goto L_0x000a;
    L_0x006c:
        r0 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r1 = r12.kff;
        r1 = r1.kfA;
        r2 = r12.kff;
        r2 = r2.ffK;
        r3 = r12.kff;
        r3 = r3.kfX;
        r3 = r0.k(r1, r2, r3);
        r0 = r12;
        goto L_0x000f;
    L_0x0082:
        r0 = r12.kff;
        if (r0 == 0) goto L_0x000a;
    L_0x0086:
        r0 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r1 = r12.kff;
        r1 = r1.kfA;
        r2 = r12.kff;
        r2 = r2.kfY;
        r3 = r0.aA(r1, r2);
        r0 = r12;
        goto L_0x000f;
    L_0x0099:
        r0 = r12.kff;
        if (r0 == 0) goto L_0x00bf;
    L_0x009d:
        r0 = r12.kff;
        r0 = r0.kfA;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x00bf;
    L_0x00a7:
        r0 = r12.kff;
        r0 = r0.kfA;
        r1 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r1.DU(r0);
        r1 = com.tencent.mm.plugin.game.wepkg.a.b.aVn();
        r1.DU(r0);
        com.tencent.mm.plugin.game.wepkg.model.f.Ej(r0);
        r0 = r12;
        goto L_0x000f;
    L_0x00bf:
        r0 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r1 = r0.fAQ;
        if (r1 == 0) goto L_0x0113;
    L_0x00c7:
        r1 = "delete from %s";
        r4 = new java.lang.Object[r3];
        r5 = "WepkgVersion";
        r4[r2] = r5;
        r1 = java.lang.String.format(r1, r4);
        r4 = "WepkgVersion";
        r1 = r0.fV(r4, r1);
        r4 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r5 = "WepkgVersionRecord clearWepkg ret:%s";
        r6 = new java.lang.Object[r3];
        r1 = java.lang.Boolean.valueOf(r1);
        r6[r2] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        r1 = "delete from %s";
        r4 = new java.lang.Object[r3];
        r5 = "WepkgPreloadFiles";
        r4[r2] = r5;
        r1 = java.lang.String.format(r1, r4);
        r4 = "WepkgPreloadFiles";
        r0 = r0.fV(r4, r1);
        r1 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r4 = "WepkgPreloadFilesRecord clearWepkg ret:%s";
        r3 = new java.lang.Object[r3];
        r0 = java.lang.Boolean.valueOf(r0);
        r3[r2] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r3);
    L_0x0113:
        r0 = com.tencent.mm.plugin.game.wepkg.utils.d.Em();
        r1 = new com.tencent.mm.plugin.game.wepkg.model.f$2;
        r1.<init>();
        r0.H(r1);
        goto L_0x000a;
    L_0x0121:
        r0 = r12.kff;
        if (r0 == 0) goto L_0x000a;
    L_0x0125:
        r0 = r12.kff;
        r0 = r0.kfA;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x000a;
    L_0x012f:
        r0 = r12.kff;
        r0 = r0.kfA;
        r1 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r1.DU(r0);
        r1 = com.tencent.mm.plugin.game.wepkg.a.b.aVn();
        r1.DU(r0);
        r0 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r1 = r12.kff;
        r4 = new com.tencent.mm.plugin.game.wepkg.a.c;
        r4.<init>();
        r5 = r1.kfA;
        r4.field_pkgId = r5;
        r5 = r1.appId;
        r4.field_appId = r5;
        r5 = r1.version;
        r4.field_version = r5;
        r5 = r1.ffK;
        r4.field_pkgPath = r5;
        r5 = r1.kfR;
        r4.field_disableWvCache = r5;
        r6 = r1.kfS;
        r4.field_clearPkgTime = r6;
        r6 = r1.kfT;
        r4.field_checkIntervalTime = r6;
        r5 = r1.kfU;
        r4.field_packMethod = r5;
        r5 = r1.cfx;
        r4.field_domain = r5;
        r5 = r1.bKg;
        r4.field_md5 = r5;
        r5 = r1.downloadUrl;
        r4.field_downloadUrl = r5;
        r5 = r1.kfV;
        r4.field_pkgSize = r5;
        r5 = r1.kfm;
        r4.field_downloadNetType = r5;
        r6 = r1.kfW;
        r4.field_nextCheckTime = r6;
        r6 = r1.createTime;
        r4.field_createTime = r6;
        r5 = r1.charset;
        r4.field_charset = r5;
        r5 = r1.kfX;
        r4.field_bigPackageReady = r5;
        r5 = r1.kfY;
        r4.field_preloadFilesReady = r5;
        r5 = r1.kfZ;
        r4.field_preloadFilesAtomic = r5;
        r5 = r1.kga;
        r4.field_totalDownloadCount = r5;
        r1 = r1.cga;
        r4.field_downloadTriggerType = r1;
        r1 = r0.fAQ;
        if (r1 == 0) goto L_0x01ac;
    L_0x01a4:
        r1 = r4.field_pkgId;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 == 0) goto L_0x0238;
    L_0x01ac:
        r0 = r12.kfi;
        r0 = com.tencent.mm.sdk.platformtools.bi.cX(r0);
        if (r0 != 0) goto L_0x02c0;
    L_0x01b4:
        r0 = r12.kfi;
        r1 = r0.iterator();
    L_0x01ba:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x02c0;
    L_0x01c0:
        r0 = r1.next();
        r0 = (com.tencent.mm.plugin.game.wepkg.model.WepkgPreloadFile) r0;
        if (r0 == 0) goto L_0x01ba;
    L_0x01c8:
        r4 = com.tencent.mm.plugin.game.wepkg.a.b.aVn();
        r5 = new com.tencent.mm.plugin.game.wepkg.a.a;
        r5.<init>();
        r6 = r0.aAL;
        r5.field_key = r6;
        r6 = r0.kfA;
        r5.field_pkgId = r6;
        r6 = r0.version;
        r5.field_version = r6;
        r6 = r0.filePath;
        r5.field_filePath = r6;
        r6 = r0.kfk;
        r5.field_rid = r6;
        r6 = r0.mimeType;
        r5.field_mimeType = r6;
        r6 = r0.bKg;
        r5.field_md5 = r6;
        r6 = r0.downloadUrl;
        r5.field_downloadUrl = r6;
        r6 = r0.size;
        r5.field_size = r6;
        r6 = r0.kfm;
        r5.field_downloadNetType = r6;
        r6 = r0.kfB;
        r5.field_completeDownload = r6;
        r6 = r0.createTime;
        r5.field_createTime = r6;
        r0 = r4.fAQ;
        if (r0 == 0) goto L_0x01ba;
    L_0x0205:
        r0 = r5.field_pkgId;
        r6 = r5.field_rid;
        r0 = r4.de(r0, r6);
        if (r0 != 0) goto L_0x029c;
    L_0x020f:
        r6 = com.tencent.mm.plugin.game.wepkg.utils.d.aow();
        r5.field_createTime = r6;
        r0 = r4.b(r5);
        r4 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r6 = "insertPreloadFile pkgid:%s, version:%s, rid:%s, ret:%s";
        r7 = 4;
        r7 = new java.lang.Object[r7];
        r8 = r5.field_pkgId;
        r7[r2] = r8;
        r8 = r5.field_version;
        r7[r3] = r8;
        r5 = r5.field_rid;
        r7[r10] = r5;
        r0 = java.lang.Boolean.valueOf(r0);
        r7[r11] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r4, r6, r7);
        goto L_0x01ba;
    L_0x0238:
        r1 = r4.field_pkgId;
        r1 = r0.DV(r1);
        if (r1 != 0) goto L_0x0274;
    L_0x0240:
        r6 = com.tencent.mm.plugin.game.wepkg.utils.d.aow();
        r8 = r4.field_checkIntervalTime;
        r6 = r6 + r8;
        r4.field_nextCheckTime = r6;
        r6 = com.tencent.mm.plugin.game.wepkg.utils.d.aow();
        r4.field_createTime = r6;
        r6 = com.tencent.mm.plugin.game.wepkg.utils.d.aow();
        r4.field_accessTime = r6;
        r0 = r0.b(r4);
        r1 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r5 = "insertPkgVersion pkgid:%s, version:%s, ret:%s";
        r6 = new java.lang.Object[r11];
        r7 = r4.field_pkgId;
        r6[r2] = r7;
        r4 = r4.field_version;
        r6[r3] = r4;
        r0 = java.lang.Boolean.valueOf(r0);
        r6[r10] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r5, r6);
        goto L_0x01ac;
    L_0x0274:
        r6 = com.tencent.mm.plugin.game.wepkg.utils.d.aow();
        r8 = r4.field_checkIntervalTime;
        r6 = r6 + r8;
        r4.field_nextCheckTime = r6;
        r0 = r0.a(r4);
        r1 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r5 = "replacePkgVersion pkgid:%s, version:%s, ret:%s";
        r6 = new java.lang.Object[r11];
        r7 = r4.field_pkgId;
        r6[r2] = r7;
        r4 = r4.field_version;
        r6[r3] = r4;
        r0 = java.lang.Boolean.valueOf(r0);
        r6[r10] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r5, r6);
        goto L_0x01ac;
    L_0x029c:
        r0 = r4.a(r5);
        r4 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r6 = "relacePreloadFile pkgid:%s, version:%s, rid:%s, ret:%s";
        r7 = 4;
        r7 = new java.lang.Object[r7];
        r8 = r5.field_pkgId;
        r7[r2] = r8;
        r8 = r5.field_version;
        r7[r3] = r8;
        r5 = r5.field_rid;
        r7[r10] = r5;
        r0 = java.lang.Boolean.valueOf(r0);
        r7[r11] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r4, r6, r7);
        goto L_0x01ba;
    L_0x02c0:
        r0 = r12;
        goto L_0x000f;
    L_0x02c3:
        r1 = r12.kff;
        if (r1 == 0) goto L_0x000a;
    L_0x02c7:
        r1 = r12.kff;
        r1 = r1.kfA;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x000a;
    L_0x02d1:
        r1 = com.tencent.mm.plugin.game.wepkg.a.b.aVn();
        r4 = r12.kff;
        r4 = r4.kfA;
        r5 = r1.fAQ;
        if (r5 != 0) goto L_0x02e8;
    L_0x02dd:
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r5 == 0) goto L_0x02e8;
    L_0x02e3:
        r12.kfi = r0;
        r0 = r12;
        goto L_0x000f;
    L_0x02e8:
        r5 = "select * from %s where %s=? and %s=0";
        r6 = new java.lang.Object[r11];
        r7 = "WepkgPreloadFiles";
        r6[r2] = r7;
        r7 = "pkgId";
        r6[r3] = r7;
        r7 = "completeDownload";
        r6[r10] = r7;
        r5 = java.lang.String.format(r5, r6);
        r6 = new java.lang.String[r3];
        r6[r2] = r4;
        r1 = r1.rawQuery(r5, r6);
        r4 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r6 = "getNeedDownloadPreLoadFileList queryStr:%s";
        r7 = new java.lang.Object[r3];
        r7[r2] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r4, r6, r7);
        if (r1 != 0) goto L_0x0321;
    L_0x0317:
        r1 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r2 = "cursor is null";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        goto L_0x02e3;
    L_0x0321:
        r4 = r1.moveToFirst();
        if (r4 == 0) goto L_0x035e;
    L_0x0327:
        r0 = new java.util.ArrayList;
        r0.<init>();
    L_0x032c:
        r4 = new com.tencent.mm.plugin.game.wepkg.model.WepkgPreloadFile;
        r4.<init>();
        r5 = new com.tencent.mm.plugin.game.wepkg.a.a;
        r5.<init>();
        r5.d(r1);
        r4.a(r5);
        r0.add(r4);
        r4 = r1.moveToNext();
        if (r4 != 0) goto L_0x032c;
    L_0x0345:
        r1.close();
        r1 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r4 = "record list size:%s";
        r5 = new java.lang.Object[r3];
        r6 = r0.size();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);
        goto L_0x02e3;
    L_0x035e:
        r1.close();
        r1 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r2 = "no record";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        goto L_0x02e3;
    L_0x036c:
        r0 = r12.kfh;
        if (r0 == 0) goto L_0x000a;
    L_0x0370:
        r0 = com.tencent.mm.plugin.game.wepkg.a.b.aVn();
        r1 = r12.kfh;
        r1 = r1.kfA;
        r2 = r12.kfh;
        r2 = r2.kfk;
        r3 = r12.kfh;
        r3 = r3.filePath;
        r4 = r12.kfh;
        r4 = r4.kfB;
        r3 = r0.d(r1, r2, r3, r4);
        r0 = r12;
        goto L_0x000f;
    L_0x038b:
        r1 = r12.kff;
        if (r1 == 0) goto L_0x000a;
    L_0x038f:
        r4 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r1 = r4.fAQ;
        if (r1 != 0) goto L_0x0410;
    L_0x0397:
        r1 = r0;
    L_0x0398:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r4 == 0) goto L_0x0803;
    L_0x039e:
        r1 = com.tencent.mm.plugin.game.wepkg.a.b.aVn();
        r4 = r1.fAQ;
        if (r4 != 0) goto L_0x04fc;
    L_0x03a6:
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r1 == 0) goto L_0x040a;
    L_0x03ac:
        r1 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r4 = r1.fAQ;
        if (r4 == 0) goto L_0x040a;
    L_0x03b4:
        r4 = "update %s set %s=0";
        r5 = new java.lang.Object[r10];
        r6 = "WepkgVersion";
        r5[r2] = r6;
        r6 = "autoDownloadCount";
        r5[r3] = r6;
        r4 = java.lang.String.format(r4, r5);
        r5 = "WepkgVersion";
        r4 = r1.fV(r5, r4);
        r5 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r6 = "WepkgVersionRecord resetAutoDownloadCount ret:%s";
        r7 = new java.lang.Object[r3];
        r4 = java.lang.Boolean.valueOf(r4);
        r7[r2] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
        r4 = "update %s set %s=0";
        r5 = new java.lang.Object[r10];
        r6 = "WepkgPreloadFiles";
        r5[r2] = r6;
        r6 = "autoDownloadCount";
        r5[r3] = r6;
        r4 = java.lang.String.format(r4, r5);
        r5 = "WepkgPreloadFiles";
        r1 = r1.fV(r5, r4);
        r4 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r5 = "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s";
        r3 = new java.lang.Object[r3];
        r1 = java.lang.Boolean.valueOf(r1);
        r3[r2] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r3);
    L_0x040a:
        r1 = r12.kff;
        r1.kfA = r0;
        goto L_0x000a;
    L_0x0410:
        r1 = "select * from %s where %s=0 and %s=1 and %s<1 and %s<?";
        r5 = 5;
        r5 = new java.lang.Object[r5];
        r6 = "WepkgVersion";
        r5[r2] = r6;
        r6 = "bigPackageReady";
        r5[r3] = r6;
        r6 = "preloadFilesAtomic";
        r5[r10] = r6;
        r6 = "autoDownloadCount";
        r5[r11] = r6;
        r6 = 4;
        r7 = "packageDownloadCount";
        r5[r6] = r7;
        r1 = java.lang.String.format(r1, r5);
        r5 = new java.lang.String[r3];
        r6 = "3";
        r5[r2] = r6;
        r5 = r4.rawQuery(r1, r5);
        if (r5 != 0) goto L_0x0444;
    L_0x0441:
        r1 = r0;
        goto L_0x0398;
    L_0x0444:
        r1 = r5.moveToFirst();
        if (r1 == 0) goto L_0x0480;
    L_0x044a:
        r1 = r5.getCount();
        if (r1 <= r3) goto L_0x0809;
    L_0x0450:
        r1 = r1 + -1;
        r1 = com.tencent.mm.sdk.platformtools.bi.eF(r1, r2);
    L_0x0456:
        r5.move(r1);
        r1 = new com.tencent.mm.plugin.game.wepkg.a.c;
        r1.<init>();
        r1.d(r5);
        r5.close();
        r5 = r1.field_pkgId;
        r4.DY(r5);
        r4 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r5 = "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:true";
        r6 = new java.lang.Object[r10];
        r7 = r1.field_pkgId;
        r6[r2] = r7;
        r7 = r1.field_version;
        r6[r3] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        r1 = r1.field_pkgId;
        goto L_0x0398;
    L_0x0480:
        r5.close();
        r1 = "select * from %s where %s=0 and %s<1 and %s<?";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r6 = "WepkgVersion";
        r5[r2] = r6;
        r6 = "bigPackageReady";
        r5[r3] = r6;
        r6 = "autoDownloadCount";
        r5[r10] = r6;
        r6 = "packageDownloadCount";
        r5[r11] = r6;
        r1 = java.lang.String.format(r1, r5);
        r5 = new java.lang.String[r3];
        r6 = "3";
        r5[r2] = r6;
        r5 = r4.rawQuery(r1, r5);
        if (r5 != 0) goto L_0x04b1;
    L_0x04ae:
        r1 = r0;
        goto L_0x0398;
    L_0x04b1:
        r1 = r5.moveToFirst();
        if (r1 == 0) goto L_0x04ed;
    L_0x04b7:
        r1 = r5.getCount();
        if (r1 <= r3) goto L_0x0806;
    L_0x04bd:
        r1 = r1 + -1;
        r1 = com.tencent.mm.sdk.platformtools.bi.eF(r1, r2);
    L_0x04c3:
        r5.move(r1);
        r1 = new com.tencent.mm.plugin.game.wepkg.a.c;
        r1.<init>();
        r1.d(r5);
        r5.close();
        r5 = r1.field_pkgId;
        r4.DY(r5);
        r4 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r5 = "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:false";
        r6 = new java.lang.Object[r10];
        r7 = r1.field_pkgId;
        r6[r2] = r7;
        r7 = r1.field_version;
        r6[r3] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        r1 = r1.field_pkgId;
        goto L_0x0398;
    L_0x04ed:
        r5.close();
        r1 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r4 = "randomNeedDownloadPkgid no download record in DB";
        com.tencent.mm.sdk.platformtools.x.i(r1, r4);
        r1 = r0;
        goto L_0x0398;
    L_0x04fc:
        r4 = "select * from %s where %s=0 and %s<1 and %s<?";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r6 = "WepkgPreloadFiles";
        r5[r2] = r6;
        r6 = "completeDownload";
        r5[r3] = r6;
        r6 = "autoDownloadCount";
        r5[r10] = r6;
        r6 = "fileDownloadCount";
        r5[r11] = r6;
        r4 = java.lang.String.format(r4, r5);
        r5 = new java.lang.String[r3];
        r6 = "3";
        r5[r2] = r6;
        r4 = r1.rawQuery(r4, r5);
        if (r4 == 0) goto L_0x03a6;
    L_0x0527:
        r5 = r4.moveToFirst();
        if (r5 == 0) goto L_0x05b9;
    L_0x052d:
        r0 = r4.getCount();
        if (r0 <= r3) goto L_0x0800;
    L_0x0533:
        r0 = r0 + -1;
        r0 = com.tencent.mm.sdk.platformtools.bi.eF(r0, r2);
    L_0x0539:
        r4.move(r0);
        r0 = new com.tencent.mm.plugin.game.wepkg.a.a;
        r0.<init>();
        r0.d(r4);
        r4.close();
        r4 = r0.field_pkgId;
        r5 = r0.field_rid;
        r6 = r1.fAQ;
        if (r6 == 0) goto L_0x055b;
    L_0x054f:
        r6 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r6 != 0) goto L_0x055b;
    L_0x0555:
        r6 = com.tencent.mm.sdk.platformtools.bi.oW(r5);
        if (r6 == 0) goto L_0x0576;
    L_0x055b:
        r1 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r4 = "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, rid:%s";
        r5 = new java.lang.Object[r11];
        r6 = r0.field_pkgId;
        r5[r2] = r6;
        r6 = r0.field_version;
        r5[r3] = r6;
        r6 = r0.field_rid;
        r5[r10] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);
        r0 = r0.field_pkgId;
        goto L_0x03a6;
    L_0x0576:
        r6 = "update %s set %s=%s+1 where %s='%s' and %s='%s'";
        r7 = 7;
        r7 = new java.lang.Object[r7];
        r8 = "WepkgPreloadFiles";
        r7[r2] = r8;
        r8 = "autoDownloadCount";
        r7[r3] = r8;
        r8 = "autoDownloadCount";
        r7[r10] = r8;
        r8 = "pkgId";
        r7[r11] = r8;
        r8 = 4;
        r7[r8] = r4;
        r4 = 5;
        r8 = "rid";
        r7[r4] = r8;
        r4 = 6;
        r7[r4] = r5;
        r4 = java.lang.String.format(r6, r7);
        r5 = "WepkgPreloadFiles";
        r1 = r1.fV(r5, r4);
        r4 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r5 = "WepkgPreloadFilesRecord addAutoDownloadCount ret:%s";
        r6 = new java.lang.Object[r3];
        r1 = java.lang.Boolean.valueOf(r1);
        r6[r2] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        goto L_0x055b;
    L_0x05b9:
        r4.close();
        r1 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r4 = "randomNeedDownloadPkgid no download record in DB";
        com.tencent.mm.sdk.platformtools.x.i(r1, r4);
        goto L_0x03a6;
    L_0x05c7:
        r0 = r12.kff;
        if (r0 == 0) goto L_0x000a;
    L_0x05cb:
        r0 = com.tencent.mm.plugin.game.wepkg.a.b.aVn();
        r1 = r12.kff;
        r1 = r1.kfA;
        r0 = r0.DT(r1);
        r12.kfi = r0;
        r0 = r12;
        goto L_0x000f;
    L_0x05dc:
        r1 = r12.kfh;
        if (r1 == 0) goto L_0x000a;
    L_0x05e0:
        r1 = com.tencent.mm.plugin.game.wepkg.a.b.aVn();
        r2 = r12.kfh;
        r2 = r2.kfA;
        r4 = r12.kfh;
        r4 = r4.kfk;
        r1 = r1.de(r2, r4);
        if (r1 == 0) goto L_0x05fa;
    L_0x05f2:
        r0 = r12.kfh;
        r0.a(r1);
        r0 = r12;
        goto L_0x000f;
    L_0x05fa:
        r12.kfh = r0;
        goto L_0x000a;
    L_0x05fe:
        r0 = r12.kff;
        if (r0 == 0) goto L_0x000a;
    L_0x0602:
        r0 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r1 = r12.kff;
        r1 = r1.kfA;
        r3 = r0.DZ(r1);
        r0 = r12;
        goto L_0x000f;
    L_0x0611:
        r1 = r12.kff;
        if (r1 == 0) goto L_0x000a;
    L_0x0615:
        r1 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r2 = r12.kff;
        r2 = r2.kfA;
        r1 = r1.DW(r2);
        if (r1 == 0) goto L_0x062b;
    L_0x0623:
        r0 = r12.kff;
        r0.a(r1);
        r0 = r12;
        goto L_0x000f;
    L_0x062b:
        r12.kff = r0;
        goto L_0x000a;
    L_0x062f:
        r0 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r0 = r0.aVp();
        r12.kfg = r0;
        r0 = r12;
        goto L_0x000f;
    L_0x063c:
        r0 = r12.kff;
        if (r0 == 0) goto L_0x000a;
    L_0x0640:
        r0 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r1 = r12.kff;
        r1 = r1.kfA;
        r3 = r0.Ea(r1);
        r0 = r12;
        goto L_0x000f;
    L_0x064f:
        r0 = r12.kff;
        if (r0 == 0) goto L_0x000a;
    L_0x0653:
        r0 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r1 = r12.kff;
        r1 = r1.kfA;
        r4 = r0.fAQ;
        if (r4 == 0) goto L_0x0665;
    L_0x065f:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r4 == 0) goto L_0x0669;
    L_0x0665:
        r12.bGZ = r2;
        goto L_0x000a;
    L_0x0669:
        r4 = "update %s set %s=%s+1 where %s='%s'";
        r5 = 5;
        r5 = new java.lang.Object[r5];
        r6 = "WepkgVersion";
        r5[r2] = r6;
        r6 = "totalDownloadCount";
        r5[r3] = r6;
        r6 = "totalDownloadCount";
        r5[r10] = r6;
        r6 = "pkgId";
        r5[r11] = r6;
        r6 = 4;
        r5[r6] = r1;
        r1 = java.lang.String.format(r4, r5);
        r4 = "WepkgVersion";
        r0 = r0.fV(r4, r1);
        r1 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r4 = "WepkgVersionRecord addTotalDownloadCount ret:%s";
        r5 = new java.lang.Object[r3];
        r0 = java.lang.Boolean.valueOf(r0);
        r5[r2] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);
        r2 = r3;
        goto L_0x0665;
    L_0x06a4:
        r0 = r12.kff;
        if (r0 == 0) goto L_0x000a;
    L_0x06a8:
        r0 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r1 = r12.kff;
        r1 = r1.kfA;
        r4 = r0.fAQ;
        if (r4 == 0) goto L_0x06ba;
    L_0x06b4:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r4 == 0) goto L_0x06bf;
    L_0x06ba:
        r3 = r2;
    L_0x06bb:
        r12.bGZ = r3;
        goto L_0x000a;
    L_0x06bf:
        r4 = "update %s set %s=%s+1 where %s='%s'";
        r5 = 5;
        r5 = new java.lang.Object[r5];
        r6 = "WepkgVersion";
        r5[r2] = r6;
        r6 = "packageDownloadCount";
        r5[r3] = r6;
        r6 = "packageDownloadCount";
        r5[r10] = r6;
        r6 = "pkgId";
        r5[r11] = r6;
        r6 = 4;
        r5[r6] = r1;
        r1 = java.lang.String.format(r4, r5);
        r4 = "WepkgVersion";
        r0 = r0.fV(r4, r1);
        r1 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r4 = "WepkgVersionRecord addPackageDownloadCount ret:%s";
        r5 = new java.lang.Object[r3];
        r0 = java.lang.Boolean.valueOf(r0);
        r5[r2] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);
        goto L_0x06bb;
    L_0x06f9:
        r0 = r12.kff;
        if (r0 == 0) goto L_0x000a;
    L_0x06fd:
        r0 = com.tencent.mm.plugin.game.wepkg.a.d.aVo();
        r1 = r12.kff;
        r1 = r1.kfA;
        r4 = r0.fAQ;
        if (r4 == 0) goto L_0x070f;
    L_0x0709:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r4 == 0) goto L_0x0714;
    L_0x070f:
        r3 = r2;
    L_0x0710:
        r12.bGZ = r3;
        goto L_0x000a;
    L_0x0714:
        r4 = "update %s set %s=0 where %s='%s'";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r6 = "WepkgVersion";
        r5[r2] = r6;
        r6 = "packageDownloadCount";
        r5[r3] = r6;
        r6 = "pkgId";
        r5[r10] = r6;
        r5[r11] = r1;
        r1 = java.lang.String.format(r4, r5);
        r4 = "WepkgVersion";
        r0 = r0.fV(r4, r1);
        r1 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r4 = "WepkgVersionRecord resetPackageDownloadCount ret:%s";
        r5 = new java.lang.Object[r3];
        r0 = java.lang.Boolean.valueOf(r0);
        r5[r2] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);
        goto L_0x0710;
    L_0x0748:
        r0 = r12.kfh;
        if (r0 == 0) goto L_0x000a;
    L_0x074c:
        r0 = com.tencent.mm.plugin.game.wepkg.a.b.aVn();
        r1 = r12.kfh;
        r1 = r1.kfA;
        r4 = r12.kfh;
        r4 = r4.kfk;
        r5 = r0.fAQ;
        if (r5 == 0) goto L_0x0768;
    L_0x075c:
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r5 != 0) goto L_0x0768;
    L_0x0762:
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r5 == 0) goto L_0x076d;
    L_0x0768:
        r3 = r2;
    L_0x0769:
        r12.bGZ = r3;
        goto L_0x000a;
    L_0x076d:
        r5 = "update %s set %s=%s+1 where %s='%s' and %s='%s'";
        r6 = 7;
        r6 = new java.lang.Object[r6];
        r7 = "WepkgPreloadFiles";
        r6[r2] = r7;
        r7 = "fileDownloadCount";
        r6[r3] = r7;
        r7 = "fileDownloadCount";
        r6[r10] = r7;
        r7 = "pkgId";
        r6[r11] = r7;
        r7 = 4;
        r6[r7] = r1;
        r1 = 5;
        r7 = "rid";
        r6[r1] = r7;
        r1 = 6;
        r6[r1] = r4;
        r1 = java.lang.String.format(r5, r6);
        r4 = "WepkgPreloadFiles";
        r0 = r0.fV(r4, r1);
        r1 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r4 = "WepkgPreloadFilesRecord addFileDownloadCount ret:%s";
        r5 = new java.lang.Object[r3];
        r0 = java.lang.Boolean.valueOf(r0);
        r5[r2] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);
        goto L_0x0769;
    L_0x07b0:
        r0 = r12.kfh;
        if (r0 == 0) goto L_0x000a;
    L_0x07b4:
        r0 = com.tencent.mm.plugin.game.wepkg.a.b.aVn();
        r1 = r12.kfh;
        r1 = r1.kfA;
        r4 = r0.fAQ;
        if (r4 == 0) goto L_0x07c6;
    L_0x07c0:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r4 == 0) goto L_0x07ca;
    L_0x07c6:
        r3 = r2;
        r0 = r12;
        goto L_0x000f;
    L_0x07ca:
        r4 = "update %s set %s=0 where %s='%s'";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r6 = "WepkgPreloadFiles";
        r5[r2] = r6;
        r6 = "fileDownloadCount";
        r5[r3] = r6;
        r6 = "pkgId";
        r5[r10] = r6;
        r5[r11] = r1;
        r1 = java.lang.String.format(r4, r5);
        r4 = "WepkgPreloadFiles";
        r0 = r0.fV(r4, r1);
        r1 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r4 = "WepkgPreloadFilesRecord resetFileDownloadCount ret:%s";
        r5 = new java.lang.Object[r3];
        r0 = java.lang.Boolean.valueOf(r0);
        r5[r2] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);
        r0 = r12;
        goto L_0x000f;
    L_0x0800:
        r0 = r2;
        goto L_0x0539;
    L_0x0803:
        r0 = r1;
        goto L_0x03a6;
    L_0x0806:
        r1 = r2;
        goto L_0x04c3;
    L_0x0809:
        r1 = r2;
        goto L_0x0456;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.wepkg.model.WepkgCrossProcessTask.aai():void");
    }

    public final void aaj() {
        if (this.fFC != null) {
            this.fFC.run();
        }
    }

    public final void k(Parcel parcel) {
        this.nc = parcel.readInt();
        this.kff = (WepkgVersion) parcel.readParcelable(WepkgVersion.class.getClassLoader());
        if (this.kfg == null) {
            this.kfg = new ArrayList();
        }
        parcel.readList(this.kfg, WepkgVersion.class.getClassLoader());
        this.kfh = (WepkgPreloadFile) parcel.readParcelable(WepkgPreloadFile.class.getClassLoader());
        if (this.kfi == null) {
            this.kfi = new ArrayList();
        }
        parcel.readList(this.kfi, WepkgPreloadFile.class.getClassLoader());
        this.kfj = parcel.readString();
    }

    public final void v(Parcel parcel, int i) {
        parcel.writeInt(this.nc);
        parcel.writeParcelable(this.kff, i);
        parcel.writeList(this.kfg);
        parcel.writeParcelable(this.kfh, i);
        parcel.writeList(this.kfi);
        parcel.writeString(this.kfj);
    }
}
