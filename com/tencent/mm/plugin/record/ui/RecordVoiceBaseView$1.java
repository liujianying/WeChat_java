package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.p.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;

class RecordVoiceBaseView$1 implements OnClickListener {
    final /* synthetic */ RecordVoiceBaseView mtt;

    RecordVoiceBaseView$1(RecordVoiceBaseView recordVoiceBaseView) {
        this.mtt = recordVoiceBaseView;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", new Object[]{RecordVoiceBaseView.a(this.mtt), Boolean.valueOf(RecordVoiceBaseView.b(this.mtt).aLq())});
        if (!a.by(RecordVoiceBaseView.c(this.mtt)) && !a.bw(RecordVoiceBaseView.c(this.mtt))) {
            if (!f.zZ() && !bi.oW(RecordVoiceBaseView.a(this.mtt))) {
                s.gH(view.getContext());
            } else if (!bi.aG(RecordVoiceBaseView.a(this.mtt), "").equals(RecordVoiceBaseView.b(this.mtt).path)) {
                RecordVoiceBaseView.d(this.mtt);
            } else if (RecordVoiceBaseView.b(this.mtt).aLq()) {
                this.mtt.stopPlay();
            } else if (!RecordVoiceBaseView.e(this.mtt)) {
                RecordVoiceBaseView.d(this.mtt);
            }
        }
    }
}
