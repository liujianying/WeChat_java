package com.tencent.mm.plugin.messenger;

import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

class PluginMessenger$3 implements a {
    final /* synthetic */ PluginMessenger lbI;

    PluginMessenger$3(PluginMessenger pluginMessenger) {
        this.lbI = pluginMessenger;
    }

    public final String h(Map<String, String> map, String str) {
        if (map == null) {
            return null;
        }
        return bi.oV((String) map.get(str + ".title"));
    }
}
