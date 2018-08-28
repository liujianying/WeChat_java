package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class b extends c {
    public static final String[] ciG = new String[0];
    private static final int ciM = "insertmsg".hashCode();
    private static final int ciP = "rowid".hashCode();
    private static final int ciT = "billNo".hashCode();
    private static final int ciU = "localMsgId".hashCode();
    private static final int ciV = "status".hashCode();
    private boolean ciI = true;
    private boolean ciQ = true;
    private boolean ciR = true;
    private boolean ciS = true;
    public String field_billNo;
    public boolean field_insertmsg;
    public long field_localMsgId;
    public int field_status;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ciT == hashCode) {
                    this.field_billNo = cursor.getString(i);
                    this.ciQ = true;
                } else if (ciM == hashCode) {
                    this.field_insertmsg = cursor.getInt(i) != 0;
                } else if (ciU == hashCode) {
                    this.field_localMsgId = cursor.getLong(i);
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
        if (this.ciQ) {
            contentValues.put("billNo", this.field_billNo);
        }
        if (this.ciI) {
            contentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
        }
        if (this.ciR) {
            contentValues.put("localMsgId", Long.valueOf(this.field_localMsgId));
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
