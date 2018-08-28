package com.tencent.mm.plugin.fts;

class PluginFTS$1 implements Runnable {
    final /* synthetic */ PluginFTS jpM;

    PluginFTS$1(PluginFTS pluginFTS) {
        this.jpM = pluginFTS;
    }

    public final void run() {
        if (PluginFTS.access$200(this.jpM) != null) {
            PluginFTS.access$200(this.jpM).rollback();
        }
    }
}
