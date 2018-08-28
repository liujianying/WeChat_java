package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Parcelable;
import android.support.b.a;
import android.text.TextUtils;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.ChooseResult;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.k;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONStringer;
import org.xwalk.core.XWalkResourceClient;

final class JsApiChooseMedia$a extends AppBrandProxyUIProcessTask {
    private ChooseResult fUE = new ChooseResult();
    private JsApiChooseMedia$ChooseRequest fUF;
    private String fUG;
    private k fUH;
    int fUn;
    private p fUo;
    private OnCancelListener fUp;
    private String mVideoFilePath;

    private JsApiChooseMedia$a() {
    }

    static /* synthetic */ String g(JsApiChooseMedia$a jsApiChooseMedia$a) {
        if (!TextUtils.isEmpty(jsApiChooseMedia$a.fUG)) {
            AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(jsApiChooseMedia$a.fUF.appId, jsApiChooseMedia$a.fUG, true);
            if (attach != null && !bi.oW(attach.bNH)) {
                return attach.bNH;
            }
            x.e("MicroMsg.JsApiChooseMedia", "addThumbItem error, localId is null");
        }
        return "";
    }

    protected final void a(ProcessRequest processRequest) {
        this.fUF = (JsApiChooseMedia$ChooseRequest) processRequest;
        this.fUn = (this.fUF.fUi & this.fUF.fUj) != 0 ? 8 : 7;
        if ((bi.fQ(b()) > 200 ? 1 : 0) == 0) {
            x.e("MicroMsg.JsApiChooseMedia", "memory is not enough!");
            s.makeText(b(), ad.getResources().getString(j.app_brand_choose_media_memory_check_message), 1).show();
        }
        x.i("MicroMsg.JsApiChooseMedia", "goVideo");
        b().geJ = this;
        if (this.fUF.fUz && this.fUF.fUA) {
            this.fUH = new k(b());
            this.fUH.b(null, new 1(this), new 2(this));
            this.fUH.d(new 3(this));
            this.fUH.bEo();
        } else if (this.fUF.fUz) {
            ajo();
        } else if (this.fUF.fUA) {
            ajn();
        } else {
            this.fUE.bjW = -2;
            x.e("MicroMsg.JsApiChooseMedia", "parameter is invalid, fail and finish process");
            l((ProcessResult) this.fUE);
        }
    }

    protected final void ahC() {
        super.ahC();
        if (this.fUo != null) {
            this.fUo.dismiss();
            this.fUo = null;
        }
        if (this.fUH != null) {
            this.fUH.dismiss();
            this.fUH = null;
        }
    }

