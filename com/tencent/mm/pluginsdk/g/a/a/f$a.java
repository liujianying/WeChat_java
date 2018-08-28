package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class f$a {
    static void a(s sVar, g gVar) {
        if (sVar == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null");
        } else {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", sVar.field_urlKey, sVar.field_url, Long.valueOf(sVar.field_contentLength), Boolean.valueOf(sVar.field_deleted), sVar.field_eccSignature, Long.valueOf(sVar.field_expireTime), Boolean.valueOf(sVar.field_fileCompress), Boolean.valueOf(sVar.field_fileEncrypt), sVar.field_filePath, Boolean.valueOf(sVar.field_fileUpdated), sVar.field_fileVersion, sVar.field_groupId2, Integer.valueOf(sVar.field_keyVersion), Boolean.valueOf(bi.oW(sVar.field_encryptKey)), Integer.valueOf(sVar.field_maxRetryTimes), Integer.valueOf(sVar.field_retryTimes), sVar.field_sampleId, Integer.valueOf(sVar.field_status));
            x.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", sVar.field_encryptKey);
        }
        s cct;
        if (sVar != null && sVar.field_deleted && gVar.Th(sVar.field_fileVersion) <= 0) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", sVar.field_fileVersion, gVar.qCR);
        } else if (sVar == null) {
            cct = gVar.cct();
            cct.field_fileUpdated = true;
            cct.field_needRetry = true;
            if (bi.oW(cct.field_encryptKey)) {
                cct.field_keyVersion = -1;
            }
            x.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record " + cct);
            a.ccH().g(cct);
            c.ccr().f(gVar.bIC, gVar.bID, 0, gVar.bIJ);
            a(true, true, cct, gVar);
        } else {
            x.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
            sVar.field_networkType = gVar.networkType;
            if (bi.oW(sVar.field_originalMd5)) {
                sVar.field_originalMd5 = gVar.qBE;
            }
            if (gVar.Th(sVar.field_fileVersion) > 0) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
                cct = gVar.cct();
                if (sVar.field_keyVersion >= gVar.qBC) {
                    cct.field_keyVersion = sVar.field_keyVersion;
                    cct.field_encryptKey = sVar.field_encryptKey;
                }
                cct.field_fileUpdated = true;
                cct.field_needRetry = true;
                cct.field_deleted = false;
                a.ccH().g(cct);
                c.ccr().f(gVar.bIC, gVar.bID, 0, gVar.bIJ);
                a.ccH().Tp(gVar.qBy);
                a(false, true, cct, gVar);
            } else if (gVar.Th(sVar.field_fileVersion) == 0 && !sVar.field_needRetry) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", Integer.valueOf(sVar.field_resType), Integer.valueOf(sVar.field_subType), sVar.field_fileVersion);
            } else if (sVar.field_status == 2 || sVar.field_status == 1 || sVar.field_status == 0) {
                long Io = com.tencent.mm.pluginsdk.g.a.d.a.Io(sVar.field_filePath);
                if (sVar.field_contentLength > Io) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", Long.valueOf(sVar.field_contentLength), Long.valueOf(Io));
                    if (0 == Io) {
                        c.ccr().f(gVar.bIC, gVar.bID, 0, gVar.bIJ);
                        a(false, true, sVar, gVar);
                        return;
                    }
                    a(true, false, sVar, gVar);
                } else if (bi.oV(g.cu(i.Ti(gVar.qBy))).equals(sVar.field_md5)) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt %s", sVar.field_urlKey);
                    sVar.field_status = 2;
                    sVar.field_contentLength = com.tencent.mm.pluginsdk.g.a.d.a.Io(sVar.field_filePath);
                    sVar.field_fileUpdated = false;
                    sVar.field_reportId = gVar.qBG;
                    a.ccH().g(sVar);
                    j.n(sVar.field_reportId, 13);
                    j.n(sVar.field_reportId, 44);
                    j.a(sVar.field_resType, sVar.field_subType, sVar.field_url, bi.getInt(sVar.field_fileVersion, 0), j.a.qCA, true, "NewXml".equalsIgnoreCase(sVar.field_groupId2), true, sVar.field_sampleId);
                    if (gVar.qCf || gVar.qCg) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request %s", gVar.qBy);
                        f$b.a(sVar, false, false);
                        return;
                    }
                    c.ccr().d(gVar.bIC, gVar.bID, i.Ti(gVar.qBy), bi.getInt(gVar.qCR, 0));
                } else {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
                    a(false, true, sVar, gVar);
                }
            } else if (sVar.field_status == 4 || sVar.field_status == 3) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download %s", sVar.field_urlKey);
                a(false, true, sVar, gVar);
            }
        }
    }

    private static void a(boolean z, boolean z2, s sVar, g gVar) {
        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (sVar.field_maxRetryTimes <= 0 || sVar.field_retryTimes > 0 || z2) {
            sVar.field_reportId = gVar.qBG;
            sVar.field_status = 0;
            if (z2) {
                sVar.field_maxRetryTimes = gVar.qBI;
                sVar.field_retryTimes = gVar.qBI;
                sVar.field_fileUpdated = true;
                sVar.field_priority = gVar.priority;
                if (gVar.fileSize > 0) {
                    sVar.field_fileSize = gVar.fileSize;
                }
                a.ccH().g(sVar);
            } else {
                sVar.field_retryTimes--;
                sVar.field_priority = gVar.priority;
                a.ccH().g(sVar);
                j.n(sVar.field_reportId, 12);
            }
            if (a.ccH().To(gVar.qBy)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", gVar.qBy);
                if (gVar.bIJ) {
                    j.n(gVar.qBG, 9);
                    j.n(gVar.qBG, 44);
                    return;
                }
                return;
            }
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", gVar.qBy);
            if (z2 && !z) {
                c.ccr().f(sVar.field_resType, sVar.field_subType, 0, bi.oV(sVar.field_groupId2).equals("NewXml"));
            }
            c c = c.c(sVar);
            c.pON = z;
            c.qCe = gVar.qCe;
            if (!z) {
                com.tencent.mm.pluginsdk.g.a.d.a.Tr(i.Ti(c.qBy));
                com.tencent.mm.pluginsdk.g.a.d.a.Tr(i.Ti(c.qBy) + ".decompressed");
                com.tencent.mm.pluginsdk.g.a.d.a.Tr(i.Ti(c.qBy) + ".decrypted");
            }
            a.ccH().d(c);
            return;
        }
        x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", Integer.valueOf(sVar.field_maxRetryTimes), Integer.valueOf(sVar.field_retryTimes));
    }
}
