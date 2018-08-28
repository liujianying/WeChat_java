package com.tenpay.bankcard;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class TenpaySegmentEditText$2 implements OnFocusChangeListener {
    final /* synthetic */ TenpaySegmentEditText this$0;
    final /* synthetic */ EditText val$edit;

    TenpaySegmentEditText$2(TenpaySegmentEditText tenpaySegmentEditText, EditText editText) {
        this.this$0 = tenpaySegmentEditText;
        this.val$edit = editText;
    }

    public void onFocusChange(View view, boolean z) {
        LogUtil.d("MyTag", new Object[]{"edit onFocusChange hasFocus=" + z});
        if (z) {
            if (TenpaySegmentEditText.access$000(this.this$0) != null) {
                TenpaySegmentEditText.access$000(this.this$0).onClick(view);
            }
            if (TenpaySegmentEditText.access$200(this.this$0) != null) {
                LogUtil.d("MyTag", new Object[]{"keyboard is not null"});
                TenpaySegmentEditText.access$200(this.this$0).setXMode(0);
                TenpaySegmentEditText.access$200(this.this$0).setInputEditText(this.val$edit);
            }
        }
    }
}
