package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.1;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.2;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.recovery.util.Util;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAppBrandRecentView extends AppBrandRecentView implements a {
    private float VT;
    private float VU;
    protected float gPf;
    private AppBrandRecentView.a gPg;
    private List<a> gPh;
    private c gPi;
    private a gPj;
    e gPk = new e();
    private float gPl = 1.0f;
    private boolean gPm = false;
    private Context mContext;

    protected class b extends t {
        protected View SU;
        protected TextView eBO;
        protected ImageView gPp;
        protected TextView gPq;
        protected ImageView gmn;

        public b(View view) {
            super(view);
            this.SU = view;
            view.setOnClickListener(new 1(this, BaseAppBrandRecentView.this));
            view.setOnLongClickListener(new 2(this, BaseAppBrandRecentView.this));
            view.getLayoutParams().width = BaseAppBrandRecentView.this.getResources().getDisplayMetrics().widthPixels / 4;
            this.gmn = (ImageView) view.findViewById(com.tencent.mm.plugin.appbrand.widget.k.b.icon);
            this.gPp = (ImageView) view.findViewById(com.tencent.mm.plugin.appbrand.widget.k.b.icon_bg);
            this.eBO = (TextView) view.findViewById(com.tencent.mm.plugin.appbrand.widget.k.b.title);
            this.gPq = (TextView) view.findViewById(com.tencent.mm.plugin.appbrand.widget.k.b.test_mask);
        }
    }

    protected abstract int getLoadCount();

    protected abstract String getType();

    public BaseAppBrandRecentView(Context context) {
        super(context);
        init(context);
    }

    public BaseAppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    protected void init(Context context) {
        this.mContext = context;
        this.gPf = context.getResources().getDimension(k.a.DialogAvatarLinePadding);
        if (g.l(u.class) != null) {
            ((u) g.l(u.class)).c(this);
        } else {
            x.e("MicroMsg.BaseAppBrandRecentView", "[init] IAppBrandLocalUsageStorage get null!");
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.setOrientation(0);
        setLayoutManager(linearLayoutManager);
        a aVar = new a(this, (byte) 0);
        this.gPj = aVar;
        setAdapter(aVar);
        RecyclerView.k kVar = this.gPk;
        kVar.Sa = this;
        kVar.gPF = 4;
        kVar.Sa.a(kVar);
        kVar.Sb = new 1(kVar, kVar.Sa.getContext());
        kVar.gPE = new 2(kVar, kVar.Sa.getContext());
    }

    public final boolean T(int i, int i2) {
        e eVar = this.gPk;
        int mr = eVar.mr(eVar.mOffsetX + i);
        if (eVar.Sa != null && eVar.gPI) {
            eVar.gPE.Sv = mr;
            eVar.Sa.getLayoutManager().a(eVar.gPE);
        }
        return super.T(i, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.VT = motionEvent.getRawX();
            this.VU = motionEvent.getRawY();
        } else if (motionEvent.getAction() == 2 && this.gPm) {
            return true;
        }
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.gPm = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean canScrollHorizontally(int i) {
        return true;
    }

    public void setOnItemClickListener(AppBrandRecentView.a aVar) {
        this.gPg = aVar;
    }

    public final void refresh() {
        if (this.gPi != null) {
            e.remove(this.gPi);
        }
        c cVar = new c(this, (byte) 0);
        this.gPi = cVar;
        e.post(cVar, "MicroMsg.BaseAppBrandRecentView");
    }

    public final void release() {
        if (g.l(u.class) != null) {
            ((u) g.l(u.class)).d(this);
        } else {
            x.e("MicroMsg.BaseAppBrandRecentView", "[release] IAppBrandLocalUsageStorage get null!");
        }
        if (this.gPi != null) {
            e.remove(this.gPi);
        }
        getRecentItemList().clear();
    }

    public AppBrandRecentView.a getOnItemClickListener() {
        return this.gPg;
    }

    public void as(List<a> list) {
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s", new Object[]{((h) g.Ef().DM()).toString(), Integer.valueOf(lVar.fBN)});
        if (lVar.fBN == 5 && aqB()) {
            x.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] Ignore!!!");
        } else {
            refresh();
        }
    }

    protected boolean aqB() {
        return false;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.BaseAppBrandRecentView", "[onConfigurationChanged] orientation:%s", new Object[]{Integer.valueOf(configuration.orientation)});
        if (this.gPl != ((float) configuration.orientation)) {
            getAdapter().RR.notifyChanged();
        }
        this.gPl = (float) configuration.orientation;
    }

    public RecyclerView.a getAdapter() {
        return this.gPj;
    }

    protected void a(b bVar, a aVar) {
        int width = getWidth() / 4;
        if (width <= 0) {
            width = getResources().getDisplayMetrics().widthPixels / 4;
        }
        bVar.SU.getLayoutParams().width = width;
        if (aVar.type == 1 && aVar.gOT != null) {
            if (Util.oW(aVar.gOT.nickname)) {
                x.w("MicroMsg.BaseAppBrandRecentView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[]{aVar.gOT.username, aVar.gOT.appId});
                bVar.eBO.setVisibility(8);
            } else {
                bVar.eBO.setText(wq(aVar.gOT.nickname));
                bVar.eBO.setVisibility(0);
            }
            bVar.gPp.setVisibility(0);
            if (Util.oW(aVar.gOT.fmD)) {
                bVar.gmn.setImageDrawable(com.tencent.mm.modelappbrand.b.a.JZ());
            } else {
                com.tencent.mm.modelappbrand.b.b.Ka().a(bVar.gmn, aVar.gOT.fmD, com.tencent.mm.modelappbrand.b.a.JZ(), f.dGr);
            }
        }
    }

    private static String wq(String str) {
        if (str == null) {
            return str;
        }
        try {
            if (com.tencent.mm.ui.tools.g.abd(str) <= 12) {
                return str;
            }
            char[] toCharArray = str.toCharArray();
            int length = toCharArray.length;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i < length) {
                i3 += com.tencent.mm.ui.tools.g.abd(String.valueOf(toCharArray[i]));
                if (i3 >= 12) {
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

    public int getCount() {
        return getRecentItemList().size();
    }

    protected List<a> getRecentItemList() {
        if (this.gPh == null) {
            this.gPh = new ArrayList();
        }
        return this.gPh;
    }
}
