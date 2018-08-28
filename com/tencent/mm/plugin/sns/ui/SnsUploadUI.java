package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.j;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.e.c.b;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@a(17)
public class SnsUploadUI extends MMActivity implements LocationWidget.a {
    private SnsAdClick bYl = null;
    private String desc;
    private SnsUploadConfigView nLD;
    private boolean nOU = false;
    private int nOh = 0;
    private String nQQ = "";
    private String nQR = "";
    private SnsEditText nRk;
    private z nRl = null;
    private LinearLayout nRm;
    private int nRo = 0;
    private int nRp = 0;
    private ArrayList<String> nRq;
    private boolean nRr = false;
    private boolean nRt = false;
    private long nRu = 0;
    private AtContactWidget ogK;
    private LocationWidget ogL;
    private RangeWidget ogM;
    private SnsUploadSayFooter ogN;
    private KeyboardLinearLayout ogO;
    private boolean ogP = false;
    private boolean ogQ = false;
    private String ogR = null;
    private FrameLayout ogS = null;
    private long ogT = 0;

    static /* synthetic */ boolean b(SnsUploadUI snsUploadUI) {
        snsUploadUI.YC();
        if (!snsUploadUI.ogN.bEw()) {
            return false;
        }
        snsUploadUI.ogN.bEx();
        return true;
    }

