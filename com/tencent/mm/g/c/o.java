package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class o extends c {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)"};
    private static final int ciP = "rowid".hashCode();
    private static final int cjj = "startTime".hashCode();
    private static final int cjk = "endTime".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int clC = "version".hashCode();
    private static final int clD = "versionMd5".hashCode();
    private static final int clE = "versionState".hashCode();
    private static final int clF = "pkgPath".hashCode();
    private static final int clG = "debugType".hashCode();
    private static final int clH = "downloadURL".hashCode();
    private boolean cjF = true;
    private boolean cjb = true;
    private boolean cjc = true;
    private boolean cky = true;
    private boolean clA = true;
    private boolean clB = true;
    private boolean clw = true;
    private boolean clx = true;
    private boolean cly = true;
    private boolean clz = true;
    public String field_appId;
    public long field_createTime;
    public int field_debugType;
    public String field_downloadURL;
    public long field_endTime;
    public String field_pkgPath;
    public long field_startTime;
    public int field_version;
    public String field_versionMd5;
    public int field_versionState;

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
                } else if (clD == hashCode) {
                    this.field_versionMd5 = cursor.getString(i);
                } else if (clE == hashCode) {
                    this.field_versionState = cursor.getInt(i);
                } else if (clF == hashCode) {
                    this.field_pkgPath = cursor.getString(i);
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (clG == hashCode) {
                    this.field_debugType = cursor.getInt(i);
                } else if (clH == hashCode) {
                    this.field_downloadURL = cursor.getString(i);
                } else if (cjj == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (cjk == hashCode) {
                    this.field_endTime = cursor.getLong(i);
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
        if (this.clx) {
            contentValues.put("versionMd5", this.field_versionMd5);
        }
        if (this.cly) {
            contentValues.put("versionState", Integer.valueOf(this.field_versionState));
        }
        if (this.clz) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.clA) {
            contentValues.put("debugType", Integer.valueOf(this.field_debugType));
        }
        if (this.clB) {
            contentValues.put("downloadURL", this.field_downloadURL);
        }
        if (this.cjb) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.cjc) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
