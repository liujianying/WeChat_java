package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ay extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cmm = "modifyTime".hashCode();
    private static final int cnk = "flag".hashCode();
    private static final int cwG = "prodcutID".hashCode();
    private static final int cwH = "totalCount".hashCode();
    private static final int cwI = "continuCount".hashCode();
    private static final int cwJ = "showTipsTime".hashCode();
    private static final int cwK = "setFlagTime".hashCode();
    private boolean clP = true;
    private boolean cni = true;
    private boolean cwB = true;
    private boolean cwC = true;
    private boolean cwD = true;
    private boolean cwE = true;
    private boolean cwF = true;
    public int field_continuCount;
    public int field_flag;
    public long field_modifyTime;
    public String field_prodcutID;
    public long field_setFlagTime;
    public long field_showTipsTime;
    public int field_totalCount;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cwG == hashCode) {
                    this.field_prodcutID = cursor.getString(i);
                    this.cwB = true;
                } else if (cwH == hashCode) {
                    this.field_totalCount = cursor.getInt(i);
                } else if (cwI == hashCode) {
                    this.field_continuCount = cursor.getInt(i);
                } else if (cnk == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (cmm == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (cwJ == hashCode) {
                    this.field_showTipsTime = cursor.getLong(i);
                } else if (cwK == hashCode) {
                    this.field_setFlagTime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cwB) {
            contentValues.put("prodcutID", this.field_prodcutID);
        }
        if (this.cwC) {
            contentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
        }
        if (this.cwD) {
            contentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
        }
        if (this.cni) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.clP) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.cwE) {
            contentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
        }
        if (this.cwF) {
            contentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
