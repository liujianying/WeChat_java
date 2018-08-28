package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;

public abstract class cm extends c {
    private static final int cBM = "msgSeq".hashCode();
    private static final int cGA = "bizChatUserId".hashCode();
    private static final int cGv = "isShowTimer".hashCode();
    private static final int cGw = "reserved".hashCode();
    private static final int cGx = "transContent".hashCode();
    private static final int cGy = "transBrandWording".hashCode();
    private static final int cGz = "bizClientMsgId".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciO = "msgId".hashCode();
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int cke = "type".hashCode();
    private static final int ckj = "content".hashCode();
    private static final int cnI = "bizChatId".hashCode();
    private static final int cnT = "isSend".hashCode();
    private static final int cnk = "flag".hashCode();
    private static final int cpS = "msgSvrId".hashCode();
    private static final int cpT = "talker".hashCode();
    private static final int cpU = "imgPath".hashCode();
    private static final int cpV = "lvbuffer".hashCode();
    private static final int cpW = "talkerId".hashCode();
    private String bZN;
    private boolean cBG = false;
    public String cGB;
    public int cGC;
    public int cGD;
    public int cGE;
    public int cGF;
    public int cGG;
    public int cGH;
    public String cGI;
    public String cGJ;
    public String cGK;
    public int cGL;
    public byte[] cGM;
    public boolean cGp = false;
    private boolean cGq = false;
    private boolean cGr = false;
    public boolean cGs = false;
    private boolean cGt = false;
    public boolean cGu = false;
    private boolean ciK = false;
    private boolean ciS = false;
    private boolean cjF = false;
    private boolean cjI = false;
    private boolean cjN = false;
    private boolean cnF = false;
    private boolean cni = false;
    private boolean cnu = false;
    private boolean cpK = false;
    private boolean cpL = false;
    private boolean cpM = false;
    public boolean cpN = false;
    public boolean cpO = false;
    public int cqa;
    public String cqb;
    public long field_bizChatId;
    public String field_bizChatUserId;
    private String field_bizClientMsgId;
    public String field_content;
    public long field_createTime;
    public int field_flag;
    public String field_imgPath;
    public int field_isSend;
    public int field_isShowTimer;
    public byte[] field_lvbuffer;
    public long field_msgId;
    public long field_msgSeq;
    public long field_msgSvrId;
    public String field_reserved;
    public int field_status;
    public String field_talker;
    public int field_talkerId;
    public String field_transBrandWording;
    public String field_transContent;
    private int field_type;

    public final void setMsgId(long j) {
        this.field_msgId = j;
        this.ciK = true;
    }

    public final void ax(long j) {
        this.field_msgSvrId = j;
        this.cpK = true;
    }

    public final long wW() {
        return this.field_msgSvrId;
    }

    public final void setType(int i) {
        this.field_type = i;
        this.cjI = true;
    }

    public int getType() {
        return this.field_type;
    }

    public void setStatus(int i) {
        this.field_status = i;
        this.ciS = true;
    }

    public final void eX(int i) {
        this.field_isSend = i;
        this.cnF = true;
    }

    public final int wX() {
        return this.field_isSend;
    }

    public final void ay(long j) {
        this.field_createTime = j;
        this.cjF = true;
    }

    public final long wY() {
        return this.field_createTime;
    }

    public final void ep(String str) {
        this.field_talker = str;
        this.cpL = true;
    }

    public final String wZ() {
        return this.field_talker;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.cjN = true;
    }

    public final String getContent() {
        return this.field_content;
    }

    public final void eq(String str) {
        this.field_imgPath = str;
        this.cpM = true;
    }

    public final void er(String str) {
        this.field_reserved = str;
        this.cGq = true;
    }

    public final void C(byte[] bArr) {
        this.field_lvbuffer = bArr;
        this.cpN = true;
    }

    public final void es(String str) {
        this.field_transContent = str;
        this.cGr = true;
    }

    public final void et(String str) {
        this.field_bizClientMsgId = str;
        this.cGt = true;
    }

    public final void az(long j) {
        this.field_bizChatId = j;
        this.cnu = true;
    }

    public final void aA(long j) {
        this.field_msgSeq = j;
        this.cBG = true;
    }

    public final void fg(int i) {
        this.field_flag = i;
        this.cni = true;
    }

