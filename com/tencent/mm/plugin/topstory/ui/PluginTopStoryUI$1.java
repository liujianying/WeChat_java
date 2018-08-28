package com.tencent.mm.plugin.topstory.ui;

import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class PluginTopStoryUI$1 implements Runnable {
    final /* synthetic */ PluginTopStoryUI ozp;

    PluginTopStoryUI$1(PluginTopStoryUI pluginTopStoryUI) {
        this.ozp = pluginTopStoryUI;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            TopStoryWebView topStoryWebView = new TopStoryWebView(ad.getContext());
        } catch (Exception e) {
        }
        x.i("MicroMsg.TopStory.PluginTopStoryUI", "Create TopStoryWebView Use Time %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        PluginTopStoryUI.access$002(this.ozp, 1);
    }
}
