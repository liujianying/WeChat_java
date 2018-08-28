package com.tencent.mm.plugin.game.ui;

import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.ui.GameBannerView.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

final class GameBannerView$b extends u {
    final /* synthetic */ GameBannerView jUn;

    private GameBannerView$b(GameBannerView gameBannerView) {
        this.jUn = gameBannerView;
    }

    /* synthetic */ GameBannerView$b(GameBannerView gameBannerView, byte b) {
        this(gameBannerView);
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        int size = i % GameBannerView.b(this.jUn).size();
        viewGroup.removeView((View) obj);
        x.i("MicroMsg.GameBannerView", "destroyItem : new positon = %d, now position = %d", new Object[]{Integer.valueOf(size), Integer.valueOf(i)});
    }

    public final Object b(ViewGroup viewGroup, int i) {
        int size = i % GameBannerView.b(this.jUn).size();
        View inflate = View.inflate(GameBannerView.d(this.jUn), f.game_banner_view_item, null);
        inflate.setTag(GameBannerView.b(this.jUn).get(size));
        inflate.setOnClickListener(this.jUn);
        ImageView imageView = (ImageView) inflate.findViewById(e.game_ad_header_item_image);
        String str = ((a) GameBannerView.b(this.jUn).get(size)).dGg;
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof j)) {
            imageView.setImageDrawable(new j(str, (byte) 0));
        } else {
            ((j) drawable).setUrl(str);
        }
        try {
            viewGroup.addView(inflate, 0);
        } catch (Exception e) {
            x.e("MicroMsg.GameBannerView", "add view failed, " + e.getMessage());
        }
        x.i("MicroMsg.GameBannerView", "instantiateItem : new positon = %d, now position = %d", new Object[]{Integer.valueOf(size), Integer.valueOf(i)});
        return inflate;
    }

    public final int getCount() {
        return GameBannerView.b(this.jUn).size() <= 1 ? GameBannerView.b(this.jUn).size() : (GameBannerView.b(this.jUn).size() * BaseReportManager.MAX_READ_COUNT) * 2;
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }
}
