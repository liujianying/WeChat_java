package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ai;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.l.a;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;

public interface u {
    void a(a aVar, f.a aVar2);

    void a(ai aiVar);

    void a(Menu menu, a aVar);

    ai c(int i, long j);

    void collapseActionView();

    void dismissPopupMenus();

    ViewGroup eQ();

    boolean ef();

    boolean eg();

    void eh();

    Context getContext();

    View getCustomView();

    int getDisplayOptions();

    int getHeight();

    Menu getMenu();

    int getNavigationMode();

    CharSequence getTitle();

    int getVisibility();

    boolean hasExpandedActionView();

    boolean hideOverflowMenu();

    boolean isOverflowMenuShowing();

    void setBackgroundDrawable(Drawable drawable);

    void setCollapsible(boolean z);

    void setCustomView(View view);

    void setDisplayOptions(int i);

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setLogo(int i);

    void setLogo(Drawable drawable);

    void setNavigationContentDescription(int i);

    void setVisibility(int i);

    void setWindowCallback(Callback callback);

    void setWindowTitle(CharSequence charSequence);

    boolean showOverflowMenu();
}
