package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class JsApiStartRecordVoice extends a {
    public static final int CTRL_INDEX = 31;
    public static final String NAME = "startRecord";
    static volatile String fJc = null;
    private p fID;
    private int fIE;
    private StartRecordVoice fJd;

    public final void a(final l lVar, final JSONObject jSONObject, final int i) {
        boolean z;
        int i2 = 60;
        int i3 = 600;
        com.tencent.mm.plugin.appbrand.a.a(lVar.mAppId, new android.support.v4.app.a.a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                if (i == 116) {
                    if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        lVar.E(i, JsApiStartRecordVoice.this.f("fail:system permission denied", null));
                    } else {
                        JsApiStartRecordVoice.this.a(lVar, jSONObject, i);
                    }
                }
            }
        });
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            z = false;
        } else {
            z = com.tencent.mm.pluginsdk.permission.a.a(c, "android.permission.RECORD_AUDIO", 116, "", "");
            if (z) {
                com.tencent.mm.plugin.appbrand.a.pZ(lVar.mAppId);
            }
        }
        if (z) {
            this.fID = d(lVar);
            if (this.fID == null) {
                lVar.E(i, f("fail", null));
                return;
            }
            int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 60);
            if (optInt <= 0) {
                x.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
            } else {
                i2 = optInt;
            }
            if (i2 > 600) {
                x.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", new Object[]{Integer.valueOf(600)});
            } else {
                i3 = i2;
            }
            this.fID.a(new 1(this, lVar));
            this.fID.a(new e() {
                public final void onDestroy() {
                    JsApiStopRecordVoice.h(lVar);
                    JsApiStartRecordVoice.this.fID.b(this);
                }
            });
            this.fJd = new StartRecordVoice(this, lVar, i3, i);
            fJc = StartRecordVoice.a(this.fJd);
            AppBrandMainProcessService.a(this.fJd);
            cK(true);
            return;
        }
        lVar.E(i, f("fail", null));
    }

    private void cK(boolean z) {
        if (this.fID != null) {
            if (!ah.isMainThread()) {
                ah.A(new 3(this, z));
            } else if (z) {
                this.fIE = com.tencent.mm.plugin.appbrand.page.a.t(this.fID.fdO).a(com.tencent.mm.plugin.appbrand.page.a.a.glN);
                k.qv(this.fID.mAppId).fdJ = this.fIE;
            } else {
                com.tencent.mm.plugin.appbrand.page.a.t(this.fID.fdO).ln(this.fIE);
            }
        }
    }
}
