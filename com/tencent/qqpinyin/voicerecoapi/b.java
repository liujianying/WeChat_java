package com.tencent.qqpinyin.voicerecoapi;

public final class b extends Exception {
    private String fHW = "";
    private int mErrorCode;

    public b(int i) {
        String str;
        this.mErrorCode = i;
        switch (i) {
            case -104:
                str = "null param or 0 length";
                break;
            case -103:
                str = "already init";
                break;
            case -102:
                str = "should init at first";
                break;
            case -101:
                str = "speex engine error";
                break;
            case -100:
                str = "out of memory";
                break;
            default:
                str = "unknown error";
                break;
        }
        this.fHW = str;
        new StringBuilder("errorCode: ").append(this.mErrorCode).append("\t msg: ").append(this.fHW);
    }
}
