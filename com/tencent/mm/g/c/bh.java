package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class bh extends c {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS FavSearchInfo_Content_Index ON FavSearchInfo(content)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_TagContent_Index ON FavSearchInfo(tagContent)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_SubType_Index ON FavSearchInfo(subtype)"};
    private static final int ciP = "rowid".hashCode();
    private static final int cke = "type".hashCode();
    private static final int ckj = "content".hashCode();
    private static final int cqB = "time".hashCode();
    private static final int cxT = "localId".hashCode();
    private static final int cyA = "subtype".hashCode();
    private static final int cyz = "tagContent".hashCode();
    private boolean cjI = true;
    private boolean cjN = true;
    private boolean cqi = true;
    private boolean cxR = true;
    private boolean cyx = true;
    private boolean cyy = true;
    public String field_content;
    public long field_localId;
    public int field_subtype;
    public String field_tagContent;
    public long field_time;
    public int field_type;

    public static a wI() {
        a aVar = new a();
        aVar.sKy = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.sKA.put("localId", "LONG PRIMARY KEY ");
        stringBuilder.append(" localId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "localId";
        aVar.columns[1] = "content";
        aVar.sKA.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "tagContent";
        aVar.sKA.put("tagContent", "TEXT");
        stringBuilder.append(" tagContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "time";
        aVar.sKA.put("time", "LONG");
        stringBuilder.append(" time LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "type";
        aVar.sKA.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "subtype";
        aVar.sKA.put("subtype", "INTEGER default '0' ");
        stringBuilder.append(" subtype INTEGER default '0' ");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cxT == hashCode) {
                    this.field_localId = cursor.getLong(i);
                    this.cxR = true;
                } else if (ckj == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (cyz == hashCode) {
                    this.field_tagContent = cursor.getString(i);
                } else if (cqB == hashCode) {
                    this.field_time = cursor.getLong(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (cyA == hashCode) {
                    this.field_subtype = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cxR) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.cjN) {
            contentValues.put("content", this.field_content);
        }
        if (this.cyx) {
            contentValues.put("tagContent", this.field_tagContent);
        }
        if (this.cqi) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.cyy) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
