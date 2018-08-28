package com.tencent.mm.ui;

import com.tencent.mm.pluginsdk.model.app.f;
import java.util.Comparator;
import java.util.List;

class Sort3rdAppUI$3 implements Comparator<f> {
    final /* synthetic */ Sort3rdAppUI tqr;
    final /* synthetic */ List tqs;

    Sort3rdAppUI$3(Sort3rdAppUI sort3rdAppUI, List list) {
        this.tqr = sort3rdAppUI;
        this.tqs = list;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return this.tqs.indexOf(((f) obj2).field_appId) - this.tqs.indexOf(((f) obj).field_appId);
    }
}
