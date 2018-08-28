package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class n extends k implements e, Serializable {
    private View nDL;
    Button nDM;
    SnsTextProgressBar nDN;
    a nDO = new a(this, "apkStateMachine");
    b nDP;
    private OnClickListener nDQ = new 1(this);
    a nDR = new 2(this);

    public n(Context context, b bVar, ViewGroup viewGroup) {
        super(context, bVar, viewGroup);
    }

    protected final void bzQ() {
        Map hashMap = new HashMap();
        hashMap.put("fontNormalColor", eG(((b) this.nDt).nAd, "#FFFFFF"));
        hashMap.put("fontDisableColor", eG(((b) this.nDt).nAe, "#4CFFFFFF"));
        hashMap.put("fontPressedColor", eG(((b) this.nDt).nAf, "#99FFFFFF"));
        hashMap.put("NormalColor", eG(((b) this.nDt).nzX, "#1AAD19"));
        hashMap.put("PressedColor", eG(((b) this.nDt).nzZ, "#179B16"));
        hashMap.put("DisableColor", eG(((b) this.nDt).nzY, "#661AAD19"));
        hashMap.put("borderNormalColor", eG(((b) this.nDt).nAa, "#179E16"));
        hashMap.put("borderPressedColor", eG(((b) this.nDt).nAc, "#158E14"));
        hashMap.put("borderDisableColor", eG(((b) this.nDt).nAb, "#00179E16"));
        int parseColor = Color.parseColor((String) hashMap.get("fontNormalColor"));
        int parseColor2 = Color.parseColor((String) hashMap.get("fontDisableColor"));
        int parseColor3 = Color.parseColor((String) hashMap.get("fontPressedColor"));
        int parseColor4 = Color.parseColor((String) hashMap.get("NormalColor"));
        int parseColor5 = Color.parseColor((String) hashMap.get("PressedColor"));
        int parseColor6 = Color.parseColor((String) hashMap.get("DisableColor"));
        int i = (int) ((b) this.nDt).nAv;
        int parseColor7 = Color.parseColor((String) hashMap.get("borderNormalColor"));
        int parseColor8 = Color.parseColor((String) hashMap.get("borderPressedColor"));
        int parseColor9 = Color.parseColor((String) hashMap.get("borderDisableColor"));
        int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(d.ButtonCornerSize);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable.setColor(parseColor6);
        gradientDrawable.setStroke(i, parseColor9);
        Drawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable2.setColor(parseColor5);
        gradientDrawable2.setStroke(i, parseColor8);
        Drawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable3.setColor(parseColor4);
        gradientDrawable3.setStroke(i, parseColor7);
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, gradientDrawable);
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[]{16842910}, gradientDrawable3);
        this.nDM.setBackground(stateListDrawable);
        int[] iArr = new int[]{parseColor2, parseColor3, parseColor};
        r2 = new int[3][];
        r2[0] = new int[]{-16842910};
        r2[1] = new int[]{16842919};
        r2[2] = new int[]{16842910};
        this.nDM.setTextColor(new ColorStateList(r2, iArr));
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setShape(0);
        gradientDrawable4.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable4.setColor(parseColor5);
        gradientDrawable4.setStroke(i, parseColor8);
        Drawable gradientDrawable5 = new GradientDrawable();
        gradientDrawable5.setShape(0);
        gradientDrawable5.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable5.setColor(parseColor4);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable5, 3, 1);
        gradientDrawable5 = new GradientDrawable();
        gradientDrawable5.setShape(0);
        gradientDrawable5.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable5.setColor(parseColor4);
        ClipDrawable clipDrawable2 = new ClipDrawable(gradientDrawable5, 3, 1);
        gradientDrawable5 = new LayerDrawable(new Drawable[]{gradientDrawable4, clipDrawable, clipDrawable2});
        gradientDrawable5.setId(0, 16908288);
        gradientDrawable5.setId(1, 16908303);
        gradientDrawable5.setId(2, 16908301);
        this.nDN.setProgressDrawable(gradientDrawable5);
        this.nDN.setPaintColor(((b) this.nDt).nAf);
        if (((b) this.nDt).height > 0.0f) {
            LayoutParams layoutParams = (LayoutParams) this.nDL.getLayoutParams();
            layoutParams.height = (int) ((b) this.nDt).height;
            this.nDL.setLayoutParams(layoutParams);
        }
        this.nDM.setText(((b) this.nDt).title);
        this.nDO.Dd(11);
    }

    @TargetApi(17)
    public final View bzM() {
        this.nDh = 0;
        View view = this.contentView;
        this.nDL = view.findViewById(f.downloader);
        this.nDM = (Button) view.findViewById(f.download_btn);
        this.nDM.setOnClickListener(this.nDQ);
        this.nDN = (SnsTextProgressBar) view.findViewById(f.download_progress);
        this.nDN.setProgress(0);
        this.nDN.setVisibility(8);
        this.nDN.setOnClickListener(this.nDQ);
        this.nDO.start();
        return view;
    }

    protected final int getLayout() {
        return g.sns_ad_comp_down_apk_btn;
    }

    public final void bzA() {
        super.bzA();
        this.nDO.Dd(2);
    }

    public final void bzz() {
        super.bzz();
        if (this.nDP != null) {
            this.context.unregisterReceiver(this.nDP);
            this.nDP = null;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
    }

    public final boolean bAc() {
        if (this.context == null || TextUtils.isEmpty(((b) this.nDt).bPS) || TextUtils.isEmpty(((b) this.nDt).rU)) {
            return false;
        }
        if (TextUtils.isEmpty(((b) this.nDt).nAg)) {
            com.tencent.mm.bu.a.post(new 4(this));
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(((b) this.nDt).nAg));
            intent.addFlags(268435456);
            List B = bi.B(this.context, intent);
            if (!(B == null || B.isEmpty())) {
                Object b;
                if (TextUtils.isEmpty(intent.getPackage()) && B.size() == 1) {
                    b = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo) B.get(0));
                } else {
                    b = intent.getPackage();
                }
                if (!bi.oV(ad.getPackageName()).equals(b)) {
                    com.tencent.mm.bu.a.post(new 3(this, intent));
                }
            }
        }
        AdLandingPagesProxy.getInstance().reportDownloadInfo(9, ((b) this.nDt).bPS, ((b) this.nDt).rU, ((b) this.nDt).bKg, ((b) this.nDt).downloadUrl);
        return true;
    }

    public final void bAd() {
        x.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
        AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((b) this.nDt).rU, ((b) this.nDt).nAg);
    }

    private static String eG(String str, String str2) {
        return (!bi.oW(str) && str.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?")) ? str : str2;
    }
}
