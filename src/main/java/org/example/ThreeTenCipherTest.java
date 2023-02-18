package org.example;

/**
 * This is the main method to test EncryptDecrypt.java, ThreeTenCipher.java, NoTextException.java classes
 * @author Med
 */
public class ThreeTenCipherTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        char A[][] = new char[][] {
                {
                        'C',
                        'X',
                        'Q',
                        'Z',
                        'V',
                        'T',
                        'J',
                        'U',
                        'W',
                        'R',
                        'B',
                        'H',
                        'F',
                        'N',
                        'O',
                        'S',
                        'K',
                        'L',
                        'D',
                        'P',
                        'G',
                        'E',
                        'M',
                        'A',
                        'I',
                        'Y'
                }, {
                'P',
                'S',
                'O',
                'M',
                'F',
                'E',
                'T',
                'Q',
                'W',
                'A',
                'J',
                'V',
                'L',
                'D',
                'I',
                'H',
                'R',
                'C',
                'X',
                'B',
                'G',
                'N',
                'Z',
                'K',
                'Y',
                'U'
        }, {
                'A',
                'U',
                'B',
                'M',
                'K',
                'W',
                'R',
                'N',
                'S',
                'L',
                'F',
                'C',
                'T',
                'Z',
                'D',
                'X',
                'E',
                'J',
                'Q',
                'O',
                'V',
                'Y',
                'I',
                'G',
                'P',
                'H'
        }, {
                'G',
                'O',
                'Z',
                'T',
                'M',
                'R',
                'N',
                'K',
                'U',
                'H',
                'J',
                'X',
                'B',
                'V',
                'W',
                'C',
                'I',
                'Y',
                'L',
                'F',
                'S',
                'A',
                'E',
                'D',
                'Q',
                'P'
        }, {
                'W',
                'F',
                'Z',
                'Y',
                'H',
                'U',
                'I',
                'A',
                'B',
                'T',
                'D',
                'X',
                'R',
                'E',
                'C',
                'L',
                'Q',
                'O',
                'P',
                'K',
                'M',
                'J',
                'N',
                'S',
                'V',
                'G'
        }
        };
        String text1 = new String("Hello 310 students");
        ThreeTenCipher P1 = new ThreeTenCipher();
        EncryptDecrypt EncDec = new EncryptDecrypt();
        P1.setPlainText(text1);
        EncDec.setPlainTextSize(text1.length());
        P1.setKeys(A, text1.length());
        EncDec.encrypt();
        String text2 = EncDec.decrypt();
        if (text1.equals(text2))
            System.out.println("Yay");

        // create more testers for textArxhive of ThreeTenCipher
        String text3 = new String("Yes 1234 we are. new students");
        ThreeTenCipher P2 = new ThreeTenCipher();
        EncryptDecrypt EncDec2 = new EncryptDecrypt();
        P2.setPlainText(text3);
        EncDec2.setPlainTextSize(text3.length());
        P2.setKeys(A, text3.length());
        EncDec2.encrypt();
        String text4 = EncDec2.decrypt();
        if (text3.equals(text4))
            System.out.println("Yay2");

        String text5 = new String("Aaaaaaaaaaaaaaaaaaaaaaaaa bbbbbbbbbbb 123456 wwwwwwwwwwwwwzzzzzzzzzzz" +
                "cccccccccccccccccccccccccc eeeeeeeeeeeeee r r r r ppppppppppppppppppppp 45 wwwwwwwwwwwwwwwwwwwwdddddddddddddddw" +
                "33333333333333333333333333 rrrrrrrrrrrrrrrrrrrreaas eeeeeeeee gfgrrrrrrrrrrrrrrrrrrrrrrrrr" +
                "ddddddddddddddddddddddd");
        ThreeTenCipher P3 = new ThreeTenCipher();
        EncryptDecrypt EncDec3 = new EncryptDecrypt();
        P3.setPlainText(text5);
        EncDec3.setPlainTextSize(text5.length());
        P3.setKeys(A, text5.length());
        EncDec3.encrypt();
        String text6 = EncDec3.decrypt();
        if (text5.equals(text6))
            System.out.println("Yay3");

    }
}