package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class h extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int ckQ = "sdkVer".hashCode();
    private static final int ckR = "mediaSvrId".hashCode();
    private static final int ckS = "mediaId".hashCode();
    private static final int ckT = "clientAppDataId".hashCode();
    private static final int ckU = "totalLen".hashCode();
    private static final int ckV = "offset".hashCode();
    private static final int ckW = "isUpload".hashCode();
    private static final int ckX = "lastModifyTime".hashCode();
    private static final int ckY = "fileFullPath".hashCode();
    private static final int ckZ = "fullXml".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int cke = "type".hashCode();
    private static final int cla = "msgInfoId".hashCode();
    private static final int clb = "netTimes".hashCode();
    private static final int clc = "isUseCdn".hashCode();
    private static final int cld = "signature".hashCode();
    private static final int cle = "fakeAeskey".hashCode();
    private static final int clf = "fakeSignature".hashCode();
    private boolean ciS = true;
    private boolean cjF = true;
    private boolean cjI = true;
    private boolean ckA = true;
    private boolean ckB = true;
    private boolean ckC = true;
    private boolean ckD = true;
    private boolean ckE = true;
    private boolean ckF = true;
    private boolean ckG = true;
    private boolean ckH = true;
    private boolean ckI = true;
    private boolean ckJ = true;
    private boolean ckK = true;
    private boolean ckL = true;
    private boolean ckM = true;
    private boolean ckN = true;
    private boolean ckO = true;
    private boolean cky = true;
    private boolean ckz = true;
    public String field_appId;
    public String field_clientAppDataId;
    public long field_createTime;
    public String field_fakeAeskey;
    public String field_fakeSignature;
    public String field_fileFullPath;
    public String field_fullXml;
    public boolean field_isUpload;
    public int field_isUseCdn;
    public long field_lastModifyTime;
    public String field_mediaId;
    public String field_mediaSvrId;
    public long field_msgInfoId;
    public long field_netTimes;
    public long field_offset;
    public long field_sdkVer;
    public String field_signature;
    public long field_status;
    public long field_totalLen;
    public long field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (ckQ == hashCode) {
                    this.field_sdkVer = cursor.getLong(i);
                } else if (ckR == hashCode) {
                    this.field_mediaSvrId = cursor.getString(i);
                } else if (ckS == hashCode) {
                    this.field_mediaId = cursor.getString(i);
                } else if (ckT == hashCode) {
                    this.field_clientAppDataId = cursor.getString(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getLong(i);
                } else if (ckU == hashCode) {
                    this.field_totalLen = cursor.getLong(i);
                } else if (ckV == hashCode) {
                    this.field_offset = cursor.getLong(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getLong(i);
                } else if (ckW == hashCode) {
                    this.field_isUpload = cursor.getInt(i) != 0;
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (ckX == hashCode) {
                    this.field_lastModifyTime = cursor.getLong(i);
                } else if (ckY == hashCode) {
                    this.field_fileFullPath = cursor.getString(i);
                } else if (ckZ == hashCode) {
                    this.field_fullXml = cursor.getString(i);
                } else if (cla == hashCode) {
                    this.field_msgInfoId = cursor.getLong(i);
                } else if (clb == hashCode) {
                    this.field_netTimes = cursor.getLong(i);
                } else if (clc == hashCode) {
                    this.field_isUseCdn = cursor.getInt(i);
                } else if (cld == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (cle == hashCode) {
                    this.field_fakeAeskey = cursor.getString(i);
                } else if (clf == hashCode) {
                    this.field_fakeSignature = cursor.getString(i);
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
        if (this.ckz) {
            contentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
        }
        if (this.ckA) {
            contentValues.put("mediaSvrId", this.field_mediaSvrId);
        }
        if (this.ckB) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.ckC) {
            contentValues.put("clientAppDataId", this.field_clientAppDataId);
        }
        if (this.cjI) {
            contentValues.put("type", Long.valueOf(this.field_type));
        }
        if (this.ckD) {
            contentValues.put("totalLen", Long.valueOf(this.field_totalLen));
        }
        if (this.ckE) {
            contentValues.put("offset", Long.valueOf(this.field_offset));
        }
        if (this.ciS) {
            contentValues.put("status", Long.valueOf(this.field_status));
        }
        if (this.ckF) {
            contentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.ckG) {
            contentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
        }
        if (this.ckH) {
            contentValues.put("fileFullPath", this.field_fileFullPath);
        }
        if (this.ckI) {
            contentValues.put("fullXml", this.field_fullXml);
        }
        if (this.ckJ) {
            contentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
        }
        if (this.ckK) {
            contentValues.put("netTimes", Long.valueOf(this.field_netTimes));
        }
        if (this.ckL) {
            contentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
        }
        if (this.ckM) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.ckN) {
            contentValues.put("fakeAeskey", this.field_fakeAeskey);
        }
        if (this.ckO) {
            contentValues.put("fakeSignature", this.field_fakeSignature);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
