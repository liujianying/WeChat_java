package com.tencent.mm.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.api.e;
import com.tencent.mm.api.m;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.af.b;
import com.tencent.mm.ui.af.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.k;
import java.util.ArrayList;

@a(19)
public class MMNewPhotoEditUI extends MMActivity implements e {
    private p fUo = null;
    private int hop;
    private m lqK;
    private String tnP;
    private String tnQ;
    private String tnR;
    private boolean tnS;
    private boolean tnT;
    private final d tnU = new d(this);
    private PhotoEditProxy tnV;
    private Dialog tnW;

    static /* synthetic */ void a(MMNewPhotoEditUI mMNewPhotoEditUI) {
        Intent intent = mMNewPhotoEditUI.getIntent();
        mMNewPhotoEditUI.tnP = intent.getStringExtra("before_photo_edit");
        mMNewPhotoEditUI.tnQ = intent.getStringExtra("after_photo_edit");
        mMNewPhotoEditUI.hop = intent.getIntExtra("from_scene", 0);
        mMNewPhotoEditUI.tnT = intent.getBooleanExtra("from_scene_small_preview", false);
        mMNewPhotoEditUI.tnS = mMNewPhotoEditUI.tnV.isAutoSave();
    }

    static /* synthetic */ void d(MMNewPhotoEditUI mMNewPhotoEditUI, String str) {
        Object obj;
        x.i("MicroMsg.MMNewPhotoEditUI", "[gotoImagePreviewUI] :%s", new Object[]{str});
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList stringArrayListExtra = mMNewPhotoEditUI.getIntent().getStringArrayListExtra("preview_image_list");
        ArrayList stringArrayListExtra2 = mMNewPhotoEditUI.getIntent().getStringArrayListExtra("preview_select_image_list");
        int i = 0;
        while (stringArrayListExtra != null && i < stringArrayListExtra.size()) {
            obj = (String) stringArrayListExtra.get(i);
            if (obj.equalsIgnoreCase(bi.oV(mMNewPhotoEditUI.tnP)) || obj.equalsIgnoreCase(bi.oV(mMNewPhotoEditUI.tnQ))) {
                obj = str;
            }
            arrayList.add(obj);
            i++;
        }
        i = 0;
        while (stringArrayListExtra2 != null && i < stringArrayListExtra2.size()) {
            obj = (String) stringArrayListExtra2.get(i);
            if (obj.equalsIgnoreCase(bi.oV(mMNewPhotoEditUI.tnP)) || obj.equalsIgnoreCase(bi.oV(mMNewPhotoEditUI.tnQ))) {
                obj = str;
            }
            arrayList2.add(obj);
            i++;
        }
        String str2 = null;
        if (!mMNewPhotoEditUI.tnS) {
            str2 = mMNewPhotoEditUI.tnV.getFullPath("photoEdited_" + System.currentTimeMillis());
            j.q(str, str2, false);
        }
        FileOp.deleteFile(mMNewPhotoEditUI.tnQ);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("max_select_count", mMNewPhotoEditUI.getIntent().getIntExtra("max_select_count", 9));
        intent.putExtra("isPreviewPhoto", true);
        intent.putExtra("before_photo_edit", mMNewPhotoEditUI.tnP);
        intent.putExtra("after_photo_edit", str);
        intent.putExtra("tmp_photo_edit", str2);
        Bundle bundle = new Bundle();
        bundle.putString("before_photo_edit", mMNewPhotoEditUI.tnP);
        bundle.putString("after_photo_edit", str);
        bundle.putInt("report_info_emotion_count", mMNewPhotoEditUI.lqK.tX().uc());
        bundle.putInt("report_info_text_count", mMNewPhotoEditUI.lqK.tX().ub());
        bundle.putInt("report_info_mosaic_count", mMNewPhotoEditUI.lqK.tX().ud());
        bundle.putInt("report_info_doodle_count", mMNewPhotoEditUI.lqK.tX().ue());
        bundle.putBoolean("report_info_iscrop", mMNewPhotoEditUI.lqK.tX().ug());
        bundle.putInt("report_info_undo_count", mMNewPhotoEditUI.lqK.tX().uf());
        bundle.putBoolean("report_info_is_rotation", mMNewPhotoEditUI.lqK.tX().uh());
        intent.putExtra("report_info", bundle);
        str2 = mMNewPhotoEditUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra = mMNewPhotoEditUI.getIntent().getStringExtra("GalleryUI_ToUser");
        if (!bi.oW(str2)) {
            intent.putExtra("GalleryUI_FromUser", str2);
        }
        if (!bi.oW(stringExtra)) {
            intent.putExtra("GalleryUI_ToUser", stringExtra);
        }
        intent.putStringArrayListExtra("preview_image_list", arrayList);
        intent.putStringArrayListExtra("preview_select_image_list", arrayList2);
        mMNewPhotoEditUI.setResult(-1, intent);
        mMNewPhotoEditUI.dO(false);
        mMNewPhotoEditUI.finish();
    }

