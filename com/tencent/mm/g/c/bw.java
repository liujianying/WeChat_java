package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;

public abstract class bw extends c {
    private static final int cAj = "mac".hashCode();
    private static final int cCC = "deviceID".hashCode();
    private static final int cCD = "brandName".hashCode();
    private static final int cCE = "deviceType".hashCode();
    private static final int cCF = "connProto".hashCode();
    private static final int cCG = "connStrategy".hashCode();
    private static final int cCH = "closeStrategy".hashCode();
    private static final int cCI = "md5Str".hashCode();
    private static final int cCJ = "authKey".hashCode();
    private static final int cCK = "sessionKey".hashCode();
    private static final int cCL = "sessionBuf".hashCode();
    private static final int cCM = "authBuf".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cpV = "lvbuffer".hashCode();
    private static final int cqH = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private boolean cCA = true;
    private boolean cCB = true;
    public int cCN;
    public int cCO;
    public long cCP;
    private long cCQ;
    public String cCR;
    public String cCS;
    public String cCT;
    private int cCU;
    public int cCV;
    public long cCW;
    public String cCX;
    public String cCY;
    private String cCZ;
    private boolean cCr = true;
    private boolean cCs = true;
    private boolean cCt = true;
    private boolean cCu = true;
    private boolean cCv = true;
    private boolean cCw = true;
    private boolean cCx = true;
    private boolean cCy = true;
    private boolean cCz = true;
    public String cDa;
    public String category;
    public boolean cpN = true;
    private boolean cqo = true;
    private boolean czW = true;
    public byte[] field_authBuf;
    public String field_authKey;
    public String field_brandName;
    public int field_closeStrategy;
    public String field_connProto;
    public int field_connStrategy;
    public String field_deviceID;
    public String field_deviceType;
    public byte[] field_lvbuffer;
    public long field_mac;
    public String field_md5Str;
    public byte[] field_sessionBuf;
    public byte[] field_sessionKey;
    public String field_url;
    public String iconUrl;
    public String jumpUrl;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cCC == hashCode) {
                    this.field_deviceID = cursor.getString(i);
                    this.cCr = true;
                } else if (cCD == hashCode) {
                    this.field_brandName = cursor.getString(i);
                } else if (cAj == hashCode) {
                    this.field_mac = cursor.getLong(i);
                } else if (cCE == hashCode) {
                    this.field_deviceType = cursor.getString(i);
                } else if (cCF == hashCode) {
                    this.field_connProto = cursor.getString(i);
                } else if (cCG == hashCode) {
                    this.field_connStrategy = cursor.getInt(i);
                } else if (cCH == hashCode) {
                    this.field_closeStrategy = cursor.getInt(i);
                } else if (cCI == hashCode) {
                    this.field_md5Str = cursor.getString(i);
                } else if (cCJ == hashCode) {
                    this.field_authKey = cursor.getString(i);
                } else if (cqH == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (cCK == hashCode) {
                    this.field_sessionKey = cursor.getBlob(i);
                } else if (cCL == hashCode) {
                    this.field_sessionBuf = cursor.getBlob(i);
                } else if (cCM == hashCode) {
                    this.field_authBuf = cursor.getBlob(i);
                } else if (cpV == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuffer != null && this.field_lvbuffer.length != 0) {
                    u uVar = new u();
                    int by = uVar.by(this.field_lvbuffer);
                    if (by != 0) {
                        x.e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:" + by);
                        return;
                    }
                    if (!uVar.chD()) {
                        this.cCN = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cCO = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cCP = uVar.getLong();
                    }
                    if (!uVar.chD()) {
                        this.cCQ = uVar.getLong();
                    }
                    if (!uVar.chD()) {
                        this.cCR = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.iconUrl = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.jumpUrl = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cCS = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cCT = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.category = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cCU = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cCV = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cCW = uVar.getLong();
                    }
                    if (!uVar.chD()) {
                        this.cCX = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cCY = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cCZ = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cDa = uVar.getString();
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
            }
        }
    }

    public final ContentValues wH() {
        try {
            if (this.cpN) {
                u uVar = new u();
                uVar.chE();
                uVar.CZ(this.cCN);
                uVar.CZ(this.cCO);
                uVar.fX(this.cCP);
                uVar.fX(this.cCQ);
                uVar.Wj(this.cCR);
                uVar.Wj(this.iconUrl);
                uVar.Wj(this.jumpUrl);
                uVar.Wj(this.cCS);
                uVar.Wj(this.cCT);
                uVar.Wj(this.category);
                uVar.CZ(this.cCU);
                uVar.CZ(this.cCV);
                uVar.fX(this.cCW);
                uVar.Wj(this.cCX);
                uVar.Wj(this.cCY);
                uVar.Wj(this.cCZ);
                uVar.Wj(this.cDa);
                this.field_lvbuffer = uVar.chF();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", new Object[]{e.getMessage()});
        }
        ContentValues contentValues = new ContentValues();
        if (this.cCr) {
            contentValues.put("deviceID", this.field_deviceID);
        }
        if (this.cCs) {
            contentValues.put("brandName", this.field_brandName);
        }
        if (this.czW) {
            contentValues.put("mac", Long.valueOf(this.field_mac));
        }
        if (this.cCt) {
            contentValues.put("deviceType", this.field_deviceType);
        }
        if (this.cCu) {
            contentValues.put("connProto", this.field_connProto);
        }
        if (this.cCv) {
            contentValues.put("connStrategy", Integer.valueOf(this.field_connStrategy));
        }
        if (this.cCw) {
            contentValues.put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
        }
        if (this.cCx) {
            contentValues.put("md5Str", this.field_md5Str);
        }
        if (this.cCy) {
            contentValues.put("authKey", this.field_authKey);
        }
        if (this.cqo) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.cCz) {
            contentValues.put("sessionKey", this.field_sessionKey);
        }
        if (this.cCA) {
            contentValues.put("sessionBuf", this.field_sessionBuf);
        }
        if (this.cCB) {
            contentValues.put("authBuf", this.field_authBuf);
        }
        if (this.cpN) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }

    public final void du(String str) {
        this.cCR = str;
        this.cpN = true;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
        this.cpN = true;
    }

    public final void eh(String str) {
        this.jumpUrl = str;
        this.cpN = true;
    }

    public final void ei(String str) {
        this.cCS = str;
        this.cpN = true;
    }

    public final void ej(String str) {
        this.cCT = str;
        this.cpN = true;
    }

    public final void ek(String str) {
        this.category = str;
        this.cpN = true;
    }

    public final void fe(int i) {
        this.cCU = i;
        this.cpN = true;
    }

    public final void ff(int i) {
        this.cCV = i;
        this.cpN = true;
    }

    public final void aw(long j) {
        this.cCW = j;
        this.cpN = true;
    }

    public final void el(String str) {
        this.cCX = str;
        this.cpN = true;
    }

    public final void em(String str) {
        this.cCY = str;
        this.cpN = true;
    }

    public final void en(String str) {
        this.cCZ = str;
        this.cpN = true;
    }

    public final void eo(String str) {
        this.cDa = str;
        this.cpN = true;
    }
}
