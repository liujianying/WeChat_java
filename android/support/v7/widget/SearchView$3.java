package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class SearchView$3 implements OnItemSelectedListener {
    final /* synthetic */ SearchView UF;

    SearchView$3(SearchView searchView) {
        this.UF = searchView;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        SearchView.b(this.UF, i);
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
