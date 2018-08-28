package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ao extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int clv = "versionType".hashCode();
    private static final int ctZ = "extJson".hashCode();
    private boolean cky = true;
    private boolean cls = true;
    private boolean ctY = true;
    public String field_appId;
    public String field_extJson;
    public int field_versionType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (clv == hashCode) {
                    this.field_versionType = cursor.getInt(i);
                } else if (ctZ == hashCode) {
                    this.field_extJson = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.cls) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
        }
        if (this.ctY) {
            contentValues.put("extJson", this.field_extJson);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
