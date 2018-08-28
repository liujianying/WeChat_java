package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.g.a;
import com.tencent.mm.ab.g.b;
import com.tencent.mm.aq.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import junit.framework.Assert;

public class OpenBottleUI extends FrameLayout implements OnClickListener, a, b, m.b, SensorController.a {
    static SensorController hlW;
    private com.tencent.mm.e.a.a bAW;
    bd bGS;
    BottleBeachUI hlO;
    TextView hlP;
    LinearLayout hlQ;
    FrameLayout hlR;
    ImageView hlS;
    TextView hlT;
    TextView hlU;
    TextView hlV;
    ThrowBottleAnimUI hlX;
    String hlY;
    private boolean hlZ = true;
    private az hma;
    private long hmb = -1;
    private boolean hmc;
    TextView hmd;
    MMActivity hme;
    long hmf = 0;
    private boolean hmg = false;
    private boolean isDeleteCancel = false;

    public OpenBottleUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hlO = (BottleBeachUI) context;
        au.HU();
        c.FR().a(this);
        if (hlW == null) {
            hlW = new SensorController(context.getApplicationContext());
        }
        if (this.hma == null) {
            this.hma = new az(context.getApplicationContext());
        }
        au.HU();
        Boolean bool = (Boolean) c.DT().get(26, Boolean.valueOf(false));
        this.hmc = bool.booleanValue();
        this.hlZ = !bool.booleanValue();
        if (this.bAW != null) {
            this.bAW.aK(this.hlZ);
        }
    }

    public final void onPause() {
        au.HV().yO();
        if (this.bGS != null && this.bGS.ckz()) {
            aux();
        }
        if (this.bAW != null) {
            if (this.bAW.isPlaying()) {
                stopPlay();
            }
            this.bAW.aK(true);
        }
    }

    public final void aux() {
        if (hlW != null) {
            hlW.ciL();
        }
        this.hma.ciM();
    }

    public void onClick(View view) {
        if (R.h.bottle_open_throw_back_btn == view.getId()) {
            ThrowBottleAnimUI throwBottleAnimUI = this.hlX;
            throwBottleAnimUI.hmZ = this.bGS.ckz();
            throwBottleAnimUI.setVisibility(0);
            throwBottleAnimUI.hlO.hkD = false;
            throwBottleAnimUI.hlO.nm(-1);
            throwBottleAnimUI.auD();
            throwBottleAnimUI.auB();
            throwBottleAnimUI.auC();
            au.HU();
            c.FQ().b(new f(this.hlY, 1));
            this.isDeleteCancel = false;
            Context context = this.hlO;
            this.hlO.getString(R.l.app_tip);
            com.tencent.mm.model.bd.a(this.hlY, new 3(this, h.a(context, this.hlO.getString(R.l.app_waiting), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    OpenBottleUI.this.isDeleteCancel = true;
                }
            })));
            au.HU();
            c.FW().Yp(this.hlY);
            aux();
        } else if (R.h.bottle_open_reply_btn == view.getId()) {
            this.hlO.nm(0);
            Intent intent = new Intent();
            intent.putExtra("Chat_User", this.hlY);
            com.tencent.mm.plugin.bottle.a.ezn.e(intent, this.hlO);
            aux();
        } else if (R.h.bottle_open_voice_node_fl != view.getId()) {
            return;
        } else {
            if (this.bAW == null || !this.bAW.isPlaying()) {
                J(this.bGS);
                return;
            }
        }
        stopPlay();
    }

    final void auy() {
        String str;
        au.HU();
        ab Yg = c.FR().Yg(this.hlY);
        if (!(Yg == null || this.hlO == null)) {
            this.hlU.setText(this.hlO.getString(R.l.bottle_open_contact_from, new Object[]{com.tencent.mm.plugin.bottle.a.c.b(this.hlO, Yg)}));
            this.hlU.setCompoundDrawablesWithIntrinsicBounds(Yg.sex == 1 ? R.k.ic_sex_male : R.k.ic_sex_female, 0, 0, 0);
            this.hlU.setCompoundDrawablePadding(8);
            this.hlV.setText(j.a(this.hlO, Yg.signature, this.hlV.getTextSize()));
        }
        String XV = ab.XV(this.hlY);
        if (bi.oW(XV)) {
            str = this.hlY;
        } else {
            str = XV;
        }
        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) findViewById(R.h.bottle_open_avatar_iv), str);
    }

    static int nr(int i) {
        if (i <= 2) {
            return 100;
        }
        if (i < 10) {
            return ((i - 2) * 8) + 100;
        }
        if (i < 60) {
            return (((i / 10) + 7) * 8) + 100;
        }
        return 204;
    }

    private void J(bd bdVar) {
        if (com.tencent.mm.p.a.by(getContext()) || com.tencent.mm.p.a.bw(this.hlO)) {
            x.d("MM.Bottle_OpenBottleUI", "voip is running, can't use the feature");
            return;
        }
        boolean z = bdVar != null && bdVar.ckz();
        Assert.assertTrue(z);
        if (!(bdVar == null || !bdVar.ckz() || hlW.sIY)) {
            hlW.a(this);
            if (this.hma.Q(new 5(this))) {
                this.hmb = 0;
            } else {
                this.hmb = -1;
            }
        }
        au.HU();
        if (c.isSDCardAvailable() || bi.oW(bdVar.field_imgPath)) {
            if (this.bAW == null) {
                this.bAW = new com.tencent.mm.e.a.a(this.hlO);
            }
            af.Wp("keep_app_silent");
            q.H(bdVar);
            this.bAW.aJ(false);
            if (bdVar == null || !this.bAW.m(bdVar.field_imgPath, this.hlZ)) {
                Toast.makeText(this.hlO, this.hlO.getString(R.l.chatting_play_err), 0).show();
                return;
            }
            au.HV().e(this.hlZ, false, false);
            this.bAW.bCU = this;
            this.bAW.bCT = this;
            this.hlS.setBackgroundResource(R.a.bottle_voice_playing);
            ((AnimationDrawable) this.hlS.getBackground()).start();
            return;
        }
        s.gH(this.hlO);
    }

    private void stopPlay() {
        af.Wq("keep_app_silent");
        aux();
        if (this.hlS.getBackground() instanceof AnimationDrawable) {
            ((AnimationDrawable) this.hlS.getBackground()).stop();
            this.hlS.setBackgroundResource(R.g.bottle_receiver_voice_node);
        }
        if (this.bAW != null) {
            this.bAW.aJ(false);
        }
        setScreenEnable(true);
    }

    public final void wd() {
        x.v("MM.Bottle_OpenBottleUI", "voice play completion");
        stopPlay();
    }

    public final void onError() {
        x.v("MM.Bottle_OpenBottleUI", "voice play error");
        stopPlay();
    }

    public final void a(int i, m mVar, Object obj) {
        x.d("MM.Bottle_OpenBottleUI", "onNotifyChange event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        if (obj == null || !(obj instanceof String)) {
            x.e("MM.Bottle_OpenBottleUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        String str = (String) obj;
        if (!bi.oW(this.hlY) && ab.XV(this.hlY).equals(ab.XV(str))) {
            auy();
        }
    }

    public final boolean auz() {
        if (this.bAW == null || !this.bAW.isPlaying() || this.hlZ) {
            return false;
        }
        return true;
    }

    public final void dK(boolean z) {
        boolean z2 = true;
        if (this.bGS.ckz() && this.bAW != null) {
            if (this.hmg) {
                if (z) {
                    z2 = false;
                }
                this.hmg = z2;
            } else if (z || this.hmb == -1 || bi.bI(this.hmb) <= 400) {
                this.hmg = false;
                if (bi.VG() - this.hmf > 500 && (z || (!z && this.bAW.isPlaying()))) {
                    setScreenEnable(z);
                }
                if (this.hmc) {
                    this.bAW.aK(false);
                    au.HV().e(false, false, false);
                    this.hlZ = false;
                } else if (this.bAW.isPlaying()) {
                    this.bAW.aK(z);
                    au.HV().e(z, false, false);
                    this.hlZ = z;
                    if (!z) {
                        J(this.bGS);
                    }
                } else {
                    this.bAW.aK(true);
                    au.HV().e(true, false, false);
                    this.hlZ = true;
                }
            } else {
                this.hmg = true;
            }
        }
    }

    void setScreenEnable(boolean z) {
        this.hme.setScreenEnable(z);
    }
}
