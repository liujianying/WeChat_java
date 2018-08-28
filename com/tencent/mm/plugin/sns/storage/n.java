package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.g.c.dx;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class n extends dx {
    protected static a dhO;
    protected static Map<String, bsu> nJj = new ConcurrentHashMap();
    protected static Map<String, atf> nJk = new ConcurrentHashMap();
    public String nJb = null;
    public int nJc;
    public String nJl = null;
    public e nJm;
    private atf nJn = null;
    private boolean nkG = false;

    static {
        a aVar = new a();
        aVar.sKy = new Field[15];
        aVar.columns = new String[16];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "snsId";
        aVar.sKA.put("snsId", "LONG");
        stringBuilder.append(" snsId LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "userName";
        aVar.sKA.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "localFlag";
        aVar.sKA.put("localFlag", "INTEGER");
        stringBuilder.append(" localFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.sKA.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "head";
        aVar.sKA.put("head", "INTEGER");
        stringBuilder.append(" head INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "localPrivate";
        aVar.sKA.put("localPrivate", "INTEGER");
        stringBuilder.append(" localPrivate INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "type";
        aVar.sKA.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "sourceType";
        aVar.sKA.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "likeFlag";
        aVar.sKA.put("likeFlag", "INTEGER");
        stringBuilder.append(" likeFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "pravited";
        aVar.sKA.put("pravited", "INTEGER");
        stringBuilder.append(" pravited INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "stringSeq";
        aVar.sKA.put("stringSeq", "TEXT");
        stringBuilder.append(" stringSeq TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "content";
        aVar.sKA.put("content", "BLOB");
        stringBuilder.append(" content BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "attrBuf";
        aVar.sKA.put("attrBuf", "BLOB");
        stringBuilder.append(" attrBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "postBuf";
        aVar.sKA.put("postBuf", "BLOB");
        stringBuilder.append(" postBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "subType";
        aVar.sKA.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        aVar.columns[15] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final atf bAW() {
        if (this.field_postBuf == null) {
            return new atf();
        }
        if (this.nJl == null) {
            this.nJl = g.u(this.field_postBuf);
        }
        if (nJk.containsKey(this.nJl)) {
            this.nJn = (atf) nJk.get(this.nJl);
            if (this.nJn != null) {
                return this.nJn;
            }
        }
        try {
            this.nJn = (atf) new atf().aG(this.field_postBuf);
            nJk.put(this.nJl, this.nJn);
            return this.nJn;
        } catch (Exception e) {
            x.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
            return new atf();
        }
    }

    public n(byte b) {
        fe(0);
    }

    public static n x(n nVar) {
        n nVar2 = new n();
        nVar2.nJc = nVar.nJc;
        nVar2.field_snsId = nVar.field_snsId;
        nVar2.field_userName = nVar.field_userName;
        nVar2.field_localFlag = nVar.field_localFlag;
        nVar2.field_createTime = nVar.field_createTime;
        nVar2.field_head = nVar.field_head;
        nVar2.field_localPrivate = nVar.field_localPrivate;
        nVar2.field_type = nVar.field_type;
        nVar2.field_sourceType = nVar.field_sourceType;
        nVar2.field_likeFlag = nVar.field_likeFlag;
        nVar2.field_pravited = nVar.field_pravited;
        nVar2.field_stringSeq = nVar.field_stringSeq;
        nVar2.field_content = nVar.field_content;
        nVar2.field_attrBuf = nVar.field_attrBuf;
        return nVar2;
    }

    public final void fe(long j) {
        this.field_snsId = j;
        if (j != 0) {
            fg(j);
        }
    }

    public final String bAK() {
        if (xb(32)) {
            return v.ah("ad_table_", this.field_snsId);
        }
        return v.ah("sns_table_", this.field_snsId);
    }

    public final String getUserName() {
        return this.field_userName;
    }

    private static int ff(long j) {
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date(1000 * j));
        try {
            return Integer.valueOf(format).intValue();
        } catch (Exception e) {
            x.e("MicroMsg.SnsInfo", "error valueOf  " + format);
            return (int) (j / 86400);
        }
    }

    public final void hK(int i) {
        if (i - this.field_createTime >= 180 || i - this.field_createTime < 0) {
            this.field_createTime = i;
            this.field_head = ff((long) i);
        } else if (this.field_head == 0) {
            this.field_head = ff((long) this.field_createTime);
        }
    }

    public final int bAX() {
        return this.field_createTime;
    }

    public final void bAY() {
        this.field_localPrivate |= 1;
    }

    public final int bAZ() {
        return this.field_localPrivate;
    }

    public final boolean bBa() {
        return (this.field_localFlag & 128) > 0;
    }

    public final void bBb() {
        this.field_localFlag |= 2;
    }

    public final void bBc() {
        this.field_localFlag &= -3;
    }

    public final boolean bBd() {
        return (this.field_localFlag & 2) > 0;
    }

    public final String bBe() {
        if (xb(32)) {
            return v.ah("ad_table_", (long) this.nJc);
        }
        return v.ah("sns_table_", (long) this.nJc);
    }

    public final void aK(byte[] bArr) {
        this.field_attrBuf = bArr;
        this.nJb = g.u(this.field_content) + g.u(this.field_attrBuf);
    }

    public final void fg(long j) {
        this.field_stringSeq = i.eF(j);
        this.field_stringSeq = i.LK(this.field_stringSeq);
        x.d("MicroMsg.SnsInfo", j + " stringSeq " + this.field_stringSeq);
    }

    public final void d(Cursor cursor) {
        super.d(cursor);
        this.nJc = (int) this.sKx;
    }

    public static synchronized void release() {
        synchronized (n.class) {
            nJj.clear();
            nJk.clear();
        }
    }

    public final bsu bAJ() {
        if (this.field_content == null) {
            return e.RF();
        }
        bsu bsu;
        if (this.nJb == null) {
            this.nJb = g.u(this.field_content) + g.u(this.field_attrBuf);
        }
        if (nJj.containsKey(this.nJb)) {
            bsu = (bsu) nJj.get(this.nJb);
            if (bsu != null) {
                return bsu;
            }
        }
        try {
            bsu = (bsu) new bsu().aG(this.field_content);
            nJj.put(this.nJb, bsu);
            return bsu;
        } catch (Exception e) {
            x.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
            return e.RF();
        }
    }

    public final void c(bsu bsu) {
        try {
            this.field_content = bsu.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsInfo", e, "", new Object[0]);
        }
        this.nJb = g.u(this.field_content) + g.u(this.field_attrBuf);
    }

    public final boolean Nj(String str) {
        try {
            this.field_content = e.ng(str).toByteArray();
            this.nJb = g.u(this.field_content) + g.u(this.field_attrBuf);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsInfo", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean bBf() {
        return (this.field_localFlag & 16) > 0;
    }

    public final boolean bBg() {
        return (this.field_localFlag & 32) > 0 && this.field_snsId == 0;
    }

    public final void bBh() {
        this.field_localFlag &= -33;
    }

    public final void bBi() {
        this.field_localFlag |= 32;
    }

    public static boolean fh(long j) {
        if (bi.bG(j / 1000) > 1200) {
            return true;
        }
        return false;
    }

    public final boolean xb(int i) {
        return (this.field_sourceType & i) > 0;
    }

    public final void wZ(int i) {
        this.field_sourceType |= i;
    }

    public final void xc(int i) {
        this.field_sourceType &= i ^ -1;
    }

    public final b bAF() {
        if (this.nJm == null) {
            this.nJm = af.byr().eZ(this.field_snsId);
        }
        return this.nJm == null ? new b(null) : this.nJm.bAF();
    }

    public final a bAH() {
        if (this.nJm == null) {
            this.nJm = af.byr().eZ(this.field_snsId);
        }
        return this.nJm == null ? new a(null) : this.nJm.bAH();
    }

    public final String bBj() {
        a bAH = bAH();
        return bAH == null ? "" : bAH.nyk;
    }

    public final String bBk() {
        a bAH = bAH();
        return bAH == null ? "" : bAH.nyj;
    }

    public final String bBl() {
        b bAF = bAF();
        if (bAF != null) {
            return bAF.nxZ;
        }
        return "";
    }

    public final String bBm() {
        a bAH = bAH();
        if (bAH != null) {
            return bAH.nxZ;
        }
        return "";
    }

    public final String bBn() {
        a bAH = bAH();
        if (bAH != null) {
            return bAH.fvT;
        }
        return "";
    }

    public final String bBo() {
        a bAH = bAH();
        if (bAH != null) {
            return bAH.ntU;
        }
        return "";
    }

    public final e bBp() {
        if (this.nJm == null) {
            this.nJm = af.byr().eZ(this.field_snsId);
        }
        if (this.nJm != null) {
            this.nJm.field_createTime = this.field_createTime;
            this.nJm.field_userName = this.field_userName;
            this.nJm.field_likeFlag = this.field_likeFlag;
            this.nJm.field_attrBuf = this.field_attrBuf;
        }
        return this.nJm;
    }

    public final boolean kF() {
        return xb(32);
    }

    public final int bBq() {
        b bAF = bAF();
        if (bAF != null) {
            return bAF.nyY;
        }
        return 0;
    }

    public final boolean bzx() {
        b bAF = bAF();
        if (bAF != null) {
            return bAF.bzx();
        }
        return false;
    }

    public final boolean isValid() {
        return this.field_snsId != 0;
    }

    public final boolean bxX() {
        return this.field_snsId == 0;
    }

    public final int bBr() {
        if (!xb(32)) {
            return -1;
        }
        b bAF = bAF();
        bsu bAJ = bAJ();
        if (bAF.bzq()) {
            return 3;
        }
        if (bAJ != null && bAJ.sqc.ruz == 27) {
            return 6;
        }
        if (bAF.bzr()) {
            if (bAJ == null || bAJ.sqc.ruz != 15 || bAJ.sqj == 1) {
                return 4;
            }
            return 5;
        } else if (this.field_type != 1) {
            return 2;
        } else {
            return 1;
        }
    }

    public final boolean bBs() {
        return bBr() == 6;
    }

    public final boolean bzr() {
        int bBr = bBr();
        return bBr == 5 || bBr == 4;
    }

    public final Bundle bAM() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("values", super.wH());
        bundle.putInt("localid", this.nJc);
        if (bBp() != null) {
            bundle.putBundle("adValues", bBp().bAM());
        }
        return bundle;
    }
}
