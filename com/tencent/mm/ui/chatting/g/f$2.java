package com.tencent.mm.ui.chatting.g;

import android.content.pm.PackageInfo;
import android.view.View;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.y.g$a;

class f$2 implements e {
    final /* synthetic */ f tYA;

    f$2(f fVar) {
        this.tYA = fVar;
    }

    public final void a(int i, b bVar) {
        au.HU();
        bd dW = c.FT().dW(bVar.bJC);
        g$a gp = g$a.gp(dW.field_content);
        String B = p.B(gp.url, "message");
        String B2 = p.B(gp.dwn, "message");
        PackageInfo packageInfo = f.getPackageInfo(this.tYA.mContext, gp.appId);
        this.tYA.a(B, B2, packageInfo == null ? null : packageInfo.versionName, packageInfo == null ? 0 : packageInfo.versionCode, gp.appId, dW.field_msgId, dW.field_msgSvrId, dW);
    }

    public final void a(View view, int i, b bVar) {
        x.i("MicroMsg.MusicHistoryListPresenter", "[onItemLongClick] position:%s", new Object[]{Integer.valueOf(i)});
        new k(view.getContext()).b(view, new 1(this), new 2(this, bVar));
    }
}
