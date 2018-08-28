package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;

class ConversationWithAppBrandListView$3 implements a {
    final /* synthetic */ ConversationWithAppBrandListView upB;

    ConversationWithAppBrandListView$3(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.upB = conversationWithAppBrandListView;
    }

    public final boolean a(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
        ConversationWithAppBrandListView.f(this.upB).postDelayed(new 1(this, aVar), 666);
        return false;
    }

    public final boolean b(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
        if (!(aVar == null || aVar.gOT == null || aVar.type != 1 || ConversationWithAppBrandListView.e(this.upB) == null)) {
            b e = ConversationWithAppBrandListView.e(this.upB);
            String str = aVar.gOT.appId;
            e.gPb++;
            e.gPe.append(str + ":");
        }
        return false;
    }
}
