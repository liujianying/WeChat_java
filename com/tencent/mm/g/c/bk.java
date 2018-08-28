package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bk extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjf = "value".hashCode();
    private static final int cjy = "key".hashCode();
    private static final int cmm = "modifyTime".hashCode();
    private boolean ciX = true;
    private boolean cju = true;
    private boolean clP = true;
    public String field_key;
    public long field_modifyTime;
    public String field_value;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cjy == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.cju = true;
                } else if (cjf == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (cmm == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cju) {
            contentValues.put("key", this.field_key);
        }
        if (this.ciX) {
            contentValues.put("value", this.field_value);
        }
        if (this.clP) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
