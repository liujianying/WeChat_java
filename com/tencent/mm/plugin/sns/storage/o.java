package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class o extends i<n> implements g {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS serverSnsNameIndex ON SnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverSnsTimeHeadIndex ON SnsInfo ( head )", "DROP INDEX IF EXISTS serverSnsTimeIndex", "DROP INDEX IF EXISTS serverSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS snsMultiIndex1 ON SnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS snsMultiIndex2 ON SnsInfo ( sourceType,type,userName)", "CREATE INDEX IF NOT EXISTS snsLocalflagIndex ON SnsInfo ( localFlag )"};
    public static final String[] diD = new String[]{i.a(n.dhO, "SnsInfo")};
    protected static String nJA = " (sourceType & 2 != 0 ) and type < 21";
    private static String nJB;
    private static String nJC;
    private static String nJD;
    private static ArrayList<Integer> nJE = cm(Arrays.asList(new Integer[]{Integer.valueOf(16), Integer.valueOf(32), Integer.valueOf(2), Integer.valueOf(8), Integer.valueOf(64), Integer.valueOf(128)}));
    private static ArrayList<Integer> nJF = cm(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(8)}));
    private static String[] nJq = new String[]{"snsId", "userName", "localFlag", "createTime", "head", "localPrivate", "type", "sourceType", "likeFlag", "pravited", "stringSeq", "content", "attrBuf", "postBuf", "rowid"};
    public static String nJr;
    public static String nJs = " order by SnsInfo.createTime desc ,snsId desc";
    public static String nJt = " order by SnsInfo.createTime asc ,snsId asc";
    private static String nJu = " order by SnsInfo.createTime asc ,snsId asc";
    private static String nJv = " order by SnsInfo.head desc ,SnsInfo.createTime desc ";
    private static String nJw = " order by SnsInfo.head desc ,snsId desc";
    public static String nJx;
    public static String nJy;
    protected static String nJz;
    public e diF;
    private boolean nJo;
    private int nJp;

    static {
        int i;
        nJr = "";
        nJx = null;
        nJy = null;
        nJz = " (sourceType & 2 != 0 ) ";
        nJB = null;
        nJC = null;
        nJD = null;
        nJr = "select ";
        for (i = 0; i < nJq.length; i++) {
            if (i < nJq.length - 1) {
                nJr += " " + nJq[i] + ",";
            } else {
                nJr += " " + nJq[i] + " ";
            }
        }
        x.i("MicroMsg.SnsInfoStorage", "TIMELINE_SELECT_BEGIN " + nJr);
        List arrayList = new ArrayList();
        Iterator it = nJE.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 16) != 0 && (i & 32) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        nJx = g(arrayList, "localFlag");
        x.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{nJx});
        arrayList.clear();
        it = nJE.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 32) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        nJy = g(arrayList, "localFlag");
        x.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{nJy});
        arrayList.clear();
        it = nJE.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 64) == 0 && (i & 32) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        nJD = g(arrayList, "localFlag");
        arrayList.clear();
        it = nJF.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 8) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        nJC = g(arrayList, "sourceType");
        x.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{nJC});
        arrayList.clear();
        it = nJF.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 2) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        nJz = g(arrayList, "sourceType");
        x.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{nJz});
        arrayList.clear();
        it = nJF.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 4) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        nJB = g(arrayList, "sourceType");
        x.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{nJB});
    }

    private static boolean bBt() {
        qc qcVar = new qc();
        a.sFg.m(qcVar);
        return qcVar.caL.caM;
    }

    public static String bBu() {
        if (bBt()) {
            return " (sourceType & 2 != 0 ) and type < 21";
        }
        return " (sourceType & 2 != 0 ) ";
    }

    private static String g(List<Integer> list, String str) {
        StringBuilder stringBuilder = new StringBuilder("(");
        stringBuilder.append(str + " in (");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            stringBuilder.append(it.next());
            if (it.hasNext()) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private static ArrayList<Integer> cm(List<Integer> list) {
        ArrayList arrayList = new ArrayList(list);
        Collection hashSet = new HashSet();
        ArrayList<Integer> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Collection arrayList3 = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList3.add(Integer.valueOf(((Integer) it2.next()).intValue() | num.intValue()));
            }
            hashSet.addAll(new HashSet(arrayList3));
            hashSet.add(num);
        }
        hashSet.add(Integer.valueOf(0));
        arrayList2.addAll(hashSet);
        return arrayList2;
    }

    public o(e eVar) {
        boolean z;
        boolean z2 = true;
        super(eVar, n.dhO, "SnsInfo", ciG);
        this.diF = eVar;
        Cursor b = this.diF.b("select count(*) from SnsInfo where snsId > 0;", null, 2);
        if (!b.moveToFirst() || b.getInt(0) <= 0) {
            b.close();
            z = false;
        } else {
            x.i("MicroMsg.SnsInfoStorage", "exsits snsId > 0  ,count is %d", new Object[]{Integer.valueOf(b.getInt(0))});
            b.close();
            z = true;
        }
        if (z) {
            z2 = false;
        }
        this.nJo = z2;
        this.nJp = 0;
        if (this.nJo) {
            x.i("MicroMsg.SnsInfoStorage", "all sndId < 0 ,so optimalizeForSnsId");
            return;
        }
        nJs = " order by SnsInfo.createTime desc ,case when snsId < 0 then 0 else 1 end ,  snsId desc";
        nJt = " order by SnsInfo.createTime asc ,case when snsId < 0 then 0 else 1 end ,  snsId asc";
        nJv = " order by SnsInfo.head desc ,SnsInfo.createTime desc ";
        nJw = " order by SnsInfo.head desc ,case when snsId < 0 then 0 else 1 end ,  snsId desc";
    }

    public final int y(n nVar) {
        x.d("MicroMsg.SnsInfoStorage", "SnsInfo Insert");
        if (nVar == null) {
            return -1;
        }
        int insert = (int) this.diF.insert("SnsInfo", "", nVar.wH());
        x.d("MicroMsg.SnsInfoStorage", "SnsInfo Insert result " + insert);
        return insert;
    }

    public final void b(String str, boolean z, String str2) {
        String str3 = aU(str, z) + " AND  (snsId != 0  ) ";
        if (Nt(str2)) {
            str3 = str3 + " AND " + Nx(str2);
        }
        n(z, str3);
    }

    public final void n(boolean z, String str) {
        String str2 = "UPDATE SnsInfo SET sourceType = sourceType & " + ((z ? 4 : 8) ^ -1) + str;
        x.d("MicroMsg.SnsInfoStorage", "updateFilterUserName sql " + str2);
        this.diF.fV("SnsInfo", str2);
    }

    public final void bBv() {
        Ns(" where " + bBu() + " AND  (snsId != 0  ) ");
    }

    public final void Nq(String str) {
        if (Nt(str)) {
            Ns(" where " + Nx(str) + " and " + bBu() + " and  (snsId != 0  ) ");
        }
    }

    public final void Nr(String str) {
        if (Nt(str)) {
            Ns(" where " + Nw(str) + " and " + bBu() + " and  (snsId != 0  ) ");
        }
    }

    private void Ns(String str) {
        String str2 = "UPDATE SnsInfo SET sourceType = sourceType & -3" + str;
        x.d("MicroMsg.SnsInfoStorage", "updateFilterTimeLine sql " + str2);
        this.diF.fV("SnsInfo", str2);
    }

    public final boolean fa(long j) {
        Cursor rawQuery = this.diF.rawQuery("select *,rowid from SnsInfo  where SnsInfo.snsId=" + j, null);
        int count = rawQuery.getCount();
        rawQuery.close();
        return count > 0;
    }

    public final boolean a(long j, n nVar) {
        if (fa(j)) {
            return a(j, nVar);
        }
        return y(nVar) != -1;
    }

    public static boolean Nt(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return true;
    }

    public final String Nu(String str) {
        if (str == null || str.equals("")) {
            return " ";
        }
        if (this.nJo) {
            return " (snsId >= " + Nv(bi.oU(str)) + " ) ";
        }
        return " (stringSeq >=\"" + bi.oU(str) + "\"  ) ";
    }

    private static long Nv(String str) {
        x.i("MicroMsg.SnsInfoStorage", "seq %s to snsId %d ", new Object[]{str, Long.valueOf(new BigInteger(str).longValue())});
        return new BigInteger(str).longValue();
    }

    public final String Nw(String str) {
        if (str == null || str.equals("")) {
            return " ";
        }
        if (this.nJo) {
            return " (snsId > " + Nv(bi.oU(str)) + " ) ";
        }
        return " (stringSeq >\"" + bi.oU(str) + "\"  ) ";
    }

    public final String Nx(String str) {
        if (str == null || str.equals("")) {
            return " ";
        }
        if (this.nJo) {
            return " (snsId < " + Nv(bi.oU(str)) + " ) ";
        }
        return " (stringSeq <\"" + bi.oU(str) + "\"  ) ";
    }

    public static String aU(String str, boolean z) {
        String str2 = "";
        if (z) {
            return str2 + " WHERE " + nJB;
        }
        return (str2 + " WHERE SnsInfo.userName=\"" + bi.oU(str) + "\"") + " AND " + nJC;
    }

    public static String aV(String str, boolean z) {
        return ("select *,rowid from SnsInfo " + aU(str, z)) + " AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26)";
    }

    public final long e(long j, int i, boolean z) {
        return c(bBx(), j, i, z);
    }

    public final long a(long j, int i, String str, boolean z) {
        return c(aV(str, z), j, i, false);
    }

    private long c(String str, long j, int i, boolean z) {
        String str2;
        if (j != 0) {
            str2 = str + " AND SnsInfo.stringSeq < '" + com.tencent.mm.plugin.sns.data.i.LK(com.tencent.mm.plugin.sns.data.i.eF(j)) + "'";
        } else {
            str2 = str;
        }
        if (z) {
            str2 = str2 + " AND  (snsId != 0 ) ";
        }
        Cursor rawQuery = this.diF.rawQuery((str2 + nJs) + " limit " + i, null);
        if (rawQuery.moveToLast()) {
            n nVar = new n();
            nVar.d(rawQuery);
            rawQuery.close();
            return nVar.field_snsId;
        }
        rawQuery.close();
        return 0;
    }

    public static String bBw() {
        return "select *,rowid from SnsInfo  where " + " (sourceType & 2 != 0 ) ";
    }

    public static String bBx() {
        return "select *,rowid from SnsInfo  where " + bBu();
    }

    public static String bBy() {
        return "select *,rowid from SnsInfo  where " + (bBt() ? nJA : nJz);
    }

    public static String bBz() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select snsId from SnsInfo  where ").append(bBu()).append(" limit 3");
        return stringBuilder.toString();
    }

    public final Cursor b(String str, int i, boolean z, String str2) {
        String aV = aV(str, z);
        if (Nt(str2)) {
            aV = aV + " AND " + Nu(str2);
        }
        if (z) {
            aV = aV + nJv;
        } else {
            aV = aV + nJw;
        }
        if (i > 0) {
            aV = aV + " LIMIT " + i;
        }
        x.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery " + aV);
        return this.diF.rawQuery(aV, null);
    }

    public final Cursor Lw(String str) {
        String bBx = bBx();
        if (Nt(str)) {
            bBx = bBx + " AND " + Nu(str);
        }
        bBx = bBx + nJs;
        x.d("MicroMsg.SnsInfoStorage", "getCursorForTimeLine " + bBx);
        return this.diF.rawQuery(bBx, null);
    }

    public final List<n> aW(String str, boolean z) {
        Cursor b = this.diF.b("select *,rowid from SnsInfo " + aU(str, z) + " AND type = 4", null, 2);
        List<n> arrayList = new ArrayList();
        while (b.moveToNext()) {
            n nVar = new n();
            nVar.d(b);
            arrayList.add(nVar);
        }
        b.close();
        return arrayList;
    }

    public final int Ny(String str) {
        String bBx = bBx();
        if (Nt(str)) {
            bBx = bBx + " AND " + Nu(str);
        }
        String str2 = (bBx + " AND  (snsId != 0 ) ") + nJt + " limit 1";
        Cursor b = this.diF.b(str2, null, 2);
        int i = 0;
        if (b.moveToFirst()) {
            n nVar = new n();
            nVar.d(b);
            i = nVar.field_createTime;
        }
        b.close();
        x.i("MicroMsg.SnsInfoStorage", "getLastTime " + str2 + " createtime " + i);
        return i;
    }

    public final Cursor ch(String str, int i) {
        String str2 = (nJr + " from SnsInfo where ") + bBu();
        if (Nt(str)) {
            str2 = str2 + " AND " + Nu(str);
        }
        str2 = (((str2 + " AND createTime >= " + i) + " UNION ") + nJr + " from AdSnsInfo where createTime > " + i) + nJs;
        x.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine " + str2 + " limtiSeq: " + str);
        return this.diF.rawQuery(str2, null);
    }

    public final void eB(long j) {
        int i;
        ad.getContext().getSharedPreferences(ad.chY(), 0).edit().putLong("check_trim_time", 0).commit();
        h FO = af.FO();
        long dO = FO.dO(Thread.currentThread().getId());
        for (i = 0; ((long) i) < j; i++) {
            FO.fV("SnsInfo", "INSERT INTO SnsInfo VALUES(-69999999991777434909,'miaochanchan',2,1402026897,20140606,0,2,2,0,0,'0',X'0A143131373631303534303431393332313136373037120C6D69616F6368616E6368616E18002091F7C49C052A36E8A681E6849FE8B0A2E8BF99E4BBBDE5B7A5EFBC8CE8AEA9E68891E4B88DE4BC9AE69C89E5A29EE882A5E79A84E8BFB9E8B1A1E3808232180D0000000015000000001A0022002A0032003800480050003A0A0A0012001A0022002A0042080A0010021A0022004A0052005A006000680272007A2408001200180022002A0032003A080A0012001A00220042004A040800100052040A001200',X'08E3E5A48CEA8AEA9BA301120C6D69616F6368616E6368616E1A09E88B97E7B1B3E7B1B32091F7C49C052A04080012003000380040005000580068007000800101880100900100A00101B00100B80100',NULL);");
        }
        for (i = 0; ((long) i) < 20000; i++) {
            FO.fV("snsExtInfo3", String.format("INSERT INTO snsExtInfo3 VALUES('zeustest%d','afd',2,1402026897,'d', 0,1, 1, 1, 1, 'a', 'a', NULL);", new Object[]{Integer.valueOf(i)}));
        }
        for (i = 0; ((long) i) < 20000; i++) {
            FO.fV("snsComment", String.format("INSERT INTO snsComment VALUES(-69999999991777434909,0,2,1402026897,'d', 2,1, 'a', 'b', 1, NULL);", new Object[0]));
        }
        FO.gp(dO);
    }

    public final ArrayList<Long> bwV() {
        ArrayList<Long> arrayList = new ArrayList();
        Cursor a = this.diF.a("SnsInfo", new String[]{"*", "rowid"}, "createTime >=? AND " + nJD, new String[]{String.valueOf(((int) (System.currentTimeMillis() / 1000)) - 172800)}, null, null, "createTime ASC", 2);
        while (a.moveToNext()) {
            try {
                n nVar = new n();
                nVar.d(a);
                if (nVar.nJc != -1 && nVar.field_userName.equals(q.GF())) {
                    arrayList.add(Long.valueOf((long) nVar.nJc));
                    x.d("MicroMsg.SnsInfoStorage", "getAllNeedResendSns, add snsInfo: " + nVar.bBe());
                }
            } finally {
                a.close();
            }
        }
        x.d("MicroMsg.SnsInfoStorage", "getAllNeedResendSns, resendList.size:%d", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }

    public final boolean wi(int i) {
        return xd(i) != null;
    }

    /* renamed from: z */
    public final boolean a(n nVar) {
        if (nVar.xb(32)) {
            return af.byr().a(nVar.bBp());
        }
        boolean z = this.diF.replace("SnsInfo", "", nVar.wH()) > 0;
        x.d("MicroMsg.SnsInfoStorage", "SnsInfo replace result " + z);
        return z;
    }

    public final n fi(long j) {
        n nVar = new n();
        Cursor b = this.diF.b("select *,rowid from SnsInfo  where SnsInfo.snsId=" + j + " limit 1", null, 2);
        if (b.moveToFirst()) {
            nVar.d(b);
            b.close();
            return nVar;
        }
        b.close();
        return null;
    }

    public final n Nk(String str) {
        if (v.Lr(str)) {
            return fi(v.NE(str));
        }
        e eZ = af.byr().eZ(v.NE(str));
        if (eZ != null) {
            return eZ.bAL();
        }
        return null;
    }

    public final n xd(int i) {
        n nVar = new n();
        Cursor b = this.diF.b("select *,rowid from SnsInfo  where SnsInfo.rowid=" + i, null, 2);
        if (b.moveToFirst()) {
            nVar.d(b);
            b.close();
            return nVar;
        }
        b.close();
        return null;
    }

    public final n Nl(String str) {
        if (v.Lr(str)) {
            return xd(v.NF(str));
        }
        e xa = af.byr().xa(v.NF(str));
        if (xa != null) {
            return xa.bAL();
        }
        return null;
    }

    /* renamed from: b */
    public final boolean a(long j, n nVar) {
        ContentValues wH = nVar.wH();
        wH.remove("rowid");
        if (this.diF.update("SnsInfo", wH, "snsId=?", new String[]{String.valueOf(j)}) > 0) {
            return true;
        }
        return false;
    }

    public final int b(int i, n nVar) {
        ContentValues wH = nVar.wH();
        wH.remove("rowid");
        return this.diF.update("SnsInfo", wH, "rowid=?", new String[]{String.valueOf(i)});
    }

    public final boolean delete(long j) {
        int delete = this.diF.delete("SnsInfo", "snsId=?", new String[]{String.valueOf(j)});
        x.d("MicroMsg.SnsInfoStorage", "del msg " + j + " res " + delete);
        if (delete > 0) {
            return true;
        }
        return false;
    }

    public final boolean xe(int i) {
        if (this.diF.delete("SnsInfo", "rowid=?", new String[]{String.valueOf(i)}) > 0) {
            return true;
        }
        return false;
    }

    public final int eC(long j) {
        n fi = af.byo().fi(j);
        return fi == null ? 0 : fi.bBq();
    }

    public final int Lx(String str) {
        n Nk = af.byo().Nk(str);
        return Nk == null ? 0 : Nk.bBq();
    }
}
