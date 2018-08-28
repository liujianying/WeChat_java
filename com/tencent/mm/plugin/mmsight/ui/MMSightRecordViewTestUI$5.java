package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Point;
import android.widget.TextView;

class MMSightRecordViewTestUI$5 implements Runnable {
    final /* synthetic */ MMSightRecordViewTestUI loN;
    final /* synthetic */ TextView loR;

    MMSightRecordViewTestUI$5(MMSightRecordViewTestUI mMSightRecordViewTestUI, TextView textView) {
        this.loN = mMSightRecordViewTestUI;
        this.loR = textView;
    }

    public final void run() {
        this.loR.setText("");
        this.loR.append(String.format("picture size: %s, ratio: %s\n", new Object[]{MMSightRecordViewTestUI.a(this.loN).getPictureSize(), Float.valueOf(((float) Math.min(MMSightRecordViewTestUI.a(this.loN).getPictureSize().x, MMSightRecordViewTestUI.a(this.loN).getPictureSize().y)) / ((float) Math.max(MMSightRecordViewTestUI.a(this.loN).getPictureSize().x, MMSightRecordViewTestUI.a(this.loN).getPictureSize().y)))}));
        this.loR.append(String.format("video size: %s, ratio: %s\n", new Object[]{MMSightRecordViewTestUI.a(this.loN).getVideoSize(), Float.valueOf(((float) Math.min(MMSightRecordViewTestUI.a(this.loN).getVideoSize().x, MMSightRecordViewTestUI.a(this.loN).getVideoSize().y)) / ((float) Math.max(MMSightRecordViewTestUI.a(this.loN).getVideoSize().x, MMSightRecordViewTestUI.a(this.loN).getVideoSize().y)))}));
        this.loR.append(String.format("preview size limit: %s\n", new Object[]{Integer.valueOf(MMSightRecordViewTestUI.b(this.loN))}));
        this.loR.append(String.format("display ratio: %s\n", new Object[]{Float.valueOf(MMSightRecordViewTestUI.c(this.loN))}));
        this.loR.append(String.format("view size: %s, ratio: %s\n", new Object[]{new Point(MMSightRecordViewTestUI.a(this.loN).getWidth(), MMSightRecordViewTestUI.a(this.loN).getHeight()), Float.valueOf(((float) MMSightRecordViewTestUI.a(this.loN).getWidth()) / ((float) MMSightRecordViewTestUI.a(this.loN).getHeight()))}));
    }
}
