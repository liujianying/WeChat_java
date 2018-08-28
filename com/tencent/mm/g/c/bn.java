package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class bn extends c {
    private static final int cAB = "cgi".hashCode();
    private static final int cAC = "cmdid".hashCode();
    private static final int cAD = "functionmsgid".hashCode();
    private static final int cAE = "preVersion".hashCode();
    private static final int cAF = "retryinterval".hashCode();
    private static final int cAG = "reportid".hashCode();
    private static final int cAH = "successkey".hashCode();
    private static final int cAI = "failkey".hashCode();
    private static final int cAJ = "finalfailkey".hashCode();
    private static final int cAK = "custombuff".hashCode();
    private static final int cAL = "addMsg".hashCode();
    private static final int cAM = "needShow".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int clC = "version".hashCode();
    private boolean cAA = true;
    private boolean cAp = true;
    private boolean cAq = true;
    private boolean cAr = true;
    private boolean cAs = true;
    private boolean cAt = true;
    private boolean cAu = true;
    private boolean cAv = true;
    private boolean cAw = true;
    private boolean cAx = true;
    private boolean cAy = true;
    private boolean cAz = true;
    private boolean ciS = true;
    private boolean clw = true;
    public by field_addMsg;
    public String field_cgi;
    public int field_cmdid;
    public String field_custombuff;
    public int field_failkey;
    public int field_finalfailkey;
    public String field_functionmsgid;
    public boolean field_needShow;
    public long field_preVersion;
    public int field_reportid;
    public int field_retryinterval;
    public int field_status;
    public int field_successkey;
    public long field_version;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cAB == hashCode) {
                    this.field_cgi = cursor.getString(i);
                } else if (cAC == hashCode) {
                    this.field_cmdid = cursor.getInt(i);
                } else if (cAD == hashCode) {
                    this.field_functionmsgid = cursor.getString(i);
                    this.cAr = true;
                } else if (clC == hashCode) {
                    this.field_version = cursor.getLong(i);
                } else if (cAE == hashCode) {
                    this.field_preVersion = cursor.getLong(i);
                } else if (cAF == hashCode) {
                    this.field_retryinterval = cursor.getInt(i);
                } else if (cAG == hashCode) {
                    this.field_reportid = cursor.getInt(i);
                } else if (cAH == hashCode) {
                    this.field_successkey = cursor.getInt(i);
                } else if (cAI == hashCode) {
                    this.field_failkey = cursor.getInt(i);
                } else if (cAJ == hashCode) {
                    this.field_finalfailkey = cursor.getInt(i);
                } else if (cAK == hashCode) {
                    this.field_custombuff = cursor.getString(i);
                } else if (cAL == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_addMsg = (by) new by().aG(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseFunctionMsgItem", e.getMessage());
                    }
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cAM == hashCode) {
                    this.field_needShow = cursor.getInt(i) != 0;
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cAp) {
            contentValues.put("cgi", this.field_cgi);
        }
        if (this.cAq) {
            contentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
        }
        if (this.cAr) {
            contentValues.put("functionmsgid", this.field_functionmsgid);
        }
        if (this.clw) {
            contentValues.put("version", Long.valueOf(this.field_version));
        }
        if (this.cAs) {
            contentValues.put("preVersion", Long.valueOf(this.field_preVersion));
        }
        if (this.cAt) {
            contentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
        }
        if (this.cAu) {
            contentValues.put("reportid", Integer.valueOf(this.field_reportid));
        }
        if (this.cAv) {
            contentValues.put("successkey", Integer.valueOf(this.field_successkey));
        }
        if (this.cAw) {
            contentValues.put("failkey", Integer.valueOf(this.field_failkey));
        }
        if (this.cAx) {
            contentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
        }
        if (this.cAy) {
            contentValues.put("custombuff", this.field_custombuff);
        }
        if (this.cAz && this.field_addMsg != null) {
            try {
                contentValues.put("addMsg", this.field_addMsg.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseFunctionMsgItem", e.getMessage());
            }
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cAA) {
            contentValues.put("needShow", Boolean.valueOf(this.field_needShow));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
