package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.plugin.collect.reward.a.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.e;
import java.io.File;
import java.util.HashMap;

@a(1)
public class QrRewardMainUI extends QrRewardBaseUI {
    private String cea;
    private String desc;
    private String fkq;
    private final int hVJ = com.tencent.mm.bp.a.fromDPToPix(this.mController.tml, 200);
    private Button hVK;
    private ViewGroup hVL;
    private ViewGroup hVM;
    private RelativeLayout hVN;
    private CdnImageView hVO;
    private ImageView hVP;
    private ImageView hVQ;
    private MMEditText hVR;
    private TextView hVS;
    private TextView hVT;
    private TextView hVU;
    private TextView hVV;
    private ScrollView hVW;
    private String hVX;
    private String hVY;
    private String hVZ;
    private int hWa;
    private int hWb;
    private boolean hWc;
    private boolean hWd;
    private boolean mIsOpen = false;
    private String username;

    static /* synthetic */ void a(QrRewardMainUI qrRewardMainUI) {
        d dVar = new d(qrRewardMainUI, 1, false);
        dVar.ofp = new 4(qrRewardMainUI);
        dVar.ofq = new 5(qrRewardMainUI);
        dVar.bXO();
    }

    static /* synthetic */ void aCa() {
    }

    static /* synthetic */ void b(QrRewardMainUI qrRewardMainUI) {
        if (!qrRewardMainUI.hWc) {
            qrRewardMainUI.hVW = (ScrollView) ((ViewStub) qrRewardMainUI.findViewById(f.qrmu_save_code_vs)).inflate();
            TextView textView = (TextView) qrRewardMainUI.hVW.findViewById(f.qrsc_user_reward_code_tv);
            String dx = e.dx(e.gT(qrRewardMainUI.username), 10);
            textView.setText(j.a(qrRewardMainUI, qrRewardMainUI.getString(i.qr_reward_save_code_username_wrap_text, new Object[]{dx}), textView.getTextSize()));
            qrRewardMainUI.hWc = true;
        }
        ImageView imageView = (ImageView) qrRewardMainUI.hVW.findViewById(f.qrsc_code_iv);
        ViewGroup viewGroup = (ViewGroup) qrRewardMainUI.hVW.findViewById(f.qrsv_root_view);
        if (!bi.oW(qrRewardMainUI.desc)) {
            ((TextView) qrRewardMainUI.hVW.findViewById(f.qrsc_desc_tv)).setText(j.a(qrRewardMainUI, qrRewardMainUI.getString(i.qr_reward_wrap_text, new Object[]{qrRewardMainUI.desc}), qrRewardMainUI.hVS.getTextSize()));
        }
        qrRewardMainUI.hVW.setVisibility(4);
        ah.i(new 8(qrRewardMainUI, viewGroup, imageView), 250);
    }

    static /* synthetic */ void g(QrRewardMainUI qrRewardMainUI) {
        x.i("MicroMsg.QrRewardMainUI", "show first guide view");
        qrRewardMainUI.hVM.setVisibility(8);
        qrRewardMainUI.hVL.setVisibility(0);
        qrRewardMainUI.hVK.setOnClickListener(new 9(qrRewardMainUI));
    }

    static /* synthetic */ void o(QrRewardMainUI qrRewardMainUI) {
        qrRewardMainUI.hVR.setCursorVisible(true);
        qrRewardMainUI.hVR.requestFocus();
        qrRewardMainUI.hVR.requestFocusFromTouch();
        qrRewardMainUI.showVKB();
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        jr(1323);
        jr(1649);
        this.hWa = ((Integer) g.Ei().DT().get(aa.a.sYN, Integer.valueOf(900))).intValue();
        this.hWb = ((Integer) g.Ei().DT().get(aa.a.sYO, Integer.valueOf(343))).intValue();
        this.desc = (String) g.Ei().DT().get(aa.a.sYQ, "");
        this.hVX = (String) g.Ei().DT().get(aa.a.sYP, "");
        this.hVY = (String) g.Ei().DT().get(aa.a.sYU, "");
        this.hVZ = (String) g.Ei().DT().get(aa.a.sYV, "");
        this.fkq = (String) g.Ei().DT().get(aa.a.sYW, "");
        if (!bi.oW((String) g.Ei().DT().get(aa.a.sYT, ""))) {
            this.hWd = true;
        }
        this.username = q.GF();
        setMMTitle(i.qr_reward_main_title);
        initView();
        if (com.tencent.mm.plugin.collect.reward.b.a.aBR().aBS() && this.hWd) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.QrRewardMainUI", "do get code: %s", new Object[]{Boolean.valueOf(z)});
        b bVar = new b(z);
        bVar.o(this);
        if (z) {
            a(bVar, false, false);
        } else {
            a(bVar, true, false);
        }
    }

