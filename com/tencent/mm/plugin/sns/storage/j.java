package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.g.c.dv;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable$Columns;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public final class j extends dv {
    protected static a dhO;
    public int nJg;

    static {
        a aVar = new a();
        aVar.sKy = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "snsID";
        aVar.sKA.put("snsID", "LONG");
        stringBuilder.append(" snsID LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "parentID";
        aVar.sKA.put("parentID", "LONG");
        stringBuilder.append(" parentID LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "isRead";
        aVar.sKA.put("isRead", "SHORT default '0' ");
        stringBuilder.append(" isRead SHORT default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.sKA.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "talker";
        aVar.sKA.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = DownloadSettingTable$Columns.TYPE;
        aVar.sKA.put(DownloadSettingTable$Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "isSend";
        aVar.sKA.put("isSend", "INTEGER default 'false' ");
        stringBuilder.append(" isSend INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "curActionBuf";
        aVar.sKA.put("curActionBuf", "BLOB");
        stringBuilder.append(" curActionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[8] = "refActionBuf";
        aVar.sKA.put("refActionBuf", "BLOB");
        stringBuilder.append(" refActionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[9] = "commentSvrID";
        aVar.sKA.put("commentSvrID", "LONG");
        stringBuilder.append(" commentSvrID LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = ClientInfoTable$Columns.CLIENTID;
        aVar.sKA.put(ClientInfoTable$Columns.CLIENTID, "TEXT");
        stringBuilder.append(" clientId TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "commentflag";
        aVar.sKA.put("commentflag", "INTEGER");
        stringBuilder.append(" commentflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "isSilence";
        aVar.sKA.put("isSilence", "INTEGER default '0' ");
        stringBuilder.append(" isSilence INTEGER default '0' ");
        aVar.columns[13] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final void d(Cursor cursor) {
        try {
            super.d(cursor);
            this.nJg = (int) this.sKx;
        } catch (Exception e) {
            String message = e.getMessage();
            x.e("MicroMsg.SnsComment", "error " + message);
            if (message != null && message.contains("Unable to convert")) {
                af.byt().bAR();
            }
            throw e;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsComment", e2, "", new Object[0]);
        }
    }

    public final void bAN() {
        this.field_commentflag |= 1;
    }
}
