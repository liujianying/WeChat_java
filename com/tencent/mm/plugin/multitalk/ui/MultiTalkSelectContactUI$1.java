package com.tencent.mm.plugin.multitalk.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ax.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;

class MultiTalkSelectContactUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MultiTalkSelectContactUI lvd;

    MultiTalkSelectContactUI$1(MultiTalkSelectContactUI multiTalkSelectContactUI) {
        this.lvd = multiTalkSelectContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (ao.isNetworkConnected(ad.getContext())) {
            List linkedList = new LinkedList();
            linkedList.addAll(MultiTalkSelectContactUI.a(this.lvd));
            linkedList.add(q.GF());
            String c = bi.c(linkedList, ",");
            if (MultiTalkSelectContactUI.b(this.lvd)) {
                d.a(MultiTalkSelectContactUI.a(this.lvd).size(), MultiTalkSelectContactUI.c(this.lvd), 1, "", MultiTalkSelectContactUI.d(this.lvd).lvH);
                o.bgN().b(this.lvd, c, MultiTalkSelectContactUI.e(this.lvd));
            } else {
                d.a(MultiTalkSelectContactUI.a(this.lvd).size(), MultiTalkSelectContactUI.c(this.lvd), 2, i.bgC(), 0);
                this.lvd.setResult(-1, this.lvd.getIntent().putExtra("Select_Contact", c));
                this.lvd.finish();
            }
        } else {
            e.a(this.lvd, R.l.voip_net_unavailable, null);
        }
        this.lvd.YC();
        return true;
    }
}
