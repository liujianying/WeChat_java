package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.g.c.dk;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class s extends dk {
    public static final a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[34];
        aVar.columns = new String[35];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "urlKey_hashcode";
        aVar.sKA.put("urlKey_hashcode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" urlKey_hashcode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "urlKey_hashcode";
        aVar.columns[1] = "urlKey";
        aVar.sKA.put("urlKey", "TEXT");
        stringBuilder.append(" urlKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL;
        aVar.sKA.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "fileVersion";
        aVar.sKA.put("fileVersion", "TEXT");
        stringBuilder.append(" fileVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "networkType";
        aVar.sKA.put("networkType", "INTEGER default '2' ");
        stringBuilder.append(" networkType INTEGER default '2' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "maxRetryTimes";
        aVar.sKA.put("maxRetryTimes", "INTEGER default '3' ");
        stringBuilder.append(" maxRetryTimes INTEGER default '3' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "retryTimes";
        aVar.sKA.put("retryTimes", "INTEGER default '3' ");
        stringBuilder.append(" retryTimes INTEGER default '3' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "filePath";
        aVar.sKA.put("filePath", "TEXT");
        stringBuilder.append(" filePath TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = DownloadInfo.STATUS;
        aVar.sKA.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "contentLength";
        aVar.sKA.put("contentLength", "LONG default '0' ");
        stringBuilder.append(" contentLength LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = DownloadInfo.CONTENTTYPE;
        aVar.sKA.put(DownloadInfo.CONTENTTYPE, "TEXT");
        stringBuilder.append(" contentType TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "expireTime";
        aVar.sKA.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "md5";
        aVar.sKA.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "groupId1";
        aVar.sKA.put("groupId1", "TEXT");
        stringBuilder.append(" groupId1 TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "groupId2";
        aVar.sKA.put("groupId2", "TEXT");
        stringBuilder.append(" groupId2 TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = DownloadInfo.PRIORITY;
        aVar.sKA.put(DownloadInfo.PRIORITY, "INTEGER default '0' ");
        stringBuilder.append(" priority INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "fileUpdated";
        aVar.sKA.put("fileUpdated", "INTEGER");
        stringBuilder.append(" fileUpdated INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "deleted";
        aVar.sKA.put("deleted", "INTEGER default 'false' ");
        stringBuilder.append(" deleted INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "resType";
        aVar.sKA.put("resType", "INTEGER");
        stringBuilder.append(" resType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "subType";
        aVar.sKA.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[20] = "reportId";
        aVar.sKA.put("reportId", "LONG");
        stringBuilder.append(" reportId LONG");
        stringBuilder.append(", ");
        aVar.columns[21] = "sampleId";
        aVar.sKA.put("sampleId", "TEXT");
        stringBuilder.append(" sampleId TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "eccSignature";
        aVar.sKA.put("eccSignature", "BLOB");
        stringBuilder.append(" eccSignature BLOB");
        stringBuilder.append(", ");
        aVar.columns[23] = "originalMd5";
        aVar.sKA.put("originalMd5", "TEXT");
        stringBuilder.append(" originalMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "fileCompress";
        aVar.sKA.put("fileCompress", "INTEGER default 'false' ");
        stringBuilder.append(" fileCompress INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[25] = "fileEncrypt";
        aVar.sKA.put("fileEncrypt", "INTEGER default 'false' ");
        stringBuilder.append(" fileEncrypt INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[26] = "encryptKey";
        aVar.sKA.put("encryptKey", "TEXT");
        stringBuilder.append(" encryptKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[27] = "keyVersion";
        aVar.sKA.put("keyVersion", "INTEGER default '0' ");
        stringBuilder.append(" keyVersion INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[28] = "EID";
        aVar.sKA.put("EID", "INTEGER");
        stringBuilder.append(" EID INTEGER");
        stringBuilder.append(", ");
        aVar.columns[29] = "fileSize";
        aVar.sKA.put("fileSize", "LONG");
        stringBuilder.append(" fileSize LONG");
        stringBuilder.append(", ");
        aVar.columns[30] = "needRetry";
        aVar.sKA.put("needRetry", "INTEGER default '1' ");
        stringBuilder.append(" needRetry INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[31] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "wvCacheType";
        aVar.sKA.put("wvCacheType", "INTEGER");
        stringBuilder.append(" wvCacheType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[33] = "packageId";
        aVar.sKA.put("packageId", "TEXT");
        stringBuilder.append(" packageId TEXT");
        aVar.columns[34] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ResDownloaderRecord {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ResDownloaderRecord", e, "", new Object[0]);
        }
        try {
            Field field2 = getClass().getSuperclass().getSuperclass().getField("systemRowid");
            field2.setAccessible(true);
            stringBuilder.append("systemRowid = ").append(field2.get(this));
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.ResDownloaderRecord", e2, "", new Object[0]);
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.ResDownloaderRecord", e22, "", new Object[0]);
        }
        return stringBuilder.append(" }").toString();
    }

    protected final a AX() {
        return dhO;
    }
}
