package com.tencent.mm.ui.chatting;

import android.graphics.Matrix;
import com.tencent.mm.sdk.platformtools.x;

class ChattingImageBGView$1 implements Runnable {
    final /* synthetic */ ChattingImageBGView tJs;

    ChattingImageBGView$1(ChattingImageBGView chattingImageBGView) {
        this.tJs = chattingImageBGView;
    }

    public final void run() {
        if (ChattingImageBGView.a(this.tJs) == null) {
            x.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but bmp is null");
            return;
        }
        if (ChattingImageBGView.a(this.tJs).getWidth() == 0) {
            x.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but measured width error");
        }
        Matrix matrix = new Matrix();
        float measuredWidth = ((float) this.tJs.getMeasuredWidth()) / ((float) ChattingImageBGView.a(this.tJs).getWidth());
        float measuredHeight = ((float) this.tJs.getMeasuredHeight()) / ((float) ChattingImageBGView.a(this.tJs).getHeight());
        x.d("MicroMsg.ChattingImageBGView", "scaleW[%f], scaleH[%f] measured width[%d] measured height[%d]", new Object[]{Float.valueOf(measuredWidth), Float.valueOf(measuredHeight), Integer.valueOf(this.tJs.getMeasuredWidth()), Integer.valueOf(this.tJs.getMeasuredHeight())});
        if (measuredWidth > measuredHeight) {
            matrix.setScale(measuredWidth, measuredWidth);
        } else {
            matrix.setScale(measuredHeight, measuredHeight);
            matrix.postTranslate((((float) this.tJs.getMeasuredWidth()) - (((float) ChattingImageBGView.a(this.tJs).getWidth()) * measuredHeight)) / 2.0f, 0.0f);
        }
        this.tJs.setImageMatrix(matrix);
    }
}
