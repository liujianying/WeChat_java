package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class am extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int ckj = "content".hashCode();
    private static final int cli = "username".hashCode();
    private static final int cnK = "unReadCount".hashCode();
    private static final int cnO = "digest".hashCode();
    private static final int cnP = "digestUser".hashCode();
    private static final int cnQ = "atCount".hashCode();
    private static final int cnR = "editingMsg".hashCode();
    private static final int cnT = "isSend".hashCode();
    private static final int cnU = "msgType".hashCode();
    private static final int cnV = "msgCount".hashCode();
    private static final int cnk = "flag".hashCode();
    private static final int ctJ = "chatmode".hashCode();
    private static final int ctK = "conversationTime".hashCode();
    private static final int ctL = "customNotify".hashCode();
    private static final int ctM = "showTips".hashCode();
    private static final int ctN = "hasTrunc".hashCode();
    private static final int ctO = "parentRef".hashCode();
    private static final int ctP = "attrflag".hashCode();
    private static final int ctQ = "sightTime".hashCode();
    private static final int ctR = "unReadMuteCount".hashCode();
    private static final int ctS = "lastSeq".hashCode();
    private static final int ctT = "UnDeliverCount".hashCode();
    private static final int ctU = "UnReadInvite".hashCode();
    private static final int ctV = "firstUnDeliverSeq".hashCode();
    private boolean ciS = false;
    private boolean cjN = false;
    private boolean clg = false;
    private boolean cnA = false;
    private boolean cnB = false;
    private boolean cnC = false;
    private boolean cnD = false;
    private boolean cnF = false;
    private boolean cnG = false;
    private boolean cnH = false;
    private boolean cni = false;
    private boolean cnw = false;
    private boolean ctA = false;
    private boolean ctB = false;
    private boolean ctC = false;
    public boolean ctD = false;
    private boolean ctE = false;
    private boolean ctF = false;
    private boolean ctG = false;
    private boolean ctH = false;
    private boolean ctI = false;
    private boolean ctv = false;
    private boolean ctw = false;
    private boolean cty = false;
    public boolean ctz = false;
    public int field_UnDeliverCount;
    public int field_UnReadInvite;
    public int field_atCount;
    public int field_attrflag;
    public int field_chatmode;
    public String field_content;
    public long field_conversationTime;
    private String field_customNotify;
    public String field_digest;
    public String field_digestUser;
    public String field_editingMsg;
    public long field_firstUnDeliverSeq;
    public long field_flag;
    private int field_hasTrunc;
    public int field_isSend;
    public long field_lastSeq;
    public int field_msgCount;
    public String field_msgType;
    public String field_parentRef;
    public int field_showTips;
    public long field_sightTime;
    public int field_status;
    public int field_unReadCount;
    public int field_unReadMuteCount;
    public String field_username;

    public final void eU(int i) {
        this.field_msgCount = i;
        this.cnH = true;
    }

    public final void setUsername(String str) {
        this.field_username = str;
        this.clg = true;
    }

    public final String getUsername() {
        return this.field_username;
    }

    public final void eV(int i) {
        this.field_unReadCount = i;
        this.cnw = true;
    }

    public final void eW(int i) {
        this.field_chatmode = i;
        this.ctv = true;
    }

    public final void setStatus(int i) {
        this.field_status = i;
        this.ciS = true;
    }

    public final void eX(int i) {
        this.field_isSend = i;
        this.cnF = true;
    }

    public final void as(long j) {
        this.field_conversationTime = j;
        this.ctw = true;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.cjN = true;
    }

    public final void ec(String str) {
        this.field_msgType = str;
        this.cnG = true;
    }

    public final void at(long j) {
        this.field_flag = j;
        this.cni = true;
    }

    public final void ed(String str) {
        this.field_digest = str;
        this.cnA = true;
    }

    public final void ee(String str) {
        this.field_digestUser = str;
        this.cnB = true;
    }

    public final void eY(int i) {
        this.field_hasTrunc = i;
        this.ctA = true;
    }

    public final void ef(String str) {
        this.field_parentRef = str;
        this.ctB = true;
    }

    public final void eZ(int i) {
        this.field_attrflag = i;
        this.ctC = true;
    }

    public final void eg(String str) {
        this.field_editingMsg = str;
        this.cnD = true;
    }

    public final void fa(int i) {
        this.field_atCount = i;
        this.cnC = true;
    }

    public final void fb(int i) {
        this.field_unReadMuteCount = i;
        this.ctE = true;
    }

    public final void au(long j) {
        this.field_lastSeq = j;
        this.ctF = true;
    }

    public final long wT() {
        return this.field_lastSeq;
    }

    public final void fc(int i) {
        this.field_UnDeliverCount = i;
        this.ctG = true;
    }

    public final int wU() {
        return this.field_UnDeliverCount;
    }

    public final void fd(int i) {
        this.field_UnReadInvite = i;
        this.ctH = true;
    }

    public final void av(long j) {
        this.field_firstUnDeliverSeq = j;
        this.ctI = true;
    }

    public final long wV() {
        return this.field_firstUnDeliverSeq;
    }

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cnV == hashCode) {
                    this.field_msgCount = cursor.getInt(i);
                } else if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.clg = true;
                } else if (cnK == hashCode) {
                    this.field_unReadCount = cursor.getInt(i);
                } else if (ctJ == hashCode) {
                    this.field_chatmode = cursor.getInt(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cnT == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (ctK == hashCode) {
                    this.field_conversationTime = cursor.getLong(i);
                } else if (ckj == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (cnU == hashCode) {
                    this.field_msgType = cursor.getString(i);
                } else if (ctL == hashCode) {
                    this.field_customNotify = cursor.getString(i);
                } else if (ctM == hashCode) {
                    this.field_showTips = cursor.getInt(i);
                } else if (cnk == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (cnO == hashCode) {
                    this.field_digest = cursor.getString(i);
                } else if (cnP == hashCode) {
                    this.field_digestUser = cursor.getString(i);
                } else if (ctN == hashCode) {
                    this.field_hasTrunc = cursor.getInt(i);
                } else if (ctO == hashCode) {
                    this.field_parentRef = cursor.getString(i);
                } else if (ctP == hashCode) {
                    this.field_attrflag = cursor.getInt(i);
                } else if (cnR == hashCode) {
                    this.field_editingMsg = cursor.getString(i);
                } else if (cnQ == hashCode) {
                    this.field_atCount = cursor.getInt(i);
                } else if (ctQ == hashCode) {
                    this.field_sightTime = cursor.getLong(i);
                } else if (ctR == hashCode) {
                    this.field_unReadMuteCount = cursor.getInt(i);
                } else if (ctS == hashCode) {
                    this.field_lastSeq = cursor.getLong(i);
                } else if (ctT == hashCode) {
                    this.field_UnDeliverCount = cursor.getInt(i);
                } else if (ctU == hashCode) {
                    this.field_UnReadInvite = cursor.getInt(i);
                } else if (ctV == hashCode) {
                    this.field_firstUnDeliverSeq = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cnH) {
            contentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
        }
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.cnw) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.ctv) {
            contentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cnF) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.ctw) {
            contentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.cjN) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_msgType == null) {
            this.field_msgType = "";
        }
        if (this.cnG) {
            contentValues.put("msgType", this.field_msgType);
        }
        if (this.field_customNotify == null) {
            this.field_customNotify = "";
        }
        if (this.cty) {
            contentValues.put("customNotify", this.field_customNotify);
        }
        if (this.ctz) {
            contentValues.put("showTips", Integer.valueOf(this.field_showTips));
        }
        if (this.cni) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.field_digest == null) {
            this.field_digest = "";
        }
        if (this.cnA) {
            contentValues.put("digest", this.field_digest);
        }
        if (this.field_digestUser == null) {
            this.field_digestUser = "";
        }
        if (this.cnB) {
            contentValues.put("digestUser", this.field_digestUser);
        }
        if (this.ctA) {
            contentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
        }
        if (this.ctB) {
            contentValues.put("parentRef", this.field_parentRef);
        }
        if (this.ctC) {
            contentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
        }
        if (this.field_editingMsg == null) {
            this.field_editingMsg = "";
        }
        if (this.cnD) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.cnC) {
            contentValues.put("atCount", Integer.valueOf(this.field_atCount));
        }
        if (this.ctD) {
            contentValues.put("sightTime", Long.valueOf(this.field_sightTime));
        }
        if (this.ctE) {
            contentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
        }
        if (this.ctF) {
            contentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
        }
        if (this.ctG) {
            contentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
        }
        if (this.ctH) {
            contentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
        }
        if (this.ctI) {
            contentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
