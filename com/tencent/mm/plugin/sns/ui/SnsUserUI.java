package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$i;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.statusbar.d;

public class SnsUserUI extends MMActivity implements com.tencent.mm.plugin.sns.b.h.a {
    private long dRd = 0;
    private int dYK;
    private long dkA = 0;
    private c fIu = new 7(this);
    private String gtX;
    private boolean nNG;
    private com.tencent.matrix.trace.b.a nYi = new 11(this);
    private boolean ocD = false;
    private String ocI;
    private boolean ocJ;
    private int ocK;
    private View odd;
    private com.tencent.mm.ui.statusbar.c.a ode;
    private OnMenuItemClickListener odq = new 4(this);
    private at ogY;
    private bb ogZ;
    private com.tencent.mm.plugin.sns.model.am.a oha;
    private com.tencent.mm.plugin.sns.ui.bb.a ohb;
    private Runnable ohc = new Runnable() {
        public final void run() {
            SnsUserUI.this.ogY.bDI();
            SnsUserUI.this.ogY.bCb();
        }
    };

    class a extends at$f {
        private ba odt = null;

        a() {
        }

        public void dE(int i, int i2) {
            x.i("MicroMsg.SnsUserUI", "showImg snsinfo snslocalId:%d, pos:%d，mIsSelf:%b ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(SnsUserUI.this.nNG)});
            Intent intent;
            if (SnsUserUI.this.nNG && i2 == -1) {
                g.Ek();
                String str = (String) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sQL, null);
                if (!bi.oW(str)) {
                    byte[] WP = bi.WP(str);
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(WP, 0, WP.length);
                    obtain.setDataPosition(0);
                    try {
                        intent = (Intent) Intent.CREATOR.createFromParcel(obtain);
                        intent.addFlags(268435456);
                        intent.setClass(SnsUserUI.this, SnsUploadUI.class);
                        SnsUserUI.this.startActivity(intent);
                        return;
                    } catch (Exception e) {
                        g.Ek();
                        g.Ei().DT().a(com.tencent.mm.storage.aa.a.sQL, "");
                    }
                }
                this.odt = new ba(SnsUserUI.this);
                this.odt.ofp = new 1(this);
                this.odt.c(0, SnsUserUI.this.mController.tml.getString(i$j.app_field_pic_video));
                this.odt.ofq = new 2(this);
                this.odt.bEo();
                return;
            }
            intent = new Intent(SnsUserUI.this, SnsGalleryUI.class);
            intent.putExtra("sns_gallery_userName", SnsUserUI.this.gtX);
            intent.putExtra("sns_gallery_is_self", SnsUserUI.this.nNG);
            intent.putExtra("sns_gallery_localId", i);
            intent.putExtra("sns_source", SnsUserUI.this.ocK);
            intent.putExtra("sns_gallery_st_time", SnsUserUI.this.ogY.nZI);
            intent.putExtra("sns_gallery_ed_time", SnsUserUI.this.ogY.nZJ);
            if (SnsUserUI.this.ogY != null) {
                intent.putExtra("sns_gallery_limit_seq", SnsUserUI.this.ogY.iKw);
                SnsUserUI.this.oha.h(SnsUserUI.this.gtX, SnsUserUI.this.ogY.dD(i, i2));
                intent.putExtra("sns_gallery_position", SnsUserUI.this.ogY.nZM);
            }
            SnsUserUI.this.startActivityForResult(intent, 8);
        }

