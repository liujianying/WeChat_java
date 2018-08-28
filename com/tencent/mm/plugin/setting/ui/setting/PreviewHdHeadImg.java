package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.aa.g;
import com.tencent.mm.aa.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;

public class PreviewHdHeadImg extends MMActivity {
    private GetHdHeadImageGalleryView kXi;
    private final int mQn = 1;
    private final int mQo = 2;
    private g mQp;
    private String mQq;
    private String username;

    static /* synthetic */ void b(PreviewHdHeadImg previewHdHeadImg) {
        String str = e.dgl + "hdImg_" + com.tencent.mm.a.g.u(previewHdHeadImg.username.getBytes()) + System.currentTimeMillis() + ".jpg";
        FileOp.deleteFile(str);
        FileOp.y(previewHdHeadImg.mQq, str);
        r.a(str, previewHdHeadImg.mController.tml);
        Toast.makeText(previewHdHeadImg.mController.tml, previewHdHeadImg.mController.tml.getString(i.get_hd_head_img_save_tips, new Object[]{e.dgl}), 1).show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        initView();
    }

    protected final int getLayoutId() {
        return a.g.get_hd_head_image_gallery_view;
    }

    protected final void initView() {
        setMMTitle(i.settings_avatar);
        lF(getResources().getColor(c.transparent));
        this.username = q.GF();
        this.kXi = (GetHdHeadImageGalleryView) findViewById(f.gallery);
        this.kXi.setUsername(this.username);
        btu();
        addIconOptionMenu(0, a.e.mm_title_btn_menu, new 1(this));
        setBackBtn(new 2(this));
    }

    private void btu() {
        if (com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
            Bitmap a = com.tencent.mm.aa.c.a(this.username, true, -1);
            if (a == null) {
                a = BitmapFactory.decodeResource(getResources(), a.e.default_avatar);
            }
            if (a == null || a.isRecycled()) {
                x.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[]{this.username});
            } else {
                x.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", new Object[]{this.username});
                this.kXi.setThumbImage(a);
            }
            Bitmap jU = com.tencent.mm.aa.q.Kp().jU(this.username);
            if (jU == null || jU.isRecycled()) {
                this.mQp = new g();
                this.mQp.a(this.username, new 3(this, a));
                return;
            }
            x.i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", new Object[]{this.username});
            d(jU, com.tencent.mm.aa.q.Kp().c(this.username, true, false));
            return;
        }
        s.gH(this.mController.tml);
        d(com.tencent.mm.aa.q.Kp().bJ(this.mController.tml), null);
    }

    private void d(Bitmap bitmap, String str) {
        if (bitmap != null) {
            try {
                Bitmap createBitmap;
                if (bitmap.getWidth() < 480) {
                    float width = 480.0f / ((float) bitmap.getWidth());
                    Matrix matrix = new Matrix();
                    matrix.postScale(width, width);
                    createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                } else {
                    createBitmap = bitmap;
                }
                x.d("MicroMsg.PreviewHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight())});
                this.kXi.setHdHeadImage(createBitmap);
                this.kXi.setHdHeadImagePath(str);
                this.mQq = str;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.PreviewHdHeadImg", e, "", new Object[0]);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.PreviewHdHeadImg", "onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 2:
                    if (intent != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_Filter", true);
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.aa.q.Kp().c(q.GF() + ".crop", true, false));
                        intent2.putExtra("CropImage_ImgPath", null);
                        b.ezn.a(this, intent, intent2, com.tencent.mm.plugin.p.c.Gb(), 4, null);
                        return;
                    }
                    return;
                case 4:
                    new ag(Looper.getMainLooper()).post(new 5(this));
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                        if (stringExtra == null) {
                            x.e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
                            return;
                        } else {
                            new o(this.mController.tml, stringExtra).b(1, new 6(this));
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 2 || i == 4) {
            new ag(Looper.getMainLooper()).post(new 4(this));
        }
    }
}
