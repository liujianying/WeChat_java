package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;

class ImagePreviewUI$16 implements Runnable {
    final /* synthetic */ ImagePreviewUI jEa;
    final /* synthetic */ MediaItem jEd;

    ImagePreviewUI$16(ImagePreviewUI imagePreviewUI, MediaItem mediaItem) {
        this.jEa = imagePreviewUI;
        this.jEd = mediaItem;
    }

    public final void run() {
        ImagePreviewUI.a(this.jEa, this.jEd);
    }
}
