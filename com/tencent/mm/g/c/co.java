package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class co extends c {
    private static final int cGT = "wxGroupId".hashCode();
    private static final int cGX = "inviteUserName".hashCode();
    private static final int cHb = "memberUuid".hashCode();
    private static final int cHc = "memberId".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int cjZ = "userName".hashCode();
    private static final int ckb = "createTime".hashCode();
    private boolean cGN = true;
    private boolean cGR = true;
    private boolean cGZ = true;
    private boolean cHa = true;
    private boolean ciS = true;
    private boolean cjD = true;
    private boolean cjF = true;
    public long field_createTime;
    public String field_inviteUserName;
    public long field_memberId;
    public long field_memberUuid;
    public int field_status;
    public String field_userName;
    public String field_wxGroupId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cHb == hashCode) {
                    this.field_memberUuid = cursor.getLong(i);
                } else if (cGT == hashCode) {
                    this.field_wxGroupId = cursor.getString(i);
                } else if (cjZ == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (cGX == hashCode) {
                    this.field_inviteUserName = cursor.getString(i);
                } else if (cHc == hashCode) {
                    this.field_memberId = cursor.getLong(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
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
        if (this.cGZ) {
            contentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
        }
        if (this.cGN) {
            contentValues.put("wxGroupId", this.field_wxGroupId);
        }
        if (this.cjD) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.cGR) {
            contentValues.put("inviteUserName", this.field_inviteUserName);
        }
        if (this.cHa) {
            contentValues.put("memberId", Long.valueOf(this.field_memberId));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
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
