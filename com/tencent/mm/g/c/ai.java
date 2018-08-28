package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;

public abstract class ai extends c {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)"};
    private static final int ciP = "rowid".hashCode();
    private static final int cke = "type".hashCode();
    private static final int cli = "username".hashCode();
    private static final int cmw = "lvbuff".hashCode();
    private static final int cpI = "nickname".hashCode();
    private static final int csj = "alias".hashCode();
    private static final int csk = "conRemark".hashCode();
    private static final int csl = "domainList".hashCode();
    private static final int csm = "pyInitial".hashCode();
    private static final int csn = "quanPin".hashCode();
    private static final int cso = "showHead".hashCode();
    private static final int csp = "weiboFlag".hashCode();
    private static final int csq = "weiboNickname".hashCode();
    private static final int csr = "conRemarkPYFull".hashCode();
    private static final int css = "conRemarkPYShort".hashCode();
    private static final int cst = "verifyFlag".hashCode();
    private static final int csu = "encryptUsername".hashCode();
    private static final int csv = "chatroomFlag".hashCode();
    private static final int csw = "deleteFlag".hashCode();
    private static final int csx = "contactLabelIds".hashCode();
    private static final int csy = "descWordingId".hashCode();
    private static final int csz = "openImAppid".hashCode();
    public String bTi;
    private boolean cjI = false;
    private boolean clZ = false;
    private boolean clg = false;
    private boolean cpE = false;
    private boolean crS = false;
    private boolean crT = false;
    private boolean crU = false;
    private boolean crV = false;
    private boolean crW = false;
    private boolean crX = false;
    private boolean crY = false;
    private boolean crZ = false;
    public int csA;
    public String csB;
    public long csC;
    public String csD;
    public int csE;
    public int csF;
    public String csG;
    public String csH;
    public int csI;
    public int csJ;
    private String csK;
    private String csL;
    public String csM;
    public int csN;
    public String csO;
    public String csP;
    public String csQ;
    public int csR;
    public int csS;
    public String csT;
    public String csU;
    public String csV;
    public String csW;
    public String csX;
    public String csY;
    public String csZ;
    private boolean csa = false;
    private boolean csb = false;
    private boolean csc = false;
    private boolean csd = false;
    private boolean cse = false;
    private boolean csf = false;
    private boolean csg = false;
    private boolean csh = false;
    private boolean csi = false;
    public String cta;
    private int ctb;
    private String ctc;
    public int ctd;
    public String cte;
    private String field_alias;
    public int field_chatroomFlag;
    public String field_conRemark;
    public String field_conRemarkPYFull;
    public String field_conRemarkPYShort;
    public String field_contactLabelIds;
    public int field_deleteFlag;
    public String field_descWordingId;
    public String field_domainList;
    public String field_encryptUsername;
    public byte[] field_lvbuff;
    public String field_nickname;
    public String field_openImAppid;
    private String field_pyInitial;
    private String field_quanPin;
    public int field_showHead;
    public int field_type;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public String field_weiboNickname;
    public int sex;
    public String signature;
    private int source;
    public int uin;

    public void setUsername(String str) {
        this.field_username = str;
        this.clg = true;
    }

    public final String getUsername() {
        return this.field_username;
    }

    public void du(String str) {
        this.field_alias = str;
        this.crS = true;
    }

    public String wM() {
        return this.field_alias;
    }

    public void dv(String str) {
        this.field_conRemark = str;
        this.crT = true;
    }

    public final String wN() {
        return this.field_conRemark;
    }

    public void dw(String str) {
        this.field_domainList = str;
        this.crU = true;
    }

    public void dx(String str) {
        this.field_nickname = str;
        this.cpE = true;
    }

    public final String wO() {
        return this.field_nickname;
    }

    public void dy(String str) {
        this.field_pyInitial = str;
        this.crV = true;
    }

    public String wP() {
        return this.field_pyInitial;
    }

    public void dz(String str) {
        this.field_quanPin = str;
        this.crW = true;
    }

    public String wQ() {
        return this.field_quanPin;
    }

    public void eD(int i) {
        this.field_showHead = i;
        this.crX = true;
    }

    public void setType(int i) {
        this.field_type = i;
        this.cjI = true;
    }

    public void eE(int i) {
        this.field_weiboFlag = i;
        this.crY = true;
    }

    public void dA(String str) {
        this.field_weiboNickname = str;
        this.crZ = true;
    }

    public void dB(String str) {
        this.field_conRemarkPYFull = str;
        this.csa = true;
    }

    public void dC(String str) {
        this.field_conRemarkPYShort = str;
        this.csb = true;
    }

    public void B(byte[] bArr) {
        this.field_lvbuff = bArr;
        this.clZ = true;
    }

    public void eF(int i) {
        this.field_verifyFlag = i;
        this.csc = true;
    }

    public void dD(String str) {
        this.field_encryptUsername = str;
        this.csd = true;
    }

    public final String wR() {
        return this.field_encryptUsername;
    }

    public void eG(int i) {
        this.field_chatroomFlag = i;
        this.cse = true;
    }

    public void eH(int i) {
        this.field_deleteFlag = i;
        this.csf = true;
    }

    public void dE(String str) {
        this.field_contactLabelIds = str;
        this.csg = true;
    }

    public final void dF(String str) {
        this.field_descWordingId = str;
        this.csh = true;
    }

    public final void dG(String str) {
        this.field_openImAppid = str;
        this.csi = true;
    }

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.clg = true;
                } else if (csj == hashCode) {
                    this.field_alias = cursor.getString(i);
                } else if (csk == hashCode) {
                    this.field_conRemark = cursor.getString(i);
                } else if (csl == hashCode) {
                    this.field_domainList = cursor.getString(i);
                } else if (cpI == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (csm == hashCode) {
                    this.field_pyInitial = cursor.getString(i);
                } else if (csn == hashCode) {
                    this.field_quanPin = cursor.getString(i);
                } else if (cso == hashCode) {
                    this.field_showHead = cursor.getInt(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (csp == hashCode) {
                    this.field_weiboFlag = cursor.getInt(i);
                } else if (csq == hashCode) {
                    this.field_weiboNickname = cursor.getString(i);
                } else if (csr == hashCode) {
                    this.field_conRemarkPYFull = cursor.getString(i);
                } else if (css == hashCode) {
                    this.field_conRemarkPYShort = cursor.getString(i);
                } else if (cmw == hashCode) {
                    this.field_lvbuff = cursor.getBlob(i);
                } else if (cst == hashCode) {
                    this.field_verifyFlag = cursor.getInt(i);
                } else if (csu == hashCode) {
                    this.field_encryptUsername = cursor.getString(i);
                } else if (csv == hashCode) {
                    this.field_chatroomFlag = cursor.getInt(i);
                } else if (csw == hashCode) {
                    this.field_deleteFlag = cursor.getInt(i);
                } else if (csx == hashCode) {
                    this.field_contactLabelIds = cursor.getString(i);
                } else if (csy == hashCode) {
                    this.field_descWordingId = cursor.getString(i);
                } else if (csz == hashCode) {
                    this.field_openImAppid = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
            wS();
        }
    }

    public final ContentValues wH() {
        try {
            if (this.clZ) {
                u uVar = new u();
                uVar.chE();
                uVar.CZ(this.csA);
                uVar.CZ(this.sex);
                uVar.Wj(this.csB);
                uVar.fX(this.csC);
                uVar.CZ(this.uin);
                uVar.Wj(this.csD);
                uVar.Wj(this.bTi);
                uVar.CZ(this.csE);
                uVar.CZ(this.csF);
                uVar.Wj(this.csG);
                uVar.Wj(this.csH);
                uVar.CZ(this.csI);
                uVar.CZ(this.csJ);
                uVar.Wj(this.signature);
                uVar.Wj(this.csK);
                uVar.Wj(this.csL);
                uVar.Wj(this.csM);
                uVar.CZ(this.csN);
                uVar.CZ(this.source);
                uVar.Wj(this.csO);
                uVar.CZ(this.field_verifyFlag);
                uVar.Wj(this.csP);
                uVar.Wj(this.csQ);
                uVar.CZ(this.csR);
                uVar.CZ(this.csS);
                uVar.Wj(this.csT);
                uVar.Wj(this.csU);
                uVar.Wj(this.csV);
                uVar.Wj(this.csW);
                uVar.Wj(this.csX);
                uVar.Wj(this.csY);
                uVar.Wj(this.csZ);
                uVar.Wj(this.cta);
                uVar.CZ(this.ctb);
                uVar.Wj(this.ctc);
                uVar.CZ(this.ctd);
                uVar.Wj(this.cte);
                this.field_lvbuff = uVar.chF();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseContact", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.field_alias == null) {
            this.field_alias = "";
        }
        if (this.crS) {
            contentValues.put("alias", this.field_alias);
        }
        if (this.field_conRemark == null) {
            this.field_conRemark = "";
        }
        if (this.crT) {
            contentValues.put("conRemark", this.field_conRemark);
        }
        if (this.field_domainList == null) {
            this.field_domainList = "";
        }
        if (this.crU) {
            contentValues.put("domainList", this.field_domainList);
        }
        if (this.field_nickname == null) {
            this.field_nickname = "";
        }
        if (this.cpE) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.field_pyInitial == null) {
            this.field_pyInitial = "";
        }
        if (this.crV) {
            contentValues.put("pyInitial", this.field_pyInitial);
        }
        if (this.field_quanPin == null) {
            this.field_quanPin = "";
        }
        if (this.crW) {
            contentValues.put("quanPin", this.field_quanPin);
        }
        if (this.crX) {
            contentValues.put("showHead", Integer.valueOf(this.field_showHead));
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.crY) {
            contentValues.put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
        }
        if (this.field_weiboNickname == null) {
            this.field_weiboNickname = "";
        }
        if (this.crZ) {
            contentValues.put("weiboNickname", this.field_weiboNickname);
        }
        if (this.field_conRemarkPYFull == null) {
            this.field_conRemarkPYFull = "";
        }
        if (this.csa) {
            contentValues.put("conRemarkPYFull", this.field_conRemarkPYFull);
        }
        if (this.field_conRemarkPYShort == null) {
            this.field_conRemarkPYShort = "";
        }
        if (this.csb) {
            contentValues.put("conRemarkPYShort", this.field_conRemarkPYShort);
        }
        if (this.clZ) {
            contentValues.put("lvbuff", this.field_lvbuff);
        }
        if (this.csc) {
            contentValues.put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
        }
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = "";
        }
        if (this.csd) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.cse) {
            contentValues.put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
        }
        if (this.csf) {
            contentValues.put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
        }
        if (this.field_contactLabelIds == null) {
            this.field_contactLabelIds = "";
        }
        if (this.csg) {
            contentValues.put("contactLabelIds", this.field_contactLabelIds);
        }
        if (this.field_descWordingId == null) {
            this.field_descWordingId = "";
        }
        if (this.csh) {
            contentValues.put("descWordingId", this.field_descWordingId);
        }
        if (this.csi) {
            contentValues.put("openImAppid", this.field_openImAppid);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }

    public void eI(int i) {
        this.csA = i;
        this.clZ = true;
    }

    public void eJ(int i) {
        this.sex = i;
        this.clZ = true;
    }

    public void dH(String str) {
        this.csB = str;
        this.clZ = true;
    }

    public void ar(long j) {
        this.csC = j;
        this.clZ = true;
    }

    public void eK(int i) {
        this.uin = i;
        this.clZ = true;
    }

    public void dI(String str) {
        this.csD = str;
        this.clZ = true;
    }

    public void dJ(String str) {
        this.bTi = str;
        this.clZ = true;
    }

    public void eL(int i) {
        this.csE = i;
        this.clZ = true;
    }

    public void eM(int i) {
        this.csF = i;
        this.clZ = true;
    }

    public void dK(String str) {
        this.csG = str;
        this.clZ = true;
    }

    public void dL(String str) {
        this.csH = str;
        this.clZ = true;
    }

    public void eN(int i) {
        this.csI = i;
        this.clZ = true;
    }

    public void eO(int i) {
        this.csJ = i;
        this.clZ = true;
    }

    public void dM(String str) {
        this.signature = str;
        this.clZ = true;
    }

    public String getProvince() {
        return this.csK;
    }

    public void dN(String str) {
        this.csK = str;
        this.clZ = true;
    }

    public String getCity() {
        return this.csL;
    }

    public void dO(String str) {
        this.csL = str;
        this.clZ = true;
    }

    public void dP(String str) {
        this.csM = str;
        this.clZ = true;
    }

    public void eP(int i) {
        this.csN = i;
        this.clZ = true;
    }

    public int getSource() {
        return this.source;
    }

    public void setSource(int i) {
        this.source = i;
        this.clZ = true;
    }

    public void dQ(String str) {
        this.csO = str;
        this.clZ = true;
    }

    public void dR(String str) {
        this.csP = str;
        this.clZ = true;
    }

    public void dS(String str) {
        this.csQ = str;
        this.clZ = true;
    }

    public void eQ(int i) {
        this.csR = i;
        this.clZ = true;
    }

    public void eR(int i) {
        this.csS = i;
        this.clZ = true;
    }

    public void dT(String str) {
        this.csT = str;
        this.clZ = true;
    }

    public void dU(String str) {
        this.csU = str;
        this.clZ = true;
    }

    public void dV(String str) {
        this.csV = str;
        this.clZ = true;
    }

    public void dW(String str) {
        this.csW = str;
        this.clZ = true;
    }

    public void dX(String str) {
        this.csX = str;
        this.clZ = true;
    }

    public void dY(String str) {
        this.csY = str;
        this.clZ = true;
    }

    public void dZ(String str) {
        this.csZ = str;
        this.clZ = true;
    }

    public void ea(String str) {
        this.cta = str;
        this.clZ = true;
    }

    public final void eS(int i) {
        this.ctb = i;
        this.clZ = true;
    }

    public final void eT(int i) {
        this.ctd = i;
        this.clZ = true;
    }

    public final void eb(String str) {
        this.cte = str;
        this.clZ = true;
    }

    public final void wS() {
        try {
            if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                u uVar = new u();
                int by = uVar.by(this.field_lvbuff);
                if (by != 0) {
                    x.e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:" + by);
                    return;
                }
                this.csA = uVar.getInt();
                this.sex = uVar.getInt();
                this.csB = uVar.getString();
                this.csC = uVar.getLong();
                this.uin = uVar.getInt();
                this.csD = uVar.getString();
                this.bTi = uVar.getString();
                this.csE = uVar.getInt();
                this.csF = uVar.getInt();
                this.csG = uVar.getString();
                this.csH = uVar.getString();
                this.csI = uVar.getInt();
                this.csJ = uVar.getInt();
                this.signature = uVar.getString();
                this.csK = uVar.getString();
                this.csL = uVar.getString();
                this.csM = uVar.getString();
                this.csN = uVar.getInt();
                this.source = uVar.getInt();
                this.csO = uVar.getString();
                this.field_verifyFlag = uVar.getInt();
                this.csP = uVar.getString();
                if (!uVar.chD()) {
                    this.csQ = uVar.getString();
                }
                if (!uVar.chD()) {
                    this.csR = uVar.getInt();
                }
                if (!uVar.chD()) {
                    this.csS = uVar.getInt();
                }
                if (!uVar.chD()) {
                    this.csT = uVar.getString();
                }
                if (!uVar.chD()) {
                    this.csU = uVar.getString();
                }
                if (!uVar.chD()) {
                    this.csV = uVar.getString();
                }
                if (!uVar.chD()) {
                    this.csW = uVar.getString();
                }
                if (!uVar.chD()) {
                    this.csX = uVar.getString();
                }
                if (!uVar.chD()) {
                    this.csY = uVar.getString();
                }
                if (!uVar.chD()) {
                    this.csZ = uVar.getString();
                }
                if (!uVar.chD()) {
                    this.cta = uVar.getString();
                }
                if (!uVar.chD()) {
                    this.ctb = uVar.getInt();
                }
                if (!uVar.chD()) {
                    this.ctc = uVar.getString();
                }
                if (!uVar.chD()) {
                    this.ctd = uVar.getInt();
                }
                if (!uVar.chD()) {
                    this.cte = uVar.getString();
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseContact", "get value failed");
        }
    }
}
