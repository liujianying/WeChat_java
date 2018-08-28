package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class f extends i {
    ImageView bOA;
    ProgressBar eVR;
    boolean nDm;

    public f(Context context, ViewGroup viewGroup) {
        this(context, viewGroup, (byte) 0);
    }

    private f(Context context, ViewGroup viewGroup, byte b) {
        super(context, null, viewGroup);
        this.nDm = true;
    }

    public final View bzM() {
        View view = this.contentView;
        this.bOA = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.sns_ad_native_landing_pages_items_pure_image_img);
        this.eVR = (ProgressBar) view.findViewById(com.tencent.mm.plugin.sns.i.f.progressbar);
        return view;
    }

    protected final int getLayout() {
        return g.sns_ad_native_landing_pages_item_image;
    }

    protected final void bzQ() {
        if (this.contentView != null && this.bOA != null && this.eVR != null && ((p) this.nDt) != null) {
            float f = ((p) this.nDt).nAY;
            float f2 = ((p) this.nDt).nAZ;
            float f3 = ((p) this.nDt).nBa;
            float f4 = ((p) this.nDt).nBb;
            String str = ((p) this.nDt).nAL;
            float f5 = ((p) this.nDt).height;
            LayoutParams layoutParams = (LayoutParams) this.bOA.getLayoutParams();
            layoutParams.width = (int) ((p) this.nDt).width;
            layoutParams.height = (int) f5;
            this.bOA.setLayoutParams(layoutParams);
            this.nDm = false;
            startLoading();
            d.a(str, ((p) this.nDt).nAX, new a() {
                public final void bzS() {
                    f.this.startLoading();
                }

                public final void bxo() {
                    f.this.stopLoading();
                }

                public final void MX(String str) {
                    try {
                        f.this.stopLoading();
                        Bitmap decodeFile = BitmapFactory.decodeFile(str);
                        f fVar = f.this;
                        if (decodeFile == null) {
                            x.e("AdLandingImageComp", "when set image the bmp is null!");
                        } else if (fVar.bOA == null) {
                            x.e("AdLandingImageComp", "when set image the imageView is null!");
                        } else if (decodeFile.getWidth() == 0) {
                            x.e("AdLandingImageComp", "when set image the bmp.getWidth is 0!");
                        } else {
                            fVar.bOA.setImageBitmap(decodeFile);
                            fVar.eVR.setVisibility(8);
                        }
                    } catch (Throwable e) {
                        x.e("AdLandingImageComp", "%s" + bi.i(e));
                    }
                }
            });
            this.contentView.setPadding((int) f3, (int) f, (int) f4, (int) f2);
            ij(false);
        }
    }

    public final void startLoading() {
        this.eVR.setVisibility(0);
    }

    public final void stopLoading() {
        this.eVR.setVisibility(8);
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
            x.printErrStackTrace("AdLandingImageComp", e, "", new Object[0]);
            return false;
        }
    }
}
