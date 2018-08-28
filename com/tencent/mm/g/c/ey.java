package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ey extends c {
    private static final int cBq = "nextCheckTime".hashCode();
    private static final int cTR = "domain".hashCode();
    private static final int cTU = "accessTime".hashCode();
    private static final int cTu = "disable".hashCode();
    private static final int cUA = "clearPkgTime".hashCode();
    private static final int cUB = "checkIntervalTime".hashCode();
    private static final int cUC = "packMethod".hashCode();
    private static final int cUD = "pkgSize".hashCode();
    private static final int cUE = "charset".hashCode();
    private static final int cUF = "bigPackageReady".hashCode();
    private static final int cUG = "preloadFilesReady".hashCode();
    private static final int cUH = "preloadFilesAtomic".hashCode();
    private static final int cUI = "totalDownloadCount".hashCode();
    private static final int cUJ = "packageDownloadCount".hashCode();
    private static final int cUK = "downloadTriggerType".hashCode();
    private static final int cUg = "pkgId".hashCode();
    private static final int cUj = "downloadNetType".hashCode();
    private static final int cUl = "autoDownloadCount".hashCode();
    private static final int cUz = "disableWvCache".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int clC = "version".hashCode();
    private static final int clF = "pkgPath".hashCode();
    private static final int cvM = "md5".hashCode();
    private static final int czr = "downloadUrl".hashCode();
    private boolean cBh = true;
    private boolean cTK = true;
    private boolean cTN = true;
    private boolean cTZ = true;
    private boolean cTp = true;
    private boolean cUc = true;
    private boolean cUe = true;
    private boolean cUn = true;
    private boolean cUo = true;
    private boolean cUp = true;
    private boolean cUq = true;
    private boolean cUr = true;
    private boolean cUs = true;
    private boolean cUt = true;
    private boolean cUu = true;
    private boolean cUv = true;
    private boolean cUw = true;
    private boolean cUx = true;
    private boolean cUy = true;
    private boolean cjF = true;
    private boolean cky = true;
    private boolean clw = true;
    private boolean clz = true;
    private boolean cvk = true;
    private boolean cyW = true;
    public long field_accessTime;
    public String field_appId;
    public int field_autoDownloadCount;
    public boolean field_bigPackageReady;
    public String field_charset;
    public long field_checkIntervalTime;
    public long field_clearPkgTime;
    public long field_createTime;
    public boolean field_disable;
    public boolean field_disableWvCache;
    public String field_domain;
    public int field_downloadNetType;
    public int field_downloadTriggerType;
    public String field_downloadUrl;
    public String field_md5;
    public long field_nextCheckTime;
    public int field_packMethod;
    public int field_packageDownloadCount;
    public String field_pkgId;
    public String field_pkgPath;
    public int field_pkgSize;
    public boolean field_preloadFilesAtomic;
    public boolean field_preloadFilesReady;
    public int field_totalDownloadCount;
    public String field_version;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cUg == hashCode) {
                    this.field_pkgId = cursor.getString(i);
                    this.cTZ = true;
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (clC == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (clF == hashCode) {
                    this.field_pkgPath = cursor.getString(i);
                } else if (cUz == hashCode) {
                    this.field_disableWvCache = cursor.getInt(i) != 0;
                } else if (cUA == hashCode) {
                    this.field_clearPkgTime = cursor.getLong(i);
                } else if (cUB == hashCode) {
                    this.field_checkIntervalTime = cursor.getLong(i);
                } else if (cUC == hashCode) {
                    this.field_packMethod = cursor.getInt(i);
                } else if (cTR == hashCode) {
                    this.field_domain = cursor.getString(i);
                } else if (cvM == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (czr == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (cUD == hashCode) {
                    this.field_pkgSize = cursor.getInt(i);
                } else if (cUj == hashCode) {
                    this.field_downloadNetType = cursor.getInt(i);
                } else if (cBq == hashCode) {
                    this.field_nextCheckTime = cursor.getLong(i);
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (cTU == hashCode) {
                    this.field_accessTime = cursor.getLong(i);
                } else if (cUE == hashCode) {
                    this.field_charset = cursor.getString(i);
                } else if (cUF == hashCode) {
                    this.field_bigPackageReady = cursor.getInt(i) != 0;
                } else if (cUG == hashCode) {
                    this.field_preloadFilesReady = cursor.getInt(i) != 0;
                } else if (cUH == hashCode) {
                    this.field_preloadFilesAtomic = cursor.getInt(i) != 0;
                } else if (cUl == hashCode) {
                    this.field_autoDownloadCount = cursor.getInt(i);
                } else if (cTu == hashCode) {
                    this.field_disable = cursor.getInt(i) != 0;
                } else if (cUI == hashCode) {
                    this.field_totalDownloadCount = cursor.getInt(i);
                } else if (cUJ == hashCode) {
                    this.field_packageDownloadCount = cursor.getInt(i);
                } else if (cUK == hashCode) {
                    this.field_downloadTriggerType = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cTZ) {
            contentValues.put("pkgId", this.field_pkgId);
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.clw) {
            contentValues.put("version", this.field_version);
        }
        if (this.clz) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.cUn) {
            contentValues.put("disableWvCache", Boolean.valueOf(this.field_disableWvCache));
        }
        if (this.cUo) {
            contentValues.put("clearPkgTime", Long.valueOf(this.field_clearPkgTime));
        }
        if (this.cUp) {
            contentValues.put("checkIntervalTime", Long.valueOf(this.field_checkIntervalTime));
        }
        if (this.cUq) {
            contentValues.put("packMethod", Integer.valueOf(this.field_packMethod));
        }
        if (this.cTK) {
            contentValues.put("domain", this.field_domain);
        }
        if (this.cvk) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.cyW) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.cUr) {
            contentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
        }
        if (this.cUc) {
            contentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
        }
        if (this.cBh) {
            contentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.cTN) {
            contentValues.put("accessTime", Long.valueOf(this.field_accessTime));
        }
        if (this.field_charset == null) {
            this.field_charset = "UTF-8";
        }
        if (this.cUs) {
            contentValues.put("charset", this.field_charset);
        }
        if (this.cUt) {
            contentValues.put("bigPackageReady", Boolean.valueOf(this.field_bigPackageReady));
        }
        if (this.cUu) {
            contentValues.put("preloadFilesReady", Boolean.valueOf(this.field_preloadFilesReady));
        }
        if (this.cUv) {
            contentValues.put("preloadFilesAtomic", Boolean.valueOf(this.field_preloadFilesAtomic));
        }
        if (this.cUe) {
            contentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
        }
        if (this.cTp) {
            contentValues.put("disable", Boolean.valueOf(this.field_disable));
        }
        if (this.cUw) {
            contentValues.put("totalDownloadCount", Integer.valueOf(this.field_totalDownloadCount));
        }
        if (this.cUx) {
            contentValues.put("packageDownloadCount", Integer.valueOf(this.field_packageDownloadCount));
        }
        if (this.cUy) {
            contentValues.put("downloadTriggerType", Integer.valueOf(this.field_downloadTriggerType));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
