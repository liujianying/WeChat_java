package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Matrix;
import android.view.View;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

class VideoSegmentUI$a$1 extends MMTextureView {
    final /* synthetic */ a lnw;

    VideoSegmentUI$a$1(a aVar, Context context) {
        this.lnw = aVar;
        super(context);
    }

    protected final void onMeasure(int i, int i2) {
        x.d("MicroMsg.VideoSegmentUI", "onMeasure video size[%d, %d, %d] spec[%d, %d]", new Object[]{Integer.valueOf(a.a(this.lnw)), Integer.valueOf(a.b(this.lnw)), Integer.valueOf(a.c(this.lnw)), Integer.valueOf(View.getDefaultSize(1, i)), Integer.valueOf(View.getDefaultSize(1, i2))});
        if (a.c(this.lnw) == 90 || a.c(this.lnw) == aw.CTRL_BYTE) {
            Matrix matrix = new Matrix();
            matrix.set(getMatrix());
            int defaultSize = View.getDefaultSize(1, i);
            int defaultSize2 = View.getDefaultSize(1, i2);
            float f = ((float) defaultSize) / 2.0f;
            float f2 = ((float) defaultSize2) / 2.0f;
            float f3 = ((float) defaultSize2) / ((float) defaultSize);
            matrix.postRotate((float) a.c(this.lnw), f, f2);
            matrix.postScale(1.0f / f3, f3, f, f2);
            setTransform(matrix);
            x.i("MicroMsg.VideoSegmentUI", "rotate transform mDegrees[%d] screenSize[%d, %d]", new Object[]{Integer.valueOf(a.c(this.lnw)), Integer.valueOf(defaultSize), Integer.valueOf(defaultSize2)});
        }
        super.onMeasure(i, i2);
    }
}
