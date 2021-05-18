package DataController;

import java.util.Random;

import Controller.UserController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SMSSender {
    private static String OTP;

    public static void SendSMS(String phone, String Text) {
        MailSender.SendEmail("mmhlegoautosmssender@gmail.com", phone, OTP);
        Alert(AlertType.INFORMATION, " رمز یکبار مصرف به شماره تلفن" + ProtectedPhone() + "ارسال شد");
    }

    private static String ProtectedPhone() {
        String phone = UserController.customer.Phone;

        return " " + phone.substring(7, 11) + "*****" + phone.substring(0, 2) + " ";
    }

    private static void Alert(AlertType AlertType, String Content) {
        Alert alert = new Alert(AlertType);
        alert.setHeaderText(null);
        alert.setContentText(Content);
        alert.show();
    }

    public static void SendOTP(String Phonenumber) {
        CreateRandomOTP();
        SendSMS(Phonenumber, "رمز یک بار مصرف شما : " + OTP);
    }

    private static void CreateRandomOTP() {
        String temp = "";
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < 6; i++) {
            temp += Integer.toString(random.nextInt(10));
        }

        SetOTP(temp);
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

    public static void SetOTP(String oTP) {
        OTP = oTP;
    }
}
