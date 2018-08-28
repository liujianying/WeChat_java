package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aa.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;

public class BottleWizardStep1 extends MMActivity {
    private ImageView hly = null;

    static /* synthetic */ boolean a(BottleWizardStep1 bottleWizardStep1) {
        au.HU();
        if (c.isSDCardAvailable()) {
            h.a(bottleWizardStep1, "", bottleWizardStep1.getResources().getStringArray(R.c.change_avatar), "", new 4(bottleWizardStep1));
            return true;
        }
        s.gH(bottleWizardStep1);
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private void aut() {
        Bitmap a;
        Bitmap a2 = com.tencent.mm.aa.c.a(ab.XV(q.GF()), false, -1);
        if (a2 == null) {
            a = com.tencent.mm.aa.c.a(q.GF(), false, -1);
        } else {
            a = a2;
        }
        this.hly = (ImageView) findViewById(R.h.image_headimg_wizard);
        if (a != null) {
            this.hly.setImageBitmap(a);
        }
    }

    protected void onResume() {
        super.onResume();
        initView();
        aut();
    }

    protected final int getLayoutId() {
        return R.i.bottle_wizard_step1;
    }

    protected final void initView() {
        setMMTitle(R.l.bottle_beach_title);
        ((LinearLayout) findViewById(R.h.image_headimg_wizard_btn)).setOnClickListener(new 1(this));
        setBackBtn(new 2(this));
        addTextOptionMenu(0, getString(R.l.app_nextstep), new 3(this));
    }

    private void auu() {
        if (!l.c(this, e.dgl, "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
            Toast.makeText(this, getString(R.l.selectcameraapp_none), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.BottleWizardStep1", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    auu();
                    return;
                } else {
                    h.a(this, getString(R.l.permission_camera_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 5(this), null);
                    return;
                }
            default:
                return;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Context applicationContext;
        String d;
        Intent intent2;
        switch (i) {
            case 2:
                if (intent != null) {
                    applicationContext = getApplicationContext();
                    au.HU();
                    d = l.d(applicationContext, intent, c.Gb());
                    if (d != null) {
                        intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_ImgPath", d);
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.aa.q.Kp().c(ab.XV(q.GF()), true, false) + ".crop");
                        a.ezn.a(intent2, 4, this, intent);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                applicationContext = getApplicationContext();
                au.HU();
                d = l.d(applicationContext, intent, c.Gb());
                if (d != null) {
                    intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 1);
                    intent2.putExtra("CropImage_OutputPath", d);
                    intent2.putExtra("CropImage_ImgPath", d);
                    a.ezn.a(this, intent2, 4);
                    return;
                }
                return;
            case 4:
                if (intent != null) {
                    d = intent.getStringExtra("CropImage_OutputPath");
                    if (d == null) {
                        x.e("MicroMsg.BottleWizardStep1", "crop picture failed");
                        return;
                    } else {
                        new o(this.mController.tml, d).b(2, new 6(this));
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
