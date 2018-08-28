package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ex extends c {
    private static final int cUg = "pkgId".hashCode();
    private static final int cUh = "rid".hashCode();
    private static final int cUi = "mimeType".hashCode();
    private static final int cUj = "downloadNetType".hashCode();
    private static final int cUk = "completeDownload".hashCode();
    private static final int cUl = "autoDownloadCount".hashCode();
    private static final int cUm = "fileDownloadCount".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjy = "key".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int clC = "version".hashCode();
    private static final int clp = "size".hashCode();
    private static final int cvM = "md5".hashCode();
    private static final int czr = "downloadUrl".hashCode();
    private static final int czv = "filePath".hashCode();
    private boolean cTZ = true;
    private boolean cUa = true;
    private boolean cUb = true;
    private boolean cUc = true;
    private boolean cUd = true;
    private boolean cUe = true;
    private boolean cUf = true;
    private boolean cjF = true;
    private boolean cju = true;
    private boolean clm = true;
    private boolean clw = true;
    private boolean cvk = true;
    private boolean cyW = true;
    private boolean cza = true;
    public int field_autoDownloadCount;
    public boolean field_completeDownload;
    public long field_createTime;
    public int field_downloadNetType;
    public String field_downloadUrl;
    public int field_fileDownloadCount;
    public String field_filePath;
    public String field_key;
    public String field_md5;
    public String field_mimeType;
    public String field_pkgId;
    public String field_rid;
    public int field_size;
    public String field_version;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cjy == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.cju = true;
                } else if (cUg == hashCode) {
                    this.field_pkgId = cursor.getString(i);
                } else if (clC == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (czv == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (cUh == hashCode) {
                    this.field_rid = cursor.getString(i);
                } else if (cUi == hashCode) {
                    this.field_mimeType = cursor.getString(i);
                } else if (cvM == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (czr == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (clp == hashCode) {
                    this.field_size = cursor.getInt(i);
                } else if (cUj == hashCode) {
                    this.field_downloadNetType = cursor.getInt(i);
                } else if (cUk == hashCode) {
                    this.field_completeDownload = cursor.getInt(i) != 0;
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (cUl == hashCode) {
                    this.field_autoDownloadCount = cursor.getInt(i);
                } else if (cUm == hashCode) {
                    this.field_fileDownloadCount = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cju) {
            contentValues.put("key", this.field_key);
        }
        if (this.cTZ) {
            contentValues.put("pkgId", this.field_pkgId);
        }
        if (this.clw) {
            contentValues.put("version", this.field_version);
        }
        if (this.cza) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.cUa) {
            contentValues.put("rid", this.field_rid);
        }
        if (this.cUb) {
            contentValues.put("mimeType", this.field_mimeType);
        }
        if (this.cvk) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.cyW) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.clm) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.cUc) {
            contentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
        }
        if (this.cUd) {
            contentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.cUe) {
            contentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
        }
        if (this.cUf) {
            contentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
