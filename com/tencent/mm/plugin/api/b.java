package com.tencent.mm.plugin.api;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.j;

public final class b extends com.tencent.mm.plugin.mmsight.api.b {
    private d fam;
    private VideoTransPara fan;

    public final void a(com.tencent.mm.remoteservice.d dVar, VideoTransPara videoTransPara) {
        if (dVar != null) {
            CaptureMMProxy.createProxy(new CaptureMMProxy(dVar));
        }
        j.c(videoTransPara);
        this.fan = videoTransPara;
    }

    public final d ZO() {
        if (this.fan != null) {
            k.bey();
            this.fam = k.d(this.fan);
        }
        return this.fam;
    }
}
