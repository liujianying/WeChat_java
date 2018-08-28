package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class br extends c {
    private static final int cAY = "expireTime".hashCode();
    private static final int cBo = "randomTime".hashCode();
    private static final int cBp = "isFirst".hashCode();
    private static final int cBq = "nextCheckTime".hashCode();
    private static final int cBr = "isRunning".hashCode();
    private static final int cBs = "noWifi".hashCode();
    private static final int cBt = "noSdcard".hashCode();
    private static final int cBu = "noEnoughSpace".hashCode();
    private static final int cBv = "lowBattery".hashCode();
    private static final int cBw = "continueDelay".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int clp = "size".hashCode();
    private static final int cml = "packageName".hashCode();
    private static final int cvM = "md5".hashCode();
    private static final int czr = "downloadUrl".hashCode();
    private boolean cAP = true;
    private boolean cBf = true;
    private boolean cBg = true;
    private boolean cBh = true;
    private boolean cBi = true;
    private boolean cBj = true;
    private boolean cBk = true;
    private boolean cBl = true;
    private boolean cBm = true;
    private boolean cBn = true;
    private boolean cky = true;
    private boolean clO = true;
    private boolean clm = true;
    private boolean cvk = true;
    private boolean cyW = true;
    public String field_appId;
    public boolean field_continueDelay;
    public String field_downloadUrl;
    public long field_expireTime;
    public boolean field_isFirst;
    public boolean field_isRunning;
    public boolean field_lowBattery;
    public String field_md5;
    public long field_nextCheckTime;
    public boolean field_noEnoughSpace;
    public boolean field_noSdcard;
    public boolean field_noWifi;
    public String field_packageName;
    public long field_randomTime;
    public long field_size;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.cky = true;
                } else if (czr == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (clp == hashCode) {
                    this.field_size = cursor.getLong(i);
                } else if (cvM == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (cml == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (cAY == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (cBo == hashCode) {
                    this.field_randomTime = cursor.getLong(i);
                } else if (cBp == hashCode) {
                    this.field_isFirst = cursor.getInt(i) != 0;
                } else if (cBq == hashCode) {
                    this.field_nextCheckTime = cursor.getLong(i);
                } else if (cBr == hashCode) {
                    this.field_isRunning = cursor.getInt(i) != 0;
                } else if (cBs == hashCode) {
                    this.field_noWifi = cursor.getInt(i) != 0;
                } else if (cBt == hashCode) {
                    this.field_noSdcard = cursor.getInt(i) != 0;
                } else if (cBu == hashCode) {
                    this.field_noEnoughSpace = cursor.getInt(i) != 0;
                } else if (cBv == hashCode) {
                    this.field_lowBattery = cursor.getInt(i) != 0;
                } else if (cBw == hashCode) {
                    this.field_continueDelay = cursor.getInt(i) != 0;
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
        if (this.cyW) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.clm) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.cvk) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.clO) {
            contentValues.put("packageName", this.field_packageName);
        }
        if (this.cAP) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.cBf) {
            contentValues.put("randomTime", Long.valueOf(this.field_randomTime));
        }
        if (this.cBg) {
            contentValues.put("isFirst", Boolean.valueOf(this.field_isFirst));
        }
        if (this.cBh) {
            contentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
        }
        if (this.cBi) {
            contentValues.put("isRunning", Boolean.valueOf(this.field_isRunning));
        }
        if (this.cBj) {
            contentValues.put("noWifi", Boolean.valueOf(this.field_noWifi));
        }
        if (this.cBk) {
            contentValues.put("noSdcard", Boolean.valueOf(this.field_noSdcard));
        }
        if (this.cBl) {
            contentValues.put("noEnoughSpace", Boolean.valueOf(this.field_noEnoughSpace));
        }
        if (this.cBm) {
            contentValues.put("lowBattery", Boolean.valueOf(this.field_lowBattery));
        }
        if (this.cBn) {
            contentValues.put("continueDelay", Boolean.valueOf(this.field_continueDelay));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
