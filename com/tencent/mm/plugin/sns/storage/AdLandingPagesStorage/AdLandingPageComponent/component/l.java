package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.pluginsdk.ui.d.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class l extends k {
    RelativeLayout kFI;
    Button nDG;
    View nDH;

    static /* synthetic */ void a(l lVar) {
        if (lVar.context instanceof SnsAdNativeLandingPagesUI) {
            ((SnsAdNativeLandingPagesUI) lVar.context).a(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.nDt).nAG, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.nDt).nAD, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.nDt).nAE, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.nDt).nAF, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.nDt).nAB == 1, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.nDt).nAC == 1, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.nDt).nAA == 1);
        }
        lVar.nDH.setPressed(false);
    }

    public l(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l lVar, ViewGroup viewGroup) {
        super(context, lVar, viewGroup);
    }

    protected final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l bAa() {
        return (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt;
    }

    protected final int getLayout() {
        return i$g.sns_ad_native_landing_pages_item_btn;
    }

    @TargetApi(17)
    protected final void bzQ() {
        this.nDh = 0;
        int width = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getWidth();
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nBc > 0.0f && ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nBc < ((float) (width * 2))) {
            width = ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nBb) + (((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nBc) + ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nBa));
        }
        this.kFI.setBackgroundColor(this.backgroundColor);
        if (bi.oW(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAy)) {
            int parseColor;
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (bi.oW(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAx) || ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAv <= 0.0f) {
                boolean z = false;
            } else {
                try {
                    parseColor = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAx);
                } catch (Throwable e) {
                    x.e("MicroMsg.Sns.AdLandingPageBtnComponent", bi.i(e));
                    parseColor = 0;
                }
                gradientDrawable.setStroke((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAv, parseColor);
                parseColor = 1;
            }
            if (!bi.oW(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAw)) {
                int parseColor2;
                try {
                    parseColor2 = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAw);
                } catch (Throwable e2) {
                    x.e("MicroMsg.Sns.AdLandingPageBtnComponent", bi.i(e2));
                    parseColor2 = 0;
                }
                gradientDrawable.setColor(parseColor2);
                parseColor = 1;
            }
            if (parseColor != 0) {
                this.nDG.setBackgroundDrawable(gradientDrawable);
            }
        } else {
            d.b("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAy, false, 0, new 1(this));
        }
        this.nDG.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).title);
        d(this.nDG);
        this.nDG.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).azb);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAu != null && ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAu.length() > 0) {
            try {
                this.nDG.setTextColor(Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAu));
            } catch (Exception e3) {
                x.e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", new Object[]{((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAu});
            }
        }
        try {
            this.nDG.setTextAlignment(4);
        } catch (Exception e4) {
            x.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).height > 0.0f) {
            this.nDG.setLayoutParams(new LayoutParams((width - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nBa)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nBb), (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).height));
        } else {
            this.nDG.setLayoutParams(new LayoutParams((width - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nBa)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nBb), this.nDG.getLayoutParams().height));
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAz == 1) {
            this.nDH.setLayoutParams(new LayoutParams((width - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nBa)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nBb), this.nDH.getLayoutParams().height));
            this.nDH.setVisibility(0);
            this.nDH.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    l.a(l.this);
                    return true;
                }
            });
            this.nDH.setOnClickListener(new 3(this));
            return;
        }
        this.nDH.setVisibility(8);
    }

    protected void d(Button button) {
        button.setOnClickListener(new 4(this));
    }

    protected final void bAb() {
        int intExtra;
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l lVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt;
        String str = "";
        int i = 0;
        if (this.context instanceof Activity) {
            str = ad.Na(((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_rawSnsId"));
            intExtra = ((Activity) this.context).getIntent().getIntExtra("sns_landig_pages_from_source", 0);
            i = ((Activity) this.context).getIntent().getIntExtra("sns_landing_pages_adType", 0);
        } else {
            intExtra = 0;
        }
        String str2;
        SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI;
        String str3;
        String str4;
        String str5;
        if (lVar.bID == 4) {
            f fVar = (f) lVar;
            str2 = fVar.hwD;
            if (this.context instanceof SnsAdNativeLandingPagesUI) {
                snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) this.context;
                str3 = fVar.hvN;
                str4 = (str3 == null || !snsAdNativeLandingPagesUI.nSn.containsKey(str3)) ? str2 : (String) snsAdNativeLandingPagesUI.nSn.get(str3);
            } else {
                str4 = str2;
            }
            x.i("MicroMsg.Sns.AdLandingPageBtnComponent", "ext is " + str4);
            Intent intent = new Intent();
            intent.putExtra("key_card_id", fVar.hvN);
            intent.putExtra("key_card_ext", str4);
            intent.putExtra("key_from_scene", 21);
            intent.putExtra("key_stastic_scene", 15);
            com.tencent.mm.bg.d.b(this.context, "card", ".ui.CardDetailUI", intent);
        } else if (lVar.bID == 8) {
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt) instanceof j) {
                Object stringExtra;
                str5 = "";
                str4 = "";
                if ((this.context instanceof Activity) && bzT().nBm == 2) {
                    str5 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
                    stringExtra = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
                } else {
                    str3 = str4;
                }
                str4 = ((j) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt)).nAW;
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                str = String.format("%s:%s:%s:%s:%d:%s:%s:%d", new Object[]{str5, stringExtra, str4, valueOf, Integer.valueOf(lVar.nBm), lVar.ntU, str, Integer.valueOf(intExtra)});
                j jVar = (j) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt);
                if (this.context instanceof SnsAdNativeLandingPagesUI) {
                    SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI2 = (SnsAdNativeLandingPagesUI) this.context;
                    str3 = snsAdNativeLandingPagesUI2.nyk == null ? "" : snsAdNativeLandingPagesUI2.nyk;
                    snsAdNativeLandingPagesUI2 = (SnsAdNativeLandingPagesUI) this.context;
                    str2 = snsAdNativeLandingPagesUI2.fxE == null ? "" : snsAdNativeLandingPagesUI2.fxE;
                } else {
                    str3 = jVar.nyk;
                    str2 = jVar.nyj;
                }
                str5 = jVar.cbs;
                r5 = new String[2];
                r5[0] = String.format("gdt_vid=%s", new Object[]{str2});
                r5[1] = String.format("weixinadinfo=%s.%s.0.0", new Object[]{str3, str2});
                AdLandingPagesProxy.getInstance().doOpenAppBrand(jVar.username, e.m(str5, r5), str);
            }
        } else if (lVar.bID == 9) {
            g gVar = (g) lVar;
            Intent intent2 = new Intent();
            intent2.putExtra("map_view_type", 1);
            intent2.putExtra("kwebmap_slat", gVar.nAk.kCw);
            intent2.putExtra("kwebmap_lng", gVar.nAk.kCx);
            intent2.putExtra("kwebmap_scale", gVar.nAk.bSz);
            intent2.putExtra("kPoiName", gVar.nAk.bWB);
            intent2.putExtra("Kwebmap_locaion", gVar.nAk.kCz);
            x.i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + gVar.nAk.kCw + ", slong " + gVar.nAk.kCx + ", " + gVar.nAk.bWB);
            com.tencent.mm.bg.d.b(this.context, "location", ".ui.RedirectUI", intent2, 2);
        } else if (lVar.bID == 10) {
            if (a.qPG != null) {
                i iVar = (i) lVar;
                if (iVar.nAj.size() > 1) {
                    a.qPG.a(this.context, iVar.nAj, new 5(this));
                } else if (iVar.nAj.size() > 0) {
                    AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity) this.context, (String) iVar.nAj.get(0));
                }
            }
        } else if (lVar.bID != 11) {
            Intent intent3 = new Intent();
            str4 = lVar.nAs;
            if (!(TextUtils.isEmpty(lVar.nyj) || TextUtils.isEmpty(lVar.nyk))) {
                str4 = ad.l(str4, new String[]{"traceid=" + lVar.nyj + "&aid=" + lVar.nyk});
            }
            x.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open url %s", new Object[]{str4});
            intent3.putExtra("rawUrl", str4);
            intent3.putExtra("useJs", true);
            intent3.putExtra("type", -255);
            intent3.putExtra("geta8key_scene", 2);
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nBm == 0) {
                SnsAdClick snsAdClick = new SnsAdClick(str, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).ntU, i, intExtra);
                Bundle bundle = new Bundle();
                bundle.putParcelable("KSnsAdTag", snsAdClick);
                intent3.putExtra("jsapiargs", bundle);
            }
            if ((this.context instanceof Activity) && ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nBm == 2) {
                str2 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
                str4 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
                if (!bi.oW(str2)) {
                    str3 = String.valueOf(System.currentTimeMillis() / 1000);
                    str = "official_mall_%s_%s_%s_%s";
                    Object[] objArr = new Object[4];
                    if (bi.oW(str4)) {
                        str4 = "";
                    }
                    objArr[0] = str4;
                    objArr[1] = str2;
                    objArr[2] = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAW;
                    objArr[3] = str3;
                    str4 = String.format(str, objArr);
                    intent3.putExtra("prePublishId", str4);
                    intent3.putExtra("KPublisherId", str4);
                    intent3.putExtra("pay_channel", 47);
                }
            }
            com.tencent.mm.bg.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent3);
        } else if (this.context instanceof SnsAdNativeLandingPagesUI) {
            boolean z;
            snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) this.context;
            s sVar = lVar.nAG;
            str3 = lVar.nAD;
            str = lVar.nAE;
            str5 = lVar.nAF;
            boolean z2 = lVar.nAB == 1;
            boolean z3 = lVar.nAC == 1;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.nDt).nAA == 1) {
                z = true;
            } else {
                z = false;
            }
            snsAdNativeLandingPagesUI.a(sVar, str3, str, str5, z2, z3, z);
        }
    }

    @TargetApi(17)
    public final View bzM() {
        View view = this.contentView;
        this.kFI = (RelativeLayout) view.findViewById(i$f.sns_ad_native_landing_pages_item_btn_relative);
        this.nDG = (Button) view.findViewById(i$f.sns_ad_native_landing_pages_item_btn_btn);
        this.nDH = view.findViewById(i$f.sns_ad_native_landing_pages_item_gray_cover);
        return view;
    }
}
