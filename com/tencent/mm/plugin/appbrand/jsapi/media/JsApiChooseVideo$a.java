package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessRequest;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseRequest;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseResult;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.util.List;

final class JsApiChooseVideo$a extends AppBrandProxyUIProcessTask {
    private ChooseResult fUS = new ChooseResult();
    private ChooseRequest fUT;
    private p fUo;
    private OnCancelListener fUp;
    private String mVideoFilePath;

    private JsApiChooseVideo$a() {
    }

    protected final void a(AppBrandProxyUIProcessTask$ProcessRequest appBrandProxyUIProcessTask$ProcessRequest) {
        boolean z;
        this.fUT = (ChooseRequest) appBrandProxyUIProcessTask$ProcessRequest;
        this.fUT.maxDuration = Math.min(Math.max(this.fUT.maxDuration, 60), 0);
        if (bi.fQ(ahw()) > 200) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            s.makeText(ahw(), ad.getResources().getString(j.app_brand_choose_media_video_processing), 1).show();
        }
        ahw().geJ = this;
        Intent intent = new Intent();
        intent.putExtra("key_send_raw_image", false);
        intent.putExtra("query_media_type", 2);
        if (this.fUT.fUg && this.fUT.fUh) {
            this.mVideoFilePath = e.dgl + "microMsg." + System.currentTimeMillis() + ".mp4";
            intent.putExtra("record_video_force_sys_camera", true);
            intent.putExtra("record_video_quality", 1);
            intent.putExtra("record_video_time_limit", this.fUT.maxDuration);
            intent.putExtra("video_full_path", this.mVideoFilePath);
            l.c(ahw(), 1, 7, intent);
        } else if (this.fUT.fUg) {
            this.mVideoFilePath = e.dgl + "microMsg." + System.currentTimeMillis() + ".mp4";
            l.a(ahw(), this.mVideoFilePath, 5, this.fUT.maxDuration, 1, false);
        } else if (this.fUT.fUh) {
            intent.putExtra("show_header_view", false);
            l.c(ahw(), 1, 7, intent);
        } else {
            this.fUS.bjW = -2;
            a(this.fUS);
        }
    }

    protected final void ahC() {
        super.ahC();
        if (this.fUo != null) {
            this.fUo.dismiss();
            this.fUo = null;
        }
    }

    private void ajp() {
        this.fUp = new 1(this);
        MMActivity ahw = ahw();
        ad.getResources().getString(j.app_tip);
        this.fUo = h.a(ahw, ad.getResources().getString(j.app_brand_choose_media_video_processing), true, this.fUp);
    }

    public final void b(int i, int i2, Intent intent) {
        if (i2 == 0) {
            this.fUS.bjW = 0;
            a(this.fUS);
        } else if (-1 != i2) {
            this.fUS.bjW = -2;
            a(this.fUS);
        } else {
            switch (i) {
                case 4:
                    List stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                    if (!bi.cX(stringArrayListExtra)) {
                        String str = (String) stringArrayListExtra.get(0);
                        ajp();
                        c.Em().H(new 3(this, str));
                        return;
                    }
                    break;
                case 5:
                    if (!bi.oW(this.mVideoFilePath)) {
                        ajp();
                        c.Em().H(new 2(this));
                        return;
                    }
                    break;
            }
            this.fUS.bjW = -2;
            a(this.fUS);
        }
    }

    private AppBrandLocalVideoObject Z(String str, boolean z) {
        int i;
        int i2;
        MediaMetadataRetriever mediaMetadataRetriever;
        if (z) {
            try {
                boolean oZ = com.tencent.mm.plugin.a.c.oZ(str);
                x.i("MicroMsg.JsApiChooseVideo", "checkRemux, isMp4 = %b", new Object[]{Boolean.valueOf(oZ)});
                int i3 = -10000;
                if (oZ) {
                    i3 = SightVideoJNI.shouldRemuxing(str, 660, 500, 26214400, 300000.0d, 1000000);
                    x.i("MicroMsg.JsApiChooseVideo", "checkRemux, ret = %d", new Object[]{Integer.valueOf(i3)});
                }
                if (i3 == -1 || !oZ) {
                    x.i("MicroMsg.JsApiChooseVideo", "fileLength = %d", new Object[]{Integer.valueOf(com.tencent.mm.a.e.cm(str))});
                    i3 = com.tencent.mm.a.e.cm(str) > 26214400 ? -1 : 1;
                }
                switch (i3) {
                    case IX5WebViewClient.ERROR_CONNECT /*-6*/:
                    case IX5WebViewClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
                    case IX5WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                    case IX5WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
                    case IX5WebViewClient.ERROR_HOST_LOOKUP /*-2*/:
                    case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                        i3 = -50002;
                        break;
                    case 0:
                        i3 = -50006;
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        i3 = 1;
                        break;
                    default:
                        x.e("MicroMsg.JsApiChooseVideo", "unknown check type");
                        i3 = -50001;
                        break;
                }
                if (i3 == -50006) {
                    int[] iArr = new int[2];
                    com.tencent.mm.pluginsdk.model.j.d(str, iArr);
                    i = iArr[0];
                    i2 = iArr[1];
                    String str2 = e.dgl + "microMsg." + System.currentTimeMillis() + ".mp4";
                    i3 = SightVideoJNI.remuxing(str, str2, i, i2, b.nbW, b.nbV, 8, 2, 25.0f, b.nbX, null, 0, false);
                    x.i("MicroMsg.JsApiChooseVideo", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", new Object[]{str, str2, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2)});
                    str = str2;
                }
            } catch (Throwable e) {
                x.e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", new Object[]{bi.i(e)});
            }
        }
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
        } catch (Exception e2) {
            x.e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[]{e2});
            mediaMetadataRetriever = null;
        }
        if (mediaMetadataRetriever == null) {
            x.e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
            return null;
        }
        int i4 = bi.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
        i = bi.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
        i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
        mediaMetadataRetriever.release();
        AppBrandLocalVideoObject attachVideo = AppBrandLocalMediaObjectManager.attachVideo(this.fUT.appId, str);
        if (attachVideo == null) {
            return null;
        }
        attachVideo.duration = (i2 + 500) / 1000;
        attachVideo.width = i4;
        attachVideo.height = i;
        attachVideo.size = com.tencent.mm.a.e.cm(str);
        x.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", new Object[]{attachVideo});
        return attachVideo;
    }
}
