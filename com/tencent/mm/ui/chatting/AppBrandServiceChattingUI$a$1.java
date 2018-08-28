package com.tencent.mm.ui.chatting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes$b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;

class AppBrandServiceChattingUI$a$1 implements d {
    final /* synthetic */ a tGQ;

    AppBrandServiceChattingUI$a$1(a aVar) {
        this.tGQ = aVar;
    }

    public final boolean kS(boolean z) {
        if (a.a(this.tGQ) != null) {
            WxaAttributes$b.a aVar = (WxaAttributes$b.a) a.a(this.tGQ).frZ.get(0);
            if (a.b(this.tGQ) == 2 && a.c(this.tGQ).username.equals(aVar.userName)) {
                x.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", new Object[]{aVar.userName, aVar.bGH});
                a.a(this.tGQ, aVar.bGH);
            } else {
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1080;
                ((com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(this.tGQ.getContext(), aVar.userName, "", 0, aVar.version, aVar.bGH, appBrandStatObject, a.d(this.tGQ));
            }
        } else {
            x.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
        }
        return true;
    }
}
