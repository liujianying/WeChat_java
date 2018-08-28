package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.p.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.s;

class FavVoiceBaseView$2 implements OnClickListener {
    final /* synthetic */ FavVoiceBaseView jaI;

    FavVoiceBaseView$2(FavVoiceBaseView favVoiceBaseView) {
        this.jaI = favVoiceBaseView;
    }

    public final void onClick(View view) {
        if (!a.by(view.getContext()) && !a.bw(view.getContext())) {
            if (!f.zZ() && !bi.oW(FavVoiceBaseView.g(this.jaI))) {
                s.gH(view.getContext());
            } else if (!bi.aG(FavVoiceBaseView.g(this.jaI), "").equals(FavVoiceBaseView.h(this.jaI).path)) {
                FavVoiceBaseView.i(this.jaI);
            } else if (FavVoiceBaseView.h(this.jaI).aLq()) {
                this.jaI.aLs();
            } else if (!FavVoiceBaseView.j(this.jaI)) {
                FavVoiceBaseView.i(this.jaI);
            }
        }
    }
}
