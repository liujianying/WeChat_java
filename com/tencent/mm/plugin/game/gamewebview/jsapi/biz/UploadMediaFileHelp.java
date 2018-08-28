package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.appbrand.jsapi.share.g;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;

public final class UploadMediaFileHelp {
    private static ProgressDialog eHw = null;
    public MMActivity fcq;
    public d jGU;
    public String jHD;
    public boolean jHE;
    public b jHF;
    public String mAppId;

    static /* synthetic */ void a(Context context, WebViewJSSDKFileItem webViewJSSDKFileItem, String str, String str2, int i, boolean z, a aVar) {
        5 5 = new 5(str2, aVar);
        e b = o.Pf().b(Long.valueOf(o.Pf().a(webViewJSSDKFileItem.fnM, webViewJSSDKFileItem.fnQ ? 0 : 1, 0, 0, new PString(), new PInt(), new PInt())));
        String str3 = webViewJSSDKFileItem.fnM;
        webViewJSSDKFileItem.fnM = o.Pf().o(b.dTL, "", "");
        x.i("MicroMsg.UploadMediaFileHelp", "Image Inserted: %s", new Object[]{r0});
        x.i("MicroMsg.UploadMediaFileHelp", "add cdn upload task result : %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.webview.modeltools.e.bUW().a(str, str2, i, g.CTRL_INDEX, 2, 5))});
        webViewJSSDKFileItem.fnM = str3;
        if (!com.tencent.mm.plugin.webview.modeltools.e.bUW().a(str, str2, i, g.CTRL_INDEX, 2, 5)) {
            aVar.b(false, "", "");
        } else if (z) {
            context.getString(R.l.app_tip);
            eHw = h.a(context, context.getString(R.l.wv_uploading), true, new 6(5, str2, aVar));
        }
    }

    static /* synthetic */ void a(Context context, String str, String str2, int i, boolean z, a aVar) {
        7 7 = new 7(str2, aVar);
        x.i("MicroMsg.UploadMediaFileHelp", "add cdn upload task result : %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.webview.modeltools.e.bUW().a(str, str2, i, g.CTRL_INDEX, 2, 7))});
        if (!com.tencent.mm.plugin.webview.modeltools.e.bUW().a(str, str2, i, g.CTRL_INDEX, 2, 7)) {
            aVar.b(false, "", "");
        } else if (z) {
            context.getString(R.l.app_tip);
            p a = h.a(context, context.getString(R.l.wv_uploading), true, new 8(7, str2, aVar));
            eHw = a;
            a.setOnKeyListener(new 9(context));
        }
    }

    static /* synthetic */ void b(UploadMediaFileHelp uploadMediaFileHelp) {
        if (uploadMediaFileHelp.jGU.getActionBar() != null) {
            com.tencent.mm.plugin.game.gamewebview.ui.e actionBar = uploadMediaFileHelp.jGU.getActionBar();
            if (actionBar.jKg != null) {
                actionBar.jKg.dismiss();
                actionBar.jKg = null;
            }
            uploadMediaFileHelp.jGU.getActionBar().setCloseWindowConfirmInfo(null);
        }
    }

    /* renamed from: aSy */
    final void a() {
        if (this.jGU.getActionBar() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("close_window_confirm_dialog_switch", true);
            bundle.putString("close_window_confirm_dialog_title_cn", this.fcq.getString(R.l.webview_jssdk_video_uploading_tips));
            bundle.putString("close_window_confirm_dialog_title_eng", this.fcq.getString(R.l.webview_jssdk_video_uploading_tips));
            bundle.putString("close_window_confirm_dialog_ok_cn", this.fcq.getString(R.l.webview_jssdk_upload_video_cancel));
            bundle.putString("close_window_confirm_dialog_ok_eng", this.fcq.getString(R.l.webview_jssdk_upload_video_cancel));
            bundle.putString("close_window_confirm_dialog_cancel_cn", this.fcq.getString(R.l.webview_jssdk_upload_video_continue));
            bundle.putString("close_window_confirm_dialog_cancel_eng", this.fcq.getString(R.l.webview_jssdk_upload_video_continue));
            this.jGU.getActionBar().setCloseWindowConfirmInfo(bundle);
        }
        aSz();
    }

    final void aSz() {
        if (this.jHE) {
            UploadMediaFileActivity uploadMediaFileActivity = new UploadMediaFileActivity(this.fcq);
            uploadMediaFileActivity.jHO = this.jHD;
            uploadMediaFileActivity.appId = this.mAppId;
            uploadMediaFileActivity.jHP = this.jHE;
            uploadMediaFileActivity.fFC = new 3(this, uploadMediaFileActivity);
            uploadMediaFileActivity.aNI();
            return;
        }
        final UploadMediaFileTask uploadMediaFileTask = new UploadMediaFileTask();
        uploadMediaFileTask.jHO = this.jHD;
        uploadMediaFileTask.appId = this.mAppId;
        uploadMediaFileTask.fFC = new Runnable() {
            public final void run() {
                uploadMediaFileTask.ahB();
                UploadMediaFileHelp.b(UploadMediaFileHelp.this);
                if (uploadMediaFileTask.success) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("serverId", bi.oV(uploadMediaFileTask.mediaId));
                    hashMap.put("mediaUrl", bi.oV(uploadMediaFileTask.jHQ));
                    UploadMediaFileHelp.this.jHF.a(true, hashMap);
                    return;
                }
                UploadMediaFileHelp.this.jHF.a(false, null);
            }
        };
        uploadMediaFileTask.ahA();
        GameWebViewMainProcessService.a(uploadMediaFileTask);
    }
}
