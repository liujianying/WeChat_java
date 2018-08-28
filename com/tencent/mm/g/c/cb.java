package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cb extends c {
    public static final String[] ciG = new String[0];
    private static final int ciL = "payMsgId".hashCode();
    private static final int ciO = "msgId".hashCode();
    private static final int ciP = "rowid".hashCode();
    private boolean ciH = true;
    private boolean ciK = true;
    public long field_msgId;
    public String field_payMsgId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ciL == hashCode) {
                    this.field_payMsgId = cursor.getString(i);
                    this.ciH = true;
                } else if (ciO == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.ciH) {
            contentValues.put("payMsgId", this.field_payMsgId);
        }
        if (this.ciK) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
