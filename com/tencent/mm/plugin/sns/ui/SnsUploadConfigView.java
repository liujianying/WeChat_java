package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.fu;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.i.a$c;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.i.a.b;
import com.tencent.mm.ui.y;

public class SnsUploadConfigView extends LinearLayout implements e, a, b {
    private static String byT = "com.tencent.mm";
    private Context context;
    private ProgressDialog kxR = null;
    boolean oaw = false;
    private boolean ogA = true;
    private boolean ogB = false;
    boolean ogC = false;
    arj ogD = new arj();
    com.tencent.mm.ui.i.a ogE = new com.tencent.mm.ui.i.a();
    ImageView ogr;
    ImageView ogs;
    ImageView ogt;
    ImageView ogu;
    private boolean ogv = false;
    boolean ogw = false;
    boolean ogx = false;
    private boolean ogy = false;
    private boolean ogz = false;

    static /* synthetic */ void m(SnsUploadConfigView snsUploadConfigView) {
        x.e("MicroMsg.SnsUploadConfigView", "dealWithRefreshTokenFail");
        if (snsUploadConfigView.ogw) {
            String string = snsUploadConfigView.getContext().getString(j.app_tip);
            h.a(snsUploadConfigView.getContext(), snsUploadConfigView.getContext().getString(j.facebook_friend_need_rebind), string, new 4(snsUploadConfigView), null);
        }
        snsUploadConfigView.ogw = false;
        snsUploadConfigView.setSyncFacebook(false);
    }

