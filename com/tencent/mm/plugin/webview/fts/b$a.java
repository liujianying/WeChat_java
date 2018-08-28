package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.storage.c;

class b$a implements i<Bundle, Bundle> {
    private b$a() {
    }

    public final /* synthetic */ Object av(Object obj) {
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100266");
        int i = fJ.isValid() ? ai.getInt((String) fJ.ckq().get("search_wa_widget_init_out_time"), 8000) : 8000;
        Bundle bundle = new Bundle();
        bundle.putInt("search_wa_widget_init_out_time", i);
        return bundle;
    }
}
