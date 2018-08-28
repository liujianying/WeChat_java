package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery;

public class ContactRemarkImagePreviewUI extends MMActivity {
    private MMGestureGallery hDd;
    private boolean uiA;
    private boolean uiB;
    private a uiC;
    private View uiy;
    private String uiz;
    private String username;

    static /* synthetic */ void d(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
        ch chVar = new ch();
        e.a(chVar, 6, contactRemarkImagePreviewUI.uiz);
        chVar.bJF.activity = contactRemarkImagePreviewUI;
        chVar.bJF.bJM = 46;
        a.sFg.m(chVar);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.username = getIntent().getStringExtra("Contact_User");
        this.uiz = getIntent().getStringExtra("remark_image_path");
        this.uiA = getIntent().getBooleanExtra("view_temp_remark_image", false);
        this.uiB = getIntent().getBooleanExtra("view_only", false);
        if (bi.oW(this.username)) {
            finish();
        } else {
            initView();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.contact_remark_image_preview;
    }

    protected final void initView() {
        this.uiy = findViewById(R.h.container_ll);
        this.hDd = (MMGestureGallery) findViewById(R.h.gallery);
        setMMTitle(R.l.mod_remark_preview_image_title);
        this.hDd.setVerticalFadingEdgeEnabled(false);
        this.hDd.setHorizontalFadingEdgeEnabled(false);
        k.bD(this.hDd);
        this.uiC = new a(this);
        this.uiC.imagePath = this.uiz;
        this.hDd.setAdapter(this.uiC);
        this.hDd.setOnItemClickListener(new 3(this));
        addIconOptionMenu(0, R.k.actionbar_icon_dark_more, new 1(this));
        setBackBtn(new 2(this));
    }

    private void mi(boolean z) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("response_delete", true);
            setResult(-1, intent);
        }
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        mi(false);
        return true;
    }
}
