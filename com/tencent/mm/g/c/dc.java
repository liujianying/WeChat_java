package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class dc extends c {
    private static final int cJQ = "reportId".hashCode();
    private static final int cJY = "retryTimes".hashCode();
    private static final int cJZ = "retriedCount".hashCode();
    private static final int cKa = "retryInterval".hashCode();
    private static final int cKb = "networkType".hashCode();
    private static final int cKc = "pkgMd5".hashCode();
    private static final int cKd = "lastRetryTime".hashCode();
    private static final int cKe = "firstTimeTried".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int cke = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int clC = "version".hashCode();
    private boolean cJN = true;
    private boolean cJR = true;
    private boolean cJS = true;
    private boolean cJT = true;
    private boolean cJU = true;
    private boolean cJV = true;
    private boolean cJW = true;
    private boolean cJX = true;
    private boolean cjI = true;
    private boolean cky = true;
    private boolean clw = true;
    public String field_appId;
    public boolean field_firstTimeTried;
    public long field_lastRetryTime;
    public int field_networkType;
    public String field_pkgMd5;
    public int field_reportId;
    public int field_retriedCount;
    public long field_retryInterval;
    public int field_retryTimes;
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
                } else if (cJY == hashCode) {
                    this.field_retryTimes = cursor.getInt(i);
                } else if (cJZ == hashCode) {
                    this.field_retriedCount = cursor.getInt(i);
                } else if (cKa == hashCode) {
                    this.field_retryInterval = cursor.getLong(i);
                } else if (cKb == hashCode) {
                    this.field_networkType = cursor.getInt(i);
                } else if (cKc == hashCode) {
                    this.field_pkgMd5 = cursor.getString(i);
                } else if (cKd == hashCode) {
                    this.field_lastRetryTime = cursor.getLong(i);
                } else if (cKe == hashCode) {
                    this.field_firstTimeTried = cursor.getInt(i) != 0;
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
        if (this.clw) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.cjI) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.cJR) {
            contentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
        }
        if (this.cJS) {
            contentValues.put("retriedCount", Integer.valueOf(this.field_retriedCount));
        }
        if (this.cJT) {
            contentValues.put("retryInterval", Long.valueOf(this.field_retryInterval));
        }
        if (this.cJU) {
            contentValues.put("networkType", Integer.valueOf(this.field_networkType));
        }
        if (this.cJV) {
            contentValues.put("pkgMd5", this.field_pkgMd5);
        }
        if (this.cJW) {
            contentValues.put("lastRetryTime", Long.valueOf(this.field_lastRetryTime));
        }
        if (this.cJX) {
            contentValues.put("firstTimeTried", Boolean.valueOf(this.field_firstTimeTried));
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
