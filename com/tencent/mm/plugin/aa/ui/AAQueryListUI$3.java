package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class AAQueryListUI$3 implements OnItemClickListener {
    final /* synthetic */ AAQueryListUI eCd;

    AAQueryListUI$3(AAQueryListUI aAQueryListUI) {
        this.eCd = aAQueryListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (AAQueryListUI.f(this.eCd) != null) {
            if (i < 0 || i >= AAQueryListUI.f(this.eCd).getCount()) {
                x.i("MicroMsg.AAQueryListUI", "click out of bound! %s", Integer.valueOf(i));
                return;
            }
            int top = view.getTop();
            k kVar = (k) AAQueryListUI.f(this.eCd).getItem(i);
            if (kVar != null) {
                if (!bi.oW(kVar.qYo)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", kVar.qYo);
                    d.b(this.eCd, "webview", ".ui.tools.WebViewUI", intent);
                } else if (!bi.oW(kVar.qYc)) {
                    String str = null;
                    if (kVar.qYn == 2) {
                        str = q.GF();
                    }
                    Intent intent2 = new Intent(this.eCd, PaylistAAUI.class);
                    intent2.putExtra("bill_no", kVar.qYc);
                    intent2.putExtra("launcher_user_name", str);
                    intent2.putExtra("enter_scene", 4);
                    intent2.putExtra("chatroom", kVar.qYd);
                    intent2.putExtra("item_position", i);
                    intent2.putExtra("item_offset", top);
                    this.eCd.startActivityForResult(intent2, 1);
                }
            }
        }
        h.mEJ.h(13721, Integer.valueOf(5), Integer.valueOf(3));
    }
}