    private void ajn() {
        int i;
        int i2;
        x.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
        if (this.fUF.fUC && this.fUF.fUB) {
            i = 0;
        } else if (this.fUF.fUC) {
            i = 1;
        } else if (this.fUF.fUB) {
            i = 2;
        } else {
            i = 0;
        }
        Intent intent = new Intent();
        String str = "KEY_SIGHT_PARAMS";
        String str2 = "microMsg_" + System.currentTimeMillis();
        this.mVideoFilePath = e.dgl + "microMsg." + str2 + ".mp4";
        this.fUG = e.dgl + "microMsg." + str2 + ".jpeg";
        int i3 = this.fUF.maxDuration;
        Parcelable sightParams = new SightParams(3, 1);
        if (this.fUF.isFront) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        sightParams.lel = i2;
        sightParams.mode = i;
        if (sightParams.lem == null) {
            sightParams.lem = new VideoTransPara();
        }
        sightParams.lem.duration = i3;
        sightParams.let = false;
        sightParams.m(str2, this.mVideoFilePath, this.fUG, e.dgl + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        intent.putExtra(str, sightParams);
        l.a(b(), 7, intent, 3, i);
    }

    private void ajo() {
        int i = 3;
        boolean z = true;
        x.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
        if (!(this.fUF.fUB && this.fUF.fUC)) {
            if (this.fUF.fUB) {
                i = 1;
            } else if (this.fUF.fUC) {
                i = 2;
            }
        }
        Intent intent = new Intent();
        intent.putExtra("key_can_select_video_and_pic", true);
        String str = "key_send_raw_image";
        if (this.fUF.fUi) {
            z = false;
        }
        intent.putExtra(str, z);
        l.a(b(), 8, this.fUF.count, this.fUn, i, false, intent);
    }

    public final void b(int i, int i2, Intent intent) {
        if (i2 == 0) {
            x.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is canceled");
            this.fUE.bjW = 0;
            l((ProcessResult) this.fUE);
        } else if (-1 != i2) {
            x.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is not RESULT_OK");
            this.fUE.bjW = -2;
            l((ProcessResult) this.fUE);
        } else {
            boolean booleanExtra;
            boolean z;
            switch (i) {
                case 7:
                    x.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                    if (intent == null) {
                        x.e("MicroMsg.JsApiChooseMedia", "data is null!");
                        break;
                    }
                    x.i("MicroMsg.JsApiChooseMedia", "data is valid!");
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        x.e("MicroMsg.JsApiChooseMedia", "sight capture result is null!");
                        this.fUE.bjW = -2;
                        l((ProcessResult) this.fUE);
                        return;
                    } else if (sightCaptureResult.lec) {
                        String str = sightCaptureResult.lek;
                        if (bi.oW(str)) {
                            x.e("MicroMsg.JsApiChooseMedia", "picture_picturePath file is not exist! path:%s", new Object[]{str});
                            this.fUE.bjW = -2;
                            l((ProcessResult) this.fUE);
                            return;
                        }
                        booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", false);
                        if (((!this.fUF.fUj ? 1 : 0) & this.fUF.fUi) == 0 && ((this.fUF.fUi & this.fUF.fUj) & booleanExtra) == 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        x.d("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[]{Boolean.valueOf(true), Boolean.valueOf(this.fUF.fUi), Boolean.valueOf(this.fUF.fUj), Boolean.valueOf(booleanExtra), Boolean.valueOf(z)});
                        if (z) {
                            ajp();
                        }
                        c.Em().H(new 6(this, z, str));
                        return;
                    } else {
                        this.mVideoFilePath = sightCaptureResult.lee;
                        if (bi.oW(this.mVideoFilePath)) {
                            x.e("MicroMsg.JsApiChooseMedia", "mVideoFilePath is null");
                            break;
                        }
                        x.i("MicroMsg.JsApiChooseMedia", "mVideoFilePath:%s", new Object[]{this.mVideoFilePath});
                        if (!tO(this.fUG) && tO(sightCaptureResult.lef)) {
                            this.fUG = sightCaptureResult.lef;
                        }
                        ajp();
                        c.Em().H(new Runnable() {
                            public final void run() {
                                if (new File(JsApiChooseMedia$a.this.mVideoFilePath).exists()) {
                                    x.i("MicroMsg.JsApiChooseMedia", "take media camera, the mVideoFilePath file exist, success");
                                    JsApiChooseMedia$a.this.fUE.bjW = -1;
                                    JsApiChooseMedia$a.this.fUE.type = "video";
                                    AppBrandLocalVideoObject a = JsApiChooseMedia$a.this.tN(JsApiChooseMedia$a.this.mVideoFilePath);
                                    if (a == null) {
                                        x.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[]{JsApiChooseMedia$a.this.mVideoFilePath});
                                        JsApiChooseMedia$a.this.fUE.bjW = -2;
                                        JsApiChooseMedia$a.this.l((ProcessResult) JsApiChooseMedia$a.this.fUE);
                                        return;
                                    }
                                    JsApiChooseMedia$a.b(JsApiChooseMedia$a.this, JsApiChooseMedia$a.this.mVideoFilePath);
                                    String g = JsApiChooseMedia$a.g(JsApiChooseMedia$a.this);
                                    JsApiChooseMedia$a.this.fUE.fUD = JsApiChooseMedia$a.c(a.bNH, g, a.duration, a.height, a.width, a.size);
                                    JsApiChooseMedia$a.this.l((ProcessResult) JsApiChooseMedia$a.this.fUE);
                                    return;
                                }
                                x.e("MicroMsg.JsApiChooseMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[]{JsApiChooseMedia$a.this.mVideoFilePath});
                                JsApiChooseMedia$a.this.fUE.bjW = -2;
                                JsApiChooseMedia$a.this.l((ProcessResult) JsApiChooseMedia$a.this.fUE);
                            }
                        });
                        return;
                    }
                case 8:
                    x.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                    if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                        final List stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                        if (stringArrayListExtra2 == null || stringArrayListExtra2.size() == 0) {
                            x.e("MicroMsg.JsApiChooseMedia", "chosen is null,  fail");
                            this.fUE.bjW = -2;
                            l((ProcessResult) this.fUE);
                            return;
                        }
                        booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", false);
                        if (((!this.fUF.fUj ? 1 : 0) & this.fUF.fUi) == 0 && ((this.fUF.fUi & this.fUF.fUj) & booleanExtra) == 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        x.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[]{Boolean.valueOf(false), Boolean.valueOf(this.fUF.fUi), Boolean.valueOf(this.fUF.fUj), Boolean.valueOf(booleanExtra), Boolean.valueOf(z)});
                        if (z) {
                            ajp();
                        }
                        c.Em().H(new Runnable() {
                            public final void run() {
                                ArrayList arrayList = new ArrayList(stringArrayListExtra2.size());
                                ArrayList arrayList2 = new ArrayList(stringArrayListExtra2.size());
                                for (String str : stringArrayListExtra2) {
                                    String str2;
                                    if (z) {
                                        str2 = JsApiChooseMedia$a.tK(str2);
                                    }
                                    AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(JsApiChooseMedia$a.this.fUF.appId, str2, z | 0);
                                    if (attach != null) {
                                        arrayList.add(Long.valueOf(attach.eyz));
                                        arrayList2.add(attach.bNH);
                                    } else {
                                        x.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", new Object[]{str2});
                                    }
                                }
                                if (arrayList2.size() == 0) {
                                    x.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                                    JsApiChooseMedia$a.this.fUE.bjW = -2;
                                    JsApiChooseMedia$a.this.l((ProcessResult) JsApiChooseMedia$a.this.fUE);
                                    return;
                                }
                                ah.A(new 1(this, arrayList2, arrayList));
                            }
                        });
                        return;
                    }
                    this.mVideoFilePath = (String) stringArrayListExtra.get(0);
                    if (bi.oW(this.mVideoFilePath)) {
                        x.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is  null, fail");
                        break;
                    }
                    ajp();
                    c.Em().H(new 4(this));
                    return;
            }
            this.fUE.bjW = -2;
            l((ProcessResult) this.fUE);
        }
    }

    private void ajp() {
        this.fUp = new 8(this);
        MMActivity ahw = b();
        ad.getResources().getString(j.app_tip);
        this.fUo = h.a(ahw, ad.getResources().getString(j.app_brand_choose_media_video_compressing), true, this.fUp);
    }

    private static String tK(String str) {
        String str2 = e.dgl + "microMsg." + System.currentTimeMillis() + ".jpg";
        try {
            Bitmap decodeFile = MMBitmapFactory.decodeFile(str, 0);
            if (decodeFile == null) {
                x.e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp return null");
                return null;
            }
            long VF = bi.VF();
            int a = n.a(decodeFile, 70, str2);
            x.i("MicroMsg.JsApiChooseMedia", "doCompressImage, ret = %d, cost = %d, %s (%d) -> %s (%d)", new Object[]{Integer.valueOf(a), Long.valueOf(bi.VF() - VF), str, Long.valueOf(new File(str).length()), str2, Long.valueOf(new File(str2).length())});
            if (a == 1 && com.tencent.mm.a.e.cn(str) && com.tencent.mm.a.e.cn(str2)) {
                try {
                    b.a(new a(str), new a(str2));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.JsApiChooseMedia", e, "duplicate exif", new Object[0]);
                }
            }
            return a == 1 ? str2 : str;
        } catch (OutOfMemoryError e2) {
            x.e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp oom");
            return null;
        }
    }

    private AppBrandLocalVideoObject tN(String str) {
        int i;
        int i2;
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            boolean oZ = com.tencent.mm.plugin.a.c.oZ(str);
            x.i("MicroMsg.JsApiChooseMedia", "checkRemux, isMp4 = %b", new Object[]{Boolean.valueOf(oZ)});
            int i3 = -10000;
            if (oZ) {
                i3 = SightVideoJNI.shouldRemuxing(str, 660, TbsListener$ErrorCode.INFO_CODE_MINIQB, 26214400, 300000.0d, 1000000);
                x.i("MicroMsg.JsApiChooseMedia", "checkRemux, ret = %d", new Object[]{Integer.valueOf(i3)});
            }
            if (i3 == -1 || !oZ) {
                x.i("MicroMsg.JsApiChooseMedia", "fileLength = %d", new Object[]{Integer.valueOf(com.tencent.mm.a.e.cm(str))});
                i3 = com.tencent.mm.a.e.cm(str) > 26214400 ? -1 : 1;
            }
            switch (i3) {
                case XWalkResourceClient.ERROR_CONNECT /*-6*/:
                case XWalkResourceClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
                case XWalkResourceClient.ERROR_AUTHENTICATION /*-4*/:
                case -3:
                case -2:
                case -1:
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
                    x.e("MicroMsg.JsApiChooseMedia", "unknown check type");
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
                x.i("MicroMsg.JsApiChooseMedia", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", new Object[]{str, str2, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2)});
                str = str2;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.JsApiChooseMedia", "addVideoItem, remux failed, exp = %s", new Object[]{bi.i(e)});
        }
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
        } catch (Exception e2) {
            x.e("MicroMsg.JsApiChooseMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[]{e2});
            mediaMetadataRetriever = null;
        }
        if (mediaMetadataRetriever == null) {
            x.e("MicroMsg.JsApiChooseMedia", "addVideoItem, null meta data");
            return null;
        }
        int i4 = bi.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
        i = bi.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
        i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
        mediaMetadataRetriever.release();
        AppBrandLocalVideoObject attachVideo = AppBrandLocalMediaObjectManager.attachVideo(this.fUF.appId, str);
        if (attachVideo == null) {
            x.e("MicroMsg.JsApiChooseMedia", "attachVideo error, return null");
            return null;
        }
        attachVideo.duration = (i2 + TbsListener$ErrorCode.INFO_CODE_MINIQB) / TbsLog.TBSLOG_CODE_SDK_BASE;
        attachVideo.width = i4;
        attachVideo.height = i;
        attachVideo.size = com.tencent.mm.a.e.cm(str);
        x.i("MicroMsg.JsApiChooseMedia", "addVideoItem, return %s", new Object[]{attachVideo});
        return attachVideo;
    }

    private static boolean tO(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.JsApiChooseMedia", "video thumb file path is null");
            return false;
        }
        File file = new File(str);
        x.i("MicroMsg.JsApiChooseMedia", "thumbFilePath:%s", new Object[]{str});
        if (file.exists()) {
            x.i("MicroMsg.JsApiChooseMedia", "video thumb file is exist");
            return true;
        }
        x.e("MicroMsg.JsApiChooseMedia", "video thumb file is not exist");
        return false;
    }

    private static String c(ArrayList<String> arrayList, ArrayList<Long> arrayList2) {
        if (arrayList == null || arrayList.size() == 0) {
            x.e("MicroMsg.JsApiChooseMedia", "parseImageItemToJson localIds is null");
            return "";
        }
        x.i("MicroMsg.JsApiChooseMedia", "parseImageItemToJson()");
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            for (int i = 0; i < arrayList.size(); i++) {
                jSONStringer.object();
                String str = (String) arrayList.get(i);
                Long l = (Long) arrayList2.get(i);
                jSONStringer.key("tempFilePath");
                jSONStringer.value(str);
                jSONStringer.key("size");
                jSONStringer.value(String.valueOf(l.longValue()));
                jSONStringer.endObject();
            }
            jSONStringer.endArray();
            return jSONStringer.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.JsApiChooseMedia", e, "", new Object[0]);
            return "";
        }
    }

    private static String c(String str, String str2, int i, int i2, int i3, int i4) {
        if (bi.oW(str)) {
            x.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
            return "";
        }
        x.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            jSONStringer.object();
            jSONStringer.key("tempFilePath");
            jSONStringer.value(str);
            jSONStringer.key("thumbTempFilePath");
            jSONStringer.value(str2);
            jSONStringer.key("duration");
            jSONStringer.value(String.valueOf(i));
            jSONStringer.key("height");
            jSONStringer.value(String.valueOf(i2));
            jSONStringer.key("width");
            jSONStringer.value(String.valueOf(i3));
            jSONStringer.key("size");
            jSONStringer.value(String.valueOf(i4));
            jSONStringer.endObject();
            jSONStringer.endArray();
            return jSONStringer.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.JsApiChooseMedia", e, "", new Object[0]);
            return "";
        }
    }
}
