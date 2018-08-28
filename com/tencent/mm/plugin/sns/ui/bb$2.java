package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.ui.tools.a.a;

class bb$2 implements a {
    final /* synthetic */ bb ogl;

    bb$2(bb bbVar) {
        this.ogl = bbVar;
    }

    public final String NT(String str) {
        return af.getAccSnsTmpPath() + g.u((this.ogl.filePath + System.currentTimeMillis()).getBytes());
    }
}
