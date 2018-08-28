package com.tencent.mm.plugin.location_soso;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.x;

public class Plugin implements c {
    public static final String TAG = "MicroMsg.Plugin";

    public Plugin() {
        x.d(TAG, "initLoctionInit");
    }

    public n createApplication() {
        return null;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ar createSubCore() {
        return null;
    }
}
