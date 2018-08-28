package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bp.a;
import com.tencent.mm.ui.widget.picker.b;
import java.util.ArrayList;

class WxaLuckyMoneyPrepareUI$16 implements OnClickListener {
    final /* synthetic */ ArrayList kAt;
    final /* synthetic */ WxaLuckyMoneyPrepareUI kMq;

    WxaLuckyMoneyPrepareUI$16(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI, ArrayList arrayList) {
        this.kMq = wxaLuckyMoneyPrepareUI;
        this.kAt = arrayList;
    }

    public final void onClick(View view) {
        b bVar = new b(this.kMq.mController.tml, this.kAt);
        bVar.GC(WxaLuckyMoneyPrepareUI.f(this.kMq));
        bVar.uLl = new 1(this, bVar);
        bVar.GB(a.fromDPToPix(this.kMq.mController.tml, 288));
        bVar.show();
    }
}
