package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.ax.a;
import com.tencent.mm.g.a.jf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class m implements a {
    Activity bOb;
    c ifd = null;
    IdleHandler tjO;
    Runnable uhD = new 10(this);
    g unL;
    ConversationWithAppBrandListView uqX;
    c uru = null;
    c urv = null;

    /* renamed from: com.tencent.mm.ui.conversation.m$5 */
    class AnonymousClass5 extends c<jf> {
        final /* synthetic */ ConversationWithAppBrandListView urz;

        AnonymousClass5(ConversationWithAppBrandListView conversationWithAppBrandListView) {
            this.urz = conversationWithAppBrandListView;
            this.sFo = jf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (this.urz != null) {
                this.urz.setSelection(0);
            }
            return false;
        }
    }

    public final void p(String str, String str2, String str3) {
        if (this.unL != null) {
            this.unL.notifyDataSetChanged();
        }
    }
}
