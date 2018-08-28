package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class e$3 implements OnClickListener {
    final /* synthetic */ e qsJ;

    public e$3(e eVar) {
        this.qsJ = eVar;
    }

    public final void onClick(View view) {
        x.i("NoteSelectManager", "cut");
        if (!e.cD() || !e.k(this.qsJ)) {
            x.e("NoteSelectManager", "cut: not init or not editable");
            this.qsJ.cav();
        } else if (!e.l(this.qsJ)) {
            this.qsJ.cav();
            int cao = this.qsJ.cao();
            ArrayList arrayList;
            if (cao == 2) {
                Object a = e.a(this.qsJ, true, null, "");
                if (bi.K(a)) {
                    x.e("NoteSelectManager", "cut: selectedSpan is null or empty");
                    e.h(this.qsJ);
                    return;
                }
                h hVar = new h();
                hVar.content = b.a(a);
                hVar.qoJ = -1;
                hVar.qoH = false;
                arrayList = new ArrayList();
                arrayList.add(hVar);
                f.c(ad.getContext(), arrayList);
            } else if (cao == 3) {
                arrayList = e.b(this.qsJ, true, null, "");
                if (arrayList == null || arrayList.size() <= 0) {
                    x.e("NoteSelectManager", "cut: dataList is null or empty");
                    e.h(this.qsJ);
                    return;
                }
                f.c(ad.getContext(), arrayList);
            } else {
                x.e("NoteSelectManager", "cut: not in select");
                e.h(this.qsJ);
            }
        } else if (e.m(this.qsJ) != null) {
            e.m(this.qsJ).bZp();
        }
    }
}