    public SnsUploadConfigView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.context = context;
        View inflate = y.gq(context).inflate(g.sns_upload_config_view, this, true);
        this.ogr = (ImageView) inflate.findViewById(f.sns_sync_facebook_iv);
        this.ogs = (ImageView) inflate.findViewById(f.sns_sync_twitter_iv);
        this.ogt = (ImageView) inflate.findViewById(f.sns_sync_qzone_iv);
        this.ogu = (ImageView) inflate.findViewById(f.sns_sync_weishi_iv);
        if (!com.tencent.mm.al.b.PB()) {
            this.ogt.setVisibility(8);
        }
        com.tencent.mm.kernel.g.Ek();
        if (!com.tencent.mm.kernel.g.Ei().DT().getBoolean(aa.a.sQN, false)) {
            this.ogu.setVisibility(8);
        }
        if (!com.tencent.mm.al.b.PD()) {
            this.ogs.setVisibility(8);
        }
        if (!q.He()) {
            this.ogr.setVisibility(8);
        }
        this.ogt.setOnClickListener(new 1(this, context));
        this.ogu.setOnClickListener(new 8(this, context));
        this.ogr.setOnClickListener(new 9(this));
        this.ogs.setOnClickListener(new 10(this));
    }

    public final void bEr() {
        this.ogv = false;
        this.ogw = false;
        this.ogx = false;
        this.ogy = false;
        this.ogz = false;
        this.ogt.setImageResource(i.album_qzone_icon_normal);
        this.ogu.setImageResource(i.album_wesee_icon_normal);
        this.ogr.setImageResource(i.album_facebook_icon_normal);
        this.ogs.setImageResource(i.album_twitter_icon_normal);
    }

    /* renamed from: bEs */
    final void c() {
        if (this.ogy) {
            boolean z;
            com.tencent.mm.kernel.g.Ek();
            int f = bi.f((Integer) com.tencent.mm.kernel.g.Ei().DT().get(9, null));
            if (f == 0) {
                h.a(getContext(), j.settings_weibo_notice, j.app_tip, new 11(this), new 12(this));
            } else if (f != 0) {
                z = true;
                if (z) {
                    this.ogy = false;
                    return;
                } else {
                    this.ogt.setImageResource(i.album_qzone_icon_pressed);
                    return;
                }
            }
            z = false;
            if (z) {
                this.ogt.setImageResource(i.album_qzone_icon_pressed);
                return;
            } else {
                this.ogy = false;
                return;
            }
        }
        this.ogt.setImageResource(i.album_qzone_icon_normal);
    }

    /* renamed from: bEt */
    final void e() {
        if (this.ogu != null) {
            if (this.ogC) {
                com.tencent.mm.kernel.g.Ek();
                if (com.tencent.mm.kernel.g.Ei().DT().getBoolean(aa.a.sQN, false)) {
                    this.ogu.setVisibility(0);
                    if (this.ogz) {
                        this.ogu.setImageResource(i.album_wesee_icon_pressed);
                        return;
                    } else {
                        this.ogu.setImageResource(i.album_wesee_icon_normal);
                        return;
                    }
                }
            }
            this.ogz = false;
            this.ogu.setVisibility(8);
        }
    }

    void setSyncFacebook(boolean z) {
        if (this.ogw) {
            boolean z2;
            if (q.Hg()) {
                z2 = true;
            } else {
                h.a(getContext(), j.settings_facebook_notice, j.app_tip, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        d.b(SnsUploadConfigView.this.getContext(), "account", ".ui.FacebookAuthUI", new Intent().putExtra("shake_music", true));
                    }
                }, new 14(this));
                z2 = false;
            }
            if (z2) {
                if (!(z || this.ogB || !q.Hg())) {
                    final fu fuVar = new fu();
                    fuVar.bJX = new Runnable() {
                        public final void run() {
                            if (!fuVar.bOv.bJm) {
                                SnsUploadConfigView.m(SnsUploadConfigView.this);
                            }
                        }
                    };
                    com.tencent.mm.sdk.b.a.sFg.a(fuVar, Looper.myLooper());
                }
                this.ogr.setImageResource(i.album_facebook_icon_pressed);
                return;
            }
            this.ogw = false;
            return;
        }
        this.ogr.setImageResource(i.album_facebook_icon_normal);
    }

    /* renamed from: bEu */
    final void j() {
        if (this.ogx) {
            boolean z;
            if (this.ogE.cAo()) {
                z = true;
            } else {
                h.a(getContext(), j.settings_twitter_notice, j.app_tip, new 15(this), new 2(this));
                z = false;
            }
            if (z) {
                this.ogs.setImageResource(i.album_twitter_icon_pressed);
                return;
            } else {
                this.ogx = false;
                return;
            }
        }
        this.ogs.setImageResource(i.album_twitter_icon_normal);
    }

    public int getPrivated() {
        if (this.oaw) {
            return 1;
        }
        return 0;
    }

    public void setPrivated(boolean z) {
        this.oaw = z;
        if (z) {
            bEr();
        }
    }

    public int getSyncFlag() {
        int i = 0;
        if (this.ogv) {
            i = 1;
        }
        if (this.ogw) {
            i |= 2;
        }
        if (this.ogx) {
            i |= 8;
        }
        if (this.ogy) {
            i |= 4;
        }
        if (this.ogz) {
            return i | 16;
        }
        return i;
    }

    public org.b.d.i getTwitterAccessToken() {
        return this.ogE.uFc;
    }

    private void rI(int i) {
        h.a(getContext(), i, j.app_tip, new 5(this), new 6(this));
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0 && lVar != null) {
            e();
        }
    }

    public final void a(a$c a_c) {
        if (this.kxR != null) {
            this.kxR.cancel();
        }
        switch (7.kyp[a_c.ordinal()]) {
            case 1:
                this.ogx = true;
                rI(j.twitterlogin_success);
                break;
            case 2:
                this.ogx = false;
                break;
            case 3:
                this.ogx = false;
                rI(j.twitterlogin_failed);
                break;
        }
        j();
    }

    public final void b(a$c a_c) {
        switch (7.kyp[a_c.ordinal()]) {
            case 3:
                this.ogx = false;
                break;
        }
        j();
    }
}
