package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.widget.ListView;

public interface af {
    void EV(int i);

    void EW(int i);

    void Y(boolean z, boolean z2);

    void addHeaderView(View view);

    void avj();

    void bg(int i);

    void c(Context context, String str, OnCancelListener onCancelListener);

    void ctY();

    void cuc();

    void cue();

    void dismissDialog();

    void eX(int i, int i2);

    View getChildAt(int i);

    int getFirstVisiblePosition();

    int getHeaderViewsCount();

    int getLastVisiblePosition();

    ListView getListView();

    boolean hideVKB();

    void lT(boolean z);

    boolean removeOptionMenu(int i);

    void setKeepScreenOn(boolean z);

    void showOptionMenu(int i, boolean z);

    void showOptionMenu(boolean z);

    void showVKB();

    void updateOptionMenuIcon(int i, int i2);
}
