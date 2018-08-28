package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class db extends c {
    private static final int cJO = "sceneList".hashCode();
    private static final int cJP = "cgiList".hashCode();
    private static final int cJQ = "reportId".hashCode();
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestAppIDIndex ON PredownloadBlockCgiRequest(appId)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestStartTimeIndex ON PredownloadBlockCgiRequest(startTime)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestEndTimeIndex ON PredownloadBlockCgiRequest(endTime)"};
    private static final int ciP = "rowid".hashCode();
    private static final int cjj = "startTime".hashCode();
    private static final int cjk = "endTime".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int cli = "username".hashCode();
    private boolean cJL = true;
    private boolean cJM = true;
    private boolean cJN = true;
    private boolean cjb = true;
    private boolean cjc = true;
    private boolean cky = true;
    private boolean clg = true;
    public String field_appId;
    public String field_cgiList;
    public long field_endTime;
    public int field_reportId;
    public String field_sceneList;
    public long field_startTime;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.clg = true;
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cjj == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (cjk == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (cJO == hashCode) {
                    this.field_sceneList = cursor.getString(i);
                } else if (cJP == hashCode) {
                    this.field_cgiList = cursor.getString(i);
                } else if (cJQ == hashCode) {
                    this.field_reportId = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.cjb) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.cjc) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.cJL) {
            contentValues.put("sceneList", this.field_sceneList);
        }
        if (this.cJM) {
            contentValues.put("cgiList", this.field_cgiList);
        }
        if (this.cJN) {
            contentValues.put("reportId", Integer.valueOf(this.field_reportId));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
