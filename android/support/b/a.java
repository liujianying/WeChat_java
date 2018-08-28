package android.support.b;

import android.content.res.AssetManager.AssetInputStream;
import android.util.Pair;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.plugin.appbrand.jsapi.bp;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    private static final String TAG_HAS_THUMBNAIL = "HasThumbnail";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final d TAG_RAF_IMAGE_SIZE = new d(TAG_STRIP_OFFSETS, 273, 3, (byte) 0);
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    private static final String TAG_THUMBNAIL_DATA = "ThumbnailData";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    private static final String TAG_THUMBNAIL_LENGTH = "ThumbnailLength";
    private static final String TAG_THUMBNAIL_OFFSET = "ThumbnailOffset";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    private static final byte[] kS = new byte[]{(byte) -1, (byte) -40, (byte) -1};
    private static final byte[] kT = new byte[]{(byte) 79, (byte) 76, (byte) 89, (byte) 77, (byte) 80, (byte) 0};
    private static final byte[] kU = new byte[]{(byte) 79, (byte) 76, (byte) 89, (byte) 77, (byte) 80, (byte) 85, (byte) 83, (byte) 0, (byte) 73, (byte) 73};
    private static SimpleDateFormat kV;
    private static final String[] kW = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    private static final int[] kX = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    private static final byte[] kY = new byte[]{(byte) 65, (byte) 83, (byte) 67, (byte) 73, (byte) 73, (byte) 0, (byte) 0, (byte) 0};
    private static final int[] kZ = new int[]{8, 8, 8};
    private static final Pattern lL = Pattern.compile(".*[1-9].*");
    private static final Pattern lM = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    private static final int[] la = new int[]{4};
    private static final int[] lb = new int[]{8};
    private static final d[] lc = new d[]{new d(TAG_NEW_SUBFILE_TYPE, 254, 4, (byte) 0), new d(TAG_SUBFILE_TYPE, 255, 4, (byte) 0), new d(TAG_IMAGE_WIDTH, GLIcon.TOP, (byte) 0), new d(TAG_IMAGE_LENGTH, 257, (byte) 0), new d(TAG_BITS_PER_SAMPLE, 258, 3, (byte) 0), new d(TAG_COMPRESSION, 259, 3, (byte) 0), new d(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3, (byte) 0), new d(TAG_IMAGE_DESCRIPTION, 270, 2, (byte) 0), new d(TAG_MAKE, 271, 2, (byte) 0), new d(TAG_MODEL, 272, 2, (byte) 0), new d(TAG_STRIP_OFFSETS, 273, (byte) 0), new d(TAG_ORIENTATION, 274, 3, (byte) 0), new d(TAG_SAMPLES_PER_PIXEL, 277, 3, (byte) 0), new d(TAG_ROWS_PER_STRIP, 278, (byte) 0), new d(TAG_STRIP_BYTE_COUNTS, 279, (byte) 0), new d(TAG_X_RESOLUTION, 282, 5, (byte) 0), new d(TAG_Y_RESOLUTION, 283, 5, (byte) 0), new d(TAG_PLANAR_CONFIGURATION, bp.CTRL_INDEX, 3, (byte) 0), new d(TAG_RESOLUTION_UNIT, 296, 3, (byte) 0), new d(TAG_TRANSFER_FUNCTION, 301, 3, (byte) 0), new d(TAG_SOFTWARE, 305, 2, (byte) 0), new d(TAG_DATETIME, 306, 2, (byte) 0), new d(TAG_ARTIST, 315, 2, (byte) 0), new d(TAG_WHITE_POINT, 318, 5, (byte) 0), new d(TAG_PRIMARY_CHROMATICITIES, 319, 5, (byte) 0), new d(TAG_SUB_IFD_POINTER, 330, 4, (byte) 0), new d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4, (byte) 0), new d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4, (byte) 0), new d(TAG_Y_CB_CR_COEFFICIENTS, 529, 5, (byte) 0), new d(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3, (byte) 0), new d(TAG_Y_CB_CR_POSITIONING, 531, 3, (byte) 0), new d(TAG_REFERENCE_BLACK_WHITE, 532, 5, (byte) 0), new d(TAG_COPYRIGHT, 33432, 2, (byte) 0), new d(TAG_EXIF_IFD_POINTER, 34665, 4, (byte) 0), new d(TAG_GPS_INFO_IFD_POINTER, 34853, 4, (byte) 0), new d(TAG_RW2_SENSOR_TOP_BORDER, 4, 4, (byte) 0), new d(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4, (byte) 0), new d(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4, (byte) 0), new d(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4, (byte) 0), new d(TAG_RW2_ISO, 23, 3, (byte) 0), new d(TAG_RW2_JPG_FROM_RAW, 46, 7, (byte) 0)};
    private static final d[] ld = new d[]{new d(TAG_EXPOSURE_TIME, 33434, 5, (byte) 0), new d(TAG_F_NUMBER, 33437, 5, (byte) 0), new d(TAG_EXPOSURE_PROGRAM, 34850, 3, (byte) 0), new d(TAG_SPECTRAL_SENSITIVITY, 34852, 2, (byte) 0), new d(TAG_ISO_SPEED_RATINGS, 34855, 3, (byte) 0), new d(TAG_OECF, 34856, 7, (byte) 0), new d(TAG_EXIF_VERSION, 36864, 2, (byte) 0), new d(TAG_DATETIME_ORIGINAL, 36867, 2, (byte) 0), new d(TAG_DATETIME_DIGITIZED, 36868, 2, (byte) 0), new d(TAG_COMPONENTS_CONFIGURATION, 37121, 7, (byte) 0), new d(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5, (byte) 0), new d(TAG_SHUTTER_SPEED_VALUE, 37377, 10, (byte) 0), new d(TAG_APERTURE_VALUE, 37378, 5, (byte) 0), new d(TAG_BRIGHTNESS_VALUE, 37379, 10, (byte) 0), new d(TAG_EXPOSURE_BIAS_VALUE, 37380, 10, (byte) 0), new d(TAG_MAX_APERTURE_VALUE, 37381, 5, (byte) 0), new d(TAG_SUBJECT_DISTANCE, 37382, 5, (byte) 0), new d(TAG_METERING_MODE, 37383, 3, (byte) 0), new d(TAG_LIGHT_SOURCE, 37384, 3, (byte) 0), new d(TAG_FLASH, 37385, 3, (byte) 0), new d(TAG_FOCAL_LENGTH, 37386, 5, (byte) 0), new d(TAG_SUBJECT_AREA, 37396, 3, (byte) 0), new d(TAG_MAKER_NOTE, 37500, 7, (byte) 0), new d(TAG_USER_COMMENT, 37510, 7, (byte) 0), new d(TAG_SUBSEC_TIME, 37520, 2, (byte) 0), new d(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2, (byte) 0), new d(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2, (byte) 0), new d(TAG_FLASHPIX_VERSION, 40960, 7, (byte) 0), new d(TAG_COLOR_SPACE, 40961, 3, (byte) 0), new d(TAG_PIXEL_X_DIMENSION, 40962, (byte) 0), new d(TAG_PIXEL_Y_DIMENSION, 40963, (byte) 0), new d(TAG_RELATED_SOUND_FILE, 40964, 2, (byte) 0), new d(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4, (byte) 0), new d(TAG_FLASH_ENERGY, 41483, 5, (byte) 0), new d(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7, (byte) 0), new d(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5, (byte) 0), new d(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5, (byte) 0), new d(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3, (byte) 0), new d(TAG_SUBJECT_LOCATION, 41492, 3, (byte) 0), new d(TAG_EXPOSURE_INDEX, 41493, 5, (byte) 0), new d(TAG_SENSING_METHOD, 41495, 3, (byte) 0), new d(TAG_FILE_SOURCE, 41728, 7, (byte) 0), new d(TAG_SCENE_TYPE, 41729, 7, (byte) 0), new d(TAG_CFA_PATTERN, 41730, 7, (byte) 0), new d(TAG_CUSTOM_RENDERED, 41985, 3, (byte) 0), new d(TAG_EXPOSURE_MODE, 41986, 3, (byte) 0), new d(TAG_WHITE_BALANCE, 41987, 3, (byte) 0), new d(TAG_DIGITAL_ZOOM_RATIO, 41988, 5, (byte) 0), new d(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3, (byte) 0), new d(TAG_SCENE_CAPTURE_TYPE, 41990, 3, (byte) 0), new d(TAG_GAIN_CONTROL, 41991, 3, (byte) 0), new d(TAG_CONTRAST, 41992, 3, (byte) 0), new d(TAG_SATURATION, 41993, 3, (byte) 0), new d(TAG_SHARPNESS, 41994, 3, (byte) 0), new d(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7, (byte) 0), new d(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3, (byte) 0), new d(TAG_IMAGE_UNIQUE_ID, 42016, 2, (byte) 0), new d(TAG_DNG_VERSION, 50706, 1, (byte) 0), new d(TAG_DEFAULT_CROP_SIZE, 50720, (byte) 0)};
    private static final d[] le = new d[]{new d(TAG_GPS_VERSION_ID, 0, 1, (byte) 0), new d(TAG_GPS_LATITUDE_REF, 1, 2, (byte) 0), new d(TAG_GPS_LATITUDE, 2, 5, (byte) 0), new d(TAG_GPS_LONGITUDE_REF, 3, 2, (byte) 0), new d(TAG_GPS_LONGITUDE, 4, 5, (byte) 0), new d(TAG_GPS_ALTITUDE_REF, 5, 1, (byte) 0), new d(TAG_GPS_ALTITUDE, 6, 5, (byte) 0), new d(TAG_GPS_TIMESTAMP, 7, 5, (byte) 0), new d(TAG_GPS_SATELLITES, 8, 2, (byte) 0), new d(TAG_GPS_STATUS, 9, 2, (byte) 0), new d(TAG_GPS_MEASURE_MODE, 10, 2, (byte) 0), new d(TAG_GPS_DOP, 11, 5, (byte) 0), new d(TAG_GPS_SPEED_REF, 12, 2, (byte) 0), new d(TAG_GPS_SPEED, 13, 5, (byte) 0), new d(TAG_GPS_TRACK_REF, 14, 2, (byte) 0), new d(TAG_GPS_TRACK, 15, 5, (byte) 0), new d(TAG_GPS_IMG_DIRECTION_REF, 16, 2, (byte) 0), new d(TAG_GPS_IMG_DIRECTION, 17, 5, (byte) 0), new d(TAG_GPS_MAP_DATUM, 18, 2, (byte) 0), new d(TAG_GPS_DEST_LATITUDE_REF, 19, 2, (byte) 0), new d(TAG_GPS_DEST_LATITUDE, 20, 5, (byte) 0), new d(TAG_GPS_DEST_LONGITUDE_REF, 21, 2, (byte) 0), new d(TAG_GPS_DEST_LONGITUDE, 22, 5, (byte) 0), new d(TAG_GPS_DEST_BEARING_REF, 23, 2, (byte) 0), new d(TAG_GPS_DEST_BEARING, 24, 5, (byte) 0), new d(TAG_GPS_DEST_DISTANCE_REF, 25, 2, (byte) 0), new d(TAG_GPS_DEST_DISTANCE, 26, 5, (byte) 0), new d(TAG_GPS_PROCESSING_METHOD, 27, 7, (byte) 0), new d(TAG_GPS_AREA_INFORMATION, 28, 7, (byte) 0), new d(TAG_GPS_DATESTAMP, 29, 2, (byte) 0), new d(TAG_GPS_DIFFERENTIAL, 30, 3, (byte) 0)};
    private static final d[] lf = new d[]{new d(TAG_INTEROPERABILITY_INDEX, 1, 2, (byte) 0)};
    private static final d[] lg = new d[]{new d(TAG_NEW_SUBFILE_TYPE, 254, 4, (byte) 0), new d(TAG_SUBFILE_TYPE, 255, 4, (byte) 0), new d(TAG_THUMBNAIL_IMAGE_WIDTH, GLIcon.TOP, (byte) 0), new d(TAG_THUMBNAIL_IMAGE_LENGTH, 257, (byte) 0), new d(TAG_BITS_PER_SAMPLE, 258, 3, (byte) 0), new d(TAG_COMPRESSION, 259, 3, (byte) 0), new d(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3, (byte) 0), new d(TAG_IMAGE_DESCRIPTION, 270, 2, (byte) 0), new d(TAG_MAKE, 271, 2, (byte) 0), new d(TAG_MODEL, 272, 2, (byte) 0), new d(TAG_STRIP_OFFSETS, 273, (byte) 0), new d(TAG_ORIENTATION, 274, 3, (byte) 0), new d(TAG_SAMPLES_PER_PIXEL, 277, 3, (byte) 0), new d(TAG_ROWS_PER_STRIP, 278, (byte) 0), new d(TAG_STRIP_BYTE_COUNTS, 279, (byte) 0), new d(TAG_X_RESOLUTION, 282, 5, (byte) 0), new d(TAG_Y_RESOLUTION, 283, 5, (byte) 0), new d(TAG_PLANAR_CONFIGURATION, bp.CTRL_INDEX, 3, (byte) 0), new d(TAG_RESOLUTION_UNIT, 296, 3, (byte) 0), new d(TAG_TRANSFER_FUNCTION, 301, 3, (byte) 0), new d(TAG_SOFTWARE, 305, 2, (byte) 0), new d(TAG_DATETIME, 306, 2, (byte) 0), new d(TAG_ARTIST, 315, 2, (byte) 0), new d(TAG_WHITE_POINT, 318, 5, (byte) 0), new d(TAG_PRIMARY_CHROMATICITIES, 319, 5, (byte) 0), new d(TAG_SUB_IFD_POINTER, 330, 4, (byte) 0), new d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4, (byte) 0), new d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4, (byte) 0), new d(TAG_Y_CB_CR_COEFFICIENTS, 529, 5, (byte) 0), new d(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3, (byte) 0), new d(TAG_Y_CB_CR_POSITIONING, 531, 3, (byte) 0), new d(TAG_REFERENCE_BLACK_WHITE, 532, 5, (byte) 0), new d(TAG_COPYRIGHT, 33432, 2, (byte) 0), new d(TAG_EXIF_IFD_POINTER, 34665, 4, (byte) 0), new d(TAG_GPS_INFO_IFD_POINTER, 34853, 4, (byte) 0), new d(TAG_DNG_VERSION, 50706, 1, (byte) 0), new d(TAG_DEFAULT_CROP_SIZE, 50720, (byte) 0)};
    private static final d[] lh = new d[]{new d(TAG_ORF_THUMBNAIL_IMAGE, GLIcon.TOP, 7, (byte) 0), new d(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4, (byte) 0), new d(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4, (byte) 0)};
    private static final d[] li = new d[]{new d(TAG_ORF_PREVIEW_IMAGE_START, 257, 4, (byte) 0), new d(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4, (byte) 0)};
    private static final d[] lj = new d[]{new d(TAG_ORF_ASPECT_FRAME, 4371, 3, (byte) 0)};
    private static final d[] lk = new d[]{new d(TAG_COLOR_SPACE, 55, 3, (byte) 0)};
    private static final d[][] ll = new d[][]{lc, ld, le, lf, lg, lc, lh, li, lj, lk};
    private static final d[] lm = new d[]{new d(TAG_SUB_IFD_POINTER, 330, 4, (byte) 0), new d(TAG_EXIF_IFD_POINTER, 34665, 4, (byte) 0), new d(TAG_GPS_INFO_IFD_POINTER, 34853, 4, (byte) 0), new d(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4, (byte) 0), new d(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1, (byte) 0), new d(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1, (byte) 0)};
    private static final d ln = new d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4, (byte) 0);
    private static final d lo = new d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4, (byte) 0);
    private static final HashMap[] lp = new HashMap[ll.length];
    private static final HashMap[] lq = new HashMap[ll.length];
    private static final HashSet<String> lr = new HashSet(Arrays.asList(new String[]{TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP}));
    private static final HashMap ls = new HashMap();
    private static final Charset lt = Charset.forName("US-ASCII");
    private static final byte[] lu = "Exif\u0000\u0000".getBytes(lt);
    private boolean lA;
    private int lB;
    private int lC;
    private byte[] lD;
    private int lE;
    private int lF;
    private int lG;
    private int lH;
    private int lI;
    private int lJ;
    private boolean lK;
    private final String lv;
    private final AssetInputStream lw;
    private int lx;
    private final HashMap[] ly = new HashMap[ll.length];
    private ByteOrder lz = ByteOrder.BIG_ENDIAN;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        kV = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i = 0; i < ll.length; i++) {
            lp[i] = new HashMap();
            lq[i] = new HashMap();
            for (d dVar : ll[i]) {
                lp[i].put(Integer.valueOf(dVar.number), dVar);
                lq[i].put(dVar.name, dVar);
            }
        }
        ls.put(Integer.valueOf(lm[0].number), Integer.valueOf(5));
        ls.put(Integer.valueOf(lm[1].number), Integer.valueOf(1));
        ls.put(Integer.valueOf(lm[2].number), Integer.valueOf(2));
        ls.put(Integer.valueOf(lm[3].number), Integer.valueOf(3));
        ls.put(Integer.valueOf(lm[4].number), Integer.valueOf(7));
        ls.put(Integer.valueOf(lm[5].number), Integer.valueOf(8));
    }

    public a(String str) {
        Throwable th;
        if (str == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        this.lw = null;
        this.lv = str;
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                b((InputStream) fileInputStream);
                b(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                b(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            b(fileInputStream);
            throw th;
        }
    }

    private c B(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= ll.length) {
                return null;
            }
            Object obj = this.ly[i2].get(str);
            if (obj != null) {
                return (c) obj;
            }
            i = i2 + 1;
        }
    }

    public final String getAttribute(String str) {
        c B = B(str);
        if (B == null) {
            return null;
        }
        if (!lr.contains(str)) {
            return B.c(this.lz);
        }
        e[] eVarArr;
        if (!str.equals(TAG_GPS_TIMESTAMP)) {
            try {
                Object a = B.a(this.lz);
                if (a == null) {
                    throw new NumberFormatException("NULL can't be converted to a double value");
                }
                double parseDouble;
                if (a instanceof String) {
                    parseDouble = Double.parseDouble((String) a);
                } else if (a instanceof long[]) {
                    long[] jArr = (long[]) a;
                    if (jArr.length == 1) {
                        parseDouble = (double) jArr[0];
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else if (a instanceof int[]) {
                    int[] iArr = (int[]) a;
                    if (iArr.length == 1) {
                        parseDouble = (double) iArr[0];
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else if (a instanceof double[]) {
                    double[] dArr = (double[]) a;
                    if (dArr.length == 1) {
                        parseDouble = dArr[0];
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else if (a instanceof e[]) {
                    eVarArr = (e[]) a;
                    if (eVarArr.length == 1) {
                        e eVar = eVarArr[0];
                        parseDouble = ((double) eVar.lU) / ((double) eVar.lV);
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
                return Double.toString(parseDouble);
            } catch (NumberFormatException e) {
                return null;
            }
        } else if (B.format == 5 || B.format == 10) {
            eVarArr = (e[]) B.a(this.lz);
            if (eVarArr == null || eVarArr.length != 3) {
                new StringBuilder("Invalid GPS Timestamp array. array=").append(Arrays.toString(eVarArr));
                return null;
            }
            return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) eVarArr[0].lU) / ((float) eVarArr[0].lV))), Integer.valueOf((int) (((float) eVarArr[1].lU) / ((float) eVarArr[1].lV))), Integer.valueOf((int) (((float) eVarArr[2].lU) / ((float) eVarArr[2].lV)))});
        } else {
            new StringBuilder("GPS Timestamp format is not rational. format=").append(B.format);
            return null;
        }
    }

    public final int C(String str) {
        int i = 1;
        c B = B(str);
        if (B == null) {
            return i;
        }
        try {
            return B.b(this.lz);
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public final void setAttribute(String str, String str2) {
        if (str2 != null && lr.contains(str)) {
            if (str.equals(TAG_GPS_TIMESTAMP)) {
                Matcher matcher = lM.matcher(str2);
                if (matcher.find()) {
                    str2 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
                } else {
                    new StringBuilder("Invalid value for ").append(str).append(" : ").append(str2);
                    return;
                }
            }
            try {
                str2 = ((long) (Double.parseDouble(str2) * 10000.0d)) + "/10000";
            } catch (NumberFormatException e) {
                new StringBuilder("Invalid value for ").append(str).append(" : ").append(str2);
                return;
            }
        }
        for (int i = 0; i < ll.length; i++) {
            if (i != 4 || this.lA) {
                Object obj = lq[i].get(str);
                if (obj != null) {
                    if (str2 != null) {
                        int i2;
                        d dVar = (d) obj;
                        Pair D = D(str2);
                        if (dVar.lS == ((Integer) D.first).intValue() || dVar.lS == ((Integer) D.second).intValue()) {
                            i2 = dVar.lS;
                        } else if (dVar.lT != -1 && (dVar.lT == ((Integer) D.first).intValue() || dVar.lT == ((Integer) D.second).intValue())) {
                            i2 = dVar.lT;
                        } else if (dVar.lS == 1 || dVar.lS == 7 || dVar.lS == 2) {
                            i2 = dVar.lS;
                        } else {
                            String str3;
                            StringBuilder append = new StringBuilder("Given tag (").append(str).append(") value didn't match with one of expected formats: ").append(kW[dVar.lS]).append(dVar.lT == -1 ? "" : ", " + kW[dVar.lT]).append(" (guess: ").append(kW[((Integer) D.first).intValue()]);
                            if (((Integer) D.second).intValue() == -1) {
                                str3 = "";
                            } else {
                                str3 = ", " + kW[((Integer) D.second).intValue()];
                            }
                            append.append(str3).append(")");
                        }
                        String[] split;
                        int[] iArr;
                        String[] split2;
                        e[] eVarArr;
                        String[] split3;
                        switch (i2) {
                            case 1:
                                HashMap hashMap = this.ly[i];
                                if (str2.length() != 1 || str2.charAt(0) < '0' || str2.charAt(0) > '1') {
                                    byte[] bytes = str2.getBytes(lt);
                                    obj = new c(1, bytes.length, bytes);
                                } else {
                                    obj = new c(1, 1, new byte[]{(byte) (str2.charAt(0) - 48)});
                                }
                                hashMap.put(str, obj);
                                break;
                            case 2:
                            case 7:
                                this.ly[i].put(str, c.E(str2));
                                break;
                            case 3:
                                split = str2.split(",");
                                iArr = new int[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    iArr[i2] = Integer.parseInt(split[i2]);
                                }
                                this.ly[i].put(str, c.a(iArr, this.lz));
                                break;
                            case 4:
                                split = str2.split(",");
                                long[] jArr = new long[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    jArr[i2] = Long.parseLong(split[i2]);
                                }
                                this.ly[i].put(str, c.a(jArr, this.lz));
                                break;
                            case 5:
                                split2 = str2.split(",");
                                eVarArr = new e[split2.length];
                                for (i2 = 0; i2 < split2.length; i2++) {
                                    split3 = split2[i2].split("/");
                                    eVarArr[i2] = new e((long) Double.parseDouble(split3[0]), (long) Double.parseDouble(split3[1]), (byte) 0);
                                }
                                this.ly[i].put(str, c.a(eVarArr, this.lz));
                                break;
                            case 9:
                                split = str2.split(",");
                                iArr = new int[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    iArr[i2] = Integer.parseInt(split[i2]);
                                }
                                this.ly[i].put(str, c.b(iArr, this.lz));
                                break;
                            case 10:
                                split2 = str2.split(",");
                                eVarArr = new e[split2.length];
                                for (i2 = 0; i2 < split2.length; i2++) {
                                    split3 = split2[i2].split("/");
                                    eVarArr[i2] = new e((long) Double.parseDouble(split3[0]), (long) Double.parseDouble(split3[1]), (byte) 0);
                                }
                                this.ly[i].put(str, c.b(eVarArr, this.lz));
                                break;
                            case 12:
                                split = str2.split(",");
                                double[] dArr = new double[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    dArr[i2] = Double.parseDouble(split[i2]);
                                }
                                this.ly[i].put(str, c.a(dArr, this.lz));
                                break;
                            default:
                                break;
                        }
                    }
                    this.ly[i].remove(str);
                }
            }
        }
    }

    private void removeAttribute(String str) {
        for (int i = 0; i < ll.length; i++) {
            this.ly[i].remove(str);
        }
    }

    private void b(InputStream inputStream) {
        int i = 0;
        while (i < ll.length) {
            try {
                this.ly[i] = new HashMap();
                i++;
            } catch (IOException e) {
                this.lK = false;
            } finally {
                aV();
            }
        }
        InputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        BufferedInputStream bufferedInputStream2 = (BufferedInputStream) bufferedInputStream;
        bufferedInputStream2.mark(5000);
        byte[] bArr = new byte[5000];
        if (bufferedInputStream2.read(bArr) != 5000) {
            throw new EOFException();
        }
        Object obj;
        c cVar;
        c cVar2;
        int[] iArr;
        int i2;
        bufferedInputStream2.reset();
        if (e(bArr)) {
            i = 4;
        } else if (f(bArr)) {
            i = 9;
        } else {
            a aVar = new a(bArr);
            this.lz = c(aVar);
            aVar.lO = this.lz;
            short readShort = aVar.readShort();
            aVar.close();
            obj = (readShort == (short) 20306 || readShort == (short) 21330) ? 1 : null;
            if (obj != null) {
                i = 7;
            } else {
                aVar = new a(bArr);
                this.lz = c(aVar);
                aVar.lO = this.lz;
                short readShort2 = aVar.readShort();
                aVar.close();
                i = (readShort2 == (short) 85 ? 1 : null) != null ? 10 : 0;
            }
        }
        this.lx = i;
        a aVar2 = new a(bufferedInputStream);
        switch (this.lx) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                a(aVar2);
                break;
            case 4:
                a(aVar2, 0, 0);
                break;
            case 7:
                a(aVar2);
                cVar = (c) this.ly[1].get(TAG_MAKER_NOTE);
                if (cVar != null) {
                    a aVar3 = new a(cVar.lR);
                    aVar3.lO = this.lz;
                    byte[] bArr2 = new byte[kT.length];
                    aVar3.readFully(bArr2);
                    aVar3.seek(0);
                    byte[] bArr3 = new byte[kU.length];
                    aVar3.readFully(bArr3);
                    if (Arrays.equals(bArr2, kT)) {
                        aVar3.seek(8);
                    } else if (Arrays.equals(bArr3, kU)) {
                        aVar3.seek(12);
                    }
                    b(aVar3, 6);
                    cVar = (c) this.ly[7].get(TAG_ORF_PREVIEW_IMAGE_START);
                    cVar2 = (c) this.ly[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
                    if (!(cVar == null || cVar2 == null)) {
                        this.ly[5].put(TAG_JPEG_INTERCHANGE_FORMAT, cVar);
                        this.ly[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, cVar2);
                    }
                    cVar = (c) this.ly[8].get(TAG_ORF_ASPECT_FRAME);
                    if (cVar != null) {
                        iArr = (int[]) cVar.a(this.lz);
                        if (iArr != null && iArr.length == 4) {
                            if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                                i2 = (iArr[2] - iArr[0]) + 1;
                                i = (iArr[3] - iArr[1]) + 1;
                                if (i2 < i) {
                                    i2 += i;
                                    i = i2 - i;
                                    i2 -= i;
                                }
                                cVar2 = c.a(i2, this.lz);
                                cVar = c.a(i, this.lz);
                                this.ly[0].put(TAG_IMAGE_WIDTH, cVar2);
                                this.ly[0].put(TAG_IMAGE_LENGTH, cVar);
                                break;
                            }
                        }
                        new StringBuilder("Invalid aspect frame values. frame=").append(Arrays.toString(iArr));
                        break;
                    }
                }
                break;
            case 9:
                b(aVar2);
                break;
            case 10:
                a(aVar2);
                if (((c) this.ly[0].get(TAG_RW2_JPG_FROM_RAW)) != null) {
                    a(aVar2, this.lJ, 5);
                }
                cVar = (c) this.ly[0].get(TAG_RW2_ISO);
                cVar2 = (c) this.ly[1].get(TAG_ISO_SPEED_RATINGS);
                if (cVar != null && cVar2 == null) {
                    this.ly[1].put(TAG_ISO_SPEED_RATINGS, cVar);
                    break;
                }
        }
        HashMap hashMap = this.ly[4];
        cVar = (c) hashMap.get(TAG_COMPRESSION);
        if (cVar != null) {
            this.lE = cVar.b(this.lz);
            switch (this.lE) {
                case 1:
                case 7:
                    cVar = (c) hashMap.get(TAG_BITS_PER_SAMPLE);
                    if (cVar != null) {
                        iArr = (int[]) cVar.a(this.lz);
                        if (Arrays.equals(kZ, iArr)) {
                            obj = 1;
                        } else if (this.lx == 3) {
                            cVar2 = (c) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION);
                            if (cVar2 != null) {
                                i2 = cVar2.b(this.lz);
                                if ((i2 == 1 && Arrays.equals(iArr, lb)) || (i2 == 6 && Arrays.equals(iArr, kZ))) {
                                    i = 1;
                                }
                            }
                        }
                        if (obj != null) {
                            b(aVar2, hashMap);
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        b(aVar2, hashMap);
                        break;
                    }
                    break;
                case 6:
                    a(aVar2, hashMap);
                    break;
            }
        }
        this.lE = 6;
        a(aVar2, hashMap);
        this.lK = true;
    }

    public final void saveAttributes() {
        Closeable fileInputStream;
        Closeable fileOutputStream;
        Throwable th;
        if (!this.lK || this.lx != 4) {
            throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
        } else if (this.lv == null) {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        } else {
            byte[] thumbnailBytes = (this.lE == 6 || this.lE == 7) ? getThumbnailBytes() : null;
            this.lD = thumbnailBytes;
            File file = new File(this.lv + ".tmp");
            if (new File(this.lv).renameTo(file)) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(this.lv);
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                        b(fileInputStream);
                        b(fileOutputStream);
                        file.delete();
                        throw th;
                    }
                    try {
                        b((InputStream) fileInputStream, (OutputStream) fileOutputStream);
                        b(fileInputStream);
                        b(fileOutputStream);
                        file.delete();
                        this.lD = null;
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        b(fileInputStream);
                        b(fileOutputStream);
                        file.delete();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    fileInputStream = null;
                    b(fileInputStream);
                    b(fileOutputStream);
                    file.delete();
                    throw th;
                }
            }
            throw new IOException("Could not rename to " + file.getAbsolutePath());
        }
    }

    private byte[] getThumbnailBytes() {
        Closeable closeable;
        Throwable th;
        if (!this.lA) {
            return null;
        }
        if (this.lD != null) {
            return this.lD;
        }
        Closeable closeable2;
        try {
            if (this.lw != null) {
                closeable2 = this.lw;
                try {
                    if (closeable2.markSupported()) {
                        closeable2.reset();
                        closeable = closeable2;
                    } else {
                        b(closeable2);
                        return null;
                    }
                } catch (IOException e) {
                    b(closeable2);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = closeable2;
                    b(closeable);
                    throw th;
                }
            }
            closeable = this.lv != null ? new FileInputStream(this.lv) : null;
            if (closeable == null) {
                try {
                    throw new FileNotFoundException();
                } catch (IOException e2) {
                    closeable2 = closeable;
                    b(closeable2);
                    return null;
                } catch (Throwable th22) {
                    th = th22;
                    b(closeable);
                    throw th;
                }
            } else if (closeable.skip((long) this.lB) != ((long) this.lB)) {
                throw new IOException("Corrupted image");
            } else {
                byte[] bArr = new byte[this.lC];
                if (closeable.read(bArr) != this.lC) {
                    throw new IOException("Corrupted image");
                }
                this.lD = bArr;
                b(closeable);
                return bArr;
            }
        } catch (IOException e3) {
            closeable2 = null;
            b(closeable2);
            return null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            b(closeable);
            throw th;
        }
    }

    private static boolean e(byte[] bArr) {
        for (int i = 0; i < kS.length; i++) {
            if (bArr[i] != kS[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean f(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    private void a(a aVar, int i, int i2) {
        aVar.lO = ByteOrder.BIG_ENDIAN;
        aVar.seek((long) i);
        byte readByte = aVar.readByte();
        if (readByte != (byte) -1) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        int i3 = i + 1;
        if (aVar.readByte() != (byte) -40) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        int i4 = i3 + 1;
        while (true) {
            byte readByte2 = aVar.readByte();
            if (readByte2 != (byte) -1) {
                throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & 255));
            }
            i4++;
            byte readByte3 = aVar.readByte();
            i3 = i4 + 1;
            if (readByte3 == (byte) -39 || readByte3 == (byte) -38) {
                aVar.lO = this.lz;
            } else {
                i4 = aVar.readUnsignedShort() - 2;
                i3 += 2;
                if (i4 < 0) {
                    throw new IOException("Invalid length");
                }
                byte[] bArr;
                switch (readByte3) {
                    case (byte) -64:
                    case (byte) -63:
                    case (byte) -62:
                    case (byte) -61:
                    case (byte) -59:
                    case (byte) -58:
                    case (byte) -57:
                    case (byte) -55:
                    case (byte) -54:
                    case (byte) -53:
                    case (byte) -51:
                    case (byte) -50:
                    case (byte) -49:
                        if (aVar.skipBytes(1) == 1) {
                            this.ly[i2].put(TAG_IMAGE_LENGTH, c.a((long) aVar.readUnsignedShort(), this.lz));
                            this.ly[i2].put(TAG_IMAGE_WIDTH, c.a((long) aVar.readUnsignedShort(), this.lz));
                            i4 -= 5;
                            break;
                        }
                        throw new IOException("Invalid SOFx");
                    case (byte) -31:
                        if (i4 >= 6) {
                            bArr = new byte[6];
                            if (aVar.read(bArr) == 6) {
                                i3 += 6;
                                i4 -= 6;
                                if (Arrays.equals(bArr, lu)) {
                                    if (i4 > 0) {
                                        this.lF = i3;
                                        bArr = new byte[i4];
                                        if (aVar.read(bArr) == i4) {
                                            i3 += i4;
                                            a aVar2 = new a(bArr);
                                            a(aVar2, bArr.length);
                                            b(aVar2, i2);
                                            i4 = 0;
                                            break;
                                        }
                                        throw new IOException("Invalid exif");
                                    }
                                    throw new IOException("Invalid exif");
                                }
                            }
                            throw new IOException("Invalid exif");
                        }
                        break;
                    case (byte) -2:
                        bArr = new byte[i4];
                        if (aVar.read(bArr) == i4) {
                            if (getAttribute(TAG_USER_COMMENT) != null) {
                                i4 = 0;
                                break;
                            }
                            this.ly[1].put(TAG_USER_COMMENT, c.E(new String(bArr, lt)));
                            i4 = 0;
                            break;
                        }
                        throw new IOException("Invalid exif");
                }
                if (i4 < 0) {
                    throw new IOException("Invalid length");
                } else if (aVar.skipBytes(i4) != i4) {
                    throw new IOException("Invalid JPEG segment");
                } else {
                    i4 += i3;
                }
            }
        }
        aVar.lO = this.lz;
    }

    private void a(a aVar) {
        a(aVar, aVar.available());
        b(aVar, 0);
        d(aVar, 0);
        d(aVar, 5);
        d(aVar, 4);
        k(0, 5);
        k(0, 4);
        k(5, 4);
        c cVar = (c) this.ly[1].get(TAG_PIXEL_X_DIMENSION);
        c cVar2 = (c) this.ly[1].get(TAG_PIXEL_Y_DIMENSION);
        if (!(cVar == null || cVar2 == null)) {
            this.ly[0].put(TAG_IMAGE_WIDTH, cVar);
            this.ly[0].put(TAG_IMAGE_LENGTH, cVar2);
        }
        if (this.ly[4].isEmpty() && h(this.ly[5])) {
            this.ly[4] = this.ly[5];
            this.ly[5] = new HashMap();
        }
        h(this.ly[4]);
        if (this.lx == 8) {
            cVar = (c) this.ly[1].get(TAG_MAKER_NOTE);
            if (cVar != null) {
                a aVar2 = new a(cVar.lR);
                aVar2.lO = this.lz;
                aVar2.seek(6);
                b(aVar2, 9);
                cVar = (c) this.ly[9].get(TAG_COLOR_SPACE);
                if (cVar != null) {
                    this.ly[1].put(TAG_COLOR_SPACE, cVar);
                }
            }
        }
    }

    private void b(a aVar) {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        a(aVar, i, 5);
        aVar.seek((long) i2);
        aVar.lO = ByteOrder.BIG_ENDIAN;
        i2 = aVar.readInt();
        for (i = 0; i < i2; i++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                c a = c.a(readShort, this.lz);
                c a2 = c.a(readShort2, this.lz);
                this.ly[0].put(TAG_IMAGE_LENGTH, a);
                this.ly[0].put(TAG_IMAGE_WIDTH, a2);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    private void b(InputStream inputStream, OutputStream outputStream) {
        InputStream dataInputStream = new DataInputStream(inputStream);
        OutputStream bVar = new b(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() != (byte) -1) {
            throw new IOException("Invalid marker");
        }
        bVar.writeByte(-1);
        if (dataInputStream.readByte() != (byte) -40) {
            throw new IOException("Invalid marker");
        }
        bVar.writeByte(-40);
        bVar.writeByte(-1);
        bVar.writeByte(-31);
        a((b) bVar);
        byte[] bArr = new byte[GLIcon.LEFT];
        while (dataInputStream.readByte() == (byte) -1) {
            byte readByte = dataInputStream.readByte();
            int readUnsignedShort;
            int read;
            switch (readByte) {
                case (byte) -39:
                case (byte) -38:
                    bVar.writeByte(-1);
                    bVar.writeByte(readByte);
                    c(dataInputStream, bVar);
                    return;
                case (byte) -31:
                    readUnsignedShort = dataInputStream.readUnsignedShort() - 2;
                    if (readUnsignedShort >= 0) {
                        byte[] bArr2 = new byte[6];
                        if (readUnsignedShort >= 6) {
                            if (dataInputStream.read(bArr2) == 6) {
                                if (Arrays.equals(bArr2, lu)) {
                                    if (dataInputStream.skipBytes(readUnsignedShort - 6) == readUnsignedShort - 6) {
                                        break;
                                    }
                                    throw new IOException("Invalid length");
                                }
                            }
                            throw new IOException("Invalid exif");
                        }
                        bVar.writeByte(-1);
                        bVar.writeByte(readByte);
                        bVar.writeShort((short) (readUnsignedShort + 2));
                        if (readUnsignedShort >= 6) {
                            readUnsignedShort -= 6;
                            bVar.write(bArr2);
                        }
                        while (readUnsignedShort > 0) {
                            read = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort, GLIcon.LEFT));
                            if (read < 0) {
                                break;
                            }
                            bVar.write(bArr, 0, read);
                            readUnsignedShort -= read;
                        }
                        break;
                    }
                    throw new IOException("Invalid length");
                default:
                    bVar.writeByte(-1);
                    bVar.writeByte(readByte);
                    readUnsignedShort = dataInputStream.readUnsignedShort();
                    bVar.writeShort((short) readUnsignedShort);
                    readUnsignedShort -= 2;
                    if (readUnsignedShort >= 0) {
                        while (readUnsignedShort > 0) {
                            read = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort, GLIcon.LEFT));
                            if (read < 0) {
                                break;
                            }
                            bVar.write(bArr, 0, read);
                            readUnsignedShort -= read;
                        }
                        break;
                    }
                    throw new IOException("Invalid length");
            }
        }
        throw new IOException("Invalid marker");
    }

    private void aV() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null) {
            this.ly[0].put(TAG_DATETIME, c.E(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.ly[0].put(TAG_IMAGE_WIDTH, c.a(0, this.lz));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.ly[0].put(TAG_IMAGE_LENGTH, c.a(0, this.lz));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.ly[0].put(TAG_ORIENTATION, c.a(0, this.lz));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.ly[1].put(TAG_LIGHT_SOURCE, c.a(0, this.lz));
        }
    }

    private static ByteOrder c(a aVar) {
        short readShort = aVar.readShort();
        switch (readShort) {
            case (short) 18761:
                return ByteOrder.LITTLE_ENDIAN;
            case (short) 19789:
                return ByteOrder.BIG_ENDIAN;
            default:
                throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void a(a aVar, int i) {
        this.lz = c(aVar);
        aVar.lO = this.lz;
        int readUnsignedShort = aVar.readUnsignedShort();
        if (this.lx == 7 || this.lx == 10 || readUnsignedShort == 42) {
            readUnsignedShort = aVar.readInt();
            if (readUnsignedShort < 8 || readUnsignedShort >= i) {
                throw new IOException("Invalid first Ifd offset: " + readUnsignedShort);
            }
            readUnsignedShort -= 8;
            if (readUnsignedShort > 0 && aVar.skipBytes(readUnsignedShort) != readUnsignedShort) {
                throw new IOException("Couldn't jump to first Ifd: " + readUnsignedShort);
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private void b(a aVar, int i) {
        while (a.d(aVar) + 2 <= a.e(aVar)) {
            short readShort = aVar.readShort();
            if (a.d(aVar) + (readShort * 12) <= a.e(aVar)) {
                for (short s = (short) 0; s < readShort; s = (short) (s + 1)) {
                    int readUnsignedShort = aVar.readUnsignedShort();
                    int readUnsignedShort2 = aVar.readUnsignedShort();
                    int readInt = aVar.readInt();
                    long j = (long) (aVar.mPosition + 4);
                    d dVar = (d) lp[i].get(Integer.valueOf(readUnsignedShort));
                    long j2 = 0;
                    Object obj = null;
                    if (dVar != null && readUnsignedShort2 > 0 && readUnsignedShort2 < kX.length) {
                        j2 = ((long) readInt) * ((long) kX[readUnsignedShort2]);
                        if (j2 >= 0 && j2 <= 2147483647L) {
                            obj = 1;
                        }
                    }
                    if (obj == null) {
                        aVar.seek(j);
                    } else {
                        if (j2 > 4) {
                            int readInt2 = aVar.readInt();
                            if (this.lx == 7) {
                                if (TAG_MAKER_NOTE.equals(dVar.name)) {
                                    this.lG = readInt2;
                                } else if (i == 6 && TAG_ORF_THUMBNAIL_IMAGE.equals(dVar.name)) {
                                    this.lH = readInt2;
                                    this.lI = readInt;
                                    c a = c.a(6, this.lz);
                                    c a2 = c.a((long) this.lH, this.lz);
                                    c a3 = c.a((long) this.lI, this.lz);
                                    this.ly[4].put(TAG_COMPRESSION, a);
                                    this.ly[4].put(TAG_JPEG_INTERCHANGE_FORMAT, a2);
                                    this.ly[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, a3);
                                }
                            } else if (this.lx == 10 && TAG_RW2_JPG_FROM_RAW.equals(dVar.name)) {
                                this.lJ = readInt2;
                            }
                            if (((long) readInt2) + j2 <= ((long) a.e(aVar))) {
                                aVar.seek((long) readInt2);
                            } else {
                                aVar.seek(j);
                            }
                        }
                        obj = ls.get(Integer.valueOf(readUnsignedShort));
                        if (obj != null) {
                            j2 = -1;
                            switch (readUnsignedShort2) {
                                case 3:
                                    j2 = (long) aVar.readUnsignedShort();
                                    break;
                                case 4:
                                    j2 = aVar.ba();
                                    break;
                                case 8:
                                    j2 = (long) aVar.readShort();
                                    break;
                                case 9:
                                case 13:
                                    j2 = (long) aVar.readInt();
                                    break;
                            }
                            if (j2 > 0 && j2 < ((long) a.e(aVar))) {
                                aVar.seek(j2);
                                b(aVar, ((Integer) obj).intValue());
                            }
                            aVar.seek(j);
                        } else {
                            byte[] bArr = new byte[((int) j2)];
                            aVar.readFully(bArr);
                            c cVar = new c(readUnsignedShort2, readInt, bArr, (byte) 0);
                            this.ly[i].put(dVar.name, cVar);
                            if (TAG_DNG_VERSION.equals(dVar.name)) {
                                this.lx = 3;
                            }
                            if (((TAG_MAKE.equals(dVar.name) || TAG_MODEL.equals(dVar.name)) && cVar.c(this.lz).contains("PENTAX")) || (TAG_COMPRESSION.equals(dVar.name) && cVar.b(this.lz) == 65535)) {
                                this.lx = 8;
                            }
                            if (((long) aVar.mPosition) != j) {
                                aVar.seek(j);
                            }
                        }
                    }
                }
                if (aVar.mPosition + 4 <= a.e(aVar)) {
                    int readInt3 = aVar.readInt();
                    if (readInt3 > 8 && readInt3 < a.e(aVar)) {
                        aVar.seek((long) readInt3);
                        if (this.ly[4].isEmpty()) {
                            i = 4;
                        } else if (this.ly[5].isEmpty()) {
                            i = 5;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
    }

    private void c(a aVar, int i) {
        c cVar = (c) this.ly[i].get(TAG_IMAGE_WIDTH);
        if (((c) this.ly[i].get(TAG_IMAGE_LENGTH)) == null || cVar == null) {
            c cVar2 = (c) this.ly[i].get(TAG_JPEG_INTERCHANGE_FORMAT);
            if (cVar2 != null) {
                a(aVar, cVar2.b(this.lz), i);
            }
        }
    }

    private void a(a aVar, HashMap hashMap) {
        c cVar = (c) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        c cVar2 = (c) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (cVar != null && cVar2 != null) {
            int b = cVar.b(this.lz);
            int min = Math.min(cVar2.b(this.lz), aVar.available() - b);
            if (this.lx == 4 || this.lx == 9 || this.lx == 10) {
                b += this.lF;
            } else if (this.lx == 7) {
                b += this.lG;
            }
            if (b > 0 && min > 0) {
                this.lA = true;
                this.lB = b;
                this.lC = min;
                if (this.lv == null && this.lw == null) {
                    byte[] bArr = new byte[min];
                    aVar.seek((long) b);
                    aVar.readFully(bArr);
                    this.lD = bArr;
                }
            }
        }
    }

    private void b(a aVar, HashMap hashMap) {
        c cVar = (c) hashMap.get(TAG_STRIP_OFFSETS);
        c cVar2 = (c) hashMap.get(TAG_STRIP_BYTE_COUNTS);
        if (cVar != null && cVar2 != null) {
            long[] d = d(cVar.a(this.lz));
            long[] d2 = d(cVar2.a(this.lz));
            if (d != null && d2 != null) {
                long j = 0;
                for (long j2 : d2) {
                    j += j2;
                }
                Object obj = new byte[((int) j)];
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < d.length; i3++) {
                    int i4 = (int) d2[i3];
                    int i5 = ((int) d[i3]) - i2;
                    aVar.seek((long) i5);
                    i2 += i5;
                    Object obj2 = new byte[i4];
                    aVar.read(obj2);
                    i2 += i4;
                    System.arraycopy(obj2, 0, obj, i, obj2.length);
                    i += obj2.length;
                }
                this.lA = true;
                this.lD = obj;
                this.lC = obj.length;
            }
        }
    }

    private boolean h(HashMap hashMap) {
        c cVar = (c) hashMap.get(TAG_IMAGE_LENGTH);
        c cVar2 = (c) hashMap.get(TAG_IMAGE_WIDTH);
        if (!(cVar == null || cVar2 == null)) {
            int b = cVar.b(this.lz);
            int b2 = cVar2.b(this.lz);
            if (b <= 512 && b2 <= 512) {
                return true;
            }
        }
        return false;
    }

    private void d(a aVar, int i) {
        c cVar = (c) this.ly[i].get(TAG_DEFAULT_CROP_SIZE);
        c cVar2 = (c) this.ly[i].get(TAG_RW2_SENSOR_TOP_BORDER);
        c cVar3 = (c) this.ly[i].get(TAG_RW2_SENSOR_LEFT_BORDER);
        c cVar4 = (c) this.ly[i].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        c cVar5 = (c) this.ly[i].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (cVar != null) {
            Object a;
            Object a2;
            if (cVar.format == 5) {
                e[] eVarArr = (e[]) cVar.a(this.lz);
                if (eVarArr == null || eVarArr.length != 2) {
                    new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(eVarArr));
                    return;
                } else {
                    a = c.a(eVarArr[0], this.lz);
                    a2 = c.a(eVarArr[1], this.lz);
                }
            } else {
                int[] iArr = (int[]) cVar.a(this.lz);
                if (iArr == null || iArr.length != 2) {
                    new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(iArr));
                    return;
                } else {
                    a = c.a(iArr[0], this.lz);
                    a2 = c.a(iArr[1], this.lz);
                }
            }
            this.ly[i].put(TAG_IMAGE_WIDTH, a);
            this.ly[i].put(TAG_IMAGE_LENGTH, a2);
        } else if (cVar2 == null || cVar3 == null || cVar4 == null || cVar5 == null) {
            c(aVar, i);
        } else {
            int b = cVar2.b(this.lz);
            int b2 = cVar4.b(this.lz);
            int b3 = cVar5.b(this.lz);
            int b4 = cVar3.b(this.lz);
            if (b2 > b && b3 > b4) {
                b = b2 - b;
                b2 = b3 - b4;
                cVar = c.a(b, this.lz);
                cVar2 = c.a(b2, this.lz);
                this.ly[i].put(TAG_IMAGE_LENGTH, cVar);
                this.ly[i].put(TAG_IMAGE_WIDTH, cVar2);
            }
        }
    }

    private int a(b bVar) {
        int size;
        int i;
        int i2;
        Entry entry;
        int[] iArr = new int[ll.length];
        int[] iArr2 = new int[ll.length];
        for (d dVar : lm) {
            removeAttribute(dVar.name);
        }
        removeAttribute(ln.name);
        removeAttribute(lo.name);
        for (i2 = 0; i2 < ll.length; i2++) {
            for (Object obj : this.ly[i2].entrySet().toArray()) {
                entry = (Entry) obj;
                if (entry.getValue() == null) {
                    this.ly[i2].remove(entry.getKey());
                }
            }
        }
        if (!this.ly[1].isEmpty()) {
            this.ly[0].put(lm[1].name, c.a(0, this.lz));
        }
        if (!this.ly[2].isEmpty()) {
            this.ly[0].put(lm[2].name, c.a(0, this.lz));
        }
        if (!this.ly[3].isEmpty()) {
            this.ly[1].put(lm[3].name, c.a(0, this.lz));
        }
        if (this.lA) {
            this.ly[4].put(ln.name, c.a(0, this.lz));
            this.ly[4].put(lo.name, c.a((long) this.lC, this.lz));
        }
        for (i = 0; i < ll.length; i++) {
            i2 = 0;
            for (Entry entry2 : this.ly[i].entrySet()) {
                size = ((c) entry2.getValue()).size();
                if (size > 4) {
                    size += i2;
                } else {
                    size = i2;
                }
                i2 = size;
            }
            iArr2[i] = iArr2[i] + i2;
        }
        i2 = 8;
        for (size = 0; size < ll.length; size++) {
            if (!this.ly[size].isEmpty()) {
                iArr[size] = i2;
                i2 += (((this.ly[size].size() * 12) + 2) + 4) + iArr2[size];
            }
        }
        if (this.lA) {
            this.ly[4].put(ln.name, c.a((long) i2, this.lz));
            this.lB = i2 + 6;
            i2 += this.lC;
        }
        int i3 = i2 + 8;
        if (!this.ly[1].isEmpty()) {
            this.ly[0].put(lm[1].name, c.a((long) iArr[1], this.lz));
        }
        if (!this.ly[2].isEmpty()) {
            this.ly[0].put(lm[2].name, c.a((long) iArr[2], this.lz));
        }
        if (!this.ly[3].isEmpty()) {
            this.ly[1].put(lm[3].name, c.a((long) iArr[3], this.lz));
        }
        bVar.writeShort((short) i3);
        bVar.write(lu);
        bVar.writeShort(this.lz == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        bVar.lO = this.lz;
        bVar.writeShort((short) 42);
        bVar.writeInt(8);
        for (int i4 = 0; i4 < ll.length; i4++) {
            if (!this.ly[i4].isEmpty()) {
                c cVar;
                bVar.writeShort((short) this.ly[i4].size());
                size = ((iArr[i4] + 2) + (this.ly[i4].size() * 12)) + 4;
                i = size;
                for (Entry entry22 : this.ly[i4].entrySet()) {
                    int i5 = ((d) lq[i4].get(entry22.getKey())).number;
                    cVar = (c) entry22.getValue();
                    i2 = cVar.size();
                    bVar.writeShort((short) i5);
                    bVar.writeShort((short) cVar.format);
                    bVar.writeInt(cVar.lQ);
                    if (i2 > 4) {
                        bVar.writeInt((int) ((long) i));
                        i += i2;
                    } else {
                        bVar.write(cVar.lR);
                        if (i2 < 4) {
                            for (size = i2; size < 4; size++) {
                                bVar.writeByte(0);
                            }
                        }
                    }
                }
                if (i4 != 0 || this.ly[4].isEmpty()) {
                    bVar.writeInt(0);
                } else {
                    bVar.writeInt((int) ((long) iArr[4]));
                }
                for (Entry entry222 : this.ly[i4].entrySet()) {
                    cVar = (c) entry222.getValue();
                    if (cVar.lR.length > 4) {
                        bVar.write(cVar.lR, 0, cVar.lR.length);
                    }
                }
            }
        }
        if (this.lA) {
            bVar.write(getThumbnailBytes());
        }
        bVar.lO = ByteOrder.BIG_ENDIAN;
        return i3;
    }

    private static Pair<Integer, Integer> D(String str) {
        if (str.contains(",")) {
            String[] split = str.split(",");
            Pair<Integer, Integer> D = D(split[0]);
            if (((Integer) D.first).intValue() == 2) {
                return D;
            }
            int i = 1;
            while (i < split.length) {
                int intValue;
                int i2;
                Pair D2 = D(split[i]);
                if (((Integer) D2.first).equals(D.first) || ((Integer) D2.second).equals(D.first)) {
                    intValue = ((Integer) D.first).intValue();
                } else {
                    intValue = -1;
                }
                if (((Integer) D.second).intValue() == -1 || !(((Integer) D2.first).equals(D.second) || ((Integer) D2.second).equals(D.second))) {
                    i2 = -1;
                } else {
                    i2 = ((Integer) D.second).intValue();
                }
                if (intValue == -1 && i2 == -1) {
                    return new Pair(Integer.valueOf(2), Integer.valueOf(-1));
                }
                Pair<Integer, Integer> pair;
                if (intValue == -1) {
                    pair = new Pair(Integer.valueOf(i2), Integer.valueOf(-1));
                } else if (i2 == -1) {
                    pair = new Pair(Integer.valueOf(intValue), Integer.valueOf(-1));
                } else {
                    pair = D;
                }
                i++;
                D = pair;
            }
            return D;
        } else if (str.contains("/")) {
            String[] split2 = str.split("/");
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble < 0 || parseDouble2 < 0) {
                        return new Pair(Integer.valueOf(10), Integer.valueOf(-1));
                    }
                    if (parseDouble > 2147483647L || parseDouble2 > 2147483647L) {
                        return new Pair(Integer.valueOf(5), Integer.valueOf(-1));
                    }
                    return new Pair(Integer.valueOf(10), Integer.valueOf(5));
                } catch (NumberFormatException e) {
                }
            }
            return new Pair(Integer.valueOf(2), Integer.valueOf(-1));
        } else {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                if (valueOf.longValue() >= 0 && valueOf.longValue() <= 65535) {
                    return new Pair(Integer.valueOf(3), Integer.valueOf(4));
                }
                if (valueOf.longValue() < 0) {
                    return new Pair(Integer.valueOf(9), Integer.valueOf(-1));
                }
                return new Pair(Integer.valueOf(4), Integer.valueOf(-1));
            } catch (NumberFormatException e2) {
                try {
                    Double.parseDouble(str);
                    return new Pair(Integer.valueOf(12), Integer.valueOf(-1));
                } catch (NumberFormatException e3) {
                    return new Pair(Integer.valueOf(2), Integer.valueOf(-1));
                }
            }
        }
    }

    private void k(int i, int i2) {
        if (!this.ly[i].isEmpty() && !this.ly[i2].isEmpty()) {
            c cVar = (c) this.ly[i].get(TAG_IMAGE_LENGTH);
            c cVar2 = (c) this.ly[i].get(TAG_IMAGE_WIDTH);
            c cVar3 = (c) this.ly[i2].get(TAG_IMAGE_LENGTH);
            c cVar4 = (c) this.ly[i2].get(TAG_IMAGE_WIDTH);
            if (cVar != null && cVar2 != null && cVar3 != null && cVar4 != null) {
                int b = cVar.b(this.lz);
                int b2 = cVar2.b(this.lz);
                int b3 = cVar3.b(this.lz);
                int b4 = cVar4.b(this.lz);
                if (b < b3 && b2 < b4) {
                    HashMap hashMap = this.ly[i];
                    this.ly[i] = this.ly[i2];
                    this.ly[i2] = hashMap;
                }
            }
        }
    }

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    private static int c(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i;
            }
            i += read;
            outputStream.write(bArr, 0, read);
        }
    }

    private static long[] d(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = (long) iArr[i];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }
}
