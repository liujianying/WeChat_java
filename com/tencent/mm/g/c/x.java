package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class x extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cnJ = "brandUserName".hashCode();
    private static final int cov = "userId".hashCode();
    private boolean cnv = true;
    private boolean cou = true;
    public String field_brandUserName;
    public String field_userId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cnJ == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                    this.cnv = true;
                } else if (cov == hashCode) {
                    this.field_userId = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cnv) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.cou) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
