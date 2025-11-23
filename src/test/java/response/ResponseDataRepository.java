package response;

import java.util.List;

public class ResponseDataRepository {
    public static String email;
    public static String password;
    public static String token;
    public static List<ResponseContactCreatedMessage> responseMessages;

    //YENİ: Oluşturulan mesajı saklamak için
    public static ResponseContactCreatedMessage createdMessage;
}