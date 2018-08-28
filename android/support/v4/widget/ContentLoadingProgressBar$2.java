package android.support.v4.widget;

class ContentLoadingProgressBar$2 implements Runnable {
    final /* synthetic */ ContentLoadingProgressBar yS;

    ContentLoadingProgressBar$2(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.yS = contentLoadingProgressBar;
    }

    public final void run() {
        ContentLoadingProgressBar.b(this.yS);
        if (!ContentLoadingProgressBar.c(this.yS)) {
            ContentLoadingProgressBar.a(this.yS, System.currentTimeMillis());
            this.yS.setVisibility(0);
        }
    }
}
