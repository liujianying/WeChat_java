package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ek extends c {
    private static final int cRE = "wallet_region".hashCode();
    private static final int cRF = "function_list".hashCode();
    private static final int cRG = "new_list".hashCode();
    private static final int cRH = "banner_list".hashCode();
    private static final int cRI = "type_name_list".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private boolean cRA = true;
    private boolean cRB = true;
    private boolean cRC = true;
    private boolean cRD = true;
    private boolean cRz = true;
    public String field_banner_list;
    public String field_function_list;
    public String field_new_list;
    public String field_type_name_list;
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
                } else if (cRF == hashCode) {
                    this.field_function_list = cursor.getString(i);
                } else if (cRG == hashCode) {
                    this.field_new_list = cursor.getString(i);
                } else if (cRH == hashCode) {
                    this.field_banner_list = cursor.getString(i);
                } else if (cRI == hashCode) {
                    this.field_type_name_list = cursor.getString(i);
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
        if (this.cRA) {
            contentValues.put("function_list", this.field_function_list);
        }
        if (this.cRB) {
            contentValues.put("new_list", this.field_new_list);
        }
        if (this.cRC) {
            contentValues.put("banner_list", this.field_banner_list);
        }
        if (this.cRD) {
            contentValues.put("type_name_list", this.field_type_name_list);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
