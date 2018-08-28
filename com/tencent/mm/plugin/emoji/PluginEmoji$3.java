package com.tencent.mm.plugin.emoji;

import android.content.Context;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.n;
import com.tencent.mm.api.o.a;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.view.SmileyPanelImpl;

class PluginEmoji$3 implements a {
    final /* synthetic */ PluginEmoji icR;

    PluginEmoji$3(PluginEmoji pluginEmoji) {
        this.icR = pluginEmoji;
    }

    public final SmileyPanel aS(Context context) {
        return new SmileyPanelImpl(context);
    }

    public final n ur() {
        return new k();
    }
}
