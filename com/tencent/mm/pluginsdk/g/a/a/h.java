package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.g.a.a.b.b;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class h implements com.tencent.mm.pluginsdk.g.a.c.h {
    h() {
    }

    public final void a(s sVar, int i) {
        if (sVar.field_expireTime != 0 && sVar.field_expireTime <= bi.VE()) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "urlKey(%s) exceed expire time(%d), delete", new Object[]{sVar.field_urlKey, Long.valueOf(sVar.field_expireTime)});
            q ccH = a.ccH();
            String str = sVar.field_urlKey;
            if (ccH.fAQ) {
                ccH.qDu.jy(str);
            }
            com.tencent.mm.pluginsdk.g.a.d.a.Tr(sVar.field_filePath);
            com.tencent.mm.pluginsdk.g.a.d.a.Tr(sVar.field_filePath + ".decompressed");
            com.tencent.mm.pluginsdk.g.a.d.a.Tr(sVar.field_filePath + ".decrypted");
            a.ccH().Tp(sVar.field_urlKey);
        } else if (i == 0) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network unavailable, skip");
        } else if (2 == i && 1 == sVar.field_networkType) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network type = gprs, record network type = wifi, skip this ");
        } else if (sVar.field_deleted) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record(%s), should have been deleted", new Object[]{sVar.field_urlKey});
            com.tencent.mm.pluginsdk.g.a.d.a.Tr(sVar.field_filePath);
            com.tencent.mm.pluginsdk.g.a.d.a.Tr(sVar.field_filePath + ".decompressed");
            com.tencent.mm.pluginsdk.g.a.d.a.Tr(sVar.field_filePath + ".decrypted");
        } else if (!sVar.field_needRetry) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", new Object[]{Integer.valueOf(sVar.field_resType), Integer.valueOf(sVar.field_subType), sVar.field_fileVersion});
        } else if (sVar.field_status == 2) {
            long Io = com.tencent.mm.pluginsdk.g.a.d.a.Io(sVar.field_filePath);
            if (sVar.field_contentLength > Io) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "content-length > fileSize, resume download");
                if (0 == Io) {
                    if (!sVar.field_needRetry) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", new Object[]{Integer.valueOf(sVar.field_resType), Integer.valueOf(sVar.field_subType), sVar.field_fileVersion});
                        return;
                    } else if (1 != i) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "fileSize = 0, completed file may be deleted by user, skip this because it's not wifi");
                        return;
                    } else {
                        for (b bVar : c.ccr().ccp()) {
                            int i2 = sVar.field_resType;
                            i2 = sVar.field_subType;
                            bi.getInt(sVar.field_fileVersion, 0);
                            if (bVar.ccq()) {
                                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "filterNotRetry by %s, resType %d, subType %d, version %s", new Object[]{bVar.getClass().getName(), Integer.valueOf(sVar.field_resType), Integer.valueOf(sVar.field_subType), sVar.field_fileVersion});
                                return;
                            }
                        }
                        sVar.field_fileUpdated = true;
                        c.ccr().f(sVar.field_resType, sVar.field_subType, 0, bi.oV(sVar.field_groupId2).equals("NewXml"));
                        a.ccH().g(sVar);
                    }
                }
                a.ccH().d(c.c(sVar));
            } else if (d(sVar)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 check ok, file download complete, throw event to do decrypt");
                e(sVar);
            } else {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
                a(sVar, 1 == i);
            }
        } else if (sVar.field_status == 1 || sVar.field_status == 0) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "db status: downloading or waiting, db content-length %d", new Object[]{Long.valueOf(sVar.field_contentLength)});
            if (a.ccH().To(sVar.field_urlKey)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "request already in downloading queue");
                return;
            }
            x.d("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "check md5");
            if (d(sVar)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 match, request complete, throw event to do decrypt");
                sVar.field_status = 2;
                sVar.field_contentLength = com.tencent.mm.pluginsdk.g.a.d.a.Io(sVar.field_filePath);
                a.ccH().g(sVar);
                e(sVar);
                return;
            }
            if (0 == com.tencent.mm.pluginsdk.g.a.d.a.Io(sVar.field_filePath)) {
                sVar.field_fileUpdated = true;
                a.ccH().g(sVar);
                c.ccr().f(sVar.field_resType, sVar.field_subType, 0, bi.oV(sVar.field_groupId2).equals("NewXml"));
            }
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 not match,  download");
            a.ccH().d(c.c(sVar));
        } else if (sVar.field_status == 4 || sVar.field_status == 3) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
            sVar.field_status = 0;
            a(sVar, true);
        }
    }

    private static boolean d(s sVar) {
        return bi.oV(g.cu(sVar.field_filePath)).equals(sVar.field_md5);
    }

    private static void a(s sVar, boolean z) {
        a.ccH().Tp(sVar.field_urlKey);
        com.tencent.mm.pluginsdk.g.a.d.a.Tr(sVar.field_filePath);
        com.tencent.mm.pluginsdk.g.a.d.a.Tr(sVar.field_filePath + ".decompressed");
        com.tencent.mm.pluginsdk.g.a.d.a.Tr(sVar.field_filePath + ".decrypted");
        if (2 == sVar.field_status && !z) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "delete completed but invalid file, but forceDL = false, skip this downloading");
        } else if (sVar.field_maxRetryTimes <= 0 || sVar.field_retryTimes > 0) {
            sVar.field_retryTimes--;
            sVar.field_fileUpdated = true;
            a.ccH().g(sVar);
            j.n(sVar.field_reportId, 12);
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "post network task");
            c c = c.c(sVar);
            c.pON = false;
            a.ccH().d(c);
        } else {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip ", new Object[]{Integer.valueOf(sVar.field_maxRetryTimes), Integer.valueOf(sVar.field_retryTimes)});
        }
    }

    private static void e(s sVar) {
        if (sVar.field_fileCompress || sVar.field_fileEncrypt) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "send query and decrypt request");
            c.ccr().b(sVar);
            return;
        }
        c.ccr().d(sVar.field_resType, sVar.field_subType, sVar.field_filePath, bi.getInt(sVar.field_fileVersion, 0));
    }
}
