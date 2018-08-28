package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.t.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public abstract class SnsBaseGalleryUI extends MMActivity implements a {
    private boolean hkK = true;
    private LinearLayout nTo;
    s nTp;
    private LinearLayout nTq;
    t nTr;
    private boolean nTs = true;
    private TextView nTt = null;
    protected SnsInfoFlip nTu;
    protected Button nTv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        af.byj().N(3, true);
        this.nTo = (LinearLayout) findViewById(f.layout_content);
        this.nTq = (LinearLayout) findViewById(f.content);
        this.nTr = new t(this, this);
        t tVar = this.nTr;
        x.i("MicroMsg.GalleryTitleManager", "onAttach");
        g.Ek();
        g.Eh().dpP.a(TbsListener$ErrorCode.INCR_UPDATE_EXCEPTION, tVar);
        com.tencent.mm.sdk.b.a.sFg.b(tVar.iYS);
        com.tencent.mm.sdk.b.a.sFg.b(tVar.nNd);
    }

    public void onResume() {
        super.onResume();
        if (this.nTp != null) {
            this.nTp.refresh();
        }
    }

    public void addView(View view) {
        this.nTo.addView(view, new LayoutParams(-1, -1));
    }

    @SuppressLint({"ResourceAsColor"})
    public final void t(boolean z, int i) {
        this.nTp = new s(this, i, z);
        this.nTp.setBackgroundColor(c.transparent);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        this.nTp.getBackground().setAlpha(50);
        this.nTq.addView(this.nTp, layoutParams);
        this.nTp.setSnsSource(getIntent().getIntExtra("sns_source", 0));
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.nTr != null) {
            t tVar = this.nTr;
            x.i("MicroMsg.GalleryTitleManager", "onDetch");
            g.Ek();
            g.Eh().dpP.b(TbsListener$ErrorCode.INCR_UPDATE_EXCEPTION, tVar);
            com.tencent.mm.sdk.b.a.sFg.c(tVar.iYS);
            com.tencent.mm.sdk.b.a.sFg.c(tVar.nNd);
        }
        if (this.nTu != null) {
            SnsInfoFlip snsInfoFlip = this.nTu;
            if (snsInfoFlip.nWz != null && (snsInfoFlip.nWz instanceof MMGestureGallery)) {
                MMGestureGallery mMGestureGallery = (MMGestureGallery) snsInfoFlip.nWz;
                mMGestureGallery.uAg.release();
                mMGestureGallery.uAh.release();
                mMGestureGallery.uAf.release();
            }
            this.nTu.onDestroy();
        }
    }

    protected int getLayoutId() {
        return i.g.sns_gallery_img;
    }

    public void cj(String str, int i) {
        if (this.nTs && !af.bxX()) {
            n Nl = af.byo().Nl(str);
            if (Nl == null || Nl.field_snsId == 0) {
                enableOptionMenu(false);
            } else {
                enableOptionMenu(true);
            }
        }
    }

    protected void onPause() {
        if (this.nTu != null) {
            this.nTu.onPause();
        }
        if (this.nTr != null) {
            t tVar = this.nTr;
            if (tVar.nMW != null) {
                aj ajVar = new aj();
                ajVar.bHK.activity = (Activity) tVar.context;
                ajVar.bHK.bHL = tVar.nMW;
                com.tencent.mm.sdk.b.a.sFg.m(ajVar);
                tVar.nMW = null;
                tVar.bJs = 0;
                tVar.bJr = 0;
            }
        }
        super.onPause();
    }

    public final void eP(String str, String str2) {
        if (this.nTs) {
            setMMTitle(str);
            setMMSubTitle(str2);
        }
    }

    public void ci(String str, int i) {
    }

    public void aun() {
        int i = 8;
        boolean z = false;
        if (this.nTs) {
            int i2;
            if (this.hkK) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            setTitleVisibility(i2);
            if (this.nTp != null) {
                s sVar = this.nTp;
                if (!this.hkK) {
                    i = 0;
                }
                sVar.setVisibility(i);
            }
            if (!this.hkK) {
                z = true;
            }
            this.hkK = z;
        }
    }

    public final void bBZ() {
        this.hkK = false;
        setTitleVisibility(8);
        if (this.nTp != null) {
            this.nTp.setVisibility(8);
        }
    }
}
