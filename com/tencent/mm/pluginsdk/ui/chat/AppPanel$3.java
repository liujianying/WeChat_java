package com.tencent.mm.pluginsdk.ui.chat;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.chat.AppGrid.b;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AppPanel$3 implements b {
    final /* synthetic */ AppPanel qKH;

    AppPanel$3(AppPanel appPanel) {
        this.qKH = appPanel;
    }

    public final int Cf(int i) {
        if (i < AppPanel.f(this.qKH)) {
            int length = AppPanel.g(this.qKH).length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (AppPanel.g(this.qKH)[i3]) {
                    if (i2 == i) {
                        return i3;
                    }
                    i2++;
                }
            }
        } else if (i >= AppPanel.f(this.qKH) && i < AppPanel.h(this.qKH)) {
            return Integer.MIN_VALUE;
        }
        return Integer.MAX_VALUE;
    }

    public final void Cg(int i) {
        if (i != 0) {
            return;
        }
        if (this.qKH.qKn.qKL.value) {
            AppPanel.a(this.qKH, true);
        } else {
            Toast.makeText(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.chatting_msg_type_not_support), 0).show();
        }
    }

    public final void a(int i, f fVar) {
        int i2 = 0;
        String str = "MicroMsg.AppPanel";
        String str2 = "pos=%d, has appInfo = %b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(fVar != null);
        x.d(str, str2, objArr);
        if (fVar != null && g.j(fVar)) {
            Map hashMap = new HashMap();
            q.q(hashMap);
            hashMap.put(fVar.field_appId, "1");
            q.p(hashMap);
        }
        rn rnVar;
        String str3;
        f fVar2;
        int intValue;
        List F;
        switch (i) {
            case Integer.MIN_VALUE:   //int中最小的值
                if (!this.qKH.qKn.qKS.value) {
                    Toast.makeText(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.chatting_msg_type_not_support), 0).show(); //暂不支持此消息类型
                    return;
                } else if (fVar == null) {
                    x.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
                    return;
                } else {
                    if (fVar.cbJ() || fVar.cbL()) {
                        if (AppPanel.m(this.qKH) == null) {
                            AppPanel.a(this.qKH, AppPanel.i(this.qKH).getSharedPreferences(ad.chY(), 0));
                        }
                        if (AppPanel.m(this.qKH).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, true)) {
                            AppPanel.m(this.qKH).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, false).commit();
                        }
                        if (fVar.cbL()) {
                            h.mEJ.h(10923, new Object[]{Integer.valueOf(16), fVar.field_appId, Integer.valueOf(0)});
                        }
                        h.mEJ.h(10923, new Object[]{Integer.valueOf(13), fVar.field_appId, Integer.valueOf(0)});
                    } else {
                        h.mEJ.h(10923, new Object[]{Integer.valueOf(11), fVar.field_appId});
                    }
                    AppPanel.k(this.qKH).b(fVar);
                    return;
                }
            case 0:
                if (this.qKH.qKn.qKL.value) {
                    h.mEJ.h(10923, new Object[]{Integer.valueOf(1)});
                    AppPanel.a(this.qKH, false);
                    return;
                }
                Toast.makeText(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.chatting_msg_type_not_support), 0).show();
                return;
            case 1:
                h.mEJ.h(10923, new Object[]{Integer.valueOf(14)});
                a k = AppPanel.k(this.qKH);
                if (!this.qKH.qKn.qLb.value) {
                    i2 = 2;
                }
                k.su(i2);
                return;
            case 2:
                if (this.qKH.qKn.qKO.value) {
                    h.mEJ.h(10923, new Object[]{Integer.valueOf(8)});
                    au.HU();
                    c.DT().set(54, Boolean.valueOf(false));
                    if (AppPanel.k(this.qKH) != null) {
                        rnVar = new rn();
                        rnVar.ccn.ccp = true;
                        com.tencent.mm.sdk.b.a.sFg.m(rnVar);
                        str3 = rnVar.cco.ccr;
                        if (bi.oW(str3)) {
                            AppPanel.k(this.qKH).bcy();
                            return;
                        }
                        x.v("MicroMsg.AppPanel", "Talkroom is on: " + str3);
                        com.tencent.mm.ui.base.h.a(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.talk_room_enter_voip_tip), "", AppPanel.i(this.qKH).getString(R.l.app_ok), AppPanel.i(this.qKH).getString(R.l.app_cancel), new 1(this), new 2(this));
                        return;
                    }
                    return;
                }
                Toast.makeText(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.chatting_msg_type_not_support), 0).show();
                return;
            case 3:
                if (AppPanel.k(this.qKH) != null) {
                    AppPanel.k(this.qKH).bcI();
                    return;
                }
                return;
            case 4:
                if (this.qKH.qKn.qKU.value) {
                    h.mEJ.h(10923, new Object[]{Integer.valueOf(7)});
                    au.HU();
                    c.DT().set(62, Boolean.valueOf(false));
                    rnVar = new rn();
                    rnVar.ccn.ccp = true;
                    com.tencent.mm.sdk.b.a.sFg.m(rnVar);
                    str3 = rnVar.cco.ccr;
                    if (bi.oW(str3)) {
                        AppPanel.k(this.qKH).bcz();
                        return;
                    }
                    x.v("MicroMsg.AppPanel", "Talkroom is on: " + str3);
                    com.tencent.mm.ui.base.h.a(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.talk_room_enter_voip_tip), "", AppPanel.i(this.qKH).getString(R.l.app_ok), AppPanel.i(this.qKH).getString(R.l.app_cancel), new 3(this), new 4(this));
                    return;
                }
                Toast.makeText(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.chatting_msg_type_not_support), 0).show();
                return;
            case 5:
                if (AppPanel.k(this.qKH) != null) {
                    h.mEJ.h(10923, new Object[]{Integer.valueOf(6)});
                    au.HU();
                    c.DT().set(67, Boolean.valueOf(false));
                    AppPanel.k(this.qKH).bcA();
                    return;
                }
                return;
            case 6:
                if (this.qKH.qKn.qKY.value && this.qKH.qKn.qKZ.value) {
                    au.HU();
                    if (((Boolean) c.DT().get(290817, Boolean.valueOf(true))).booleanValue()) {
                        au.HU();
                        c.DT().set(290817, Boolean.valueOf(false));
                        this.qKH.refresh();
                    }
                    h.mEJ.h(10923, new Object[]{Integer.valueOf(3)});
                    AppPanel.k(this.qKH).bcB();
                    return;
                }
                Toast.makeText(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.chatting_msg_type_not_support), 0).show();
                return;
            case 7:
                if (this.qKH.qKn.qLc.value) {
                    if (fVar == null) {
                        fVar2 = (f) AppPanel.l(this.qKH).get(f.qzG);
                        if (fVar2 == null) {
                            return;
                        }
                    }
                    fVar2 = fVar;
                    if (fVar2.cbJ() || fVar2.cbL()) {
                        if (AppPanel.m(this.qKH) == null) {
                            AppPanel.a(this.qKH, AppPanel.i(this.qKH).getSharedPreferences(ad.chY(), 0));
                        }
                        if (AppPanel.m(this.qKH).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, true)) {
                            AppPanel.m(this.qKH).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, false).commit();
                        }
                        h.mEJ.h(10923, new Object[]{Integer.valueOf(13), fVar2.field_appId, Integer.valueOf(0)});
                    } else {
                        h.mEJ.h(10923, new Object[]{Integer.valueOf(11), fVar2.field_appId});
                    }
                    au.HU();
                    intValue = ((Integer) c.DT().get(aa.a.sTs, Integer.valueOf(0))).intValue();
                    au.HU();
                    F = bi.F(((String) c.DT().get(aa.a.sVu, "")).split(";"));
                    if (!F.contains(String.valueOf(intValue))) {
                        F.add(String.valueOf(intValue));
                        au.HU();
                        c.DT().a(aa.a.sVu, bi.c(F, ";"));
                        this.qKH.refresh();
                    }
                    AppPanel.k(this.qKH).bcH();
                    return;
                }
                Toast.makeText(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.chatting_msg_type_not_support), 0).show();
                return;
            case 8:
                if (fVar == null) {
                    fVar = (f) AppPanel.l(this.qKH).get(f.qzE);
                }
                au.HU();
                intValue = ((Integer) c.DT().get(aa.a.sTs, Integer.valueOf(0))).intValue();
                au.HU();
                F = bi.F(((String) c.DT().get(aa.a.sVt, "")).split(";"));
                if (!F.contains(String.valueOf(intValue))) {
                    F.add(String.valueOf(intValue));
                    au.HU();
                    c.DT().a(aa.a.sVt, bi.c(F, ";"));
                    this.qKH.refresh();
                }
                au.HU();
                c.DT().set(80, Boolean.valueOf(false));
                AppPanel.k(this.qKH).b(fVar);
                return;
            case 9:
                if (AppPanel.k(this.qKH) != null) {
                    if (fVar == null) {
                        fVar2 = (f) AppPanel.l(this.qKH).get(f.qzH);
                        if (fVar2 == null) {
                            x.i("MicroMsg.AppPanel", "empty info");
                            return;
                        }
                    }
                    fVar2 = fVar;
                    if (fVar2.cbJ() || fVar2.cbL()) {
                        if (AppPanel.m(this.qKH) == null) {
                            AppPanel.a(this.qKH, AppPanel.i(this.qKH).getSharedPreferences(ad.chY(), 0));
                        }
                        if (AppPanel.m(this.qKH).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, true)) {
                            AppPanel.m(this.qKH).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, false).commit();
                        }
                    }
                    AppPanel.k(this.qKH).bcK();
                    return;
                }
                return;
            case 10:
                h.mEJ.h(10923, new Object[]{Integer.valueOf(9)});
                au.HU();
                c.DT().set(73, Boolean.valueOf(false));
                AppPanel.n(this.qKH).ceh();
                return;
            case 11:
                if (this.qKH.qKn.qKM.value) {
                    h.mEJ.h(10923, new Object[]{Integer.valueOf(4)});
                    AppPanel.k(this.qKH).bcC();
                    return;
                }
                Toast.makeText(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.chatting_msg_type_not_support), 0).show();
                return;
            case 12:
                if (this.qKH.qKn.qKN.value) {
                    h.mEJ.h(10923, new Object[]{Integer.valueOf(5)});
                    if (AppPanel.k(this.qKH) != null) {
                        AppPanel.k(this.qKH).bcE();
                        return;
                    }
                    return;
                }
                Toast.makeText(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.chatting_msg_type_not_support), 0).show();
                return;
            case 13:
                if (this.qKH.qKn.qLa.value) {
                    if (AppPanel.k(this.qKH) != null) {
                        AppPanel.k(this.qKH).bcG();
                    }
                    h.mEJ.h(10923, new Object[]{Integer.valueOf(15)});
                    au.HU();
                    boolean booleanValue = ((Boolean) c.DT().get(208899, Boolean.valueOf(false))).booleanValue();
                    au.HU();
                    boolean booleanValue2 = ((Boolean) c.DT().get(208913, Boolean.valueOf(false))).booleanValue();
                    if (booleanValue) {
                        h.mEJ.h(11594, new Object[]{Integer.valueOf(3)});
                        return;
                    } else if (booleanValue2) {
                        h.mEJ.h(11594, new Object[]{Integer.valueOf(4)});
                        return;
                    } else {
                        return;
                    }
                }
                Toast.makeText(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.chatting_msg_type_not_support), 0).show();
                return;
            case 14:
                if (this.qKH.qKn.qKQ.value) {
                    au.HU();
                    if (((Boolean) c.DT().get(327744, Boolean.valueOf(true))).booleanValue()) {
                        au.HU();
                        c.DT().set(327744, Boolean.valueOf(false));
                        this.qKH.refresh();
                    }
                    h.mEJ.h(10923, new Object[]{Integer.valueOf(12)});
                    AppPanel.k(this.qKH).bcF();
                    return;
                }
                Toast.makeText(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.chatting_msg_type_not_support), 0).show();
                return;
            case 15:
                if (this.qKH.qKn.qLe.value) {
                    AppPanel.k(this.qKH).bcJ();
                    return;
                } else {
                    Toast.makeText(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.chatting_msg_type_not_support), 0).show();
                    return;
                }
            case 16:
                if (this.qKH.qKn.qLg.value) {
                    h.mEJ.h(10923, new Object[]{Integer.valueOf(17)});
                    if (AppPanel.k(this.qKH) != null) {
                        AppPanel.k(this.qKH).bcL();
                        return;
                    }
                    return;
                }
                Toast.makeText(AppPanel.i(this.qKH), AppPanel.i(this.qKH).getString(R.l.chatting_msg_type_not_support), 0).show();
                return;
            case Integer.MAX_VALUE:
                if (AppPanel.j(this.qKH) == null) {
                    x.e("MicroMsg.AppPanel", "infoList == null");
                    return;
                }
                h.mEJ.k(10305, String.valueOf(AppPanel.j(this.qKH).size()));
                h.mEJ.h(10923, new Object[]{Integer.valueOf(10)});
                com.tencent.mm.kernel.g.Ei().DT().set(69121, "");
                AppPanel.k(this.qKH).bcD();
                return;
            default:
                return;
        }
    }
}
