package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bj extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int cjj = "startTime".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int ckw = "scene".hashCode();
    private static final int cml = "packageName".hashCode();
    private static final int cps = "extInfo".hashCode();
    private static final int cvM = "md5".hashCode();
    private static final int czA = "downloaderType".hashCode();
    private static final int czB = "downloadUrlHashCode".hashCode();
    private static final int czC = "downloadedSize".hashCode();
    private static final int czD = "totalSize".hashCode();
    private static final int czE = "autoDownload".hashCode();
    private static final int czF = "channelId".hashCode();
    private static final int czG = "errCode".hashCode();
    private static final int czH = "startSize".hashCode();
    private static final int czI = "startState".hashCode();
    private static final int czJ = "fromWeApp".hashCode();
    private static final int czK = "downloadInWifi".hashCode();
    private static final int czq = "downloadId".hashCode();
    private static final int czr = "downloadUrl".hashCode();
    private static final int czs = "secondaryUrl".hashCode();
    private static final int czt = "fileSize".hashCode();
    private static final int czu = "fileName".hashCode();
    private static final int czv = "filePath".hashCode();
    private static final int czw = "fileType".hashCode();
    private static final int czx = "autoInstall".hashCode();
    private static final int czy = "showNotification".hashCode();
    private static final int czz = "sysDownloadId".hashCode();
    private boolean ciS = true;
    private boolean cjb = true;
    private boolean cku = true;
    private boolean cky = true;
    private boolean clO = true;
    private boolean cpe = true;
    private boolean cvk = true;
    private boolean cyV = true;
    private boolean cyW = true;
    private boolean cyX = true;
    private boolean cyY = true;
    private boolean cyZ = true;
    private boolean cza = true;
    private boolean czb = true;
    private boolean czc = true;
    private boolean czd = true;
    private boolean cze = true;
    private boolean czf = true;
    private boolean czg = true;
    private boolean czh = true;
    private boolean czi = true;
    private boolean czj = true;
    private boolean czk = true;
    private boolean czl = true;
    private boolean czm = true;
    private boolean czn = true;
    private boolean czo = true;
    private boolean czp = true;
    public String field_appId;
    public boolean field_autoDownload;
    public boolean field_autoInstall;
    public String field_channelId;
    public long field_downloadId;
    public boolean field_downloadInWifi;
    public String field_downloadUrl;
    public int field_downloadUrlHashCode;
    public long field_downloadedSize;
    public int field_downloaderType;
    public int field_errCode;
    public String field_extInfo;
    public String field_fileName;
    public String field_filePath;
    public long field_fileSize;
    public int field_fileType;
    public boolean field_fromWeApp;
    public String field_md5;
    public String field_packageName;
    public int field_scene;
    public String field_secondaryUrl;
    public boolean field_showNotification;
    public long field_startSize;
    public int field_startState;
    public long field_startTime;
    public int field_status;
    public long field_sysDownloadId;
    public long field_totalSize;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (czq == hashCode) {
                    this.field_downloadId = cursor.getLong(i);
                    this.cyV = true;
                } else if (czr == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (czs == hashCode) {
                    this.field_secondaryUrl = cursor.getString(i);
                } else if (czt == hashCode) {
                    this.field_fileSize = cursor.getLong(i);
                } else if (czu == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (czv == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (czw == hashCode) {
                    this.field_fileType = cursor.getInt(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cvM == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (czx == hashCode) {
                    this.field_autoInstall = cursor.getInt(i) != 0;
                } else if (czy == hashCode) {
                    this.field_showNotification = cursor.getInt(i) != 0;
                } else if (czz == hashCode) {
                    this.field_sysDownloadId = cursor.getLong(i);
                } else if (czA == hashCode) {
                    this.field_downloaderType = cursor.getInt(i);
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (czB == hashCode) {
                    this.field_downloadUrlHashCode = cursor.getInt(i);
                } else if (cml == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (czC == hashCode) {
                    this.field_downloadedSize = cursor.getLong(i);
                } else if (czD == hashCode) {
                    this.field_totalSize = cursor.getLong(i);
                } else if (czE == hashCode) {
                    this.field_autoDownload = cursor.getInt(i) != 0;
                } else if (czF == hashCode) {
                    this.field_channelId = cursor.getString(i);
                } else if (ckw == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (czG == hashCode) {
                    this.field_errCode = cursor.getInt(i);
                } else if (cjj == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (czH == hashCode) {
                    this.field_startSize = cursor.getLong(i);
                } else if (czI == hashCode) {
                    this.field_startState = cursor.getInt(i);
                } else if (czJ == hashCode) {
                    this.field_fromWeApp = cursor.getInt(i) != 0;
                } else if (czK == hashCode) {
                    this.field_downloadInWifi = cursor.getInt(i) != 0;
                } else if (cps == hashCode) {
                    this.field_extInfo = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cyV) {
            contentValues.put("downloadId", Long.valueOf(this.field_downloadId));
        }
        if (this.field_downloadUrl == null) {
            this.field_downloadUrl = "";
        }
        if (this.cyW) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.field_secondaryUrl == null) {
            this.field_secondaryUrl = "";
        }
        if (this.cyX) {
            contentValues.put("secondaryUrl", this.field_secondaryUrl);
        }
        if (this.cyY) {
            contentValues.put("fileSize", Long.valueOf(this.field_fileSize));
        }
        if (this.field_fileName == null) {
            this.field_fileName = "";
        }
        if (this.cyZ) {
            contentValues.put("fileName", this.field_fileName);
        }
        if (this.field_filePath == null) {
            this.field_filePath = "";
        }
        if (this.cza) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.czb) {
            contentValues.put("fileType", Integer.valueOf(this.field_fileType));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.field_md5 == null) {
            this.field_md5 = "";
        }
        if (this.cvk) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.czc) {
            contentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
        }
        if (this.czd) {
            contentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
        }
        if (this.cze) {
            contentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
        }
        if (this.czf) {
            contentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
        }
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.czg) {
            contentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
        }
        if (this.field_packageName == null) {
            this.field_packageName = "";
        }
        if (this.clO) {
            contentValues.put("packageName", this.field_packageName);
        }
        if (this.czh) {
            contentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
        }
        if (this.czi) {
            contentValues.put("totalSize", Long.valueOf(this.field_totalSize));
        }
        if (this.czj) {
            contentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
        }
        if (this.field_channelId == null) {
            this.field_channelId = "";
        }
        if (this.czk) {
            contentValues.put("channelId", this.field_channelId);
        }
        if (this.cku) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.czl) {
            contentValues.put("errCode", Integer.valueOf(this.field_errCode));
        }
        if (this.cjb) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.czm) {
            contentValues.put("startSize", Long.valueOf(this.field_startSize));
        }
        if (this.czn) {
            contentValues.put("startState", Integer.valueOf(this.field_startState));
        }
        if (this.czo) {
            contentValues.put("fromWeApp", Boolean.valueOf(this.field_fromWeApp));
        }
        if (this.czp) {
            contentValues.put("downloadInWifi", Boolean.valueOf(this.field_downloadInWifi));
        }
        if (this.field_extInfo == null) {
            this.field_extInfo = "";
        }
        if (this.cpe) {
            contentValues.put("extInfo", this.field_extInfo);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
