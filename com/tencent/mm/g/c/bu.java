package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bu extends c {
    private static final int cCa = "googleid".hashCode();
    private static final int cCb = "googlename".hashCode();
    private static final int cCc = "googlephotourl".hashCode();
    private static final int cCd = "googlegmail".hashCode();
    private static final int cCe = "nicknameqp".hashCode();
    private static final int cCf = "usernamepy".hashCode();
    private static final int cCg = "small_url".hashCode();
    private static final int cCh = "big_url".hashCode();
    private static final int cCi = "ret".hashCode();
    private static final int cCj = "googleitemid".hashCode();
    private static final int cCk = "googlecgistatus".hashCode();
    private static final int cCl = "contecttype".hashCode();
    private static final int cCm = "googlenamepy".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int cli = "username".hashCode();
    private static final int cpI = "nickname".hashCode();
    private boolean cBN = true;
    private boolean cBO = true;
    private boolean cBP = true;
    private boolean cBQ = true;
    private boolean cBR = true;
    private boolean cBS = true;
    private boolean cBT = true;
    private boolean cBU = true;
    private boolean cBV = true;
    private boolean cBW = true;
    private boolean cBX = true;
    private boolean cBY = true;
    private boolean cBZ = true;
    private boolean ciS = true;
    private boolean clg = true;
    private boolean cpE = true;
    public String field_big_url;
    public String field_contecttype;
    public int field_googlecgistatus;
    public String field_googlegmail;
    public String field_googleid;
    public String field_googleitemid;
    public String field_googlename;
    public String field_googlenamepy;
    public String field_googlephotourl;
    public String field_nickname;
    public String field_nicknameqp;
    public int field_ret;
    public String field_small_url;
    public int field_status;
    public String field_username;
    public String field_usernamepy;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cCa == hashCode) {
                    this.field_googleid = cursor.getString(i);
                } else if (cCb == hashCode) {
                    this.field_googlename = cursor.getString(i);
                } else if (cCc == hashCode) {
                    this.field_googlephotourl = cursor.getString(i);
                } else if (cCd == hashCode) {
                    this.field_googlegmail = cursor.getString(i);
                } else if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (cpI == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (cCe == hashCode) {
                    this.field_nicknameqp = cursor.getString(i);
                } else if (cCf == hashCode) {
                    this.field_usernamepy = cursor.getString(i);
                } else if (cCg == hashCode) {
                    this.field_small_url = cursor.getString(i);
                } else if (cCh == hashCode) {
                    this.field_big_url = cursor.getString(i);
                } else if (cCi == hashCode) {
                    this.field_ret = cursor.getInt(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cCj == hashCode) {
                    this.field_googleitemid = cursor.getString(i);
                    this.cBW = true;
                } else if (cCk == hashCode) {
                    this.field_googlecgistatus = cursor.getInt(i);
                } else if (cCl == hashCode) {
                    this.field_contecttype = cursor.getString(i);
                } else if (cCm == hashCode) {
                    this.field_googlenamepy = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cBN) {
            contentValues.put("googleid", this.field_googleid);
        }
        if (this.cBO) {
            contentValues.put("googlename", this.field_googlename);
        }
        if (this.cBP) {
            contentValues.put("googlephotourl", this.field_googlephotourl);
        }
        if (this.cBQ) {
            contentValues.put("googlegmail", this.field_googlegmail);
        }
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.cpE) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.cBR) {
            contentValues.put("nicknameqp", this.field_nicknameqp);
        }
        if (this.cBS) {
            contentValues.put("usernamepy", this.field_usernamepy);
        }
        if (this.cBT) {
            contentValues.put("small_url", this.field_small_url);
        }
        if (this.cBU) {
            contentValues.put("big_url", this.field_big_url);
        }
        if (this.cBV) {
            contentValues.put("ret", Integer.valueOf(this.field_ret));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cBW) {
            contentValues.put("googleitemid", this.field_googleitemid);
        }
        if (this.cBX) {
            contentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
        }
        if (this.cBY) {
            contentValues.put("contecttype", this.field_contecttype);
        }
        if (this.cBZ) {
            contentValues.put("googlenamepy", this.field_googlenamepy);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
