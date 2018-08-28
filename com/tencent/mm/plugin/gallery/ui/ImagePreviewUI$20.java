package com.tencent.mm.plugin.gallery.ui;

class ImagePreviewUI$20 implements Runnable {
    final /* synthetic */ ImagePreviewUI jEa;
    final /* synthetic */ int jEf;

    ImagePreviewUI$20(ImagePreviewUI imagePreviewUI, int i) {
        this.jEa = imagePreviewUI;
        this.jEf = i;
    }

    public final void run() {
        ImagePreviewUI.o(this.jEa).smoothScrollToPosition(this.jEf);
    }
}
