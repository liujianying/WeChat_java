package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;

public abstract class ac extends c {
    public static final String[] ciG = new String[0];
    private static final int ciO = "msgId".hashCode();
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int cke = "type".hashCode();
    private static final int ckj = "content".hashCode();
    private static final int cpS = "msgSvrId".hashCode();
    private static final int cpT = "talker".hashCode();
    private static final int cpU = "imgPath".hashCode();
    private static final int cpV = "lvbuffer".hashCode();
    private static final int cpW = "talkerId".hashCode();
    private static final int cpX = "isExpand".hashCode();
    private static final int cpY = "orderFlag".hashCode();
    private static final int cpZ = "hasShow".hashCode();
    private boolean ciK = true;
    private boolean ciS = true;
    private boolean cjF = true;
    private boolean cjI = true;
    private boolean cjN = true;
    private boolean cpK = true;
    private boolean cpL = true;
    private boolean cpM = true;
    private boolean cpN = true;
    private boolean cpO = true;
    private boolean cpP = true;
    private boolean cpQ = true;
    private boolean cpR = true;
    private int cqa;
    private String cqb;
    public String field_content;
    public long field_createTime;
    public int field_hasShow;
    public String field_imgPath;
    public boolean field_isExpand;
    public byte[] field_lvbuffer;
    public long field_msgId;
    public long field_msgSvrId;
    public long field_orderFlag;
    public int field_status;
    public String field_talker;
    public int field_talkerId;
    public int field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ciO == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.ciK = true;
                } else if (cpS == hashCode) {
                    this.field_msgSvrId = cursor.getLong(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (cpT == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (ckj == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (cpU == hashCode) {
                    this.field_imgPath = cursor.getString(i);
                } else if (cpV == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (cpW == hashCode) {
                    this.field_talkerId = cursor.getInt(i);
                } else if (cpX == hashCode) {
                    this.field_isExpand = cursor.getInt(i) != 0;
                } else if (cpY == hashCode) {
                    this.field_orderFlag = cursor.getLong(i);
                } else if (cpZ == hashCode) {
                    this.field_hasShow = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuffer != null && this.field_lvbuffer.length != 0) {
                    u uVar = new u();
                    int by = uVar.by(this.field_lvbuffer);
                    if (by != 0) {
                        x.e("MicroMsg.SDK.BaseBizTimeLineInfo", "parse LVBuffer error:" + by);
                        return;
                    }
                    if (!uVar.chD()) {
                        this.cqa = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cqb = uVar.getString();
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed");
            }
        }
    }

    public final ContentValues wH() {
        try {
            if (this.cpN) {
                u uVar = new u();
                uVar.chE();
                uVar.CZ(this.cqa);
                uVar.Wj(this.cqb);
                this.field_lvbuffer = uVar.chF();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed, %s", new Object[]{e.getMessage()});
        }
        ContentValues contentValues = new ContentValues();
        if (this.ciK) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.cpK) {
            contentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.cpL) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.cjN) {
            contentValues.put("content", this.field_content);
        }
        if (this.cpM) {
            contentValues.put("imgPath", this.field_imgPath);
        }
        if (this.cpN) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.cpO) {
            contentValues.put("talkerId", Integer.valueOf(this.field_talkerId));
        }
        if (this.cpP) {
            contentValues.put("isExpand", Boolean.valueOf(this.field_isExpand));
        }
        if (this.cpQ) {
            contentValues.put("orderFlag", Long.valueOf(this.field_orderFlag));
        }
        if (this.cpR) {
            contentValues.put("hasShow", Integer.valueOf(this.field_hasShow));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }

    public final void eC(int i) {
        this.cqa = i;
        this.cpN = true;
    }

    public final void dt(String str) {
        this.cqb = str;
        this.cpN = true;
    }
}
