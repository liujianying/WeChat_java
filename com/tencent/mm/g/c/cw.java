package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cw extends c {
    private static final int cBa = "isRead".hashCode();
    private static final int cJu = "msgContentXml".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciO = "msgId".hashCode();
    private static final int ciP = "rowid".hashCode();
    private boolean cAR = true;
    private boolean cJt = true;
    private boolean ciK = true;
    public String field_isRead;
    public String field_msgContentXml;
    public String field_msgId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ciO == hashCode) {
                    this.field_msgId = cursor.getString(i);
                    this.ciK = true;
                } else if (cJu == hashCode) {
                    this.field_msgContentXml = cursor.getString(i);
                } else if (cBa == hashCode) {
                    this.field_isRead = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.ciK) {
            contentValues.put("msgId", this.field_msgId);
        }
        if (this.cJt) {
            contentValues.put("msgContentXml", this.field_msgContentXml);
        }
        if (this.cAR) {
            contentValues.put("isRead", this.field_isRead);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
