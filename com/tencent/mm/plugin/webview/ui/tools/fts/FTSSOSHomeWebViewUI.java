package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.fts.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayoutWithAll;
import com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout;
import com.tencent.mm.ui.tools.g;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class FTSSOSHomeWebViewUI extends BaseSOSWebViewUI {
    private FTSMainUIEducationLayout jwW;
    private OnClickListener jxn = new 16(this);
    private View mTX;
    private View neM;
    private View qdJ;
    private a qdK;
    private b qdL;
    private c qdM;
    private d qdN;
    private float qdO = Float.MAX_VALUE;
    private FTSMainUIHotWordLayout qdP;
    private FTSMainUIEducationLayoutWithAll qdQ;
    private View qdR;
    private TextView qdS;
    private View qdT;
    private View qdU;
    private View qdV;
    b qdW;
    private int qdX;
    private boolean qdY;
    private int qdZ = 0;
    private String qea = "";
    boolean qeb;
    boolean qec;
    private int qed = 0;
    private int qee = 0;
    private String qef = "";
    private OnClickListener qeg = new 17(this);
    private a$a qeh = new 2(this);
    private a$a qei = new 3(this);
    private a$a qej = new 4(this);
    private String qek;
    int qel;
    private OnClickListener qem = new 5(this);
    private OnItemClickListener qen = new 6(this);
    private OnClickListener qeo = new 7(this);
    private boolean qep;
    private TextView titleView;

    static /* synthetic */ void B(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        if (fTSSOSHomeWebViewUI.qdQ.getVisibility() == 0) {
            fTSSOSHomeWebViewUI.bXw();
        } else if (fTSSOSHomeWebViewUI.qdQ.getVisibility() != 0) {
            fTSSOSHomeWebViewUI.qdQ.setVisibility(0);
            fTSSOSHomeWebViewUI.qdT.setVisibility(0);
            fTSSOSHomeWebViewUI.qdQ.getViewTreeObserver().addOnPreDrawListener(new 8(fTSSOSHomeWebViewUI));
        }
    }

    static /* synthetic */ void F(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        x.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "setInitStatus originInputX %f, x %f ", new Object[]{Float.valueOf(fTSSOSHomeWebViewUI.qdO), Float.valueOf(fTSSOSHomeWebViewUI.qdi.getX())});
        if (fTSSOSHomeWebViewUI.qdO != Float.MAX_VALUE) {
            fTSSOSHomeWebViewUI.qdi.setX(fTSSOSHomeWebViewUI.qdO);
        }
        fTSSOSHomeWebViewUI.qdV.setBackgroundColor(fTSSOSHomeWebViewUI.getResources().getColor(R.e.websearch_bg));
        fTSSOSHomeWebViewUI.titleView.setVisibility(0);
        fTSSOSHomeWebViewUI.jwW.setVisibility(0);
        fTSSOSHomeWebViewUI.qdP.setVisibility(0);
        View view = fTSSOSHomeWebViewUI.qdJ;
        int i = (fTSSOSHomeWebViewUI.qdo || fTSSOSHomeWebViewUI.qeP) ? 0 : 4;
        view.setVisibility(i);
        fTSSOSHomeWebViewUI.neM.setVisibility(8);
        if (d.fR(23) && !com.tencent.mm.ui.statusbar.d.Af()) {
            fTSSOSHomeWebViewUI.Z(fTSSOSHomeWebViewUI.getResources().getColor(R.e.websearch_bg), true);
        }
        fTSSOSHomeWebViewUI.bXk().aQY();
        fTSSOSHomeWebViewUI.lAV.setVisibility(0);
        fTSSOSHomeWebViewUI.qdR.setVisibility(8);
        fTSSOSHomeWebViewUI.qdQ.setVisibility(8);
        fTSSOSHomeWebViewUI.mPT.setVisibility(8);
        fTSSOSHomeWebViewUI.bXk().aQX();
        fTSSOSHomeWebViewUI.qdj.aQX();
        fTSSOSHomeWebViewUI.AU(0);
        fTSSOSHomeWebViewUI.jwW.setVisibility(0);
        fTSSOSHomeWebViewUI.qdP.setVisibility(0);
        fTSSOSHomeWebViewUI.qdD = 0;
        fTSSOSHomeWebViewUI.qef = "";
        fTSSOSHomeWebViewUI.bXf();
        fTSSOSHomeWebViewUI.bXk().jzo.clearFocus();
        fTSSOSHomeWebViewUI.qdK.clear();
        fTSSOSHomeWebViewUI.qdY = false;
        fTSSOSHomeWebViewUI.bXk().setHint(fTSSOSHomeWebViewUI.getHint());
        fTSSOSHomeWebViewUI.qdj.setVoiceImageButtonVisibile(0);
    }

    static /* synthetic */ void R(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        fTSSOSHomeWebViewUI.qdQ.setVisibility(8);
        fTSSOSHomeWebViewUI.qdT.setVisibility(8);
    }

    static /* synthetic */ void a(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, c cVar, int i) {
        Map hashMap = new HashMap();
        hashMap.put("scene", Integer.valueOf(fTSSOSHomeWebViewUI.aUM()));
        hashMap.put("businessType", "0");
        hashMap.put("scene", Integer.valueOf(fTSSOSHomeWebViewUI.aUM()));
        hashMap.put("docid", cVar.content);
        hashMap.put("docpos", Integer.valueOf(cVar.position + 1));
        hashMap.put("typepos", Integer.valueOf(1));
        hashMap.put("suggestionid", fTSSOSHomeWebViewUI.qek);
        hashMap.put("clicktype", Integer.valueOf(i));
        hashMap.put("clicksource", Integer.valueOf(1));
        hashMap.put("sceneactiontype", Integer.valueOf(1));
        hashMap.put("h5version", Integer.valueOf(p.zP(0)));
        hashMap.put("query", fTSSOSHomeWebViewUI.getInEditTextQuery());
        hashMap.put("sessionid", fTSSOSHomeWebViewUI.getSessionId());
        ad.Qa(p.U(hashMap));
    }

    static /* synthetic */ void g(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i) {
        fTSSOSHomeWebViewUI.qdN.AY(i);
        fTSSOSHomeWebViewUI.qdM.AY(i);
        fTSSOSHomeWebViewUI.qdL.AY(i);
        if (i == b.qfr) {
            fTSSOSHomeWebViewUI.jwW.setVisibility(8);
        }
    }

    static /* synthetic */ void h(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        if (!fTSSOSHomeWebViewUI.qeP) {
            StringBuilder stringBuilder = new StringBuilder(fTSSOSHomeWebViewUI.cbP);
            x.v("MicroMsg.FTS.FTSSOSHomeWebViewUI", "beginLoadingUrl edu.bottom %d, title.bottom %d", new Object[]{Integer.valueOf(fTSSOSHomeWebViewUI.jwW.getBottom()), Integer.valueOf(fTSSOSHomeWebViewUI.mTX.getBottom())});
            stringBuilder.append("&nativeHeight=").append(a.ag(fTSSOSHomeWebViewUI, fTSSOSHomeWebViewUI.jwW.getBottom() - fTSSOSHomeWebViewUI.mTX.getBottom()));
            fTSSOSHomeWebViewUI.cbP = stringBuilder.toString();
            fTSSOSHomeWebViewUI.getIntent().putExtra("rawUrl", fTSSOSHomeWebViewUI.cbP);
            fTSSOSHomeWebViewUI.pXP = fTSSOSHomeWebViewUI.cbP;
            fTSSOSHomeWebViewUI.mhH.loadUrl(fTSSOSHomeWebViewUI.cbP);
        }
    }

    static /* synthetic */ void v(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        fTSSOSHomeWebViewUI.qdZ--;
        fTSSOSHomeWebViewUI.qdJ.setVisibility(0);
    }

    static /* synthetic */ void w(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        fTSSOSHomeWebViewUI.qdZ++;
        fTSSOSHomeWebViewUI.qdJ.setVisibility(4);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void ant() {
        Bundle bundle;
        boolean z = true;
        super.ant();
        this.qdW = new b(this, "sos_home_webview_ui", getMainLooper());
        this.mTX = findViewById(R.h.title_container);
        this.qdV = findViewById(R.h.title_container_bg);
        this.qdU = findViewById(R.h.search_bar_underline);
        this.qdT = findViewById(R.h.menu_bg);
        this.qdR = findViewById(R.h.dropdown_menu_container);
        this.qdS = (TextView) findViewById(R.h.dropdown_menu_btn);
        this.qdR.setOnClickListener(this.qeo);
        this.titleView = (TextView) findViewById(R.h.title_tv);
        this.qdJ = findViewById(R.h.webview_keyboard_ll);
        ((WebViewKeyboardLinearLayout) this.qdJ).setOnkbdStateListener(new 1(this));
        this.jwW = (FTSMainUIEducationLayout) findViewById(R.h.search_education_layout);
        this.jwW.setOnCellClickListener(this.jxn);
        this.jwW.setCellClickable(false);
        this.jwW.getViewTreeObserver().addOnGlobalLayoutListener(new 10(this));
        this.qdQ = (FTSMainUIEducationLayoutWithAll) findViewById(R.h.search_education_layout_with_all);
        this.qdQ.setOnCellClickListener(this.jxn);
        this.qdQ.setCellClickable(true);
        this.qdP = (FTSMainUIHotWordLayout) findViewById(R.h.search_hotword_layout);
        this.qdP.setOnCellClickListener(this.qeg);
        this.qdL = new b(this, this.qdi, this.titleView, bXk().getIconView(), this.lAV, this.mPT, bXk().getEditText(), this.qdU, this.mTX, this.qdV);
        this.qdL.a(this.qeh);
        this.qdM = new c(this, this.qdi, this.titleView, bXk().getIconView(), this.lAV, this.mPT, bXk().getEditText(), this.qdU, this.mTX, this.qdV);
        this.qdM.a(this.qej);
        this.qdN = new d(this, this.qdi, this.titleView, bXk().getIconView(), this.lAV, this.mPT, bXk().getEditText(), this.qdU, this.mTX, this.qdV);
        this.qdN.a(this.qei);
        this.qdK = new a(this, (byte) 0);
        this.neM = findViewById(R.h.sos_shadow_view);
        try {
            bundle = new Bundle();
            bundle.putString("key", "educationTab");
            Bundle p = this.gcO.p(2, bundle);
            String string = p.getString("result");
            String string2 = p.getString("result_1");
            if (string2 != null) {
                string = string2;
            }
            this.jwW.J(new JSONObject(string));
        } catch (Exception e) {
        }
        try {
            bundle = new Bundle();
            bundle.putString("key", "tabSlice");
            this.qdQ.J(new JSONObject(this.gcO.p(2, bundle).getString("result")));
        } catch (Exception e2) {
        }
        findViewById(R.h.content_layout).setOnTouchListener(new 11(this));
        this.qdT.setOnClickListener(new 12(this));
        this.titleView.setText(getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE));
        this.qdX = ((LayoutParams) this.titleView.getLayoutParams()).leftMargin - ((int) getResources().getDimension(R.f.sos_search_edittext_margin));
        bXk().czi();
        boolean z2 = getIntent() != null && getIntent().getBooleanExtra("ftsInitToSearch", false);
        this.qeb = z2;
        if (getIntent() == null || !getIntent().getBooleanExtra("ftsHardcodeTitle", false)) {
            z = false;
        }
        this.qec = z;
        if (this.qeb) {
            this.qdV.setBackgroundColor(getResources().getColor(R.e.transparent));
            b bVar = this.qdW;
            bVar.b(bVar.qeB);
        } else {
            this.qdW.bXx();
        }
        this.qdW.start();
        try {
            bundle = new Bundle();
            bundle.putString("key", "searchID");
            this.qea = this.gcO.p(6, bundle).getString("result");
            ad.ai(this.qea, getSessionId(), this.jwW.getVertBizTypes());
        } catch (Exception e3) {
        }
        ad.Ab(aUM());
        AbsoluteLayout absoluteLayout = (AbsoluteLayout) this.mhH.getView();
        absoluteLayout.setOnTouchListener(new 13(this, absoluteLayout));
        this.qdi.getViewTreeObserver().addOnPreDrawListener(new 14(this));
        if (this.qeP) {
            this.qdJ.setVisibility(0);
        } else {
            this.qdJ.setVisibility(4);
        }
        this.qdj.setVoiceBtnClickListener(new 15(this));
        AU(this.qdD);
        ImageButton clearBtn = bXk().getClearBtn();
        if (clearBtn != null) {
            clearBtn.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    Object stringExtra = intent.getStringExtra("text");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        x.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "voice input final text len %d , text %s", new Object[]{Integer.valueOf(Rz(stringExtra).length()), r0});
                        this.qdj.j(r0, null);
                        anx();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static String Rz(String str) {
        if (str == null) {
            return str;
        }
        try {
            if (g.abd(str) <= 100) {
                return str;
            }
            if (str.length() > 200) {
                str = str.substring(0, 200);
            }
            char[] toCharArray = str.toCharArray();
            int length = toCharArray.length;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i < length) {
                i3 += g.abd(String.valueOf(toCharArray[i]));
                if (i3 >= 100) {
                    return str.substring(0, i2) + 8230;
                }
                i++;
                i2++;
            }
            return str;
        } catch (Exception e) {
            return str;
        }
    }

    public final int bXt() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        ad.bTj();
    }

    protected void onPause() {
        super.onPause();
        ad.bTk();
    }

    protected void onDestroy() {
        super.onDestroy();
        ad.bTl();
        ad.bTm();
    }

    protected final Map<String, Object> bXu() {
        Map<String, Object> hashMap = new HashMap();
        if (this.jwW == null || this.mTX == null) {
            return hashMap;
        }
        int bottom;
        x.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "getOnUiInitParams edu.bottom %d, title.bottom %d", new Object[]{Integer.valueOf(this.jwW.getBottom()), Integer.valueOf(this.mTX.getBottom())});
        if (this.jwW.getTop() < this.mTX.getBottom()) {
            bottom = this.jwW.getBottom() - this.mTX.getBottom();
        } else {
            bottom = this.jwW.getBottom();
        }
        hashMap.put("nativeHeight", Integer.valueOf(a.ag(this, bottom)));
        try {
            Bundle p = this.gcO.p(7, null);
            CharSequence string = p == null ? "" : p.getString("data");
            if (!TextUtils.isEmpty(string)) {
                hashMap.put("operationData", string);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSSOSHomeWebViewUI", e, "", new Object[0]);
        }
        return hashMap;
    }

    protected final int anu() {
        if (this.qeb) {
            return -1;
        }
        if (!d.fR(23) || com.tencent.mm.ui.statusbar.d.Af()) {
            return super.anu();
        }
        return getResources().getColor(R.e.websearch_bg);
    }

    public final void fg(boolean z) {
        if (this.qdW.bXy()) {
            super.fg(z);
        }
        this.qdW.Dd(5);
    }

    protected final void bXf() {
        super.bXf();
        AU(this.qdD);
        bXk().setHint(AV(this.qdD));
    }

    private void bXv() {
        try {
            this.qdK.clear();
            x.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "start to update history");
            Bundle bundle = new Bundle();
            bundle.putInt("webview_id", hashCode());
            bundle.putString("query", getInEditTextQuery());
            bundle.putInt("count", 6);
            bundle.putInt("scene", aUM());
            this.gcO.j(3, bundle);
        } catch (RemoteException e) {
        }
    }

    public final void a(String str, String str2, List<com.tencent.mm.plugin.fts.ui.widget.a.b> list, FTSEditTextView.b bVar) {
        if (bVar == FTSEditTextView.b.jzB) {
            this.qel = 0;
        }
        if (this.qdW.bXy()) {
            super.a(str, str2, list, bVar);
        } else if (getTotalQuery().length() == 0) {
            this.jwW.setVisibility(0);
            this.qdP.setVisibility(0);
            this.qdJ.setVisibility(0);
            this.qdK.clear();
        } else {
            this.jwW.setVisibility(8);
            this.qdP.setVisibility(8);
            this.qdJ.setVisibility(4);
            if (bVar != FTSEditTextView.b.jzD) {
                bXv();
            }
        }
    }

    public final boolean anx() {
        if (this.qdo) {
            this.qdW.Dd(0);
            super.anx();
        }
        return true;
    }

    private void AU(int i) {
        this.qdQ.setSelected(i);
        TextView textView = (TextView) this.qdQ.jzN.get(Integer.valueOf(i));
        this.qdS.setText(textView == null ? "" : textView.getText().toString());
        bXk().setIconRes(com.tencent.mm.au.a.b(i, this.mController.tml));
    }

    public final String bXi() {
        if (this.qel == 0) {
            return "";
        }
        return this.qek;
    }

    protected final void bXe() {
        super.bXe();
        this.qdW.Dd(11);
    }

    public final int bXj() {
        return this.qel;
    }

    protected final void bXg() {
        if (this.qdZ <= 0) {
            super.bXg();
            bXk().setHint(getHint());
            this.qdW.Dd(2);
            this.qdi.setBackgroundResource(R.g.sos_round_corner);
            this.neM.setVisibility(8);
            this.qek = null;
            this.qel = 0;
            h.mEJ.h(15521, new Object[]{Integer.valueOf(this.scene), Integer.valueOf(1), bXk().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.qdD)});
        }
    }

    protected final void bXh() {
        super.bXh();
        if (!this.qeP) {
            this.qdJ.setVisibility(0);
            if (this.mhH.getTopView() != null && (this.mhH.getTopView() instanceof AbsoluteLayout)) {
                ((ViewGroup) this.jwW.getParent()).removeView(this.jwW);
                ((AbsoluteLayout) this.mhH.getTopView()).addView(this.jwW, new AbsoluteLayout.LayoutParams(-1, -2, 0, this.qee - this.mTX.getHeight()));
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.sos_home_webview_ui;
    }

    protected final String getHint() {
        return AV(bXo());
    }

    protected final void j(int i, Bundle bundle) {
        super.j(i, bundle);
        switch (i) {
            case 119:
                this.qdW.Dd(8);
                return;
            case 122:
                this.qdW.Dd(10);
                return;
            case 126:
                List arrayList = new ArrayList();
                if (bXk().jzo.hasFocus()) {
                    String string = bundle.getString("query");
                    if (getInEditTextQuery().equals(string)) {
                        int i2 = 0;
                        for (String str : bundle.getStringArrayList("result")) {
                            if (com.tencent.mm.au.a.at(str, string)) {
                                i2++;
                                if (i2 <= 2) {
                                    c cVar = new c(this, (byte) 0);
                                    cVar.type = 1;
                                    cVar.icon = R.k.sos_history;
                                    cVar.content = str;
                                    cVar.qeF = R.g.sos_edittext_clear;
                                    arrayList.add(cVar);
                                }
                            }
                        }
                    }
                }
                ah.A(new 1(this.qdK, arrayList));
                return;
            case 127:
                List arrayList2 = new ArrayList();
                if (bXk().jzo.hasFocus()) {
                    if (getInEditTextQuery().equals(bundle.getString("query"))) {
                        this.qek = bundle.getString("suggestionId");
                        for (String str2 : bundle.getStringArrayList("result")) {
                            c cVar2 = new c(this, (byte) 0);
                            cVar2.type = 2;
                            cVar2.icon = 0;
                            cVar2.content = str2;
                            cVar2.qeF = R.g.sos_up;
                            arrayList2.add(cVar2);
                        }
                    }
                }
                ah.A(new 3(this.qdK, arrayList2));
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.f.h.CTRL_INDEX /*136*/:
                bundle.getString("fts_key_new_query", "");
                this.qdW.Dd(13);
                return;
            default:
                return;
        }
    }

    private String AV(int i) {
        int i2 = -1;
        switch (i) {
            case 1:
                i2 = R.l.search_education_biz_contact;
                break;
            case 2:
                i2 = R.l.search_education_article;
                break;
            case 8:
                i2 = R.l.fts_header_timeline;
                break;
            case 16:
                i2 = R.l.fts_header_poi;
                break;
            case 64:
                i2 = R.l.app_brand_entrance;
                break;
            case 128:
                i2 = R.l.fts_header_emoji_product;
                break;
            case ab.CTRL_BYTE /*256*/:
            case 384:
                i2 = R.l.fts_header_emoji;
                break;
            case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                i2 = R.l.fts_header_music;
                break;
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                i2 = R.l.fts_header_novel;
                break;
        }
        if (i2 < 0) {
            return getString(R.l.search_detail_page_hint, new Object[]{this.qef});
        }
        return getString(R.l.search_detail_page_hint, new Object[]{getString(i2)});
    }

    private void bXw() {
        if (this.qdQ.getVisibility() == 0 && !this.qep) {
            this.qep = true;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.qdQ, View.TRANSLATION_Y, new float[]{0.0f, (float) (-this.qdQ.getHeight())});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.qdT, View.ALPHA, new float[]{1.0f, 0.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(300);
            animatorSet.setInterpolator(new AccelerateInterpolator());
            animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat});
            animatorSet.addListener(new 9(this));
            animatorSet.start();
        }
    }

    public void onBackPressed() {
        if (this.qdQ.getVisibility() == 0) {
            bXw();
        } else {
            super.onBackPressed();
        }
        bXk().aQY();
    }

    protected final boolean bXq() {
        return (!this.qdW.bXy() || this.qdL.isAnimating || this.qdM.isAnimating || this.qdN.isAnimating) ? false : true;
    }

    protected final boolean bVH() {
        return true;
    }

    public final void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        super.onWebViewScrollChanged(i, i2, i3, i4);
        int min = Math.min(i2, Math.max(a.fromDPToPix(this, this.mhH.getContentHeight()) - this.mhH.getHeight(), 0));
        this.qdL.AX(this.qed - min);
        this.qdM.AX(this.qed - min);
        this.qdN.AX(this.qed - min);
        if (!this.qdW.bXy()) {
            this.qdi.setTranslationY((float) (-min));
        }
    }
}
