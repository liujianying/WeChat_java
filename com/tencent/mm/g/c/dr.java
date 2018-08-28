package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dr extends c {
    private static final int cJy = "retryCount".hashCode();
    private static final int cNq = "state_flag".hashCode();
    private static final int cNr = "update_time".hashCode();
    private static final int cNs = "seq".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cqC = "card_id".hashCode();
    private boolean cJw = true;
    private boolean cNn = true;
    private boolean cNo = true;
    private boolean cNp = true;
    private boolean cqj = true;
    public String field_card_id;
    public int field_retryCount;
    public long field_seq;
    public int field_state_flag;
    public long field_update_time;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cqC == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.cqj = true;
                } else if (cNq == hashCode) {
                    this.field_state_flag = cursor.getInt(i);
                } else if (cNr == hashCode) {
                    this.field_update_time = cursor.getLong(i);
                } else if (cNs == hashCode) {
                    this.field_seq = cursor.getLong(i);
                } else if (cJy == hashCode) {
                    this.field_retryCount = cursor.getInt(i);
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
        if (this.cNn) {
            contentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
        }
        if (this.cNo) {
            contentValues.put("update_time", Long.valueOf(this.field_update_time));
        }
        if (this.cNp) {
            contentValues.put("seq", Long.valueOf(this.field_seq));
        }
        if (this.cJw) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
