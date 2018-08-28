package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class er extends c {
    private static final int cTu = "disable".hashCode();
    private static final int cTv = "configUrl".hashCode();
    private static final int cTw = "configResources".hashCode();
    private static final int cTx = "configCrc32".hashCode();
    private static final int cTy = "isFromXml".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cxQ = "configId".hashCode();
    private boolean cTp = true;
    private boolean cTq = true;
    private boolean cTr = true;
    private boolean cTs = true;
    private boolean cTt = true;
    private boolean cxP = true;
    public long field_configCrc32;
    public String field_configId;
    public String field_configResources;
    public String field_configUrl;
    public boolean field_disable;
    public boolean field_isFromXml;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cTu == hashCode) {
                    boolean z;
                    if (cursor.getInt(i) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.field_disable = z;
                } else if (cxQ == hashCode) {
                    this.field_configId = cursor.getString(i);
                    this.cxP = true;
                } else if (cTv == hashCode) {
                    this.field_configUrl = cursor.getString(i);
                } else if (cTw == hashCode) {
                    this.field_configResources = cursor.getString(i);
                } else if (cTx == hashCode) {
                    this.field_configCrc32 = cursor.getLong(i);
                } else if (cTy == hashCode) {
                    this.field_isFromXml = cursor.getInt(i) != 0;
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cTp) {
            contentValues.put("disable", Boolean.valueOf(this.field_disable));
        }
        if (this.cxP) {
            contentValues.put("configId", this.field_configId);
        }
        if (this.cTq) {
            contentValues.put("configUrl", this.field_configUrl);
        }
        if (this.cTr) {
            contentValues.put("configResources", this.field_configResources);
        }
        if (this.cTs) {
            contentValues.put("configCrc32", Long.valueOf(this.field_configCrc32));
        }
        if (this.cTt) {
            contentValues.put("isFromXml", Boolean.valueOf(this.field_isFromXml));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
