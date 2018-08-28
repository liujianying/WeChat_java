package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.a;

@a(3)
public class MMBaseActivity extends Activity {
    private boolean mIsPaused;

    public Resources getResources() {
        if (getAssets() == null || ad.getResources() == null) {
            return super.getResources();
        }
        return ad.getResources();
    }

    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        if (getAssets() == null || !"layout_inflater".equals(str)) {
            return systemService;
        }
        return y.b((LayoutInflater) systemService);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
    }

    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
    }

    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!d.a(this, this.mIsPaused, new Intent[]{intent}, new Object[]{Integer.valueOf(i), bundle})) {
            super.startActivityForResult(intent, i, bundle);
        }
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    public void startActivities(Intent[] intentArr) {
        super.startActivities(intentArr);
    }

    public void startActivities(Intent[] intentArr, Bundle bundle) {
        if (!d.a(this, this.mIsPaused, intentArr, new Object[]{bundle})) {
            super.startActivities(intentArr, bundle);
        }
    }

    public void startActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
    }
}
