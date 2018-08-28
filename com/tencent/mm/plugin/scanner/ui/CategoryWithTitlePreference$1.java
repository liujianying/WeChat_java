package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;

class CategoryWithTitlePreference$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ CategoryWithTitlePreference mHY;

    CategoryWithTitlePreference$1(CategoryWithTitlePreference categoryWithTitlePreference, Bitmap bitmap) {
        this.mHY = categoryWithTitlePreference;
        this.abc = bitmap;
    }

    public final void run() {
        CategoryWithTitlePreference.a(this.mHY).setImageBitmap(this.abc);
        CategoryWithTitlePreference.a(this.mHY).setVisibility(0);
        if (CategoryWithTitlePreference.b(this.mHY) != null) {
            CategoryWithTitlePreference.b(this.mHY).notifyDataSetChanged();
        }
    }
}
