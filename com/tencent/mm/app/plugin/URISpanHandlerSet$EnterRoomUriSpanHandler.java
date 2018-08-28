package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.chatting.ChattingUI;

@a
class URISpanHandlerSet$EnterRoomUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$EnterRoomUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        return null;
    }

    final int[] vB() {
        return new int[0];
    }

    final boolean a(m mVar, g gVar) {
        return false;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        if (str.startsWith("weixin://jump/mainframe/")) {
            int lastIndexOf = str.trim().lastIndexOf("/");
            if (lastIndexOf >= 0 && lastIndexOf < str.trim().length() - 1) {
                String substring = str.trim().substring(lastIndexOf + 1);
                if (com.tencent.mm.model.s.fq(substring)) {
                    au.HU();
                    ab Yg = c.FR().Yg(substring);
                    if (Yg == null || ((int) Yg.dhP) == 0) {
                        Yg = new ab();
                        Yg.setUsername(substring);
                        au.HU();
                        c.FR().T(Yg);
                    }
                }
                Intent putExtra = new Intent(URISpanHandlerSet.a(this.bAt), ChattingUI.class).putExtra("Chat_User", substring).putExtra("Chat_Mode", 1);
                if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
                    putExtra.addFlags(268435456);
                }
                URISpanHandlerSet.a(this.bAt).startActivity(putExtra);
                return true;
            }
        }
        return false;
    }
}
