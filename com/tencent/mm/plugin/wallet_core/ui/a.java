package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.bk.b;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class a {
    public f psv = null;
    Map<String, q> psw = null;
    Map<String, h> psx = null;

    public a(f fVar) {
        Assert.assertNotNull(fVar);
        this.psv = fVar;
        Wj();
    }

    private void Wj() {
        int i = 0;
        this.psw = new HashMap();
        List list = this.psv.pdZ;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                q qVar = (q) list.get(i2);
                this.psw.put(qVar.pdS, qVar);
            }
        } else {
            x.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
        }
        this.psx = new HashMap();
        if (this.psv.pea == null || this.psv.pea.pek == null) {
            x.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
            return;
        }
        List list2 = this.psv.pea.pek;
        while (i < list2.size()) {
            h hVar = (h) list2.get(i);
            this.psx.put(hVar.pem, hVar);
            i++;
        }
    }

    public final Map<String, a> Pl(String str) {
        return ba(str, false);
    }

    public final h aZ(String str, boolean z) {
        if (!"0".equals(str) && this.psx.containsKey(str)) {
            return (h) this.psx.get(str);
        }
        for (String str2 : this.psx.keySet()) {
            h hVar = (h) this.psx.get(str2);
            if (!(hVar.peo == null || hVar.peo.size() == 0)) {
                int i;
                int size = hVar.peo.size();
                int i2 = 0;
                Iterator it = hVar.peo.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    e eVar = (e) it.next();
                    if (!this.psw.containsKey(eVar.pdS)) {
                        break;
                    }
                    q qVar = (q) this.psw.get(eVar.pdS);
                    if (qVar.peR.equals("") && qVar.peT.size() == 0 && (!z || qVar.peQ == 0)) {
                        i++;
                    }
                    i2 = i;
                }
                if (i > 0 && i == size) {
                    return hVar;
                }
            }
        }
        return null;
    }

    public final Map<String, a> ba(String str, boolean z) {
        Map<String, a> hashMap = new HashMap();
        if (this.psv.pea != null && this.psv.pea.pek != null) {
            double d;
            List list = this.psv.pea.pek;
            if (this.psx.containsKey(str)) {
                d = ((h) this.psx.get(str)).pen;
            } else {
                d = 0.0d;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                h hVar = (h) list.get(i2);
                String str2 = null;
                if (str.equals("0") && !hVar.equals("0")) {
                    str2 = hVar.pem;
                } else if (hVar.pem.startsWith(str) && !str.equals(hVar.pem)) {
                    str2 = hVar.pem.replace(str + "-", "");
                }
                String[] Po = Po(str2);
                if (Po != null && Po.length > 0) {
                    q qVar = (q) this.psw.get(Po[0]);
                    if (qVar != null) {
                        if ((qVar.peQ != 0 ? 1 : null) != null && !bi.oW(qVar.peR) && qVar.peT.size() <= 0 && (z || !qVar.peR.equalsIgnoreCase("CFT"))) {
                            a aVar = (a) hashMap.get(qVar.peR);
                            if (aVar == null || hVar.pen > aVar.psy.pen) {
                                aVar = new a();
                                aVar.psy = hVar;
                                aVar.lNT = qVar.lNT;
                                aVar.psz = hVar.pen - d;
                                aVar.psA = qVar.peR;
                                hashMap.put(qVar.peR, aVar);
                            }
                        }
                    }
                }
                i = i2 + 1;
            }
        } else {
            x.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
        }
        return hashMap;
    }

    public final List<q> Pm(String str) {
        List<q> linkedList = new LinkedList();
        if (this.psv.pdZ != null) {
            Map Pl = Pl(str);
            for (int i = 0; i < this.psv.pdZ.size(); i++) {
                q qVar = (q) this.psv.pdZ.get(i);
                if (qVar != null) {
                    Object obj;
                    if (qVar.peQ != 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null && Pl.containsKey(qVar.peR)) {
                        linkedList.add(qVar);
                    }
                }
            }
        } else {
            x.w("MicroMsg.FavorLogicHelper", "fucn[getBankFavorListWithSelectedCompId] mFavorInfo.tradeFavList null");
        }
        return linkedList;
    }

    public final h Pn(String str) {
        return (h) this.psx.get(str);
    }

    public static String[] Po(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return str.split("-");
    }

    public final String Pp(String str) {
        return bb(str, false);
    }

    public final String bb(String str, boolean z) {
        String[] Po = Po(str);
        if (Po == null) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Po.length; i++) {
            q qVar = (q) this.psw.get(Po[i]);
            if (qVar != null) {
                Object obj;
                if (qVar.peQ != 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null || (bi.oW(qVar.peR) && !z)) {
                    stringBuilder.append(Po[i]);
                    stringBuilder.append("-");
                }
            }
        }
        if (stringBuilder.length() == 0) {
            return "0";
        }
        return stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString();
    }

    public final FavorPayInfo Pq(String str) {
        FavorPayInfo favorPayInfo = new FavorPayInfo();
        if (this.psx.get(str) == null) {
            favorPayInfo.pnP = "0";
            if (this.psv != null) {
                favorPayInfo.pnS = this.psv.pdY;
            }
            favorPayInfo.pnQ = 0;
            return favorPayInfo;
        }
        favorPayInfo.pnP = str;
        if (this.psv != null) {
            favorPayInfo.pnS = this.psv.pdY;
        }
        favorPayInfo.pnQ = 0;
        String[] Po = Po(str);
        if (Po == null) {
            return favorPayInfo;
        }
        for (int length = Po.length - 1; length >= 0; length--) {
            q qVar = (q) this.psw.get(Po[length]);
            if (qVar != null) {
                if ((qVar.peQ != 0 ? 1 : 0) == 0) {
                    break;
                }
                favorPayInfo.pnQ = 1;
                if (qVar.peT != null && qVar.peT.size() > 0) {
                    favorPayInfo.pnU = new LinkedList();
                    Iterator it = qVar.peT.iterator();
                    while (it.hasNext()) {
                        favorPayInfo.pnU.add(ab.a((b) it.next()));
                    }
                }
                if (!bi.oW(qVar.peR)) {
                    favorPayInfo.pnR = qVar.peR;
                    break;
                }
            }
        }
        return favorPayInfo;
    }

    public static boolean a(FavorPayInfo favorPayInfo, Bankcard bankcard) {
        if (bankcard == null) {
            x.w("MicroMsg.FavorLogicHelper", "curBankcard null");
            return true;
        }
        if (!(favorPayInfo == null || bi.oW(favorPayInfo.pnP))) {
            boolean z;
            if (favorPayInfo.pnQ != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && !bi.oW(favorPayInfo.pnR) && favorPayInfo.pnU != null && favorPayInfo.pnU.contains(bankcard.field_bindSerial)) {
                return false;
            }
        }
        if (favorPayInfo.pnQ != 0) {
            if (!bi.oW(favorPayInfo.pnR) && bankcard.field_bankcardType != null && !bankcard.field_bankcardType.equals(favorPayInfo.pnR)) {
                return true;
            }
            if (bi.oW(favorPayInfo.pnR) && bankcard.field_bankcardType.equals("CFT")) {
                return true;
            }
        }
        return false;
    }

    private static String cH(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return stringBuilder.toString();
            }
            stringBuilder.append(((String) list.get(i2)));
            if (i2 < list.size() - 1) {
                stringBuilder.append("-");
            }
            i = i2 + 1;
        }
    }

    public final String Pr(String str) {
        int i;
        ArrayList jl = o.bOW().jl(true);
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (i = 0; i < jl.size(); i++) {
            hashMap.put(((Bankcard) jl.get(i)).field_bankcardType, Integer.valueOf(0));
        }
        String[] Po = Po(str);
        if (Po != null) {
            for (Object obj : Po) {
                q qVar = (q) this.psw.get(obj);
                if (qVar != null) {
                    boolean z;
                    if (qVar.peQ != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (hashMap.containsKey(qVar.peR) || bi.oW(qVar.peR)) {
                            arrayList.add(obj);
                        } else {
                        }
                    }
                }
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 0) {
            return "0";
        }
        return cH(arrayList);
    }

    public final List<q> bPV() {
        int i;
        ArrayList jl = o.bOW().jl(true);
        Map hashMap = new HashMap();
        for (i = 0; i < jl.size(); i++) {
            hashMap.put(((Bankcard) jl.get(i)).field_bankcardType, Integer.valueOf(0));
        }
        List<q> linkedList = new LinkedList();
        List list = this.psv.pdZ;
        if (list != null) {
            for (i = 0; i < list.size(); i++) {
                q qVar = (q) list.get(i);
                if (qVar != null) {
                    boolean z;
                    if (qVar.peQ != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (hashMap.containsKey(qVar.peR) || bi.oW(qVar.peR)) {
                            linkedList.add(qVar);
                        } else {
                        }
                    }
                }
                linkedList.add(qVar);
            }
        }
        return linkedList;
    }
}
