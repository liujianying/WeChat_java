package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.record.b.m;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e implements b {
    RecordVoiceBaseView mtK;
    private m mts = new m();

    public final View eb(Context context) {
        View inflate = View.inflate(context, R.i.record_listitem_voice, null);
        ((RecordVoiceBaseView) inflate.findViewById(R.h.voice_player)).setVoiceHelper(this.mts);
        return inflate;
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        View findViewById = view.findViewById(R.h.empty_voice);
        this.mtK = (RecordVoiceBaseView) view.findViewById(R.h.voice_player);
        if (bVar.bjS == 0) {
            this.mtK.setVisibility(8);
            findViewById.setVisibility(0);
        } else if (bVar.bjS == 1) {
            findViewById.setVisibility(8);
            this.mtK.setVisibility(0);
            String a = com.tencent.mm.plugin.record.b.b.a(bVar);
            fz fzVar = new fz();
            fzVar.bOL.type = 17;
            fzVar.bOL.bON = bVar.bOz;
            a.sFg.m(fzVar);
            int i2 = fzVar.bOM.ret;
            if (!com.tencent.mm.a.e.cn(a)) {
                if (bi.oW(bVar.bOz.rzo)) {
                    findViewById.setVisibility(0);
                    this.mtK.setVisibility(8);
                } else {
                    x.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", new Object[]{Long.valueOf(bVar.msw.field_localId), bVar.bOz.rzo});
                    fz fzVar2 = new fz();
                    fzVar2.bOL.type = 16;
                    fzVar2.bOL.bJA = bVar.msw.field_localId;
                    a.sFg.m(fzVar2);
                }
            }
            RecordVoiceBaseView recordVoiceBaseView = this.mtK;
            int i3 = bVar.bOz.duration;
            recordVoiceBaseView.path = bi.aG(a, "");
            recordVoiceBaseView.bOS = i2;
            if (recordVoiceBaseView.duration != i3) {
                recordVoiceBaseView.duration = i3;
                recordVoiceBaseView.setText(((int) q.bD((long) i3)) + "''");
            }
        }
    }

    public final void destroy() {
        m mVar = this.mts;
        mVar.stopPlay();
        mVar.aux();
        m.hlW = null;
        mVar.cWy.clear();
    }

    public final void pause() {
        if (this.mts != null && this.mts.cWy.size() > 0) {
            for (m.a onFinish : this.mts.cWy) {
                onFinish.onFinish();
            }
        }
    }
}
