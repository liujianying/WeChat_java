package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.a.e;
import com.tencent.mm.ui.conversation.a.i;
import com.tencent.mm.ui.conversation.a.o;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a implements c, aq, b {
    Context context;
    n mHI;
    List<com.tencent.mm.pluginsdk.ui.b.b> una = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> unb = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> unc = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> und = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> une = new LinkedList();
    com.tencent.mm.sdk.b.c unf;
    com.tencent.mm.sdk.b.c ung;
    ListView unh;
    View uni;

    public final void a(Context context, ListView listView, View view) {
        this.context = context;
        this.unh = listView;
        this.uni = view;
        this.ung = new 1(this);
        com.tencent.mm.sdk.b.a.sFg.b(this.ung);
        ad adVar = new ad();
        adVar.bHk.activity = (Activity) context;
        com.tencent.mm.sdk.b.a.sFg.m(adVar);
        ae aeVar = new ae();
        aeVar.bHl.bHn = (com.tencent.mm.pluginsdk.ui.b.b) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.usa, null);
        com.tencent.mm.sdk.b.a.sFg.m(aeVar);
        com.tencent.mm.pluginsdk.ui.b.b bVar = (com.tencent.mm.pluginsdk.ui.b.b) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.urU, null);
        aeVar = new ae();
        aeVar.bHl.bHn = bVar;
        aeVar.bHl.bHm = false;
        aeVar.bHl.level = 1;
        com.tencent.mm.sdk.b.a.sFg.m(aeVar);
        o oVar = (o) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.urZ, null);
        aeVar = new ae();
        aeVar.bHl.bHn = oVar;
        aeVar.bHl.bHm = false;
        aeVar.bHl.level = 2;
        com.tencent.mm.sdk.b.a.sFg.m(aeVar);
        com.tencent.mm.ui.conversation.a.a aVar = (com.tencent.mm.ui.conversation.a.a) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.urW, null);
        aeVar = new ae();
        aeVar.bHl.bHn = aVar;
        aeVar.bHl.bHm = false;
        aeVar.bHl.level = 3;
        com.tencent.mm.sdk.b.a.sFg.m(aeVar);
        com.tencent.mm.ui.d.a aVar2 = (com.tencent.mm.ui.d.a) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.usb, new Object[]{com.tencent.mm.model.b.b.b.dDY});
        aeVar = new ae();
        aeVar.bHl.bHn = aVar2;
        aeVar.bHl.bHm = true;
        com.tencent.mm.sdk.b.a.sFg.m(aeVar);
        com.tencent.mm.sdk.b.a.sFg.c(this.ung);
        List linkedList = new LinkedList();
        linkedList.addAll(this.una);
        linkedList.addAll(this.unb);
        linkedList.addAll(this.unc);
        linkedList.addAll(this.und);
        Collections.sort(linkedList, new 2(this));
        dW(linkedList);
        LinkedList linkedList2 = new LinkedList();
        bVar = (com.tencent.mm.pluginsdk.ui.b.b) e.a(context, com.tencent.mm.ui.conversation.a.e.a.urV, null);
        if (!(bVar == null || bVar.getView() == null)) {
            listView.addFooterView(bVar.getView());
        }
        this.une.add(bVar);
        listView.addFooterView(new i(context).getView(), null, true);
        this.une.add(bVar);
        this.mHI = new 3(this);
        au.a(this.mHI);
        this.unf = new 4(this);
        com.tencent.mm.sdk.b.a.sFg.b(this.unf);
        au.HU();
        com.tencent.mm.model.c.a(this);
        cyF();
    }

    public final void cyF() {
        boolean z = true;
        if (this.context != null && au.HX()) {
            x.i("MicroMsg.BannerHelper", "updateBanner, :%d", new Object[]{Integer.valueOf(hashCode())});
            boolean j = j(this.una, true);
            boolean j2 = j(this.unb, true);
            boolean j3 = j(this.unc, true);
            boolean j4 = j(this.und, true);
            if (!(j || j2 || j3 || j4)) {
                z = false;
            }
            if (j2) {
                dY(this.unc);
                dY(this.und);
            } else if (j3) {
                dY(this.und);
            }
            if (z && this.unh.getVisibility() != 0) {
                this.unh.setVisibility(0);
                this.uni.setVisibility(8);
            }
            for (com.tencent.mm.pluginsdk.ui.b.b bVar : this.une) {
                if (bVar != null) {
                    bVar.anR();
                }
            }
        }
    }

    public final void jX(String str) {
        if (au.HX() && !au.Dr() && ai.oV(str).length() > 0 && str.equals(q.GF())) {
            cyF();
        }
    }

    public final void a(int i, m mVar, Object obj) {
        if (au.HX()) {
            au.HU();
            if (mVar == com.tencent.mm.model.c.DT()) {
                int bc = ai.bc(obj);
                if (8193 == bc) {
                    cyF();
                }
                if (42 == bc) {
                    cyF();
                }
            }
        }
    }

    public final void HK() {
        cyF();
    }

    private void dW(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b view : list) {
            this.unh.addHeaderView(view.getView());
        }
    }

    final void dX(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            if (bVar.getView() != null) {
                this.unh.removeHeaderView(bVar.getView());
            }
        }
    }

    final boolean j(List<com.tencent.mm.pluginsdk.ui.b.b> list, boolean z) {
        boolean z2 = false;
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            boolean z3;
            View childAt = ((ViewGroup) bVar.getView()).getChildAt(0);
            if (bVar.anR()) {
                String str = "MicroMsg.BannerHelper";
                String str2 = "refreshAndReturnIsVisible[true] :%s, checkAll:%b, isVisible:%b, hc:%d";
                Object[] objArr = new Object[4];
                objArr[0] = bVar;
                objArr[1] = Boolean.valueOf(z);
                z3 = childAt != null && childAt.getVisibility() == 0;
                objArr[2] = Boolean.valueOf(z3);
                objArr[3] = Integer.valueOf(hashCode());
                x.i(str, str2, objArr);
                if (!z) {
                    return true;
                }
                z3 = true;
            } else {
                if (childAt != null && childAt.getVisibility() == 0) {
                    x.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[false] but visible :%s, checkAll:%b, hc:%d", new Object[]{bVar, Boolean.valueOf(z), Integer.valueOf(hashCode())});
                }
                z3 = z2;
            }
            z2 = z3;
        }
        return z2;
    }

    private static void dY(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b visibility : list) {
            visibility.setVisibility(8);
        }
    }

    static void dZ(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b release : list) {
            release.release();
        }
    }

    static void ea(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b destroy : list) {
            destroy.destroy();
        }
        list.clear();
    }
}
