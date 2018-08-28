package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@a
class URISpanHandlerSet$EmotionStoreUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$EmotionStoreUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (!str.trim().startsWith("weixin://emoticonstore/")) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("/");
        Object obj = "";
        if (lastIndexOf != -1) {
            obj = str.substring(lastIndexOf + 1);
        }
        return new m(str, 29, obj);
    }

    final int[] vB() {
        return new int[]{29};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 29) {
            return false;
        }
        if (gVar != null) {
            gVar.a(mVar);
        }
        Intent intent = new Intent();
        intent.putExtra("download_entrance_scene", 21);
        intent.putExtra("extra_id", (String) mVar.F(String.class));
        intent.putExtra("preceding_scence", 3);
        d.b(URISpanHandlerSet.a(this.bAt), "emoji", ".ui.EmojiStoreDetailUI", intent);
        if (gVar != null) {
            gVar.b(mVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        return false;
    }
}
