package com.tencent.mm.ui.tools;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.VerticalScrollBar.a;

class CountryCodeUI$5 implements a {
    final /* synthetic */ CountryCodeUI uvR;

    CountryCodeUI$5(CountryCodeUI countryCodeUI) {
        this.uvR = countryCodeUI;
    }

    public final void ys(String str) {
        int i = 0;
        if (this.uvR.getString(R.l.scroll_bar_search).equals(str)) {
            CountryCodeUI.b(this.uvR).setSelection(0);
            return;
        }
        int intValue = Integer.decode(str.substring(0, str.length() - 1)).intValue();
        int[] iArr = CountryCodeUI.c(this.uvR).kuO;
        if (iArr != null) {
            while (i < iArr.length) {
                if (iArr[i] == intValue) {
                    CountryCodeUI.b(this.uvR).setSelection(i + CountryCodeUI.b(this.uvR).getHeaderViewsCount());
                    return;
                }
                i++;
            }
        }
    }
}
