package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eb extends c {
    private static final int cPa = "contactLabels".hashCode();
    private static final int cPb = "conDescription".hashCode();
    private static final int cPc = "conPhone".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int csk = "conRemark".hashCode();
    private static final int csu = "encryptUsername".hashCode();
    private boolean cOX = true;
    private boolean cOY = true;
    private boolean cOZ = true;
    private boolean crT = true;
    private boolean csd = true;
    public String field_conDescription;
    public String field_conPhone;
    public String field_conRemark;
    public String field_contactLabels;
    public String field_encryptUsername;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (csu == hashCode) {
                    this.field_encryptUsername = cursor.getString(i);
                    this.csd = true;
                } else if (csk == hashCode) {
                    this.field_conRemark = cursor.getString(i);
                } else if (cPa == hashCode) {
                    this.field_contactLabels = cursor.getString(i);
                } else if (cPb == hashCode) {
                    this.field_conDescription = cursor.getString(i);
                } else if (cPc == hashCode) {
                    this.field_conPhone = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = "";
        }
        if (this.csd) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.field_conRemark == null) {
            this.field_conRemark = "";
        }
        if (this.crT) {
            contentValues.put("conRemark", this.field_conRemark);
        }
        if (this.field_contactLabels == null) {
            this.field_contactLabels = "";
        }
        if (this.cOX) {
            contentValues.put("contactLabels", this.field_contactLabels);
        }
        if (this.field_conDescription == null) {
            this.field_conDescription = "";
        }
        if (this.cOY) {
            contentValues.put("conDescription", this.field_conDescription);
        }
        if (this.field_conPhone == null) {
            this.field_conPhone = "";
        }
        if (this.cOZ) {
            contentValues.put("conPhone", this.field_conPhone);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
