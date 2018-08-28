package com.tencent.mm.plugin.topstory.ui.video;

class TopStoryVideoPlayTextureView$1 implements Runnable {
    final /* synthetic */ TopStoryVideoPlayTextureView oAj;

    TopStoryVideoPlayTextureView$1(TopStoryVideoPlayTextureView topStoryVideoPlayTextureView) {
        this.oAj = topStoryVideoPlayTextureView;
    }

    public final void run() {
        synchronized (TopStoryVideoPlayTextureView.a(this.oAj)) {
            TopStoryVideoPlayTextureView.b(this.oAj);
        }
    }
}
