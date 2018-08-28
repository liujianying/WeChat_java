package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.db;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class ct extends c {
    private static final int cIY = "acctTypeId".hashCode();
    private static final int cIZ = "language".hashCode();
    private static final int cJd = "appid".hashCode();
    private static final int cJe = "appRec".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int clj = "updateTime".hashCode();
    private boolean cIV = true;
    private boolean cIW = true;
    private boolean cJb = true;
    private boolean cJc = true;
    private boolean clh = true;
    public String field_acctTypeId;
    public db field_appRec;
    public String field_appid;
    public String field_language;
    public long field_updateTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cJd == hashCode) {
                    this.field_appid = cursor.getString(i);
                } else if (cIZ == hashCode) {
                    this.field_language = cursor.getString(i);
                } else if (cJe == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_appRec = (db) new db().aG(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", e.getMessage());
                    }
                } else if (clj == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (cIY == hashCode) {
                    this.field_acctTypeId = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cJb) {
            contentValues.put("appid", this.field_appid);
        }
        if (this.cIW) {
            contentValues.put("language", this.field_language);
        }
        if (this.cJc && this.field_appRec != null) {
            try {
                contentValues.put("appRec", this.field_appRec.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", e.getMessage());
            }
        }
        if (this.clh) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.cIV) {
            contentValues.put("acctTypeId", this.field_acctTypeId);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
