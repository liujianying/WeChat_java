package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ag extends c {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS CardQrCodeDataInfo_card_id_index ON CardQrCodeDataInfo(card_id)"};
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int cqC = "card_id".hashCode();
    private static final int crg = "code_id".hashCode();
    private static final int crh = "code".hashCode();
    private boolean ciS = true;
    private boolean cqj = true;
    private boolean cre = true;
    private boolean crf = true;
    public String field_card_id;
    public String field_code;
    public String field_code_id;
    public int field_status;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (crg == hashCode) {
                    this.field_code_id = cursor.getString(i);
                } else if (cqC == hashCode) {
                    this.field_card_id = cursor.getString(i);
                } else if (crh == hashCode) {
                    this.field_code = cursor.getString(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cre) {
            contentValues.put("code_id", this.field_code_id);
        }
        if (this.cqj) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.crf) {
            contentValues.put("code", this.field_code);
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
