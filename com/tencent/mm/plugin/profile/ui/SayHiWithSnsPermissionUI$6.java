package com.tencent.mm.plugin.profile.ui;

import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.openim.b.f;
import com.tencent.mm.openim.b.g;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class SayHiWithSnsPermissionUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ SayHiWithSnsPermissionUI lYi;

    SayHiWithSnsPermissionUI$6(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        this.lYi = sayHiWithSnsPermissionUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (SayHiWithSnsPermissionUI.d(this.lYi) == null || !SayHiWithSnsPermissionUI.d(this.lYi).isShowing()) {
            SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI;
            ActionBarActivity actionBarActivity;
            if (SayHiWithSnsPermissionUI.e(this.lYi)) {
                int i;
                List linkedList = new LinkedList();
                linkedList.add(SayHiWithSnsPermissionUI.f(this.lYi));
                List linkedList2 = new LinkedList();
                linkedList2.add(Integer.valueOf(SayHiWithSnsPermissionUI.g(this.lYi)));
                String h = SayHiWithSnsPermissionUI.h(this.lYi);
                Map hashMap = new HashMap();
                if (SayHiWithSnsPermissionUI.i(this.lYi).uGQ) {
                    i = 1;
                } else {
                    i = 0;
                }
                hashMap.put(SayHiWithSnsPermissionUI.f(this.lYi), Integer.valueOf(i));
                x.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", new Object[]{Integer.valueOf(i)});
                if (ab.XR(SayHiWithSnsPermissionUI.f(this.lYi))) {
                    f fVar = new f(SayHiWithSnsPermissionUI.f(this.lYi), h, this.lYi.getIntent().getStringExtra(a.ths));
                    au.DF().a(fVar, 0);
                    sayHiWithSnsPermissionUI = this.lYi;
                    actionBarActivity = this.lYi.mController.tml;
                    this.lYi.getString(R.l.app_tip);
                    SayHiWithSnsPermissionUI.a(sayHiWithSnsPermissionUI, h.a(actionBarActivity, this.lYi.getString(R.l.sendrequest_sending), true, new 1(this, fVar)));
                } else {
                    m mVar = new m(linkedList, linkedList2, h, "", hashMap, SayHiWithSnsPermissionUI.j(this.lYi));
                    String stringExtra = this.lYi.getIntent().getStringExtra("source_from_user_name");
                    String stringExtra2 = this.lYi.getIntent().getStringExtra("source_from_nick_name");
                    if (!bi.oW(stringExtra)) {
                        mVar.fy(stringExtra, stringExtra2);
                    }
                    au.DF().a(mVar, 0);
                    SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI2 = this.lYi;
                    actionBarActivity = this.lYi.mController.tml;
                    this.lYi.getString(R.l.app_tip);
                    SayHiWithSnsPermissionUI.a(sayHiWithSnsPermissionUI2, h.a(actionBarActivity, this.lYi.getString(R.l.sendrequest_sending), true, new 2(this, mVar)));
                }
            } else if (SayHiWithSnsPermissionUI.k(this.lYi)) {
                String stringExtra3 = this.lYi.getIntent().getStringExtra("Verify_ticket");
                if (ab.XR(SayHiWithSnsPermissionUI.f(this.lYi))) {
                    g gVar = new g(SayHiWithSnsPermissionUI.f(this.lYi), stringExtra3);
                    au.DF().a(gVar, 0);
                    sayHiWithSnsPermissionUI = this.lYi;
                    actionBarActivity = this.lYi.mController.tml;
                    this.lYi.getString(R.l.app_tip);
                    SayHiWithSnsPermissionUI.a(sayHiWithSnsPermissionUI, h.a(actionBarActivity, this.lYi.getString(R.l.contact_info_dealing_verify), true, new 3(this, gVar)));
                } else {
                    m mVar2 = new m(SayHiWithSnsPermissionUI.f(this.lYi), stringExtra3, SayHiWithSnsPermissionUI.g(this.lYi), (byte) 0);
                    au.DF().a(mVar2, 0);
                    sayHiWithSnsPermissionUI = this.lYi;
                    actionBarActivity = this.lYi.mController.tml;
                    this.lYi.getString(R.l.app_tip);
                    SayHiWithSnsPermissionUI.a(sayHiWithSnsPermissionUI, h.a(actionBarActivity, this.lYi.getString(R.l.contact_info_dealing_verify), true, new 4(this, mVar2)));
                }
            }
        }
        return false;
    }
}
