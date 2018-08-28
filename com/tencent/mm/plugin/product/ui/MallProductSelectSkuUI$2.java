package com.tencent.mm.plugin.product.ui;

import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.sdk.platformtools.x;

class MallProductSelectSkuUI$2 implements OnItemClickListener {
    final /* synthetic */ MallProductSelectSkuUI lTq;

    MallProductSelectSkuUI$2(MallProductSelectSkuUI mallProductSelectSkuUI) {
        this.lTq = mallProductSelectSkuUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar = null;
        Pair pair = (Pair) view.getTag();
        MallProductSelectSkuUI mallProductSelectSkuUI = this.lTq;
        c b = MallProductSelectSkuUI.b(this.lTq);
        String str = (String) pair.first;
        String str2 = (String) pair.second;
        x.d("MicroMsg.MallProductManager", "selectSkuInfo (" + str + " , " + str2 + ")");
        if (b.lQX.containsKey(str) && ((String) b.lQX.get(str)).equals(str2)) {
            b.lQX.remove(str);
            b.lQP = c.I(b.lQX);
            b.lRa = b.lQW != null ? (e) b.lQW.get(b.lQP) : null;
        } else {
            b.lQX.put(str, str2);
            b.lQP = c.I(b.lQX);
            x.d("MicroMsg.MallProductManager", "getSkuInfoId (" + b.lQP + ")");
            if (b.lQW != null) {
                b.lRa = (e) b.lQW.get(b.lQP);
            }
            MallProductSelectSkuUI.a(mallProductSelectSkuUI, eVar);
            MallProductSelectSkuUI.a(this.lTq);
        }
        b.bmX();
        eVar = b.lRa;
        MallProductSelectSkuUI.a(mallProductSelectSkuUI, eVar);
        MallProductSelectSkuUI.a(this.lTq);
    }
}
