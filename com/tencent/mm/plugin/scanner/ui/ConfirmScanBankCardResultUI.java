package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class ConfirmScanBankCardResultUI extends MMActivity {
    protected static final Map<String, Bitmap> mIc = new HashMap();
    protected Bitmap mBmp = null;
    private String mIb = null;
    private ImageView mIe;
    private EditText mIf;

    public static void c(Bitmap bitmap, String str) {
        if (bitmap != null && !bitmap.isRecycled() && !bi.oW(str)) {
            Intent intent = new Intent();
            intent.setClass(ad.getContext(), ConfirmScanBankCardResultUI.class);
            intent.addFlags(268435456);
            intent.putExtra("_card_num_", str);
            String str2 = "_image_cache_key_" + str;
            mIc.put(str2, bitmap);
            intent.putExtra("_image_cache_key_", str2);
            ad.getContext().startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        setMMTitle(R.l.scan_wallet_confirm_card_id_ui_title);
        if (getIntent() == null) {
            x.e("MicroMsg.ConfirmScanBankCardResultUI", "intent is null, return");
            obj = null;
        } else {
            this.mIb = getIntent().getStringExtra("_image_cache_key_");
            if (bi.oW(this.mIb)) {
                x.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp cache key is null or nil");
                obj = null;
            } else {
                this.mBmp = (Bitmap) mIc.get(this.mIb);
                if (this.mBmp == null || this.mBmp.isRecycled()) {
                    x.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp invalid, return");
                    obj = null;
                } else {
                    obj = 1;
                }
            }
        }
        if (obj == null) {
            finish();
            return;
        }
        CharSequence stringExtra = getIntent().getStringExtra("_card_num_");
        if (bi.oW(stringExtra)) {
            x.e("MicroMsg.ConfirmScanBankCardResultUI", "cardNum is null or nil");
            finish();
            return;
        }
        this.mIe = (ImageView) findViewById(R.h.imageBankCard);
        this.mIf = (EditText) findViewById(R.h.editBankCard);
        this.mIe.setImageBitmap(this.mBmp);
        this.mIf.setText(stringExtra);
        findViewById(R.h.buttonOK).setOnClickListener(new 1(this));
        setBackBtn(new 2(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mIe != null) {
            this.mIe.setImageBitmap(null);
        }
        if (!bi.oW(this.mIb)) {
            mIc.remove(this.mIb);
        }
        if (this.mBmp != null) {
            this.mBmp.recycle();
        }
    }

    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 7);
        intent.putExtra("scan_bankcard_with_confirm_ui", true);
        intent.addFlags(268435456);
        intent.setClass(this, BaseScanUI.class);
        startActivity(intent);
        super.finish();
    }

    protected final int getLayoutId() {
        return R.i.confirm_scan_bank_card_result_ui;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
