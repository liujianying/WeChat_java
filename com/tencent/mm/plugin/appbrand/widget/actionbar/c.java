package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.mm.plugin.appbrand.page.a.a;

public interface c {
    void aoZ();

    void dk(boolean z);

    View getActionView();

    double getBackgroundAlpha();

    int getBackgroundColor();

    int getForegroundColor();

    LayoutParams getLayoutParams();

    CharSequence getMainTitle();

    ViewParent getParent();

    void setBackButtonClickListener(OnClickListener onClickListener);

    void setBackgroundAlpha(double d);

    void setBackgroundColor(int i);

    void setBackgroundColor(String str);

    void setCapsuleHomeButtonLongClickListener(OnLongClickListener onLongClickListener);

    void setCloseButtonClickListener(OnClickListener onClickListener);

    void setForegroundColor(int i);

    void setForegroundStyle(String str);

    void setLayoutParams(LayoutParams layoutParams);

    void setLoadingIconVisibility(boolean z);

    void setMainTitle(String str);

    void setNavBackOrClose(boolean z);

    void setNavHidden(boolean z);

    void setOptionBtnStatus(a aVar);

    void setOptionButtonClickListener(OnClickListener onClickListener);

    void setTitleAreaOnDoubleClickListener(OnClickListener onClickListener);
}
