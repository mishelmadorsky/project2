import java.util.Scanner;

public class ExNumber3 {

    public static final String FORMAT_1_2 = "05";
    public static final String FORMAT_3 = "9725";

    public static void main(String[] args) {
        String phoneNumber = getUserPhoneNumber();
        int format = checkFormat1(phoneNumber);
        String normalPhoneNumber = normalPhoneNumber(phoneNumber, format);
        System.out.println(normalPhoneNumber);

    }

    public static String getUserPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        String phone;
        String possible = "1234567890-";
        int count = 0;
        do {
            System.out.println("Enter your number : ");
            phone = scanner.nextLine();
            for (int i = 0; i < phone.length(); i++) {
                for (int j = 0; j < possible.length(); j++) {
                    if (phone.charAt(i) == possible.charAt(j)) {
                        count++;
                        break;
                    }
                }
            }
        }
        while (phone.length() != count);
        return phone;
    }

    public static int checkFormat1(String phoneNumber) {
        int format = 0;
        int count = 0;
        for (int i = 0; i < FORMAT_1_2.length(); i++) {
            if (phoneNumber.charAt(i) == FORMAT_1_2.charAt(i)) {
                count++;
                if (count == 2) {
                    if (phoneNumber.charAt(3) == '-' && phoneNumber.length() == 11) {
                        format = 1;
                    } else if (phoneNumber.length() == 10 && phoneNumber.charAt(3) != '-') {
                        format = 2;
                    }
                }
            }
        }
        if (format == 0) {
            count = 0;
            for (int i = 0; i < FORMAT_3.length(); i++) {
                if (phoneNumber.charAt(i) == FORMAT_3.charAt(i)) {
                    count++;
                    if (count == 4 && phoneNumber.length() == 12) {
                        format = 3;
                    }
                }
            }
        }
        return format;
    }

    public static String normalPhoneNumber(String phoneNumber, int format) {
        String normalPhoneNumber = "";
        switch (format) {
            case 0:
                normalPhoneNumber = normalPhoneNumber;
                break;
            case 1:
                normalPhoneNumber = phoneNumber;
                break;
            case 2:
                normalPhoneNumber += subString(0, 2, phoneNumber) + '-' + subString(3, 9, phoneNumber);
                break;
            case 3:
                normalPhoneNumber += '0' + subString(3, 4, phoneNumber) + '-' + subString(5, 11, phoneNumber);
                break;
        }
        return normalPhoneNumber;
    }

    public static String subString(int startIndex, int finishIndex, String userInput) {
        String newString = "";
        for (int i = startIndex; i <= finishIndex; i++) {
            newString += userInput.charAt(i);
        }
        return newString;
    }
}