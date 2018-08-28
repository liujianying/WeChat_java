package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class OpenFileChooserUI extends MMActivity {
    private int count;
    private ProgressDialog eHw = null;
    private String fOr;
    private String fOs;
    private int jCU;
    private int jCt;
    private int ohT;
    private boolean pWc;
    private int pWd;
    private int pWe;
    private boolean pWf = false;
    private OnCancelListener pWg = null;

    static /* synthetic */ void b(OpenFileChooserUI openFileChooserUI, String str) {
        String str2 = null;
        if (openFileChooserUI.pWe == 0) {
            x.e("MicroMsg.OpenFileChooserUI", "don't need thumb image");
            return;
        }
        File file;
        if (TextUtils.isEmpty(openFileChooserUI.fOs)) {
            x.e("MicroMsg.OpenFileChooserUI", "thumbFilePath is empty!");
            file = null;
        } else {
            file = new File(openFileChooserUI.fOs);
        }
        if (file == null || !file.exists()) {
            x.e("MicroMsg.OpenFileChooserUI", "file == null or file not exist for path:%s!", openFileChooserUI.fOs);
            String name = new File(str).getName();
            if (!TextUtils.isEmpty(name) && name.contains(".")) {
                str2 = name.substring(0, name.lastIndexOf("."));
            }
            if (TextUtils.isEmpty(str2)) {
                openFileChooserUI.fOs = e.dgl + ("microMsg_" + System.currentTimeMillis()) + ".jpeg";
            } else if (e.dgl == null || !e.dgl.endsWith("/")) {
                openFileChooserUI.fOs = e.dgl + "/" + str2 + ".jpeg";
            } else {
                openFileChooserUI.fOs = e.dgl + str2 + ".jpeg";
            }
            if (new File(openFileChooserUI.fOs).exists()) {
                x.i("MicroMsg.OpenFileChooserUI", "file is exist for path:%s!", openFileChooserUI.fOs);
                return;
            }
            x.i("MicroMsg.OpenFileChooserUI", "file not exist for path:%s!", openFileChooserUI.fOs);
            x.i("MicroMsg.OpenFileChooserUI", "create new thumb path:%s!", openFileChooserUI.fOs);
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
            if (createVideoThumbnail == null) {
                x.e("MicroMsg.OpenFileChooserUI", "createVideoThumbnail bitmap fail for path:%s!", openFileChooserUI.fOs);
                return;
            }
            try {
                c.a(ThumbnailUtils.extractThumbnail(createVideoThumbnail, 690, 400, 2), 30, CompressFormat.JPEG, openFileChooserUI.fOs, true);
                return;
            } catch (IOException e) {
                x.e("MicroMsg.OpenFileChooserUI", "saveBitmapToImage exist IOException:" + e.getMessage());
                return;
            }
        }
        x.i("MicroMsg.OpenFileChooserUI", "file is exist!, path:%s", openFileChooserUI.fOs);
    }

    static /* synthetic */ String d(OpenFileChooserUI openFileChooserUI) {
        if (TextUtils.isEmpty(openFileChooserUI.fOs)) {
            return "";
        }
        WebViewJSSDKFileItem Qn = WebViewJSSDKFileItem.Qn(openFileChooserUI.fOs);
        Qn.fOs = openFileChooserUI.fOs;
        Qn.fnQ = true;
        Qn.bMT = 1;
        com.tencent.mm.plugin.webview.modeltools.e.bUX().b(Qn);
        return Qn.bNH;
    }

    static /* synthetic */ String o(String str, List list) {
        int[] iArr = new int[2];
        j.d(str, iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PInt pInt3 = new PInt();
        PInt pInt4 = new PInt();
        d.a(str, pInt, pInt2, pInt3, pInt4, new PInt());
        String str2 = e.dgl + "microMsg." + System.currentTimeMillis() + ".mp4";
        x.i("MicroMsg.OpenFileChooserUI", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", str, str2, Integer.valueOf(SightVideoJNI.remuxing(str, str2, i, i2, b.nbW, b.nbV, 8, 2, 25.0f, (float) pInt4.value, null, 0, false)), Integer.valueOf(i), Integer.valueOf(i2));
        WebViewJSSDKVideoItem Qp = WebViewJSSDKFileItem.Qp(str2);
        Qp.width = i;
        Qp.height = i2;
        Qp.duration = r2;
        Qp.size = com.tencent.mm.a.e.cm(str2);
        list.add(Qp.bNH);
        com.tencent.mm.plugin.webview.modeltools.e.bUX().b(Qp);
        return Qp.bNH;
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        this.count = getIntent().getIntExtra("key_pick_local_pic_count", 0);
        if (this.count <= 0 || this.count > 9) {
            this.count = 9;
        }
        this.ohT = this.count;
        this.jCt = getIntent().getIntExtra("key_pick_local_pic_query_source_type", 8);
        this.jCU = getIntent().getIntExtra("query_media_type", 1);
        this.pWc = getIntent().getBooleanExtra("key_pick_local_pic_send_raw", false);
        this.pWd = getIntent().getIntExtra("key_pick_local_pic_capture", 3);
        this.pWe = getIntent().getIntExtra("key_pick_local_media_video_type", 0);
        if ((this.jCt == 7 && this.jCU == 2) || this.jCU == 3) {
            if (!bVJ()) {
                s.makeText(this, getString(R.l.webview_memory_check_message), 1).show();
                this.pWf = true;
            }
            Intent intent = new Intent();
            intent.putExtra("key_send_raw_image", this.pWc);
            intent.putExtra("query_media_type", this.jCU);
            int intExtra;
            int intExtra2;
            int i;
            if (this.pWe == 1) {
                if (this.pWd != 4096 && (this.pWd & 4096) > 0) {
                    intExtra = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                    intExtra2 = getIntent().getIntExtra("key_pick_local_media_duration", 60);
                    intent.putExtra("KEY_SIGHT_PARAMS", AC(1));
                    intent.putExtra("record_video_force_sys_camera", false);
                    intent.putExtra("show_header_view", true);
                    intent.putExtra("record_video_is_sight_capture", true);
                    intent.putExtra("record_video_quality", intExtra);
                    intent.putExtra("record_video_time_limit", intExtra2);
                    intent.putExtra("video_full_path", this.fOr);
                    l.c((Activity) this, this.ohT, this.jCt, intent);
                } else if (this.pWd == 16 || this.pWd == 256) {
                    intent.putExtra("KEY_SIGHT_PARAMS", AC(1));
                    l.a((Context) this, 6, intent, 3, 1);
                } else if (this.pWd == 4096) {
                    intent.putExtra("show_header_view", false);
                    l.c((Activity) this, this.ohT, this.jCt, intent);
                }
            } else if (this.pWe == 2) {
                String oV = bi.oV(getIntent().getStringExtra("key_pick_local_media_sight_type"));
                if (this.pWd != 4096 && (this.pWd & 4096) > 0) {
                    x.e("MicroMsg.OpenFileChooserUI", "choose media from local or camera is not support");
                    setResult(1);
                    a();
                } else if (this.pWd == 16 || this.pWd == 256) {
                    intExtra = 0;
                    if (oV.contains("video") && oV.contains("image")) {
                        intExtra = 0;
                    } else if (oV.contains("video")) {
                        intExtra = 1;
                    } else if (oV.contains("image")) {
                        intExtra = 2;
                    }
                    intent.putExtra("KEY_SIGHT_PARAMS", AC(intExtra));
                    l.a((Context) this, 7, intent, 3, intExtra);
                } else if (this.pWd == 4096) {
                    i = 3;
                    if (oV.contains("image") && oV.contains("video")) {
                        i = 3;
                    } else if (oV.contains("image")) {
                        i = 1;
                    } else if (oV.contains("video")) {
                        i = 2;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_can_select_video_and_pic", true);
                    intent2.putExtra("key_send_raw_image", this.pWc);
                    l.a((Activity) this, 8, this.ohT, this.jCt, i, false, intent2);
                }
            } else if (this.pWd != 4096 && (this.pWd & 4096) > 0) {
                this.fOr = e.dgl + "microMsg." + System.currentTimeMillis() + ".mp4";
                intExtra = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                intExtra2 = getIntent().getIntExtra("key_pick_local_media_duration", 60);
                intent.putExtra("record_video_force_sys_camera", true);
                intent.putExtra("record_video_quality", intExtra);
                intent.putExtra("record_video_time_limit", intExtra2);
                intent.putExtra("video_full_path", this.fOr);
                l.c((Activity) this, this.ohT, this.jCt, intent);
            } else if (this.pWd == 16 || this.pWd == 256) {
                this.fOr = e.dgl + "microMsg." + System.currentTimeMillis() + ".mp4";
                i = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                l.a(this, this.fOr, 5, getIntent().getIntExtra("key_pick_local_media_duration", 60), i, this.pWd == 16);
            } else if (this.pWd == 4096) {
                intent.putExtra("show_header_view", false);
                l.c((Activity) this, this.ohT, this.jCt, intent);
            }
            if (this.pWd != 4096 && (this.pWd & 4096) > 0) {
                obj = 1;
                if (obj == null) {
                    if (!bVJ()) {
                        s.makeText(this, getString(R.l.webview_memory_check_message), 1).show();
                        this.pWf = true;
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("key_send_raw_image", this.pWc);
                    intent3.putExtra("query_media_type", this.jCU);
                    switch (this.pWd) {
                        case 1:
                            intent3.putExtra("show_header_view", false);
                            l.a((Activity) this, 1, this.ohT, this.jCt, intent3);
                            return;
                        case 2:
                            h.a(this, "", new String[]{getString(R.l.webview_jssdk_take_photo)}, "", true, new 1(this), new 2(this));
                            return;
                        case 3:
                            l.a((Activity) this, 1, this.count, this.jCt, intent3);
                            return;
                        default:
                            x.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                            setResult(0);
                            a();
                            return;
                    }
                }
            } else if (this.pWd == 16 || this.pWd == 256) {
                obj = 1;
                if (obj == null) {
                    if (!bVJ()) {
                        s.makeText(this, getString(R.l.webview_memory_check_message), 1).show();
                        this.pWf = true;
                    }
                    Intent intent32 = new Intent();
                    intent32.putExtra("key_send_raw_image", this.pWc);
                    intent32.putExtra("query_media_type", this.jCU);
                    switch (this.pWd) {
                        case 1:
                            intent32.putExtra("show_header_view", false);
                            l.a((Activity) this, 1, this.ohT, this.jCt, intent32);
                            return;
                        case 2:
                            h.a(this, "", new String[]{getString(R.l.webview_jssdk_take_photo)}, "", true, new 1(this), new 2(this));
                            return;
                        case 3:
                            l.a((Activity) this, 1, this.count, this.jCt, intent32);
                            return;
                        default:
                            x.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                            setResult(0);
                            a();
                            return;
                    }
                }
            } else if (this.pWd == 4096) {
                obj = 1;
                if (obj == null) {
                    if (!bVJ()) {
                        s.makeText(this, getString(R.l.webview_memory_check_message), 1).show();
                        this.pWf = true;
                    }
                    Intent intent322 = new Intent();
                    intent322.putExtra("key_send_raw_image", this.pWc);
                    intent322.putExtra("query_media_type", this.jCU);
                    switch (this.pWd) {
                        case 1:
                            intent322.putExtra("show_header_view", false);
                            l.a((Activity) this, 1, this.ohT, this.jCt, intent322);
                            return;
                        case 2:
                            h.a(this, "", new String[]{getString(R.l.webview_jssdk_take_photo)}, "", true, new 1(this), new 2(this));
                            return;
                        case 3:
                            l.a((Activity) this, 1, this.count, this.jCt, intent322);
                            return;
                        default:
                            x.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                            setResult(0);
                            a();
                            return;
                    }
                }
            }
        }
        obj = null;
        if (obj == null) {
            if (!bVJ()) {
                s.makeText(this, getString(R.l.webview_memory_check_message), 1).show();
                this.pWf = true;
            }
            Intent intent3222 = new Intent();
            intent3222.putExtra("key_send_raw_image", this.pWc);
            intent3222.putExtra("query_media_type", this.jCU);
            switch (this.pWd) {
                case 1:
                    intent3222.putExtra("show_header_view", false);
                    l.a((Activity) this, 1, this.ohT, this.jCt, intent3222);
                    return;
                case 2:
                    h.a(this, "", new String[]{getString(R.l.webview_jssdk_take_photo)}, "", true, new 1(this), new 2(this));
                    return;
                case 3:
                    l.a((Activity) this, 1, this.count, this.jCt, intent3222);
                    return;
                default:
                    x.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                    setResult(0);
                    a();
                    return;
            }
        }
    }

    private boolean bVJ() {
        x.i("MicroMsg.OpenFileChooserUI", "avaiableMem = %d", Long.valueOf(bi.fQ(this)));
        if (bi.fQ(this) <= 200) {
            return false;
        }
        return true;
    }

    private SightParams AC(int i) {
        String str = "microMsg_" + System.currentTimeMillis();
        this.fOr = e.dgl + str + ".mp4";
        this.fOs = e.dgl + str + ".jpeg";
        int intExtra = getIntent().getIntExtra("key_pick_local_media_duration", 60);
        SightParams sightParams = new SightParams(3, 1);
        sightParams.lel = this.pWd == 16 ? 1 : 2;
        sightParams.mode = i;
        if (sightParams.lem == null) {
            sightParams.lem = new VideoTransPara();
        }
        sightParams.lem.duration = intExtra;
        sightParams.m(str, this.fOr, this.fOs, e.dgl + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        return sightParams;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.OpenFileChooserUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    l.c(this.mController.tml, e.dgl, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
                    return;
                } else {
                    h.a(this, getString(R.l.permission_camera_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 3(this), null);
                    return;
                }
            default:
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        File file = null;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            Intent intent2 = new Intent();
            intent2.putExtra("key_pick_local_media_show_memory_warning", this.pWf);
            setResult(i2, intent2);
            a();
            return;
        }
        String d;
        Intent intent3;
        ArrayList arrayList;
        SightCaptureResult sightCaptureResult;
        switch (i) {
            case 1:
            case 3:
                au.Em().H(new 4(this, intent, i2));
                return;
            case 2:
                d = l.d(this.mController.tml.getApplicationContext(), intent, e.dgl);
                if (bi.oW(d)) {
                    x.w("MicroMsg.OpenFileChooserUI", "take photo, but result is null");
                    setResult(-2, intent);
                    a();
                    return;
                }
                x.i("MicroMsg.OpenFileChooserUI", "take photo, result[%s]", d);
                intent3 = new Intent();
                intent3.putExtra("key_send_raw_image", this.pWc);
                intent3.putExtra("max_select_count", this.ohT);
                intent3.putExtra("query_source_type", this.jCt);
                arrayList = new ArrayList(1);
                arrayList.add(d);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("preview_image", true);
                intent3.addFlags(67108864);
                com.tencent.mm.bg.d.b(this, "gallery", ".ui.GalleryEntryUI", intent3, 3);
                return;
            case 4:
                List stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                    x.e("MicroMsg.OpenFileChooserUI", "choose video failed, path is null");
                    setResult(1);
                    a();
                    return;
                }
                x.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_GALLERY_VIDEO");
                x.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", stringArrayListExtra.get(0));
                if (this.pWe == 1 && !tO(this.fOs)) {
                    x.i("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
                }
                Rc((String) stringArrayListExtra.get(0));
                return;
            case 5:
                if (new File(this.fOr).exists()) {
                    Rc(this.fOr);
                    return;
                }
                x.e("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_VIDEO, file not exist : %s", this.fOr);
                setResult(1);
                a();
                return;
            case 6:
                x.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_SIGHT_VIDEO");
                if (intent != null) {
                    x.i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        x.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        a();
                        return;
                    }
                    this.fOr = sightCaptureResult.lee;
                    x.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", this.fOr);
                    if (!tO(this.fOs) && tO(sightCaptureResult.lef)) {
                        this.fOs = sightCaptureResult.lef;
                    }
                    if (!TextUtils.isEmpty(this.fOr)) {
                        file = new File(this.fOr);
                    }
                    if (file == null || !file.exists()) {
                        x.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", this.fOr);
                    } else {
                        x.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", this.fOr);
                        Rc(this.fOr);
                        return;
                    }
                }
                x.e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                a();
                return;
            case 7:
                x.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                if (intent != null) {
                    x.i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        x.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        a();
                        return;
                    } else if (sightCaptureResult.lec) {
                        d = sightCaptureResult.lek;
                        if (bi.oW(d)) {
                            x.e("MicroMsg.OpenFileChooserUI", "picture_picturePath file is not exist! path:%s", d);
                            setResult(1);
                            a();
                            return;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        WebViewJSSDKFileItem Qn = WebViewJSSDKFileItem.Qn(d);
                        Qn.fnQ = true;
                        Qn.bMT = 1;
                        com.tencent.mm.plugin.webview.modeltools.e.bUX().b(Qn);
                        arrayList2.add(Qn.bNH);
                        x.i("MicroMsg.OpenFileChooserUI", "filepath is : %s, local id is : %s", d, Qn.bNH);
                        x.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", aj.V(arrayList2));
                        intent3 = new Intent();
                        intent3.putExtra("key_pick_local_media_local_ids", d);
                        intent3.putExtra("key_pick_local_media_callback_type", 2);
                        setResult(i2, intent3);
                        a();
                        return;
                    } else {
                        File file2;
                        this.fOr = sightCaptureResult.lee;
                        x.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", this.fOr);
                        if (!tO(this.fOs) && tO(sightCaptureResult.lef)) {
                            this.fOs = sightCaptureResult.lef;
                        }
                        if (TextUtils.isEmpty(this.fOr)) {
                            file2 = null;
                        } else {
                            file2 = new File(this.fOr);
                        }
                        if (file2 == null || !file2.exists()) {
                            x.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", this.fOr);
                        } else {
                            x.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", this.fOr);
                            Rc(this.fOr);
                            return;
                        }
                    }
                }
                x.e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                a();
                return;
            case 8:
                x.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
                ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra2 == null || stringArrayListExtra2.size() <= 0) {
                    List<String> stringArrayListExtra3 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", true);
                    if (stringArrayListExtra3 == null) {
                        x.e("MicroMsg.OpenFileChooserUI", "chosen is null");
                        setResult(1);
                        a();
                        return;
                    }
                    arrayList = new ArrayList();
                    for (String d2 : stringArrayListExtra3) {
                        WebViewJSSDKFileItem Qn2 = WebViewJSSDKFileItem.Qn(d2);
                        String str = Qn2.bNH;
                        Qn2.fnQ = booleanExtra;
                        com.tencent.mm.plugin.webview.modeltools.e.bUX().b(Qn2);
                        x.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", d2, str);
                        arrayList.add(str);
                    }
                    x.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", aj.V(arrayList));
                    intent3 = new Intent();
                    intent3.putExtra("key_pick_local_media_local_ids", d2);
                    intent3.putExtra("key_pick_local_media_show_memory_warning", this.pWf);
                    intent3.putExtra("key_pick_local_media_callback_type", 2);
                    setResult(i2, intent3);
                    a();
                    return;
                }
                Rc((String) stringArrayListExtra2.get(0));
                return;
            default:
                x.e("MicroMsg.OpenFileChooserUI", "unknown request code = %d", Integer.valueOf(i));
                setResult(1);
                a();
                return;
        }
    }

    private void Rc(String str) {
        this.pWg = new 5(this);
        getString(R.l.app_tip);
        this.eHw = h.a(this, getString(R.l.webview_jssdk_choose_video_compressing), true, this.pWg);
        au.Em().H(new 6(this, str));
    }

    private String Rd(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
        } catch (Exception e) {
            x.e("MicroMsg.OpenFileChooserUI", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e);
            mediaMetadataRetriever = null;
        }
        if (mediaMetadataRetriever == null) {
            return null;
        }
        int i = bi.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
        int i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
        int i3 = bi.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
        mediaMetadataRetriever.release();
        mediaMetadataRetriever.release();
        WebViewJSSDKVideoItem Qp = WebViewJSSDKFileItem.Qp(str);
        Qp.duration = (i3 + 500) / 1000;
        Qp.width = i;
        Qp.height = i2;
        Qp.size = com.tencent.mm.a.e.cm(str);
        if (this.pWe == 1) {
            Qp.fOs = this.fOs;
        }
        com.tencent.mm.plugin.webview.modeltools.e.bUX().b(Qp);
        return Qp.bNH;
    }

    private int Re(String str) {
        com.tencent.mm.compatible.j.a.a j;
        Intent intent = new Intent();
        intent.setData(Uri.parse("file://" + str));
        com.tencent.mm.compatible.j.a.a aVar = null;
        ao.is2G(this);
        try {
            j = com.tencent.mm.compatible.j.a.j(this, intent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.OpenFileChooserUI", e, "", new Object[0]);
            j = aVar;
        }
        if (j == null) {
            x.e("MicroMsg.OpenFileChooserUI", "compressVideo filed.");
            return -50005;
        }
        int i;
        String str2 = j.filename;
        boolean oZ = com.tencent.mm.plugin.a.c.oZ(str2);
        x.i("MicroMsg.OpenFileChooserUI", "isMp4 = %b", Boolean.valueOf(oZ));
        int i2 = -10000;
        if (oZ) {
            i2 = SightVideoJNI.shouldRemuxing(str2, 660, 500, 26214400, 300000.0d, 1000000);
            x.i("MicroMsg.OpenFileChooserUI", "check remuxing, ret %d", Integer.valueOf(i2));
        }
        if (i2 == -1 || !oZ) {
            x.i("MicroMsg.OpenFileChooserUI", "fileLenght = %d", Integer.valueOf(com.tencent.mm.a.e.cm(str2)));
            if (com.tencent.mm.a.e.cm(str2) > 26214400) {
                i2 = -1;
            } else {
                i2 = 1;
            }
        }
        switch (i2) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                return -50002;
            case 0:
                i = 1;
                i2 = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                i = 0;
                i2 = 1;
                break;
            default:
                x.e("MicroMsg.OpenFileChooserUI", "unknown check type");
                return -50001;
        }
        if (i != 0) {
            i2 = -50006;
        }
        i = j.duration / 1000;
        x.i("MicroMsg.OpenFileChooserUI", "finish to import %s  ret %d | duration %d", str2, Integer.valueOf(i2), Integer.valueOf(i));
        return i2;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
        }
    }

    private static boolean tO(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.OpenFileChooserUI", "video thumb file path is null");
            return false;
        }
        File file = new File(str);
        x.i("MicroMsg.OpenFileChooserUI", "thumbFilePath:%s", str);
        if (file.exists()) {
            x.i("MicroMsg.OpenFileChooserUI", "video thumb file is exist");
            return true;
        }
        x.e("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
        return false;
    }
}
