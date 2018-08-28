package com.tencent.mm.storage;

import com.tencent.mm.g.c.ac;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class q extends ac {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.sKA.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "msgId";
        aVar.columns[1] = "msgSvrId";
        aVar.sKA.put("msgSvrId", "LONG");
        stringBuilder.append(" msgSvrId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "type";
        aVar.sKA.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "status";
        aVar.sKA.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "createTime";
        aVar.sKA.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "talker";
        aVar.sKA.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "content";
        aVar.sKA.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "imgPath";
        aVar.sKA.put("imgPath", "TEXT");
        stringBuilder.append(" imgPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "lvbuffer";
        aVar.sKA.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        aVar.columns[9] = "talkerId";
        aVar.sKA.put("talkerId", "INTEGER");
        stringBuilder.append(" talkerId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "isExpand";
        aVar.sKA.put("isExpand", "INTEGER");
        stringBuilder.append(" isExpand INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "orderFlag";
        aVar.sKA.put("orderFlag", "LONG default '0' ");
        stringBuilder.append(" orderFlag LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "hasShow";
        aVar.sKA.put("hasShow", "INTEGER default '1' ");
        stringBuilder.append(" hasShow INTEGER default '1' ");
        aVar.columns[13] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final long ckx() {
        return (this.field_orderFlag & -4294967296L) >> 32;
    }

    public final boolean cky() {
        return this.field_type == 285212721;
    }

    public final boolean ckz() {
        return this.field_type == 34;
    }

    public final boolean ckA() {
        switch (this.field_type) {
            case 3:
            case 13:
            case 23:
            case i$l.AppCompatTheme_actionModeCopyDrawable /*33*/:
            case i$l.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                return true;
            default:
                return false;
        }
    }

    public final boolean isText() {
        switch (this.field_type) {
            case 1:
            case 11:
            case 21:
            case i$l.AppCompatTheme_actionModeCloseDrawable /*31*/:
            case i$l.AppCompatTheme_actionModeShareDrawable /*36*/:
                return true;
            default:
                return false;
        }
    }
}
