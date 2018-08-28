package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.e$h;
import java.io.File;

@a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141031", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareScreenToTimeLineUI extends MMActivity {
    String filePath = null;
    Uri uri = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle("");
        int a = s.a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.xA();
                au.DF().a(new bg(new 1(this)), 0);
                initView();
                return;
            case 1:
                finish();
                return;
            default:
                x.e("MicroMsg.ShareScreenToTimeLineUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void initView() {
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, intent is null");
            czy();
            finish();
            return;
        }
        String action = intent.getAction();
        this.uri = intent.getData();
        if (bi.oW(action)) {
            x.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, action is null");
            czy();
            finish();
            return;
        }
        String j = s.j(intent, e$h.thz);
        String resolveType = getIntent().resolveType(this);
        if (bi.oW(resolveType)) {
            czy();
            finish();
        } else if (!resolveType.contains("image")) {
            czy();
            finish();
        } else if (action.equals("android.intent.action.VIEW")) {
            x.i("MicroMsg.ShareScreenToTimeLineUI", "send signal: " + action);
            if (bi.n(this.uri)) {
                this.filePath = bi.h(this, this.uri);
                if (!bi.oW(this.filePath) && bi.Xh(this.filePath)) {
                    String str = this.filePath;
                    DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                    boolean b = o.b(str, decodeResultLogger);
                    if (!b && decodeResultLogger.getDecodeResult() >= 2000) {
                        h.mEJ.k(12712, KVStatHelper.getKVStatString(str, 4, decodeResultLogger));
                    }
                    if (b) {
                        gk(this.filePath, j);
                        return;
                    }
                    czy();
                    finish();
                    return;
                } else if (s.a(intent, "Ksnsupload_empty_img", false)) {
                    gk(this.filePath, j);
                    return;
                } else {
                    czy();
                    finish();
                    return;
                }
            }
            x.e("MicroMsg.ShareScreenToTimeLineUI", "fail, not accepted: %s", new Object[]{this.uri});
            czy();
            finish();
        } else {
            x.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, uri is null");
            czy();
            finish();
        }
    }

    private void gk(String str, String str2) {
        Intent intent = new Intent();
        if (!bi.oW(str)) {
            intent.putExtra("sns_kemdia_path", str);
            intent.putExtra("KFilterId", -1);
        }
        if (!bi.oW(str2)) {
            intent.putExtra(e$h.thz, str2);
        }
        if (au.HW() && !au.Dr()) {
            intent.putExtra("K_go_to_SnsTimeLineUI", true);
            d.b(this, "sns", ".ui.SnsUploadUI", intent);
        } else if (bi.oW(str)) {
            czy();
        } else {
            intent = new Intent(this, ShareToTimeLineUI.class);
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
            intent.addFlags(32768).addFlags(268435456);
            intent.setType("image/*");
            intent.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
        }
        finish();
    }

    private void czy() {
        Toast.makeText(this, R.l.shareimg_to_timeline_get_res_fail, 1).show();
    }
}
