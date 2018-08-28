package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.ui.t.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnsUploadBrowseUI extends SnsBaseGalleryUI implements a {
    private int nTw = 0;
    private ArrayList<String> ogn = new ArrayList();
    private HashMap<Integer, Boolean> ogo = new HashMap();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        if (this.nTu != null) {
            this.nTu.bDr();
            this.nTu.onDestroy();
        }
        af.byl().H(this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.nTu != null) {
            this.nTu.aKx();
        }
    }

    protected void onPause() {
        if (this.nTu != null) {
            this.nTu.onPause();
        }
        super.onPause();
    }

    protected final int getLayoutId() {
        return i$g.sns_browse_img;
    }

    public final void bEq() {
        Intent intent = new Intent();
        List<b> flipList = this.nTu.getFlipList();
        if (flipList != null) {
            this.ogn.clear();
            for (b bVar : flipList) {
                Object substring;
                String str = af.getAccSnsTmpPath() + bVar.caK.ksA;
                if (bVar.caK.ksA.startsWith("pre_temp_extend_pic")) {
                    substring = bVar.caK.ksA.substring(19);
                } else {
                    String substring2 = str;
                }
                this.ogn.add(substring2);
            }
            intent.putExtra("sns_gallery_temp_paths", this.ogn);
            intent.putExtra("sns_update_preview_image_count", this.ogo.size());
            this.ogo.clear();
            setResult(-1, intent);
            finish();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
        bEq();
        return true;
    }

    protected final void initView() {
        String aG = bi.aG(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.ogn = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
        if (this.ogn != null) {
            this.nTw = getIntent().getIntExtra("sns_gallery_position", 0);
            this.nTu = new SnsInfoFlip(this);
            this.nTu.setEnableHorLongBmpMode(false);
            this.nTu.setShowTitle(true);
            af.getAccSnsTmpPath();
            this.nTu.a(aj.ch(this.ogn), aG, this.nTw, this.nTp, this);
            this.nTu.setOnPageSelectListener(new 1(this));
            addView(this.nTu);
            setBackBtn(new 2(this));
            addIconOptionMenu(0, i$j.app_delete, e.mm_title_btn_delete_normal, new 3(this));
        }
    }

    public final void ci(String str, int i) {
        if (this.nTu != null) {
            this.nTu.aKx();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsUploadBrowseUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
        }
    }

    protected final int getForceOrientation() {
        return 4;
    }

    public final void cj(String str, int i) {
    }
}