        public final void dF(int i, int i2) {
            n xd = af.byo().xd(i);
            if (xd != null) {
                if (xd.field_type == 15) {
                    Intent intent = new Intent(SnsUserUI.this, SnsGalleryUI.class);
                    intent.putExtra("sns_gallery_userName", SnsUserUI.this.gtX);
                    intent.putExtra("sns_gallery_is_self", SnsUserUI.this.nNG);
                    intent.putExtra("sns_gallery_localId", i);
                    intent.putExtra("sns_source", SnsUserUI.this.ocK);
                    intent.putExtra("sns_gallery_st_time", SnsUserUI.this.ogY.nZI);
                    intent.putExtra("sns_gallery_ed_time", SnsUserUI.this.ogY.nZJ);
                    if (SnsUserUI.this.ogY != null) {
                        intent.putExtra("sns_gallery_limit_seq", SnsUserUI.this.ogY.iKw);
                        SnsUserUI.this.oha.h(SnsUserUI.this.gtX, SnsUserUI.this.ogY.dD(i, i2));
                        intent.putExtra("sns_gallery_position", SnsUserUI.this.ogY.nZM);
                    }
                    SnsUserUI.this.startActivityForResult(intent, 8);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.setClass(SnsUserUI.this, SnsCommentDetailUI.class);
                intent2.putExtra("INTENT_TALKER", xd.field_userName);
                intent2.putExtra("INTENT_SNS_LOCAL_ID", v.ai("sns_table_", (long) i));
                SnsUserUI.this.startActivityForResult(intent2, 12);
            }
        }

        public final void xw(int i) {
            n xd = af.byo().xd(i);
            if (xd != null) {
                Intent intent = new Intent();
                intent.setClass(SnsUserUI.this, SnsCommentDetailUI.class);
                intent.putExtra("INTENT_TALKER", xd.field_userName);
                intent.putExtra("INTENT_SNS_LOCAL_ID", v.ai("sns_table_", (long) i));
                SnsUserUI.this.startActivityForResult(intent, 12);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        if (this.mController != null) {
            this.mController.ak(2, false);
        }
        super.onCreate(bundle);
        if (g.Eg().Dx()) {
            com.tencent.mm.l.a Yg;
            this.odd = findViewById(i$f.action_bar_container);
            if (this.odd != null && com.tencent.mm.ui.statusbar.c.uuT) {
                com.tencent.mm.ui.statusbar.c ab = com.tencent.mm.ui.statusbar.c.ab(this);
                3 3 = new 3(this);
                this.ode = 3;
                ab.a(3);
                getWindow().getDecorView().requestApplyInsets();
                d.a(getWindow());
            }
            getWindow().getDecorView().setSystemUiVisibility(1280);
            lF(this.mController.tml.getResources().getColor(i.c.transparent));
            b(new Runnable() {
                public final void run() {
                }
            }, new Runnable() {
                public final void run() {
                    SnsUserUI.this.cqg();
                }
            });
            this.oha = af.bye();
            this.ocK = getIntent().getIntExtra("sns_source", 0);
            this.gtX = getIntent().getStringExtra("sns_userName");
            if (this.gtX == null) {
                this.gtX = "";
            }
            g.Ek();
            this.ocJ = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yc(this.gtX);
            this.ocI = q.GF();
            this.nNG = this.ocI.equals(this.gtX);
            ay byc = af.byc();
            String aG = bi.aG(getIntent().getStringExtra("sns_signature"), "");
            String aG2 = bi.aG(getIntent().getStringExtra("sns_nickName"), "");
            if (this.gtX == null || this.gtX.equals("")) {
                Yg = byc.Yg(this.ocI);
            } else {
                Yg = byc.Yg(this.gtX);
            }
            if (Yg != null && ((int) Yg.dhP) > 0) {
                aG = Yg.signature;
                aG2 = Yg.BK();
                x.i("MicroMsg.SnsUserUI", "contact:user[%s] id[%d] nickname[%s]", new Object[]{Yg.field_username, Integer.valueOf((int) Yg.dhP), aG2});
            }
            this.ogZ = new bb(this);
            this.ogZ.a(this.ocI, this.gtX, aG2, aG, this.ocJ, this.nNG, this.ocK);
            bb bbVar = this.ogZ;
            10 10 = new 10(this);
            this.ohb = 10;
            bbVar.ofW = 10;
            this.ogZ.onCreate();
            if (getIntent().getExtras() != null) {
                getIntent().getExtras().setClassLoader(getClass().getClassLoader());
            }
            initView();
            com.tencent.mm.sdk.b.a.sFg.b(this.fIu);
            return;
        }
        finish();
    }

    public void onDestroy() {
        this.ocD = true;
        com.tencent.mm.sdk.b.a.sFg.c(this.fIu);
        b p = b.p(getIntent());
        if (p != null) {
            p.update();
            p.RD();
        }
        if (!(this.ogZ == null || this.ogZ.tipDialog == null)) {
            this.ogZ.tipDialog.dismiss();
            this.ogZ.tipDialog = null;
        }
        g.Ek();
        if (g.Eg().Dx() && this.oha != null) {
            this.oha.a(this, this.ohb.getType());
        }
        if (this.ogZ != null) {
            this.ogZ.onDestroy();
        }
        super.onDestroy();
    }

    public void onDrag() {
        super.onDrag();
        cqg();
    }

    protected final int getLayoutId() {
        return i$g.sns_self;
    }

    public void onResume() {
        this.dRd = bi.VE();
        ((com.tencent.matrix.trace.a) com.tencent.matrix.a.tg().g(com.tencent.matrix.trace.a.class)).bsV.a(this.nYi);
        if (this.ogY != null) {
            this.ogY.notifyDataSetChanged();
        }
        setRequestedOrientation(-1);
        if (this.nNG) {
            this.mController.addIconOptionMenu(0, getString(i$j.sns_message_desc), i$i.actionbar_list_icon, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.setClass(SnsUserUI.this, SnsMsgUI.class);
                    intent.putExtra("sns_msg_force_show_all", true);
                    SnsUserUI.this.startActivityForResult(intent, 8);
                    return true;
                }
            });
        } else {
            enableOptionMenu(false);
        }
        setBackBtn(this.odq, i$i.actionbar_icon_dark_back);
        if (this.nNG) {
            setMMTitle(i$j.sns_photo_ui_title);
        } else {
            CharSequence BL;
            x.d("MicroMsg.SnsUserUI", "SnsUserUI, userName:%s, title:%s", new Object[]{this.gtX, this.ogZ.title});
            ab Yg = af.byc().Yg(this.gtX);
            if (Yg != null) {
                x.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is not null");
                BL = Yg.BL();
            } else {
                x.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is null, title:%s", new Object[]{this.ogZ.title});
                BL = this.ogZ.title;
            }
            setMMTitle(com.tencent.mm.plugin.sns.data.i.y(BL));
        }
        bb.onResume();
        super.onResume();
    }

