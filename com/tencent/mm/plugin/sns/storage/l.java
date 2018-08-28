package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.g.c.dw;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.protocal.c.vu;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.reflect.Field;

public final class l extends dw {
    protected static a dhO;

    static {
        a aVar = new a();
        aVar.sKy = new Field[16];
        aVar.columns = new String[17];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.sKA.put("userName", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "userName";
        aVar.columns[1] = "md5";
        aVar.sKA.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "newerIds";
        aVar.sKA.put("newerIds", "TEXT");
        stringBuilder.append(" newerIds TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "bgId";
        aVar.sKA.put("bgId", "TEXT");
        stringBuilder.append(" bgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "bgUrl";
        aVar.sKA.put("bgUrl", "TEXT");
        stringBuilder.append(" bgUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "older_bgId";
        aVar.sKA.put("older_bgId", "TEXT");
        stringBuilder.append(" older_bgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "local_flag";
        aVar.sKA.put("local_flag", "INTEGER");
        stringBuilder.append(" local_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "istyle";
        aVar.sKA.put("istyle", "INTEGER");
        stringBuilder.append(" istyle INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "iFlag";
        aVar.sKA.put("iFlag", "INTEGER");
        stringBuilder.append(" iFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "icount";
        aVar.sKA.put("icount", "INTEGER");
        stringBuilder.append(" icount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "faultS";
        aVar.sKA.put("faultS", "BLOB");
        stringBuilder.append(" faultS BLOB");
        stringBuilder.append(", ");
        aVar.columns[11] = "snsBgId";
        aVar.sKA.put("snsBgId", "LONG");
        stringBuilder.append(" snsBgId LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "snsuser";
        aVar.sKA.put("snsuser", "BLOB");
        stringBuilder.append(" snsuser BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "adsession";
        aVar.sKA.put("adsession", "BLOB");
        stringBuilder.append(" adsession BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "lastFirstPageRequestErrCode";
        aVar.sKA.put("lastFirstPageRequestErrCode", "INTEGER");
        stringBuilder.append(" lastFirstPageRequestErrCode INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "lastFirstPageRequestErrType";
        aVar.sKA.put("lastFirstPageRequestErrType", "INTEGER");
        stringBuilder.append(" lastFirstPageRequestErrType INTEGER");
        aVar.columns[16] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final void bAS() {
        this.field_local_flag &= -3;
    }

    public final boolean bAT() {
        return (this.field_local_flag & 2) > 0;
    }

    public final bqd bAU() {
        try {
            return (bqd) new bqd().aG(this.field_snsuser);
        } catch (Exception e) {
            return null;
        }
    }

    public final vu bAV() {
        xs xsVar = new xs();
        vu vuVar = new vu();
        if (bi.bC(this.field_faultS)) {
            return vuVar;
        }
        try {
            vu vuVar2;
            xsVar = (xs) new xs().aG(this.field_faultS);
            if (xsVar.rDy.size() > 0) {
                vuVar2 = (vu) xsVar.rDy.getFirst();
            } else {
                vuVar2 = vuVar;
            }
            return vuVar2;
        } catch (Exception e) {
            return vuVar;
        }
    }
}
