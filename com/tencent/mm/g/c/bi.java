package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bi extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cnf = "title".hashCode();
    private static final int cqH = "url".hashCode();
    private static final int cyL = "featureId".hashCode();
    private static final int cyM = "titlePY".hashCode();
    private static final int cyN = "titleShortPY".hashCode();
    private static final int cyO = "tag".hashCode();
    private static final int cyP = "actionType".hashCode();
    private static final int cyQ = "helpUrl".hashCode();
    private static final int cyR = "updateUrl".hashCode();
    private static final int cyS = "androidUrl".hashCode();
    private static final int cyT = "iconPath".hashCode();
    private static final int cyU = "timestamp".hashCode();
    private boolean cnb = true;
    private boolean cqo = true;
    private boolean cyB = true;
    private boolean cyC = true;
    private boolean cyD = true;
    private boolean cyE = true;
    private boolean cyF = true;
    private boolean cyG = true;
    private boolean cyH = true;
    private boolean cyI = true;
    private boolean cyJ = true;
    private boolean cyK = true;
    public int field_actionType;
    public String field_androidUrl;
    public int field_featureId;
    public String field_helpUrl;
    public String field_iconPath;
    public String field_tag;
    public long field_timestamp;
    public String field_title;
    public String field_titlePY;
    public String field_titleShortPY;
    public String field_updateUrl;
    public String field_url;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cyL == hashCode) {
                    this.field_featureId = cursor.getInt(i);
                    this.cyB = true;
                } else if (cnf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (cyM == hashCode) {
                    this.field_titlePY = cursor.getString(i);
                } else if (cyN == hashCode) {
                    this.field_titleShortPY = cursor.getString(i);
                } else if (cyO == hashCode) {
                    this.field_tag = cursor.getString(i);
                } else if (cyP == hashCode) {
                    this.field_actionType = cursor.getInt(i);
                } else if (cqH == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (cyQ == hashCode) {
                    this.field_helpUrl = cursor.getString(i);
                } else if (cyR == hashCode) {
                    this.field_updateUrl = cursor.getString(i);
                } else if (cyS == hashCode) {
                    this.field_androidUrl = cursor.getString(i);
                } else if (cyT == hashCode) {
                    this.field_iconPath = cursor.getString(i);
                } else if (cyU == hashCode) {
                    this.field_timestamp = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cyB) {
            contentValues.put("featureId", Integer.valueOf(this.field_featureId));
        }
        if (this.cnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.cyC) {
            contentValues.put("titlePY", this.field_titlePY);
        }
        if (this.cyD) {
            contentValues.put("titleShortPY", this.field_titleShortPY);
        }
        if (this.cyE) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.cyF) {
            contentValues.put("actionType", Integer.valueOf(this.field_actionType));
        }
        if (this.cqo) {
            contentValues.put("url", this.field_url);
        }
        if (this.cyG) {
            contentValues.put("helpUrl", this.field_helpUrl);
        }
        if (this.cyH) {
            contentValues.put("updateUrl", this.field_updateUrl);
        }
        if (this.cyI) {
            contentValues.put("androidUrl", this.field_androidUrl);
        }
        if (this.cyJ) {
            contentValues.put("iconPath", this.field_iconPath);
        }
        if (this.cyK) {
            contentValues.put("timestamp", Long.valueOf(this.field_timestamp));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
