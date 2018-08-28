package com.tenpay.bankcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.b;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpayUtil;
import com.tenpay.ndk.Encrypt;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class TenpaySegmentEditText extends LinearLayout {
    private static String mTimeStamp;
    private final int BG_LINE_COLOR;
    private final int BG_LINE_HEIGHT;
    private final int BG_LINE_SIZE;
    private final String TAG;
    private Context mContext;
    private List<EditText> mEditArray;
    EditState mEditState;
    private MyKeyboardWindow mKeyboard;
    private boolean mNoFocus;
    private OnClickListener mOnClickListener;
    private Paint mPaintBg;
    private Paint mPaintSplit;

    public TenpaySegmentEditText(Context context) {
        this(context, null);
        this.mContext = context;
        init();
    }

    public TenpaySegmentEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "MyTag";
        this.BG_LINE_COLOR = -11615450;
        this.BG_LINE_SIZE = 4;
        this.BG_LINE_HEIGHT = 9;
        this.mOnClickListener = null;
        this.mNoFocus = true;
        this.mEditState = EditState.DEFAULT;
        this.mContext = null;
        this.mEditArray = new ArrayList();
        this.mKeyboard = null;
        this.mContext = context;
        init();
    }

    private void init() {
        setBackgroundColor(-1);
        setOrientation(0);
        setIsBankcardFormat(true);
        this.mPaintSplit = new Paint();
        this.mPaintSplit.setStrokeWidth(0.0f);
        this.mPaintSplit.setColor(-7829368);
        this.mPaintBg = new Paint();
        this.mPaintBg.setColor(-11615450);
        this.mPaintBg.setStyle(Style.FILL);
    }

    public final void setIsBankcardFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.BANKCARD;
        } else if (EditState.BANKCARD == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setText(String str) {
        setText(str, null);
    }

    public final void setText(String str, String str2) {
        Encrypt encrypt = new Encrypt();
        if (bi.oW(str2)) {
            str2 = encrypt.getRandomKey();
        }
        String[] split = encrypt.desedeDecode(str, str2).split("-");
        removeAllViews();
        this.mNoFocus = true;
        this.mEditArray.clear();
        for (int i = 0; i < split.length; i++) {
            View editText = new EditText(this.mContext);
            editText.setText(split[i]);
            editText.setMaxLines(1);
            editText.setFilters(new InputFilter[]{new LengthFilter(split[i].length())});
            editText.setGravity(17);
            editText.setInputType(2);
            editText.setBackgroundColor(0);
            editText.setSelectAllOnFocus(true);
            editText.setOnClickListener(new 1(this, editText));
            setNoSystemInputOnEditText(editText);
            ((InputMethodManager) this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 2);
            editText.setOnFocusChangeListener(new 2(this, editText));
            addView(editText, new LayoutParams(-2, -1, (float) split[i].length()));
            this.mEditArray.add(editText);
        }
        setFocusable(false);
    }

    public final void setKeyboard(MyKeyboardWindow myKeyboardWindow) {
        this.mKeyboard = myKeyboardWindow;
    }

    public final void setFocusable(boolean z) {
        int i = 0;
        LogUtil.d("MyTag", new Object[]{"setFocusable " + z});
        while (true) {
            int i2 = i;
            if (i2 < this.mEditArray.size()) {
                EditText editText = (EditText) this.mEditArray.get(i2);
                editText.setFocusable(z);
                editText.setFocusableInTouchMode(z);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackgroundLine(canvas);
    }

    private void drawBackgroundLine(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float f = (float) (height - 4);
        canvas.drawRect(0.0f, f, (float) width, (float) height, this.mPaintBg);
        float f2 = f - 9.0f;
        int size = this.mEditArray.size();
        canvas.drawRect(0.0f, f2, 4.0f, f, this.mPaintBg);
        int i = 0;
        float f3 = 0.0f;
        while (i < size) {
            width = -2;
            if (i == size - 1) {
                width = -4;
            }
            int i2 = width;
            float width2 = f3 + ((float) (((EditText) this.mEditArray.get(i)).getWidth() + i2));
            canvas.drawRect(width2, f2, width2 + 4.0f, f, this.mPaintBg);
            i++;
            f3 = width2 - ((float) i2);
        }
    }

    public static void setSalt(String str) {
        mTimeStamp = str;
    }

    private String getInputText() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mEditArray.size()) {
                break;
            }
            stringBuffer.append(((EditText) this.mEditArray.get(i2)).getText().toString());
            i = i2 + 1;
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.length() == 0) {
            return null;
        }
        stringBuffer2.trim().replaceAll(" ", "");
        return stringBuffer2;
    }

    public final String getEncryptDataWithHash(boolean z) {
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            return null;
        }
        if (z) {
            inputText = TenpayUtil.md5HexDigest(inputText);
        }
        Encrypt encrypt = new Encrypt();
        if (mTimeStamp != null) {
            encrypt.setTimeStamp(mTimeStamp);
        }
        b.cCO();
        if (b.cCP()) {
            return encrypt.encryptPasswdWithRSA2048(inputText);
        }
        return encrypt.encryptPasswd(inputText);
    }

    public final String get3DesEncrptData() {
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            return null;
        }
        Encrypt encrypt = new Encrypt();
        return encrypt.desedeEncode(inputText, encrypt.getRandomKey());
    }

    public final boolean isMatchPattern(String str) {
        boolean z = false;
        if (str == null) {
            return z;
        }
        try {
            return Pattern.compile(str).matcher(getInputText()).matches();
        } catch (Exception e) {
            return z;
        }
    }

    private boolean isMatchPattern(String str, String str2) {
        boolean z = false;
        if (str2 == null) {
            return z;
        }
        try {
            return Pattern.compile(str2).matcher(str).matches();
        } catch (Exception e) {
            return z;
        }
    }

    public final void ClearInput() {
    }

    public final int getInputLength() {
        String inputText = getInputText();
        if (inputText == null) {
            return 0;
        }
        return inputText.length();
    }

    public static void setNoSystemInputOnEditText(EditText editText) {
        if (VERSION.SDK_INT < 11) {
            editText.setInputType(0);
            return;
        }
        Class cls = EditText.class;
        try {
            Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
            method.setAccessible(true);
            method.invoke(editText, new Object[]{Boolean.valueOf(false)});
        } catch (NoSuchMethodException e) {
            try {
                Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                method2.setAccessible(true);
                method2.invoke(editText, new Object[]{Boolean.valueOf(false)});
            } catch (Exception e2) {
                editText.setInputType(0);
            }
        } catch (Exception e3) {
        }
    }
}
