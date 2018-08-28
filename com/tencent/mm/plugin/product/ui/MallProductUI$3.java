package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.product.b.m;
import java.util.ArrayList;
import java.util.Iterator;

class MallProductUI$3 implements OnItemClickListener {
    final /* synthetic */ MallProductUI lUa;

    MallProductUI$3(MallProductUI mallProductUI) {
        this.lUa = mallProductUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar = (b) view.getTag();
        switch (bVar.type) {
            case 2:
                m mVar = this.lUa.lSG.lQL;
                if (mVar.lRp.lRD != null && mVar.lRp.lRD.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = mVar.lRp.lRD.iterator();
                    while (it.hasNext()) {
                        arrayList.add((String) it.next());
                    }
                    bVar.lSn = arrayList;
                    break;
                }
        }
        MallProductUI.f(this.lUa).a(this.lUa, view, i);
    }
}
