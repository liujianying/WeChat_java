package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cx extends c {
    private static final int cJx = "cardUserId".hashCode();
    private static final int cJy = "retryCount".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private boolean cJv = true;
    private boolean cJw = true;
    public String field_cardUserId;
    public int field_retryCount;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cJx == hashCode) {
                    this.field_cardUserId = cursor.getString(i);
                    this.cJv = true;
                } else if (cJy == hashCode) {
                    this.field_retryCount = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cJv) {
            contentValues.put("cardUserId", this.field_cardUserId);
        }
        if (this.cJw) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
