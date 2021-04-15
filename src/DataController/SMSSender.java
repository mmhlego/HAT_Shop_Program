package DataController;

import java.util.Random;

public class SMSSender {
    private static String OTP;

    public static void SendSMS(String phone, String OTP) {
        createRandomOTP();
        MailSender.SendEmail("mmhlegoautosmssender@gmail.com", phone, OTP);
    }

    private static void createRandomOTP() {
        String temp = "";
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < 6; i++) {
            temp += Integer.toString(random.nextInt(10));
        }

        setOTP(temp);
    }

    public static boolean CheckkOTP(String input) {
        if (OTP.equals(input)) {
            return true;
        }
        return false;
    }

    public static String getOTP() {
        return OTP;
    }

    public static void setOTP(String oTP) {
        OTP = oTP;
    }
}
