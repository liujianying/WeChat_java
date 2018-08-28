package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dm extends c {
    private static final int cEa = "createtime".hashCode();
    private static final int cMf = "uid".hashCode();
    private static final int cMg = "devicetype".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cvR = "name".hashCode();
    private boolean cDV = true;
    private boolean cMd = true;
    private boolean cMe = true;
    private boolean cvp = true;
    public long field_createtime;
    public String field_devicetype;
    public String field_name;
    public String field_uid;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cMf == hashCode) {
                    this.field_uid = cursor.getString(i);
                    this.cMd = true;
                } else if (cvR == hashCode) {
                    this.field_name = cursor.getString(i);
                } else if (cMg == hashCode) {
                    this.field_devicetype = cursor.getString(i);
                } else if (cEa == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.field_uid == null) {
            this.field_uid = "";
        }
        if (this.cMd) {
            contentValues.put("uid", this.field_uid);
        }
        if (this.field_name == null) {
            this.field_name = "";
        }
        if (this.cvp) {
            contentValues.put("name", this.field_name);
        }
        if (this.field_devicetype == null) {
            this.field_devicetype = "";
        }
        if (this.cMe) {
            contentValues.put("devicetype", this.field_devicetype);
        }
        if (this.cDV) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
