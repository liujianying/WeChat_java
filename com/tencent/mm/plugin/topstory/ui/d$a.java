package com.tencent.mm.plugin.topstory.ui;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.f.h;
import java.io.File;

class d$a implements Runnable {
    String ozu;

    public d$a(String str) {
        this.ozu = str;
    }

    public final void run() {
        File file = new File(e.bnE + "topstory/trace.info");
        if (file.exists() && file.length() > 2048) {
            file.delete();
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        this.ozu = "Trace:\n" + h.h("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000) + "\n" + this.ozu;
        com.tencent.mm.a.e.e(file.getAbsolutePath(), this.ozu.getBytes());
    }
}
