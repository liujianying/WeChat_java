package com.tencent.mm.plugin.webview.ui.tools.bag;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;

public final class b {
    public static final int qbj;
    public static final int qbk = ak.eL(ad.getContext());
    public static final int qbl = ad.getContext().getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
    public static final int qbm = ad.getContext().getResources().getDimensionPixelSize(R.f.webview_bag_size);
    public static final int qbn = ad.getContext().getResources().getDimensionPixelSize(R.f.webview_bag_margin);
    public static final int qbo = ad.getContext().getResources().getDimensionPixelSize(R.f.webview_bag_indicator_size);
    public static final int qbp;
    public static final float qbq;

    static {
        x.i("MicroMsg.BagIndicatorController", "getNavigationBarHeight show:%b height:%d", new Object[]{Boolean.valueOf(ak.gt(ad.getContext())), Integer.valueOf(ak.gt(ad.getContext()) ? ak.gs(ad.getContext()) : 0)});
        qbj = r0;
        int dimensionPixelSize = ad.getContext().getResources().getDimensionPixelSize(R.f.webview_bag_indicator_container_size);
        qbp = dimensionPixelSize;
        qbq = ((float) dimensionPixelSize) / ((float) qbo);
    }
}
