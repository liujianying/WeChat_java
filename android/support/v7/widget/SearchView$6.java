package android.support.v7.widget;

class SearchView$6 implements Runnable {
    final /* synthetic */ SearchView UF;

    SearchView$6(SearchView searchView) {
        this.UF = searchView;
    }

    public final void run() {
        if (SearchView.b(this.UF) != null && (SearchView.b(this.UF) instanceof ak)) {
            SearchView.b(this.UF).changeCursor(null);
        }
    }
}
