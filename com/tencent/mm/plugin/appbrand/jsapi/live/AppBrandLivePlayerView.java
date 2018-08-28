package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class AppBrandLivePlayerView extends TXCloudVideoView {
    l fRA;
    a fRB;
    private b fRC;
    int fRD;
    boolean fRE;

    public AppBrandLivePlayerView(Context context) {
        super(context);
        init(context);
    }

    public AppBrandLivePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public final void ua() {
        j jVar;
        l lVar = this.fRA;
        if (lVar.dni) {
            lVar.fRX.stopPlay(true);
            lVar.fRX.setPlayListener(null);
            jVar = new j();
        } else {
            jVar = new j(-3, "uninited livePlayer");
        }
        x.i("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", new Object[]{Integer.valueOf(jVar.errorCode), jVar.fRT});
    }

    public void setNeedEvent(boolean z) {
        this.fRE = z;
    }

    public void setPlayEventListener(ITXLivePlayListener iTXLivePlayListener) {
        this.fRA.fRY = iTXLivePlayListener;
    }

    public void setFullScreenDelegate(a aVar) {
        this.fRB = aVar;
    }

    public void setOnFullScreenChangeListener(b bVar) {
        this.fRC = bVar;
    }

    final void cP(boolean z) {
        if (this.fRE && this.fRC != null) {
            this.fRC.e(z, this.fRD);
        }
    }

    private void init(Context context) {
        this.fRA = new l(context);
    }
}