    protected final void initView() {
        this.hVK = (Button) findViewById(f.qrmu_open_reward_btn);
        this.hVL = (ViewGroup) findViewById(f.qrmu_no_code_layout);
        this.hVM = (ViewGroup) findViewById(f.qrmu_main_layout);
        this.hVO = (CdnImageView) findViewById(f.qrmu_code_iv);
        this.hVS = (TextView) findViewById(f.qrmu_desc_tv);
        this.hVP = (ImageView) findViewById(f.qrmu_code_avatar_iv);
        this.hVQ = (ImageView) findViewById(f.qrmu_code_avatar_border_iv);
        this.hVN = (RelativeLayout) findViewById(f.qrmu_code_layout);
        this.hVR = (MMEditText) findViewById(f.qrmu_code_word_et);
        this.hVT = (TextView) findViewById(f.qrmu_save_code_tv);
        this.hVV = (TextView) findViewById(f.qrmu_set_code_tv);
        this.hVU = (TextView) findViewById(f.qrmu_bottom_tv);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.hVP, this.username, 0.03f, true);
        try {
            this.hVR.setText(j.a(this.mController.tml, this.hVX, this.hVR.getTextSize()));
            this.hVR.setSelection(this.hVX.length());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.QrRewardMainUI", e, "", new Object[0]);
        }
        this.hVR.addTextChangedListener(new 1(this));
        this.hVR.setOnEditorActionListener(new 10(this));
        this.hVQ.setOnClickListener(new 11(this));
        this.hVT.setClickable(true);
        this.hVT.setOnTouchListener(new m(this));
        com.tencent.mm.plugin.wallet_core.ui.m mVar = new com.tencent.mm.plugin.wallet_core.ui.m(new 12(this));
        CharSequence spannableString = new SpannableString(getString(i.qr_reward_save_code_btn_text));
        spannableString.setSpan(mVar, 0, spannableString.length(), 18);
        this.hVT.setText(spannableString);
        this.hVV.setClickable(true);
        this.hVV.setOnTouchListener(new m(this));
        mVar = new com.tencent.mm.plugin.wallet_core.ui.m(new 13(this));
        spannableString = new SpannableString(getString(i.qr_reward_set_money_title));
        spannableString.setSpan(mVar, 0, spannableString.length(), 18);
        this.hVV.setText(spannableString);
        aBV();
        aBW();
        aBY();
        aBX();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof b) {
            final b bVar = (b) lVar;
            bVar.a(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void i(l lVar) {
                    QrRewardMainUI.this.hVX = bVar.hUX.hqp;
                    QrRewardMainUI.this.hWa = bVar.hUX.rqf;
                    QrRewardMainUI.this.hWb = bVar.hUX.rqb;
                    QrRewardMainUI.this.desc = bVar.hUX.desc;
                    QrRewardMainUI.this.cea = bVar.hUX.plj;
                    QrRewardMainUI.this.mIsOpen = !bVar.hUX.rpZ;
                    QrRewardMainUI.this.hVY = bVar.hUX.hwH;
                    QrRewardMainUI.this.hVZ = bVar.hUX.rqd;
                    QrRewardMainUI.this.hWd = true;
                    QrRewardMainUI.this.aBX();
                    if (QrRewardMainUI.this.mIsOpen) {
                        QrRewardMainUI.this.g(bVar.hUX.mwO, bVar.hUX.rqa, false);
                        QrRewardMainUI.this.aBW();
                        QrRewardMainUI.this.aBY();
                    } else {
                        QrRewardMainUI.g(QrRewardMainUI.this);
                    }
                    QrRewardMainUI.this.fkq = bVar.hUX.mwO;
                    QrRewardMainUI.aCa();
                    x.d("MicroMsg.QrRewardMainUI", "url: %s", new Object[]{QrRewardMainUI.this.fkq});
                }
            }).b(new 15(this, bVar)).c(new 14(this, bVar));
        } else if (lVar instanceof h) {
            final h hVar = (h) lVar;
            hVar.a(new 3(this, hVar)).b(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void i(l lVar) {
                    x.e("MicroMsg.QrRewardMainUI", "set word error: %s, %s", new Object[]{Integer.valueOf(hVar.hVe.hUm), hVar.hVe.hUn});
                    QrRewardMainUI.this.hVX = (String) g.Ei().DT().get(aa.a.sYP, "");
                    QrRewardMainUI.this.eb(bi.oW(QrRewardMainUI.this.hVX));
                    QrRewardMainUI.this.hVR.setText("");
                    QrRewardMainUI.this.aBY();
                    if (!bi.oW(hVar.hVe.hUn)) {
                        Toast.makeText(QrRewardMainUI.this, hVar.hVe.hUn, 0).show();
                    }
                }
            }).c(new 17(this));
            this.hVR.clearFocus();
            this.hVR.setCursorVisible(false);
        }
        return true;
    }

    public final void onKeyboardStateChanged() {
        super.onKeyboardStateChanged();
        x.i("MicroMsg.QrRewardMainUI", "key board changed: %s", new Object[]{Integer.valueOf(this.mController.tmG)});
        if (this.mController.tmG == 2) {
            this.hVX = this.hVR.getText().toString();
            aBZ();
            if (bi.oW(this.hVX)) {
                eb(true);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            this.desc = intent.getStringExtra("key_desc");
            this.hWa = intent.getIntExtra("key_photo_width", 900);
            this.hWb = intent.getIntExtra("key_icon_width", 343);
            x.i("MicroMsg.QrRewardMainUI", "return from first: %s", new Object[]{Boolean.valueOf(intent.getBooleanExtra("key_return_from_first", true))});
            if (intent.getBooleanExtra("key_return_from_first", true)) {
                this.hVM.setVisibility(0);
                this.hVL.setVisibility(8);
            }
            this.hWd = true;
            aBW();
            String stringExtra = intent.getStringExtra("key_photo_url");
            g(stringExtra, intent.getStringExtra("key_photo_aeskey"), true);
            this.fkq = stringExtra;
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.qr_reward_main_ui;
    }

    public void onDestroy() {
        super.onDestroy();
        js(1323);
        js(1649);
        com.tencent.mm.plugin.collect.reward.b.a aBR = com.tencent.mm.plugin.collect.reward.b.a.aBR();
        x.d("MicroMsg.QrRewardCdnDownloadHelper", "do clear callback");
        if (aBR.diQ != null) {
            x.i("MicroMsg.QrRewardCdnDownloadHelper", "callback size: %s", new Object[]{Integer.valueOf(aBR.diQ.size())});
            aBR.diQ.clear();
        }
    }

    protected final boolean Wt() {
        return false;
    }

    private void g(String str, String str2, boolean z) {
        boolean z2 = this.fkq != null && this.fkq.equals(str);
        x.i("MicroMsg.QrRewardMainUI", "do download photo: %s, same url: %s, pic exist: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(com.tencent.mm.plugin.collect.reward.b.a.aBR().aBS())});
        if (z || !z2 || !r3) {
            com.tencent.mm.plugin.collect.reward.b.a aBR = com.tencent.mm.plugin.collect.reward.b.a.aBR();
            AnonymousClass6 anonymousClass6 = new com.tencent.mm.plugin.collect.reward.b.a.a() {
                public final void K(String str, int i, int i2) {
                    x.i("MicroMsg.QrRewardMainUI", "callback ret: %s, %s, %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
                    if (i == 0 && i2 == 0) {
                        ah.A(new 1(this));
                    }
                }
            };
            x.i("MicroMsg.QrRewardCdnDownloadHelper", "downloadImage. imageId:%s", new Object[]{str});
            File file = new File(com.tencent.mm.plugin.collect.reward.b.a.hVf);
            if (!file.exists()) {
                file.mkdirs();
            }
            com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
            iVar.ceW = false;
            iVar.dPV = aBR;
            iVar.field_fullpath = com.tencent.mm.plugin.collect.reward.b.a.hVf + aBR.aBT();
            iVar.field_mediaId = bi.oV(com.tencent.mm.modelcdntran.d.a("QrRewardImg", bi.VF(), q.Hl().field_username, ""));
            iVar.field_fileId = str;
            iVar.field_aesKey = str2;
            iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FILE;
            iVar.field_priority = com.tencent.mm.modelcdntran.b.dOk;
            iVar.field_needStorage = false;
            iVar.field_isStreamMedia = false;
            iVar.field_appType = 0;
            iVar.field_bzScene = 0;
            if (aBR.diQ == null) {
                aBR.diQ = new HashMap();
            }
            aBR.diQ.put(iVar.field_mediaId, anonymousClass6);
            if (!com.tencent.mm.modelcdntran.g.ND().b(iVar, -1)) {
                x.e("MicroMsg.QrRewardCdnDownloadHelper", "ljd: cdntra addSendTask failed. imageId:%s", new Object[]{str});
            }
        }
    }

    private void aBV() {
        if (com.tencent.mm.plugin.collect.reward.b.a.aBR().aBS()) {
            this.hVO.ag(com.tencent.mm.plugin.collect.reward.b.a.hVf + com.tencent.mm.plugin.collect.reward.b.a.aBR().aBT(), this.hVJ, this.hVJ);
            this.hVN.setVisibility(0);
            return;
        }
        this.hVN.setVisibility(4);
    }

    private void aBW() {
        int round = Math.round(((float) this.hVJ) * ((((float) this.hWb) * 1.0f) / ((float) this.hWa)));
        if (round <= 0) {
            round = 248;
        }
        ViewGroup.LayoutParams layoutParams = this.hVQ.getLayoutParams();
        layoutParams.width = round;
        layoutParams.height = round;
        this.hVQ.setLayoutParams(layoutParams);
        layoutParams = this.hVP.getLayoutParams();
        layoutParams.width = round;
        layoutParams.height = round;
        this.hVP.setLayoutParams(layoutParams);
        layoutParams = this.hVR.getLayoutParams();
        layoutParams.width = round - 30;
        layoutParams.height = round - 30;
        this.hVR.setLayoutParams(layoutParams);
        this.hVR.setTextSize(0, (float) ((round * 2) / 3));
        this.hVM.requestLayout();
        if (bi.oW(this.desc)) {
            this.hVS.setText("");
        } else {
            this.hVS.setText(j.a(this, getString(i.qr_reward_wrap_text, new Object[]{this.desc}), this.hVS.getTextSize()));
        }
        eb(bi.oW(this.hVX));
    }

    private void aBX() {
        if (bi.oW(this.hVY)) {
            this.hVU.setVisibility(8);
            return;
        }
        this.hVU.setClickable(true);
        this.hVU.setOnTouchListener(new m(this));
        com.tencent.mm.plugin.wallet_core.ui.m mVar = new com.tencent.mm.plugin.wallet_core.ui.m(new 7(this));
        CharSequence spannableString = new SpannableString(this.hVY);
        spannableString.setSpan(mVar, 0, spannableString.length(), 18);
        this.hVU.setText(spannableString);
        this.hVU.setVisibility(0);
    }

    private void eb(boolean z) {
        x.i("MicroMsg.QrRewardMainUI", "switch mode: %s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.hVP.setVisibility(0);
            this.hVR.setVisibility(4);
            com.tencent.mm.pluginsdk.ui.a.b.a(this.hVP, this.username, 0.03f, true);
            return;
        }
        this.hVP.setVisibility(4);
        this.hVR.setVisibility(0);
    }

    private void aBY() {
        if (!bi.oW(this.hVX)) {
            this.hVR.setText(j.a(this.mController.tml, this.hVX, this.hVR.getTextSize()));
            this.hVR.setSelection(this.hVX.length());
        }
    }

    private void aBZ() {
        x.i("MicroMsg.QrRewardMainUI", "do set photo word");
        h hVar = new h(this.hVX);
        hVar.o(this);
        a(hVar, true, false);
    }
}
