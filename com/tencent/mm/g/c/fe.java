package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fe extends c {
    private static final int cVE = "RecordId".hashCode();
    private static final int cVF = "AppId".hashCode();
    private static final int cVG = "AppName".hashCode();
    private static final int cVH = "UserName".hashCode();
    private static final int cVI = "IconUrl".hashCode();
    private static final int cVJ = "BriefIntro".hashCode();
    private static final int cVK = "isSync".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int clG = "debugType".hashCode();
    private boolean cVA = true;
    private boolean cVB = true;
    private boolean cVC = true;
    private boolean cVD = true;
    private boolean cVx = true;
    private boolean cVy = true;
    private boolean cVz = true;
    private boolean cjF = true;
    private boolean clA = true;
    public String field_AppId;
    public String field_AppName;
    public String field_BriefIntro;
    public String field_IconUrl;
    public String field_RecordId;
    public String field_UserName;
    public long field_createTime;
    public int field_debugType;
    public boolean field_isSync;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cVE == hashCode) {
                    this.field_RecordId = cursor.getString(i);
                    this.cVx = true;
                } else if (cVF == hashCode) {
                    this.field_AppId = cursor.getString(i);
                } else if (cVG == hashCode) {
                    this.field_AppName = cursor.getString(i);
                } else if (cVH == hashCode) {
                    this.field_UserName = cursor.getString(i);
                } else if (cVI == hashCode) {
                    this.field_IconUrl = cursor.getString(i);
                } else if (cVJ == hashCode) {
                    this.field_BriefIntro = cursor.getString(i);
                } else if (cVK == hashCode) {
                    this.field_isSync = cursor.getInt(i) != 0;
                } else if (clG == hashCode) {
                    this.field_debugType = cursor.getInt(i);
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cVx) {
            contentValues.put("RecordId", this.field_RecordId);
        }
        if (this.cVy) {
            contentValues.put("AppId", this.field_AppId);
        }
        if (this.cVz) {
            contentValues.put("AppName", this.field_AppName);
        }
        if (this.cVA) {
            contentValues.put("UserName", this.field_UserName);
        }
        if (this.cVB) {
            contentValues.put("IconUrl", this.field_IconUrl);
        }
        if (this.cVC) {
            contentValues.put("BriefIntro", this.field_BriefIntro);
        }
        if (this.cVD) {
            contentValues.put("isSync", Boolean.valueOf(this.field_isSync));
        }
        if (this.clA) {
            contentValues.put("debugType", Integer.valueOf(this.field_debugType));
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
