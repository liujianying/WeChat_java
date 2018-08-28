package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class af extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cqC = "card_id".hashCode();
    private static final int cqY = "lower_bound".hashCode();
    private static final int cqZ = "need_insert_show_timestamp".hashCode();
    private static final int cra = "show_timestamp_encrypt_key".hashCode();
    private static final int crb = "expire_time_interval".hashCode();
    private static final int crc = "show_expire_interval".hashCode();
    private static final int crd = "fetch_time".hashCode();
    private boolean cqS = true;
    private boolean cqT = true;
    private boolean cqU = true;
    private boolean cqV = true;
    private boolean cqW = true;
    private boolean cqX = true;
    private boolean cqj = true;
    public String field_card_id;
    public int field_expire_time_interval;
    public long field_fetch_time;
    public int field_lower_bound;
    public boolean field_need_insert_show_timestamp;
    public int field_show_expire_interval;
    public String field_show_timestamp_encrypt_key;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cqC == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.cqj = true;
                } else if (cqY == hashCode) {
                    this.field_lower_bound = cursor.getInt(i);
                } else if (cqZ == hashCode) {
                    this.field_need_insert_show_timestamp = cursor.getInt(i) != 0;
                } else if (cra == hashCode) {
                    this.field_show_timestamp_encrypt_key = cursor.getString(i);
                } else if (crb == hashCode) {
                    this.field_expire_time_interval = cursor.getInt(i);
                } else if (crc == hashCode) {
                    this.field_show_expire_interval = cursor.getInt(i);
                } else if (crd == hashCode) {
                    this.field_fetch_time = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cqj) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.cqS) {
            contentValues.put("lower_bound", Integer.valueOf(this.field_lower_bound));
        }
        if (this.cqT) {
            contentValues.put("need_insert_show_timestamp", Boolean.valueOf(this.field_need_insert_show_timestamp));
        }
        if (this.cqU) {
            contentValues.put("show_timestamp_encrypt_key", this.field_show_timestamp_encrypt_key);
        }
        if (this.cqV) {
            contentValues.put("expire_time_interval", Integer.valueOf(this.field_expire_time_interval));
        }
        if (this.cqW) {
            contentValues.put("show_expire_interval", Integer.valueOf(this.field_show_expire_interval));
        }
        if (this.cqX) {
            contentValues.put("fetch_time", Long.valueOf(this.field_fetch_time));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
