package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class el extends c {
    private static final int cRP = "wallet_tpa_country".hashCode();
    private static final int cRQ = "wallet_type".hashCode();
    private static final int cRR = "wallet_name".hashCode();
    private static final int cRS = "wallet_selected".hashCode();
    private static final int cRT = "wallet_balance".hashCode();
    private static final int cRU = "wallet_tpa_country_mask".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private boolean cRJ = true;
    private boolean cRK = true;
    private boolean cRL = true;
    private boolean cRM = true;
    private boolean cRN = true;
    private boolean cRO = true;
    public int field_wallet_balance;
    public String field_wallet_name;
    public int field_wallet_selected;
    public String field_wallet_tpa_country;
    public int field_wallet_tpa_country_mask;
    public int field_wallet_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cRP == hashCode) {
                    this.field_wallet_tpa_country = cursor.getString(i);
                    this.cRJ = true;
                } else if (cRQ == hashCode) {
                    this.field_wallet_type = cursor.getInt(i);
                } else if (cRR == hashCode) {
                    this.field_wallet_name = cursor.getString(i);
                } else if (cRS == hashCode) {
                    this.field_wallet_selected = cursor.getInt(i);
                } else if (cRT == hashCode) {
                    this.field_wallet_balance = cursor.getInt(i);
                } else if (cRU == hashCode) {
                    this.field_wallet_tpa_country_mask = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cRJ) {
            contentValues.put("wallet_tpa_country", this.field_wallet_tpa_country);
        }
        if (this.cRK) {
            contentValues.put("wallet_type", Integer.valueOf(this.field_wallet_type));
        }
        if (this.cRL) {
            contentValues.put("wallet_name", this.field_wallet_name);
        }
        if (this.cRM) {
            contentValues.put("wallet_selected", Integer.valueOf(this.field_wallet_selected));
        }
        if (this.cRN) {
            contentValues.put("wallet_balance", Integer.valueOf(this.field_wallet_balance));
        }
        if (this.cRO) {
            contentValues.put("wallet_tpa_country_mask", Integer.valueOf(this.field_wallet_tpa_country_mask));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
