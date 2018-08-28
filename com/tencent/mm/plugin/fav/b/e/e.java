package com.tencent.mm.plugin.fav.b.e;

import android.database.Cursor;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.j;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e extends i<j> implements aa {
    private com.tencent.mm.sdk.e.e diF;

    public final /* synthetic */ boolean a(j jVar) {
        return super.b(jVar);
    }

    public final /* synthetic */ boolean a(j jVar, String[] strArr) {
        return super.c(jVar, strArr);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, j.dhO, "FavSearchInfo", null);
        this.diF = eVar;
    }

    public final ArrayList<Long> a(List<String> list, List<String> list2, List<Integer> list3) {
        Iterator it;
        String str;
        ArrayList<Long> arrayList = new ArrayList();
        String str2 = "select localId from FavSearchInfo";
        String str3 = " 1=1 ";
        if (!(list == null || list.isEmpty())) {
            it = list.iterator();
            while (true) {
                str = str3;
                if (!it.hasNext()) {
                    break;
                }
                str3 = str + " and content like '%" + ((String) it.next()) + "%'";
            }
            str3 = str;
        }
        if (!(list2 == null || list2.isEmpty())) {
            it = list2.iterator();
            while (true) {
                str = str3;
                if (!it.hasNext()) {
                    break;
                }
                str3 = str + " and tagContent like '%" + ((String) it.next()) + "%'";
            }
            str3 = str;
        }
        str3 = str2 + " where " + str3;
        if (!(list3 == null || list3.isEmpty())) {
            str3 = str3 + " and ((1=1 ";
            Iterator it2 = list3.iterator();
            while (true) {
                str = str3;
                if (!it2.hasNext()) {
                    break;
                }
                str3 = str + " and type = " + ((Integer) it2.next()).intValue();
            }
            str3 = str + ") or (1=1";
            it2 = list3.iterator();
            while (true) {
                str = str3;
                if (!it2.hasNext()) {
                    break;
                }
                str3 = str + " and subtype & " + j.pJ(((Integer) it2.next()).intValue()) + " != 0";
            }
            str3 = str + "))";
        }
        x.d("MicroMsg.FavSearchStorage", "search id sql {%s}", new Object[]{str3 + " order by time desc"});
        Cursor b = this.diF.b(str3, null, 2);
        if (b == null) {
            return arrayList;
        }
        while (b.moveToNext()) {
            arrayList.add(Long.valueOf(b.getLong(0)));
        }
        b.close();
        return arrayList;
    }

    public final boolean Bt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        int i;
        x.d("MicroMsg.FavSearchStorage", "is tag exist sql {%s}", new Object[]{"select count(localId) from FavSearchInfo where tagContent like '%" + str + "%'"});
        Cursor b = this.diF.b(r2, null, 2);
        if (b == null || !b.moveToFirst()) {
            i = 0;
        } else {
            i = b.getInt(0);
        }
        if (b != null) {
            b.close();
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    public final void dA(long j) {
        this.diF.fV("FavSearchInfo", "delete from FavSearchInfo where localId = " + j);
    }

    public final j dB(long j) {
        j jVar = null;
        Cursor b = this.diF.b("select * from FavSearchInfo where localId = " + j, null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                jVar = new j();
                jVar.d(b);
            }
            b.close();
        }
        return jVar;
    }
}
