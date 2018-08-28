package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

public final class o extends i {
    private static final Map<String, Bitmap> nEi = new WeakHashMap();
    ViewPager nEj;
    a nEk;
    AdLandingControlView nEl;
    private int nEm = 0;
    private int nEn = 0;
    boolean nEo = true;

    public o(Context context, n nVar, ViewGroup viewGroup) {
        super(context, nVar, viewGroup);
        this.nEl = new AdLandingControlView(context);
    }

    public final void bzA() {
        this.nEk.wN(this.nEj.getCurrentItem());
        if (this.nEo) {
            this.nEk.wO(0);
            this.nEo = false;
        } else {
            this.nEk.wO(this.nEn);
        }
        super.bzA();
    }

    public final void bzB() {
        this.nEk.wO(-1);
        super.bzB();
    }

    public final void N(Map<String, Object> map) {
        super.N(map);
        if (map.containsKey("startIndex")) {
            try {
                this.nEm = ((Integer) map.get("startIndex")).intValue();
                this.nEj.k(this.nEm, false);
            } catch (Exception e) {
            }
        }
    }

    public final void bzV() {
        super.bzV();
        this.nEj.k(this.nEm, false);
    }

    protected final void bzQ() {
        a aVar;
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int width = (windowManager.getDefaultDisplay().getWidth() - ((int) ((n) this.nDt).nBa)) - ((int) ((n) this.nDt).nBb);
        int height = windowManager.getDefaultDisplay().getHeight();
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        if (this.nEj.getAdapter() == null) {
            a aVar2 = new a(this.context, layoutInflater, (n) this.nDt, this.backgroundColor);
            this.nEj.setOnPageChangeListener(new 1(this, aVar2));
            this.nEj.setAdapter(aVar2);
            aVar = aVar2;
        } else {
            a aVar3 = (a) this.nEj.getAdapter();
            aVar3.nEr = (n) this.nDt;
            aVar = aVar3;
        }
        this.nEl.eS(((n) this.nDt).nAH.size(), 0);
        if (((n) this.nDt).nAK) {
            this.nEj.setLayoutParams(new LayoutParams(width, height));
        } else if (((n) this.nDt).nAH.size() > 0) {
            m mVar = (m) ((n) this.nDt).nAH.get(0);
            new LinearLayout(this.context).setOrientation(1);
            int i = 0;
            Iterator it = mVar.nAH.iterator();
            while (it.hasNext()) {
                s sVar = (s) it.next();
                int i2 = (int) (((float) i) + sVar.nAY);
                if (sVar instanceof u) {
                    u uVar = (u) sVar;
                    View inflate = layoutInflater.inflate(g.sns_ad_native_landing_pages_item_text, null);
                    inflate.setBackgroundColor(this.backgroundColor);
                    ((TextView) inflate.findViewById(f.sns_ad_landingpage_text_wordTitle)).setText(uVar.nBt);
                    ((TextView) inflate.findViewById(f.sns_ad_landingpage_text_wordTitle)).measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    i = ((TextView) inflate.findViewById(f.sns_ad_landingpage_text_wordTitle)).getPaddingBottom() + ((i2 + ((TextView) inflate.findViewById(f.sns_ad_landingpage_text_wordTitle)).getPaddingTop()) + ((TextView) inflate.findViewById(f.sns_ad_landingpage_text_wordTitle)).getHeight());
                } else if (sVar instanceof l) {
                    Button button = (Button) layoutInflater.inflate(g.sns_ad_native_landing_pages_item_btn, null).findViewById(f.sns_ad_native_landing_pages_item_btn_btn);
                    button.setText(((l) sVar).title);
                    button.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    int paddingTop = button.getPaddingTop() + i2;
                    if (sVar.nBd > 0.0f && ((int) sVar.nBd) != Integer.MAX_VALUE) {
                        paddingTop = (int) (((float) paddingTop) + sVar.nBd);
                    } else if (sVar.height <= 0.0f || ((int) sVar.height) == Integer.MAX_VALUE) {
                        paddingTop += button.getHeight();
                    } else {
                        paddingTop = (int) (((float) paddingTop) + sVar.height);
                    }
                    i = button.getPaddingBottom() + paddingTop;
                } else if (sVar instanceof p) {
                    float f = 0.0f;
                    float f2 = 0.0f;
                    float f3 = sVar.nAY;
                    float f4 = sVar.nAZ;
                    if (sVar instanceof p) {
                        p pVar = (p) sVar;
                        f = pVar.height;
                        f2 = pVar.width;
                    }
                    if (((int) f) == 0 || ((int) f2) == 0) {
                        i = i2 + height;
                    } else {
                        i = (int) (((f * ((float) width)) / f2) + ((float) i2));
                    }
                    i = (int) (((float) ((int) (((float) i) + f3))) + f4);
                } else if (sVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o) {
                    i = i2 + height;
                } else if (sVar instanceof q) {
                    q qVar = (q) sVar;
                    if (qVar.nAT == 1) {
                        i = i2 + height;
                    } else if (((int) qVar.width) > 0) {
                        i = ((((int) qVar.height) * width) / ((int) qVar.width)) + i2;
                    } else {
                        i = (int) (qVar.height + ((float) i2));
                    }
                } else if (sVar instanceof w) {
                    w wVar = (w) sVar;
                    if (wVar.nBA != 1) {
                        i = i2 + height;
                    } else if (((int) wVar.width) > 0) {
                        i = ((((int) wVar.height) * width) / ((int) wVar.width)) + i2;
                    } else {
                        i = (int) (wVar.height + ((float) i2));
                    }
                } else if (sVar instanceof v) {
                    i = i2 + height;
                } else {
                    i = i2;
                }
                i = (int) (sVar.nAZ + ((float) i));
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(width, i);
            layoutParams.leftMargin = (int) ((n) this.nDt).nBa;
            layoutParams.rightMargin = (int) ((n) this.nDt).nBb;
            this.nEj.setLayoutParams(layoutParams);
        }
        this.nEk = aVar;
        aVar.notifyDataSetChanged();
    }

    public final View bzM() {
        View view = this.contentView;
        this.nEj = (ViewPager) view.findViewById(f.sns_ad_native_landing_pages_items_turnimages_viewpager);
        this.nEl = (AdLandingControlView) view.findViewById(f.sns_ad_native_lading_pages_turnimages_indicator);
        return view;
    }

    protected final int getLayout() {
        return g.sns_ad_native_landing_pages_item_turnimages;
    }

    public final boolean aa(JSONObject jSONObject) {
        if (super.aa(jSONObject)) {
            return true;
        }
        return false;
    }

    public final LinkedList<JSONObject> bAe() {
        a aVar = this.nEk;
        LinkedList<JSONObject> linkedList = new LinkedList();
        for (String str : aVar.nEw.keySet()) {
            a aVar2 = (a) aVar.nEw.get(str);
            if (aVar2 != null && aVar2.nEC.size() != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= aVar2.nEC.size()) {
                        break;
                    }
                    i iVar = (i) aVar2.nEC.get(i2);
                    JSONObject jSONObject = new JSONObject();
                    if (iVar.aa(jSONObject)) {
                        linkedList.add(jSONObject);
                    }
                    i = i2 + 1;
                }
            }
        }
        return linkedList;
    }
}
