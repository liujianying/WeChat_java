package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.ar.n;
import com.tencent.mm.ar.r;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.ui.t.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class ArtistBrowseUI extends SnsBaseGalleryUI implements a {
    private String kCA = "";
    private String kfy = "";

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

    protected final int getLayoutId() {
        return i$g.sns_gallery_img;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.nTr.nND);
        setResult(-1, intent);
        finish();
        return true;
    }

    protected final void initView() {
        this.kCA = getIntent().getStringExtra("sns_gallery_artist_lan");
        int intExtra = getIntent().getIntExtra("sns_gallery_position", 0);
        r.Qp();
        this.kfy = n.Qm();
        t(false, 2);
        this.nTu = new SnsInfoFlip(this);
        List ey = aj.ey(this.kCA, this.kfy);
        this.nTu.setShowTitle(true);
        this.nTu.a(ey, "", intExtra, this.nTp, this);
        addView(this.nTu);
        setBackBtn(new 1(this));
        setMMTitle(i$j.sns_ui_setback);
        showOptionMenu(false);
        this.nTp.setCallBack(new 2(this));
    }

    protected void onPause() {
        if (this.nTu != null) {
            this.nTu.onPause();
        }
        super.onPause();
    }

    public final void ci(String str, int i) {
        if (this.nTu != null) {
            this.nTu.aKx();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.ArtistBrowseUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            this.nTr.xg(intent.getIntExtra("sns_gallery_op_id", 0));
        }
    }

    public final void cj(String str, int i) {
    }
}
