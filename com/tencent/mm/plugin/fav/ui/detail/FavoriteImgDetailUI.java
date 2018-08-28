package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.bp.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.ui.FavDetailFooterView;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.h;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.fav.ui.widget.FavDetailTitleView;
import com.tencent.mm.plugin.fav.ui.widget.FavTagEntrance;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FavoriteImgDetailUI extends BaseFavDetailReportUI implements p {
    private c iYS = new 9(this);
    private OnClickListener iZP = new 4(this);
    private LinearLayout jcJ;
    private FavDetailTitleView jcK;
    private FavDetailFooterView jcL;
    private FavTagEntrance jcM;
    private int jcN = 0;
    private g jcO;
    private HashMap<String, a> jcP = new HashMap();
    private Bitmap jcQ;
    private boolean jcR = true;
    private OnLongClickListener jcS = new 5(this);

    protected final MMLoadScrollView aMI() {
        return (MMLoadScrollView) findViewById(e.scroll_view);
    }

    protected final int getLayoutId() {
        return f.favorite_img_detail_ui;
    }

    public void onCreate(Bundle bundle) {
        com.tencent.mm.pluginsdk.e.k(this);
        super.onCreate(bundle);
        aMO();
        this.jcJ = (LinearLayout) findViewById(e.fav_img_container);
        this.jcK = (FavDetailTitleView) findViewById(e.fav_detail_title);
        this.jcL = (FavDetailFooterView) findViewById(e.fav_detail_footer);
        this.jcM = (FavTagEntrance) findViewById(e.fav_tag_entrance);
        this.jcO = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(getIntent().getLongExtra("key_detail_info_id", -1));
        if (this.jcO == null) {
            finish();
            return;
        }
        F(this.jcO);
        this.jcK.D(this.jcO);
        this.jcL.D(this.jcO);
        Iterator it = this.jcO.field_favProto.rBI.iterator();
        int i = 0;
        while (it.hasNext()) {
            vx vxVar = (vx) it.next();
            x.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", new Object[]{Integer.valueOf(i), vxVar.jdM});
            a aVar = new a(this, (byte) 0);
            aVar.bOz = vxVar;
            int i2 = i + 1;
            View imageView = new ImageView(this.mController.tml);
            int dimensionPixelSize = getResources().getDimensionPixelSize(m.c.SmallPadding);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (i > 0) {
                layoutParams.topMargin = dimensionPixelSize;
            }
            this.jcJ.addView(imageView, layoutParams);
            imageView.setTag(vxVar);
            i = dimensionPixelSize / 2;
            imageView.setScaleType(ScaleType.CENTER_INSIDE);
            imageView.setPadding(i, i, i, i);
            imageView.setMinimumWidth(a.fromDPToPix(this.mController.tml, 50));
            imageView.setMinimumHeight(a.fromDPToPix(this.mController.tml, 50));
            imageView.setImageResource(h.fav_list_img_default);
            imageView.setOnClickListener(this.iZP);
            imageView.setOnLongClickListener(this.jcS);
            aVar.bOA = imageView;
            this.jcP.put(vxVar.jdM, aVar);
            a(aVar);
            if (vxVar.rAw != 0) {
                this.jcR = false;
            }
            i = i2;
        }
        this.jcM.setFavItemID(this.jcO.field_localId);
        this.jcM.setTagContent(this.jcO.field_tagProto.rBX);
        setMMTitle(getString(i.favorite_detail));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FavoriteImgDetailUI.this.finish();
                return true;
            }
        });
        addIconOptionMenu(0, i.top_item_desc_more, h.actionbar_icon_dark_more, new 2(this));
        com.tencent.mm.pluginsdk.e.l(this);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().c(this.jcM);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().a(this);
        com.tencent.mm.sdk.b.a.sFg.b(this.iYS);
    }

    protected void onResume() {
        super.onResume();
        for (Entry value : this.jcP.entrySet()) {
            a((a) value.getValue());
        }
    }

    protected void onDestroy() {
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().d(this.jcM);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().b(this);
        com.tencent.mm.sdk.b.a.sFg.c(this.iYS);
        super.onDestroy();
    }

    private void aMO() {
        DisplayMetrics displayMetrics;
        if (ad.getResources() != null) {
            displayMetrics = ad.getResources().getDisplayMetrics();
        } else {
            displayMetrics = getResources().getDisplayMetrics();
        }
        this.jcN = displayMetrics.widthPixels - (getResources().getDimensionPixelOffset(m.c.FavDetailPadding) * 2);
        this.jcN = Math.max(this.jcN, 0);
        x.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", new Object[]{Integer.valueOf(this.jcN)});
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        aMO();
        for (Entry value : this.jcP.entrySet()) {
            a((a) value.getValue());
        }
    }

    private void a(a aVar) {
        com.tencent.mm.kernel.g.Em().H(new 3(this, aVar));
    }

    public static void a(String str, String str2, Context context) {
        if (bi.oW(str)) {
            x.w("MicroMsg.FavoriteImgDetailUI", "save image fail, path is null");
        } else if (!r.a(str, context, i.cropimage_saved)) {
            Toast.makeText(context, str2, 1).show();
        }
    }

    private Bitmap l(vx vxVar) {
        boolean z = true;
        Bitmap a = k.a(vxVar, this.jcO);
        String str = "MicroMsg.FavoriteImgDetailUI";
        String str2 = "get thumb ok ? %B";
        Object[] objArr = new Object[1];
        if (a == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        if (a != null) {
            return a;
        }
        if (this.jcQ == null) {
            this.jcQ = com.tencent.mm.compatible.g.a.decodeResource(getResources(), h.fav_list_img_default);
        }
        return this.jcQ;
    }

    public final void d(com.tencent.mm.plugin.fav.a.c cVar) {
        if (cVar != null && cVar.isFinished()) {
            x.d("MicroMsg.FavoriteImgDetailUI", "on cdn status change, dataid[%s]", new Object[]{cVar.field_dataId});
            a aVar = (a) this.jcP.get(cVar.field_dataId);
            if (aVar != null) {
                a(aVar);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i) {
            if (-1 == i2) {
                com.tencent.mm.plugin.fav.a.k kVar = new com.tencent.mm.plugin.fav.a.k();
                if (com.tencent.mm.plugin.fav.a.k.u(this.jcO)) {
                    com.tencent.mm.ui.base.h.bA(this.mController.tml, getString(i.Fav_NotDownload_CannotForward));
                    return;
                }
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                x.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", new Object[]{stringExtra});
                com.tencent.mm.plugin.fav.ui.h.a(this.mController.tml, stringExtra, stringExtra2, this.jcO, new 8(this, com.tencent.mm.ui.base.h.a(this.mController.tml, getString(i.favorite_forward_tips), false, null)));
            } else {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
