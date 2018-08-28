package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.i;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j$a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;

class VideoAdPlayerUI$4 implements OnClickListener {
    final /* synthetic */ VideoAdPlayerUI oiz;

    VideoAdPlayerUI$4(VideoAdPlayerUI videoAdPlayerUI) {
        this.oiz = videoAdPlayerUI;
    }

    public final void onClick(View view) {
        if (VideoAdPlayerUI.q(this.oiz) != 0) {
            j.a(j$a.DetailInVideo, this.oiz.oij, this.oiz.oii, VideoAdPlayerUI.r(this.oiz), VideoAdPlayerUI.q(this.oiz), VideoAdPlayerUI.s(this.oiz), VideoAdPlayerUI.t(this.oiz), VideoAdPlayerUI.u(this.oiz), VideoAdPlayerUI.v(this.oiz), VideoAdPlayerUI.w(this.oiz), VideoAdPlayerUI.x(this.oiz));
        }
        if (VideoAdPlayerUI.e(this.oiz) != 0) {
            int i = VideoAdPlayerUI.a(this.oiz).njs.nkq;
            if (VideoAdPlayerUI.b(this.oiz) && VideoAdPlayerUI.a(this.oiz).njs.nku != 0) {
                i += (int) (bi.bI(VideoAdPlayerUI.a(this.oiz).njs.nku) / 1000);
            }
            i iVar = new i(13228, "1,1," + i + "," + VideoAdPlayerUI.f(this.oiz) + "," + VideoAdPlayerUI.g(this.oiz) + "," + bi.VE() + "," + VideoAdPlayerUI.h(this.oiz) + "," + VideoAdPlayerUI.i(this.oiz), (int) bi.VE());
            g.Ek();
            g.Eh().dpP.a(iVar, 0);
        }
        this.oiz.finish();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("key_snsad_statextstr", VideoAdPlayerUI.y(this.oiz));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", VideoAdPlayerUI.z(this.oiz));
        intent.putExtra("useJs", true);
        if (VideoAdPlayerUI.A(this.oiz)) {
            c cVar = new c(VideoAdPlayerUI.B(this.oiz), 18, 6, "", 2, VideoAdPlayerUI.C(this.oiz).bAK());
            g.Ek();
            g.Eh().dpP.a(cVar, 0);
        }
        new ag(Looper.getMainLooper()).post(new 1(this, intent));
    }
}
