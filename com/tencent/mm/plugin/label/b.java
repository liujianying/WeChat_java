package com.tencent.mm.plugin.label;

import com.tencent.mm.ab.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.protocal.c.bxe;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class b implements com.tencent.mm.plugin.label.a.b {
    ArrayList<String> kAx;
    ArrayList<String> kAy;
    private e kAz = new 1(this);
    String username;

    public final /* synthetic */ List FC(String str) {
        if (bi.oW(str)) {
            x.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[getLabelStrList]");
            return null;
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        return e.aYJ().H(str.split(","));
    }

    public final /* synthetic */ List FD(String str) {
        return e.aYJ().XW(str);
    }

    public final /* synthetic */ List aYH() {
        return e.aYJ().cld();
    }

    public final void aYE() {
        e.aYJ().aYE();
    }

    public final String Fz(String str) {
        return e.aYJ().Fz(str);
    }

    public final String FA(String str) {
        return e.aYJ().FA(str);
    }

    public final void a(a aVar) {
        e.aYJ().c(aVar);
    }

    public final void b(a aVar) {
        e.aYJ().d(aVar);
    }

    public final List<String> aYF() {
        ag aYJ = e.aYJ();
        long VF = bi.VF();
        ArrayList cle = aYJ.cle();
        if (cle == null) {
            return null;
        }
        aYJ.clf();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cle.size(); i++) {
            ArrayList arrayList2 = (ArrayList) aYJ.tal.get(Integer.valueOf(((ad) cle.get(i)).field_labelID));
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList.add(((ad) cle.get(i)).field_labelName);
            }
        }
        x.i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", new Object[]{Long.valueOf(bi.bH(VF)), Integer.valueOf(cle.size()), Integer.valueOf(arrayList.size()), bi.cjd()});
        return arrayList;
    }

    public final List<String> FB(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.Label.ContactLabelManagerImpl", "labels is null.");
            return null;
        }
        String[] split = str.split(",");
        if (split == null || split.length <= 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(split));
        return arrayList;
    }

    public final String bo(List<String> list) {
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.Label.ContactLabelManagerImpl", "labelList is empty");
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append((String) list.get(i));
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    public final synchronized void dw(String str, String str2) {
        x.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] user:%s labels:%s", new Object[]{str, str2});
        if (bi.oW(str2)) {
            x.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labels is null.");
        } else {
            ArrayList arrayList = (ArrayList) FB(str2);
            if (arrayList == null || arrayList.isEmpty()) {
                x.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
            } else {
                this.username = str;
                this.kAx = arrayList;
                int size = arrayList.size();
                this.kAy = new ArrayList();
                for (int i = 0; i < size; i++) {
                    ad XX = e.aYJ().XX((String) arrayList.get(i));
                    if (XX != null && XX.field_isTemporary) {
                        this.kAy.add(arrayList.get(i));
                    }
                }
                au.DF().a(635, this.kAz);
                au.DF().a(638, this.kAz);
                if (this.kAy == null || this.kAy.isEmpty()) {
                    g(str, arrayList);
                    aYG();
                } else {
                    x.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", new Object[]{this.kAy.toString()});
                    au.DF().a(new com.tencent.mm.plugin.label.b.a(this.kAy), 0);
                }
            }
        }
    }

    final void aYG() {
        this.username = null;
        this.kAx = null;
        this.kAy = null;
        au.DF().b(635, this.kAz);
        au.DF().b(638, this.kAz);
    }

    static void g(String str, ArrayList<String> arrayList) {
        String str2 = "MicroMsg.Label.ContactLabelManagerImpl";
        String str3 = "cpan[saveContact] username:%s,list:%s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = arrayList == null ? "" : arrayList.toString();
        x.d(str2, str3, objArr);
        if (bi.oW(str) || arrayList == null || arrayList.size() <= 0) {
            x.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact label faild.");
            return;
        }
        String str4 = "";
        if (arrayList != null && arrayList.size() > 0) {
            str4 = c.bq(e.aYJ().ab(arrayList));
        }
        LinkedList linkedList = new LinkedList();
        bxe bxe = new bxe();
        bxe.rvl = str4;
        bxe.hbL = str;
        linkedList.add(bxe);
        au.DF().a(new d(linkedList), 0);
    }

    public final void bp(List<String> list) {
        au.DF().a(new com.tencent.mm.plugin.label.b.a((List) list), 0);
    }

    public final void g(List<String> list, List<String> list2) {
        String str;
        String str2;
        Map hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        if (list.size() > 0) {
            Iterator it = list2.iterator();
            for (String str22 : list) {
                List<String> F = bi.F(((String) it.next()).split(","));
                if (F != null && F.size() > 0) {
                    for (String str3 : F) {
                        String str4;
                        String dx;
                        if (hashMap.containsKey(str3)) {
                            str4 = (String) hashMap.get(str3);
                            dx = c.dx(str4, str22);
                            if (!dx.equalsIgnoreCase(str4)) {
                                hashMap.put(str3, dx);
                            }
                        } else {
                            au.HU();
                            ab Yg = c.FR().Yg(str3);
                            if (Yg != null) {
                                str4 = Yg.field_contactLabelIds;
                                dx = c.dx(str4, str22);
                                if (!dx.equalsIgnoreCase(str4)) {
                                    hashMap.put(str3, dx);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            str3 = (String) entry.getKey();
            str22 = (String) entry.getValue();
            bxe bxe = new bxe();
            bxe.hbL = str3;
            bxe.rvl = str22;
            linkedList.add(bxe);
        }
        if (linkedList.size() > 0) {
            au.DF().a(new d(linkedList), 0);
        }
    }
}
