package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class AppBrandLivePusherView extends TXCloudVideoView {
    m fRF;
    private ITXLivePushListener fRG;

    public AppBrandLivePusherView(Context context) {
        super(context);
        init(context);
    }

    public AppBrandLivePusherView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public final void u(Bundle bundle) {
        j jVar;
        m mVar = this.fRF;
        if (bundle == null) {
            jVar = new j(-1, "invalid params");
        } else {
            m.d("updateLivePusher", bundle);
            if (mVar.dni) {
                mVar.c(bundle, false);
                String string = bundle.getString("pushUrl", mVar.fSm);
                if (!(string == null || string.isEmpty() || mVar.fSm == null || mVar.fSm.equalsIgnoreCase(string) || !mVar.fSk.isPushing())) {
                    x.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
                    mVar.fSk.stopCameraPreview(true);
                    mVar.fSk.stopPusher();
                }
                mVar.fSm = string;
                mVar.fSq = bundle.getBoolean("autopush", mVar.fSq);
                if (!(!mVar.fSq || mVar.fSm == null || mVar.fSm.isEmpty() || mVar.fSk.isPushing())) {
                    x.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
                    mVar.fRV.setVisibility(0);
                    if (mVar.fSv) {
                        mVar.fSk.startCameraPreview(mVar.fRV);
                    }
                    mVar.fSk.startPusher(mVar.fSm);
                }
                jVar = new j();
            } else {
                jVar = new j(-3, "uninited livePusher");
            }
        }
        x.i("MicroMsg.AppBrandLivePusherView", "onUpdate code:%d info:%s", new Object[]{Integer.valueOf(jVar.errorCode), jVar.fRT});
    }

    public final boolean tB(String str) {
        x.i("MicroMsg.AppBrandLivePusherView", "onOperate code:%d info:%s", new Object[]{Integer.valueOf(r2.errorCode), this.fRF.tD(str).fRT});
        if (this.fRF.tD(str).errorCode == 0) {
            return true;
        }
        return false;
    }

    public final void ua() {
        j jVar;
        m mVar = this.fRF;
        if (mVar.dni) {
            mVar.fSk.stopCameraPreview(true);
            mVar.fSk.stopPusher();
            mVar.fSk.setPushListener(null);
            jVar = new j();
        } else {
            jVar = new j(-3, "uninited livePusher");
        }
        x.i("MicroMsg.AppBrandLivePusherView", "onDestroy code:%d info:%s", new Object[]{Integer.valueOf(jVar.errorCode), jVar.fRT});
    }

    public void setOnPushEventListener(ITXLivePushListener iTXLivePushListener) {
        this.fRG = iTXLivePushListener;
        this.fRF.fSl = this.fRG;
    }

    public void setSnapshotListener(ITXSnapshotListener iTXSnapshotListener) {
        this.fRF.fSp = iTXSnapshotListener;
    }

    private void init(Context context) {
        this.fRF = new m(context);
        setBackgroundColor(-16777216);
    }
}
