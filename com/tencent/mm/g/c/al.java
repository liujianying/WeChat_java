package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class al extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ctt = "labelId".hashCode();
    private static final int ctu = "contactName".hashCode();
    private boolean ctr;
    private boolean cts;
    public String field_contactName;
    public String field_labelId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ctt == hashCode) {
                    this.field_labelId = cursor.getString(i);
                } else if (ctu == hashCode) {
                    this.field_contactName = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.ctr) {
            contentValues.put("labelId", this.field_labelId);
        }
        if (this.cts) {
            contentValues.put("contactName", this.field_contactName);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
