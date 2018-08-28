package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.j.d;
import java.util.List;

class AAQueryListUI$6 implements a<Object, d<List, String, Boolean>> {
    final /* synthetic */ AAQueryListUI eCd;
    final /* synthetic */ boolean eCf;

    AAQueryListUI$6(AAQueryListUI aAQueryListUI, boolean z) {
        this.eCd = aAQueryListUI;
        this.eCf = z;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        List list = (List) dVar.get(0);
        x.i("MicroMsg.AAQueryListUI", "record list size: %s, h5Url: %s, lastFlag: %s", new Object[]{Integer.valueOf(list.size()), dVar.get(1), dVar.get(2)});
        if (!bi.oW((String) dVar.get(1))) {
            AAQueryListUI.a(this.eCd, (String) dVar.get(1));
        }
        if (this.eCf) {
            AAQueryListUI.f(this.eCd).Wf();
        }
        b f = AAQueryListUI.f(this.eCd);
        x.i("MicroMsg.AAQueryListAdapter", "addNewRecord: %s", new Object[]{list});
        if (list != null && list.size() > 0) {
            x.i("MicroMsg.AAQueryListAdapter", "addNewRecord size: %s", new Object[]{Integer.valueOf(list.size())});
            f.dataList.addAll(list);
            f.notifyDataSetChanged();
        }
        if (AAQueryListUI.g(this.eCd) != null) {
            AAQueryListUI.g(this.eCd).dismiss();
            AAQueryListUI.h(this.eCd);
        }
        if (AAQueryListUI.a(this.eCd).getVisibility() != 0) {
            AAQueryListUI.a(this.eCd).setVisibility(0);
        }
        AAQueryListUI.i(this.eCd);
        if (!((Boolean) dVar.get(2)).booleanValue()) {
            AAQueryListUI.j(this.eCd);
        }
        if (AAQueryListUI.a(this.eCd).getFooterViewsCount() > 0) {
            AAQueryListUI.a(this.eCd).removeFooterView(AAQueryListUI.d(this.eCd));
        }
        if (AAQueryListUI.b(this.eCd)) {
            AAQueryListUI.k(this.eCd);
            if (AAQueryListUI.l(this.eCd).getVisibility() == 0) {
                AAQueryListUI.a(this.eCd).addFooterView(AAQueryListUI.l(this.eCd), null, false);
            }
        }
        return uQG;
    }
}
