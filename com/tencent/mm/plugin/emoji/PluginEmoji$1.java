package com.tencent.mm.plugin.emoji;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.b.a;
import com.tencent.mm.ui.e.b.b;

class PluginEmoji$1 implements b {
    final /* synthetic */ PluginEmoji icR;

    PluginEmoji$1(PluginEmoji pluginEmoji) {
        this.icR = pluginEmoji;
    }

    public final a cq(String str, String str2) {
        try {
            return com.tencent.mm.plugin.gif.b.aVQ().dj(str, str2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PluginEmoji", e, "", new Object[0]);
            return null;
        }
    }
}