    static /* synthetic */ void k(SnsUploadUI snsUploadUI) {
        snsUploadUI.nRk.requestFocus();
        x.d("MicroMsg.SnsUploadUI", "request fouces");
        if (snsUploadUI.ogN.bEw()) {
            snsUploadUI.ogN.bEx();
        }
        if (!t.fC(snsUploadUI)) {
            snsUploadUI.ogN.bEv();
        }
        snsUploadUI.mController.contentView.postInvalidate();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.nRk != null) {
            bundle.putString("contentdesc", this.nRk.getText().toString());
        }
        bundle.getString("contentdesc");
        this.nRl.H(bundle);
        super.onSaveInstanceState(bundle);
    }

    public void onCreate(Bundle bundle) {
        View a;
        LayoutParams layoutParams;
        boolean z = true;
        e.k(this);
        super.onCreate(bundle);
        lF(this.mController.tml.getResources().getColor(c.white));
        cqh();
        getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        this.nRt = getIntent().getBooleanExtra("KSnsPostManu", false);
        this.nRu = getIntent().getLongExtra("KTouchCameraTime", 0);
        this.nOh = getIntent().getIntExtra("Ksnsupload_type", 0);
        this.bYl = (SnsAdClick) getIntent().getParcelableExtra("KsnsAdTag");
        this.nOU = getIntent().getBooleanExtra("Kis_take_photo", false);
        this.ogP = getIntent().getBooleanExtra("need_result", false);
        this.ogQ = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
        this.ogR = getIntent().getStringExtra("Ksnsupload_canvas_info");
        this.nRk = (SnsEditText) findViewById(f.sns_desc_tv);
        this.nRk.setTextSize(1, (ah.fe(this.mController.tml) * this.nRk.getTextSize()) / com.tencent.mm.bp.a.getDensity(this.mController.tml));
        if (!bi.oW(getIntent().getStringExtra(h.thz))) {
            this.nRk.setText(b.d(this.mController.tml, getIntent().getStringExtra(h.thz), this.nRk.getTextSize()));
        } else if (!(this.nRk == null || bundle == null)) {
            CharSequence string = bundle.getString("contentdesc");
            if (string != null) {
                this.nRk.setText(string);
            }
        }
        if (this.nOh == 8) {
            this.nRk.setText(b.d(this.mController.tml, getIntent().getStringExtra(h.thz), this.nRk.getTextSize()));
        }
        this.ogO = (KeyboardLinearLayout) findViewById(f.root);
        this.ogN = (SnsUploadSayFooter) findViewById(f.say_footer);
        this.ogN.setMMEditText(this.nRk);
        this.ogN.setVisibility(8);
        this.ogS = (FrameLayout) findViewById(f.root_fr);
        this.ogS.post(new 17(this));
        this.nRk.setOnClickListener(new 2(this));
        this.nRk.setOnLongClickListener(new 3(this));
        WrapScollview wrapScollview = (WrapScollview) findViewById(f.scroll_view);
        wrapScollview.setContentView(this.nRk);
        wrapScollview.setDoComputeScrollDeltaToGetChildRectOnScreen(false);
        String aG = bi.aG(getIntent().getStringExtra("reportSessionId"), "");
        this.nLD = (SnsUploadConfigView) findViewById(f.config_view);
        SnsUploadConfigView snsUploadConfigView = this.nLD;
        boolean z2 = this.nOh == 14 && !aG.contains("wx5dfbe0a95623607b");
        snsUploadConfigView.ogC = z2;
        if (z2) {
            g.Ek();
            g.Eh().dpP.a(2842, snsUploadConfigView);
            j jVar = new j();
            g.Ek();
            g.Eh().dpP.a(jVar, 0);
        }
        snsUploadConfigView.ogD.rms = -1000.0f;
        snsUploadConfigView.ogD.rmr = -1000.0f;
        if (!snsUploadConfigView.oaw) {
            g.Ek();
            int f = bi.f((Integer) g.Ei().DT().get(68404, null));
            snsUploadConfigView.ogw = (f & 2) != 0;
            snsUploadConfigView.ogx = (f & 8) != 0;
            if (!com.tencent.mm.al.b.PD()) {
                snsUploadConfigView.ogx = false;
            }
            if (!q.He()) {
                snsUploadConfigView.ogw = false;
            }
        }
        snsUploadConfigView.setSyncFacebook(false);
        snsUploadConfigView.c();
        snsUploadConfigView.j();
        snsUploadConfigView.e();
        if (snsUploadConfigView.ogx) {
            snsUploadConfigView.ogE.a(snsUploadConfigView);
        }
        if (this.nOh != 0) {
            SnsUploadConfigView snsUploadConfigView2 = this.nLD;
            snsUploadConfigView2.ogr.setVisibility(8);
            snsUploadConfigView2.ogs.setVisibility(8);
            snsUploadConfigView2.ogt.setVisibility(8);
            snsUploadConfigView2.ogu.setVisibility(8);
        }
        if (this.nOh == 9) {
            this.nLD.ogt.setVisibility(0);
        }
        setBackBtn(new 4(this));
        a(0, getString(i.j.sns_send), new 5(this), s.b.tmX);
        findViewById(f.upload_content).setOnTouchListener(new 6(this));
        this.ogK = (AtContactWidget) findViewById(f.at_contact_widget);
        this.ogK.nLD = this.nLD;
        this.ogL = (LocationWidget) findViewById(f.location_widget);
        this.ogL.setLocationWidgetListener(this);
        switch (this.nOh) {
            case 0:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
                this.ogM = (RangeWidget) findViewById(f.rang_widget_bottom);
                findViewById(f.rang_widget_top).setVisibility(8);
                break;
            case 1:
            case 11:
            case 15:
            case 16:
                this.ogM = (RangeWidget) findViewById(f.rang_widget_bottom);
                findViewById(f.rang_widget_top).setVisibility(8);
                break;
            case 2:
            case 8:
                this.ogM = (RangeWidget) findViewById(f.rang_widget_bottom);
                findViewById(f.rang_widget_top).setVisibility(8);
                this.ogK.setVisibility(8);
                break;
        }
        this.ogM.nLD = this.nLD;
        this.ogL.Y(getIntent());
        this.ogK.Y(getIntent());
        aa(getIntent());
        YC();
        x.d("MicroMsg.SnsUploadUI", "share type %d, isManuSnsPost:%b", new Object[]{Integer.valueOf(this.nOh), Boolean.valueOf(this.nRt)});
        if (this.nOh == 0 || this.nOh == 14 || this.nOh == 9) {
            Parcel obtain = Parcel.obtain();
            getIntent().writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            if (this.nOh == 9) {
                g.Ek();
                g.Ei().DT().a(aa.a.sQM, bi.bE(marshall));
                setMMTitle(this.mController.tml.getResources().getString(i.j.sns_text_title));
            } else {
                g.Ek();
                g.Ei().DT().a(aa.a.sQL, bi.bE(marshall));
                setMMTitle("");
            }
        }
        switch (this.nOh) {
            case 0:
                this.nRl = new ah(this);
                this.nRk.addTextChangedListener(new 1(this));
                break;
            case 1:
            case 11:
            case 15:
            case 16:
                this.nRl = new aa(this);
                break;
            case 2:
                this.nRl = new ac(this);
                break;
            case 3:
                this.nRl = new ai(this, 9);
                break;
            case 4:
                this.nRl = new p(this);
                break;
            case 5:
                this.nRl = new ai(this, 14);
                break;
            case 6:
                this.nRl = new ai(this, 12);
                break;
            case 7:
                this.nRl = new ai(this, 13);
                break;
            case 8:
                this.nRl = new be(this);
                break;
            case 9:
                g.Ek();
                CharSequence aG2 = bi.aG((String) g.Ei().DT().get(68408, ""), "");
                g.Ek();
                int a2 = bi.a((Integer) g.Ei().DT().get(7489, Integer.valueOf(0)), 0);
                if (bi.oW(aG2)) {
                    z = false;
                }
                this.nRl = new ae(this, z);
                this.nRk.setPasterLen(a2);
                this.nRk.setText(b.d(this.mController.tml, aG2, this.nRk.getTextSize()));
                this.nRk.addTextChangedListener(new TextWatcher() {
                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        if (SnsUploadUI.this.nRk.getText().toString().trim().length() > 0) {
                            SnsUploadUI.this.enableOptionMenu(true);
                        } else {
                            SnsUploadUI.this.enableOptionMenu(false);
                        }
                    }

                    public final void afterTextChanged(Editable editable) {
                    }
                });
                break;
            case 10:
                this.nRl = new n(this);
                break;
            case 12:
                this.nRl = new o(this);
                break;
            case 13:
                this.nRl = new q(this);
                break;
            case 14:
                this.nRl = new ad(this);
                break;
        }
        this.nRl.G(bundle);
        View findViewById;
        View findViewById2;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.nRl instanceof a) {
            findViewById = findViewById(f.sns_desc_container_frame);
            View findViewById3 = findViewById(f.sns_img_tips);
            DynamicGridView dynamicGridView = (DynamicGridView) findViewById(f.sns_preview_img_dynamicgrid);
            dynamicGridView.setOnTouchListener(new 11(this));
            a = ((a) this.nRl).a(findViewById, findViewById(f.del_area), dynamicGridView, findViewById3);
            dynamicGridView.setVisibility(0);
            findViewById2 = findViewById(f.widget_line);
            layoutParams2 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
            layoutParams2.addRule(3, f.sns_preview_img_dynamicgrid);
            findViewById2.setLayoutParams(layoutParams2);
        } else {
            findViewById = this.nRl.bBV();
            this.nRm = (LinearLayout) findViewById(f.widget_content);
            this.nRm.setVisibility(0);
            this.nRm.setClipChildren(false);
            if (findViewById != null) {
                this.nRm.addView(findViewById);
            } else {
                this.nRm.setVisibility(8);
            }
            if (this.nOh == 9 || this.nOh == 14) {
                findViewById2 = findViewById(f.widget_line);
                layoutParams2 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams2.topMargin = (int) (((float) (this.nOh == 9 ? 128 : 96)) * com.tencent.mm.sdk.platformtools.c.chu().density);
                findViewById2.setLayoutParams(layoutParams2);
            }
            a = findViewById;
        }
        if (this.nRl instanceof aa) {
            layoutParams = (LayoutParams) a.getLayoutParams();
            layoutParams.width = -1;
            a.setLayoutParams(layoutParams);
        }
        if ((this.nRl instanceof p) || (this.nRl instanceof n) || (this.nRl instanceof o)) {
            layoutParams = (LayoutParams) a.getLayoutParams();
            layoutParams.width = -1;
            a.setLayoutParams(layoutParams);
        }
        bEA();
        this.ogO.setOnkbdStateListener(new KeyboardLinearLayout.a() {
            public final void qN(int i) {
                if (i == -3) {
                    x.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_SHOW");
                    new ag().postDelayed(new 1(this), 100);
                    return;
                }
                new ag().postDelayed(new 2(this), 200);
                x.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_HIDE");
            }
        });
        if (this.nOh == 0) {
            if (!(this.nRl instanceof ah)) {
                x.e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
            } else if (VERSION.SDK_INT < 11) {
                x.d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
            } else {
                new 13(this).run();
            }
        }
        e.l(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        SnsUploadSayFooter snsUploadSayFooter = this.ogN;
        boolean z = snsUploadSayFooter.bEw() || snsUploadSayFooter.getVisibility() == 0;
        if (z) {
            this.ogN.bEx();
            return true;
        }
        bEy();
        return true;
    }

    private void bEy() {
        if ((this.nOh != 0 || ((ah) this.nRl).nPY.nQj.size() <= 0) && this.nOh != 14 && (this.nOh != 9 || bi.oW(this.nRk.getText().toString()))) {
            com.tencent.mm.ui.base.h.a(this, i.j.sns_upload_cancel_tips, 0, i.j.app_alert_exit, i.j.app_cancel, false, new 16(this), null, c.alert_btn_color_warn);
            return;
        }
        com.tencent.mm.ui.base.h.a(this, i.j.sns_upload_exit_and_save_tips, 0, i.j.sns_upload_exit_save, i.j.sns_upload_exit_not_save, true, new 14(this), new 15(this), c.alert_btn_color_no);
    }

    private void bEz() {
        if (this.bYl != null) {
            this.bYl.in(10);
        }
        setResult(0, new Intent());
        finish();
    }

    public final void bEA() {
        if (this.nRl.bBU()) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
    }

    protected void onPause() {
        if (this.nOh == 9) {
            String trim = this.nRk.getText().toString().trim();
            g.Ek();
            g.Ei().DT().set(68408, trim);
            if (bi.oW(trim)) {
                g.Ek();
                g.Ei().DT().set(7489, Integer.valueOf(0));
            } else {
                g.Ek();
                g.Ei().DT().set(7489, Integer.valueOf(this.nRk.getPasterLen()));
            }
        }
        super.YC();
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.ogN.post(new 7(this));
        if (this.nRl != null && (this.nRl instanceof ad)) {
            ad adVar = (ad) this.nRl;
            if (adVar.nOQ != null && !bi.oW(adVar.videoPath)) {
                adVar.nOQ.aO(adVar.videoPath, false);
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.nLD != null) {
            SnsUploadConfigView snsUploadConfigView = this.nLD;
            g.Ek();
            g.Eh().dpP.b(2842, snsUploadConfigView);
        }
        if (this.nRl != null) {
            this.nRl.bBW();
        }
        if (this.ogL != null) {
            this.ogL.stop();
        }
        if (this.ogN != null) {
            SnsUploadSayFooter snsUploadSayFooter = this.ogN;
            if (snsUploadSayFooter.kXH != null) {
                snsUploadSayFooter.kXH.um();
                snsUploadSayFooter.kXH.destroy();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.nRk != null) {
            this.nRk.clearFocus();
        }
        if (i2 == -1) {
            if (this.nRl.d(i, intent)) {
                bEA();
            }
            switch (i) {
                case 5:
                    if (intent != null) {
                        getIntent().putExtras(intent.getExtras());
                        aa(intent);
                        return;
                    }
                    return;
                case 6:
                    if (intent != null) {
                        getIntent().putExtras(intent.getExtras());
                        this.ogK.Y(intent);
                        return;
                    }
                    return;
                case 8:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra("bind_facebook_succ", false);
                        SnsUploadConfigView snsUploadConfigView = this.nLD;
                        if (booleanExtra) {
                            snsUploadConfigView.ogw = true;
                            snsUploadConfigView.setSyncFacebook(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 10:
                    if (intent != null) {
                        getIntent().putExtras(intent.getExtras());
                        this.ogL.Y(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void aa(Intent intent) {
        List list = null;
        this.ogM.a(5, -1, intent, this.ogK);
        int intExtra = intent.getIntExtra("Ktag_range_index", 0);
        if (intExtra >= 2) {
            this.nQQ = intent.getStringExtra("Klabel_name_list");
            this.nQR = intent.getStringExtra("Kother_user_name_list");
            List list2;
            if (bi.oW(this.nQQ)) {
                list2 = null;
            } else {
                list2 = Arrays.asList(this.nQQ.split(","));
            }
            if (!bi.oW(this.nQR)) {
                list = Arrays.asList(this.nQR.split(","));
            }
            this.nRq = new ArrayList();
            this.nRo = 0;
            if (list2 != null && list2.size() > 0) {
                Collection hashSet = new HashSet();
                for (String FA : list2) {
                    List<String> FD = com.tencent.mm.plugin.label.a.a.aYK().FD(com.tencent.mm.plugin.label.a.a.aYK().FA(FA));
                    if (FD == null || FD.size() == 0) {
                        x.e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
                        break;
                    }
                    for (String FA2 : FD) {
                        hashSet.add(FA2);
                        this.nRo++;
                        x.d("MicroMsg.SnsUploadUI", "dz:name : %s", new Object[]{FA2});
                    }
                }
                this.nRq = new ArrayList(hashSet);
            }
            if (list2 != null) {
                int i = 0;
                for (String FA22 : list2) {
                    int i2;
                    if (bi.oW(FA22)) {
                        i2 = i;
                    } else {
                        i2 = i + 1;
                    }
                    i = i2;
                }
                this.nRo = i;
            }
            this.nRp = 0;
            if (list != null && list.size() > 0) {
                for (String FA222 : list) {
                    if (!this.nRq.contains(FA222)) {
                        this.nRq.add(FA222);
                        this.nRp++;
                    }
                }
            }
            if (intExtra == 2) {
                this.nRr = false;
            } else {
                this.nRr = true;
            }
        }
    }

    protected final int getLayoutId() {
        return i.g.sns_upload_ui;
    }

    public final ArrayList<Exif.a> bCh() {
        if (!(this.nRl instanceof ah)) {
            return null;
        }
        ah ahVar = (ah) this.nRl;
        ArrayList arrayList = ahVar.nPY.nQj;
        ArrayList<Exif.a> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Exif.a aVar = (Exif.a) ahVar.nQa.get((String) it.next());
            if (aVar != null) {
                arrayList2.add(aVar);
            }
        }
        return arrayList2;
    }

    public final boolean bCi() {
        return this.nOU;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.SnsUploadUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case a$k.AppCompatTheme_imageButtonStyle /*64*/:
                if (iArr[0] == 0) {
                    this.ogL.bCe();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a(this, getString(i.j.permission_location_request_again_msg), getString(i.j.permission_tips_title), getString(i.j.jump_to_settings), getString(i.j.app_cancel), false, new 8(this), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
