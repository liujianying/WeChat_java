package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dg extends c {
    private static final int cJQ = "reportId".hashCode();
    private static final int cKE = "decryptKey".hashCode();
    private static final int cKc = "pkgMd5".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int cmj = "appVersion".hashCode();
    private boolean cJN = true;
    private boolean cJV = true;
    private boolean cKD = true;
    private boolean cky = true;
    private boolean clM = true;
    public String field_appId;
    public int field_appVersion;
    public String field_decryptKey;
    public String field_pkgMd5;
    public int field_reportId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cmj == hashCode) {
                    this.field_appVersion = cursor.getInt(i);
                } else if (cKE == hashCode) {
                    this.field_decryptKey = cursor.getString(i);
                } else if (cKc == hashCode) {
                    this.field_pkgMd5 = cursor.getString(i);
                } else if (cJQ == hashCode) {
                    this.field_reportId = cursor.getInt(i);
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
        if (this.clM) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.cKD) {
            contentValues.put("decryptKey", this.field_decryptKey);
        }
        if (this.cJV) {
            contentValues.put("pkgMd5", this.field_pkgMd5);
        }
        if (this.cJN) {
            contentValues.put("reportId", Integer.valueOf(this.field_reportId));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
