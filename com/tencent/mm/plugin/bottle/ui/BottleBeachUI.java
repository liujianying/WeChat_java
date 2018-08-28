package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.m;
import com.tencent.mm.ac.m$a$a;
import com.tencent.mm.ac.z;
import com.tencent.mm.aq.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.jsapi.contact.d;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.bottle.ui.OpenBottleUI.1;
import com.tencent.mm.plugin.bottle.ui.OpenBottleUI.4;
import com.tencent.mm.plugin.bottle.ui.ThrowBottleUI.2;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.widget.MMEditText;

@a(1)
public class BottleBeachUI extends MMActivity implements OnClickListener, e, m$a$a, b {
    private MoonImageView hkA;
    private ImageView hkB;
    private int hkC = 0;
    boolean hkD = true;
    private ImageView hkE;
    private ImageView hkF;
    private ImageView hkG;
    private TextView hkH;
    private d hkI;
    private b hkJ;
    private boolean hkK = true;
    private View hks;
    private FrameLayout hkt;
    private ThrowBottleUI hku;
    private PickBottleUI hkv;
    private OpenBottleUI hkw;
    private BallonImageView hkx;
    private LightHouseImageView hky;
    private ImageView hkz;
    private p tipDialog = null;

    protected final int getLayoutId() {
        return R.i.bottle_beach;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!q.GW()) {
            au.HU();
            c.FQ().b(new g(11, 1));
        }
        initView();
        au.DF().a(d.CTRL_INDEX, this);
        au.DF().a(new com.tencent.mm.plugin.bottle.a.d(), 0);
    }

    protected void onResume() {
        super.onResume();
        auo();
        this.mController.tlX.postDelayed(new 1(this), 1000);
        if (this.hkC == 3 && this.hkw != null) {
            OpenBottleUI openBottleUI = this.hkw;
            if (openBottleUI.bGS != null && openBottleUI.bGS.ckz()) {
                OpenBottleUI.hlW.a(openBottleUI);
            }
            openBottleUI.setScreenEnable(true);
            openBottleUI.hmf = bi.VG();
        }
        au.HU();
        c.FW().a(this);
        z.Ni().a(this);
        au.DF().a(s$l.AppCompatTheme_ratingBarStyle, this);
    }

    protected void onPause() {
        super.onPause();
        if (this.hkC == 1 && this.hku != null) {
            this.hku.auH();
        }
        if (this.hkC == 3 && this.hkw != null) {
            this.hkw.onPause();
        }
        if (au.HX()) {
            au.HU();
            c.FW().b(this);
            au.DF().b(s$l.AppCompatTheme_ratingBarStyle, this);
        }
        z.Ni().b(this);
    }

    public void onDestroy() {
        if (this.hku != null) {
            ThrowBottleUI throwBottleUI = this.hku;
            throwBottleUI.hne = null;
            throwBottleUI.hnh = null;
            if (throwBottleUI.hni != null) {
                throwBottleUI.hni.cancel();
                throwBottleUI.hni = null;
            }
            if (throwBottleUI.hnj != null) {
                throwBottleUI.hnj.release();
            }
            throwBottleUI.hnj = null;
            throwBottleUI.hnk = null;
            throwBottleUI.hlO = null;
            if (throwBottleUI.hnf != null) {
                throwBottleUI.hnf.release();
            }
            this.hku = null;
        }
        if (this.hkv != null) {
            PickBottleUI pickBottleUI = this.hkv;
            pickBottleUI.handler.removeCallbacks(pickBottleUI.hmn);
            pickBottleUI.handler.removeCallbacks(pickBottleUI.hmo);
            pickBottleUI.hlO = null;
            pickBottleUI.hmj = null;
            pickBottleUI.hmk = null;
            this.hkv = null;
        }
        if (this.hkI != null) {
            this.hkI.cancel();
            this.hkI.context = null;
            this.hkI = null;
        }
        if (this.hkw != null) {
            OpenBottleUI openBottleUI = this.hkw;
            if (openBottleUI.bGS != null && openBottleUI.bGS.ckz()) {
                openBottleUI.aux();
            }
            openBottleUI.hlO = null;
            if (openBottleUI.hlX != null) {
                openBottleUI.hlX.release();
                openBottleUI.hlX = null;
            }
            OpenBottleUI.hlW = null;
            au.HU();
            c.FR().b(openBottleUI);
            this.hkw = null;
        }
        this.hkx = null;
        this.hky = null;
        this.hkA = null;
        if (this.hkJ != null) {
            this.hkJ.dismiss();
            this.hkJ = null;
        }
        au.DF().b(d.CTRL_INDEX, this);
        super.onDestroy();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        int i = 8;
        setMMTitle(R.l.bottle_beach_title);
        lF(getResources().getColor(R.e.transparent));
        addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, new 2(this));
        setBackBtn(new 3(this));
        boolean ciW = bi.ciW();
        if (this.hkx == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.h.bottle_beach_bg_fl);
            ((FrameLayout) frameLayout.getParent()).removeView(frameLayout);
            ((FrameLayout) getWindow().getDecorView()).addView(frameLayout, 0);
            frameLayout.setBackgroundResource(ciW ? R.g.bottle_day_bg : R.g.bottle_night_bg);
            frameLayout.setVisibility(0);
            this.hkx = (BallonImageView) findViewById(R.h.bottle_ballon_iv);
            this.hky = (LightHouseImageView) findViewById(R.h.bottle_light_house_iv);
            this.hkz = (ImageView) findViewById(R.h.bottle_star_iv);
            this.hkA = (MoonImageView) findViewById(R.h.bottle_moon_iv);
        }
        this.hkx.setVisibility(ciW ? 0 : 8);
        this.hky.setVisibility(ciW ? 8 : 0);
        this.hkA.hkz = this.hkz;
        MoonImageView moonImageView = this.hkA;
        if (!ciW) {
            i = 0;
        }
        moonImageView.setVisibility(i);
        this.hks = findViewById(R.h.bottle_board_frame);
        this.hks.setOnClickListener(new 4(this));
        this.hkE = (ImageView) findViewById(R.h.bottle_opt_throw_tv);
        this.hkF = (ImageView) findViewById(R.h.bottle_opt_pick_tv);
        this.hkG = (ImageView) findViewById(R.h.bottle_opt_list_tv);
        this.hkE.setOnClickListener(this);
        this.hkF.setOnClickListener(this);
        this.hkG.setOnClickListener(this);
        this.hkB = (ImageView) findViewById(R.h.bottle_close_frame_btn);
        this.hkB.setOnClickListener(this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MM.UI.BottleUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (i2 == -2002 && this.hkC == 0) {
            nl(R.l.bottle_banby_expose);
            return;
        }
        switch (lVar.getType()) {
            case s$l.AppCompatTheme_ratingBarStyle /*106*/:
                x.i("MM.UI.BottleUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (!com.tencent.mm.plugin.bottle.a.ezo.a(this.mController.tml, i, i2, str)) {
                    if (i == 4 && i2 == -4) {
                        h.i(this.mController.tml, R.l.address_not_found, R.l.app_tip);
                        return;
                    } else if (i == 0 && i2 == 0) {
                        bja bcS = ((f) lVar).bcS();
                        String a = ab.a(bcS.rvi);
                        com.tencent.mm.aa.q.Kp().g(a, ab.a(bcS.rcn));
                        Intent intent = new Intent();
                        com.tencent.mm.pluginsdk.ui.tools.c.a(intent, bcS, 25);
                        if (bi.oV(a).length() > 0) {
                            if ((bcS.rTe & 8) > 0) {
                                com.tencent.mm.plugin.report.service.h.mEJ.k(10298, a + ",25");
                            }
                            com.tencent.mm.plugin.bottle.a.ezn.d(intent, this.mController.tml);
                            return;
                        }
                        return;
                    } else {
                        Toast.makeText(this.mController.tml, this.mController.tml.getString(R.l.fmt_search_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                }
                return;
            case d.CTRL_INDEX /*152*/:
                auo();
                return;
            default:
                nk(R.l.bottle_get_count_err);
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            if (this.hkC == 3) {
                x.v("MM.UI.BottleUI", "on key dwon");
                if (i == 25 && this.hkw.auz()) {
                    au.HV().fE(0);
                    return true;
                } else if (i == 24 && this.hkw.auz()) {
                    au.HV().fD(0);
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        } else if (!this.hkD) {
            return true;
        } else {
            if (this.hkC == 0) {
                finish();
                return true;
            }
            nm(0);
            return true;
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        Intent intent;
        if (R.h.bottle_opt_throw_tv == id) {
            if (com.tencent.mm.plugin.bottle.a.c.auc() > 0) {
                nm(1);
            } else {
                nl(R.l.bottle_cannot_throw);
            }
        } else if (R.h.bottle_opt_pick_tv == id) {
            if (com.tencent.mm.plugin.bottle.a.c.aud() > 0) {
                nm(2);
            } else {
                nl(R.l.bottle_cannot_pick);
            }
        } else if (R.h.bottle_opt_list_tv == id) {
            if (!this.hkK) {
                aun();
            }
            intent = new Intent();
            intent.setClass(this, BottleConversationUI.class);
            intent.putExtra("conversation_from", "from_beach");
            startActivity(intent);
        } else if (R.h.bottle_close_frame_btn == id) {
            if (this.hkC == 3) {
                this.hkw.onPause();
                this.hkw.aux();
            }
            nm(0);
            n(0, 8, 8, 8);
        } else if (R.h.bottle_picked_result_img == id) {
            String bottleTalker = ((PickedBottleImageView) view).getBottleTalker();
            String realUserName = ((PickedBottleImageView) view).getRealUserName();
            if (realUserName != null && realUserName.length() > 0) {
                nm(0);
                au.HU();
                com.tencent.mm.storage.ab Yg = c.FR().Yg(realUserName);
                if (Yg == null || ((int) Yg.dhP) == 0 || !com.tencent.mm.l.a.gd(Yg.field_type)) {
                    f fVar = new f(realUserName);
                    au.DF().a(fVar, 0);
                    ActionBarActivity actionBarActivity = this.mController.tml;
                    getString(R.l.app_tip);
                    this.tipDialog = h.a(actionBarActivity, getString(R.l.address_searching), true, new 5(this, fVar));
                    return;
                }
                intent = new Intent();
                intent.putExtra("Contact_User", Yg.field_username);
                if (Yg.ckW()) {
                    com.tencent.mm.plugin.report.service.h.mEJ.k(10298, Yg.field_username + ",25");
                    intent.putExtra("Contact_Scene", 25);
                }
                com.tencent.mm.plugin.bottle.a.ezn.d(intent, this.mController.tml);
            } else if (bottleTalker != null) {
                nm(3);
                OpenBottleUI openBottleUI = this.hkw;
                if (openBottleUI.hlX == null) {
                    openBottleUI.hlX = (ThrowBottleAnimUI) openBottleUI.hlO.findViewById(R.h.bottle_throw_anim_lo1);
                    openBottleUI.hlX.setOnThrowEndListener(new 1(openBottleUI));
                }
                if (openBottleUI.hlP == null) {
                    openBottleUI.hlP = (TextView) openBottleUI.findViewById(R.h.bottle_open_text_container);
                    openBottleUI.hlQ = (LinearLayout) openBottleUI.findViewById(R.h.bottle_open_voice_container);
                    openBottleUI.hlR = (FrameLayout) openBottleUI.findViewById(R.h.bottle_open_voice_node_fl);
                    openBottleUI.hlS = (ImageView) openBottleUI.findViewById(R.h.bottle_open_voice_anim_iv);
                    openBottleUI.hlT = (TextView) openBottleUI.findViewById(R.h.bottle_open_voice_length_tv);
                    openBottleUI.hlU = (TextView) openBottleUI.findViewById(R.h.bottle_open_contact_from_tv);
                    openBottleUI.hlV = (TextView) openBottleUI.findViewById(R.h.bottle_open_contact_signature_tv);
                    openBottleUI.hlR.setOnClickListener(openBottleUI);
                }
                openBottleUI.hlY = bottleTalker;
                x.d("MM.Bottle_OpenBottleUI", bottleTalker);
                au.HU();
                openBottleUI.bGS = c.FT().GE(bottleTalker);
                if (openBottleUI.bGS.ckz()) {
                    float bD;
                    openBottleUI.hlP.setVisibility(8);
                    openBottleUI.hlQ.setVisibility(0);
                    openBottleUI.hlR.setMinimumWidth(com.tencent.mm.bp.a.fromDPToPix(openBottleUI.hlO, OpenBottleUI.nr((int) com.tencent.mm.modelvoice.q.E(openBottleUI.bGS))));
                    openBottleUI.hlT.setText(openBottleUI.hlO.getString(R.l.fmt_time_length, new Object[]{Integer.valueOf((int) bD)}));
                    OpenBottleUI.hlW.a(openBottleUI);
                    if (openBottleUI.bGS != null) {
                        bD = com.tencent.mm.modelvoice.q.bD(new n(openBottleUI.bGS.field_content).time);
                        FrameLayout frameLayout = openBottleUI.hlR;
                        openBottleUI.getResources().getString(R.l.bottle_voice_play_btn_text);
                        frameLayout.setContentDescription(String.format("%d", new Object[]{Integer.valueOf((int) bD)}));
                    }
                } else {
                    openBottleUI.hlP.setVisibility(0);
                    openBottleUI.hlQ.setVisibility(8);
                    openBottleUI.hlP.setText(openBottleUI.bGS.field_content);
                    j.g(openBottleUI.hlP, 1);
                }
                openBottleUI.auy();
                if (openBottleUI.hmd == null) {
                    openBottleUI.hmd = (TextView) openBottleUI.findViewById(R.h.expose_bottle);
                    openBottleUI.hmd.setOnClickListener(new 4(openBottleUI));
                }
            } else {
                nm(0);
            }
        }
    }

    private void aun() {
        boolean z = this.hkK;
        fullScreenNoTitleBar(z);
        this.hkK = !z;
    }

    private void nk(int i) {
        CharSequence string = i > 0 ? this.mController.tml.getString(i) : null;
        if (this.hkI == null) {
            this.hkI = new d(this);
        }
        this.hkI.cancel();
        if (string != null) {
            this.hkI.setDuration(0);
            this.hkI.setText(string);
            this.hkI.show();
        }
    }

    public final void nl(int i) {
        if (this.hkJ == null) {
            this.hkJ = new b(this);
        }
        b bVar = this.hkJ;
        bVar.ePz.setText(getString(i));
        this.hkJ.show();
    }

    public final void nm(int i) {
        this.hkC = i;
        nk(0);
        if (this.hkK) {
            aun();
        }
        switch (i) {
            case 0:
                this.hkD = true;
                n(0, 8, 8, 8);
                return;
            case 1:
                n(8, 0, 8, 8);
                return;
            case 2:
                n(8, 8, 0, 8);
                return;
            case 3:
                n(8, 8, 8, 0);
                return;
            default:
                n(8, 8, 8, 8);
                return;
        }
    }

    private void n(int i, int i2, int i3, int i4) {
        x.v("MM.UI.BottleUI", "set frame visible");
        if (this.hkt == null) {
            this.hkt = (FrameLayout) findViewById(R.h.bottle_float_frame_container);
        }
        this.hks.setVisibility(i);
        if (i == 0) {
            auo();
            this.hkB.setVisibility(8);
            YC();
        }
        if (i2 == 0 && this.hku == null) {
            this.hku = (ThrowBottleUI) View.inflate(this, R.i.bottle_throw, null);
            this.hkt.addView(this.hku);
            ThrowBottleUI throwBottleUI = this.hku;
            throwBottleUI.hnf = new ToneGenerator(1, 60);
            throwBottleUI.hni = (Vibrator) throwBottleUI.hlO.getSystemService("vibrator");
            throwBottleUI.hnl = (ImageView) throwBottleUI.findViewById(R.h.bottle_record_volumn_hint);
            throwBottleUI.hnm = (TextView) throwBottleUI.findViewById(R.h.bottle_audio_status_img);
            throwBottleUI.hnm.setVisibility(8);
            throwBottleUI.hnn = (ImageView) throwBottleUI.findViewById(R.h.bottle_record_text_hint);
            throwBottleUI.hno = (MMEditText) throwBottleUI.findViewById(R.h.bottle_throw_edittext);
            throwBottleUI.hnp = throwBottleUI.findViewById(R.h.bottle_throw_bottom_margin_view);
            throwBottleUI.hns = (ThrowBottleFooter) throwBottleUI.findViewById(R.h.bottle_throw_footer);
            throwBottleUI.hml = (ImageView) throwBottleUI.hlO.findViewById(R.h.bottle_close_frame_btn);
            throwBottleUI.hnr = (ImageButton) throwBottleUI.findViewById(R.h.bottle_attach_btn);
            throwBottleUI.hnr.setOnClickListener(throwBottleUI);
            throwBottleUI.hnq = (Button) throwBottleUI.findViewById(R.h.bottle_throw_btn);
            throwBottleUI.hnq.setOnTouchListener(new 2(throwBottleUI));
            throwBottleUI.setOnClickListener(throwBottleUI);
            if (throwBottleUI.hnv == null) {
                throwBottleUI.hnv = (LayoutParams) throwBottleUI.hno.getLayoutParams();
                throwBottleUI.hnx = throwBottleUI.hnv.topMargin;
            }
            throwBottleUI.hns.setOnLayoutChangeListener(new ThrowBottleUI.1(throwBottleUI));
        }
        if (this.hku != null) {
            this.hku.setVisibility(i2);
        }
        if (i3 == 0 && this.hkv == null) {
            this.hkv = (PickBottleUI) View.inflate(this, R.i.bottle_pick, null);
            this.hkt.addView(this.hkv);
            this.hkv.initView();
        }
        if (this.hkv != null) {
            this.hkv.setVisibility(i3);
        }
        if (i3 == 0) {
            this.hkv.setDensity(com.tencent.mm.bp.a.getDensity(this));
            PickBottleUI pickBottleUI = this.hkv;
            pickBottleUI.hmk.setVisibility(8);
            pickBottleUI.hmj.E(Integer.MAX_VALUE, -1, -1);
            pickBottleUI.hml.setVisibility(8);
            pickBottleUI.hlO.hkD = false;
            pickBottleUI.handler.postDelayed(pickBottleUI.hmn, 1000);
        }
        if (i4 == 0 && this.hkw == null) {
            this.hkw = (OpenBottleUI) View.inflate(this, R.i.bottle_open, null);
            this.hkt.addView(this.hkw);
            OpenBottleUI openBottleUI = this.hkw;
            ((Button) openBottleUI.findViewById(R.h.bottle_open_throw_back_btn)).setOnClickListener(openBottleUI);
            ((Button) openBottleUI.findViewById(R.h.bottle_open_reply_btn)).setOnClickListener(openBottleUI);
            openBottleUI.hme = this;
        }
        if (this.hkw != null) {
            this.hkw.setVisibility(i4);
        }
    }

    private void auo() {
        if (this.hkH == null) {
            this.hkH = (TextView) findViewById(R.h.bottle_list_unread_tv);
            this.hkH.setBackgroundResource(r.hd(this.mController.tml));
        }
        int aue = com.tencent.mm.plugin.bottle.a.c.aue();
        this.hkH.setText(String.valueOf(aue));
        this.hkH.setVisibility(aue > 0 ? 0 : 8);
    }

    public final void kX(String str) {
        if (this.hkv != null) {
            PickBottleUI pickBottleUI = this.hkv;
            if (pickBottleUI.hmk != null) {
                PickedBottleImageView pickedBottleImageView = pickBottleUI.hmk;
                if (str.equals(pickedBottleImageView.hkb)) {
                    pickedBottleImageView.iconBitmap = m.d(pickedBottleImageView.hkb, pickedBottleImageView.iconUrl, R.g.nosdcard_headimg);
                    pickedBottleImageView.update();
                    pickedBottleImageView.invalidate();
                }
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        auo();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MM.UI.BottleUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case s$l.AppCompatTheme_panelMenuListTheme /*80*/:
                if (iArr[0] != 0) {
                    h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 6(this), null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
