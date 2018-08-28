package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.io.File;

@a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141031", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareScreenImgUI extends MMActivity {
    private ProgressDialog eHw = null;
    String filePath = null;
    private ag handler = new 1(this);
    private Intent intent = null;
    Uri uri = null;

    static /* synthetic */ void a(ShareScreenImgUI shareScreenImgUI) {
        if (shareScreenImgUI.eHw != null && shareScreenImgUI.eHw.isShowing()) {
            shareScreenImgUI.eHw.dismiss();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle("");
        int a = s.a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
            case 0:
                NotifyReceiver.xA();
                initView();
                return;
            case 1:
                finish();
                return;
            default:
                x.e("MicroMsg.ShareScreenImgUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void initView() {
        this.intent = getIntent();
        if (this.intent == null) {
            x.e("MicroMsg.ShareScreenImgUI", "launch : fail, intent is null");
            czy();
            finish();
            return;
        }
        x.i("MicroMsg.ShareScreenImgUI", "intent = " + this.intent);
        String action = this.intent.getAction();
        this.uri = this.intent.getData();
        if (bi.oW(action)) {
            x.e("MicroMsg.ShareScreenImgUI", "launch : fail, action is null");
            czy();
            finish();
        } else if (action.equals("android.intent.action.VIEW")) {
            x.i("MicroMsg.ShareScreenImgUI", "send signal: " + action);
            if (this.uri == null || !bi.n(this.uri)) {
                x.e("MicroMsg.ShareScreenImgUI", "launch : fail, not accepted: %s", new Object[]{this.uri});
                czy();
                finish();
                return;
            }
            getString(R.l.app_tip);
            this.eHw = h.a(this, getString(R.l.app_waiting), true, new 2(this));
            this.filePath = bi.h(this, this.uri);
            if (!bi.oW(this.filePath)) {
                action = this.filePath;
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                boolean b = o.b(action, decodeResultLogger);
                if (!b && decodeResultLogger.getDecodeResult() >= 2000) {
                    com.tencent.mm.plugin.report.service.h.mEJ.k(12712, KVStatHelper.getKVStatString(action, 3, decodeResultLogger));
                }
                if (b) {
                    czU();
                    return;
                }
            }
            x.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
            czy();
            finish();
        } else {
            x.e("MicroMsg.ShareScreenImgUI", "launch : fail, uri is null");
            czy();
            finish();
        }
    }

    private void czU() {
        int i;
        x.i("MicroMsg.ShareScreenImgUI", "filepath:[%s]", new Object[]{this.filePath});
        Intent intent = getIntent();
        String resolveType = intent.resolveType(this);
        if (resolveType == null || resolveType.length() == 0) {
            x.e("MicroMsg.ShareScreenImgUI", "map : mimeType is null");
            i = -1;
        } else if (resolveType.toLowerCase().contains("image")) {
            i = 0;
        } else {
            x.d("MicroMsg.ShareScreenImgUI", "map : unknown mimetype, send as file");
            i = 3;
        }
        if (i == -1) {
            x.e("MicroMsg.ShareScreenImgUI", "launch, msgType is invalid");
            finish();
            return;
        }
        if (!s.a(getIntent(), "Intro_Switch", false) && au.HW() && !au.Dr()) {
            intent.setData(this.uri);
            intent.setClass(this, MsgRetransmitUI.class);
            intent.putExtra("Retr_File_Name", this.filePath);
            intent.putExtra("Retr_Msg_Type", i);
            intent.putExtra("Retr_Scene", 1);
            intent.putExtra("Retr_start_where_you_are", false);
            intent.addFlags(67108864);
            startActivity(intent);
        } else if (bi.oW(this.filePath)) {
            czy();
        } else {
            Intent intent2 = new Intent(this, ShareImgUI.class);
            intent2.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.filePath)));
            intent2.addFlags(67108864);
            intent2.setType("image/*");
            intent2.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent2);
        }
        finish();
    }

    private void czy() {
        Toast.makeText(this, R.l.shareimg_get_res_fail, 1).show();
    }
}
