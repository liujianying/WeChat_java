package com.tencent.mm.plugin.messenger;

import com.tencent.mm.plugin.messenger.a.e$a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class PluginMessenger$5 implements e$a {
    final /* synthetic */ PluginMessenger lbI;

    PluginMessenger$5(PluginMessenger pluginMessenger) {
        this.lbI = pluginMessenger;
    }

    public final String h(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String aG = bi.aG((String) map.get(str + ".separator"), "、");
        int i = 0;
        while (true) {
            int i2 = i;
            String str2 = str + ".memberlist.member" + (i2 != 0 ? Integer.valueOf(i2) : "");
            if (map.get(str2) == null) {
                return stringBuilder.toString();
            }
            if (i2 != 0) {
                stringBuilder.append(aG);
            }
            str2 = (String) map.get(str2 + ".nickname");
            if (bi.oW(str2)) {
                x.w("MicroMsg.PluginMessenger", "hy: can not resolve username or nickname");
            } else {
                stringBuilder.append(str2);
            }
            i = i2 + 1;
        }
    }
}
