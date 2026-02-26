import java.nio.charset.Charset;

public final class TextDecoders {
    private TextDecoders() {}

    // Equivalent to: new TextDecoder('gbk')
    public static final Charset DECODER_GBK = Charset.forName("GBK");

    // Equivalent to: decoder.decode(bytes)
    public static String decodeGBK(byte[] bytes) {
        return new String(bytes, DECODER_GBK);
    }
}
