package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ac.a.a.a;
import com.tencent.mm.protocal.c.aih;
import com.tencent.mm.protocal.c.aru;
import com.tencent.mm.protocal.c.arv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ap implements e, t {
    private static ap qAS;
    public String lang;
    public boolean qAT = false;
    public boolean qAU = false;
    private List<String> qAV = new LinkedList();
    public long qAW;
    private final int qAX = 20;
    public int qAY = 0;
    public long qAZ;

    private ap() {
    }

    public static ap ccb() {
        if (qAS == null) {
            qAS = new ap();
        }
        return qAS;
    }

    public final void a(int i, int i2, String str, x xVar) {
        if (g.Eg().Dx()) {
            this.qAT = false;
            x.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (xVar == null) {
                x.e("MicroMsg.SuggestionAppListLogic", "scene == null");
            } else if (i == 0 && i2 == 0) {
                switch (xVar.getType()) {
                    case 4:
                        x.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", new Object[]{Integer.valueOf(((aih) ((ah) xVar).ivx.dIE.dIL).rLe)});
                        LinkedList linkedList = r13.qAr;
                        if (linkedList == null || linkedList.size() <= 0) {
                            x.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
                            return;
                        } else if (ad.getContext() == null || a.bmm() == null) {
                            x.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
                            return;
                        } else {
                            f fVar;
                            LinkedList linkedList2 = new LinkedList();
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                fVar = (f) it.next();
                                String str2 = "MicroMsg.SuggestionAppListLogic";
                                String str3 = "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]";
                                Object[] objArr = new Object[5];
                                objArr[0] = fVar.field_appName;
                                objArr[1] = fVar.field_packageName;
                                objArr[2] = fVar.field_signature;
                                objArr[3] = fVar.cmM;
                                objArr[4] = Boolean.valueOf(fVar.cmL != null);
                                x.d(str2, str3, objArr);
                                linkedList2.add(fVar.field_appId);
                            }
                            a.bmm().X(linkedList2);
                            List<f> eR = g.eR(ad.getContext());
                            if (eR.size() > 0) {
                                i bmk = a.bmm().bmk();
                                for (f fVar2 : eR) {
                                    if (fVar2.field_appId != null) {
                                        Object obj;
                                        Iterator it2 = linkedList.iterator();
                                        while (it2.hasNext()) {
                                            fVar = (f) it2.next();
                                            if (fVar.field_appId != null && fVar2.field_appId.equals(fVar.field_appId)) {
                                                obj = 1;
                                                if (obj != null) {
                                                    if (g.a(ad.getContext(), fVar2)) {
                                                        fVar2.field_status = 1;
                                                    } else {
                                                        fVar2.field_status = 4;
                                                    }
                                                    bmk.a(fVar2, new String[0]);
                                                }
                                            }
                                        }
                                        obj = null;
                                        if (obj != null) {
                                            if (g.a(ad.getContext(), fVar2)) {
                                                fVar2.field_status = 1;
                                            } else {
                                                fVar2.field_status = 4;
                                            }
                                            bmk.a(fVar2, new String[0]);
                                        }
                                    }
                                }
                            }
                            g.Ek();
                            g.Ei().DT().setLong(352275, System.currentTimeMillis());
                            this.qAW = System.currentTimeMillis();
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    public final void eT(Context context) {
        if (!g.Eg().Dx() || context == null) {
            return;
        }
        if (this.qAU) {
            x.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
            return;
        }
        this.qAU = true;
        if (this.lang == null) {
            this.lang = w.d(context.getSharedPreferences(ad.chY(), 0));
        }
        x.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
        cR(this.lang, this.qAY);
    }

    public static void cR(String str, int i) {
        x.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", new Object[]{Integer.valueOf(i), str});
        ag agVar = new ag(i, str);
        g.Ek();
        g.Eh().dpP.a(agVar, 0);
    }

    public final void reset() {
        x.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
        g.Ek();
        g.Ei().DT().setLong(352276, 0);
        this.qAZ = 0;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (g.Eg().Dx()) {
            this.qAU = false;
            if (lVar == null) {
                x.e("MicroMsg.SuggestionAppListLogic", "scene == null");
                this.qAY = 0;
                this.qAV.clear();
                return;
            } else if (i == 0 && i2 == 0) {
                x.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                ag agVar = (ag) lVar;
                aru aru = (agVar.diG == null || agVar.diG.dIE.dIL == null) ? null : (aru) agVar.diG.dIE.dIL;
                if (aru == null) {
                    x.e("MicroMsg.SuggestionAppListLogic", "resp == null");
                    this.qAY = 0;
                    this.qAV.clear();
                    return;
                } else if (aru.rTY == null || aru.rTY.size() <= 0) {
                    x.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
                    a(a.bmm().bmk(), this.qAV);
                    this.qAY = 0;
                    this.qAV.clear();
                    g.Ek();
                    g.Ei().DT().setLong(352276, System.currentTimeMillis());
                    this.qAZ = System.currentTimeMillis();
                    return;
                } else {
                    x.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", new Object[]{Integer.valueOf(this.qAY), Integer.valueOf(aru.rTY.size())});
                    i bmk = a.bmm().bmk();
                    List linkedList = new LinkedList();
                    Iterator it = aru.rTY.iterator();
                    while (it.hasNext()) {
                        arv arv = (arv) it.next();
                        x.v("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", new Object[]{arv.rqK, Integer.valueOf(arv.rUd), Integer.valueOf(arv.rUh), Integer.valueOf(arv.rUg), Integer.valueOf(arv.rUe), arv.bPS});
                        if (!bi.oW(arv.bPS)) {
                            if (f.qzH.equals(arv.bPS)) {
                                arv.rUe = (arv.rUe ^ 253) ^ -1;
                                x.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", new Object[]{Integer.valueOf(arv.rUe)});
                            }
                            this.qAV.add(arv.bPS);
                            f bl = g.bl(arv.bPS, true);
                            if (bl != null) {
                                Object obj = bl.field_serviceAppInfoFlag != arv.rUe ? 1 : bl.field_serviceAppType != arv.rUd ? 1 : bl.cmZ != arv.rUg ? 1 : bl.field_serviceShowFlag != arv.rUh ? 1 : !bi.oV(bl.field_appName).equals(bi.oV(arv.rqK)) ? 1 : !bi.oV(bl.field_appName_en).equals(bi.oV(arv.rTZ)) ? 1 : !bi.oV(bl.field_appName_tw).equals(bi.oV(arv.rUa)) ? 1 : !bi.oV(bl.field_appName_hk).equals(bi.oV(arv.rUl)) ? 1 : !bi.oV(bl.cmX).equals(bi.oV(arv.rUc)) ? 1 : !bi.oV(bl.cmW).equals(bi.oV(arv.rUb)) ? 1 : !bi.oV(bl.cmY).equals(bi.oV(arv.rUf)) ? 1 : null;
                                if (obj != null) {
                                    String str2 = bl.cmX;
                                    String str3 = bl.cmW;
                                    a(bl, arv);
                                    boolean a = bmk.a(bl, new String[0]);
                                    if (!bi.oV(str2).equals(bi.oV(arv.rUc))) {
                                        x.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + bi.oV(arv.rUc));
                                        com.tencent.mm.plugin.ac.a.bmd().cO(bl.field_appId, 5);
                                    }
                                    if (!bi.oV(str3).equals(bi.oV(arv.rUb))) {
                                        x.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + bi.oV(arv.rUb));
                                        com.tencent.mm.plugin.ac.a.bmd().cO(bl.field_appId, 4);
                                    }
                                    x.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", new Object[]{arv.bPS, Boolean.valueOf(a)});
                                }
                            } else {
                                bl = new f();
                                bl.field_appId = arv.bPS;
                                a(bl, arv);
                                boolean l = bmk.l(bl);
                                x.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", new Object[]{arv.bPS, Boolean.valueOf(l)});
                            }
                            if (bi.oW(bl.field_openId)) {
                                linkedList.add(arv.bPS);
                            }
                        }
                    }
                    if (linkedList.size() > 0) {
                        x.d("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", new Object[]{Integer.valueOf(linkedList.size())});
                        com.tencent.mm.plugin.ac.a.bmh().cS(linkedList);
                    }
                    if (aru.rTY.size() == 20) {
                        this.qAY += 20;
                        cR(this.lang, this.qAY);
                    } else {
                        a(bmk, this.qAV);
                        this.qAY = 0;
                        this.qAV.clear();
                    }
                    g.Ek();
                    g.Ei().DT().setLong(352276, System.currentTimeMillis());
                    this.qAZ = System.currentTimeMillis();
                    return;
                }
            } else {
                x.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                this.qAY = 0;
                this.qAV.clear();
                return;
            }
        }
        x.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
        this.qAY = 0;
        this.qAV.clear();
    }

    private static void a(i iVar, List<String> list) {
        if (iVar != null && list != null && list.size() > 0) {
            x.d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
            List<f> arrayList = new ArrayList();
            if (a.bmm() == null) {
                x.e("MicroMsg.AppInfoLogic", "getAllServices, getISubCorePluginBase() == null");
            } else {
                Cursor bml = a.bmm().bml();
                if (bml != null) {
                    while (bml.moveToNext()) {
                        f fVar = new f();
                        fVar.d(bml);
                        if (!bi.oW(fVar.field_openId)) {
                            arrayList.add(fVar);
                        }
                    }
                    bml.close();
                }
            }
            x.d("MicroMsg.SuggestionAppListLogic", "oldList %d", new Object[]{Integer.valueOf(arrayList.size())});
            if (arrayList.size() > 0) {
                for (f fVar2 : arrayList) {
                    if (fVar2.field_appId != null) {
                        int i;
                        for (String equals : list) {
                            if (fVar2.field_appId.equals(equals)) {
                                i = 1;
                                break;
                            }
                        }
                        i = 0;
                        if (i == 0) {
                            boolean b = iVar.b(fVar2, new String[0]);
                            x.d("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", new Object[]{fVar2.field_appId, Boolean.valueOf(b)});
                        }
                    }
                }
            }
        }
    }

    private static void a(f fVar, arv arv) {
        fVar.field_appName = arv.rqK;
        fVar.field_appName_en = arv.rTZ;
        fVar.field_appName_tw = arv.rUa;
        fVar.field_appName_hk = arv.rUl;
        fVar.cmW = arv.rUb;
        fVar.clZ = true;
        fVar.cmX = arv.rUc;
        fVar.clZ = true;
        fVar.cmY = arv.rUf;
        fVar.clZ = true;
        fVar.field_serviceAppInfoFlag = arv.rUe;
        fVar.field_serviceAppType = arv.rUd;
        fVar.cmZ = arv.rUg;
        fVar.clZ = true;
        fVar.field_serviceShowFlag = arv.rUh;
    }
}
