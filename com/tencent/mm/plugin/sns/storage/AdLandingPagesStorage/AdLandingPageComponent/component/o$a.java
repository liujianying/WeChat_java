package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.ui.am;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class o$a extends u {
    int backgroundColor;
    int hmV;
    int hmW;
    Context mContext;
    LayoutInflater mLayoutInflater;
    n nEr;
    private int nEs = 600;
    int nEt = 700;
    int nEu = 250;
    HashMap<String, View> nEv = new HashMap();
    HashMap<String, a> nEw = new HashMap();

    public o$a(Context context, LayoutInflater layoutInflater, n nVar, int i) {
        this.mContext = context;
        this.mLayoutInflater = layoutInflater;
        this.nEr = nVar;
        this.backgroundColor = i;
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        this.hmV = windowManager.getDefaultDisplay().getWidth();
        this.hmW = windowManager.getDefaultDisplay().getHeight();
    }

    public final int getCount() {
        return this.nEr.nAH.size();
    }

    public final boolean a(View view, Object obj) {
        return view == ((View) obj);
    }

    public final void e(Object obj) {
    }

    public final Object b(ViewGroup viewGroup, int i) {
        View inflate = this.mLayoutInflater.inflate(i$g.sns_ad_native_landing_pages_item_trunpages, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(i$f.sns_ad_native_landing_pages_item_turnpages_linaerlayout);
        linearLayout.setBackgroundColor(this.backgroundColor);
        a aVar = (a) this.nEw.get(String.valueOf(i));
        List list = ((m) this.nEr.nAH.get(i)).nAH;
        if (aVar == null || aVar.nEC.size() == 0) {
            this.nEw.put(String.valueOf(i), a(list, 0, list.size(), linearLayout));
        } else {
            aVar.nEC.addAll(a(list, aVar.nEC.size(), list.size(), linearLayout).nEC);
            Iterator it = aVar.nEC.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (iVar.getView().getParent() != null && (iVar.getView().getParent() instanceof ViewGroup)) {
                    ((ViewGroup) iVar.getView().getParent()).removeView(iVar.getView());
                }
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                i iVar2 = (i) aVar.nEC.get(i2);
                linearLayout.addView(iVar2.getView());
                iVar2.a((s) list.get(i2));
            }
        }
        ImageView imageView = (ImageView) inflate.findViewById(i$f.sns_ad_native_landing_pages_item_turnpages_right_icon);
        TextView textView = (TextView) inflate.findViewById(i$f.sns_ad_native_landing_pages_item_turnpages_page_tv);
        if (this.backgroundColor - -16777216 <= -1 - this.backgroundColor) {
            imageView.setImageDrawable(a.f(this.mContext, e.page_icon_direction_right));
        } else {
            imageView.setImageDrawable(a.f(this.mContext, e.page_right_dark_xxhdpi));
        }
        if (this.nEr.nAJ == 1) {
            imageView.setVisibility(8);
            textView.setVisibility(8);
        } else {
            if (i == this.nEr.nAH.size() - 1) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
            textView.setText((i + 1) + "/" + this.nEr.nAH.size());
        }
        inflate.setLayoutParams(new LayoutParams(this.hmV, linearLayout.getMeasuredHeight()));
        inflate.setBackgroundColor(this.backgroundColor);
        viewGroup.addView(inflate);
        viewGroup.setBackgroundColor(this.backgroundColor);
        this.nEv.put(String.valueOf(i), inflate);
        return inflate;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final int k(Object obj) {
        return -2;
    }

    public final void wN(int i) {
        View view = (View) this.nEv.get(String.valueOf(i));
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(i$f.sns_ad_native_landing_pages_item_turnpages_right_icon);
            if (imageView != null && imageView.getVisibility() == 0) {
                if (imageView.getTag() == null || !(imageView.getTag() instanceof String) || new BigInteger((String) imageView.getTag()).longValue() < 1) {
                    imageView.setTag("1");
                    Animation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
                    alphaAnimation.setDuration((long) this.nEs);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    alphaAnimation.setAnimationListener(new 2(this, imageView));
                    imageView.startAnimation(alphaAnimation);
                }
            }
        }
    }

    public final void wO(int i) {
        for (String str : this.nEw.keySet()) {
            a aVar = (a) this.nEw.get(str);
            if (!(aVar == null || aVar.nEC.size() == 0)) {
                int i2;
                i iVar;
                if (str.equals(String.valueOf(i))) {
                    for (i2 = 0; i2 < aVar.nEC.size(); i2++) {
                        iVar = (i) aVar.nEC.get(i2);
                        if (!iVar.nDw) {
                            iVar.bzA();
                        }
                    }
                } else {
                    for (i2 = 0; i2 < aVar.nEC.size(); i2++) {
                        iVar = (i) aVar.nEC.get(i2);
                        if (iVar.nDw) {
                            iVar.bzB();
                        }
                    }
                }
            }
        }
    }

    private a a(List<s> list, int i, int i2, ViewGroup viewGroup) {
        a aVar = new a(this);
        if (list == null) {
            return aVar;
        }
        int max = Math.max(0, i);
        int min = Math.min(list.size(), i2);
        for (int i3 = max; i3 < min; i3++) {
            i a = am.a(this.mContext, (s) list.get(i3), viewGroup, this.backgroundColor);
            aVar.nEC.add(a);
            viewGroup.addView(a.getView());
        }
        return aVar;
    }
}
