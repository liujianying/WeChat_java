package com.tencent.mm.plugin.game;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.game.b.a;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements c {
    public n createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ar createSubCore() {
        return new SubCoreGameCenter();
    }
}