    public void onPause() {
        HardCoderJNI.stopPerformace(HardCoderJNI.hcSNSUserScrollEnable, this.dYK);
        this.dYK = 0;
        bb.onPause();
        super.onPause();
        ((com.tencent.matrix.trace.a) com.tencent.matrix.a.tg().g(com.tencent.matrix.trace.a.class)).bsV.b(this.nYi);
        this.dRd = bi.VE() > this.dRd ? bi.VE() - this.dRd : 1;
        HardCoderJNI.reportFPS(704, HardCoderJNI.hcSNSUserScrollAction, 1, this.dkA, this.dRd);
        this.dkA = 0;
        this.dRd = 0;
    }

    protected final void initView() {
        this.ogY = new at(this, new 12(this), this.gtX, new 13(this));
        this.ogZ.kww.setAdapter(this.ogY);
        this.ogZ.kww.setOnItemClickListener(new 14(this));
        this.ogZ.kww.postDelayed(new 15(this), 500);
        setBackBtn(this.odq, i$i.actionbar_icon_dark_back);
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
        if (this.ogY != null) {
            this.ogY.nQU = str;
            if (str.compareTo(this.ogY.iKw) < 0) {
                x.i("MicroMsg.SnsUserUI", "onFpSetSize addsize %s %s isNeedNP %s", new Object[]{str, this.ogY.iKw, Boolean.valueOf(z)});
                this.ogY.bDI();
            } else {
                x.i("MicroMsg.SnsUserUI", "onFpSetSize addsize passed %s %s isNeedNP %s", new Object[]{str, this.ogY.iKw, Boolean.valueOf(z)});
            }
            this.ogY.bCb();
        }
        if (!z4 || this.ocI.equals(this.gtX)) {
            if (this.ocI.equals(this.gtX) && j != 0) {
                g.Ek();
                g.Ei().DT().a(com.tencent.mm.storage.aa.a.sVE, Long.valueOf(j));
                this.ogY.fn(j);
            }
            this.ogZ.ofU = z2;
            if (z2) {
                this.ogZ.im(false);
            } else if (z) {
                this.oha.b(this.ohb.getType(), this.gtX, this.nNG, this.ocK);
            }
        } else {
            this.ogZ.ofU = true;
            this.ogZ.xk(i);
        }
        if (z3) {
            this.ogZ.nvg.bDn();
        }
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
        af.aRu().removeCallbacks(this.ohc);
        if (this.ogY != null) {
            this.ogY.nZF = z2;
            this.ogY.nQU = str;
            if (str.compareTo(this.ogY.iKw) < 0) {
                x.i("MicroMsg.SnsUserUI", "onNpAddSize addsize %s %s", new Object[]{str, this.ogY.iKw});
                this.ogY.bDI();
            } else {
                x.i("MicroMsg.SnsUserUI", "onNpAddSize addsize passed %s %s", new Object[]{str, this.ogY.iKw});
            }
            this.ogY.bCb();
        }
        if (!z3 || this.ocI.equals(this.gtX)) {
            if (this.ocI.equals(this.gtX) && j != 0) {
                g.Ek();
                g.Ei().DT().a(com.tencent.mm.storage.aa.a.sVE, Long.valueOf(j));
                this.ogY.fn(j);
            }
            this.ogZ.ofU = z;
            if (z) {
                this.ogZ.im(z2);
                return;
            }
            return;
        }
        this.ogZ.ofU = true;
        this.ogZ.xk(i);
    }

    public final void lF(int i) {
        super.lF(i);
        if (VERSION.SDK_INT >= 21 && this.odd != null) {
            this.odd.setBackgroundColor(getWindow().getStatusBarColor());
            d.a(getWindow());
        }
    }

    private void bEB() {
        if (!com.tencent.mm.p.a.bw(this)) {
            x.d("MicroMsg.SnsUserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 18, "", "")), bi.cjd(), this});
            if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 18, "", "")) {
                x.d("MicroMsg.SnsUserUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")), bi.cjd(), this});
                if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")) {
                    l.A(this.mController.tml, new Intent());
                }
            }
        }
    }

    public void onBackPressed() {
        finish();
    }

    public boolean supportNavigationSwipeBack() {
        return super.supportNavigationSwipeBack();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsUserUI", "on activity result, %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (5985 == i && i2 == -1) {
            finish();
            return;
        }
        super.onActivityResult(i, i2, intent);
        this.ogZ.onActivityResult(i, i2, intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.SnsUserUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 18:
                if (iArr[0] == 0) {
                    bEB();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? i$j.permission_camera_request_again_msg : i$j.permission_microphone_request_again_msg;
                if (iArr[0] != 0) {
                    h.a(this, getString(i2), getString(i$j.permission_tips_title), getString(i$j.jump_to_settings), getString(i$j.app_cancel), false, new 5(this), new 6(this));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
