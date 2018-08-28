package com.tencent.mm.plugin.game;

import android.os.Bundle;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.v;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class c$13 extends c<gk> {
    final /* synthetic */ c jFM;

    c$13(c cVar) {
        this.jFM = cVar;
        this.sFo = gk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gk gkVar = (gk) bVar;
        switch (gkVar.bPB.actionCode) {
            case 1:
                f.a(gkVar.bPB.context, gkVar.bPB.appId, gkVar.bPB.messageAction, gkVar.bPB.messageExt, null);
                an.a(gkVar.bPB.context, gkVar.bPB.scene, gkVar.bPB.scene, 1, 3, gkVar.bPB.appId, 0, null);
                break;
            case 2:
                int i = gkVar.bPB.scene;
                x.i("MicroMsg.GameEventListener", "scene = %d, extinfo = %s", new Object[]{Integer.valueOf(i), gkVar.bPB.extMsg});
                Bundle bundle = new Bundle();
                bundle.putInt("game_report_from_scene", i);
                bundle.putCharSequence("game_app_id", gkVar.bPB.appId);
                bundle.putCharSequence("game_report_extra_click_extinfo", r1);
                an.a(gkVar.bPB.context, gkVar.bPB.scene, gkVar.bPB.scene, 1, com.tencent.mm.plugin.game.e.c.b(gkVar.bPB.context, gkVar.bPB.appId, null, bundle), gkVar.bPB.appId, 0, null);
                break;
            case 3:
                r.update();
                break;
            case 5:
                int i2 = gkVar.bPB.scene;
                ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSi();
                o.a(v.aTZ(), i2, 2);
                break;
        }
        return false;
    }
}
