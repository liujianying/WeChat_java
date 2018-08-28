package com.tencent.mm.plugin.websearch;

class PluginWebSearch$a implements Runnable {
    final /* synthetic */ PluginWebSearch pKx;
    boolean pKy;

    PluginWebSearch$a(PluginWebSearch pluginWebSearch, boolean z) {
        this.pKx = pluginWebSearch;
        this.pKy = z;
    }

    public final void run() {
        PluginWebSearch.access$400(this.pKx, this.pKy);
    }
}
