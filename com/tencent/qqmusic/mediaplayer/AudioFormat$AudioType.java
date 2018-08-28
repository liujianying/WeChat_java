package com.tencent.qqmusic.mediaplayer;

public enum AudioFormat$AudioType {
    UNSUPPORT(1, "Unknown"),
    MP3(9, "mp3"),
    OGG(4, "ogg"),
    M4A(3, "m4a"),
    FLAC(2, "flac"),
    APE(5, "ape"),
    WAV(8, "wav"),
    WMA(7, "wma"),
    AMR(6, "amr"),
    MP4(10, "mp4"),
    AAC(11, "aac");
    
    private String extension;
    private int value;

    private AudioFormat$AudioType(int i, String str) {
        this.value = 0;
        this.value = i;
        this.extension = str;
    }

    public final int getValue() {
        return this.value;
    }
}
