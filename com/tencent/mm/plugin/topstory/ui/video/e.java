package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.topstory.a.c;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.sdk.platformtools.ad;

public final class e {
    a hKh = new 1(this);
    public boolean ozV = false;
    c ozW;
    int ozX = bIa();

    public e() {
        g.Eh().a(this.hKh);
    }

    public final boolean aEY() {
        return this.ozX == 1;
    }

    public final boolean bHZ() {
        return this.ozX == 2;
    }

    public final boolean isConnected() {
        return this.ozX != 0;
    }

    static int bIa() {
        if (!com.tinkerboots.sdk.b.a.isConnected(ad.getContext())) {
            return 0;
        }
        if (!com.tinkerboots.sdk.b.a.isWifi(ad.getContext())) {
            return 2;
        }
        if (((PluginTopStoryUI) g.n(PluginTopStoryUI.class)).getTopStoryCommand().ozr) {
            return 2;
        }
        return 1;
    }
}
