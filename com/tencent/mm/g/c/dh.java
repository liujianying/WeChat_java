package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dh extends c {
    private static final int cKJ = "recordLocalId".hashCode();
    private static final int cKK = "isThumb".hashCode();
    private static final int cKL = "tpaeskey".hashCode();
    private static final int cKM = "tpdataurl".hashCode();
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)"};
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int ckS = "mediaId".hashCode();
    private static final int ckU = "totalLen".hashCode();
    private static final int ckV = "offset".hashCode();
    private static final int cke = "type".hashCode();
    private static final int cwd = "cdnUrl".hashCode();
    private static final int cwm = "tpauthkey".hashCode();
    private static final int cxJ = "dataId".hashCode();
    private static final int cxL = "cdnKey".hashCode();
    private static final int cxM = "path".hashCode();
    private static final int cxT = "localId".hashCode();
    private static final int cyp = "toUser".hashCode();
    private static final int czG = "errCode".hashCode();
    private static final int czw = "fileType".hashCode();
    private boolean cKF = true;
    private boolean cKG = true;
    private boolean cKH = true;
    private boolean cKI = true;
    private boolean ciS = true;
    private boolean cjI = true;
    private boolean ckB = true;
    private boolean ckD = true;
    private boolean ckE = true;
    private boolean cvC = true;
    private boolean cvL = true;
    private boolean cxD = true;
    private boolean cxF = true;
    private boolean cxG = true;
    private boolean cxR = true;
    private boolean cyb = true;
    private boolean czb = true;
    private boolean czl = true;
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_errCode;
    public int field_fileType;
    public boolean field_isThumb;
    public int field_localId;
    public String field_mediaId;
    public int field_offset;
    public String field_path;
    public int field_recordLocalId;
    public int field_status;
    public String field_toUser;
    public int field_totalLen;
    public String field_tpaeskey;
    public String field_tpauthkey;
    public String field_tpdataurl;
    public int field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cxT == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.cxR = true;
                } else if (cKJ == hashCode) {
                    this.field_recordLocalId = cursor.getInt(i);
                } else if (cyp == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (cxJ == hashCode) {
                    this.field_dataId = cursor.getString(i);
                } else if (ckS == hashCode) {
                    this.field_mediaId = cursor.getString(i);
                } else if (cxM == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (cwd == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (cxL == hashCode) {
                    this.field_cdnKey = cursor.getString(i);
                } else if (ckU == hashCode) {
                    this.field_totalLen = cursor.getInt(i);
                } else if (cKK == hashCode) {
                    this.field_isThumb = cursor.getInt(i) != 0;
                } else if (ckV == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (czw == hashCode) {
                    this.field_fileType = cursor.getInt(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (czG == hashCode) {
                    this.field_errCode = cursor.getInt(i);
                } else if (cKL == hashCode) {
                    this.field_tpaeskey = cursor.getString(i);
                } else if (cwm == hashCode) {
                    this.field_tpauthkey = cursor.getString(i);
                } else if (cKM == hashCode) {
                    this.field_tpdataurl = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cxR) {
            contentValues.put("localId", Integer.valueOf(this.field_localId));
        }
        if (this.cKF) {
            contentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
        }
        if (this.field_toUser == null) {
            this.field_toUser = "";
        }
        if (this.cyb) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.cxD) {
            contentValues.put("dataId", this.field_dataId);
        }
        if (this.ckB) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.cxG) {
            contentValues.put("path", this.field_path);
        }
        if (this.cvC) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.cxF) {
            contentValues.put("cdnKey", this.field_cdnKey);
        }
        if (this.ckD) {
            contentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
        }
        if (this.cKG) {
            contentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
        }
        if (this.ckE) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.czb) {
            contentValues.put("fileType", Integer.valueOf(this.field_fileType));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.czl) {
            contentValues.put("errCode", Integer.valueOf(this.field_errCode));
        }
        if (this.cKH) {
            contentValues.put("tpaeskey", this.field_tpaeskey);
        }
        if (this.cvL) {
            contentValues.put("tpauthkey", this.field_tpauthkey);
        }
        if (this.cKI) {
            contentValues.put("tpdataurl", this.field_tpdataurl);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
