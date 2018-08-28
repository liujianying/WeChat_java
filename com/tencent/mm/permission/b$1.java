package com.tencent.mm.permission;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;
import java.util.List;

class b$1 extends c<lq> {
    final /* synthetic */ b evd;

    b$1(b bVar) {
        this.evd = bVar;
        this.sFo = lq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lq lqVar = (lq) bVar;
        if (true == lqVar.bWa.bWc) {
            if (!b.iP(lqVar.bWa.type)) {
                if (a.dfP == null) {
                    List<a.b> arrayList = new ArrayList();
                    List<a.a> arrayList2 = new ArrayList();
                    a.a(e.duN + "permissioncfg.cfg", arrayList, arrayList2);
                    PInt pInt = new PInt(0);
                    PBool pBool = new PBool();
                    for (a.b bVar2 : arrayList) {
                        pInt.value = 0;
                        pBool.value = true;
                        if (a.a(Build.MANUFACTURER, bVar2.dfU, pInt, pBool) && a.a(Build.MODEL, bVar2.model, pInt, pBool)) {
                            a.a(VERSION.RELEASE, bVar2.version, pInt, pBool);
                        }
                        if (pBool.value && pInt.value > 0) {
                            a.dfP = Boolean.valueOf(1 == bVar2.dfS);
                        }
                    }
                    if (a.dfP == null || true != a.dfP.booleanValue()) {
                        for (PackageInfo packageInfo : a.be(false)) {
                            for (a.a aVar : arrayList2) {
                                pInt.value = 0;
                                pBool.value = true;
                                if (a.a(packageInfo.packageName, aVar.byT, pInt, pBool)) {
                                    if (aVar.dfQ == 0 && aVar.dfR == 0) {
                                        pBool.value = true;
                                    } else if (aVar.dfQ > packageInfo.versionCode || aVar.dfR < packageInfo.versionCode) {
                                        pBool.value = false;
                                    } else {
                                        pInt.value++;
                                        pBool.value = true;
                                    }
                                }
                                if (pBool.value && pInt.value > 0) {
                                    a.dfP = Boolean.valueOf(1 == aVar.dfS);
                                }
                            }
                            if (a.dfP != null && true == a.dfP.booleanValue()) {
                                break;
                            }
                        }
                        if (a.dfP == null) {
                            a.dfP = Boolean.valueOf(false);
                        }
                    }
                }
                if (a.dfP.booleanValue()) {
                    lqVar.bWb.bWe = b.y(lqVar.bWa.type, true);
                    b.b(lqVar.bWa.type, false, true);
                }
            }
            lqVar.bWb.bWe = false;
            b.b(lqVar.bWa.type, true, false);
        } else {
            lqVar.bWb.bWe = false;
            b.b(lqVar.bWa.type, false, lqVar.bWa.bWd);
        }
        return false;
    }
}
