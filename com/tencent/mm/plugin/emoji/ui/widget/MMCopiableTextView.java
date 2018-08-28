package com.tencent.mm.plugin.emoji.ui.widget;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class MMCopiableTextView extends EditText implements OnLongClickListener {
    private final String TAG = "MicroMsg.MMCopiableTextView";
    private int gKG;
    private int iss;

    public MMCopiableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMCopiableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOnLongClickListener(this);
        setLongClickable(true);
    }

    protected void onCreateContextMenu(ContextMenu contextMenu) {
    }

    protected boolean getDefaultEditable() {
        return false;
    }

    public boolean onLongClick(View view) {
        String obj = getEditableText().toString();
        if (!bi.oW(obj) && this.gKG > 0 && this.iss > 0 && this.iss > this.gKG) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setText(obj.substring(this.gKG, this.iss).trim());
                x.i("MicroMsg.MMCopiableTextView", "copy text :%s", new Object[]{clipboardManager.getText()});
            }
            Toast.makeText(getContext(), R.l.app_copy_ok, 0).show();
        }
        return false;
    }

    public void setStartIndex(int i) {
        this.gKG = i;
    }

    public void setEndIndex(int i) {
        this.iss = i;
    }
}
