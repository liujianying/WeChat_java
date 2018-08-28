package com.tencent.mm.plugin.topstory;

import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.io.File;

class PluginTopStory$a implements Runnable {
    final /* synthetic */ PluginTopStory oyB;

    private PluginTopStory$a(PluginTopStory pluginTopStory) {
        this.oyB = pluginTopStory;
    }

    /* synthetic */ PluginTopStory$a(PluginTopStory pluginTopStory, byte b) {
        this(pluginTopStory);
    }

    public final void run() {
        x.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard ftsrecommendVideo folder %b", new Object[]{Boolean.valueOf(e.co(com.tencent.mm.compatible.util.e.bnE + "ftsrecommendVideo/"))});
        x.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard topstory folder %b", new Object[]{Boolean.valueOf(e.co(com.tencent.mm.compatible.util.e.bnE + "topstory/"))});
        File file = new File(g.bHB());
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File absolutePath : listFiles) {
                    boolean co = e.co(absolutePath.getAbsolutePath());
                    x.i("MicroMsg.TopStory.PluginTopStory", "Delete Cache File %s %b", new Object[]{absolutePath.getAbsolutePath(), Boolean.valueOf(co)});
                }
            }
            FileOp.mL(g.bHB() + ".nomedia/");
        } else {
            FileOp.mL(g.bHB());
            FileOp.mL(g.bHB() + ".nomedia/");
            x.i("MicroMsg.TopStory.PluginTopStory", "Create TopStoryCacheFolder");
        }
        com.tencent.mm.kernel.g.Ei().DT().a(a.sZF, Long.valueOf(0));
    }
}
