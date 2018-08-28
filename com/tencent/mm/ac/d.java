package com.tencent.mm.ac;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.g.c.aa;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends aa {
    public static int dKL = 1;
    public static int dKM = 0;
    public static int dKN = 1;
    private static int dKQ = 0;
    private static b dKR = null;
    protected static a dhO;
    private List<a> dKO;
    public b dKP;

    static {
        a aVar = new a();
        aVar.sKy = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.sKA.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "username";
        aVar.columns[1] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "brandList";
        aVar.sKA.put("brandList", "TEXT default '' ");
        stringBuilder.append(" brandList TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "brandListVersion";
        aVar.sKA.put("brandListVersion", "TEXT");
        stringBuilder.append(" brandListVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "brandListContent";
        aVar.sKA.put("brandListContent", "TEXT");
        stringBuilder.append(" brandListContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "brandFlag";
        aVar.sKA.put("brandFlag", "INTEGER");
        stringBuilder.append(" brandFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "extInfo";
        aVar.sKA.put("extInfo", "TEXT");
        stringBuilder.append(" extInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "brandInfo";
        aVar.sKA.put("brandInfo", "TEXT");
        stringBuilder.append(" brandInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "brandIconURL";
        aVar.sKA.put("brandIconURL", "TEXT");
        stringBuilder.append(" brandIconURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "updateTime";
        aVar.sKA.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "hadAlert";
        aVar.sKA.put("hadAlert", "INTEGER");
        stringBuilder.append(" hadAlert INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "acceptType";
        aVar.sKA.put("acceptType", "INTEGER default '0' ");
        stringBuilder.append(" acceptType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "type";
        aVar.sKA.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "status";
        aVar.sKA.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "enterpriseFather";
        aVar.sKA.put("enterpriseFather", "TEXT");
        stringBuilder.append(" enterpriseFather TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "kfWorkerId";
        aVar.sKA.put("kfWorkerId", "TEXT");
        stringBuilder.append(" kfWorkerId TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "specialType";
        aVar.sKA.put("specialType", "INTEGER");
        stringBuilder.append(" specialType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "attrSyncVersion";
        aVar.sKA.put("attrSyncVersion", "TEXT");
        stringBuilder.append(" attrSyncVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "incrementUpdateTime";
        aVar.sKA.put("incrementUpdateTime", "LONG");
        stringBuilder.append(" incrementUpdateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[19] = "bitFlag";
        aVar.sKA.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        aVar.columns[20] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final b bG(boolean z) {
        if (this.dKP == null || z) {
            if (bi.oW(this.field_extInfo) || dKQ != this.field_extInfo.hashCode()) {
                b ks = b.ks(this.field_extInfo);
                this.dKP = ks;
                dKR = ks;
                dKQ = bi.oV(this.field_extInfo).hashCode();
            } else {
                this.dKP = dKR;
            }
        }
        return this.dKP;
    }

    public final boolean LQ() {
        return (this.field_brandFlag & 1) == 0;
    }

    public final boolean LR() {
        return (this.field_brandFlag & 4) != 0;
    }

    public final boolean LS() {
        if (System.currentTimeMillis() - this.field_updateTime > 86400000) {
            return true;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        if (this.field_updateTime >= instance.getTimeInMillis()) {
            return false;
        }
        return true;
    }

    public final void LT() {
        bG(false);
        b bVar = this.dKP;
        if (bVar.dKT != null) {
            bVar.dLh = bVar.dKT.optInt("ConnectorMsgType");
        }
        this.field_acceptType = bVar.dLh;
        this.field_type = bG(false).Mw();
        if (Ma()) {
            hv(1);
        } else {
            this.field_bitFlag &= -2;
        }
    }

    public final boolean LU() {
        bG(false);
        x.i("MicroMsg.BizInfo", "is report location, user %s %B", new Object[]{this.field_username, Boolean.valueOf(this.dKP.LU())});
        return this.dKP.LU();
    }

    public final boolean LV() {
        bG(false);
        if (this.field_type == 1) {
            return true;
        }
        return false;
    }

    public final boolean LW() {
        bG(false);
        if (this.field_type == 0) {
            return true;
        }
        return false;
    }

    public final boolean LX() {
        bG(false);
        if (this.field_type == 2 || this.field_type == 3) {
            return true;
        }
        return false;
    }

    public final boolean LY() {
        bG(false);
        if (this.field_type == 2) {
            return true;
        }
        return false;
    }

    public final boolean LZ() {
        bG(false);
        if (this.field_type == 3) {
            return true;
        }
        return false;
    }

    public final boolean Ma() {
        bG(false);
        if (this.dKP == null || this.dKP.MB() == null) {
            return false;
        }
        boolean z = this.dKP.dLe.dLF == 1;
        if (z && !hu(1)) {
            hv(1);
            z.MY().e(this);
        }
        if (!z) {
            return z;
        }
        x.d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", new Object[]{this.field_username});
        return z;
    }

    public final boolean Mb() {
        bG(false);
        if (this.dKP == null || this.dKP.MB() == null) {
            return false;
        }
        boolean z = this.dKP.dLe.dLF == 2;
        if (z && !hu(2)) {
            hv(2);
            z.MY().e(this);
        }
        if (!z) {
            return z;
        }
        x.d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", new Object[]{this.field_username});
        return z;
    }

    public final String Mc() {
        bG(false);
        if (this.dKP != null) {
            a MB = this.dKP.MB();
            if (!(MB == null || MB.dLG == null || MB.dLG.isEmpty())) {
                return MB.dLG;
            }
        }
        return null;
    }

    public final long Md() {
        bG(false);
        if (this.dKP == null) {
            return 0;
        }
        a MB = this.dKP.MB();
        if (MB == null || MB.appid == 0) {
            return 0;
        }
        return MB.appid;
    }

    public final boolean Me() {
        bG(false);
        if (this.dKP == null) {
            x.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo() null");
            return true;
        } else if (this.dKP.Mu() == null) {
            x.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo().getRegisterSource() null");
            return true;
        } else if (this.dKP.Mu().dLU) {
            return false;
        } else {
            return true;
        }
    }

    public final String Mf() {
        bG(false);
        if (this.dKP != null) {
            a MB = this.dKP.MB();
            if (MB != null) {
                return MB.dLH;
            }
        }
        return null;
    }

    public final String Mg() {
        String str = bG(false).MB().dLD;
        if (bi.oW(str)) {
            x.e("MicroMsg.BizInfo", "check father: %s, %s", new Object[]{this.field_username, str});
        }
        return str;
    }

    public final void d(Cursor cursor) {
        super.d(cursor);
    }

    public final ContentValues wH() {
        return super.wH();
    }

    public final List<a> Mh() {
        if (this.dKO != null) {
            return this.dKO;
        }
        this.dKO = new LinkedList();
        if (this.field_brandInfo == null || this.field_brandInfo.length() == 0) {
            return this.dKO;
        }
        try {
            JSONArray optJSONArray = new JSONObject(this.field_brandInfo).optJSONArray("urls");
            for (int i = 0; i < optJSONArray.length(); i++) {
                a aVar = new a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                aVar.title = optJSONObject.optString("title");
                aVar.url = optJSONObject.optString("url");
                aVar.dKS = optJSONObject.optString("title_key");
                aVar.description = optJSONObject.optString("description");
                this.dKO.add(aVar);
            }
        } catch (Throwable e) {
            x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bi.i(e)});
        }
        return this.dKO;
    }

    private boolean hu(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    private void hv(int i) {
        this.field_bitFlag |= i;
    }
}
