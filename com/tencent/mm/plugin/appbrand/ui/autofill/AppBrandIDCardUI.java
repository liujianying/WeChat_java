package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.protocal.c.ek;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.LinkedList;
import org.json.JSONArray;

public class AppBrandIDCardUI extends DrawStatusBarActivity {
    public static final int guz = g.app_brand_idcard_container;
    private String appId;
    private int dBM;
    private p geH;
    private String gxA;
    private a gxe = new 1(this);
    public Fragment gxu;
    public Fragment gxv;
    private bnm gxw;
    private ek gxx;
    private LinkedList<Integer> gxy;
    private String gxz;

    static /* synthetic */ void e(AppBrandIDCardUI appBrandIDCardUI) {
        x.i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
        appBrandIDCardUI.gxu = new a();
        ((a) appBrandIDCardUI.gxu).gxe = appBrandIDCardUI.gxe;
        appBrandIDCardUI.getSupportFragmentManager().bk().a(guz, appBrandIDCardUI.gxu, appBrandIDCardUI.gxu.getClass().getSimpleName()).G(appBrandIDCardUI.gxu.getClass().getSimpleName()).commit();
    }

    static /* synthetic */ void h(AppBrandIDCardUI appBrandIDCardUI) {
        x.i("MicroMsg.AppBrandIDCardUI", "switchToVerifyFragment");
        appBrandIDCardUI.gxv = new b();
        ((b) appBrandIDCardUI.gxv).gxe = appBrandIDCardUI.gxe;
        appBrandIDCardUI.getSupportFragmentManager().bk().a(guz, appBrandIDCardUI.gxv, appBrandIDCardUI.gxv.getClass().getSimpleName()).G(appBrandIDCardUI.gxv.getClass().getSimpleName()).commit();
        if (appBrandIDCardUI.isSupportNavigationSwipeBack()) {
            appBrandIDCardUI.getSwipeBackLayout().setEnableGesture(false);
        }
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        getWindow().requestFeature(10);
        getWindow().getDecorView().setFitsSystemWindows(true);
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            x.e("MicroMsg.AppBrandIDCardUI", "bundle is null, return");
            finish();
            return;
        }
        this.appId = extras.getString("intent_appid", "");
        if (bi.oW(this.appId)) {
            x.e("MicroMsg.AppBrandIDCardUI", "appId is null, return");
            finish();
            return;
        }
        this.gxy = y(extras);
        if (bi.cX(this.gxy) || this.gxy.size() <= 0) {
            x.e("MicroMsg.AppBrandIDCardUI", "categoryId is null, return");
            Intent intent = new Intent();
            intent.putExtra("intent_err_code", 40003);
            intent.putExtra("intent_err_msg", "category_id is null");
            setResult(1, intent);
            finish();
            return;
        }
        this.dBM = extras.getInt("intent_auth_type", 1);
        this.mController.contentView.setBackgroundColor(-855310);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        View frameLayout = new FrameLayout(this);
        frameLayout.setId(guz);
        ((ViewGroup) this.mController.contentView).addView(frameLayout, layoutParams);
        setBackBtn(new 2(this));
        getString(j.app_tip);
        this.geH = h.a(this, getString(j.loading_tips), true, new 3(this));
        this.geH.show();
        this.gxe.anI();
    }

    public void onBackPressed() {
        back();
    }

    private void back() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
            return;
        }
        super.onBackPressed();
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(true);
        }
    }

    public void onSwipeBack() {
        back();
    }

    private static LinkedList<Integer> y(Bundle bundle) {
        LinkedList<Integer> linkedList = new LinkedList();
        try {
            x.i("MicroMsg.AppBrandIDCardUI", "[processCategoryId] categoryIdStr:%s", new Object[]{bundle.getString("intent_category_id")});
            JSONArray jSONArray = new JSONArray(r1);
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(Integer.valueOf(jSONArray.optInt(i)));
            }
            return linkedList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandIDCardUI", e, "", new Object[0]);
            return null;
        }
    }

    public final boolean noActionBar() {
        return true;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
