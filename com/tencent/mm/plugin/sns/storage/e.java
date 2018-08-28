package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.g.c.f;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e extends f {
    protected static a dhO;
    protected static Map<String, b> nJd = new ConcurrentHashMap();
    protected static Map<String, a> nJe = new ConcurrentHashMap();
    public String nJb = null;
    protected int nJc;

    static {
        a aVar = new a();
        aVar.sKy = new Field[22];
        aVar.columns = new String[23];
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
        aVar.columns[14] = "adinfo";
        aVar.sKA.put("adinfo", "TEXT");
        stringBuilder.append(" adinfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "adxml";
        aVar.sKA.put("adxml", "TEXT");
        stringBuilder.append(" adxml TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "createAdTime";
        aVar.sKA.put("createAdTime", "INTEGER");
        stringBuilder.append(" createAdTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "exposureTime";
        aVar.sKA.put("exposureTime", "INTEGER");
        stringBuilder.append(" exposureTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[18] = "firstControlTime";
        aVar.sKA.put("firstControlTime", "INTEGER");
        stringBuilder.append(" firstControlTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "recxml";
        aVar.sKA.put("recxml", "TEXT");
        stringBuilder.append(" recxml TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "subType";
        aVar.sKA.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[21] = "exposureCount";
        aVar.sKA.put("exposureCount", "INTEGER");
        stringBuilder.append(" exposureCount INTEGER");
        aVar.columns[22] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final b bAF() {
        b bVar;
        if (this.field_adxml == null) {
            bVar = null;
        } else if (nJd.containsKey(this.field_adxml)) {
            return (b) nJd.get(this.field_adxml);
        } else {
            bVar = new b(this.field_adxml);
            nJd.put(this.field_adxml, bVar);
        }
        return bVar == null ? new b(null) : bVar;
    }

    public final b bAG() {
        b bVar;
        if (this.field_recxml == null) {
            bVar = null;
        } else if (nJd.containsKey(this.field_recxml)) {
            return (b) nJd.get(this.field_recxml);
        } else {
            bVar = new b(this.field_recxml);
            nJd.put(this.field_recxml, bVar);
        }
        return bVar == null ? new b(null) : bVar;
    }

    public final a bAH() {
        a aVar;
        if (this.field_adinfo == null) {
            aVar = null;
        } else if (nJe.containsKey(this.field_adinfo)) {
            return (a) nJe.get(this.field_adinfo);
        } else {
            aVar = new a(this.field_adinfo);
            nJe.put(this.field_adinfo, aVar);
        }
        return aVar == null ? new a(null) : aVar;
    }

    public final boolean Ni(String str) {
        if (str == null || str.length() <= 0 || str.equals(this.field_adinfo)) {
            return false;
        }
        nJe.remove(this.field_adinfo);
        this.field_adinfo = str;
        return true;
    }

    public final boolean bzx() {
        b bAF = bAF();
        if (bAF != null) {
            return bAF.bzx();
        }
        return false;
    }

    public final int bAI() {
        b bAG = bAG();
        return bAG == null ? 0 : bAG.nyY;
    }

    public final int getSource() {
        b bAG = bAG();
        return bAG == null ? 0 : bAG.nyY;
    }

    public final void c(bsu bsu) {
        try {
            this.field_content = bsu.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AdSnsInfo", e, "", new Object[0]);
        }
    }

    public final boolean Nj(String str) {
        try {
            this.field_content = com.tencent.mm.modelsns.e.ng(str).toByteArray();
            this.nJb = g.u(this.field_content) + g.u(this.field_attrBuf);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AdSnsInfo", e, "", new Object[0]);
            return false;
        }
    }

    public final bsu bAJ() {
        if (this.field_content == null) {
            return com.tencent.mm.modelsns.e.RF();
        }
        bsu bsu;
        if (this.nJb == null) {
            this.nJb = g.u(this.field_content) + g.u(this.field_attrBuf);
        }
        if (n.nJj.containsKey(this.nJb)) {
            bsu = (bsu) n.nJj.get(this.nJb);
            if (bsu != null) {
                return bsu;
            }
        }
        try {
            bsu = (bsu) new bsu().aG(this.field_content);
            n.nJj.put(this.nJb, bsu);
            return bsu;
        } catch (Exception e) {
            x.e("MicroMsg.AdSnsInfo", "error get snsinfo timeline!");
            return com.tencent.mm.modelsns.e.RF();
        }
    }

    public final void aK(byte[] bArr) {
        this.field_attrBuf = bArr;
        this.nJb = g.u(this.field_content) + g.u(this.field_attrBuf);
    }

    public final void wZ(int i) {
        this.field_sourceType |= i;
    }

    public final String bAK() {
        return v.ah("ad_table_", this.field_snsId);
    }

    public final n bAL() {
        n nVar = new n();
        nVar.c(bAJ());
        x.d("MicroMsg.AdSnsInfo", "from server xml ok %d", new Object[]{Long.valueOf(this.field_snsId)});
        nVar.nJc = this.nJc;
        nVar.field_userName = this.field_userName;
        nVar.hK(this.field_createTime);
        nVar.field_likeFlag = this.field_likeFlag;
        nVar.fe(this.field_snsId);
        nVar.field_sourceType = this.field_sourceType;
        nVar.field_content = this.field_content;
        nVar.wZ(2);
        nVar.wZ(32);
        nVar.field_attrBuf = this.field_attrBuf;
        bsu bAJ = nVar.bAJ();
        bAJ.hbL = this.field_userName;
        nVar.field_pravited = bAJ.rVG;
        nVar.bBb();
        nVar.c(bAJ);
        if (bAJ.sqc != null) {
            nVar.field_type = bAJ.sqc.ruz;
            nVar.field_subType = bAJ.sqc.ruB;
        }
        nVar.nJm = this;
        return nVar;
    }

    public final void d(Cursor cursor) {
        super.d(cursor);
        this.nJc = (int) this.sKx;
    }

    public final Bundle bAM() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("values", super.wH());
        bundle.putInt("localid", this.nJc);
        return bundle;
    }

    public final void F(Bundle bundle) {
        if (bundle != null) {
            ContentValues contentValues = (ContentValues) bundle.getParcelable("values");
            this.field_snsId = contentValues.getAsLong("snsId").longValue();
            this.field_userName = contentValues.getAsString("userName");
            this.field_localFlag = contentValues.getAsInteger("localFlag").intValue();
            this.field_createTime = contentValues.getAsInteger("createTime").intValue();
            this.field_head = contentValues.getAsInteger("head").intValue();
            this.field_localPrivate = contentValues.getAsInteger("localPrivate").intValue();
            this.field_type = contentValues.getAsInteger("type").intValue();
            this.field_sourceType = contentValues.getAsInteger("sourceType").intValue();
            this.field_likeFlag = contentValues.getAsInteger("likeFlag").intValue();
            this.field_pravited = contentValues.getAsInteger("pravited").intValue();
            this.field_stringSeq = contentValues.getAsString("stringSeq");
            this.field_content = contentValues.getAsByteArray("content");
            this.field_attrBuf = contentValues.getAsByteArray("attrBuf");
            this.field_postBuf = contentValues.getAsByteArray("postBuf");
            this.field_adinfo = contentValues.getAsString("adinfo");
            this.field_adxml = contentValues.getAsString("adxml");
            this.field_createAdTime = contentValues.getAsInteger("createAdTime").intValue();
            this.field_exposureTime = contentValues.getAsInteger("exposureTime").intValue();
            this.field_firstControlTime = contentValues.getAsInteger("firstControlTime").intValue();
            this.field_recxml = contentValues.getAsString("recxml");
            this.field_subType = contentValues.getAsInteger("subType").intValue();
            this.sKx = contentValues.getAsLong("rowid").longValue();
            this.nJc = bundle.getInt("localid");
        }
    }
}
