package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class y extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjZ = "userName".hashCode();
    private static final int cnJ = "brandUserName".hashCode();
    private static final int coA = "UserVersion".hashCode();
    private static final int coB = "profileUrl".hashCode();
    private static final int cok = "headImageUrl".hashCode();
    private static final int coo = "needToUpdate".hashCode();
    private static final int cop = "bitFlag".hashCode();
    private static final int cot = "addMemberUrl".hashCode();
    private static final int cov = "userId".hashCode();
    private static final int coz = "userNamePY".hashCode();
    private boolean cjD = true;
    private boolean cnY = true;
    private boolean cnv = true;
    private boolean coc = true;
    private boolean cod = true;
    private boolean coh = true;
    private boolean cou = true;
    private boolean cow = true;
    private boolean cox = true;
    private boolean coy = true;
    public int field_UserVersion;
    public String field_addMemberUrl;
    public int field_bitFlag;
    public String field_brandUserName;
    public String field_headImageUrl;
    public boolean field_needToUpdate;
    public String field_profileUrl;
    public String field_userId;
    public String field_userName;
    public String field_userNamePY;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cov == hashCode) {
                    this.field_userId = cursor.getString(i);
                    this.cou = true;
                } else if (cjZ == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (coz == hashCode) {
                    this.field_userNamePY = cursor.getString(i);
                } else if (cnJ == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (coA == hashCode) {
                    this.field_UserVersion = cursor.getInt(i);
                } else if (coo == hashCode) {
                    this.field_needToUpdate = cursor.getInt(i) != 0;
                } else if (cok == hashCode) {
                    this.field_headImageUrl = cursor.getString(i);
                } else if (coB == hashCode) {
                    this.field_profileUrl = cursor.getString(i);
                } else if (cop == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (cot == hashCode) {
                    this.field_addMemberUrl = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cou) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.cjD) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.field_userNamePY == null) {
            this.field_userNamePY = "";
        }
        if (this.cow) {
            contentValues.put("userNamePY", this.field_userNamePY);
        }
        if (this.field_brandUserName == null) {
            this.field_brandUserName = "";
        }
        if (this.cnv) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.cox) {
            contentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
        }
        if (this.coc) {
            contentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
        }
        if (this.cnY) {
            contentValues.put("headImageUrl", this.field_headImageUrl);
        }
        if (this.coy) {
            contentValues.put("profileUrl", this.field_profileUrl);
        }
        if (this.cod) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.coh) {
            contentValues.put("addMemberUrl", this.field_addMemberUrl);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
