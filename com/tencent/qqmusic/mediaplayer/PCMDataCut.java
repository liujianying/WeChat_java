package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.codec.ape.ApeDecoder;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegPlayer;
import com.tencent.qqmusic.mediaplayer.codec.flac.FLACDecoder;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;

class PCMDataCut {
    private static final String TAG = "PCMDataCut";
    private AudioCut mAudioCut = null;
    private BaseDecoder mDecoder = null;
    private String mFileName = null;

    public PCMDataCut(String str) {
        this.mFileName = str;
        prepareDecoder();
    }

    boolean cutPCMData(String str, int i, int i2, int i3, boolean z) {
        Throwable th;
        File file;
        WaveWriter waveWriter;
        boolean z2 = false;
        WaveWriter waveWriter2 = null;
        try {
            File file2;
            z2 = initDecoder();
            if (z2) {
                z2 = getAudioFormation();
            }
            if (z2) {
                z2 = calculateBufferSize();
            }
            if (this.mAudioCut.information == null || this.mAudioCut.information.getDuration() < 30000) {
                Logger.d(TAG, "cutPCMData 歌曲时长小于30S，不适用音频指纹");
                Logger.i("MatchManager.Finger", "[cutPCMData] too short");
                z2 = false;
            }
            int i4 = i * 1000;
            int i5 = i2 * 1000;
            if (z2) {
                int sampleRate = (int) ((((long) ((i5 - i4) / 1000)) * this.mAudioCut.information.getSampleRate()) * ((long) this.mAudioCut.information.getChannels()));
                short[] sArr = new short[this.mAudioCut.bufferSize];
                if (this.mDecoder instanceof ApeDecoder) {
                    ((ApeDecoder) this.mDecoder).nSeekToExactly(i4 / 1000);
                } else {
                    this.mDecoder.seekTo(i4);
                }
                int i6 = 0;
                int i7 = 0;
                file2 = new File(str);
                try {
                    WaveWriter waveWriter3 = new WaveWriter(file2, (int) this.mAudioCut.information.getSampleRate(), this.mAudioCut.information.getChannels(), this.mAudioCut.sampleBit);
                    try {
                        waveWriter3.createWaveFile();
                        int i8 = -1;
                        while (i6 <= sampleRate && this.mDecoder.getCurrentTime() < ((long) (i5 + 2000))) {
                            try {
                                int decodeData = this.mDecoder.decodeData(this.mAudioCut.bufferSize * 2, sArr);
                                if (decodeData > 0) {
                                    i7 = decodeData;
                                    if (this.mDecoder.getCurrentTime() <= ((long) ((i4 + i5) / 2)) || i8 != -1) {
                                        decodeData = sampleRate;
                                    } else {
                                        float currentTime = ((float) (this.mDecoder.getCurrentTime() - ((long) i4))) / 1000.0f;
                                        Logger.d(TAG, "speedtime=" + currentTime + ",size=" + i6);
                                        currentTime = (2.0f * ((float) i6)) / ((currentTime * ((float) this.mAudioCut.information.getSampleRate())) * ((float) this.mAudioCut.information.getChannels()));
                                        this.mAudioCut.sampleBit = Math.round(currentTime) * 8;
                                        Logger.d(TAG, "sampleBit=" + this.mAudioCut.sampleBit);
                                        if (this.mAudioCut.sampleBit < 8) {
                                            Logger.e(TAG, "sampleBit=" + this.mAudioCut.sampleBit);
                                            if (this.mDecoder != null) {
                                                this.mDecoder.release();
                                                this.mDecoder = null;
                                            }
                                            try {
                                                waveWriter3.closeWaveFile();
                                                if (!z2 && file2.exists()) {
                                                    file2.delete();
                                                }
                                            } catch (Throwable e) {
                                                Logger.e(TAG, e);
                                            }
                                            return false;
                                        }
                                        sampleRate = (int) ((((((long) ((i5 - i4) / 1000)) * this.mAudioCut.information.getSampleRate()) * ((long) this.mAudioCut.information.getChannels())) * ((long) this.mAudioCut.sampleBit)) / 16);
                                        waveWriter3.setSampleByte(this.mAudioCut.sampleBit);
                                        decodeData = sampleRate;
                                        i8 = sampleRate;
                                    }
                                    i6 += i7 / 2;
                                    sampleRate = i7 / 2;
                                    if (i8 != -1 && i6 >= i8) {
                                        waveWriter3.write(sArr, 0, sampleRate - (i6 - i8));
                                        break;
                                    }
                                    waveWriter3.write(sArr, 0, sampleRate);
                                    sampleRate = decodeData;
                                } else {
                                    if (this.mDecoder != null) {
                                        this.mDecoder.release();
                                        this.mDecoder = null;
                                    }
                                    try {
                                        waveWriter3.closeWaveFile();
                                        if (!z2 && file2.exists()) {
                                            file2.delete();
                                        }
                                    } catch (Throwable e2) {
                                        Logger.e(TAG, e2);
                                    }
                                    return false;
                                }
                            } catch (Throwable e3) {
                                Logger.e(TAG, e3);
                            }
                        }
                        if (z) {
                            z2 = waveWriter3.reSamplerTo8K();
                            waveWriter2 = waveWriter3;
                        } else {
                            z2 = waveWriter3.reSampler();
                            waveWriter2 = waveWriter3;
                        }
                    } catch (Throwable e32) {
                        th = e32;
                        file = file2;
                        waveWriter = waveWriter3;
                    } catch (Throwable e322) {
                        th = e322;
                        file = file2;
                        waveWriter = waveWriter3;
                    }
                } catch (Throwable e4) {
                    th = e4;
                    file = file2;
                    waveWriter = null;
                    try {
                        Logger.e(TAG, th);
                        if (this.mDecoder != null) {
                            this.mDecoder.release();
                            this.mDecoder = null;
                        }
                        if (waveWriter != null) {
                            try {
                                waveWriter.closeWaveFile();
                            } catch (Throwable e22) {
                                Logger.e(TAG, e22);
                                return false;
                            }
                        }
                        if (file == null || !file.exists()) {
                            return false;
                        }
                        file.delete();
                        return false;
                    } catch (Throwable e222) {
                        th = e222;
                        if (this.mDecoder != null) {
                            this.mDecoder.release();
                            this.mDecoder = null;
                        }
                        if (waveWriter != null) {
                            try {
                                waveWriter.closeWaveFile();
                            } catch (Throwable e2222) {
                                Logger.e(TAG, e2222);
                                throw th;
                            }
                        }
                        if (!(z2 || file == null || !file.exists())) {
                            file.delete();
                        }
                        throw th;
                    }
                } catch (Throwable e42) {
                    th = e42;
                    file = file2;
                    waveWriter = null;
                    if (this.mDecoder != null) {
                        this.mDecoder.release();
                        this.mDecoder = null;
                    }
                    if (waveWriter != null) {
                        try {
                            waveWriter.closeWaveFile();
                        } catch (Throwable e22222) {
                            Logger.e(TAG, e22222);
                            throw th;
                        }
                    }
                    file.delete();
                    throw th;
                }
            }
            file2 = null;
            if (this.mDecoder != null) {
                this.mDecoder.release();
                this.mDecoder = null;
            }
            if (waveWriter2 != null) {
                try {
                    waveWriter2.closeWaveFile();
                } catch (Throwable e222222) {
                    Logger.e(TAG, e222222);
                    return false;
                }
            }
            if (z2 || file2 == null || !file2.exists()) {
                return z2;
            }
            file2.delete();
            return z2;
        } catch (Throwable e2222222) {
            th = e2222222;
            file = null;
            waveWriter = null;
        } catch (Throwable e22222222) {
            th = e22222222;
            file = null;
            waveWriter = null;
            if (this.mDecoder != null) {
                this.mDecoder.release();
                this.mDecoder = null;
            }
            if (waveWriter != null) {
                try {
                    waveWriter.closeWaveFile();
                } catch (Throwable e222222222) {
                    Logger.e(TAG, e222222222);
                    throw th;
                }
            }
            file.delete();
            throw th;
        }
    }

