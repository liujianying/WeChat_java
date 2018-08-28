package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.LinkedList;

public class NearLifeCreatePoiUI extends MMActivity implements e {
    private TextWatcher UE = new 7(this);
    private p fUo;
    private String fuu;
    private aqr lEa;
    private String lEb;
    private String lEc;
    private Addr lEd;
    private String lEe;
    private EditText lEf;
    private EditText lEg;
    private TextView lEh;
    private TextView lEi;
    private b lEj;
    private com.tencent.mm.plugin.nearlife.b.b lEk;
    private OnClickListener lEl = new 1(this);
    private OnClickListener lEm = new 2(this);
    private OnClickListener lEn = new 3(this);
    private OnMenuItemClickListener lEo = new 4(this);
    private a lEp = new 5(this);
    private OnMenuItemClickListener lEq = new 6(this);

    static /* synthetic */ LinkedList g(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        String charSequence = ((TextView) nearLifeCreatePoiUI.findViewById(R.h.tv_position_category)).getText().toString();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new bhz().VO(charSequence));
        return linkedList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.DF().a(650, this);
        this.lEa = new aqr();
        this.lEa.rms = getIntent().getFloatExtra("get_lat", -85.0f);
        this.lEa.rmr = getIntent().getFloatExtra("get_lng", -1000.0f);
        this.lEa.ryV = getIntent().getIntExtra("get_preci", 0);
        this.lEa.ryX = "";
        this.lEa.ryY = 0;
        this.lEa.ryW = "";
        this.lEj = b.Oz();
        if (this.lEj != null) {
            this.lEj.a((double) this.lEa.rms, (double) this.lEa.rmr, this.lEp);
        }
        this.fuu = getIntent().getStringExtra("search_id");
        x.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", new Object[]{this.fuu});
        initView();
    }

    protected final int getLayoutId() {
        return R.i.near_life_create_poi;
    }

    protected final void initView() {
        setMMTitle(R.l.nl_create_poi_title);
        ((ViewGroup) findViewById(R.h.ll_pos_district_ctn)).setOnClickListener(this.lEl);
        ((ViewGroup) findViewById(R.h.ll_pos_category_ctn)).setOnClickListener(this.lEm);
        ((TextView) findViewById(R.h.tv_more_content)).setOnClickListener(this.lEn);
        findViewById(R.h.tv_more_content).setVisibility(8);
        findViewById(R.h.ll_pos_category_ctn).setVisibility(0);
        findViewById(R.h.ll_pos_tel_container).setVisibility(0);
        this.lEf = (EditText) findViewById(R.h.et_position_name);
        this.lEg = (EditText) findViewById(R.h.et_detailed_address);
        this.lEh = (TextView) findViewById(R.h.tv_position_district);
        this.lEi = (TextView) findViewById(R.h.tv_position_category);
        this.lEf.addTextChangedListener(this.UE);
        this.lEg.addTextChangedListener(this.UE);
        this.lEh.addTextChangedListener(this.UE);
        Object aG = bi.aG(getIntent().getStringExtra("get_poi_name"), "");
        if (aG.length() != 0) {
            this.lEf.setText(aG);
            this.lEf.setSelection(aG.length());
        }
        c.d(this.lEf).Gi(100).a(null);
        c.d(this.lEg).Gi(TbsListener$ErrorCode.INFO_CODE_BASE).a(null);
        c.d((EditText) findViewById(R.h.et_position_tel)).Gi(100).a(null);
        a(0, getString(R.l.app_finish), this.lEo, s.b.tmX);
        enableOptionMenu(0, false);
        setBackBtn(this.lEq);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                String stringExtra = intent.getStringExtra("karea_result");
                if (!bi.oW(stringExtra)) {
                    ((TextView) findViewById(R.h.tv_position_district)).setText(stringExtra.replace(" ", ""));
                    return;
                }
                return;
            case 2:
                if (-1 == i2 && intent != null) {
                    this.lEi.setText(bi.oV(intent.getStringExtra("poi_category")));
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(650, this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != keyEvent.getKeyCode()) {
            return super.onKeyDown(i, keyEvent);
        }
        bjf();
        return true;
    }

    private void bjf() {
        h.a(this, R.l.nl_abandon_create_poi, R.l.nl_create_poi_title, new 8(this), null);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            this.fUo.dismiss();
            com.tencent.mm.plugin.nearlife.b.b bVar = (com.tencent.mm.plugin.nearlife.b.b) lVar;
            Intent intent = new Intent();
            if (this.lEa != null) {
                intent.putExtra("get_lat", this.lEa.rms);
                intent.putExtra("get_lng", this.lEa.rmr);
            }
            if (this.lEd != null) {
                intent.putExtra("get_city", this.lEd.dRJ);
            }
            intent.putExtra("get_poi_address", this.lEc);
            intent.putExtra("get_poi_classify_id", bVar.lCR);
            intent.putExtra("get_poi_name", this.lEb);
            intent.putExtra("get_poi_classify_type", 1);
            setResult(-1, intent);
            finish();
            return;
        }
        this.fUo.dismiss();
        Toast.makeText(this.mController.tml, getString(R.l.nl_create_failed), 1).show();
        this.lEk = null;
    }
}
