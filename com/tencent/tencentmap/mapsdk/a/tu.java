package com.tencent.tencentmap.mapsdk.a;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public abstract class tu extends Activity {
    private List<tw> a = new ArrayList();
    private Bundle b;

    protected void a(tw twVar) {
        this.a.add(twVar);
        twVar.a(this.b);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = bundle;
    }

    protected void onDestroy() {
        super.onDestroy();
        for (tw twVar : this.a) {
            if (twVar != null) {
                twVar.e();
            }
        }
        this.a.clear();
    }

    protected void onPause() {
        super.onPause();
        for (tw twVar : this.a) {
            if (twVar != null) {
                twVar.b();
            }
        }
    }

    protected void onResume() {
        super.onResume();
        for (tw twVar : this.a) {
            if (twVar != null) {
                twVar.a();
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        for (tw twVar : this.a) {
            if (twVar != null) {
                twVar.b(bundle);
            }
        }
    }

    protected void onStop() {
        super.onStop();
        for (tw twVar : this.a) {
            if (twVar != null) {
                twVar.c();
            }
        }
    }
}
