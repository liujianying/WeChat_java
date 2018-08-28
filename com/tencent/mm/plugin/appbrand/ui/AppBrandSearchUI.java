package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;
import java.util.List;

public class AppBrandSearchUI extends FTSSearchTabWebViewUI {
    private String gvA;
    private String gvB;
    private View gvz;
    private int scene;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lF(getResources().getColor(R.e.normal_actionbar_color));
        this.gvB = getIntent().getStringExtra("key_session_id");
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        x.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[]{this.gvB});
        h.mEJ.h(13929, new Object[]{this.gvB, "", Integer.valueOf(1), Integer.valueOf(this.scene)});
        Intent intent = new Intent();
        intent.putExtra("key_session_id", this.gvB);
        intent.putExtra("ftsbizscene", this.scene);
        setResult(-1, intent);
    }

    protected final void initView() {
        super.initView();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(-855310));
        AL(-16777216);
    }

    protected final void ant() {
        super.ant();
        if (this.jwl != null) {
            ((ImageView) this.jwl.findViewById(R.h.ab_back_btn)).getDrawable().setColorFilter(-16777216, Mode.SRC_ATOP);
            FTSEditTextView fTSEditTextView = (FTSEditTextView) this.jwl.findViewById(R.h.fts_edittext);
            fTSEditTextView.getIconView().setImageResource(R.k.appbrand_actionbar_search_view_icon_black);
            ((ImageButton) fTSEditTextView.findViewById(R.h.clear_btn)).getDrawable().setColorFilter(-16777216, Mode.SRC_ATOP);
            fTSEditTextView.getEditText().setHintTextColor(getResources().getColor(R.e.light_bg_hint_color));
            fTSEditTextView.getEditText().setTextColor(-16777216);
            k.c(this);
        }
    }

    protected final int anu() {
        if (VERSION.SDK_INT >= 23 && (!com.tencent.mm.compatible.util.h.Ae() || !AppBrandNearbyWebViewUI.Af())) {
            ak.g(getWindow());
            return -855310;
        } else if (VERSION.SDK_INT >= 21) {
            return p.feh;
        } else {
            return super.anu();
        }
    }

    public void onDestroy() {
        if (this.scene == 3 || this.scene == 16) {
            h.mEJ.h(13929, new Object[]{this.gvB, b.dFx, Integer.valueOf(2), Integer.valueOf(this.scene)});
        }
        super.onDestroy();
    }

    public final boolean anx() {
        this.gvz.setVisibility(8);
        return super.anx();
    }

    public final void a(String str, String str2, List<a.b> list, FTSEditTextView.b bVar) {
        if (!TextUtils.isEmpty(str2)) {
            this.gvz.setVisibility(8);
        }
        try {
            this.gcO.g(10001, null);
        } catch (RemoteException e) {
            x.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", new Object[]{e});
        }
        super.a(str, str2, list, bVar);
    }

    protected final void dealContentView(View view) {
        super.dealContentView(view);
        this.gvA = getIntent().getStringExtra("key_nearby_url");
        getIntent().getStringExtra("key_nearby_list_id");
        this.gvz = getLayoutInflater().inflate(R.i.app_brand_search_ui_recommend_page, (ViewGroup) view, false);
        View findViewById = this.gvz.findViewById(R.h.nearbyV);
        findViewById.setOnClickListener(new 1(this));
        if (TextUtils.isEmpty(this.gvA)) {
            findViewById.setVisibility(8);
            this.gvz.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            this.gvz.setVisibility(0);
        }
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.gvz);
            return;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (getWindow().hasFeature(9)) {
            View view2 = this.gvz;
            int paddingLeft = this.gvz.getPaddingLeft();
            Rect rect = new Rect();
            int actionBarHeight = getActionBarHeight();
            View decorView = getWindow().getDecorView();
            decorView.getWindowVisibleDisplayFrame(rect);
            int height = decorView.getHeight();
            int[] iArr = new int[2];
            decorView.getLocationOnScreen(iArr);
            if (height == 0) {
                actionBarHeight += any();
            }
            actionBarHeight = (height - rect.height() < 0 || iArr[1] <= 200) ? actionBarHeight + rect.top : actionBarHeight + (height - rect.height());
            view2.setPadding(paddingLeft, actionBarHeight + this.gvz.getPaddingTop(), this.gvz.getPaddingRight(), this.gvz.getPaddingBottom());
        }
        addContentView(this.gvz, layoutParams);
    }

    private int any() {
        int i = 0;
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            return getResources().getDimensionPixelSize(bi.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Exception e) {
            return i;
        }
    }

    protected final void j(int i, Bundle bundle) {
        super.j(i, bundle);
        switch (i) {
            case 142:
                this.handler.post(new 2(this, bundle.getString("fts_key_json_data"), bundle.getInt("fts_key_is_cache_data", 0), bundle.getInt("fts_key_is_expired", 1)));
                return;
            default:
                return;
        }
    }

    protected final String getHint() {
        String stringExtra = getIntent().getStringExtra("key_search_place_holder");
        return (stringExtra == null || stringExtra.length() <= 0) ? super.getHint() : stringExtra;
    }
}
