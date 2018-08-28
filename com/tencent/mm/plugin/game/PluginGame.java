package com.tencent.mm.plugin.game;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.game.a.a.a;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.a.d;
import com.tencent.mm.plugin.game.model.h;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class PluginGame extends f implements c, d {
    c jFW;

    public void configure(g gVar) {
        if (gVar.ES()) {
            x.i("MicroMsg.PluginGame", "PluginGame configure");
            a.a(new b());
            if (this.jFW == null) {
                this.jFW = new c();
            }
        }
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            x.i("MicroMsg.PluginGame", "PluginGame execute");
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.a.c.class, new e());
            com.tencent.mm.kernel.g.a(b.class, new d());
        }
    }

    public void onAccountInitialized(e.c cVar) {
        x.i("MicroMsg.PluginGame", "onAccountInitialized");
        if (this.jFW != null) {
            c cVar2 = this.jFW;
            ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().a("gamecenter", cVar2.iwx, true);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFw);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFx);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.hKG);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFy);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFz);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFA);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFB);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFC);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFF);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFG);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFD);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFH);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFI);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFJ);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFK);
            com.tencent.mm.sdk.b.a.sFg.b(cVar2.jFL);
            m.aDb();
            com.tencent.mm.plugin.game.model.a.d.aDb();
            com.tencent.mm.plugin.game.wepkg.utils.c cVar3 = cVar2.jFv;
            x.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
            com.tencent.mm.sdk.b.a.sFg.b(cVar3.kgn);
            com.tencent.mm.sdk.b.a.sFg.b(cVar3.kgp);
            com.tencent.mm.sdk.b.a.sFg.b(cVar3.kgo);
            com.tencent.mm.plugin.game.wepkg.b.a.aDb();
            Context context = ad.getContext();
            if (context != null) {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("we_pkg_sp", 4);
                    if (sharedPreferences == null) {
                        x.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
                    } else {
                        if (sharedPreferences.getBoolean("disable_we_pkg", false)) {
                            x.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
                            sharedPreferences.edit().putBoolean("disable_we_pkg", false).commit();
                        }
                        sharedPreferences.edit().putInt("white_screen_times", 0).commit();
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.Wepkg.WepkgListener", e.getMessage());
                }
            }
        }
        h.aTL().Zy();
    }

    public void onAccountRelease() {
        x.i("MicroMsg.PluginGame", "onAccountRelease");
        if (this.jFW != null) {
            c cVar = this.jFW;
            ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().b("gamecenter", cVar.iwx, true);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFw);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFx);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.hKG);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFy);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFz);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFA);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFB);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFC);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFF);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFG);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFD);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFH);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFI);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFJ);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFK);
            com.tencent.mm.sdk.b.a.sFg.c(cVar.jFL);
            m.aDc();
            com.tencent.mm.plugin.game.model.a.d.aDc();
            com.tencent.mm.plugin.game.wepkg.utils.c cVar2 = cVar.jFv;
            x.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
            com.tencent.mm.sdk.b.a.sFg.c(cVar2.kgn);
            com.tencent.mm.sdk.b.a.sFg.c(cVar2.kgp);
            com.tencent.mm.sdk.b.a.sFg.c(cVar2.kgo);
            com.tencent.mm.plugin.game.wepkg.b.a.aDc();
            com.tencent.mm.plugin.game.wepkg.utils.d.aox();
        }
        com.tencent.mm.plugin.game.e.c.aox();
    }
}
