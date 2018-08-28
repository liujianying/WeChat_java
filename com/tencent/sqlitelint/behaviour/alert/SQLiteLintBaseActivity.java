package com.tencent.sqlitelint.behaviour.alert;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.sqlitelint.d.b;
import com.tencent.sqlitelint.d.c;

public abstract class SQLiteLintBaseActivity extends Activity {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteLintBaseActivity.class.desiredAssertionStatus());
    private Toolbar vnN;

    protected abstract int getLayoutId();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.activity_sqlitelint_base);
        FrameLayout frameLayout = (FrameLayout) findViewById(b.content);
        LayoutInflater from = LayoutInflater.from(this);
        int layoutId = getLayoutId();
        if ($assertionsDisabled || layoutId != 0) {
            from.inflate(layoutId, frameLayout);
            this.vnN = (Toolbar) findViewById(b.toolbar);
            this.vnN.setNavigationOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    SQLiteLintBaseActivity.this.finish();
                }
            });
            Drawable logo = this.vnN.getLogo();
            if (logo != null) {
                logo.setVisible(false, true);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    protected final void setTitle(String str) {
        this.vnN.setTitle((CharSequence) str);
    }
}
