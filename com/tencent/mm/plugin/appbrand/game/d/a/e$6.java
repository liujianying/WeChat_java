package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.game.widget.input.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.widget.input.u.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

class e$6 implements e {
    final /* synthetic */ int doP;
    final /* synthetic */ float fCA;
    final /* synthetic */ l fCl;
    final /* synthetic */ e fCx;
    final /* synthetic */ WAGamePanelInputEditText fCy;
    final /* synthetic */ a fCz;

    e$6(e eVar, WAGamePanelInputEditText wAGamePanelInputEditText, l lVar, a aVar, float f, int i) {
        this.fCx = eVar;
        this.fCy = wAGamePanelInputEditText;
        this.fCl = lVar;
        this.fCz = aVar;
        this.fCA = f;
        this.doP = i;
    }

    public final void kn(int i) {
        if (2 == i) {
            a aVar = this.fCx.fCq;
            String obj = this.fCy.getEditableText().toString();
            l lVar = this.fCl;
            Map hashMap = new HashMap(2);
            hashMap.put("errMsg", "ok");
            hashMap.put(DownloadSettingTable$Columns.VALUE, obj);
            aVar.x(hashMap).a(lVar).ahM();
            return;
        }
        x.i("MicroMsg.WAGameJsApiShowKeyboard", "onVisibilityChanged inputPanelHeight(%d),density(%f).", new Object[]{Integer.valueOf(this.fCz.getHeight()), Float.valueOf(this.fCA)});
        Map hashMap2 = new HashMap(1);
        hashMap2.put("height", Float.valueOf(((float) r0) / this.fCA));
        this.fCl.E(this.doP, this.fCx.f("ok", hashMap2));
    }
}
