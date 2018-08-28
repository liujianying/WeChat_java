package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class em extends c {
    private static final int cBe = "receiveTime".hashCode();
    private static final int cKW = "receiveStatus".hashCode();
    private static final int cRZ = "mNativeUrl".hashCode();
    private static final int cSa = "hbType".hashCode();
    private static final int cSb = "receiveAmount".hashCode();
    private static final int cSc = "hbStatus".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private boolean cAV = true;
    private boolean cKU = true;
    private boolean cRV = true;
    private boolean cRW = true;
    private boolean cRX = true;
    private boolean cRY = true;
    public int field_hbStatus;
    public int field_hbType;
    public String field_mNativeUrl;
    public long field_receiveAmount;
    public int field_receiveStatus;
    public long field_receiveTime;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cRZ == hashCode) {
                    this.field_mNativeUrl = cursor.getString(i);
                    this.cRV = true;
                } else if (cSa == hashCode) {
                    this.field_hbType = cursor.getInt(i);
                } else if (cSb == hashCode) {
                    this.field_receiveAmount = cursor.getLong(i);
                } else if (cBe == hashCode) {
                    this.field_receiveTime = cursor.getLong(i);
                } else if (cKW == hashCode) {
                    this.field_receiveStatus = cursor.getInt(i);
                } else if (cSc == hashCode) {
                    this.field_hbStatus = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cRV) {
            contentValues.put("mNativeUrl", this.field_mNativeUrl);
        }
        if (this.cRW) {
            contentValues.put("hbType", Integer.valueOf(this.field_hbType));
        }
        if (this.cRX) {
            contentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
        }
        if (this.cAV) {
            contentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
        }
        if (this.cKU) {
            contentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
        }
        if (this.cRY) {
            contentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
