package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cr extends c {
    private static final int cIS = "reqkey".hashCode();
    private static final int cIT = "ack_key".hashCode();
    private static final int cIU = "receive_time".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private boolean cIP = true;
    private boolean cIQ = true;
    private boolean cIR = true;
    private boolean ciS = true;
    public String field_ack_key;
    public long field_receive_time;
    public String field_reqkey;
    public int field_status;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cIS == hashCode) {
                    this.field_reqkey = cursor.getString(i);
                    this.cIP = true;
                } else if (cIT == hashCode) {
                    this.field_ack_key = cursor.getString(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cIU == hashCode) {
                    this.field_receive_time = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cIP) {
            contentValues.put("reqkey", this.field_reqkey);
        }
        if (this.cIQ) {
            contentValues.put("ack_key", this.field_ack_key);
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cIR) {
            contentValues.put("receive_time", Long.valueOf(this.field_receive_time));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
