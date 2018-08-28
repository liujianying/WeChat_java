package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class es extends c {
    private static final int cAY = "expireTime".hashCode();
    private static final int cBd = "weight".hashCode();
    private static final int cTB = "appIdKey".hashCode();
    private static final int cTC = "timeStamp".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjf = DownloadSettingTable$Columns.VALUE.hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int clp = "size".hashCode();
    private boolean cAP = true;
    private boolean cAU = true;
    private boolean cTA = true;
    private boolean cTz = true;
    private boolean ciX = true;
    private boolean cky = true;
    private boolean clm = true;
    public String field_appId;
    public String field_appIdKey;
    public long field_expireTime;
    public long field_size;
    public long field_timeStamp;
    public String field_value;
    public String field_weight;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cTB == hashCode) {
                    this.field_appIdKey = cursor.getString(i);
                    this.cTz = true;
                } else if (cjf == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (cBd == hashCode) {
                    this.field_weight = cursor.getString(i);
                } else if (cAY == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (cTC == hashCode) {
                    this.field_timeStamp = cursor.getLong(i);
                } else if (clp == hashCode) {
                    this.field_size = cursor.getLong(i);
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
        if (this.cTz) {
            contentValues.put("appIdKey", this.field_appIdKey);
        }
        if (this.ciX) {
            contentValues.put(DownloadSettingTable$Columns.VALUE, this.field_value);
        }
        if (this.cAU) {
            contentValues.put("weight", this.field_weight);
        }
        if (this.cAP) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.cTA) {
            contentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
        }
        if (this.clm) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
