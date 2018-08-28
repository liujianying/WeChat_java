package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bs extends c {
    private static final int cBA = "cache".hashCode();
    private static final int cBz = "reqType".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private boolean cBx = true;
    private boolean cBy = true;
    public byte[] field_cache;
    public String field_reqType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cBz == hashCode) {
                    this.field_reqType = cursor.getString(i);
                    this.cBx = true;
                } else if (cBA == hashCode) {
                    this.field_cache = cursor.getBlob(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cBx) {
            contentValues.put("reqType", this.field_reqType);
        }
        if (this.cBy) {
            contentValues.put("cache", this.field_cache);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
