package com.tencent.mm.plugin.card.sharecard.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.x;

class ShareCardListUI$4 implements OnScrollListener {
    final /* synthetic */ ShareCardListUI hAq;

    ShareCardListUI$4(ShareCardListUI shareCardListUI) {
        this.hAq = shareCardListUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !ShareCardListUI.g(this.hAq) && ShareCardListUI.d(this.hAq) != 4) {
            x.d("MicroMsg.ShareCardListUI", "onScroll() >> doNetSceneGetCardsHomePageLayout()");
            ShareCardListUI.h(this.hAq);
        }
    }
}
