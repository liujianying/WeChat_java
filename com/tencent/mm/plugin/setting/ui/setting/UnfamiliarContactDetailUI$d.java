package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.bd;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.g;
import com.tencent.mm.protocal.c.ayq;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class UnfamiliarContactDetailUI$d implements e, Runnable {
    int index = 0;
    int lcB = 0;
    final /* synthetic */ UnfamiliarContactDetailUI mUT;
    g mVi;
    Collection<Integer> mVj;
    int mVk = 0;
    LinkedList<String> mVl = new LinkedList();
    LinkedList<b> mVm = new LinkedList();

    UnfamiliarContactDetailUI$d(UnfamiliarContactDetailUI unfamiliarContactDetailUI, Collection<Integer> collection, g gVar) {
        this.mUT = unfamiliarContactDetailUI;
        this.mVj = collection;
        this.mVi = gVar;
    }

    public final void run() {
        this.lcB = this.mVj.size();
        for (Integer intValue : this.mVj) {
            int intValue2 = intValue.intValue();
            this.index++;
            int size = this.mVj.size();
            int i = this.index;
            if (UnfamiliarContactDetailUI.e(this.mUT) != null) {
                ab abVar = UnfamiliarContactDetailUI.e(this.mUT).vS(intValue2).guS;
                if (ab.XR(abVar.field_username)) {
                    ((a) com.tencent.mm.kernel.g.l(a.class)).oB(abVar.field_username);
                } else {
                    ra raVar = new ra();
                    raVar.rvi = new bhz().VO(bi.oV(abVar.field_username));
                    this.mVm.add(new h.a(4, raVar));
                    if (this.mVm.size() % 20 == 0 || i == size) {
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Eh().dpP.a(new com.tencent.mm.aq.a(this.mVm), 0);
                        this.mVm.clear();
                    }
                }
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() != 681) {
            return;
        }
        if (((com.tencent.mm.aq.a) lVar).ebV == null || ((com.tencent.mm.aq.a) lVar).ebV.ebY == null) {
            x.e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
            return;
        }
        ayq ayq = ((com.tencent.mm.aq.a) lVar).ebV.ebY.eca;
        if (ayq.rfn != 0 || ayq.sbu == null || ayq.sbu.rHd == null) {
            x.e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[]{Integer.valueOf(ayq.rfn)});
            return;
        }
        List list = ((com.tencent.mm.aq.a) lVar).ebW;
        x.i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(ayq.sbu.rHd.size())});
        for (int i3 = 0; i3 < list.size(); i3++) {
            b bVar = (b) list.get(i3);
            if (bVar.getCmdId() != 4) {
                x.w("MicroMsg.UnfamiliarContactUI", "cmdId:%s operation:%s", new Object[]{Integer.valueOf(bVar.getCmdId()), bVar.toString()});
            } else {
                this.lcB--;
                ra raVar = (ra) bVar.lcH;
                if (((Integer) r5.get(i3)).intValue() == 0) {
                    this.mVk++;
                    ab Yg = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(com.tencent.mm.platformtools.ab.a(raVar.rvi));
                    if (Yg != null) {
                        Yg.Bc();
                        bd.a(Yg.field_username, null);
                        ((i) com.tencent.mm.kernel.g.l(i.class)).FR().a(Yg.field_username, Yg);
                        ((i) com.tencent.mm.kernel.g.l(i.class)).FW().Yp(Yg.field_username);
                        this.mVl.add(Yg.field_username);
                    }
                } else {
                    x.e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", new Object[]{r5.get(i3), com.tencent.mm.platformtools.ab.a(raVar.rvi)});
                }
            }
        }
        if (this.lcB <= 0) {
            Iterator it = this.mVl.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                Iterator it2 = UnfamiliarContactDetailUI.f(this.mUT).iterator();
                while (it2.hasNext()) {
                    if (((UnfamiliarContactDetailUI.b) it2.next()).guS.field_username.equals(str2)) {
                        it2.remove();
                    }
                }
            }
            UnfamiliarContactDetailUI.a(this.mUT, UnfamiliarContactDetailUI.f(this.mUT));
            this.mUT.runOnUiThread(new 1(this));
        }
    }
}
