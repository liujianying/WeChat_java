package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class r extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int cnk = "flag".hashCode();
    private static final int cnl = "sortId".hashCode();
    private boolean cky = true;
    private boolean cni = true;
    private boolean cnj = true;
    public String field_appId;
    public long field_flag;
    public int field_sortId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cnk == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cnl == hashCode) {
                    this.field_sortId = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cni) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.cnj) {
            contentValues.put("sortId", Integer.valueOf(this.field_sortId));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
