package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a {
    WeakReference<b> tYP = null;

    public interface b {
        void a(View view, a aVar);

        void ay(LinkedList<String> linkedList);
    }

    abstract CharSequence a(Map<String, String> map, String str, WeakReference<Context> weakReference);

    abstract String cxK();

    public a(b bVar) {
        Assert.assertNotNull(bVar);
        this.tYP = new WeakReference(bVar);
        ((e) g.l(e.class)).a(cxK(), new 1(this));
    }

    public final void release() {
        ((e) g.l(e.class)).Gs(cxK());
    }
}
