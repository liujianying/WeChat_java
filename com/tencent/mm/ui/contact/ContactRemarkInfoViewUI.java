package com.tencent.mm.ui.contact;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.at.c;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;

public class ContactRemarkInfoViewUI extends MMActivity {
    private String bgo;
    private String csT;
    private int eLK;
    private String edD;
    private ab guS;
    private TextView uiI;
    private TextView uiJ;
    private ImageView uiM;
    private boolean uiS = false;
    private View ujk;
    private View ujl;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eLK = getIntent().getIntExtra("Contact_Scene", 9);
        this.username = getIntent().getStringExtra("Contact_User");
        if (ai.oW(this.username)) {
            a();
            return;
        }
        Wj();
        initView();
    }

    public void onResume() {
        super.onResume();
        Wj();
        this.uiI.setText(j.a((Context) this, ai.oV(this.bgo), this.uiI.getTextSize()));
        if (ai.oW(this.csT)) {
            this.ujk.setVisibility(8);
        } else {
            this.ujk.setVisibility(0);
            this.uiJ.setText(ai.oV(this.csT));
        }
        if (ai.oW(this.edD)) {
            this.ujl.setVisibility(8);
            return;
        }
        this.ujl.setVisibility(0);
        c.Qt();
        if (c.mz(this.username)) {
            cyf();
        } else {
            c.Qt().a(this.username, this.edD, new 4(this));
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.contact_remark_info_view;
    }

    private void Wj() {
        au.HU();
        this.guS = com.tencent.mm.model.c.FR().Yg(this.username);
        this.bgo = this.guS.BL();
        this.csT = this.guS.csT;
        this.edD = this.guS.csU;
    }

    protected final void initView() {
        this.uiI = (TextView) findViewById(R.h.contact_info_remark_name_tv);
        this.uiJ = (TextView) findViewById(R.h.contact_info_remark_desc_tv);
        this.uiM = (ImageView) findViewById(R.h.remark_pic_display);
        this.ujk = findViewById(R.h.contact_remark_desc_container);
        this.ujl = findViewById(R.h.contact_remark_image_container);
        setMMTitle(R.l.contact_info_mod_remarkinfo);
        this.uiM.setOnClickListener(new 1(this));
        addTextOptionMenu(0, getString(R.l.app_edit), new 2(this));
        setBackBtn(new 3(this));
    }

    private void cyf() {
        c.Qt();
        Bitmap mB = c.mB(this.username);
        if (mB != null) {
            this.uiM.setImageBitmap(mB);
            this.uiS = true;
        }
    }
}
