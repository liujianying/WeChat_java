package com.tencent.mm.plugin.gcm;

import com.tencent.mm.g.a.gu;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.gcm.modelgcm.GcmBroadcastReceiver;
import com.tencent.mm.plugin.gcm.modelgcm.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public class Plugin implements c {
    com.tencent.mm.sdk.b.c kha = new 1(this);
    com.tencent.mm.sdk.b.c khb = new com.tencent.mm.sdk.b.c<gu>() {
        {
            this.sFo = gu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            a aVG = a.aVG();
            if (aVG == null) {
                return false;
            }
            x.i("GcmRegister", "GCM onLogout. isRegToSvr:" + aVG.aVO());
            GcmBroadcastReceiver.aVF();
            if (aVG.aVO()) {
                aVG.aVN();
            }
            return true;
        }
    };

    public Plugin() {
        com.tencent.mm.sdk.b.a.sFg.b(this.kha);
        com.tencent.mm.sdk.b.a.sFg.b(this.khb);
    }

    public n createApplication() {
        return new com.tencent.mm.plugin.gcm.a.a();
    }

    public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory() {
        return null;
    }

    public ar createSubCore() {
        return new com.tencent.mm.plugin.gcm.modelgcm.b();
    }
}
