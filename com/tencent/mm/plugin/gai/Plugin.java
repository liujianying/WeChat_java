package com.tencent.mm.plugin.gai;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.gai.a.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class Plugin implements c {
    public Plugin() {
        x.i("MicroMsg.Plugin.gai", "gai Plugin!");
        if (!ad.getContext().getSharedPreferences(ad.chY() + "_google_aid", 4).getBoolean("already_report_googleaid", false)) {
            e.post(new 2(this, ad.getContext(), new 1(this)), "Advertisement-MAT-thread");
        }
    }

    public n createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ar createSubCore() {
        return new com.tencent.mm.plugin.gai.b.a();
    }
}
