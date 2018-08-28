package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class ev extends c {
    private static final int cAY = "expireTime".hashCode();
    private static final int cIo = "protocol".hashCode();
    private static final int cLQ = "packageId".hashCode();
    private static final int cLy = "contentLength".hashCode();
    private static final int cLz = DownloadInfo.CONTENTTYPE.hashCode();
    private static final int cTQ = "urlMd5Hashcode".hashCode();
    private static final int cTR = "domain".hashCode();
    private static final int cTS = "localPath".hashCode();
    private static final int cTT = "isLatestVersion".hashCode();
    private static final int cTU = "accessTime".hashCode();
    private static final int cTV = "cacheType".hashCode();
    private static final int cTW = "contentMd5".hashCode();
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS WebViewResourceCacheAppIdIndex ON WebViewResourceCache(appId)", "CREATE INDEX IF NOT EXISTS WebViewResourceCacheDomainIndex ON WebViewResourceCache(domain)", "CREATE INDEX IF NOT EXISTS WebViewResourceCachePackageIdIndex ON WebViewResourceCache(packageId)"};
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int clC = "version".hashCode();
    private static final int cqH = TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL.hashCode();
    private static final int cxQ = "configId".hashCode();
    private boolean cAP = true;
    private boolean cHH = true;
    private boolean cLb = true;
    private boolean cLc = true;
    private boolean cLt = true;
    private boolean cTJ = true;
    private boolean cTK = true;
    private boolean cTL = true;
    private boolean cTM = true;
    private boolean cTN = true;
    private boolean cTO = true;
    private boolean cTP = true;
    private boolean cjF = true;
    private boolean cky = true;
    private boolean clw = true;
    private boolean cqo = true;
    private boolean cxP = true;
    public long field_accessTime;
    public String field_appId;
    public int field_cacheType;
    public String field_configId;
    public long field_contentLength;
    public String field_contentMd5;
    public String field_contentType;
    public long field_createTime;
    public String field_domain;
    public long field_expireTime;
    public boolean field_isLatestVersion;
    public String field_localPath;
    public String field_packageId;
    public int field_protocol;
    public String field_url;
    public int field_urlMd5Hashcode;
    public String field_version;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cTQ == hashCode) {
                    this.field_urlMd5Hashcode = cursor.getInt(i);
                } else if (cqH == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cTR == hashCode) {
                    this.field_domain = cursor.getString(i);
                } else if (clC == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (cTS == hashCode) {
                    this.field_localPath = cursor.getString(i);
                } else if (cLz == hashCode) {
                    this.field_contentType = cursor.getString(i);
                } else if (cLy == hashCode) {
                    this.field_contentLength = cursor.getLong(i);
                } else if (cTT == hashCode) {
                    this.field_isLatestVersion = cursor.getInt(i) != 0;
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (cTU == hashCode) {
                    this.field_accessTime = cursor.getLong(i);
                } else if (cAY == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (cTV == hashCode) {
                    this.field_cacheType = cursor.getInt(i);
                } else if (cxQ == hashCode) {
                    this.field_configId = cursor.getString(i);
                } else if (cIo == hashCode) {
                    this.field_protocol = cursor.getInt(i);
                } else if (cLQ == hashCode) {
                    this.field_packageId = cursor.getString(i);
                } else if (cTW == hashCode) {
                    this.field_contentMd5 = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cTJ) {
            contentValues.put("urlMd5Hashcode", Integer.valueOf(this.field_urlMd5Hashcode));
        }
        if (this.cqo) {
            contentValues.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, this.field_url);
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.cTK) {
            contentValues.put("domain", this.field_domain);
        }
        if (this.clw) {
            contentValues.put("version", this.field_version);
        }
        if (this.cTL) {
            contentValues.put("localPath", this.field_localPath);
        }
        if (this.cLc) {
            contentValues.put(DownloadInfo.CONTENTTYPE, this.field_contentType);
        }
        if (this.cLb) {
            contentValues.put("contentLength", Long.valueOf(this.field_contentLength));
        }
        if (this.cTM) {
            contentValues.put("isLatestVersion", Boolean.valueOf(this.field_isLatestVersion));
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.cTN) {
            contentValues.put("accessTime", Long.valueOf(this.field_accessTime));
        }
        if (this.cAP) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.cTO) {
            contentValues.put("cacheType", Integer.valueOf(this.field_cacheType));
        }
        if (this.cxP) {
            contentValues.put("configId", this.field_configId);
        }
        if (this.cHH) {
            contentValues.put("protocol", Integer.valueOf(this.field_protocol));
        }
        if (this.cLt) {
            contentValues.put("packageId", this.field_packageId);
        }
        if (this.cTP) {
            contentValues.put("contentMd5", this.field_contentMd5);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
