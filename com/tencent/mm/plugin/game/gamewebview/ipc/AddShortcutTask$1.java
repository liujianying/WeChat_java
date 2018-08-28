package com.tencent.mm.plugin.game.gamewebview.ipc;

import com.tencent.mm.plugin.base.model.d.a;

class AddShortcutTask$1 implements a {
    final /* synthetic */ AddShortcutTask jGb;

    AddShortcutTask$1(AddShortcutTask addShortcutTask) {
        this.jGb = addShortcutTask;
    }

    public final void dF(boolean z) {
        this.jGb.success = z;
        this.jGb.ahH();
    }
}
