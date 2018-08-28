package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.br.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;

public final class m {
    private Context mContext;
    private StringBuilder qHo;
    private SpannableStringBuilder qHp = new SpannableStringBuilder();
    private SpannableString qHq;
    private SpannableStringBuilder qHr = new SpannableStringBuilder();
    private CharacterStyle qHs = new ForegroundColorSpan(-5066062);
    private int qHt;
    private int qHu;
    public int qHv = 3;

    public m(Context context) {
        this.mContext = context;
    }

    public final void a(MMEditText mMEditText, String str, boolean z) {
        if (mMEditText != null) {
            if (this.qHo == null) {
                throw new IllegalStateException("You should saveHistory before setText");
            }
            int length = this.qHt + str.length();
            this.qHp.clear();
            this.qHr.clear();
            if (z) {
                CharSequence charSequence;
                this.qHq = g.cjL().a(this.qHo.subSequence(0, this.qHt), mMEditText.getTextSize());
                SpannableStringBuilder append = this.qHp.append(this.qHq);
                SpannableStringBuilder spannableStringBuilder = this.qHr;
                if (spannableStringBuilder == null || str == null || str.length() == 0) {
                    charSequence = spannableStringBuilder;
                } else {
                    int length2;
                    int i;
                    if (str.length() < this.qHv) {
                        length2 = str.length();
                        i = 0;
                    } else {
                        length2 = str.length();
                        i = length2 - this.qHv;
                    }
                    spannableStringBuilder.append(str).setSpan(this.qHs, i, length2, 33);
                    Object charSequence2 = spannableStringBuilder;
                }
                append.append(charSequence2).append(this.qHo.subSequence(this.qHu, this.qHo.length()));
            } else {
                this.qHq = g.cjL().a(str, mMEditText.getTextSize());
                this.qHp.append(this.qHq);
            }
            x.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", new Object[]{Integer.valueOf(this.qHt), Integer.valueOf(this.qHu), Integer.valueOf(length), Integer.valueOf(this.qHp.length()), str, this.qHp});
            mMEditText.setText(this.qHp);
            if (length > this.qHp.length()) {
                return;
            }
            if (length == 0) {
                mMEditText.setSelection(this.qHp.length());
            } else {
                mMEditText.setSelection(length);
            }
        }
    }

    public final void a(MMEditText mMEditText) {
        if (mMEditText != null) {
            this.qHv = 0;
            this.qHq = g.cjL().a(mMEditText.getText().toString(), mMEditText.getTextSize());
            x.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", new Object[]{this.qHq});
            mMEditText.setText(this.qHq);
            mMEditText.setSelection(this.qHq.length());
        }
    }

    public final void b(MMEditText mMEditText) {
        if (mMEditText != null) {
            this.qHt = mMEditText.getSelectionStart();
            this.qHu = mMEditText.getSelectionEnd();
            this.qHo = new StringBuilder(mMEditText.getText());
            x.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", new Object[]{Integer.valueOf(this.qHt), Integer.valueOf(this.qHu), this.qHo});
            if (mMEditText.getText().toString().equalsIgnoreCase("")) {
                this.qHp.clear();
            }
        }
    }
}
