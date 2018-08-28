package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aq extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int clj = "updateTime".hashCode();
    private static final int cln = "data".hashCode();
    private static final int cuh = "id".hashCode();
    private static final int cui = "cacheKey".hashCode();
    private static final int cuj = "interval".hashCode();
    private boolean cky = true;
    private boolean clh = true;
    private boolean clk = true;
    private boolean cue = true;
    private boolean cuf = true;
    private boolean cug = true;
    public String field_appId;
    public String field_cacheKey;
    public String field_data;
    public String field_id;
    public int field_interval;
    public long field_updateTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cuh == hashCode) {
                    this.field_id = cursor.getString(i);
                } else if (cui == hashCode) {
                    this.field_cacheKey = cursor.getString(i);
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cln == hashCode) {
                    this.field_data = cursor.getString(i);
                } else if (cuj == hashCode) {
                    this.field_interval = cursor.getInt(i);
                } else if (clj == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cue) {
            contentValues.put("id", this.field_id);
        }
        if (this.cuf) {
            contentValues.put("cacheKey", this.field_cacheKey);
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.clk) {
            contentValues.put("data", this.field_data);
        }
        if (this.cug) {
            contentValues.put("interval", Integer.valueOf(this.field_interval));
        }
        if (this.clh) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
