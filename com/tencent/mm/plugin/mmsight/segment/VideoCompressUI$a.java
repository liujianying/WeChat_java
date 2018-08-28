package com.tencent.mm.plugin.mmsight.segment;

class VideoCompressUI$a {
    public int audioBitRate;
    public String egB;
    public String egC;
    public int egD;
    public int egE;
    final /* synthetic */ VideoCompressUI lmY;
    public int videoBitRate;
    public int videoFrameRate;
    public int videoHeight;
    public int videoWidth;

    private VideoCompressUI$a(VideoCompressUI videoCompressUI) {
        this.lmY = videoCompressUI;
        this.egD = -1;
        this.videoHeight = -1;
        this.videoWidth = -1;
        this.videoBitRate = -1;
        this.egE = -1;
        this.videoFrameRate = -1;
        this.audioBitRate = -1;
    }

    /* synthetic */ VideoCompressUI$a(VideoCompressUI videoCompressUI, byte b) {
        this(videoCompressUI);
    }
}
