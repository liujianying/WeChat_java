package com.tencent.mm.plugin.scanner.history.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.plugin.scanner.history.a.a;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.ui.MMActivity;

public class ScannerHistoryUI extends MMActivity {
    private ListView CU;
    private View gQd;
    private LinearLayout hGr;
    private View hGs;
    private TextView hGt;
    private a mFn;

    static /* synthetic */ void a(ScannerHistoryUI scannerHistoryUI, int i) {
        a aVar = (a) scannerHistoryUI.mFn.getItem(i);
        if (aVar != null) {
            Intent intent = new Intent();
            intent.setClass(scannerHistoryUI, ProductUI.class);
            intent.setFlags(65536);
            intent.putExtra("key_Product_xml", aVar.field_xmlContent);
            intent.putExtra("key_Product_funcType", aVar.field_funcType);
            intent.putExtra("key_Qrcode_Url", aVar.field_qrcodeUrl);
            intent.putExtra("key_need_add_to_history", false);
            scannerHistoryUI.startActivity(intent);
            h.mEJ.h(12684, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
        }
    }

    protected final int getLayoutId() {
        return R.i.scan_history_list_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.scan_history_ttile);
        setBackBtn(new 1(this));
        this.CU = (ListView) findViewById(R.h.scan_history_lv);
        this.hGr = (LinearLayout) View.inflate(getBaseContext(), R.i.scan_history_list_header_view, null);
        this.CU.addHeaderView(this.hGr);
        this.mFn = new a(this);
        this.CU.setAdapter(this.mFn);
        this.CU.setOnItemClickListener(new 2(this));
        this.CU.setOnItemLongClickListener(new 3(this));
        addTextOptionMenu(0, getString(R.l.card_clear), new 4(this));
        this.gQd = findViewById(R.h.content_no_data);
        this.hGs = View.inflate(this, R.i.scan_history_list_header_tips_layout, null);
        if (this.hGr != null) {
            this.hGr.addView(this.hGs);
        }
        this.hGt = (TextView) this.hGs.findViewById(R.h.history_list_header_tips);
        this.hGt.setText(R.l.history_only_show_product);
        axM();
    }

    private void axM() {
        if (c.brZ().getCount() > 0) {
            this.CU.setVisibility(0);
            this.gQd.setVisibility(8);
            this.hGs.setVisibility(0);
            enableOptionMenu(true);
        } else {
            this.CU.setVisibility(8);
            this.gQd.setVisibility(0);
            this.hGs.setVisibility(8);
            enableOptionMenu(false);
        }
        this.mFn.notifyDataSetChanged();
    }
}
