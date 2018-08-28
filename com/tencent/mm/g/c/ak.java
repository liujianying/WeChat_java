package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ak extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int ctm = "labelID".hashCode();
    private static final int ctn = "labelName".hashCode();
    private static final int cto = "labelPYFull".hashCode();
    private static final int ctp = "labelPYShort".hashCode();
    private static final int ctq = "isTemporary".hashCode();
    private boolean cjF = true;
    private boolean cth = true;
    private boolean cti = true;
    private boolean ctj = true;
    private boolean ctk = true;
    private boolean ctl = true;
    public long field_createTime;
    public boolean field_isTemporary;
    public int field_labelID;
    public String field_labelName;
    public String field_labelPYFull;
    public String field_labelPYShort;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ctm == hashCode) {
                    this.field_labelID = cursor.getInt(i);
                    this.cth = true;
                } else if (ctn == hashCode) {
                    this.field_labelName = cursor.getString(i);
                } else if (cto == hashCode) {
                    this.field_labelPYFull = cursor.getString(i);
                } else if (ctp == hashCode) {
                    this.field_labelPYShort = cursor.getString(i);
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (ctq == hashCode) {
                    this.field_isTemporary = cursor.getInt(i) != 0;
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cth) {
            contentValues.put("labelID", Integer.valueOf(this.field_labelID));
        }
        if (this.cti) {
            contentValues.put("labelName", this.field_labelName);
        }
        if (this.ctj) {
            contentValues.put("labelPYFull", this.field_labelPYFull);
        }
        if (this.ctk) {
            contentValues.put("labelPYShort", this.field_labelPYShort);
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.ctl) {
            contentValues.put("isTemporary", Boolean.valueOf(this.field_isTemporary));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
