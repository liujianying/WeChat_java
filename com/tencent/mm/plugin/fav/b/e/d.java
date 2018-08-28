package com.tencent.mm.plugin.fav.b.e;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.plugin.fav.a.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class d extends i<g> implements x {
    private static final String iXS = ("xml,edittime,ext,favProto,flag,fromUser,id,itemStatus,localId,localSeq,realChatName,sourceCreateTime,sourceId,sourceType,toUser,type" + ",updateSeq,updateTime,tagProto,sessionId,datatotalsize,rowid");
    private e diF;

    public d(e eVar) {
        super(eVar, g.dhO, "FavItemInfo", null);
        this.diF = eVar;
    }

    public final e aLz() {
        return this.diF;
    }

    public final g dy(long j) {
        if (this.diF == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Fav.FavItemInfoStorage", "getBtLocalId, but db is null, return");
            return null;
        }
        Cursor a = this.diF.a("FavItemInfo", null, "localId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            g gVar = new g();
            try {
                gVar.d(a);
                a.close();
                return gVar;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Fav.FavItemInfoStorage", "getByLocalId convertFrom(cu) cause IlleagalStateException, return null");
                a.close();
                return null;
            }
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByLocalId:%d, no data", new Object[]{Long.valueOf(j)});
        a.close();
        return null;
    }

    public final g dz(long j) {
        Cursor rawQuery = this.diF.rawQuery("Select * from FavItemInfo where id = " + j, null);
        if (rawQuery.getCount() != 0) {
            g gVar = new g();
            rawQuery.moveToFirst();
            try {
                gVar.d(rawQuery);
                rawQuery.close();
                return gVar;
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.Fav.FavItemInfoStorage", e, "", new Object[0]);
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Fav.FavItemInfoStorage", "getByFavId(%d),info.convertFrom error", new Object[]{Long.valueOf(j)});
                rawQuery.close();
                return null;
            }
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByFavId:%d, no data", new Object[]{Long.valueOf(j)});
        rawQuery.close();
        return null;
    }

    public final int aLA() {
        Cursor rawQuery = rawQuery("select count(*) from FavItemInfo where type = 2", new String[0]);
        if (rawQuery == null) {
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public final g Bs(String str) {
        Cursor a = this.diF.a("FavItemInfo", null, "sourceId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            g gVar = new g();
            gVar.d(a);
            a.close();
            return gVar;
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "klem getBySourceId:%s, no data", new Object[]{str});
        a.close();
        return null;
    }

    /* renamed from: y */
    public final boolean b(g gVar) {
        Assert.assertTrue(gVar.field_localId > 0);
        if (gVar.field_favProto.rBG != null) {
            wr wrVar = gVar.field_favProto.rBG;
            if (wrVar.bJt <= 0) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "insert::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_type), Integer.valueOf(wrVar.bJt)});
                wrVar.CO(1);
            } else {
                wrVar.CO(wrVar.bJt);
            }
        }
        b.a(gVar);
        boolean a = a(gVar, false);
        if (a) {
            b(gVar.field_localId, 2, Long.valueOf(gVar.field_localId));
        }
        return a;
    }

    /* renamed from: a */
    public final boolean c(g gVar, String... strArr) {
        if (gVar.field_favProto.rBG != null) {
            wr wrVar = gVar.field_favProto.rBG;
            if (wrVar.bJt <= 0) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_type), Integer.valueOf(wrVar.bJt)});
                wrVar.CO(1);
            } else {
                wrVar.CO(wrVar.bJt);
            }
        }
        b.a(gVar);
        boolean b = super.b(gVar, false, strArr);
        if (b) {
            b(gVar.field_localId, 3, Long.valueOf(gVar.field_localId));
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Fav.FavItemInfoStorage", "update result[%B]", new Object[]{Boolean.valueOf(b)});
        return b;
    }

    public final boolean r(long j, int i) {
        String str = "select count(updateTime) from FavItemInfo where updateTime < " + j;
        if (i != -1) {
            str = str + " and type = " + i;
        }
        Cursor b = this.diF.b(str, null, 2);
        if (b == null) {
            return true;
        }
        b.moveToFirst();
        if (b.getInt(0) == 0) {
            b.close();
            return true;
        }
        b.close();
        return false;
    }

    public final long s(long j, int i) {
        String str;
        long j2;
        if (this.diF == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Fav.FavItemInfoStorage", "getNextUpdateTime, but db is null, return");
            return 0;
        } else if (j == 0) {
            str = "select updateTime from FavItemInfo where itemStatus > 0";
            if (i != -1) {
                str = str + " and type = " + i;
            }
            Cursor rawQuery = this.diF.rawQuery(str + " order by updateTime desc limit 20", null);
            if (rawQuery == null) {
                return 0;
            }
            if (rawQuery.getCount() == 0) {
                rawQuery.close();
                return 0;
            }
            rawQuery.moveToLast();
            j2 = rawQuery.getLong(0);
            rawQuery.close();
            return j2;
        } else {
            str = "select updateTime from FavItemInfo where updateTime < " + j;
            if (i != -1) {
                str = str + " and type = " + i;
            }
            Cursor rawQuery2 = this.diF.rawQuery((str + " and itemStatus > 0") + " order by updateTime desc limit 20", null);
            if (rawQuery2 == null || rawQuery2.getCount() <= 0) {
                j2 = j;
            } else {
                rawQuery2.moveToLast();
                j2 = rawQuery2.getLong(0);
            }
            if (rawQuery2 == null) {
                return j2;
            }
            rawQuery2.close();
            return j2;
        }
    }

    public final List<g> a(int i, Set<Integer> set, w wVar) {
        if (set == null || !set.contains(Integer.valueOf(i))) {
            String str;
            List<g> arrayList = new ArrayList();
            String str2 = "select " + iXS + " from FavItemInfo where itemStatus > 0";
            if (i != -1) {
                str = str2 + " and type = " + i;
            } else if (set != null) {
                Iterator it = set.iterator();
                while (true) {
                    str = str2;
                    if (!it.hasNext()) {
                        break;
                    }
                    str2 = str + " and type != " + ((Integer) it.next()).intValue();
                }
            } else {
                str = str2;
            }
            Cursor b = this.diF.b(str + " order by updateTime desc limit 20", null, 2);
            if (b == null) {
                return arrayList;
            }
            while (b.moveToNext()) {
                g gVar = new g();
                gVar.d(b);
                if (wVar == null || !wVar.t(gVar)) {
                    arrayList.add(gVar);
                } else {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[]{Integer.valueOf(gVar.field_id), Integer.valueOf(gVar.field_type)});
                }
            }
            b.close();
            return arrayList;
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "getFirstPageList::block set contains target type, error, do return null");
        return null;
    }

    public final LinkedList<Integer> t(long j, int i) {
        LinkedList<Integer> linkedList = new LinkedList();
        String str = "select id from FavItemInfo where updateTime >= " + j;
        if (i != -1) {
            str = str + " and type = " + i;
        }
        Cursor b = this.diF.b((str + " and updateSeq > localSeq") + " order by updateTime desc", null, 2);
        if (b == null) {
            return linkedList;
        }
        while (b.moveToNext()) {
            linkedList.add(Integer.valueOf(b.getInt(0)));
        }
        b.close();
        return linkedList;
    }

    public final long u(long j, int i) {
        String str;
        Cursor rawQuery;
        long j2;
        if (this.diF == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Fav.FavItemInfoStorage", "getMinBatchGetUpdateTime, but db is null, return");
            return 0;
        } else if (j == 0) {
            str = "select updateTime from (select * from FavItemInfo";
            if (i != -1) {
                str = str + " where type = " + i;
            }
            rawQuery = this.diF.rawQuery((str + " order by updateTime desc limit 20") + ") where updateSeq > localSeq", null);
            if (rawQuery == null) {
                return 0;
            }
            if (rawQuery.getCount() == 0) {
                rawQuery.close();
                return 0;
            }
            rawQuery.moveToLast();
            j2 = rawQuery.getLong(0);
            rawQuery.close();
            return j2;
        } else {
            str = "select updateTime from (select * from FavItemInfo where updateTime < " + j;
            if (i != -1) {
                str = str + " and type = " + i;
            }
            rawQuery = this.diF.rawQuery((str + " order by updateTime desc limit 20") + ") where updateSeq > localSeq", null);
            if (rawQuery == null) {
                return 0;
            }
            if (rawQuery.getCount() == 0) {
                rawQuery.close();
                return 0;
            }
            rawQuery.moveToLast();
            j2 = rawQuery.getLong(0);
            rawQuery.close();
            return j2;
        }
    }

    public final List<g> b(long j, int i, Set<Integer> set, w wVar) {
        if (set == null || !set.contains(Integer.valueOf(i))) {
            String str;
            List<g> arrayList = new ArrayList();
            String str2 = "select " + iXS + " from FavItemInfo where updateTime >= " + j;
            if (i != -1) {
                str = str2 + " and type = " + i;
            } else if (set != null) {
                Iterator it = set.iterator();
                while (true) {
                    str = str2;
                    if (!it.hasNext()) {
                        break;
                    }
                    str2 = str + " and type != " + ((Integer) it.next()).intValue();
                }
            } else {
                str = str2;
            }
            Cursor b = this.diF.b((str + " and itemStatus > 0") + " order by updateTime desc", null, 2);
            if (b == null) {
                return arrayList;
            }
            while (b.moveToNext()) {
                g gVar = new g();
                try {
                    gVar.d(b);
                    if (wVar == null || !wVar.t(gVar)) {
                        arrayList.add(gVar);
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Fav.FavItemInfoStorage", "fav getlist convertfrom (cu) error,continue");
                }
            }
            b.close();
            return arrayList;
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "getList::block set contains target type, error, do return null");
        return null;
    }

    public final List<g> aLB() {
        List<g> list = null;
        Cursor rawQuery = this.diF.rawQuery("select " + iXS + " from FavItemInfo where itemStatus=3", null);
        if (rawQuery != null) {
            if (rawQuery.getCount() == 0) {
                rawQuery.close();
            } else {
                list = new LinkedList();
                while (rawQuery.moveToNext()) {
                    g gVar = new g();
                    gVar.d(rawQuery);
                    list.add(gVar);
                }
                rawQuery.close();
            }
        }
        return list;
    }

    public final List<g> aLC() {
        List<g> list = null;
        Cursor b = this.diF.b("select " + iXS + " from FavItemInfo where itemStatus=1", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                list = new LinkedList();
                do {
                    g gVar = new g();
                    gVar.d(b);
                    list.add(gVar);
                } while (b.moveToNext());
            }
            b.close();
        }
        return list;
    }

    public final void t(int i, long j) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Fav.FavItemInfoStorage", "setStatus status:%d,localId:%d", new Object[]{Integer.valueOf(i), Long.valueOf(j)});
        this.diF.fV("FavItemInfo", "update FavItemInfo set itemStatus = " + i + " where localId = " + j);
        Xp(String.valueOf(j));
    }

    public final void z(g gVar) {
        String str = "delete from FavItemInfo where localId = " + gVar.field_localId;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavItemInfoStorage", "delete sql: " + str);
        this.diF.fV("FavItemInfo", str);
        b(gVar.field_localId, 5, Long.valueOf(gVar.field_localId));
    }

    public final List<g> aLD() {
        List<g> list = null;
        Cursor b = this.diF.b("select " + iXS + " from FavItemInfo where (itemStatus=9 or itemStatus=12)", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                list = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.d(b);
                    list.add(gVar);
                } while (b.moveToNext());
            }
            b.close();
        }
        return list;
    }

    public final List<g> aLE() {
        List<g> list = null;
        Cursor b = this.diF.b("select " + iXS + " from FavItemInfo where itemStatus=17", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                list = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.d(b);
                    list.add(gVar);
                } while (b.moveToNext());
            }
            b.close();
        }
        return list;
    }

    public final List<g> aLF() {
        List<g> list = null;
        Cursor b = this.diF.b("select " + iXS + " from FavItemInfo where itemStatus=3 or itemStatus=6 or itemStatus=11 or itemStatus=14 or itemStatus=16 or itemStatus=18", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                list = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.d(b);
                    list.add(gVar);
                } while (b.moveToNext());
            }
            b.close();
        }
        return list;
    }

    public final ArrayList<g> a(List<Long> list, List<g> list2, Set<Integer> set, w wVar) {
        if (list == null || list.size() == 0 || list.size() > 20) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ").append(iXS).append(" from FavItemInfo where ");
        if (set != null && set.size() > 0) {
            stringBuffer.append("( 1=1");
            for (Integer append : set) {
                stringBuffer.append(" and type != ").append(append);
            }
            stringBuffer.append(") and ");
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                stringBuffer.append("( ");
            }
            if (i == size - 1) {
                stringBuffer.append("localId = ").append(list.get(i)).append(" )");
            } else {
                stringBuffer.append("localId = ").append(list.get(i)).append(" or ");
            }
        }
        stringBuffer.append(" order by updateTime desc");
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Fav.FavItemInfoStorage", "get list by id list sql %s", new Object[]{stringBuffer.toString()});
        Cursor b = this.diF.b(r0, null, 2);
        if (b == null) {
            return null;
        }
        ArrayList<g> arrayList;
        if (b.moveToFirst()) {
            ArrayList<g> arrayList2 = new ArrayList();
            do {
                g gVar;
                if (list2 == null || list2.isEmpty()) {
                    gVar = new g();
                } else {
                    gVar = (g) list2.remove(0);
                }
                gVar.d(b);
                if (wVar == null || !wVar.t(gVar)) {
                    arrayList2.add(gVar);
                } else {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[]{Integer.valueOf(gVar.field_id), Integer.valueOf(gVar.field_type)});
                }
            } while (b.moveToNext());
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        b.close();
        return arrayList;
    }

    public final boolean b(g gVar, String... strArr) {
        if (gVar.field_favProto.rBG != null) {
            wr wrVar = gVar.field_favProto.rBG;
            if (wrVar.bJt <= 0) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_type), Integer.valueOf(wrVar.bJt)});
                wrVar.CO(1);
            } else {
                wrVar.CO(wrVar.bJt);
            }
        }
        return super.b(gVar, false, strArr);
    }

    public final List<g> aLG() {
        List<g> list = null;
        Cursor b = this.diF.b("select " + iXS + " from FavItemInfo where flag =  -1 and itemStatus = 0 ", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                list = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.d(b);
                    list.add(gVar);
                } while (b.moveToNext());
            }
            b.close();
        }
        return list;
    }

    public final List<Long> aLH() {
        long currentTimeMillis = System.currentTimeMillis();
        List<Long> arrayList = new ArrayList();
        String str = "select localId from FavItemInfo where ";
        String str2 = "";
        for (int i : a.iVp) {
            str2 = str2 + i + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        str = (str + " itemStatus in (" + str2 + ")") + " and datatotalsize > 0 ";
        str2 = "";
        for (int i2 : a.iVo) {
            str2 = str2 + i2 + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        Cursor rawQuery = this.diF.rawQuery((str + " and type in (" + str2 + ")") + " order by datatotalsize desc", null);
        if (rawQuery == null) {
            return arrayList;
        }
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return arrayList;
        }
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        long currentTimeMillis2 = System.currentTimeMillis();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavItemInfoStorage", "getCleanList cu.getCount() = %d,used %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
        return arrayList;
    }

    public final void aLI() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength");
        String str = "select " + iXS + " from FavItemInfo where ";
        String str2 = "";
        for (int i : a.iVp) {
            str2 = str2 + i + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        str = str + "itemStatus in (" + str2 + ")";
        str2 = "";
        for (int i2 : a.iVo) {
            str2 = str2 + i2 + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        Cursor rawQuery = this.diF.rawQuery(str + " and type in (" + str2 + ")", null);
        if (rawQuery == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu = null");
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = 0");
        } else {
            long dO;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = " + rawQuery.getCount());
            if (this.diF instanceof h) {
                dO = ((h) this.diF).dO(Thread.currentThread().getId());
            } else {
                dO = 0;
            }
            while (rawQuery.moveToNext()) {
                g gVar = new g();
                gVar.d(rawQuery);
                if (pM(gVar.field_itemStatus)) {
                    long j;
                    if (gVar.field_favProto != null) {
                        Iterator it = gVar.field_favProto.rBI.iterator();
                        j = 0;
                        while (it.hasNext()) {
                            j = ((vx) it.next()).rzJ + j;
                        }
                    } else {
                        j = 0;
                    }
                    gVar.field_datatotalsize = j;
                    c(gVar, "localId");
                }
            }
            if (this.diF instanceof h) {
                ((h) this.diF).gp(dO);
            }
            rawQuery.close();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength end");
        }
    }

    private static boolean pM(int i) {
        for (int i2 : a.iVp) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public final List<Long> aLJ() {
        List arrayList = new ArrayList();
        Cursor b = this.diF.b("select localId from FavItemInfo" + " order by updateTime desc", null, 2);
        if (b != null) {
            if (b.getCount() == 0) {
                b.close();
            } else {
                while (b.moveToNext()) {
                    arrayList.add(Long.valueOf(b.getLong(0)));
                }
                b.close();
            }
        }
        return arrayList;
    }

    public final int pL(int i) {
        try {
            Cursor b = this.diF.b("select count(*) from FavItemInfo where id>" + i, null, 2);
            if (b == null) {
                return -1;
            }
            if (b.getCount() == 0) {
                b.close();
                return -1;
            }
            b.moveToNext();
            int i2 = b.getInt(0);
            b.close();
            return i2;
        } catch (Throwable th) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "getFavHomePosition failed with throwable: " + th.getMessage());
            return -1;
        }
    }
}
