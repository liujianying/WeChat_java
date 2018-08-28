package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cv extends c {
    private static final int cJq = "sceneFlag".hashCode();
    private static final int cJr = "msgTypeFlag".hashCode();
    private static final int cJs = "msgState".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int cml = "packageName".hashCode();
    private boolean cJn = true;
    private boolean cJo = true;
    private boolean cJp = true;
    private boolean ciS = true;
    private boolean cky = true;
    private boolean clO = true;
    public String field_appId;
    public int field_msgState;
    public int field_msgTypeFlag;
    public String field_packageName;
    public int field_sceneFlag;
    public int field_status;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.cky = true;
                } else if (cml == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cJq == hashCode) {
                    this.field_sceneFlag = cursor.getInt(i);
                } else if (cJr == hashCode) {
                    this.field_msgTypeFlag = cursor.getInt(i);
                } else if (cJs == hashCode) {
                    this.field_msgState = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.clO) {
            contentValues.put("packageName", this.field_packageName);
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cJn) {
            contentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
        }
        if (this.cJo) {
            contentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
        }
        if (this.cJp) {
            contentValues.put("msgState", Integer.valueOf(this.field_msgState));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
