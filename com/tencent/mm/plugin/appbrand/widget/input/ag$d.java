package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.s.b;

final class ag$d extends Resources {
    ag$d(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
    }

    public final String[] getStringArray(int i) {
        if (b.merge_smiley_code_smiley == i) {
            return new String[0];
        }
        if (b.merge_smiley_softbank_emoji == i) {
            return new String[0];
        }
        return super.getStringArray(i);
    }
}
