package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class w extends a {
    private ImageView bOA;
    ProgressBar eVR;
    private int hmV;
    private int hmW;
    boolean nAI;
    boolean nDm = true;
    private WindowManager nFy;

    public w(Context context, p pVar, ViewGroup viewGroup) {
        super(context, pVar, viewGroup);
    }

    protected final int getLayout() {
        return g.sns_ad_native_landing_pages_item_pure_image;
    }

    public final View bzM() {
        this.bOA = (ImageView) this.contentView.findViewById(f.sns_ad_native_landing_pages_items_pure_image_img);
        this.eVR = (ProgressBar) this.contentView.findViewById(f.progressbar);
        return this.contentView;
    }

    protected final void bzQ() {
        if (this.contentView != null && this.bOA != null && this.eVR != null && ((p) this.nDt) != null) {
            if (this.nFy == null) {
                this.nFy = (WindowManager) this.context.getSystemService("window");
                this.hmV = this.nFy.getDefaultDisplay().getWidth();
                this.hmW = this.nFy.getDefaultDisplay().getHeight();
            }
            String str = ((p) this.nDt).nAL;
            String str2 = ((p) this.nDt).nAM;
            float f = ((p) this.nDt).height;
            float f2 = ((p) this.nDt).width;
            this.nAI = ((p) this.nDt).nAI;
            if (f != 0.0f && f2 != 0.0f && !this.nAI) {
                this.bOA.setLayoutParams(new LayoutParams((int) f2, (int) f));
            } else if (!this.nAI || f == 0.0f || f2 == 0.0f) {
                this.bOA.setLayoutParams(new LayoutParams(this.hmV, this.hmW));
            } else {
                this.bOA.setLayoutParams(new LayoutParams(this.hmV, this.hmW));
            }
            if (str2 != null && str2.length() > 0) {
                try {
                    this.bOA.setBackgroundColor(Color.parseColor(str2));
                } catch (Exception e) {
                }
            }
            if (str == null || str.length() <= 0) {
                x.i("AdLandingPagePureImageComponet", "Pure image component fillItem without imageurl.");
                return;
            }
            Bitmap eK = d.eK("adId", str);
            if (eK == null || !I(eK)) {
                this.nDm = false;
                startLoading();
                d.a(str, ((p) this.nDt).nAX, new 1(this));
                return;
            }
            x.i("AdLandingPagePureImageComponet", "loaded cached image with  " + str);
            this.nDm = true;
        }
    }

    public final void startLoading() {
        this.eVR.setVisibility(0);
    }

    public final boolean I(Bitmap bitmap) {
        if (bitmap == null) {
            x.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
            return false;
        } else if (this.bOA == null) {
            x.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
            return false;
        } else if (bitmap.getWidth() == 0) {
            x.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
            return false;
        } else {
            this.bOA.setImageBitmap(bitmap);
            this.eVR.setVisibility(8);
            return true;
        }
    }

    public final boolean aa(JSONObject jSONObject) {
        if (!super.aa(jSONObject)) {
            return false;
        }
        try {
            if (!this.nDm) {
                String ce = ac.ce(((p) this.nDt).nAL);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", ce);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("imgUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("AdLandingPagePureImageComponet", e, "", new Object[0]);
            return false;
        }
    }
}
