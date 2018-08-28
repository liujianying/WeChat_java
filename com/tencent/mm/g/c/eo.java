package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eo extends c {
    private static final int cRE = "wallet_region".hashCode();
    private static final int cSm = "wallet_grey_item_buf".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private boolean cRz = true;
    private boolean cSl = true;
    public byte[] field_wallet_grey_item_buf;
    public int field_wallet_region;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cRE == hashCode) {
                    this.field_wallet_region = cursor.getInt(i);
                    this.cRz = true;
                } else if (cSm == hashCode) {
                    this.field_wallet_grey_item_buf = cursor.getBlob(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cRz) {
            contentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
        }
        if (this.cSl) {
            contentValues.put("wallet_grey_item_buf", this.field_wallet_grey_item_buf);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
