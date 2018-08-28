package com.tencent.mm.ac;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.ac.d.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class e extends i<d> {
    public static final String[] ciG = new String[]{"CREATE  INDEX IF NOT EXISTS type_username_index ON bizinfo ( type,username ) ", "CREATE  INDEX IF NOT EXISTS  username_acceptType_index ON bizinfo ( username,acceptType ) "};
    public static Map<String, String> dLV = new HashMap();
    public static final String[] diD = new String[]{i.a(d.dhO, "bizinfo")};
    private final k<a, b> dKC = new 1(this);

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.dhO, "bizinfo", ciG);
    }

    public final void a(a aVar, Looper looper) {
        this.dKC.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.dKC != null) {
            this.dKC.remove(aVar);
        }
    }

    public final d kA(String str) {
        d dVar = new d();
        dVar.field_username = str;
        super.b(dVar, new String[0]);
        return dVar;
    }

    public final void delete(String str) {
        d dVar = new d();
        dVar.field_username = str;
        String[] strArr = new String[]{"username"};
        x.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[]{Boolean.valueOf(super.a(dVar, strArr)), str});
        b bVar = new b();
        bVar.dKF = str;
        bVar.dMb = a.dLY;
        bVar.dMc = dVar;
        this.dKC.ci(bVar);
        this.dKC.doNotify();
    }

    public final void c(d dVar) {
        String[] strArr = new String[]{"username"};
        x.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[]{Boolean.valueOf(super.a(dVar, strArr)), dVar.field_username});
        b bVar = new b();
        bVar.dKF = dVar.field_username;
        bVar.dMb = a.dLY;
        bVar.dMc = dVar;
        this.dKC.ci(bVar);
        this.dKC.doNotify();
    }

    /* renamed from: d */
    public final boolean b(d dVar) {
        dVar.field_updateTime = System.currentTimeMillis();
        dVar.LT();
        x.v("MicroMsg.BizInfoStorage", "username is %s, %s, %d, %s, %s, %s, %d", new Object[]{dVar.field_username, dVar.field_brandList, Integer.valueOf(dVar.field_brandFlag), dVar.field_brandInfo, dVar.field_extInfo, dVar.field_brandIconURL, Long.valueOf(dVar.field_updateTime)});
        b bG = dVar.bG(false);
        if (bG != null) {
            b.b Ms = bG.Ms();
            if (Ms != null) {
                dVar.field_specialType = Ms.dLA;
            }
        }
        boolean b = super.b(dVar);
        if (b && !s.fq(dVar.field_username)) {
            b bVar = new b();
            bVar.dKF = dVar.field_username;
            bVar.dLf = dVar.LU();
            bVar.dMb = a.dLX;
            bVar.dMc = dVar;
            this.dKC.ci(bVar);
            this.dKC.doNotify();
        }
        return b;
    }

    /* renamed from: e */
    public final boolean a(d dVar) {
        dVar.field_updateTime = System.currentTimeMillis();
        dVar.LT();
        b bG = dVar.bG(false);
        if (bG != null) {
            b.b Ms = bG.Ms();
            if (Ms != null) {
                dVar.field_specialType = Ms.dLA;
            }
        }
        boolean a = super.a(dVar);
        if (a && !s.fq(dVar.field_username)) {
            b bVar = new b();
            bVar.dKF = dVar.field_username;
            bVar.dLf = dVar.LU();
            bVar.dMb = a.dLZ;
            bVar.dMc = dVar;
            this.dKC.ci(bVar);
            this.dKC.doNotify();
        }
        return a;
    }

    public final List<String> hw(int i) {
        x.i("MicroMsg.BizInfoStorage", "getList: sql[%s]", new Object[]{String.format(Locale.US, "select %s from %s where %s & %d > 0", new Object[]{"username", "bizinfo", "acceptType", Integer.valueOf(i)})});
        long VG = bi.VG();
        Cursor rawQuery = rawQuery(r0, new String[0]);
        List<String> linkedList = new LinkedList();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    linkedList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            x.i("MicroMsg.BizInfoStorage", "getMyAcceptList: type[%d], use time[%d ms]", new Object[]{Integer.valueOf(i), Long.valueOf(bi.bI(VG))});
            return ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().dp(linkedList);
        }
        x.i("MicroMsg.BizInfoStorage", "getMyAcceptList: cursor not null, type[%d], use time[%d ms]", new Object[]{Integer.valueOf(i), Long.valueOf(bi.bI(VG))});
        return linkedList;
    }

    public final int hx(int i) {
        List hw = hw(i);
        if (bi.cX(hw)) {
            return 0;
        }
        return hw.size();
    }

    public static String MD() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rcontact.showHead asc, ");
        stringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(rcontact.conRemarkPYFull) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(rcontact.conRemark) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" upper(rcontact.quanPin) asc, ");
        stringBuffer.append(" upper(rcontact.nickname) asc, ");
        stringBuffer.append(" upper(rcontact.username) asc ");
        return stringBuffer.toString();
    }

    public static String ME() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rcontact.type & 2048 desc, ");
        stringBuffer.append("rcontact.showHead asc, ");
        stringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(rcontact.conRemarkPYFull) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(rcontact.conRemark) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" upper(rcontact.quanPin) asc, ");
        stringBuffer.append(" upper(rcontact.nickname) asc, ");
        stringBuffer.append(" upper(rcontact.username) asc ");
        return stringBuffer.toString();
    }

    public static void a(StringBuilder stringBuilder) {
        stringBuilder.append("select bizinfo.username ");
    }

    public static void b(StringBuilder stringBuilder) {
        stringBuilder.append("select bizinfo.brandIconURL");
        stringBuilder.append(", bizinfo.type");
        stringBuilder.append(", bizinfo.status");
        stringBuilder.append(", bizinfo.enterpriseFather");
        stringBuilder.append(", bizinfo.brandFlag");
        stringBuilder.append(", bizinfo.extInfo");
        stringBuilder.append(", rcontact.username");
        stringBuilder.append(", rcontact.conRemark");
        stringBuilder.append(", rcontact.quanPin");
        stringBuilder.append(", rcontact.nickname");
        stringBuilder.append(", rcontact.alias");
        stringBuilder.append(", rcontact.type ");
    }

    public static void c(StringBuilder stringBuilder) {
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where rcontact.username = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag & ").append(ab.ckY()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type & 1) != 0 ");
    }

    public static void d(StringBuilder stringBuilder) {
        stringBuilder.append(" and bizinfo.type = 3 ");
    }

    public static void a(StringBuilder stringBuilder, String str) {
        stringBuilder.append(" and bizinfo.type = 3");
        stringBuilder.append(" and bizinfo.enterpriseFather = '").append(str).append("' ");
    }

    public static void a(StringBuilder stringBuilder, boolean z) {
        stringBuilder.append(" and (bizinfo.bitFlag & 1) ");
        stringBuilder.append(z ? "!=" : "==").append(" 0 ");
    }

    public static void b(StringBuilder stringBuilder, boolean z) {
        stringBuilder.append(" and (bizinfo.brandFlag & 1) ");
        stringBuilder.append(z ? "==" : "!=").append(" 0 ");
    }

    public static Cursor K(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        a(stringBuilder, false);
        b(stringBuilder, true);
        stringBuilder.append(" and (bizinfo.acceptType & ").append(i).append(") > 0 ");
        stringBuilder.append(" order by ");
        stringBuilder.append(MD());
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseChildOfAcceptType sql %s", new Object[]{stringBuilder.toString()});
        return g.Ei().dqq.b(stringBuilder.toString(), null, 0);
    }

    public final Cursor kB(String str) {
        String str2;
        List<String> kC = kC(str);
        List arrayList = new ArrayList();
        for (String str22 : kC) {
            if (!bi.oW(kA(str22).Mf())) {
                arrayList.add(str22);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        b(stringBuilder, true);
        stringBuilder.append(" and (");
        for (int i = 0; i < arrayList.size(); i++) {
            str22 = (String) arrayList.get(i);
            if (i > 0) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("rcontact.username = '").append(str22).append("'");
        }
        stringBuilder.append(") order by ");
        stringBuilder.append(ME());
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseChatConnector sql %s", new Object[]{stringBuilder.toString()});
        return g.Ei().dqq.b(stringBuilder.toString(), null, 0);
    }

    public static List<String> MF() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select rcontact.username");
        stringBuilder.append(", bizinfo.enterpriseFather");
        stringBuilder.append(", bizinfo.bitFlag & 1");
        c(stringBuilder);
        d(stringBuilder);
        stringBuilder.append(" and (");
        stringBuilder.append(" (bizinfo.bitFlag & 1) != 0");
        stringBuilder.append(" or ");
        stringBuilder.append(" (bizinfo.acceptType & 128) > 0 ");
        stringBuilder.append(" and (bizinfo.brandFlag & 1) == 0) ");
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseConnectorList sql %s", new Object[]{stringBuilder.toString()});
        Cursor b = g.Ei().dqq.b(r0, null, 2);
        List<String> arrayList = new ArrayList();
        if (b == null) {
            return arrayList;
        }
        while (b.moveToNext()) {
            int i;
            if (b.getInt(2) > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                i = 0;
            } else {
                i = 1;
            }
            arrayList.add(b.getString(i));
        }
        b.close();
        return ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().dp(arrayList);
    }

    public static Cursor C(String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        b(stringBuilder, true);
        if (z) {
            a(stringBuilder, false);
        }
        stringBuilder.append(" order by ");
        stringBuilder.append(ME());
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseEnableChild sql %s", new Object[]{stringBuilder.toString()});
        return g.Ei().dqq.b(stringBuilder.toString(), null, 0);
    }

    public static List<String> kC(String str) {
        List<String> list = null;
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseChildNameList sql %s", new Object[]{stringBuilder.toString()});
        Cursor b = g.Ei().dqq.b(r1, null, 2);
        if (b != null) {
            list = new ArrayList();
            while (b.moveToNext()) {
                list.add(b.getString(0));
            }
            b.close();
        }
        return list;
    }

    public static String kD(String str) {
        String string;
        if (bi.oW(str)) {
            x.w("MicroMsg.BizInfoStorage", "getBizChatBrandUserName userName is null");
            return null;
        } else if (dLV == null || !dLV.containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            a(stringBuilder);
            c(stringBuilder);
            a(stringBuilder, str);
            a(stringBuilder, true);
            x.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatChild sql %s", new Object[]{stringBuilder.toString()});
            Cursor b = g.Ei().dqq.b(string, null, 2);
            if (b == null) {
                return null;
            }
            if (b.moveToFirst()) {
                string = b.getString(0);
                dLV.put(str, string);
            } else {
                string = null;
            }
            b.close();
            return string;
        } else {
            string = (String) dLV.get(str);
            if (bi.oW(string) || !s.he(string)) {
                return null;
            }
            return string;
        }
    }

    public static List<String> MG() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select bizinfo.username");
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where bizinfo.specialType = 1");
        stringBuilder.append(" and rcontact.username = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag & ").append(ab.ckY()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type & 1) != 0 ");
        x.i("MicroMsg.BizInfoStorage", "getSpecialInternalBizUsernames sql %s", new Object[]{stringBuilder.toString()});
        List<String> arrayList = new ArrayList();
        Cursor b = g.Ei().dqq.b(r0, null, 2);
        int columnIndex = b.getColumnIndex("username");
        while (b.moveToNext()) {
            arrayList.add(b.getString(columnIndex));
        }
        b.close();
        return arrayList;
    }

    public static boolean kE(String str) {
        boolean z = false;
        if (!bi.oW(str) && f.kN(str)) {
            d kH = f.kH(str);
            if (!(kH.bG(false) == null || kH.bG(false).MB() == null || bi.oW(kH.Mg()))) {
                ai YE = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().YE(kH.Mg());
                if (YE != null && YE.field_username.equals(str) && YE.field_unReadCount > 0) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Ys(kH.Mg());
                }
            }
            Cursor GO = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().GO(str);
            GO.moveToFirst();
            while (!GO.isAfterLast()) {
                bd bdVar = new bd();
                bdVar.d(GO);
                bdVar.setStatus(4);
                x.d("MicroMsg.BizInfoStorage", "writeOpLog: msgSvrId = " + bdVar.field_msgSvrId + " status = " + bdVar.field_status);
                GO.moveToNext();
                z = true;
            }
            GO.close();
            if (z) {
                ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Ys(str);
                ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().GM(str);
            }
        }
        return z;
    }

    public static void kF(String str) {
        if (!bi.oW(str) && f.kN(str)) {
            ((a) g.n(a.class)).getNotification().eJ(str);
            ((a) g.n(a.class)).getNotification().vo();
        }
    }

    public static void kG(String str) {
        if (!bi.oW(str) && f.kN(str)) {
            ((a) g.n(a.class)).getNotification().eJ("");
        }
    }
}
