package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ch extends c {
    private static final int cEa = "createtime".hashCode();
    private static final int cEb = "sayhiuser".hashCode();
    private static final int cEc = "sayhicontent".hashCode();
    private static final int cEd = "imgpath".hashCode();
    private static final int cEe = "sayhiencryptuser".hashCode();
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS lbsverifymessage_unread_index ON LBSVerifyMessage(status)", "CREATE INDEX IF NOT EXISTS lbsverifymessage_createtimeIndex ON LBSVerifyMessage(createtime)"};
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int cke = "type".hashCode();
    private static final int ckj = "content".hashCode();
    private static final int ckw = "scene".hashCode();
    private static final int ckx = "ticket".hashCode();
    private static final int cnT = "isSend".hashCode();
    private static final int cnk = "flag".hashCode();
    private static final int cpT = "talker".hashCode();
    private static final int cvN = "svrid".hashCode();
    private boolean cDV = true;
    private boolean cDW = true;
    private boolean cDX = true;
    private boolean cDY = true;
    private boolean cDZ = true;
    private boolean ciS = true;
    private boolean cjI = true;
    private boolean cjN = true;
    private boolean cku = true;
    private boolean ckv = true;
    private boolean cnF = true;
    private boolean cni = true;
    private boolean cpL = true;
    private boolean cvl = true;
    public String field_content;
    public long field_createtime;
    public int field_flag;
    public String field_imgpath;
    public int field_isSend;
    public String field_sayhicontent;
    public String field_sayhiencryptuser;
    public String field_sayhiuser;
    public int field_scene;
    public int field_status;
    public long field_svrid;
    public String field_talker;
    public String field_ticket;
    public int field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cvN == hashCode) {
                    this.field_svrid = cursor.getLong(i);
                    this.cvl = true;
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (ckw == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (cEa == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (cpT == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (ckj == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (cEb == hashCode) {
                    this.field_sayhiuser = cursor.getString(i);
                } else if (cEc == hashCode) {
                    this.field_sayhicontent = cursor.getString(i);
                } else if (cEd == hashCode) {
                    this.field_imgpath = cursor.getString(i);
                } else if (cnT == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (cEe == hashCode) {
                    this.field_sayhiencryptuser = cursor.getString(i);
                } else if (ckx == hashCode) {
                    this.field_ticket = cursor.getString(i);
                } else if (cnk == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cvl) {
            contentValues.put("svrid", Long.valueOf(this.field_svrid));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.cku) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.cDV) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.cpL) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.cjN) {
            contentValues.put("content", this.field_content);
        }
        if (this.cDW) {
            contentValues.put("sayhiuser", this.field_sayhiuser);
        }
        if (this.cDX) {
            contentValues.put("sayhicontent", this.field_sayhicontent);
        }
        if (this.cDY) {
            contentValues.put("imgpath", this.field_imgpath);
        }
        if (this.cnF) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.cDZ) {
            contentValues.put("sayhiencryptuser", this.field_sayhiencryptuser);
        }
        if (this.ckv) {
            contentValues.put("ticket", this.field_ticket);
        }
        if (this.cni) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
