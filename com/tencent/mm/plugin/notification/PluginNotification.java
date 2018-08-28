package com.tencent.mm.plugin.notification;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.notification.b.a;

public class PluginNotification extends f implements a {
    private al lHs;

    public void execute(g gVar) {
    }

    public void setNotification(al alVar) {
        this.lHs = alVar;
        b.lHh = alVar;
    }

    public al getNotification() {
        return this.lHs;
    }
}
