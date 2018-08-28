package com.tencent.mm.plugin.game.model.a;

import android.database.Cursor;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.na;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class g {

    /* renamed from: com.tencent.mm.plugin.game.model.a.g$2 */
    class AnonymousClass2 implements com.tencent.mm.ab.v.a {
        final /* synthetic */ String bAj;

        AnonymousClass2(String str) {
            this.bAj = str;
        }

        public final int a(int i, int i2, String str, b bVar, l lVar) {
            if (i == 0 && i2 == 0) {
                na naVar = (na) bVar.dIE.dIL;
                if (naVar == null) {
                    return 0;
                }
                x.i("MicroMsg.GameSilentDownloader", "op:%d", new Object[]{Integer.valueOf(naVar.op)});
                switch (naVar.op) {
                    case 1:
                        ((c) com.tencent.mm.kernel.g.l(c.class)).aSl().DH(this.bAj);
                        if (naVar.rrf != null && naVar.rrf.rdc != null && !bi.oW(naVar.rrf.rdc.rcY)) {
                            c DC = ((c) com.tencent.mm.kernel.g.l(c.class)).aSl().DC(this.bAj);
                            if (DC != null) {
                                if (!naVar.rrf.rdc.rcY.equals(bi.oV(DC.field_downloadUrl))) {
                                    x.i("MicroMsg.GameSilentDownloader", "update downloadInfo. [oldDownloadUrl]:%s, [newDownloadUrl]:%s, [size]:%d, [md5]:%s", new Object[]{DC.field_downloadUrl, naVar.rrf.rdc.rcY, Long.valueOf(naVar.rrf.rdc.rcZ), naVar.rrf.rdc.rda});
                                    if (bi.oW(DC.field_downloadUrl)) {
                                        FileDownloadTaskInfo yP = d.aCU().yP(naVar.rrf.rdc.rcY);
                                        if (!(yP == null || yP.id <= 0 || yP.status == 4)) {
                                            x.i("MicroMsg.GameSilentDownloader", "download task already exists");
                                            e.C(this.bAj, 6, 0);
                                            ((c) com.tencent.mm.kernel.g.l(c.class)).aSl().a(DC, new String[0]);
                                            g.this.fv(false);
                                            return 0;
                                        }
                                    }
                                    DC.field_downloadUrl = naVar.rrf.rdc.rcY;
                                    DC.field_size = naVar.rrf.rdc.rcZ;
                                    DC.field_md5 = naVar.rrf.rdc.rda;
                                    if (!bi.oW(naVar.rrf.rdc.jPg)) {
                                        DC.field_packageName = naVar.rrf.rdc.jPg;
                                    }
                                    ((c) com.tencent.mm.kernel.g.l(c.class)).aSl().c(DC, new String[0]);
                                }
                                int i3 = naVar.rrf.rdc.jPZ;
                                if (DC != null && !bi.oW(DC.field_downloadUrl)) {
                                    x.i("MicroMsg.GameSilentDownloader", "startDownload, appId:%s, url:%s, size:%d, md5:%s, packageName:%s, expireTime:%d, isFirst:%b, nextCheckTime:%d, isRunning:%b", new Object[]{DC.field_appId, DC.field_downloadUrl, Long.valueOf(DC.field_size), DC.field_md5, DC.field_packageName, Long.valueOf(DC.field_expireTime), Boolean.valueOf(DC.field_isFirst), Long.valueOf(DC.field_nextCheckTime), Boolean.valueOf(DC.field_isRunning)});
                                    FileDownloadTaskInfo yP2 = d.aCU().yP(DC.field_downloadUrl);
                                    long j;
                                    if (yP2 != null && yP2.id > 0 && yP2.status == 2) {
                                        x.i("MicroMsg.GameSilentDownloader", "resume downloadTask");
                                        j = yP2.id;
                                        d.aCU().ibV = true;
                                        d.aCU().co(j);
                                        break;
                                    }
                                    com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
                                    aVar.yQ(DC.field_downloadUrl);
                                    aVar.setAppId(DC.field_appId);
                                    aVar.cx(DC.field_size);
                                    aVar.cQ(DC.field_packageName);
                                    aVar.yS(com.tencent.mm.pluginsdk.model.app.g.b(ad.getContext(), com.tencent.mm.pluginsdk.model.app.g.bl(DC.field_appId, true), null));
                                    aVar.yT(DC.field_md5);
                                    aVar.ef(false);
                                    aVar.eg(false);
                                    aVar.ox(1);
                                    aVar.aDa();
                                    d.aCU().ibV = true;
                                    j = i3 == 1 ? d.aCU().b(aVar.ick) : d.aCU().a(aVar.ick);
                                    x.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "add downloadTask id:%d, downloaderType:%d", new Object[]{Long.valueOf(j), Integer.valueOf(i3)});
                                    break;
                                }
                                x.e("MicroMsg.GameSilentDownloader", "downloadInfo is null");
                                break;
                            }
                            x.i("MicroMsg.GameSilentDownloader", "local SilentDownloadTask is deleted");
                            return 0;
                        }
                        x.e("MicroMsg.GameSilentDownloader", "downloadInfo is null");
                        h.mEJ.a(860, 20, 1, false);
                        return 0;
                        break;
                    case 2:
                        x.i("MicroMsg.GameSilentDownloader", "delay, nextInterval:%d", new Object[]{Long.valueOf(naVar.rre)});
                        ((c) com.tencent.mm.kernel.g.l(c.class)).aSl().E(this.bAj, bi.VE() + naVar.rre);
                        g.this.fv(false);
                        break;
                    case 3:
                        e.C(this.bAj, 5, 0);
                        g.cancelDownload(this.bAj);
                        g.this.fv(false);
                        break;
                    default:
                        h.mEJ.a(860, 19, 1, false);
                        break;
                }
                return 0;
            }
            x.e("MicroMsg.GameSilentDownloader", "Check Error, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            h.mEJ.a(860, 18, 1, false);
            return 0;
        }
    }

    private static class a {
        private static g jOR = new g();
    }

    /* synthetic */ g(byte b) {
        this();
    }

    private g() {
    }

    public final void fv(boolean z) {
        while (true) {
            c cVar;
            f aSl = ((c) com.tencent.mm.kernel.g.l(c.class)).aSl();
            Cursor rawQuery = aSl.rawQuery(String.format("select * from %s where %s=1 limit 1", new Object[]{"GameSilentDownload", "isRunning"}), new String[0]);
            c cVar2;
            if (rawQuery == null) {
                x.i("MicroMsg.GameSilentDownloadStorage", "first cursor is null");
                cVar = null;
            } else if (rawQuery.moveToFirst()) {
                cVar2 = new c();
                cVar2.d(rawQuery);
                rawQuery.close();
                cVar = cVar2;
            } else {
                x.i("MicroMsg.GameSilentDownloadStorage", "no running task");
                rawQuery.close();
                rawQuery = aSl.rawQuery(String.format("select * from %s where %s < ? limit 1", new Object[]{"GameSilentDownload", "nextCheckTime"}), new String[]{String.valueOf(bi.VE())});
                if (rawQuery == null) {
                    x.i("MicroMsg.GameSilentDownloadStorage", "second cursor is null");
                    cVar = null;
                } else if (rawQuery.moveToFirst()) {
                    cVar2 = new c();
                    cVar2.d(rawQuery);
                    rawQuery.close();
                    cVar = cVar2;
                } else {
                    rawQuery.close();
                    x.i("MicroMsg.GameSilentDownloadStorage", "no record");
                    cVar = null;
                }
            }
            if (cVar == null) {
                x.i("MicroMsg.GameSilentDownloader", "silentDownload witch can check is empty!");
                return;
            }
            x.i("MicroMsg.GameSilentDownloader", "[appid:%s] in DB to check download", new Object[]{cVar.field_appId});
            if (cVar.field_expireTime <= bi.VE()) {
                x.i("MicroMsg.GameSilentDownloader", "task expire time, appId:%s", new Object[]{cVar.field_appId});
                e.DB(cVar.field_appId);
                cancelDownload(cVar.field_appId);
                z = false;
            } else if (ao.isWifi(ad.getContext())) {
                ((c) com.tencent.mm.kernel.g.l(c.class)).aSl().DD(cVar.field_appId);
                com.tencent.mm.kernel.g.Ek();
                if (com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
                    ((c) com.tencent.mm.kernel.g.l(c.class)).aSl().DE(cVar.field_appId);
                    if (cVar.field_size <= 0 || f.aM(cVar.field_size)) {
                        ((c) com.tencent.mm.kernel.g.l(c.class)).aSl().DF(cVar.field_appId);
                        x.i("MicroMsg.GameSilentDownloader", "fromBattery：%b", new Object[]{Boolean.valueOf(z)});
                        if (z) {
                            ((c) com.tencent.mm.kernel.g.l(c.class)).aSl().DG(cVar.field_appId);
                        } else {
                            com.tencent.mm.plugin.game.model.a.a.a aUG = a.aUG();
                            x.i("MicroMsg.GameSilentDownloader", "battery isCharging:%b  percent:%f", new Object[]{Boolean.valueOf(aUG.gCp), Float.valueOf(aUG.jOI)});
                            if (aUG.gCp || ((double) aUG.jOI) >= 0.2d) {
                                ((c) com.tencent.mm.kernel.g.l(c.class)).aSl().DG(cVar.field_appId);
                            } else {
                                x.i("MicroMsg.GameSilentDownloader", "battery is low");
                                return;
                            }
                        }
                        com.tencent.mm.bu.a.post(new Runnable() {
                            public final void run() {
                                if (com.tencent.mm.pluginsdk.model.app.g.a(ad.getContext(), com.tencent.mm.pluginsdk.model.app.g.bk(cVar.field_appId, false))) {
                                    x.i("MicroMsg.GameSilentDownloader", "app is installed, appid = %s", new Object[]{cVar.field_appId});
                                    e.C(cVar.field_appId, 4, 0);
                                    ah.A(new 1(this));
                                    return;
                                }
                                ah.A(new 2(this));
                            }
                        });
                        return;
                    }
                    x.i("MicroMsg.GameSilentDownloader", "sdcard dont have enough space");
                    return;
                }
                x.i("MicroMsg.GameSilentDownloader", "sdcard isnt available");
                return;
            } else {
                x.i("MicroMsg.GameSilentDownloader", "NetType is not WIFI");
                return;
            }
        }
    }

    public static void pauseDownload() {
        Cursor rawQuery = ((c) com.tencent.mm.kernel.g.l(c.class)).aSl().rawQuery(String.format("select * from %s", new Object[]{"GameSilentDownload"}), new String[0]);
        List list;
        if (rawQuery == null) {
            x.i("MicroMsg.GameSilentDownloadStorage", "cursor is null");
            list = null;
        } else if (rawQuery.moveToFirst()) {
            list = new ArrayList();
            do {
                c cVar = new c();
                cVar.d(rawQuery);
                list.add(cVar);
            } while (rawQuery.moveToNext());
            rawQuery.close();
            x.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfoList size:%s", new Object[]{Integer.valueOf(list.size())});
        } else {
            rawQuery.close();
            x.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfoList no record");
            list = null;
        }
        if (!bi.cX(list)) {
            for (c cVar2 : list) {
                if (cVar2 != null) {
                    if (cVar2.field_expireTime <= bi.VE()) {
                        x.i("MicroMsg.GameSilentDownloader", "pauseDownload, task expire time, appId:%s", new Object[]{cVar2.field_appId});
                        e.DB(cVar2.field_appId);
                        cancelDownload(cVar2.field_appId);
                    } else {
                        FileDownloadTaskInfo yO = d.aCU().yO(cVar2.field_appId);
                        if (yO != null && yO.id > 0 && yO.status == 1) {
                            long j = yO.id;
                            d.aCU().ibV = true;
                            boolean cn = d.aCU().cn(j);
                            x.i("MicroMsg.GameSilentDownloader", "pauseDownload, appid:%s, ret:%b", new Object[]{yO.appId, Boolean.valueOf(cn)});
                        }
                    }
                }
            }
        }
    }

    static void cancelDownload(String str) {
        if (!bi.oW(str)) {
            c cVar = new c();
            cVar.field_appId = str;
            x.i("MicroMsg.GameSilentDownloader", "remove SilentDownload DB, appid:%s, ret:%b", new Object[]{str, Boolean.valueOf(((c) com.tencent.mm.kernel.g.l(c.class)).aSl().a(cVar, new String[0]))});
            if (((c) com.tencent.mm.kernel.g.l(c.class)).aSl().a(cVar, new String[0])) {
                FileDownloadTaskInfo yO = d.aCU().yO(str);
                if (yO != null && yO.id > 0) {
                    d.aCU().cl(yO.id);
                    x.i("MicroMsg.GameSilentDownloader", "remove download task, appid:%s", new Object[]{yO.appId});
                }
            }
        }
    }
}
