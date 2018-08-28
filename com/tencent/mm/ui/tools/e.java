package com.tencent.mm.ui.tools;

import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ui.tools.ActionBarSearchView.a;
import com.tencent.mm.ui.tools.ActionBarSearchView.b;
import java.util.ArrayList;

public interface e {
    void czt();

    boolean czu();

    boolean czv();

    String getSearchContent();

    void ms(boolean z);

    void mt(boolean z);

    void setAutoMatchKeywords(boolean z);

    void setBackClickCallback(a aVar);

    void setCallBack(b bVar);

    void setEditTextEnabled(boolean z);

    void setHint(CharSequence charSequence);

    void setKeywords(ArrayList<String> arrayList);

    void setNotRealCallBack(SearchViewNotRealTimeHelper.a aVar);

    void setOnEditorActionListener(OnEditorActionListener onEditorActionListener);

    void setSearchContent(String str);

    void setSearchTipIcon(int i);

    void setSelectedTag(String str);

    void setStatusBtnEnabled(boolean z);
}
