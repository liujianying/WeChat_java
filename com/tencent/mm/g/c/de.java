package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class de extends c {
    private static final int cJQ = "reportId".hashCode();
    private static final int cKg = "launchProtoBlob".hashCode();
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableStartTimeIndex ON PredownloadIssueLaunchWxaAppResponse(startTime)", "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableEndTimeIndex ON PredownloadIssueLaunchWxaAppResponse(endTime)"};
    private static final int ciP = "rowid".hashCode();
    private static final int cjj = "startTime".hashCode();
    private static final int cjk = "endTime".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int ckw = "scene".hashCode();
    private boolean cJN = true;
    private boolean cKf = true;
    private boolean cjb = true;
    private boolean cjc = true;
    private boolean cku = true;
    private boolean cky = true;
    public String field_appId;
    public long field_endTime;
    public byte[] field_launchProtoBlob;
    public long field_reportId;
    public int field_scene;
    public long field_startTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (ckw == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (cKg == hashCode) {
                    this.field_launchProtoBlob = cursor.getBlob(i);
                } else if (cjj == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (cjk == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (cJQ == hashCode) {
                    this.field_reportId = cursor.getLong(i);
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
        if (this.cku) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.cKf) {
            contentValues.put("launchProtoBlob", this.field_launchProtoBlob);
        }
        if (this.cjb) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.cjc) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.cJN) {
            contentValues.put("reportId", Long.valueOf(this.field_reportId));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
