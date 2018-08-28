package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class AppBrandSOSUI extends FTSSOSMoreWebViewUI {
    private String gvA;
    private String gvB;
    private View gvz;
    private int scene;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.a.pop_in, 0);
        this.gvB = getIntent().getStringExtra("key_session_id");
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        x.i("MicroMsg.AppBrandSOSUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[]{this.gvB});
        h.mEJ.h(13929, new Object[]{this.gvB, "", Integer.valueOf(1), Integer.valueOf(this.scene)});
        Intent intent = new Intent();
        intent.putExtra("key_session_id", this.gvB);
        intent.putExtra("ftsbizscene", this.scene);
        setResult(-1, intent);
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
            x.e("MicroMsg.AppBrandSOSUI", "refresh keyword id error : %s", new Object[]{e});
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

    protected final String getHint() {
        String stringExtra = getIntent().getStringExtra("key_search_place_holder");
        return (stringExtra == null || stringExtra.length() <= 0) ? super.getHint() : stringExtra;
    }

    protected final boolean anv() {
        return true;
    }
}