    private boolean initDecoder() {
        if (this.mDecoder == null) {
            return false;
        }
        try {
            int init = this.mDecoder.init(this.mFileName, false);
            Logger.i(TAG, "nativeOpen return=" + init);
            if (init != 0) {
                init = this.mDecoder.init(this.mFileName, false);
            }
            if (init == 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            Logger.e(TAG, e);
            return false;
        }
    }

    private boolean getAudioFormation() {
        if (this.mDecoder != null) {
            try {
                this.mAudioCut.information = this.mDecoder.getAudioInformation();
            } catch (Throwable e) {
                Logger.e(TAG, e);
            }
        }
        if (this.mAudioCut.information != null) {
            return true;
        }
        return false;
    }

    private boolean calculateBufferSize() {
        if (this.mDecoder == null) {
            return false;
        }
        int i;
        int minBufferSize = AudioTrack.getMinBufferSize((int) this.mAudioCut.information.getSampleRate(), this.mAudioCut.information.getChannels() == 1 ? 4 : 12, 2);
        try {
            if (this.mDecoder instanceof FLACDecoder) {
                i = ((FLACDecoder) this.mDecoder).getminBufferSize();
                Logger.i(TAG, "decoder_buf_size = " + i + ", playback_buf_size = " + minBufferSize);
                if (AudioType.FLAC.equals(this.mAudioCut.audioType)) {
                    this.mAudioCut.bufferSize = minBufferSize;
                } else {
                    this.mAudioCut.bufferSize = i;
                }
                if (this.mDecoder instanceof FfmpegPlayer) {
                    this.mAudioCut.bufferSize = Math.max(4096, minBufferSize);
                }
                return true;
            }
        } catch (Throwable e) {
            Logger.e(TAG, e);
        }
        i = 0;
        Logger.i(TAG, "decoder_buf_size = " + i + ", playback_buf_size = " + minBufferSize);
        if (AudioType.FLAC.equals(this.mAudioCut.audioType)) {
            this.mAudioCut.bufferSize = minBufferSize;
        } else {
            this.mAudioCut.bufferSize = i;
        }
        if (this.mDecoder instanceof FfmpegPlayer) {
            this.mAudioCut.bufferSize = Math.max(4096, minBufferSize);
        }
        return true;
    }

    private void prepareDecoder() {
        if (this.mFileName == null) {
            throw new NullPointerException("the path is null!");
        }
        this.mAudioCut = new AudioCut(null);
        try {
            this.mAudioCut.audioType = AudioRecognition.recognitionAudioFormatExactly(this.mFileName);
        } catch (Throwable e) {
            Logger.e(TAG, e);
        }
        this.mDecoder = MediaCodecFactory.createDecoderByType(this.mAudioCut.audioType);
    }
}
