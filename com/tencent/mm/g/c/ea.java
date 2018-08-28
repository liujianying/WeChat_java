package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.e.c;

public abstract class ea extends c {
    private static final int cDk = "step".hashCode();
    private static final int cOW = "date".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cuh = SlookAirButtonFrequentContactAdapter.ID.hashCode();
    private static final int cyU = "timestamp".hashCode();
    private boolean cDj = true;
    private boolean cOV = true;
    private boolean cue = true;
    private boolean cyK = true;
    public String field_date;
    public int field_id;
    public int field_step;
    public long field_timestamp;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cuh == hashCode) {
                    this.field_id = cursor.getInt(i);
                    this.cue = true;
                } else if (cOW == hashCode) {
                    this.field_date = cursor.getString(i);
                } else if (cDk == hashCode) {
                    this.field_step = cursor.getInt(i);
                } else if (cyU == hashCode) {
                    this.field_timestamp = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cue) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Integer.valueOf(this.field_id));
        }
        if (this.cOV) {
            contentValues.put("date", this.field_date);
        }
        if (this.cDj) {
            contentValues.put("step", Integer.valueOf(this.field_step));
        }
        if (this.cyK) {
            contentValues.put("timestamp", Long.valueOf(this.field_timestamp));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
