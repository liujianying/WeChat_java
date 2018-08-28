package com.tencent.mm.plugin.topstory.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.x;

class PluginTopStoryUI$2 implements Runnable {
    final /* synthetic */ PluginTopStoryUI ozp;

    PluginTopStoryUI$2(PluginTopStoryUI pluginTopStoryUI) {
        this.ozp = pluginTopStoryUI;
    }

    public final void run() {
        ((i) g.l(i.class)).FW().Yp("topstoryapp");
        x.i("MicroMsg.TopStory.PluginTopStoryUI", "Delete TopStory Conversation Entry");
    }
}