    public void d(Cursor cursor) {
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
                } else if (cnT == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (cGv == hashCode) {
                    this.field_isShowTimer = cursor.getInt(i);
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (cpT == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (ckj == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (cpU == hashCode) {
                    this.field_imgPath = cursor.getString(i);
                } else if (cGw == hashCode) {
                    this.field_reserved = cursor.getString(i);
                } else if (cpV == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (cpW == hashCode) {
                    this.field_talkerId = cursor.getInt(i);
                } else if (cGx == hashCode) {
                    this.field_transContent = cursor.getString(i);
                } else if (cGy == hashCode) {
                    this.field_transBrandWording = cursor.getString(i);
                } else if (cGz == hashCode) {
                    this.field_bizClientMsgId = cursor.getString(i);
                } else if (cnI == hashCode) {
                    this.field_bizChatId = cursor.getLong(i);
                } else if (cGA == hashCode) {
                    this.field_bizChatUserId = cursor.getString(i);
                } else if (cBM == hashCode) {
                    this.field_msgSeq = cursor.getLong(i);
                } else if (cnk == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuffer != null && this.field_lvbuffer.length != 0) {
                    u uVar = new u();
                    int by = uVar.by(this.field_lvbuffer);
                    if (by != 0) {
                        x.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:" + by);
                        return;
                    }
                    if (!uVar.chD()) {
                        this.cGB = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cqa = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cqb = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cGC = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cGD = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cGE = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cGF = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cGG = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cGH = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cGI = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cGJ = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cGK = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cGL = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.bZN = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cGM = uVar.getBuffer();
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
            }
        }
    }

    public ContentValues wH() {
        try {
            if (this.cpN) {
                u uVar = new u();
                uVar.chE();
                uVar.Wj(this.cGB);
                uVar.CZ(this.cqa);
                uVar.Wj(this.cqb);
                uVar.CZ(this.cGC);
                uVar.CZ(this.cGD);
                uVar.CZ(this.cGE);
                uVar.CZ(this.cGF);
                uVar.CZ(this.cGG);
                uVar.CZ(this.cGH);
                uVar.Wj(this.cGI);
                uVar.Wj(this.cGJ);
                uVar.Wj(this.cGK);
                uVar.CZ(this.cGL);
                uVar.Wj(this.bZN);
                uVar.bz(this.cGM);
                this.field_lvbuffer = uVar.chF();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", e.getMessage());
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
        if (this.cnF) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.cGp) {
            contentValues.put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
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
        if (this.cGq) {
            contentValues.put("reserved", this.field_reserved);
        }
        if (this.cpN) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.cpO) {
            contentValues.put("talkerId", Integer.valueOf(this.field_talkerId));
        }
        if (this.field_transContent == null) {
            this.field_transContent = "";
        }
        if (this.cGr) {
            contentValues.put("transContent", this.field_transContent);
        }
        if (this.field_transBrandWording == null) {
            this.field_transBrandWording = "";
        }
        if (this.cGs) {
            contentValues.put("transBrandWording", this.field_transBrandWording);
        }
        if (this.field_bizClientMsgId == null) {
            this.field_bizClientMsgId = "";
        }
        if (this.cGt) {
            contentValues.put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.cnu) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.field_bizChatUserId == null) {
            this.field_bizChatUserId = "";
        }
        if (this.cGu) {
            contentValues.put("bizChatUserId", this.field_bizChatUserId);
        }
        if (this.cBG) {
            contentValues.put("msgSeq", Long.valueOf(this.field_msgSeq));
        }
        if (this.cni) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }

    public final void eu(String str) {
        this.cGB = str;
        this.cpN = true;
    }

    public final void eC(int i) {
        this.cqa = i;
        this.cpN = true;
    }

    public final void dt(String str) {
        this.cqb = str;
        this.cpN = true;
    }

    public final void fh(int i) {
        this.cGC = i;
        this.cpN = true;
    }

    public final void fi(int i) {
        this.cGD = i;
        this.cpN = true;
    }

    public final void fj(int i) {
        this.cGH = i;
        this.cpN = true;
    }

    public final void ev(String str) {
        this.cGJ = str;
        this.cpN = true;
    }

    public final void ew(String str) {
        this.cGK = str;
        this.cpN = true;
    }

    public final void fk(int i) {
        this.cGL = i;
        this.cpN = true;
    }
}
