package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ab extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int clj = "updateTime".hashCode();
    private static final int cmt = "openId".hashCode();
    private static final int cpG = "brandUsername".hashCode();
    private static final int cpH = "headImgUrl".hashCode();
    private static final int cpI = "nickname".hashCode();
    private static final int cpJ = "kfType".hashCode();
    private boolean clW = true;
    private boolean clh = true;
    private boolean cpC = true;
    private boolean cpD = true;
    private boolean cpE = true;
    private boolean cpF = true;
    public String field_brandUsername;
    public String field_headImgUrl;
    public int field_kfType;
    public String field_nickname;
    public String field_openId;
    public long field_updateTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cmt == hashCode) {
                    this.field_openId = cursor.getString(i);
                    this.clW = true;
                } else if (cpG == hashCode) {
                    this.field_brandUsername = cursor.getString(i);
                } else if (cpH == hashCode) {
                    this.field_headImgUrl = cursor.getString(i);
                } else if (cpI == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (cpJ == hashCode) {
                    this.field_kfType = cursor.getInt(i);
                } else if (clj == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.clW) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.field_brandUsername == null) {
            this.field_brandUsername = "";
        }
        if (this.cpC) {
            contentValues.put("brandUsername", this.field_brandUsername);
        }
        if (this.cpD) {
            contentValues.put("headImgUrl", this.field_headImgUrl);
        }
        if (this.cpE) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.cpF) {
            contentValues.put("kfType", Integer.valueOf(this.field_kfType));
        }
        if (this.clh) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
