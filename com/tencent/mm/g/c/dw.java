package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dw extends c {
    private static final int cOA = "istyle".hashCode();
    private static final int cOB = "iFlag".hashCode();
    private static final int cOC = "icount".hashCode();
    private static final int cOD = "faultS".hashCode();
    private static final int cOE = "snsBgId".hashCode();
    private static final int cOF = "snsuser".hashCode();
    private static final int cOG = "adsession".hashCode();
    private static final int cOH = "lastFirstPageRequestErrCode".hashCode();
    private static final int cOI = "lastFirstPageRequestErrType".hashCode();
    private static final int cOv = "newerIds".hashCode();
    private static final int cOw = "bgId".hashCode();
    private static final int cOx = "bgUrl".hashCode();
    private static final int cOy = "older_bgId".hashCode();
    private static final int cOz = "local_flag".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjZ = "userName".hashCode();
    private static final int cvM = "md5".hashCode();
    private boolean cOh = true;
    private boolean cOi = true;
    private boolean cOj = true;
    private boolean cOk = true;
    private boolean cOl = true;
    private boolean cOm = true;
    private boolean cOn = true;
    private boolean cOo = true;
    private boolean cOp = true;
    private boolean cOq = true;
    private boolean cOr = true;
    private boolean cOs = true;
    private boolean cOt = true;
    private boolean cOu = true;
    private boolean cjD = true;
    private boolean cvk = true;
    public byte[] field_adsession;
    public String field_bgId;
    public String field_bgUrl;
    public byte[] field_faultS;
    public int field_iFlag;
    public int field_icount;
    public int field_istyle;
    public int field_lastFirstPageRequestErrCode;
    public int field_lastFirstPageRequestErrType;
    public int field_local_flag;
    public String field_md5;
    public String field_newerIds;
    public String field_older_bgId;
    public long field_snsBgId;
    public byte[] field_snsuser;
    public String field_userName;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cjZ == hashCode) {
                    this.field_userName = cursor.getString(i);
                    this.cjD = true;
                } else if (cvM == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (cOv == hashCode) {
                    this.field_newerIds = cursor.getString(i);
                } else if (cOw == hashCode) {
                    this.field_bgId = cursor.getString(i);
                } else if (cOx == hashCode) {
                    this.field_bgUrl = cursor.getString(i);
                } else if (cOy == hashCode) {
                    this.field_older_bgId = cursor.getString(i);
                } else if (cOz == hashCode) {
                    this.field_local_flag = cursor.getInt(i);
                } else if (cOA == hashCode) {
                    this.field_istyle = cursor.getInt(i);
                } else if (cOB == hashCode) {
                    this.field_iFlag = cursor.getInt(i);
                } else if (cOC == hashCode) {
                    this.field_icount = cursor.getInt(i);
                } else if (cOD == hashCode) {
                    this.field_faultS = cursor.getBlob(i);
                } else if (cOE == hashCode) {
                    this.field_snsBgId = cursor.getLong(i);
                } else if (cOF == hashCode) {
                    this.field_snsuser = cursor.getBlob(i);
                } else if (cOG == hashCode) {
                    this.field_adsession = cursor.getBlob(i);
                } else if (cOH == hashCode) {
                    this.field_lastFirstPageRequestErrCode = cursor.getInt(i);
                } else if (cOI == hashCode) {
                    this.field_lastFirstPageRequestErrType = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.cjD) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.cvk) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.cOh) {
            contentValues.put("newerIds", this.field_newerIds);
        }
        if (this.cOi) {
            contentValues.put("bgId", this.field_bgId);
        }
        if (this.cOj) {
            contentValues.put("bgUrl", this.field_bgUrl);
        }
        if (this.cOk) {
            contentValues.put("older_bgId", this.field_older_bgId);
        }
        if (this.cOl) {
            contentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
        }
        if (this.cOm) {
            contentValues.put("istyle", Integer.valueOf(this.field_istyle));
        }
        if (this.cOn) {
            contentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
        }
        if (this.cOo) {
            contentValues.put("icount", Integer.valueOf(this.field_icount));
        }
        if (this.cOp) {
            contentValues.put("faultS", this.field_faultS);
        }
        if (this.cOq) {
            contentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
        }
        if (this.cOr) {
            contentValues.put("snsuser", this.field_snsuser);
        }
        if (this.cOs) {
            contentValues.put("adsession", this.field_adsession);
        }
        if (this.cOt) {
            contentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
        }
        if (this.cOu) {
            contentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
