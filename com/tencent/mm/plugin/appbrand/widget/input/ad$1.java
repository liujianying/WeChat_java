package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.widget.input.ad.a;

class ad$1 extends a<ViewGroup, f> {
    final /* synthetic */ ad gJm;

    ad$1(ad adVar) {
        this.gJm = adVar;
        super((byte) 0);
    }

    final /* synthetic */ View ce(View view) {
        return (f) view.findViewById(g.app_brand_page_input_container);
    }

    final boolean cd(View view) {
        return view.getId() == g.app_brand_page_content;
    }
}
