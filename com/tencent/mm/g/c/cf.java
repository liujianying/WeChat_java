package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cf extends c {
    private static final int cDO = "phonenumber".hashCode();
    private static final int cDP = "calltime".hashCode();
    private static final int cDQ = "duration".hashCode();
    private static final int cDR = "addressId".hashCode();
    private static final int cDS = "phoneType".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private boolean cDJ = true;
    private boolean cDK = true;
    private boolean cDL = true;
    private boolean cDM = true;
    private boolean cDN = true;
    private boolean ciS = true;
    public long field_addressId;
    public long field_calltime;
    public long field_duration;
    public int field_phoneType;
    public String field_phonenumber;
    public int field_status;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cDO == hashCode) {
                    this.field_phonenumber = cursor.getString(i);
                } else if (cDP == hashCode) {
                    this.field_calltime = cursor.getLong(i);
                } else if (cDQ == hashCode) {
                    this.field_duration = cursor.getLong(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cDR == hashCode) {
                    this.field_addressId = cursor.getLong(i);
                } else if (cDS == hashCode) {
                    this.field_phoneType = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cDJ) {
            contentValues.put("phonenumber", this.field_phonenumber);
        }
        if (this.cDK) {
            contentValues.put("calltime", Long.valueOf(this.field_calltime));
        }
        if (this.cDL) {
            contentValues.put("duration", Long.valueOf(this.field_duration));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cDM) {
            contentValues.put("addressId", Long.valueOf(this.field_addressId));
        }
        if (this.cDN) {
            contentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
