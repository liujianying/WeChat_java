package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.g.c.h;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public final class b extends h {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "sdkVer";
        aVar.sKA.put("sdkVer", "LONG");
        stringBuilder.append(" sdkVer LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "mediaSvrId";
        aVar.sKA.put("mediaSvrId", "TEXT");
        stringBuilder.append(" mediaSvrId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "mediaId";
        aVar.sKA.put("mediaId", "TEXT");
        stringBuilder.append(" mediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "clientAppDataId";
        aVar.sKA.put("clientAppDataId", "TEXT");
        stringBuilder.append(" clientAppDataId TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = DownloadSettingTable$Columns.TYPE;
        aVar.sKA.put(DownloadSettingTable$Columns.TYPE, "LONG");
        stringBuilder.append(" type LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "totalLen";
        aVar.sKA.put("totalLen", "LONG");
        stringBuilder.append(" totalLen LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "offset";
        aVar.sKA.put("offset", "LONG");
        stringBuilder.append(" offset LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = DownloadInfo.STATUS;
        aVar.sKA.put(DownloadInfo.STATUS, "LONG");
        stringBuilder.append(" status LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "isUpload";
        aVar.sKA.put("isUpload", "INTEGER");
        stringBuilder.append(" isUpload INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "createTime";
        aVar.sKA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "lastModifyTime";
        aVar.sKA.put("lastModifyTime", "LONG");
        stringBuilder.append(" lastModifyTime LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "fileFullPath";
        aVar.sKA.put("fileFullPath", "TEXT");
        stringBuilder.append(" fileFullPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "fullXml";
        aVar.sKA.put("fullXml", "TEXT");
        stringBuilder.append(" fullXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "msgInfoId";
        aVar.sKA.put("msgInfoId", "LONG");
        stringBuilder.append(" msgInfoId LONG");
        stringBuilder.append(", ");
        aVar.columns[15] = "netTimes";
        aVar.sKA.put("netTimes", "LONG");
        stringBuilder.append(" netTimes LONG");
        stringBuilder.append(", ");
        aVar.columns[16] = "isUseCdn";
        aVar.sKA.put("isUseCdn", "INTEGER");
        stringBuilder.append(" isUseCdn INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "signature";
        aVar.sKA.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "fakeAeskey";
        aVar.sKA.put("fakeAeskey", "TEXT");
        stringBuilder.append(" fakeAeskey TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "fakeSignature";
        aVar.sKA.put("fakeSignature", "TEXT");
        stringBuilder.append(" fakeSignature TEXT");
        aVar.columns[20] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public b() {
        this.field_netTimes = 0;
    }

    public final boolean aSc() {
        if (this.field_totalLen > 0 && this.field_offset == this.field_totalLen) {
            return true;
        }
        return false;
    }
}
