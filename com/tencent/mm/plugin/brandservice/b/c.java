package com.tencent.mm.plugin.brandservice.b;

import android.database.Cursor;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.s;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c implements e {
    public LinkedList<a> hnI = new LinkedList();
    public boolean hnJ = false;
    public List<ix> hnK = new LinkedList();
    public List<ix> hnL = new LinkedList();

    public c() {
        g.DF().a(387, this);
        g.DF().a(new e(), 0);
    }

    public final void init() {
        long currentTimeMillis = System.currentTimeMillis();
        this.hnK.clear();
        this.hnL.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select bizinfo.brandIconURL");
        stringBuilder.append(", bizinfo.type");
        stringBuilder.append(", bizinfo.status");
        stringBuilder.append(", rcontact.username");
        stringBuilder.append(", rcontact.conRemark");
        stringBuilder.append(", rcontact.nickname");
        stringBuilder.append(", rcontact.alias");
        stringBuilder.append(", rcontact.conRemarkPYFull");
        stringBuilder.append(", rcontact.conRemarkPYShort");
        stringBuilder.append(", rcontact.showHead");
        stringBuilder.append(", rcontact.pyInitial");
        stringBuilder.append(", rcontact.quanPin");
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where rcontact.username = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag & ").append(ab.ckY()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type & 1) != 0 ");
        stringBuilder.append(" order by showHead asc, ");
        stringBuilder.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuilder.append(" else upper(quanPin) end asc, ");
        stringBuilder.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuilder.append(" else upper(quanPin) end asc, ");
        stringBuilder.append(" upper(quanPin) asc, ");
        stringBuilder.append(" upper(nickname) asc");
        x.d("MicroMsg.BrandService.BrandServiceMgr", "sql %s", new Object[]{stringBuilder.toString()});
        g.Ek();
        Cursor b = g.Ei().dqq.b(r0, null, 2);
        Map hashMap = new HashMap();
        if (b != null) {
            int i = 0;
            while (b.moveToNext()) {
                i++;
                ab abVar = new ab();
                abVar.d(b);
                d dVar = new d();
                dVar.d(b);
                if (!abVar.field_username.equals("gh_43f2581f6fd6")) {
                    ix ixVar = new ix();
                    ixVar.userName = abVar.field_username;
                    ixVar.guS = abVar;
                    ixVar.lUs = dVar;
                    if (!s.hr(ixVar.userName)) {
                        hashMap.put(ixVar.userName, ixVar);
                        if (ixVar.lUs.field_type != 3) {
                            if (ixVar.lUs.field_type == 2) {
                                this.hnK.add(ixVar);
                            } else if (ixVar.lUs.field_type == 1 || ixVar.lUs.field_type == 0) {
                                this.hnL.add(ixVar);
                            }
                        }
                    }
                }
            }
            x.d("MicroMsg.BrandService.BrandServiceMgr", "biz contact count %d", new Object[]{Integer.valueOf(i)});
            b.close();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        stringBuilder = new StringBuilder();
        stringBuilder.append("select username");
        stringBuilder.append(" from rcontact");
        stringBuilder.append(" where (verifyFlag & ").append(ab.ckY()).append(") != 0 ");
        stringBuilder.append(" and (type & 1) != 0 ");
        x.d("MicroMsg.BrandService.BrandServiceMgr", "sql check %s", new Object[]{stringBuilder.toString()});
        g.Ek();
        Cursor b2 = g.Ei().dqq.b(r0, null, 0);
        if (b2 != null) {
            ArrayList arrayList = new ArrayList();
            while (b2.moveToNext()) {
                String string = b2.getString(0);
                if (!hashMap.containsKey(string)) {
                    arrayList.add(string);
                }
            }
            b2.close();
            x.i("MicroMsg.BrandService.BrandServiceMgr", "need update list size is %d, {%s}", new Object[]{Integer.valueOf(arrayList.size()), arrayList});
            if (!arrayList.isEmpty()) {
                g.Ek();
                long dO = g.Ei().dqq.dO(Thread.currentThread().getId());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    a.dBr.R((String) it.next(), "");
                }
                g.Ek();
                g.Ei().dqq.gp(dO);
            }
        }
        x.d("MicroMsg.BrandService.BrandServiceMgr", "check use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        x.d("MicroMsg.BrandService.BrandServiceMgr", "service add subscribe count:%d, enterpriseFather count:%d", new Object[]{Integer.valueOf(this.hnL.size()), Integer.valueOf(this.hnK.size())});
        x.d("MicroMsg.BrandService.BrandServiceMgr", "init time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void a(int i, int i2, String str, l lVar) {
        int i3 = 0;
        x.w("MicroMsg.BrandService.BrandServiceMgr", "on scene end code(%d, %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0 && lVar.getType() == 387) {
            LinkedList linkedList = ((e) lVar).hnM;
            if (linkedList == null) {
                x.e("MicroMsg.BrandService.BrandServiceMgr", "nameList is null.");
            } else if (this.hnK == null || this.hnL == null) {
                x.e("MicroMsg.BrandService.BrandServiceMgr", "enterpriseItemList or subscribeAndServiceItemList is null.");
            } else {
                int i4;
                if (linkedList.size() != this.hnK.size() + this.hnL.size()) {
                    i4 = 1;
                } else {
                    for (ix ixVar : this.hnK) {
                        if (ixVar != null) {
                            if (!linkedList.contains(ixVar.userName)) {
                            }
                        }
                        i3 = 1;
                    }
                    if (i3 == 0) {
                        for (ix ixVar2 : this.hnL) {
                            if (ixVar2 != null) {
                                if (!linkedList.contains(ixVar2.userName)) {
                                }
                            }
                            i4 = 1;
                        }
                    }
                    i4 = i3;
                }
                if (i4 != 0) {
                    init();
                    Iterator it = this.hnI.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).auM();
                    }
                }
            }
        }
    }
}
