package com.tencent.mm.l;

import android.database.Cursor;
import com.tencent.mm.a.o;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.reflect.Field;

public class a extends ai {
    public static com.tencent.mm.sdk.e.c.a dhO;
    private static a dhQ = null;
    public long dhP;
    public int versionCode;

    public interface a {
        String cY(String str);

        String cZ(String str);
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[21];
        aVar.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.sKA.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "username";
        aVar.columns[1] = "alias";
        aVar.sKA.put("alias", "TEXT default '' ");
        stringBuilder.append(" alias TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "conRemark";
        aVar.sKA.put("conRemark", "TEXT default '' ");
        stringBuilder.append(" conRemark TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "domainList";
        aVar.sKA.put("domainList", "TEXT default '' ");
        stringBuilder.append(" domainList TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "nickname";
        aVar.sKA.put("nickname", "TEXT default '' ");
        stringBuilder.append(" nickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "pyInitial";
        aVar.sKA.put("pyInitial", "TEXT default '' ");
        stringBuilder.append(" pyInitial TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "quanPin";
        aVar.sKA.put("quanPin", "TEXT default '' ");
        stringBuilder.append(" quanPin TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "showHead";
        aVar.sKA.put("showHead", "INTEGER default '0' ");
        stringBuilder.append(" showHead INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "type";
        aVar.sKA.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "weiboFlag";
        aVar.sKA.put("weiboFlag", "INTEGER default '0' ");
        stringBuilder.append(" weiboFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "weiboNickname";
        aVar.sKA.put("weiboNickname", "TEXT default '' ");
        stringBuilder.append(" weiboNickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "conRemarkPYFull";
        aVar.sKA.put("conRemarkPYFull", "TEXT default '' ");
        stringBuilder.append(" conRemarkPYFull TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "conRemarkPYShort";
        aVar.sKA.put("conRemarkPYShort", "TEXT default '' ");
        stringBuilder.append(" conRemarkPYShort TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "lvbuff";
        aVar.sKA.put("lvbuff", "BLOB");
        stringBuilder.append(" lvbuff BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "verifyFlag";
        aVar.sKA.put("verifyFlag", "INTEGER default '0' ");
        stringBuilder.append(" verifyFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "encryptUsername";
        aVar.sKA.put("encryptUsername", "TEXT default '' ");
        stringBuilder.append(" encryptUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "chatroomFlag";
        aVar.sKA.put("chatroomFlag", "INTEGER");
        stringBuilder.append(" chatroomFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "deleteFlag";
        aVar.sKA.put("deleteFlag", "INTEGER default '0' ");
        stringBuilder.append(" deleteFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "contactLabelIds";
        aVar.sKA.put("contactLabelIds", "TEXT default '' ");
        stringBuilder.append(" contactLabelIds TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "descWordingId";
        aVar.sKA.put("descWordingId", "TEXT default '' ");
        stringBuilder.append(" descWordingId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "openImAppid";
        aVar.sKA.put("openImAppid", "TEXT");
        stringBuilder.append(" openImAppid TEXT");
        aVar.columns[21] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    public final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }

    public a(String str) {
        this();
        if (str == null) {
            str = "";
        }
        setUsername(str);
    }

    public a() {
        this.versionCode = 0;
        super.setUsername("");
        super.dx("");
        super.dy("");
        super.dz("");
        super.du("");
        super.dv("");
        super.dC("");
        super.dB("");
        super.dw("");
        super.eE(0);
        super.dA("");
        super.eD(0);
        super.setType(0);
        super.eF(0);
        super.eG(0);
        super.dE("");
        super.eJ(0);
        super.dP("");
        super.eP(0);
        super.eK(0);
        super.dI("");
        super.dJ("");
        super.eL(0);
        super.eM(0);
        super.dK("");
        super.dL("");
        super.eN(1);
        super.eI(0);
        super.eO(0);
        super.dM("");
        super.dN("");
        super.dO("");
        super.setSource(0);
        super.dR("");
        super.dQ("");
        super.ar(0);
        super.dH("");
        super.dS("");
        super.eQ(0);
        super.dV("");
        super.dW("");
        super.dX("");
        super.ea("");
        super.dF("");
        super.dG("");
        this.versionCode = 0;
    }

    public static void a(a aVar) {
        dhQ = aVar;
    }

    public static String fv(String str) {
        return dhQ != null ? dhQ.cY(str) : null;
    }

    public final int AY() {
        int i = 32;
        if (this.field_conRemarkPYShort != null && !this.field_conRemarkPYShort.equals("")) {
            i = this.field_conRemarkPYShort.charAt(0);
        } else if (this.field_conRemarkPYFull != null && !this.field_conRemarkPYFull.equals("")) {
            i = this.field_conRemarkPYFull.charAt(0);
        } else if (super.wP() != null && !super.wP().equals("")) {
            i = super.wP().charAt(0);
        } else if (super.wQ() != null && !super.wQ().equals("")) {
            i = super.wQ().charAt(0);
        } else if (this.field_nickname != null && !this.field_nickname.equals("") && isLetter(this.field_nickname.charAt(0))) {
            i = this.field_nickname.charAt(0);
        } else if (!(this.field_username == null || this.field_username.equals("") || !isLetter(this.field_username.charAt(0)))) {
            i = this.field_username.charAt(0);
        }
        if (i >= 97 && i <= 122) {
            return (char) (i - 32);
        }
        if (i < 65 || i > 90) {
            return 123;
        }
        return i;
    }

    public final void AZ() {
        setType(0);
    }

    public final void Ba() {
        setType(this.field_type | 4);
    }

    public final void Bb() {
        setType(this.field_type | 1);
    }

    public final void Bc() {
        x.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", this.field_username, Integer.valueOf(this.field_type), bi.cjd());
        setType(this.field_type & -2);
    }

    public final void Bd() {
        setType(this.field_type | 8);
    }

    public final void Be() {
        setType(this.field_type & -9);
    }

    public final void Bf() {
        setType(this.field_type | SQLiteGlobal.journalSizeLimit);
    }

    public final void Bg() {
        setType(this.field_type & -524289);
    }

    public final void Bh() {
        setType(this.field_type | 2);
    }

    public final void Bi() {
        setType(this.field_type & -3);
    }

    public final void Bj() {
        setType(this.field_type & -2049);
    }

    public final void Bk() {
        setType(this.field_type | 32);
    }

    public final void Bl() {
        setType(this.field_type & -33);
    }

    public final void Bm() {
        setType(this.field_type | 64);
    }

    public final void Bn() {
        setType(this.field_type & -65);
    }

    public final void Bo() {
        setType(this.field_type | 512);
    }

    public final void Bp() {
        setType(this.field_type & -513);
    }

    public final void Bq() {
        setType(this.field_type | 256);
    }

    public final void Br() {
        setType(this.field_type & -257);
    }

    public static int Bs() {
        return 1;
    }

    public static int Bt() {
        return 8;
    }

    public static int Bu() {
        return SQLiteGlobal.journalSizeLimit;
    }

    public static int Bv() {
        return 16;
    }

    public static int Bw() {
        return 32;
    }

    public final boolean Bx() {
        return gd(this.field_type);
    }

    public static boolean gd(int i) {
        if ((i & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean By() {
        if ((this.field_type & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isHidden() {
        return (this.field_type & 32) != 0;
    }

    public final boolean Bz() {
        return (this.field_type & 4) != 0;
    }

    public final boolean BA() {
        return (this.field_type & 8) != 0;
    }

    public final boolean BB() {
        return (SQLiteGlobal.journalSizeLimit & this.field_type) != 0;
    }

    public final boolean BC() {
        return (this.field_type & 64) != 0;
    }

    public final boolean BD() {
        return (this.field_type & 512) != 0;
    }

    public final boolean BE() {
        return (this.field_type & 1024) == 0;
    }

    public final boolean BF() {
        return (this.field_type & 256) != 0;
    }

    public final boolean BG() {
        return (this.field_type & 2048) != 0;
    }

    public final boolean BH() {
        return (32768 & this.field_type) != 0;
    }

    public final void BI() {
        setType(this.field_type | 32768);
    }

    private static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public final int BJ() {
        return (int) this.dhP;
    }

    public final String wP() {
        return (super.wP() == null || super.wP().length() < 0) ? wQ() : super.wP();
    }

    public final String wQ() {
        return (super.wQ() == null || super.wQ().length() < 0) ? this.field_nickname : super.wQ();
    }

    public final String wM() {
        String cZ = dhQ != null ? dhQ.cZ(this.field_username) : null;
        return cZ == null ? super.wM() : cZ;
    }

    public final String BK() {
        String cY = dhQ != null ? dhQ.cY(this.field_username) : null;
        if (cY != null) {
            return cY;
        }
        if (this.field_nickname == null || this.field_nickname.length() <= 0) {
            return BM();
        }
        return this.field_nickname;
    }

    public final String BL() {
        if (this.field_conRemark == null || this.field_conRemark.trim().equals("")) {
            return BK();
        }
        return this.field_conRemark;
    }

    public final String BM() {
        String wM = wM();
        if (!bi.oW(wM)) {
            return wM;
        }
        wM = this.field_username;
        if (wM == null) {
            wM = null;
        } else if (wM.toLowerCase().endsWith("@t.qq.com")) {
            wM = "@" + wM.replace("@t.qq.com", "");
        } else if (wM.toLowerCase().endsWith("@qqim")) {
            wM = wM.replace("@qqim", "");
            long longValue = Long.valueOf(wM).longValue();
            if (longValue < 0) {
                wM = new o(longValue).toString();
            }
        }
        return (wM == null || wM.length() == 0) ? this.field_username : wM;
    }

    public final int getSource() {
        return super.getSource() % 1000000;
    }

    public final int BN() {
        return super.getSource();
    }

    public final void ge(int i) {
        eG((this.field_chatroomFlag & -2) | (i & 1));
    }

    public final void d(Cursor cursor) {
        super.d(cursor);
        this.dhP = this.sKx;
        super.B(null);
    }

    private int BO() {
        int i = this.versionCode + 1;
        this.versionCode = i;
        return i;
    }

    public final void setUsername(String str) {
        if (!bi.fS(this.field_username, str)) {
            super.setUsername(str);
            BO();
        }
    }

    public final void du(String str) {
        if (!bi.fS(wM(), str)) {
            super.du(str);
            BO();
        }
    }

    public final void dv(String str) {
        if (!bi.fS(this.field_conRemark, str)) {
            super.dv(str);
            BO();
        }
    }

    public final void dw(String str) {
        if (!bi.fS(this.field_domainList, str)) {
            super.dw(str);
            BO();
        }
    }

    public final void dx(String str) {
        if (!bi.fS(this.field_nickname, str)) {
            super.dx(str);
            BO();
        }
    }

    public final void dy(String str) {
        if (!bi.fS(wP(), str)) {
            super.dy(str);
            BO();
        }
    }

    public final void dz(String str) {
        if (!bi.fS(wQ(), str)) {
            super.dz(str);
            BO();
        }
    }

    public final void eD(int i) {
        if (!bi.eG(this.field_showHead, i)) {
            super.eD(i);
            BO();
        }
    }

    public final void setType(int i) {
        if (!bi.eG(this.field_type, i)) {
            super.setType(i);
            BO();
        }
    }

    public final void eE(int i) {
        if (!bi.eG(this.field_weiboFlag, i)) {
            super.eE(i);
            BO();
        }
    }

    public final void dA(String str) {
        if (!bi.fS(this.field_weiboNickname, str)) {
            super.dA(str);
            BO();
        }
    }

    public final void dB(String str) {
        if (!bi.fS(this.field_conRemarkPYFull, str)) {
            super.dB(str);
            BO();
        }
    }

    public final void dC(String str) {
        if (!bi.fS(this.field_conRemarkPYShort, str)) {
            super.dC(str);
            BO();
        }
    }

    public final void B(byte[] bArr) {
        if (!bi.isEqual(this.field_lvbuff, bArr)) {
            super.B(bArr);
            BO();
        }
    }

    public final void eF(int i) {
        if (!bi.eG(this.field_verifyFlag, i)) {
            super.eF(i);
            BO();
        }
    }

    public final void dD(String str) {
        if (!bi.fS(this.field_encryptUsername, str)) {
            super.dD(str);
            BO();
        }
    }

    public final void eG(int i) {
        if (!bi.eG(this.field_chatroomFlag, i)) {
            super.eG(i);
            BO();
        }
    }

    public final void eH(int i) {
        if (!bi.eG(this.field_deleteFlag, i)) {
            super.eH(i);
            BO();
        }
    }

    public final void dE(String str) {
        if (!bi.fS(this.field_contactLabelIds, str)) {
            super.dE(str);
            BO();
        }
    }

    public final void eI(int i) {
        if (!bi.eG(this.csA, i)) {
            super.eI(i);
            BO();
        }
    }

    public final void eJ(int i) {
        if (!bi.eG(this.sex, i)) {
            super.eJ(i);
            BO();
        }
    }

    public final void dH(String str) {
        if (!bi.fS(this.csB, str)) {
            super.dH(str);
            BO();
        }
    }

    public final void ar(long j) {
        if (!bi.K(this.csC, j)) {
            super.ar(j);
            BO();
        }
    }

    public final void eK(int i) {
        if (!bi.eG(this.uin, i)) {
            super.eK(i);
            BO();
        }
    }

    public final void dI(String str) {
        if (!bi.fS(this.csD, str)) {
            super.dI(str);
            BO();
        }
    }

    public final void dJ(String str) {
        if (!bi.fS(this.bTi, str)) {
            super.dJ(str);
            BO();
        }
    }

    public final void eL(int i) {
        if (!bi.eG(this.csE, i)) {
            super.eL(i);
            BO();
        }
    }

    public final void eM(int i) {
        if (!bi.eG(this.csF, i)) {
            super.eM(i);
            BO();
        }
    }

    public final void dK(String str) {
        if (!bi.fS(this.csG, str)) {
            super.dK(str);
            BO();
        }
    }

    public final void dL(String str) {
        if (!bi.fS(this.csH, str)) {
            super.dL(str);
            BO();
        }
    }

    public final void eN(int i) {
        if (!bi.eG(this.csI, i)) {
            super.eN(i);
            BO();
        }
    }

    public final void eO(int i) {
        if (!bi.eG(this.csJ, i)) {
            super.eO(i);
            BO();
        }
    }

    public final void dM(String str) {
        if (!bi.fS(this.signature, str)) {
            super.dM(str);
            BO();
        }
    }

    public void dN(String str) {
        if (!bi.fS(getProvince(), str)) {
            super.dN(str);
            BO();
        }
    }

    public void dO(String str) {
        if (!bi.fS(getCity(), str)) {
            super.dO(str);
            BO();
        }
    }

    public final void dP(String str) {
        if (!bi.fS(this.csM, str)) {
            super.dP(str);
            BO();
        }
    }

    public final void eP(int i) {
        if (!bi.eG(this.csN, i)) {
            super.eP(i);
            BO();
        }
    }

    public final void setSource(int i) {
        if (!bi.eG(super.getSource(), i)) {
            super.setSource(i);
            BO();
        }
    }

    public final void dQ(String str) {
        if (!bi.fS(this.csO, str)) {
            super.dQ(str);
            BO();
        }
    }

    public final void dR(String str) {
        if (!bi.fS(this.csP, str)) {
            super.dR(str);
            BO();
        }
    }

    public void dS(String str) {
        if (!bi.fS(this.csQ, str)) {
            super.dS(str);
            BO();
        }
    }

    public final void eQ(int i) {
        if (!bi.eG(this.csR, i)) {
            super.eQ(i);
            BO();
        }
    }

    public final void eR(int i) {
        if (!bi.eG(this.csS, i)) {
            super.eR(i);
            BO();
        }
    }

    public final void dT(String str) {
        if (!bi.fS(this.csT, str)) {
            super.dT(str);
            BO();
        }
    }

    public final void dU(String str) {
        if (!bi.fS(this.csU, str)) {
            super.dU(str);
            BO();
        }
    }

    public final void dV(String str) {
        if (!bi.fS(this.csV, str)) {
            super.dV(str);
            BO();
        }
    }

    public final void dW(String str) {
        if (!bi.fS(this.csW, str)) {
            super.dW(str);
            BO();
        }
    }

    public final void dX(String str) {
        if (!bi.fS(this.csX, str)) {
            super.dX(str);
            BO();
        }
    }

    public final void dY(String str) {
        if (!bi.fS(this.csY, str)) {
            super.dY(str);
            BO();
        }
    }

    public final void dZ(String str) {
        if (!bi.fS(this.csZ, str)) {
            super.dZ(str);
            BO();
        }
    }

    public final void ea(String str) {
        if (!bi.fS(this.cta, str)) {
            super.ea(str);
            BO();
        }
    }
}
