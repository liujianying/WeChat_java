package com.tencent.mm.plugin.topstory;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView.c;

class PluginTopStory$4 implements c {
    final /* synthetic */ PluginTopStory oyB;

    PluginTopStory$4(PluginTopStory pluginTopStory) {
        this.oyB = pluginTopStory;
    }

    public final void onCoreInitFinished() {
        x.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFinished");
    }

    public final void uL() {
        x.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFailed");
    }
}
