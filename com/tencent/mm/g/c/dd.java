package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class dd extends c {
    private static final int cKc = "pkgMd5".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int cke = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int clC = "version".hashCode();
    private static final int clF = "pkgPath".hashCode();
    private boolean cJV = true;
    private boolean cjI = true;
    private boolean cky = true;
    private boolean clw = true;
    private boolean clz = true;
    public String field_appId;
    public String field_pkgMd5;
    public String field_pkgPath;
    public int field_type;
    public int field_version;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (clC == hashCode) {
                    this.field_version = cursor.getInt(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (cKc == hashCode) {
                    this.field_pkgMd5 = cursor.getString(i);
                } else if (clF == hashCode) {
                    this.field_pkgPath = cursor.getString(i);
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
        if (this.clw) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.cjI) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.cJV) {
            contentValues.put("pkgMd5", this.field_pkgMd5);
        }
        if (this.clz) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
