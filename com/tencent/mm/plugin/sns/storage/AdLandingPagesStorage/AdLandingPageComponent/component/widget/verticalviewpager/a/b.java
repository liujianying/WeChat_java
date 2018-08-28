package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class b extends Fragment {
    private static int nHk;
    private int bgColor;
    private boolean eBZ;
    private int eHG;
    private boolean eaR;
    private int hmV;
    private int hmW;
    private LinearLayoutManager nCQ;
    private final Map<String, Bitmap> nEi = new WeakHashMap();
    private int nEs = TbsLog.TBSLOG_CODE_SDK_BASE;
    private int nEt = 700;
    private c nHg;
    public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b nHl;
    private z nHm;
    private boolean nHn;
    private boolean nHo;
    public boolean nHp;
    public boolean nHq = false;
    private int nHr;
    public int nHs;
    private ah nHt;
    private a nHu;
    private b nHv;
    private a nHw;
    private boolean nHx;

    static /* synthetic */ void a(b bVar, String str, ImageView imageView) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        LayoutParams layoutParams = imageView.getLayoutParams();
        if (Float.compare(bVar.nHm.width, 0.0f) > 0) {
            layoutParams.width = (int) bVar.nHm.width;
        } else {
            layoutParams.width = -1;
        }
        if (Float.compare(bVar.nHm.height, 0.0f) > 0) {
            layoutParams.height = (int) bVar.nHm.height;
        } else {
            layoutParams.height = -2;
        }
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).bottomMargin = (int) bVar.nHm.nAZ;
        }
        imageView.setImageBitmap(decodeFile);
    }

    static /* synthetic */ void a(b bVar, String str, String str2, String str3) {
        if (bVar.nHt == null) {
            bVar.nHt = new ah();
        }
        bVar.nHt.H(new 3(bVar, str, str2, str3));
    }

    public static Fragment a(c cVar, DummyViewPager dummyViewPager, z zVar, boolean z, a aVar, boolean z2, boolean z3) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("pageInfo", cVar);
        bundle.putSerializable("viewpager", dummyViewPager);
        bundle.putSerializable("lifecycle", aVar);
        bundle.putSerializable("pageDownIconInfo", zVar);
        bundle.putBoolean("isLastPage", z);
        bundle.putBoolean("needEnterAnimation", z2);
        bundle.putBoolean("needDirectionAnimation", z3);
        b bVar = new b();
        bVar.setArguments(bundle);
        return bVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        nHk = a.fromDPToPix(getContext(), 60);
        int[] ee = ad.ee(getContext());
        this.hmV = ee[0];
        this.hmW = ee[1];
        if (this.nHg == null) {
            this.nHg = (c) getArguments().getSerializable("pageInfo");
        }
        this.nHu = (a) getArguments().getSerializable("lifecycle");
        this.nHm = (z) getArguments().getSerializable("pageDownIconInfo");
        this.eBZ = getArguments().getBoolean("isLastPage");
        this.nHn = getArguments().getBoolean("needEnterAnimation");
        this.nHo = getArguments().getBoolean("needDirectionAnimation");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.ad_landing_page_item, viewGroup, false);
        this.nHv = new b((byte) 0);
        this.nHv.nHH = inflate;
        this.nHv.nHI = (ImageView) inflate.findViewById(f.sns_ad_native_landing_pages_background_img);
        this.nHv.fyt = (LinearLayout) inflate.findViewById(f.sns_ad_native_landing_pages_sub_linear_layout);
        this.nHv.nHJ = (ImageView) inflate.findViewById(f.sns_native_landing_pages_next_img);
        this.nHv.gxh = (RecyclerView) inflate.findViewById(f.content_list);
        this.nHv.nHL = (LinearLayout) inflate.findViewById(f.fake_container);
        RecyclerView recyclerView = this.nHv.gxh;
        recyclerView.setOverScrollMode(2);
        recyclerView.setOnTouchListener(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a((DummyViewPager) getArguments().getSerializable("viewpager")));
        getActivity();
        this.nCQ = new LinearLayoutManager();
        recyclerView.setLayoutManager(this.nCQ);
        this.nHw = new a(this.nHg, this.bgColor, getActivity(), this.nCQ);
        recyclerView.setAdapter(this.nHw);
        this.nHl = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b(recyclerView, this);
        recyclerView.a(new 1(this));
        inflate.setTag(this.nHv);
        aMv();
        if (this.nHu != null) {
            this.nHu.p(this);
        }
        return inflate;
    }

    public final void onResume() {
        super.onResume();
        x.i("ContentFragment", this + " onResume " + getUserVisibleHint());
        this.eaR = true;
        if (this.nHl != null && getUserVisibleHint()) {
            this.nHl.bzN();
        }
    }

    public final void onPause() {
        super.onPause();
        new StringBuilder().append(this).append(" onPause ").append(getUserVisibleHint());
        this.eaR = false;
        if (this.nHl != null && getUserVisibleHint()) {
            this.nHl.bAo();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.nHl != null) {
            this.nHl.nGP.onDestroy();
        }
    }

    public final void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            if (this.nHl != null) {
                this.nHl.bzN();
            }
        } else if (this.nHl != null) {
            this.nHl.bAo();
        }
    }

    public final void bAq() {
        if (this.nHl != null) {
            this.nHl.bAn();
        }
    }

    public final void a(c cVar) {
        if (this.nHg != cVar) {
            this.nHg = cVar;
            aMv();
        }
    }

    private void aMv() {
        if (this.nHv != null) {
            bAr();
            if (this.nHg.nIg == null || this.nHg.nIg.length() <= 0) {
                bAr();
            } else {
                String str = this.nHg.nIg;
                x.i("ContentFragment", "bg need blur %b, url %s", new Object[]{Boolean.valueOf(this.nHg.nIh), str});
                if (this.nEi.containsKey(str)) {
                    x.i("ContentFragment", "bg has cache bitmap");
                    J((Bitmap) this.nEi.get(str));
                } else {
                    d.b("adId", str, false, 1000000001, new 2(this, str));
                }
            }
            if (this.nHw != null) {
                if (this.nHg.nIg == null || this.nHg.nIg.length() <= 0) {
                    this.nHw.bgColor = this.bgColor;
                } else {
                    this.nHw.bgColor = 0;
                }
                RecyclerView$a recyclerView$a = this.nHw;
                c cVar = this.nHg;
                if (recyclerView$a.nHg != cVar) {
                    recyclerView$a.nHg = cVar;
                    recyclerView$a.RR.notifyChanged();
                }
            }
        }
    }

    private void bAr() {
        if (this.nHg.fpc != null && this.nHg.fpc.length() > 0) {
            x.i("ContentFragment", "setting bg color %s", new Object[]{this.nHg.fpc});
            try {
                this.bgColor = Color.parseColor(this.nHg.fpc);
            } catch (Exception e) {
                x.e("ContentFragment", "the color is error : " + this.nHg.fpc);
            }
            this.nHv.nHH.setBackgroundColor(this.bgColor);
            this.nHv.nHI.setBackgroundColor(this.bgColor);
            this.nHv.fyt.setBackgroundColor(this.bgColor);
            bAs();
        }
    }

    private void J(Bitmap bitmap) {
        if (bitmap != null) {
            this.nHv.nHH.setBackgroundColor(0);
            this.nHv.nHI.setBackgroundColor(0);
            this.nHv.fyt.setBackgroundColor(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nHv.nHI.getLayoutParams();
            layoutParams.height = layoutParams.height >= this.hmW ? layoutParams.height : this.hmW;
            this.nHv.nHI.setLayoutParams(layoutParams);
            this.nHv.nHI.setImageBitmap(bitmap);
        } else {
            bAr();
        }
        bAs();
    }

    private void bAs() {
        if (this.bgColor == 0 && this.nHg.fpc != null && this.nHg.fpc.length() > 0) {
            x.i("ContentFragment", "setDirectionColor bg color %s", new Object[]{this.nHg.fpc});
            try {
                this.bgColor = Color.parseColor(this.nHg.fpc);
            } catch (Exception e) {
                x.e("ContentFragment", "the color is error : " + this.nHg.fpc);
            }
        }
        if (this.bgColor - -16777216 <= -1 - this.bgColor) {
            this.nHv.nHJ.setImageDrawable(a.f(getActivity(), e.page_down_direction_down));
        } else {
            this.nHv.nHJ.setImageDrawable(a.f(getActivity(), e.page_down_dark_xxhdpi));
        }
    }

    public final RecyclerView bAt() {
        if (this.nHv != null) {
            return this.nHv.gxh;
        }
        return null;
    }

    public final Collection<i> bAu() {
        if (this.nHw == null) {
            return Collections.EMPTY_LIST;
        }
        a aVar = this.nHw;
        return aVar.nHh == null ? Collections.EMPTY_LIST : aVar.nHh.values();
    }

    public final void bAv() {
        if (this.nHv.nHJ.getVisibility() == 0) {
            this.nHv.nHJ.clearAnimation();
            this.nHv.nHJ.setVisibility(4);
        }
    }

    public final void bAw() {
        if (b() && !this.nHq) {
            this.nHv.nHJ.clearAnimation();
            this.nHv.nHJ.setVisibility(0);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
            alphaAnimation.setDuration((long) this.nEs);
            alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            alphaAnimation.setStartOffset((long) this.nEs);
            alphaAnimation.setAnimationListener(new 4(this));
            if (this.nHm == null || this.nHm.equals(this.nHv.nHJ.getTag())) {
                this.nHv.nHJ.startAnimation(alphaAnimation);
                return;
            }
            this.nHv.nHJ.setTag(this.nHm);
            this.nHv.nHJ.setVisibility(8);
            d.a(this.nHm.iconUrl, 1000000001, new 5(this, alphaAnimation));
        }
    }

    /* renamed from: bAx */
    public final boolean b() {
        if (!this.nHo || this.nHr != 0 || this.nHs != 0) {
            return false;
        }
        int fi = this.nCQ.fi();
        int fj = this.nCQ.fj();
        if (fi == fj && fi == -1) {
            return false;
        }
        boolean z;
        for (int i = fj; i >= fi; i--) {
            a aVar = this.nHw;
            i iVar = (i) aVar.nHh.get(((s) aVar.nHg.nIi.get(i)).nAW);
            if (iVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z) {
                fj = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z) iVar).bAl();
                if (fj >= 0 && fj < nHk) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z && this.eBZ) {
            z = this.nCQ.fj() != this.nHw.getItemCount() + -1;
        }
        return z;
    }
}
