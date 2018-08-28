package com.tencent.mm.plugin.topstory;

import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.cdndownloader.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b.d;
import com.tencent.xweb.r;

public class PluginTopStory extends f implements b, c, com.tencent.mm.plugin.topstory.a.b {
    private a oyA;
    private c oyy;
    private b oyz;

    public void execute(g gVar) {
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(e.c cVar) {
        this.oyy = new c();
        this.oyz = new b();
        this.oyA = new a();
        com.tencent.mm.sdk.f.e.post(new a(this, (byte) 0), "TopStory.InitTopStoryCacheFolderTask");
        preInitXWebView();
    }

    public void onAccountRelease() {
        if (this.oyy != null) {
            c cVar = this.oyy;
            cVar.oyH.removeCallbacksAndMessages(null);
            cVar.oyH.getLooper().quit();
            this.oyy = null;
        }
        if (this.oyz != null) {
            ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.oyz.oyE);
            this.oyz = null;
        }
        if (this.oyA != null) {
            this.oyA.oyC.clear();
            this.oyA = null;
        }
    }

    public void onVideoListUICreate() {
    }

    public void onVideoListUIDestroy(bth bth) {
    }

    public void onVideoListUIPause() {
    }

    public void onVideoListUIResume() {
    }

    public c getReporter() {
        return this.oyy;
    }

    public b getRedDotMgr() {
        return this.oyz;
    }

    public a getPerformTracer() {
        return this.oyA;
    }

    private void preInitXWebView() {
        r.a(ad.getContext(), new 1(this), new 2(this), new 3(this));
        d.a(a.aAr());
        if (com.tencent.mm.sdk.platformtools.e.chv()) {
            com.tencent.xweb.x5.sdk.d.forceSysWebView();
        }
        WebView.initWebviewCore(ad.getContext(), WebView.d.vAQ, "mm", new 4(this));
        x.i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", new Object[]{r0.name()});
    }
}