    protected final int getLayoutId() {
        return c.new_photo_edit_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.cqo();
        this.tnV = new PhotoEditProxy(this.tnU);
        this.tnU.K(new 1(this));
    }

    protected final void initView() {
        FrameLayout frameLayout = (FrameLayout) findViewById(b.content);
        this.lqK = m.bwV.tY();
        m mVar = this.lqK;
        m.a.a aVar = new m.a.a();
        boolean z = (this.hop == 291 || this.hop == 293) ? false : true;
        aVar.bwX = z;
        aVar.bwZ = true;
        aVar.bwW = m.c.bxc;
        aVar.path = this.tnP;
        mVar.a(aVar.uk());
        View aQ = this.lqK.aQ(this.mController.tml);
        aQ.setActionBarCallback(this);
        frameLayout.addView(aQ, new LayoutParams(-1, -1));
        aQ.setSelectedFeatureListener(new 2(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        this.lqK.onDestroy();
        this.tnU.release();
    }

    public void onBackPressed() {
        if (!this.lqK.tW()) {
            if (this.hop == 290 || this.hop == 291) {
                h.mEJ.h(13859, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
            } else if (this.hop == 4 || this.hop == 293) {
                h.mEJ.h(13859, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
            } else {
                h.mEJ.h(13859, new Object[]{Integer.valueOf(0), Integer.valueOf(2)});
            }
            finish();
        }
    }

    public final void onFinish() {
        if (this.hop == 290 || this.hop == 291) {
            h.mEJ.h(13859, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
        } else if (this.hop == 4 || this.hop == 293) {
            h.mEJ.h(13859, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
        } else {
            h.mEJ.h(13859, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
        }
        if (this.hop == 291 || this.hop == 293) {
            k kVar = new k(this.mController.tml);
            kVar.ofp = new 3(this);
            kVar.ofq = new 4(this);
            com.tencent.mm.ui.base.h.a(this.mController.tml, kVar.bEo());
            return;
        }
        DS(-1);
    }

    public final void ua() {
        onBackPressed();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1 && intent != null) {
            x.d("MicroMsg.MMNewPhotoEditUI", "select %s for sending imagePath:%s", new Object[]{intent.getStringExtra("Select_Conv_User"), this.tnR});
            this.tnW = com.tencent.mm.ui.base.h.a(this.mController.tml, getString(af.d.photo_edit_forward_tips), false, null);
            this.tnV.sendImage(intent.getStringExtra("custom_send_text"), this.tnR, this.tnV.getSelfUsername(), r0);
            this.tnW.dismiss();
            if (this.tnS) {
                r.a(this.tnR, this);
            } else {
                FileOp.deleteFile(this.tnR);
            }
            finish();
        } else if (intent == null && !bi.oW(this.tnR) && this.hop == 291) {
            FileOp.deleteFile(this.tnR);
        }
    }

    private void DS(int i) {
        dO(true);
        this.lqK.a(new 5(this, i));
    }

    private void dO(boolean z) {
        x.i("MicroMsg.MMNewPhotoEditUI", "[setProgress] isVisible:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.fUo = p.b(this, getString(af.d.processing), true, 0, null);
        } else if (this.fUo != null && this.fUo.isShowing()) {
            this.fUo.dismiss();
            this.fUo = null;
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
