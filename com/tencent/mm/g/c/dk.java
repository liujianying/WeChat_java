package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dk extends c {
    private static final int cAY = "expireTime".hashCode();
    private static final int cJQ = "reportId".hashCode();
    private static final int cJY = "retryTimes".hashCode();
    private static final int cKb = "networkType".hashCode();
    private static final int cLA = "groupId1".hashCode();
    private static final int cLB = "groupId2".hashCode();
    private static final int cLC = "priority".hashCode();
    private static final int cLD = "fileUpdated".hashCode();
    private static final int cLE = "deleted".hashCode();
    private static final int cLF = "resType".hashCode();
    private static final int cLG = "sampleId".hashCode();
    private static final int cLH = "eccSignature".hashCode();
    private static final int cLI = "originalMd5".hashCode();
    private static final int cLJ = "fileCompress".hashCode();
    private static final int cLK = "fileEncrypt".hashCode();
    private static final int cLL = "encryptKey".hashCode();
    private static final int cLM = "keyVersion".hashCode();
    private static final int cLN = "EID".hashCode();
    private static final int cLO = "needRetry".hashCode();
    private static final int cLP = "wvCacheType".hashCode();
    private static final int cLQ = "packageId".hashCode();
    private static final int cLu = "urlKey_hashcode".hashCode();
    private static final int cLv = "urlKey".hashCode();
    private static final int cLw = "fileVersion".hashCode();
    private static final int cLx = "maxRetryTimes".hashCode();
    private static final int cLy = "contentLength".hashCode();
    private static final int cLz = "contentType".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int cks = "subType".hashCode();
    private static final int cqH = "url".hashCode();
    private static final int cvM = "md5".hashCode();
    private static final int czt = "fileSize".hashCode();
    private static final int czv = "filePath".hashCode();
    private boolean cAP = true;
    private boolean cJN = true;
    private boolean cJR = true;
    private boolean cJU = true;
    private boolean cKX = true;
    private boolean cKY = true;
    private boolean cKZ = true;
    private boolean cLa = true;
    private boolean cLb = true;
    private boolean cLc = true;
    private boolean cLd = true;
    private boolean cLe = true;
    private boolean cLf = true;
    private boolean cLg = true;
    private boolean cLh = true;
    private boolean cLi = true;
    private boolean cLj = true;
    private boolean cLk = true;
    private boolean cLl = true;
    private boolean cLm = true;
    private boolean cLn = true;
    private boolean cLo = true;
    private boolean cLp = true;
    private boolean cLq = true;
    private boolean cLr = true;
    private boolean cLs = true;
    private boolean cLt = true;
    private boolean ciS = true;
    private boolean cjW = true;
    private boolean cky = true;
    private boolean cqo = true;
    private boolean cvk = true;
    private boolean cyY = true;
    private boolean cza = true;
    public int field_EID;
    public String field_appId;
    public long field_contentLength;
    public String field_contentType;
    public boolean field_deleted;
    public byte[] field_eccSignature;
    public String field_encryptKey;
    public long field_expireTime;
    public boolean field_fileCompress;
    public boolean field_fileEncrypt;
    public String field_filePath;
    public long field_fileSize;
    public boolean field_fileUpdated;
    public String field_fileVersion;
    public String field_groupId1;
    public String field_groupId2;
    public int field_keyVersion;
    public int field_maxRetryTimes;
    public String field_md5;
    public boolean field_needRetry;
    public int field_networkType;
    public String field_originalMd5;
    public String field_packageId;
    public int field_priority;
    public long field_reportId;
    public int field_resType;
    public int field_retryTimes;
    public String field_sampleId;
    public int field_status;
    public int field_subType;
    public String field_url;
    public String field_urlKey;
    public int field_urlKey_hashcode;
    public int field_wvCacheType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cLu == hashCode) {
                    this.field_urlKey_hashcode = cursor.getInt(i);
                    this.cKX = true;
                } else if (cLv == hashCode) {
                    this.field_urlKey = cursor.getString(i);
                } else if (cqH == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (cLw == hashCode) {
                    this.field_fileVersion = cursor.getString(i);
                } else if (cKb == hashCode) {
                    this.field_networkType = cursor.getInt(i);
                } else if (cLx == hashCode) {
                    this.field_maxRetryTimes = cursor.getInt(i);
                } else if (cJY == hashCode) {
                    this.field_retryTimes = cursor.getInt(i);
                } else if (czv == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cLy == hashCode) {
                    this.field_contentLength = cursor.getLong(i);
                } else if (cLz == hashCode) {
                    this.field_contentType = cursor.getString(i);
                } else if (cAY == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (cvM == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (cLA == hashCode) {
                    this.field_groupId1 = cursor.getString(i);
                } else if (cLB == hashCode) {
                    this.field_groupId2 = cursor.getString(i);
                } else if (cLC == hashCode) {
                    this.field_priority = cursor.getInt(i);
                } else if (cLD == hashCode) {
                    this.field_fileUpdated = cursor.getInt(i) != 0;
                } else if (cLE == hashCode) {
                    this.field_deleted = cursor.getInt(i) != 0;
                } else if (cLF == hashCode) {
                    this.field_resType = cursor.getInt(i);
                } else if (cks == hashCode) {
                    this.field_subType = cursor.getInt(i);
                } else if (cJQ == hashCode) {
                    this.field_reportId = cursor.getLong(i);
                } else if (cLG == hashCode) {
                    this.field_sampleId = cursor.getString(i);
                } else if (cLH == hashCode) {
                    this.field_eccSignature = cursor.getBlob(i);
                } else if (cLI == hashCode) {
                    this.field_originalMd5 = cursor.getString(i);
                } else if (cLJ == hashCode) {
                    this.field_fileCompress = cursor.getInt(i) != 0;
                } else if (cLK == hashCode) {
                    this.field_fileEncrypt = cursor.getInt(i) != 0;
                } else if (cLL == hashCode) {
                    this.field_encryptKey = cursor.getString(i);
                } else if (cLM == hashCode) {
                    this.field_keyVersion = cursor.getInt(i);
                } else if (cLN == hashCode) {
                    this.field_EID = cursor.getInt(i);
                } else if (czt == hashCode) {
                    this.field_fileSize = cursor.getLong(i);
                } else if (cLO == hashCode) {
                    this.field_needRetry = cursor.getInt(i) != 0;
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cLP == hashCode) {
                    this.field_wvCacheType = cursor.getInt(i);
                } else if (cLQ == hashCode) {
                    this.field_packageId = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cKX) {
            contentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
        }
        if (this.cKY) {
            contentValues.put("urlKey", this.field_urlKey);
        }
        if (this.cqo) {
            contentValues.put("url", this.field_url);
        }
        if (this.cKZ) {
            contentValues.put("fileVersion", this.field_fileVersion);
        }
        if (this.cJU) {
            contentValues.put("networkType", Integer.valueOf(this.field_networkType));
        }
        if (this.cLa) {
            contentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
        }
        if (this.cJR) {
            contentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
        }
        if (this.cza) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cLb) {
            contentValues.put("contentLength", Long.valueOf(this.field_contentLength));
        }
        if (this.cLc) {
            contentValues.put("contentType", this.field_contentType);
        }
        if (this.cAP) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.cvk) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.cLd) {
            contentValues.put("groupId1", this.field_groupId1);
        }
        if (this.cLe) {
            contentValues.put("groupId2", this.field_groupId2);
        }
        if (this.cLf) {
            contentValues.put("priority", Integer.valueOf(this.field_priority));
        }
        if (this.cLg) {
            contentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
        }
        if (this.cLh) {
            contentValues.put("deleted", Boolean.valueOf(this.field_deleted));
        }
        if (this.cLi) {
            contentValues.put("resType", Integer.valueOf(this.field_resType));
        }
        if (this.cjW) {
            contentValues.put("subType", Integer.valueOf(this.field_subType));
        }
        if (this.cJN) {
            contentValues.put("reportId", Long.valueOf(this.field_reportId));
        }
        if (this.cLj) {
            contentValues.put("sampleId", this.field_sampleId);
        }
        if (this.cLk) {
            contentValues.put("eccSignature", this.field_eccSignature);
        }
        if (this.cLl) {
            contentValues.put("originalMd5", this.field_originalMd5);
        }
        if (this.cLm) {
            contentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
        }
        if (this.cLn) {
            contentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
        }
        if (this.cLo) {
            contentValues.put("encryptKey", this.field_encryptKey);
        }
        if (this.cLp) {
            contentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
        }
        if (this.cLq) {
            contentValues.put("EID", Integer.valueOf(this.field_EID));
        }
        if (this.cyY) {
            contentValues.put("fileSize", Long.valueOf(this.field_fileSize));
        }
        if (this.cLr) {
            contentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.cLs) {
            contentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
        }
        if (this.cLt) {
            contentValues.put("packageId", this.field_packageId);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
