package com.tencent.mm.plugin.appbrand.appusage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.q.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.n.g;
import com.tencent.mm.plugin.appbrand.n.g.b;
import com.tencent.mm.plugin.appbrand.n.g.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.protocal.c.ahn;
import java.util.ArrayList;
import java.util.Iterator;

public final class w implements g {
    public final b adj() {
        b bVar = new b();
        bVar.dEw = new ArrayList(0);
        bVar.gsQ = -1;
        bVar.bSc = "";
        if (!com.tencent.mm.kernel.g.Eg().dpD || !b.acE()) {
            return bVar;
        }
        Iterator 1;
        int i;
        ahn adi = q.adi();
        b bVar2 = new b();
        bVar2.bSc = adi == null ? null : adi.ksB;
        bVar2.gsQ = adi == null ? 0 : adi.rKM;
        if (adi == null) {
            1 = new 1(this, e.abg().a(new String[]{"brandId", "versionType"}, 4, 0));
            i = 4;
        } else {
            2 2 = new 2(this, adi);
            i = adi.rKL.size();
            com.tencent.mm.sdk.f.e.post(new 3(this, adi), "BatchSyncWxaAttrBySearchShowOut");
            1 = 2;
        }
        bVar2.dEw = new ArrayList(i);
        while (1.hasNext()) {
            Object[] objArr = (Object[]) 1.next();
            WxaAttributes e = e.aba().e((String) objArr[0], new String[]{"nickname", "brandIconURL"});
            if (e != null) {
                c cVar = new c();
                cVar.username = (String) objArr[0];
                cVar.fmv = ((Integer) objArr[1]).intValue();
                cVar.cbu = ((Integer) objArr[2]).intValue();
                cVar.nickname = e.field_nickname;
                cVar.fmD = e.field_brandIconURL;
                bVar2.dEw.add(cVar);
            }
        }
        i = a.fmy;
        q.adh();
        return bVar2;
    }

    public final void a(Context context, String str, g.a aVar) {
        Intent intent = new Intent(context, AppBrandLauncherUI.class);
        intent.putExtra("extra_enter_scene", 10);
        intent.putExtra("extra_enter_scene_note", str + ":" + aVar.tag);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public final void a(Context context, c cVar, String str) {
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1054;
        appBrandStatObject.bGG = str;
        ((d) com.tencent.mm.kernel.g.l(d.class)).a(context, cVar.username, null, cVar.fmv, cVar.cbu, null, appBrandStatObject);
    }
}
