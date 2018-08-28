package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dj extends c {
    private static final int cKV = "locaMsgId".hashCode();
    private static final int cKW = "receiveStatus".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cnT = "isSend".hashCode();
    private static final int ctX = "transferId".hashCode();
    private boolean cKT = true;
    private boolean cKU = true;
    private boolean cnF = true;
    private boolean ctW = true;
    public boolean field_isSend;
    public long field_locaMsgId;
    public int field_receiveStatus;
    public String field_transferId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ctX == hashCode) {
                    this.field_transferId = cursor.getString(i);
                    this.ctW = true;
                } else if (cKV == hashCode) {
                    this.field_locaMsgId = cursor.getLong(i);
                } else if (cKW == hashCode) {
                    this.field_receiveStatus = cursor.getInt(i);
                } else if (cnT == hashCode) {
                    this.field_isSend = cursor.getInt(i) != 0;
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.ctW) {
            contentValues.put("transferId", this.field_transferId);
        }
        if (this.cKT) {
            contentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
        }
        if (this.cKU) {
            contentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
        }
        if (this.cnF) {
            contentValues.put("isSend", Boolean.valueOf(this.field_isSend));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
