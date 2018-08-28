package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class AppBrandOpenWeRunSettingUI$1 implements OnClickListener {
    final /* synthetic */ AppBrandOpenWeRunSettingUI guU;

    AppBrandOpenWeRunSettingUI$1(AppBrandOpenWeRunSettingUI appBrandOpenWeRunSettingUI) {
        this.guU = appBrandOpenWeRunSettingUI;
    }

    public final void onClick(View view) {
        d.kB(13);
        AppBrandOpenWeRunSettingUI appBrandOpenWeRunSettingUI = this.guU;
        appBrandOpenWeRunSettingUI.getString(j.app_tip);
        appBrandOpenWeRunSettingUI.guT = h.a(appBrandOpenWeRunSettingUI, ((a) g.l(a.class)).cq(appBrandOpenWeRunSettingUI), true, null);
        appBrandOpenWeRunSettingUI.guT.show();
        g.Eh().dpP.a(30, appBrandOpenWeRunSettingUI);
        List linkedList = new LinkedList();
        linkedList.add("gh_43f2581f6fd6");
        List linkedList2 = new LinkedList();
        linkedList2.add(Integer.valueOf(1));
        g.Eh().dpP.a(new m(1, linkedList, linkedList2, "", ""), 0);
    }
}
