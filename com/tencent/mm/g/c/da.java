package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class da extends c {
    private static final int cJJ = "hit".hashCode();
    private static final int cJK = "hitTimeMS".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int cke = "type".hashCode();
    private boolean cJH = true;
    private boolean cJI = true;
    private boolean cjI = true;
    private boolean cky = true;
    public String field_appId;
    public int field_hit;
    public long field_hitTimeMS;
    public int field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (cJJ == hashCode) {
                    this.field_hit = cursor.getInt(i);
                } else if (cJK == hashCode) {
                    this.field_hitTimeMS = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.cJH) {
            contentValues.put("hit", Integer.valueOf(this.field_hit));
        }
        if (this.cJI) {
            contentValues.put("hitTimeMS", Long.valueOf(this.field_hitTimeMS));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
