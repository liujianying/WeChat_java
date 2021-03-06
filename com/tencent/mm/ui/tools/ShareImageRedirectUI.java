package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.transmit.ShareImageSelectorUI;
import java.util.ArrayList;

@a(7)
public class ShareImageRedirectUI extends MMBaseActivity {
    private String imagePath;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.ShareImageRedirectUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 16, "", "")), bi.cjd(), this});
        if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 16, "", "")) {
            auu();
        }
    }

    private void auu() {
        l.c(this, e.dgl, "microMsg." + System.currentTimeMillis() + ".jpg", 0);
        getWindow().getDecorView().setOnTouchListener(new 1(this));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.ShareImageRedirectUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    auu();
                    return;
                } else {
                    h.a(this, getString(R.l.permission_camera_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 2(this), new 3(this));
                    return;
                }
            default:
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        ArrayList arrayList = null;
        getWindow().getDecorView().setOnTouchListener(null);
        if (i2 != -1) {
            finish();
            return;
        }
        Intent intent2;
        switch (i) {
            case 0:
                Context applicationContext = getApplicationContext();
                au.HU();
                this.imagePath = l.d(applicationContext, intent, c.Gb());
                if (this.imagePath != null) {
                    intent2 = new Intent(this, ShareImageSelectorUI.class);
                    intent2.putExtra("intent_extra_image_path", this.imagePath);
                    startActivityForResult(intent2, 2);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    arrayList = intent.getStringArrayListExtra("Select_Contact");
                }
                if (arrayList != null && arrayList.size() == 1) {
                    Intent intent3 = new Intent(this, ChattingUI.class);
                    intent3.putExtra("Chat_User", (String) arrayList.get(0));
                    startActivity(intent3);
                    finish();
                    return;
                } else if (arrayList == null || arrayList.size() <= 1) {
                    intent2 = new Intent();
                    intent2.putExtra("Ksnsupload_type", 0);
                    intent2.putExtra("sns_kemdia_path", this.imagePath);
                    d.b(this, "sns", ".ui.SnsUploadUI", intent2);
                    finish();
                    return;
                } else {
                    finish();
                    return;
                }
            default:
                return;
        }
    }
}
