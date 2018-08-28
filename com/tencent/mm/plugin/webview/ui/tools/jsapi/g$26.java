package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class g$26 extends c<jt> {
    final /* synthetic */ g qiK;

    g$26(g gVar) {
        this.qiK = gVar;
        this.sFo = jt.class.getName().hashCode();
    }

    private boolean a(jt jtVar) {
        x.i("MicroMsg.MsgHandler", "backgroundAudioListener callback in, state:%s", new Object[]{jtVar.bTE.state});
        int i = (int) (jtVar.bTE.duration / 1000);
        if (jtVar.bTE.bTG) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("background_audio_state_player_state", r2);
                bundle.putInt("background_audio_state_player_duration", i);
                if (jtVar.bTE.bTy != null) {
                    bundle.putString("background_audio_state_player_src", jtVar.bTE.bTy.rYp);
                    bundle.putString("background_audio_state_player_src_id", jtVar.bTE.bTy.eaZ);
                }
                bundle.putInt("background_audio_state_player_err_code", jtVar.bTE.errCode);
                String str = "";
                if (!TextUtils.isEmpty(jtVar.bTE.Yy)) {
                    str = jtVar.bTE.Yy;
                }
                bundle.putString("background_audio_state_player_err_msg", str);
                if (g.D(this.qiK) != null) {
                    x.i("MicroMsg.MsgHandler", "onBackgroundAudioStateChange");
                    g.D(this.qiK).c(2100, bundle);
                } else {
                    x.e("MicroMsg.MsgHandler", "backgroundAudioListener callbacker is null");
                }
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.MsgHandler", e.getMessage());
                return false;
            }
        }
        x.e("MicroMsg.MsgHandler", "is not from QQMusicPlayer, don't callback!");
        return false;
    }
}
