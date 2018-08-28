package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class SayHiEditUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ String dMs;
    final /* synthetic */ int ulo;
    final /* synthetic */ String ulp;
    final /* synthetic */ SayHiEditUI ulq;

    SayHiEditUI$1(SayHiEditUI sayHiEditUI, String str, int i, String str2) {
        this.ulq = sayHiEditUI;
        this.dMs = str;
        this.ulo = i;
        this.ulp = str2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ulq.YC();
        b.lFJ.S(2, 1, 3);
        List linkedList = new LinkedList();
        linkedList.add(this.dMs);
        List linkedList2 = new LinkedList();
        linkedList2.add(Integer.valueOf(this.ulo));
        List linkedList3 = new LinkedList();
        if (!ai.oW(this.ulp)) {
            linkedList3.add(this.ulp);
        }
        l mVar = new m(2, linkedList, linkedList2, linkedList3, SayHiEditUI.a(this.ulq), "", null, null, "");
        au.DF().a(mVar, 0);
        SayHiEditUI sayHiEditUI = this.ulq;
        Context context = this.ulq.mController.tml;
        this.ulq.getString(R.l.app_tip);
        SayHiEditUI.a(sayHiEditUI, h.a(context, this.ulq.getString(R.l.sendrequest_sending), true, new 1(this, mVar)));
        return false;
    }
}
