package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cc extends c {
    private static final int cDv = "wechatUsername".hashCode();
    private static final int cDw = "systemAddressBookUsername".hashCode();
    private static final int cDx = "contactId".hashCode();
    private static final int cDy = "sortKey".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private boolean cDr = true;
    private boolean cDs = true;
    private boolean cDt = true;
    private boolean cDu = true;
    public String field_contactId;
    public String field_sortKey;
    public String field_systemAddressBookUsername;
    public String field_wechatUsername;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cDv == hashCode) {
                    this.field_wechatUsername = cursor.getString(i);
                } else if (cDw == hashCode) {
                    this.field_systemAddressBookUsername = cursor.getString(i);
                } else if (cDx == hashCode) {
                    this.field_contactId = cursor.getString(i);
                } else if (cDy == hashCode) {
                    this.field_sortKey = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cDr) {
            contentValues.put("wechatUsername", this.field_wechatUsername);
        }
        if (this.cDs) {
            contentValues.put("systemAddressBookUsername", this.field_systemAddressBookUsername);
        }
        if (this.cDt) {
            contentValues.put("contactId", this.field_contactId);
        }
        if (this.cDu) {
            contentValues.put("sortKey", this.field_sortKey);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
