package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;

public final class a {
    private static int kYs = 39;
    private static int kYt = 40;
    private static int kYu = 95;
    private static int kYv = 0;
    private static int kYw = 0;
    private static int kYx = 70;

    public static void f(MMActivity mMActivity) {
        int height;
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(mMActivity, kYs);
        int fromDPToPix2 = com.tencent.mm.bp.a.fromDPToPix(mMActivity, kYt);
        int i = ak.gu(mMActivity).y;
        if (ak.gt(mMActivity)) {
            i -= ak.gs(mMActivity);
        }
        if (mMActivity.getSupportActionBar() != null) {
            height = mMActivity.getSupportActionBar().getHeight();
        } else {
            height = 0;
        }
        int fromDPToPix3 = com.tencent.mm.bp.a.fromDPToPix(mMActivity, kYu);
        kYv = Math.round(((float) (((i - (fromDPToPix * 2)) - fromDPToPix2) - height)) / 5.0f);
        x.i("MicroMsg.FunctionGridSizeCalculator", "calc GRID_HEIGHT_SIZE_PX: %s, minHeight: %s", new Object[]{Integer.valueOf(kYv), Integer.valueOf(fromDPToPix3)});
        if (kYv < fromDPToPix3) {
            kYv = fromDPToPix3;
        }
        kYw = Math.round(((float) (kYv * 4)) / 3.0f) + com.tencent.mm.bp.a.fromDPToPix(mMActivity, kYx);
        x.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", new Object[]{Integer.valueOf(kYv), Integer.valueOf(kYw)});
    }

    public static int bbK() {
        return kYv;
    }

    public static int bbL() {
        return kYw;
    }

    public static int bbM() {
        return com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), kYs);
    }
}
