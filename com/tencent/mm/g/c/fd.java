package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fd extends c {
    private static final int cFO = "appIdHash".hashCode();
    private static final int cVw = "openDebug".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private boolean cFJ = true;
    private boolean cVv = true;
    private boolean cky = true;
    public String field_appId;
    public int field_appIdHash;
    public boolean field_openDebug;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cFO == hashCode) {
                    this.field_appIdHash = cursor.getInt(i);
                    this.cFJ = true;
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cVw == hashCode) {
                    this.field_openDebug = cursor.getInt(i) != 0;
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cFJ) {
            contentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.cVv) {
            contentValues.put("openDebug", Boolean.valueOf(this.field_openDebug));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
