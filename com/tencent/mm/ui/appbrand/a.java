package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.y;
import java.io.UnsupportedEncodingException;

public final class a {
    public String appId = "";
    Context context;
    public boolean gPm;
    com.tencent.mm.ui.widget.a.d gmE;
    public WxaExposedParams gvj = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a().aeo();
    public int scene;
    h trc;
    public String trd = "";
    public String username;

    public class a extends c {
        public a() {
            super(a.this);
        }

        public final void a(l lVar) {
            super.a(lVar);
            lVar.e(2, a.this.context.getString(R.l.app_brand_service_menu_receive_msg));
            lVar.e(8, a.this.context.getString(R.l.app_brand_service_menu_expose));
            lVar.e(7, a.a(a.this));
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            super.onMMMenuItemSelected(menuItem, i);
        }
    }

    public class d extends c {
        public d() {
            super(a.this);
        }

        public final void a(l lVar) {
            super.a(lVar);
            lVar.e(2, a.this.context.getString(R.l.app_brand_service_menu_receive_msg));
            lVar.e(8, a.this.context.getString(R.l.app_brand_service_menu_expose));
            lVar.e(7, a.a(a.this));
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            super.onMMMenuItemSelected(menuItem, i);
        }
    }

    public class f extends c {
        public f() {
            super(a.this);
        }

        public final View cqZ() {
            View inflate = y.gq(a.this.context).inflate(R.i.chatting_appbrand_action_sheet_title, null);
            ((TextView) inflate.findViewById(R.h.appbrand_view_title)).setText(a.this.context.getString(R.l.app_brand_service_menu_receive_confirm_msg));
            return inflate;
        }

        public final void a(l lVar) {
            super.a(lVar);
            lVar.e(5, a.this.context.getString(R.l.app_brand_menu_accept_msg));
            lVar.e(4, a.this.context.getString(R.l.app_brand_service_menu_cancel));
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            super.onMMMenuItemSelected(menuItem, i);
        }
    }

    static /* synthetic */ String a(a aVar) {
        if (aVar.gvj == null) {
            return "";
        }
        if (bi.oW(aVar.gvj.nickname)) {
            aVar.gvj.nickname = "";
        }
        return aVar.context.getString(R.l.app_brand_about_app_formatter, new Object[]{aVar.gvj.nickname});
    }

    static /* synthetic */ void a(a aVar, int i) {
        if (!bi.oW(aVar.getAppId())) {
            x.d("MicroMsg.AppBrandSerivceActionSheet", "stev report(%s), eventId : %s, appId %s, sceneId %s", new Object[]{Integer.valueOf(13798), Integer.valueOf(i), aVar.appId, aVar.trd});
            h.mEJ.h(13798, new Object[]{Integer.valueOf(i), aVar.getAppId(), Integer.valueOf(0), aVar.trd, Long.valueOf(bi.VE())});
        }
    }

    public a(Context context) {
        this.context = context;
    }

    public final void show(int i) {
        this.gmE = new com.tencent.mm.ui.widget.a.d(this.context, 1, true);
        switch (i) {
            case 1:
                this.trc = new a();
                break;
            case 2:
                this.trc = new b(this);
                break;
            case 3:
                this.trc = new f();
                break;
            case 4:
                this.trc = new g(this);
                break;
            case 5:
                this.trc = new d();
                break;
            case 6:
                this.trc = new e(this);
                break;
            default:
                return;
        }
        if (this.trc == null) {
            x.e("MicroMsg.AppBrandSerivceActionSheet", "resetTitleView, state is null");
        } else {
            View cqZ = this.trc.cqZ();
            if (cqZ != null) {
                this.gmE.dS(cqZ);
            }
        }
        this.gmE.ofp = new 2(this);
        this.gmE.ofq = new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                if (a.this.trc == null) {
                    x.e("MicroMsg.AppBrandSerivceActionSheet", "resetOnCreateMenuListener, state is null");
                } else {
                    a.this.trc.onMMMenuItemSelected(menuItem, i);
                }
            }
        };
        this.gmE.bXO();
    }

    final String getAppId() {
        if (bi.oW(this.username)) {
            return null;
        }
        if (bi.oW(this.appId)) {
            WxaAttributes rR = ((c) g.l(c.class)).rR(this.username);
            if (rR != null) {
                this.appId = rR.field_appId;
            }
        }
        return this.appId;
    }

    final void eO(int i, int i2) {
        if (!bi.oW(getAppId())) {
            x.d("MicroMsg.AppBrandSerivceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", new Object[]{Integer.valueOf(13918), this.appId, Integer.valueOf(i), this.trd, Integer.valueOf(i2)});
            h.mEJ.h(13918, new Object[]{getAppId(), Integer.valueOf(i), this.trd, Integer.valueOf(i2), Long.valueOf(bi.VE())});
        }
    }

    public static String as(String str, String str2, String str3) {
        String str4 = "";
        try {
            return String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&&business_appid=%s#wechat_redirect", new Object[]{p.encode(bi.oV(str), "UTF-8"), p.encode(bi.oV(str2), "UTF-8"), Integer.valueOf(10), p.encode(bi.oV(str3), "UTF-8")});
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.AppBrandSerivceActionSheet", "buildExposeUrl encode fail, invalid arguments");
            return str4;
        }
    }
}
