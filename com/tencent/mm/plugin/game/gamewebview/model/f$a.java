package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Bundle;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class f$a implements e, a<Bundle, IPCRunCgiRespWrapper> {
    private c<IPCRunCgiRespWrapper> dmE;

    private f$a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        Bundle bundle = (Bundle) obj;
        au.DF().a(233, this);
        this.dmE = cVar;
        String string = bundle.getString("geta8key_data_req_url");
        if (!bi.oW(bundle.getString("k_share_url"))) {
            al.fn(string, bundle.getString("k_share_url"));
        }
        au.DF().a(!bi.oW(string) ? new h(string, bundle.getString("geta8key_data_username"), bundle.getInt("geta8key_data_scene"), bundle.getInt("geta8key_data_reason"), bundle.getInt("geta8key_data_flag"), bundle.getString("geta8key_data_net_type"), bundle.getInt("geta8key_session_id", 0), "", bundle.getString("key_function_id"), bundle.getInt("key_wallet_region", 0), new byte[0]) : new h(bundle.getString("geta8key_data_appid"), bundle.getString("geta8key_data_scope"), bundle.getString("geta8key_data_state"), bundle.getInt("geta8key_session_id", 0)), 0);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.GameWebViewGetA8KeyHelp", "onSceneEnd");
        au.DF().b(233, this);
        if (this.dmE != null) {
            IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
            iPCRunCgiRespWrapper.errType = i;
            iPCRunCgiRespWrapper.errCode = i2;
            iPCRunCgiRespWrapper.Yy = str;
            iPCRunCgiRespWrapper.diG = (b) lVar.dJd;
            this.dmE.at(iPCRunCgiRespWrapper);
        }
        this.dmE = null;
    }
}
