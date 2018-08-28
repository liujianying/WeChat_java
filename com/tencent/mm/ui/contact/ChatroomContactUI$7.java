package com.tencent.mm.ui.contact;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;

class ChatroomContactUI$7 implements a {
    final /* synthetic */ ChatroomContactUI uiv;

    ChatroomContactUI$7(ChatroomContactUI chatroomContactUI) {
        this.uiv = chatroomContactUI;
    }

    public final void WY() {
    }

    public final void WZ() {
    }

    public final void pk(String str) {
        x.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", new Object[]{str});
        ChatroomContactUI.a(this.uiv, ai.oU(str));
    }

    public final void WW() {
    }

    public final void WX() {
    }

    public final void Uq() {
        x.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
        this.uiv.YC();
    }

    public final void Ur() {
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
        x.v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
        Intent intent;
        if (z) {
            intent = new Intent(this.uiv.mController.tml, VoiceSearchResultUI.class);
            intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
            intent.putExtra("VoiceSearchResultUI_VoiceId", j);
            intent.putExtra("VoiceSearchResultUI_ShowType", i);
            this.uiv.mController.tml.startActivity(intent);
            return;
        }
        intent = new Intent(this.uiv.mController.tml, VoiceSearchResultUI.class);
        intent.putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
        intent.putExtra("VoiceSearchResultUI_Error", this.uiv.mController.tml.getString(R.l.fmt_iap_err));
        intent.putExtra("VoiceSearchResultUI_VoiceId", j);
        intent.putExtra("VoiceSearchResultUI_ShowType", i);
        this.uiv.mController.tml.startActivity(intent);
    }

    public final boolean pj(String str) {
        return false;
    }
}
